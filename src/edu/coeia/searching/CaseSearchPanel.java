/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * CaseSearchPanel.java
 *
 * Created on Oct 22, 2011, 9:44:48 AM
 */
package edu.coeia.searching;

import edu.coeia.cases.Case;
import edu.coeia.items.Item;

import edu.coeia.main.CaseFrame;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.swing.JFrame;

/**
 *
 * @author wajdyessam
 */
public class CaseSearchPanel extends javax.swing.JPanel {

    private AdvancedSearchPanel  advancedSearchPanel;
    private ConnectedSearchPanel connectedSearchPanel;
    
    private final CaseFrame caseFrame ;
    private final Case aCase ;
    
    private List<SearchHistory> searchOptions = new ArrayList<SearchHistory>();
    
    /** Creates new form CaseSearchPanel */
    public CaseSearchPanel(final JFrame frame) {
        initComponents();
        
        this.caseFrame = (CaseFrame) frame;
        this.aCase =  this.caseFrame.getCase();
        
        // add tapped pane
        this.advancedSearchPanel = new AdvancedSearchPanel(this);
        this.connectedSearchPanel = new ConnectedSearchPanel(aCase, caseFrame, this);
        this.caseSearchTappedPane.add("Advanced Search", advancedSearchPanel);
        this.caseSearchTappedPane.add("Connected Search", connectedSearchPanel);
    }
    
    public Case getCurrentCase() { return this.aCase; }
    public JFrame getParentJFrame() { return this.caseFrame ; }
    
    public void setFocusInAdvancedSearchPanel () {
        this.advancedSearchPanel.setQueryTextFeildFocusable();
    }
    
    void addSearchOption(final SearchHistory option) {
        this.searchOptions.add(option);
        this.connectedSearchPanel.updateSavedSearchTable();
    }
    
    List<SearchHistory> getSearchOptions() {
        return Collections.unmodifiableList(this.searchOptions);
    }
    
    static class SearchHistory {
        public SearchHistory(final String query, final String time, final SearchScope scope, 
                final List<Item> docs) {
            
            this.query = query ;
            this.time = time;
            this.scope = scope;
            this.documents = new ArrayList<Item>();
            this.documents.addAll(Collections.unmodifiableList(docs));
        }
        
        String query;
        String time;
        SearchScope scope;
        
        List<Item> documents;
    }
    
    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        caseSearchTappedPane = new javax.swing.JTabbedPane();

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(caseSearchTappedPane, javax.swing.GroupLayout.DEFAULT_SIZE, 369, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(caseSearchTappedPane, javax.swing.GroupLayout.DEFAULT_SIZE, 93, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTabbedPane caseSearchTappedPane;
    // End of variables declaration//GEN-END:variables
}
