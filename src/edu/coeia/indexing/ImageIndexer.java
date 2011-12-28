/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.coeia.indexing;

/**
 *
 * @author wajdyessam
 */

import edu.coeia.extractors.TikaExtractor;
import edu.coeia.extractors.ImageExtractor;
import edu.coeia.hash.HashCalculator;
import edu.coeia.util.FileUtil;
import java.io.File ;

import java.util.Map;

import org.apache.lucene.document.DateTools;
import org.apache.lucene.document.Document ;
import org.apache.lucene.document.Field ;


final class ImageIndexer extends Indexer{
    
    private int parentId ;
    
    public static ImageIndexer newInstance(LuceneIndex luceneIndex, File file, String mimeType,
            ImageExtractor imageExtractor) {
        return new ImageIndexer(luceneIndex, file,mimeType, imageExtractor, 0);
    }
        
    public static ImageIndexer newInstance(LuceneIndex luceneIndex, File file, String mimeType,
            ImageExtractor imageExtractor, int parentId) {
        return new ImageIndexer(luceneIndex, file,mimeType, imageExtractor, parentId);
    }
    
    private ImageIndexer(LuceneIndex luceneIndex, File file, String mimeType,
            ImageExtractor imageExtractor, int parentId) {
        super(luceneIndex, file,mimeType, imageExtractor);
        this.parentId = parentId ;
    }
        
    @Override
    public boolean doIndexing() {
        boolean status = false; 
        
        try{            
            TikaExtractor extractor = TikaExtractor.getExtractor(this.getFile(), this.getMimeType());
            Map<String, String> metadata = extractor.getMetadata();
            
            Document doc = getDocument(this.getFile(), metadata);
            this.getLuceneIndex().getWriter().addDocument(doc);
            
            int objectId = this.getId() ;
            
            if ( doc != null) {
                this.getLuceneIndex().getWriter().addDocument(doc);    // index file
                this.increaseId();
                
                // cache images i.e move the image to images location , id will ignored 
                if ( this.isImageCache() ) {
                    this.getImageExtractor().extractImages(this, this.getFile(), objectId);
                }

                status = true;
            }
        }
        catch(Exception e) {
            throw new UnsupportedOperationException(e.getMessage());
        }
        
        return status;
    }
    
    // provide lucene document for images format (JPEG, PNG.. etc)
    private Document getDocument(File file, Map<String, String> metadata) {
        Document doc = new Document();
        
        // generic document fileds
        doc.add(new Field(IndexingConstant.DOCUMENT_ID, String.valueOf(this.getId()), Field.Store.YES, Field.Index.NOT_ANALYZED));
        doc.add(new Field(IndexingConstant.DOCUMENT, IndexingConstant.getDocumentType(IndexingConstant.DOCUMENT_TYPE.FILE), Field.Store.YES, Field.Index.NOT_ANALYZED));
        doc.add(new Field(IndexingConstant.DOCUMENT_PARENT_ID, String.valueOf(this.parentId), Field.Store.YES, Field.Index.NOT_ANALYZED));
        doc.add(new Field(IndexingConstant.DOCUMENT_HASH, HashCalculator.calculateFileHash(this.getFile().getAbsolutePath()), Field.Store.YES, Field.Index.NOT_ANALYZED));
        
        // specfic document fields
        doc.add(new Field(IndexingConstant.FILE_PATH, file.getPath(), Field.Store.YES, Field.Index.NOT_ANALYZED));
        doc.add(new Field(IndexingConstant.FILE_NAME, file.getName() , Field.Store.YES, Field.Index.NOT_ANALYZED));
        doc.add(new Field(IndexingConstant.FILE_DATE, DateTools.timeToString(file.lastModified(), DateTools.Resolution.MINUTE),Field.Store.YES, Field.Index.NOT_ANALYZED));
        doc.add(new Field(IndexingConstant.FILE_MIME, FileUtil.getExtension(file), Field.Store.YES, Field.Index.NOT_ANALYZED) );

        // unknown image metadata extracted by Tika
        for(Map.Entry<String, String> entry: metadata.entrySet()) {
            String name =  entry.getKey();
            String value = entry.getValue();
            doc.add(new Field(name, value, Field.Store.YES, Field.Index.ANALYZED)); 
        }
        
        return doc;
    }
}
