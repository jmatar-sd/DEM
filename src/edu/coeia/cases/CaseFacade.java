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
package edu.coeia.cases;

import edu.coeia.constants.ApplicationConstants;
import edu.coeia.constants.AuditingMessages;
import edu.coeia.tags.Tag;
import edu.coeia.util.FileUtil;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

/**
 * Case Facade hide all the detail of creating, opening, removing and updating
 * case also for importing and exporting case history
 * 
 * also hide the complexity of path mapping conversion between full
 * and relative path
 * 
 * @author wajdyessam
 */

public final class CaseFacade {
    private final Case aCase ;
    private final CaseHistoryHandler caseHistoryHandler;
    private final CasePathConfiguration casePathConfiguration; 
    private final CaseAuditing caseAuditing;
    private final CaseTags caseTags;
    
    /**
     * create case folder structures and save serialized case object
     * into .DAT file and handle the file path mapping
     * 
     * @param aCase
     * @return
     * @throws Exception 
     */
    public static CaseFacade newCase (final Case aCase) throws Exception {
        return new CaseFacade(aCase, true);
    }
        
    /**
     * open case resources like tagging database, auditing files
     * these resources should be closed after finishing with closeCase
     * 
     * @param aCase
     * @return
     * @throws Exception 
     */
    public static CaseFacade openCase(final Case aCase) throws Exception {
        return new CaseFacade(aCase, false);
    }
    
    /**
     * update case existing information 
     * by removing old file and write the new information file 
     * with the new information contained in the current instance
     * of Case object
     * 
     * and then update information file by replacing the case that
     * have the old path with the current information
     * 
     * @throws IOException 
     */
    public void updateCase(final String oldCaseName, final String oldCaseLocation) throws IOException {
        // update case information file .DAT
        FileUtil.createFile(this.getCaseInformationFileLocation()); 
        this.saveCaseInformation();
        
        // update cases database information file INDEXES.txt
        this.replaceOldCaseInformation(oldCaseName, oldCaseLocation);
    }
    
    /**
     *  Remove case information (case database .txt files )
     *  and remove the case history 
     * 
     *  update information file and also history
     *  the update will occur even if their is problems when deleting some files
     *  inside the case, so we can know that we read completed case
     *  and no exception occur during reading not-removed correctly case
     * 
     * @return the status of removing case history and pointer in db file
     * @throws Exception 
     */
    public boolean removeCase() throws Exception {
        // remove pointer first
        List<String> otherCasesGroup = this.getOtherCases(this.aCase.getCaseName(), this.getCaseFolderLocation());
        FileUtil.writeToFile(otherCasesGroup, getCasesInformationFileLocation());

        // remove history
        this.caseHistoryHandler.removeHistory(aCase.getCaseName());

        return true;
    }
    
    private void replaceOldCaseInformation(final String oldCaseName, final String oldCaseLocation) throws IOException {
        List<String> otherCasesGroup = this.getOtherCases(oldCaseName, oldCaseLocation);
        
        // new case information
        String newLine = aCase.getCaseName() + " - " + aCase.getCaseLocation();
        otherCasesGroup.add(newLine);
        
        // add to to indexes.text database information file
        FileUtil.writeToFile(otherCasesGroup, this.getCasesInformationFileLocation());
    }
        
    public void closeCase() {
        try {
            this.closeCaseAuditing();
            this.closeCaseTags();
        }
        catch(Exception e) {
            /** some cases after importing and cancel this operation
             * will not be in good state and the db files will not exists
             * so closing not exists file will make null pointer exception
             * here we ignore this
             */
        }
    }
    
    // Case History Simplified Methods
    public CaseHistory getCaseHistory() {
        return this.caseHistoryHandler.getHistory(this.aCase.getCaseName());
    }
    
    public void setCaseHistory(final CaseHistory history) {
        this.caseHistoryHandler.setHistory(history);
    }
    
    public void importHistory(final String fileName) throws Exception {
        this.caseHistoryHandler.importHistory(fileName);
    }
    
    public void exportHistory(final String caseName, final String filePath) throws Exception {
        this.caseHistoryHandler.exportHistory(caseName, filePath);
    }
    
    // Case File path mapping simplified methods
    public void updateMappingFile() throws IOException { 
        this.casePathConfiguration.reloadFileMapping();
    }
    
    public String getFullPath(final String relativePath) {
        return this.casePathConfiguration.getFullPath(relativePath);
    }
    
    public String getRelativePath(final String fullPath) {
        return this.casePathConfiguration.getRelativePath(fullPath);
    }
    
    public boolean isCaseHaveChangedSource() throws IOException {
        return !this.casePathConfiguration.getChangedEntries().isEmpty();
    }
    
    public void updateMapping(final String oldFullPath, final String newFullPath) throws IOException {
        String oldRelativePath = getRelativeMarkForPath(oldFullPath);
        CasePathConfiguration.PathMapping entry = new CasePathConfiguration.PathMapping(oldRelativePath, newFullPath);
        this.casePathConfiguration.updateFullPath(entry);
    }
    
    public List<String> getChangedEntries() throws IOException {
        List<CasePathConfiguration.PathMapping> mapping = this.casePathConfiguration.getChangedEntries();
        List<String> fullPaths = new ArrayList<String>();
        
        for(CasePathConfiguration.PathMapping pathMapping: mapping) {
            fullPaths.add(pathMapping.absolutePath);
        }
        
        return fullPaths;
    }
    
    private String getRelativeMarkForPath(final String fullPath) throws IOException{
        for(CasePathConfiguration.PathMapping entry: this.casePathConfiguration.getChangedEntries()) {
             String data = entry.absolutePath;
             String relative = entry.relativePath;
             
             if ( fullPath.equals(data) ) 
                 return relative;
        }
        
        return "";
    }
    
    private List<String> getOtherCases(final String name, final String path) throws FileNotFoundException {
        List<String> originalCases = FileUtil.getFileContentInList(new File(getCasesInformationFileLocation()));
        List<String> otherCases = new ArrayList<String>();

        for (String line: originalCases) {
            String otherCaseName = line.split("-")[0].trim();
            String otherCasePath = line.substring(line.indexOf("-") + 1).trim();

            if ( otherCaseName.equals(name) && otherCasePath.equals(path))
                continue ;

            otherCases.add(line);
        }
        
        return otherCases;
    }
        
    private void saveCaseInformation() throws IOException {
        FileUtil.writeObject(aCase, new File(this.getCaseInformationFileLocation()));
    }
    
    private void updateCasesInformationFile () throws IOException {
        PrintWriter writer = new PrintWriter(new FileWriter(new File(this.getCasesInformationFileLocation()), true));
        writer.println(aCase.getCaseName() + " - " + aCase.getCaseLocation());
        writer.close();
    }
        
    private void createCaseFoldersStructure () throws IOException {
        FileUtil.createFolder(this.getCaseFolderLocation());                 // CASE Parent Folder
        FileUtil.createFolder(this.getCaseIndexFolderLocation());            // INDEX folder
        FileUtil.createFolder(this.getCaseImageFolderLocation());            // IMAGE folder
        FileUtil.createFolder(this.getCaseArchiveOutputFolderLocation());    // ARCHIVE folder
        FileUtil.createFolder(this.getCaseOfflineEmailAttachmentLocation()); // OFFLINE Email Attachments
        FileUtil.createFolder(this.getCaseAuditingFolderLocation());         // AUDITING folder
        FileUtil.createFolder(this.getCaseRawReportFolderLocation());        // RAW FOLDER
        FileUtil.createFolder(this.getCaseReportFolderLocation());           // REPORTS FOLDER
        FileUtil.createFolder(this.getTagDatabaseFolderLocation());          // TAGS Folder
        
        FileUtil.createFile(this.getCaseAuditingFileLocation());        // CASE LOG
        FileUtil.createFile(this.getCaseInformationFileLocation());     // CASE-NAME.DAT
        FileUtil.createFile(this.getCaseConfigurationFileLocation());   // CONFIG.DAT
        FileUtil.createFile(this.getCasePreferenceFileLocation());      // CASE.PREF
        
        // initialize case auditing
        this.caseAuditing.init();
    }
    
    private void addCaseMappingInformation() throws IOException {
        for(String path: aCase.getEvidenceSourceLocation()) {
            this.casePathConfiguration.add(new File(path));
        }
        
        this.casePathConfiguration.saveConfiguration();
    }
        
    public void audit(final AuditingMessages message) {
        this.caseAuditing.auditing(message.toString());
    }
    
    
    /** Case Tagging **/
    public boolean isTagsDatabaseModified() {
        return this.caseTags.isTagsDbModified();
    }
    
    public void addTag(final Tag tag) {
        this.caseTags.addTag(tag);
    }
    
    public boolean saveTags() {
        return this.caseTags.saveTags();
    }
    
    public void updateMonitorChangingList() {
        this.caseTags.updateMonitorChangingList();
    }
    
    public List<Tag> getTags() {
        return this.caseTags.getTags();
    }
    
    public void removeTag(int index) {
        this.caseTags.removeTag(index);
    }
    
    private void closeCaseTags() {
        this.caseTags.close();
    }
   
    private void closeCaseAuditing() {
        this.caseAuditing.close();
    }
    
    private CaseFacade (final Case aCase, final boolean createCase) throws Exception {
        this.aCase = aCase;
        this.caseHistoryHandler = new CaseHistoryHandler();
        this.casePathConfiguration = new CasePathConfiguration(this.getCaseConfigurationFileLocation());
        this.caseAuditing = new CaseAuditing(this.aCase, this.getCaseAuditingFileLocation());
        this.caseTags = new CaseTags(this.getTagDatabaseFileLocation());
        
        if ( createCase )
            createNewCase();
        else
            openCase();
    }
        
    /**
     * create the folder structure for the current case object
     * options and return true if their is no problems
     */
    private void createNewCase() throws IOException {
        this.createCaseFoldersStructure();
        this.saveCaseInformation();
        this.updateCasesInformationFile();
        this.addCaseMappingInformation();
        this.caseTags.createDatabase();
    }
    
    private void openCase() throws Exception{
        if ( FileUtil.isFileFound(this.getTagDatabaseFileLocation())) {
            this.caseTags.openDatabase();
        }
        
        if ( FileUtil.isFileFound(this.getCaseConfigurationFileLocation())) {
            this.updateMappingFile();
        }
        
        if ( FileUtil.isFileFound(this.getCaseAuditingFileLocation())) {
            this.caseAuditing.init();
        }
    }
      
    public String getCasesInformationFileLocation() {
        return ApplicationConstants.APPLICATION_CASES_FILE;
    }
    
    public String getCasePreferenceFileLocation() {
          return this.aCase.getCaseLocation() 
                 + File.separator
                 + ApplicationConstants.CASE_PREFERENCE_FILE;
    }
    
    public String getCaseFolderLocation() { 
        return this.aCase.getCaseLocation();
    }
    
    public String getCaseIndexFolderLocation() { 
        return aCase.getCaseLocation() 
                + File.separator 
                + ApplicationConstants.CASE_INDEX_FOLDER;
    }
    
    public String getCaseImageFolderLocation() {
        return aCase.getCaseLocation() 
                +  File.separator 
                + ApplicationConstants.CASE_IMAGES_FOLDER;
    }
    
    public String getCaseInformationFileLocation() {
        return aCase.getCaseLocation() 
                + File.separator 
                + aCase.getCaseName() 
                + ApplicationConstants.CASE_SERIALIZED_INFORMATION_EXTENSION;
    }
    
    public String getCaseAuditingFolderLocation() {
        return aCase.getCaseLocation() 
            + File.separator 
            + ApplicationConstants.CASE_AUDITING_FOLDER;
    }
    
    public String getCaseAuditingFileLocation() {
        return this.getCaseAuditingFolderLocation()
                + File.separator
                + aCase.getCaseName() 
                + ApplicationConstants.CASE_AUDITING_EXTENSION;
    }
    
    public String getCaseArchiveOutputFolderLocation() {
        return aCase.getCaseLocation() 
                + File.separator 
                + ApplicationConstants.CASE_ARCHIVE_FOLDER;
    }
    
    public String getCaseOfflineEmailAttachmentLocation() {
        return aCase.getCaseLocation() 
                + File.separator 
                + ApplicationConstants.CASE_OFFLINE_EMAIL_ATTACHMENTS_FOLDER;
    }
    
    public String getCaseOnlineEmailAttachmentLocation() {
        return aCase.getCaseLocation()
                + File.separator
                + ApplicationConstants.CASE_ONLINE_EMAIL_ATTACHMENTS_FOLDER;
    }
    
    public String getCaseOnlineDatabaseLocation() {
        return aCase.getCaseLocation()
                + File.separator
                + ApplicationConstants.CASE_EMAIL_DB_FOLDER;
    }
    
    public String getCaseRawReportFolderLocation() {
        return aCase.getCaseLocation()
                + File.separator
                + ApplicationConstants.CASE_ROW_REPORT_FOLDER;
    }
    
    public String getCaseReportFolderLocation() {
        return aCase.getCaseLocation() 
                + File.separator 
                + ApplicationConstants.CASE_REPORTS_FOLDER;
    }
    
    private String getTagDatabaseFolderLocation() {
        return this.aCase.getCaseLocation()
                + File.separator
                + ApplicationConstants.CASE_TAGS_FOLDER;
    }
    
    public String getTagDatabaseFileLocation() {
        return this.aCase.getCaseLocation() 
                + File.separator 
                + ApplicationConstants.CASE_TAGS_FOLDER
                + File.separator
                + ApplicationConstants.CASE_TAG_DATABASE_FILE;
    }
    
    public String getCaseConfigurationFileLocation() {
        return this.aCase.getCaseLocation()
                + File.separator
                + ApplicationConstants.CASE_CONFIG_FILE;
    }
    
    public Case getCase() { 
        return this.aCase; 
    }
}
