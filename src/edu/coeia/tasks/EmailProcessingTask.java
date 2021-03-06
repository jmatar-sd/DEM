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
package edu.coeia.tasks;

import edu.coeia.gutil.JTableUtil;
import edu.coeia.constants.IndexingConstant;
import edu.coeia.items.EmailItem;
import edu.coeia.items.ItemFactory;
import edu.coeia.offlinemail.EmailBrowsingPanel;
import edu.coeia.offlinemail.EmailBrowsingPanel.EMAIL_PROCESSING_TYPE;

import java.io.File;
import java.io.IOException;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.apache.lucene.document.Document;
import org.apache.lucene.document.Field;
import org.apache.lucene.index.IndexReader;
import org.apache.lucene.store.Directory;
import org.apache.lucene.store.FSDirectory;

/**
 *
 * @author wajdyessam
 */
public class EmailProcessingTask implements Task{
    private final BackgroundProgressDialog dialog ;
    private final EmailBrowsingPanel panel;
    private final EMAIL_PROCESSING_TYPE type; 
    
    public EmailProcessingTask(final EMAIL_PROCESSING_TYPE type, 
            final EmailBrowsingPanel panel) {
        
        this.dialog = new BackgroundProgressDialog(null, true, this);
        this.panel = panel;
        this.type = type;
    }
    
    @Override
    public void startTask() {
        this.dialog.startThread();
    }
    
    @Override
    public void doTask() throws Exception {
        this.loadEmail();
    }
    
    @Override
    public boolean isCancelledTask() {
        return this.dialog.isCancelledThread();
    }
    
    private void loadEmail() {
        if ( this.panel.isOfflineEmailSelected() ) {
            String relativePath = String.valueOf(this.panel.getList().getSelectedValue());
            this.getAllMessageInEmailSource(relativePath, IndexingConstant.OFFLINE_EMAIL_PATH);
        }
        else if ( this.panel.isOnlineEmailSelected() ) {
            String username = String.valueOf(this.panel.getList().getSelectedValue());
            this.getAllMessageInEmailSource(username, IndexingConstant.ONLINE_EMAIL_USER_NAME);
        }
    }
    
    private void getAllMessageInEmailSource(final String value, final String constant) {
        IndexReader indexReader = null;
        
        try {
            List<Integer> ids = new ArrayList<Integer>();
            
            Directory dir = FSDirectory.open(new File(this.panel.getCaseFacade().getCaseIndexFolderLocation()));
            indexReader = IndexReader.open(dir);
            Map<Entry, Integer> messageCounter = new HashMap<Entry, Integer>();
            
            for (int i=0; i<indexReader.maxDoc(); i++) {
                if ( this.isCancelledTask() ) {
                    break ;
                }
                         
                Document document = indexReader.document(i);
                
                if ( document != null ) {
                    Field field = document.getField(constant);
                    if ( field != null && field.stringValue() != null) {
                       String tmp = field.stringValue();
                       
                       if ( tmp.endsWith(value)) {
                            EmailItem item = (EmailItem) ItemFactory.newInstance(document, panel.getCaseFacade(), false);
                            
                            String to = "";
                            if ( item.getTo() == null || item.getTo().trim().isEmpty() )
                                to = value;
                            else
                                to = item.getTo();
                            
                            if ( checkingItemType(item) ) {
                                Entry entry = new Entry(item.getFrom(), to, item.getTime());
                                
                                Integer indexNo = messageCounter.get(entry);
                                
                                if ( indexNo == null ) {
                                    messageCounter.put(entry, 1);
                                }
                                else {
                                    messageCounter.put(entry, indexNo+1);
                                }

                                ids.add(Integer.valueOf(item.getDocumentId()));
                            }
                       }
                    }
                }
            }
            
            if ( this.type == EMAIL_PROCESSING_TYPE.INBOX || this.type == EMAIL_PROCESSING_TYPE.SEND_ITEM)
                addResultToTable(messageCounter);
            else
                addDateResultToTable(messageCounter);

            
            messageCounter.clear();
            messageCounter = null;
        } catch (IOException ex) {
            ex.printStackTrace();
            Logger.getLogger(EmailProcessingTask.class.getName()).log(Level.SEVERE, null, ex);
        }
        finally {
            try {
                indexReader.close();
            } catch (IOException ex) {
                Logger.getLogger(EmailProcessingTask.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    private void addResultToTable(final Map<Entry, Integer> messageCounter) {
        // add mapping to table
        for(Map.Entry<Entry, Integer> item: messageCounter.entrySet()) {
            if ( this.isCancelledTask() )
                break ;
            
            JTableUtil.addRowToJTable(this.panel.getEmailProcessingTable(), 
                new Object[] {item.getKey().getFrom(), item.getKey().getTo(),  item.getValue()});
        }
    }
    
    private void addDateResultToTable(final Map<Entry, Integer> messageCounter) {
        // add mapping to table
        for(Map.Entry<Entry, Integer> item: messageCounter.entrySet()) {
            if ( this.isCancelledTask() )
                break ;

            JTableUtil.addRowToJTable(this.panel.getEmailDateProcessingTable(), 
                new Object[] {item.getKey().getFrom(), item.getKey().getTo(), item.getKey().getDate(), item.getValue()});
        }
    }
        
    private boolean checkingItemType(final EmailItem item ) {
        String folderName = item.getFolder();
        
        if ( folderName.equalsIgnoreCase("inbox") && this.type == EMAIL_PROCESSING_TYPE.INBOX )
            return true;
        
        if ( folderName.startsWith("sen") || folderName.startsWith("Sen") && this.type == EMAIL_PROCESSING_TYPE.SEND_ITEM )
            return true;
        
        if ( this.type == EMAIL_PROCESSING_TYPE.FREQUENCY )
            return true;
        
        return false;
    }
    
    private class Entry {
        private final String from;
        private final String to;
        private final String date ;
        
        public Entry(final String from, final String to, final String date) {
            this.from = from;
            this.to = to;
            this.date = date;
        }
        
        public String getFrom() { return this.from ; }
        public String getTo() { return this.to ; }
        public String getDate() { return this.date; }
        
        @Override
        public boolean equals(Object object) {
            if ( object == null )
                return false;
            
            if ( this == object )
                return true;
            
            if ( ! (object instanceof Entry) )
                return false;
            
            Entry entry = (Entry) object;
            
            return entry.getFrom().equalsIgnoreCase(this.from) &&
                    entry.getTo().equalsIgnoreCase(this.to);
        }

        @Override
        public int hashCode() {
            int hash = 7;
            hash = 83 * hash + (this.from != null ? this.from.hashCode() : 0);
            hash = 83 * hash + (this.to != null ? this.to.hashCode() : 0);
            return hash;
        }
    }
}
