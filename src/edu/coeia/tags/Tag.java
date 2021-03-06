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
package edu.coeia.tags;

/**
 * Tag class
 * Represent Tag in DEM that contain creator name and the date of creation
 * and contain the message of this tags
 * 
 * @author wajdyessam
 */

import java.util.Date ;

public final class Tag {
    
    /**
     * static factory method
     * @param name the name tag creator
     * @param date the date of tag creation
     * @param msg the message for this tag
     * @return new Tag object
     */
    public static Tag newInstance(String name, Date date, String msg) {
        return new Tag(name, new Date(date.getTime()), msg);
    }
    
    /**
     * private constructor 
     */
    private Tag(String name, Date date, String msg) {
        this.creationDate = date; 
        this.creatorName = name ;
        this.message = msg;
    }
    
    /**
     * toString implementation, for debugging purpose
     * @return 
     */
    @Override
    public String toString() {
        return String.format("%s[name=%s, date=%s, message=%s]", this.getClass().getName(),
                this.getName(), this.getDate().toString(), this.getMessage());
    }
    
    /**
     * Logical Equality of two tags
     * @return 
     */
    @Override
    public boolean equals(Object obj) {
        if ( obj == this)
            return true;
        
        if ( ! (obj instanceof Tag) )
            return false;
        
        Tag tag = (Tag) obj ;
        return tag.creatorName.equals(this.creatorName) 
                && tag.creationDate.equals(this.creationDate)
                && tag.message.equals(this.message) ;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 29 * hash + (this.creationDate != null ? this.creationDate.hashCode() : 0);
        hash = 29 * hash + (this.creatorName != null ? this.creatorName.hashCode() : 0);
        hash = 29 * hash + (this.message != null ? this.message.hashCode() : 0);
        return hash;
    }
    
    public String getName() { return this.creatorName ; }
    public String getMessage() { return this.message ; }
    public Date getDate() { return new Date(this.creationDate.getTime()) ; }
    
    private final Date creationDate ;
    private final String creatorName ;
    private final String message ;
}
