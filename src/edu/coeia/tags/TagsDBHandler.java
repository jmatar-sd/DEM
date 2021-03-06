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
 *
 * @author wajdyessam
 */

import static edu.coeia.util.PreconditionsChecker.* ;

import java.util.ArrayList;
import java.util.List;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.PreparedStatement;

public final class TagsDBHandler {
    
    public TagsDBHandler(final String databasePath, final boolean createNewDatabase) throws ClassNotFoundException,
            InstantiationException, SQLException, IllegalAccessException {
        
        checkNull("Location Mush have a value", databasePath);
        checkNotEmptyString("location must be not empty string", databasePath);
        
        DB_URL = DB_NAME + databasePath;
        
        if ( createNewDatabase ) {
            this.connection = this.getConnection();
            makeDBStructure();
            this.closeConnection();
        }
        else {
            this.connection = this.getConnection();
        }
    }
    
    /**
     * Get all Tags from case database
     * @return 
     */
    public List<Tag> readTagsFromDataBase() throws SQLException {
        List<Tag> tags = new ArrayList<Tag>();
        
        String select = "SELECT * FROM case_tags";
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(select);

        while ( resultSet.next() ) {
            tags.add(Tag.newInstance(resultSet.getString(1), resultSet.getTimestamp(2), 
                    resultSet.getString(3)));
        }
        
        return tags;
    }
    
    /**
     * Write New Tags to database
     * Remove database records and then add the new tags
     * @param tags 
     */
    public boolean writeTagsToDatabase(final List<Tag> tags) throws Exception {
        boolean status = false; 
        
        this.removeTagRecords();

        for(Tag tag: tags) {
            this.insertTagRecord(tag);
        }

        status = true;
        
        return (status);
    }

    /**
     * Write Tag to database 
     * @param tag
     * @throws SQLException 
     */
     private boolean insertTagRecord(final Tag tag)
            throws Exception {
        
        String s = "INSERT into case_tags values(?,?,?)";
        PreparedStatement psInsert = connection.prepareStatement(s);
        
        psInsert.setString(1, tag.getName());
        psInsert.setTimestamp(2, new java.sql.Timestamp(tag.getDate().getTime()));
        psInsert.setString(3, tag.getMessage());
        
        int ret = psInsert.executeUpdate();
        psInsert.close();

        return ret > 0 ;
    }

     /**
      * Remove Records from DataBase
      * @throws SQLException 
      */
    private void removeTagRecords() throws Exception{
        String command = "DELETE FROM case_tags";
        PreparedStatement update = connection.prepareStatement(command);
        update.executeUpdate();
        update.close();
    }
    
    public void closeConnection() throws SQLException {
        connection.close();
    }

    private void makeDBStructure() throws ClassNotFoundException,
            InstantiationException, SQLException, IllegalAccessException  {
        Statement statement = connection.createStatement();

        String tagsTable =
                "CREATE TABLE case_tags ("
                + "NAME VARCHAR(1024), "
                + "WHEN_TIME TIMESTAMP,"
                + "CONTENT VARCHAR(2048)"
                + ")";

        statement.execute(tagsTable);
        statement.close();
    }
    
    private Connection getConnection() throws ClassNotFoundException, InstantiationException,
            SQLException, IllegalAccessException {
        Class.forName(DB_DRIVER).newInstance();
        return DriverManager.getConnection(DB_URL, DB_USER, DB_PASS);
    }
    
    private String DB_URL;
    private Connection connection;
    private static final String DB_NAME = "jdbc:sqlite:" ;
    private static final String DB_DRIVER = "org.sqlite.JDBC";
    private static final String DB_USER = "";
    private static final String DB_PASS = "";
}
