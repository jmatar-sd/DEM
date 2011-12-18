/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.coeia.hashanalysis;

import edu.coeia.util.FileUtil;
import edu.coeia.util.FilesPath;
import java.io.File;
import java.io.FileFilter;
import java.util.List ;
import java.util.ArrayList ;
import java.util.Arrays;

/**
 *
 * @author wajdyessam
 */
public class HashLibraryManager {
    
    public HashLibraryManager(){ 
        //this.hashCategories = new ArrayList<HashCategory>();
    }
    
    public boolean add(final HashCategory hashCategory) {
        if ( ! this.isContain(hashCategory) ) {
            this.saveHashCategory(hashCategory);
            return true;
        }
        
        return false;
    }
    
    public boolean remove(final HashCategory hashCategory) {
        boolean status = false;
        
        try {
            File file = new File(FilesPath.HASH_LIBRARY_PATH + "\\" + hashCategory.getName() +
                    FilesPath.HASH_SET_EXTENSION );
            
            status = file.delete();
        }
        catch(Exception e) {
            e.printStackTrace();
        }
        
        return status;
    }
    
    public boolean isContain(final HashCategory hashCategory) {
        //return this.hashCategories.contains(hashCategory);
        return false;
    }
    
    public void update(final List<HashItem> items, final String categoryName) {
        try {
           File file = new File( FilesPath.HASH_LIBRARY_PATH + "\\" + categoryName + 
                   FilesPath.HASH_SET_EXTENSION);
                       
            HashCategory hashCategory = FileUtil.readObject(file);
            for(HashItem item: items) {
                if ( ! hashCategory.isContain(item) ) {
                    hashCategory.addItem(item);
                }
            }
            
            FileUtil.writeObject(hashCategory, file);
        }
        catch(Exception e) {
            e.printStackTrace();
        }
    }
    
    private void saveHashCategory(HashCategory hashCategory) { 
       try {
           File file = new File( FilesPath.HASH_LIBRARY_PATH + "\\" + hashCategory.getName() + 
                   FilesPath.HASH_SET_EXTENSION);
           
           FileUtil.writeObject(hashCategory,file);
       }
       catch(Exception e) {
           e.printStackTrace();
       }
    }
    
    public List<File> getHashSets(final String hashLocation) {
        List<File> files = new ArrayList<File>();
        
        File file = new File(hashLocation);
        FileFilter fileFilter = new FileFilter() {
            @Override
            public boolean accept(File file) {
                return file.isFile() && file.getAbsolutePath().endsWith(FilesPath.HASH_SET_EXTENSION);
            }
        };
        
        files.addAll(Arrays.asList(file.listFiles(fileFilter)));
        return files;
    }
    
    public HashCategory getHashCategory(final File file) {
        HashCategory hashCategory = null;
        
        try {
            hashCategory = FileUtil.readObject(file);
        }
        catch(Exception e) {
            e.printStackTrace();
        }
        
        return hashCategory;
    }
    
    //private List<HashCategory> hashCategories;
}