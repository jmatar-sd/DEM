/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
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

public final class YahooMessageReader {

    /*
     * Yahoo Chat Sessions
     * contain list of conversation between 2 user
     * each YahooMessage represent one record in the chat (from, to , time, txt)
     */
    public static class YahooChatSession {
        public String userName ;
        public String otherName ;
        public String path ;
        public List<YahooMessage> messages = new ArrayList<YahooMessage>();
    }
    
    /*
     * Gel chat Session in yahoo file (.DAT file)
     *
     * @param path the path to yahoo chat file
     * @throws NullPointerException when path is null 
     * @return YahooChatSession contain  chat sessions in path
     */
    public YahooChatSession processFile(File path) throws IOException{
        String currentUserName = path.getParentFile().getParentFile().getParentFile().getParentFile().getName() ;
        String otherUserName   = path.getParentFile().getName();
        List<YahooMessage> msgs = getYahooMessages(path.getAbsolutePath(), currentUserName, otherUserName);
        
        YahooChatSession chat = new YahooChatSession();
        chat.messages.addAll(msgs);
        chat.userName = currentUserName;
        chat.otherName = otherUserName;
        chat.path = path.getAbsolutePath();
        
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
     private List<YahooMessage> getYahooMessages (String path, String profileName,
        String otherName ) throws IOException {

        DataInputStream input = new DataInputStream(new FileInputStream(new File(path)) );
        List<YahooMessage> msgs = new ArrayList<YahooMessage>();

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
                        profileName, otherName, timeStamp, unknown1, YahooMessage.MESSAGE_PATH.DEST_TO_SOURCE,
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
