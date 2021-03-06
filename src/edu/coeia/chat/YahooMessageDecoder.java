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

public final class YahooMessageDecoder {
    /*
     * decode yahoo chat message with the key
     * 
     * @param cipher is the cipher text
     * @parem key is encryption key
     * @return byte array contain the clear text
     */
    public static byte[] decode (final byte[] cipher, final String key) {
        assert ( key != null ) : "key must not be null value" ;
        
        final byte[] plain = new byte[cipher.length];

        for (int i=0 ; i<cipher.length ; i++){
            int cipherInt = cipher[i];
            int keyInt = key.charAt(i % key.length());
            int resultInt = cipherInt ^ keyInt ;

            plain[i] = (byte) resultInt ;
        }

        return plain ;
    }
}