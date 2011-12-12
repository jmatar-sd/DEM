/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package edu.coeia.image;

/**
 *
 * @author wajdyessam
 */

import edu.coeia.cases.Case ;
import edu.coeia.util.FilesPath ;

import java.util.List ;

import java.io.IOException ;

public class ImageViewer {
    private static List<String> imagesPath ;

    public static List<String> getInstance(Case index) throws IOException {
        if ( imagesPath == null ) {
            ImageReader ir = new ImageReader(index.getCaseLocation() + "\\" + FilesPath.INDEX_PATH);
            imagesPath = ir.getImagesPath();
            ir.close();
        }

        return imagesPath ;
    }
}