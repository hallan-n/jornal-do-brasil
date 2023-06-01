package services;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;


public class FileServer {

    private String fileName;
    private String extension;
    private String path;
    File file = new File("");

    public FileServer(String path, String fileName, String extension) {
        this.fileName = fileName;
        this.extension = "." + extension;
        this.path = file.getAbsolutePath()+ "/src/main/java/" + path + "/";
    }
    public FileServer() {

    }
    public String getFileName() {
        return fileName;
    }
    public void setFileName(String fileName) {
        this.fileName = fileName;
    }
    public String getExtension() {
        return extension;
    }
    public void setExtension(String extension) {
        this.extension = "." + extension;
    }
    public String getPath() {
        return path;
    }
    public void setPath(String path) {
        this.path = file.getAbsolutePath()+ "\\src\\main\\java\\" + path + "\\";
    } 
    
    public void writeFile(String data) {
        try {
            FileWriter writerFile = new FileWriter(path + fileName + extension);
            writerFile.write(data);
            writerFile.close();
            System.out.println("Success writing the file.");
        } catch (IOException e) {
            System.out.println("Error writing the file.");
            e.printStackTrace();
        }
    }
}
