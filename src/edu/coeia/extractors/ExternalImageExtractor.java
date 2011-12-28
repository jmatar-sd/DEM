/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.coeia.extractors;

/**
 *
 * @author wajdyessam
 */

import edu.coeia.indexing.Indexer;
import edu.coeia.util.FileUtil;

import java.io.File ;
import java.io.FileInputStream;
import java.io.IOException;

import java.util.logging.Level;
import java.util.logging.Logger;

public class ExternalImageExtractor implements ImageExtractor{
    
    @Override
    public void extractImages(Indexer indexer, File file,int parentId) {

            try {
                FileUtil.saveObject(new FileInputStream(file), file.getName(), indexer.getImagesLocation());
            } catch (IOException ex) {
                Logger.getLogger(ExternalImageExtractor.class.getName()).log(Level.SEVERE, null, ex);
            }
       
    }
}
