/* 
 * Copyright (C) 2014 Center of Excellence in Information Assurance
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package edu.coeia.chat;

/**
 *
 * @author wajdyessam
 */

import edu.coeia.util.Utilities;

import java.io.File ;
import java.io.FileInputStream ;
import java.io.DataInputStream ;
import java.io.IOException ;
import java.io.EOFException ;

import java.util.Date ;
import java.util.ArrayList ;
import java.util.List;

public final class YahooChatReader implements ChatReader {
    
    /*
     * Get chat Session in yahoo file (.DAT file)
     *
     * @param path the path to yahoo chat file
     * @throws NullPointerException when path is null 
     * @return YahooChatSession contain  chat sessions in path
     */
    @Override
    public ChatSession processFile(final File path) throws Exception{
        String currentUserName = path.getParentFile().getParentFile().getParentFile().getParentFile().getName() ;
        String otherUserName   = path.getParentFile().getName();
        List<ChatMessage> msgs = getYahooMessages(path.getAbsolutePath(), currentUserName, otherUserName);
        
        ChatSession chat = ChatSession.newInstance(currentUserName, otherUserName, path.getAbsolutePath(), msgs);
        return chat;
    }

    /*
     * Get all yahoo chat messages between profileName user and otherName user
     * 
     * @param path is the path to yahoo chat file .DAT file
     * @param profileName is the folder name for current account
     * @param otherName is subfolder of profileName that contain chat between current and other
     * @return List of YahooMesssage that contain yahoo messages
     * @throws IOException if the path/.DAT file is not found
     */
     private List<ChatMessage> getYahooMessages (String path, String profileName,
        String otherName ) throws IOException {

        DataInputStream input = new DataInputStream(new FileInputStream(new File(path)) );
        List<ChatMessage> msgs = new ArrayList<ChatMessage>();

        try {
            while ( true ) {
                Date timeStamp = new Date( 1000 * ( (long) Utilities.convertFromLEToBE(input.readInt()) ));
                int unknown1   = Utilities.convertFromLEToBE(input.readInt());
                int sendFlag   = Utilities.convertFromLEToBE(input.readInt());
                int msgLength  = Utilities.convertFromLEToBE(input.readInt());
                
                byte[] cipherText = new byte[msgLength];
                input.readFully(cipherText);
                
                int unknown2   = Utilities.convertFromLEToBE(input.readInt());

                YahooMessage yahooMsg = null ;
                if ( sendFlag == 0 ) {
                    yahooMsg = new YahooMessage(
                        profileName, otherName, timeStamp, unknown1, YahooMessage.MESSAGE_PATH.SOURCE_TO_DEST,
                        msgLength, cipherText, unknown2);
                }
                else {
                    yahooMsg = new YahooMessage(
                        otherName, profileName, timeStamp, unknown1, YahooMessage.MESSAGE_PATH.DEST_TO_SOURCE,
                        msgLength, cipherText, unknown2);
                }

                msgs.add( yahooMsg );
            }
        }
        catch (EOFException e) {
        }
        finally{
            input.close();
        }
        
        return msgs;
    }
}
