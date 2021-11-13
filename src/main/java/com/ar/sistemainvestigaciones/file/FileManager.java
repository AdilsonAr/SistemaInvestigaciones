package com.ar.sistemainvestigaciones.file;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author KGB
 */
public class FileManager {

    public void save(String content, String uuid) {
        // convertir bytes
        String path = Properties.DOCUMENTS_URL.getValue() + uuid + ".json";
        File directory=new File(Properties.DOCUMENTS_URL.getValue() );
        if(!directory.exists()){
            directory.mkdir();
        }
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(path);
            fileOutputStream.write(content.getBytes());
            fileOutputStream.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public String read(String uuid) {
        String path=Properties.DOCUMENTS_URL.getValue() + uuid + ".json";
        File directory=new File(Properties.DOCUMENTS_URL.getValue() );
        if(!directory.exists()){
            directory.mkdir();
        }
        FileInputStream fileInputStream = null;
        File file = new File(path);
        if(file.exists()){
            /*
            byte[] bytesArray = new byte[(int) file.length()];
        try {
            fileInputStream = new FileInputStream(file);
            fileInputStream.read(bytesArray);
            fileInputStream.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
*/
            try {
                return new String(Files.readAllBytes(Paths.get(path)));
            } catch (IOException ex) {
                ex.printStackTrace();
                return "";
            }
        }else{
            return "";
        }
        
    }
}
