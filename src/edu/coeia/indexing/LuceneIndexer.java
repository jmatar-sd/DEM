/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package edu.coeia.indexing;

/**
 *
 * @author wajdyessam
 *
 */

import org.apache.lucene.index.IndexWriter;
import org.apache.lucene.store.FSDirectory ;
import org.apache.lucene.util.Version ;

import com.pff.PSTException ;
import edu.coeia.cases.Case;
import edu.coeia.main.util.FilesPath;

import java.io.FileNotFoundException ;
import java.io.File;
import java.io.IOException;

import java.util.List ;
import org.apache.lucene.analysis.StopAnalyzer;

import org.apache.tika.exception.TikaException;

// to be changed

public class LuceneIndexer {

    private static IndexWriter writer ;
    private static Case caseObject; 
    
    /*
     * Static Factory Method 
     * Create New Instance of Lucene Indexer
     */
    public static LuceneIndexer getInstance(Case aCase, boolean createIndex) throws IOException{ 
        return new LuceneIndexer(aCase, createIndex);
    }
    
    // last parameter will create new index folder
    private LuceneIndexer (Case aCase) throws IOException {
       this(aCase, true);
    }

    // add index to exists index folder if boolean value is false
    private LuceneIndexer (Case aCase, boolean newIndex) throws IOException {
        File indexDir = new File(aCase.getIndexLocation());
        
        if ( !indexDir.exists() ) {
            throw new IOException("not found indexing folder");
        }

	caseObject = aCase; 
        
        // using standard analyzer
        //writer = new IndexWriter(FSDirectory.open(indexDir), new StandardAnalyzer(Version.LUCENE_20), true, IndexWriter.MaxFieldLength.LIMITED);
        
        // using stop analyzer
        writer = new IndexWriter(FSDirectory.open(indexDir), new StopAnalyzer(Version.LUCENE_20, new File(FilesPath.STOP_WORD_FILE)),
                true, IndexWriter.MaxFieldLength.UNLIMITED);

	writer.setUseCompoundFile(false);
    }

    public int getIndexNumber () throws IOException {
        int numIndexed = writer.numDocs();
        
        return numIndexed ;
    }

    public void closeIndex () throws IOException {
        writer.optimize();
	writer.close();
    }
    
    public static boolean indexFile(File file)  
            throws IOException, FileNotFoundException, PSTException, TikaException {
        return indexFile(file, 0);
    }
    
    public static boolean indexFile(File file, int parentId)  
            throws IOException, FileNotFoundException, PSTException, TikaException {
   
        try {
            
            Indexer indexType = IndexerFactory.getIndexer(writer, file, caseObject.getCheckCompressed(),
                    caseObject.getIndexLocation(), parentId);
            
            return indexType.doIndexing();
        }
        catch(UnsupportedOperationException e){
            System.out.println(e.getMessage());
        }
        
        return false;
    }
    
//
//    // 0 = TXT , 1 = RTF , 2 = HTML , 3=HTM , 4 = MHT , 5 = DOC , 6 = PDF , 7 = XML
//    private Document parseFile (File f) throws IOException, PSTException, FileNotFoundException,
//    TikaException {
//        Document doc = null ;
//            
////            FileInputStream file = new FileInputStream(f);
////            if ( ext.equalsIgnoreCase("txt") )
////                doc =  new edu.coeia.parse.TXTParser(f.getAbsolutePath()).parseDocument(file);
////            else if ( ext.equalsIgnoreCase("rtf"))
////                doc =  new edu.coeia.parse.RTFParser(f.getAbsolutePath()).parseDocument(file);
////            else if ( ext.equalsIgnoreCase("html"))
////                doc =  new edu.coeia.parse.HTMLParser(f.getAbsolutePath()).parseDocument(file);
////            else if ( ext.equalsIgnoreCase("htm"))
////                doc =  new edu.coeia.parse.HTMLParser(f.getAbsolutePath()).parseDocument(file);
////            else if ( ext.equalsIgnoreCase("mht"))
////                doc =  new edu.coeia.parse.HTMLParser(f.getAbsolutePath()).parseDocument(file);
////            else if ( ext.equalsIgnoreCase("doc"))
////                doc =  new edu.coeia.parse.DOCParser(f.getAbsolutePath()).parseDocument(file);
////            else if ( ext.equalsIgnoreCase("pdf"))
////                 doc =  new edu.coeia.parse.PDFDocParser(f.getAbsolutePath()).parseDocument(file);
////            else if ( ext.equalsIgnoreCase("xml"))
////                doc =  new edu.coeia.parse.XMLParser(f.getAbsolutePath()).parseDocument(file);
//            
//        doc = new Document();
//        Tika tika = new Tika();
//        String mime = tika.detect(f);
//
//        if ( mime.startsWith("image")) {
//            imagesPath.add(f.getAbsolutePath());
//            //doc.add(Field.Keyword("mime", f.getAbsolutePath()));
//            doc = FileDocument.documentImage(f);
//        }
//        else {
//            String bodyText = tika.parseToString(f);
//            //doc.add(Field.UnStored("body", bodyText) );
//            //doc.add(Field.Keyword("filename", f.getAbsolutePath() ) );
//            doc = FileDocument.documentFile(f, bodyText);
//        }
//        
//        return (doc);
//    }
//
//    private boolean parsePST (String path) throws FileNotFoundException, PSTException, IOException{
//        PSTParser parser = new PSTParser();
//        return parser.parseIndexDocument(new PSTFile(path), path, writer);
//    }
    
//    public boolean indexFile (File f) throws IOException, FileNotFoundException, PSTException,
//    TikaException {
//        String ext = Utilities.getExtension(f).toLowerCase();
//        
//        if ( ext.equalsIgnoreCase("pst") || ext.equalsIgnoreCase("ost"))
//            return parsePST(f.getAbsolutePath());
//        
//        else {
//            Document doc = parseFile(f);
//
//            if ( doc != null) {
//                writer.addDocument(doc);    // index file
//            }
//            else {
//                System.out.println("Fail Parsing: " + f.getAbsolutePath());
//                return false;
//            }
//        }
//        
//        return true ;
//    }
    
}
