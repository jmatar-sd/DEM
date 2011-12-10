/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.coeia.filesignature;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Ahmed
 */
public class FileSignature {

    private static final int BUFFER_SIZE = 4096;
    private static final int MAX_SIGNATURE_SIZE = 8;
    private String Id;
    private String Signature;
    private String[] Extension;
    private String Type;
    private FileSignatureDBHandler db;

    public FileSignature() {
        
        
        
    }

    public boolean CreateDataBaseSignatures(String dbPath) throws ClassNotFoundException, InstantiationException, SQLException, IllegalAccessException {
        db = new FileSignatureDBHandler(dbPath);
        
        if (db != null) {
            return true;
        } else {
            return false;
        }
    }

    public FileSignature(String Id, String Signature, String[] Extension, String Type) {

        this.Id = Id;
        this.Signature = Signature;
        this.Extension = Extension;
        this.Type = Type;
    }

    public String getID() {
        return this.Id;
    }

    public String getSignature() {
        return this.Signature;
    }

    public String[] getExtension() {
        return this.Extension;
    }

    public String getType() {
        return this.Type;
    }
    
    String getFormattedExtension(String [] input) {
        StringBuilder result = new StringBuilder();
        if (input != null) {
            for (int i = 0; i < input.length; i++) {
                result.append(input[i]);
                if (i < input.length - 1) {
                    result.append(',');
                }
            }
        } else {

            return "";
        }
       return result.toString();
    }

    public String toString() {

        return Id + "\n" + Signature + "\n" + Extension + "\n" + Type + "\n";
    }

    private static String toHex(final byte[] bytes) {
        assert bytes != null;

        StringBuilder hex = new StringBuilder();

        for (int i = 0; i < bytes.length; i++) {
            int byte1 = bytes[i] & 0xFF;

            if (byte1 < 0xF) {
                hex.append("0");
            }

            hex.append(Integer.toHexString(byte1).toUpperCase());
        }

        return hex.toString();
    }

    public static boolean matchesSignature(byte[] signature, File file) throws FileNotFoundException, IOException {

        byte[] buffer = new byte[signature.length];
        InputStream in = new FileInputStream(file);
        int n = in.read(buffer, 0, signature.length);

        if (n < signature.length) {
            return false;
        }
        String hex = toHex(buffer);

        boolean b = false;
        String signstring = new String(signature);
        if (hex.contains(signstring)) {
            b = true;
        } else {
            b = false;
        }

        return b;
    }

    // Get the extension of the file and search for matached signature based on
    // on the extension
    public static boolean matchBadSignature(File file, FileSignature db) throws FileNotFoundException, IOException {

        String extension = getExtension(file);

        // ext  == sign in database 
        for (String ext : db.getExtension()) {
            if (extension.equalsIgnoreCase(ext)) {

                String dbSignature = db.getSignature();

                boolean result = matchesSignature(dbSignature.getBytes(), file);

                if (result) {
                    System.out.println("Bad File Signature");
                    return true;
                } else {
                    System.out.println("Unknown File Format");
                    return false;
                }
            }

        }

        return false;
    }

    // Get Signature of the file and search for it in the database
    public static boolean searchSignature(File file, FileSignature db) throws FileNotFoundException, IOException {

        boolean result = matchesSignature(db.getSignature().getBytes(), file);

        return result;
    }

    private static String getExtension(File f) {
        if (!f.exists() || f.isDirectory()) {
            return null;
        }

        int index = f.getAbsolutePath().lastIndexOf(".");

        if ((index < 0) && (index >= f.toString().length())) {
            return null;
        }

        String ext = f.getAbsolutePath().substring(index + 1);

        return (ext);
    }

    public List<FileSignature> ParseFile() throws IOException {

        BufferedReader br = null;
        List<FileSignature> files = new ArrayList<FileSignature>();
        try {

            br = new BufferedReader(new FileReader("signatures.txt"));
            String line = null;

            while ((line = br.readLine()) != null) {

                String[] values = line.split(",N/A");
                String[] firstPart = values[0].split(",");
                String[] secondPart = values[1].split(",");
                String[] extensionPart = null;
                extensionPart = secondPart[1].split("\\|");

                FileSignature fs = new FileSignature(firstPart[0], firstPart[1].replaceAll("\\ ", ""), extensionPart, secondPart[2]);
                files.add(fs);

                // System.out.println(fs.toString());
            }
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        } catch (IOException ex) {
            ex.printStackTrace();
        } finally {
            try {
                if (br != null) {
                    br.close();
                }
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }

        return files;
    }
}
