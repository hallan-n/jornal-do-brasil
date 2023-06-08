package services;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

import config.Env;

public class FileServer {
    private String fileName;
    private String extension;
    private String path;

    public FileServer(String path, String fileName, String extension) {
        this.fileName = fileName;
        this.extension = "." + extension;
        this.path = Env.PATH_BASE + "\\src\\main\\java\\" + path + "\\";
    }

    public FileServer() {

    }

    public String getPathWithFileName() {
        return path + fileName + extension;
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

    public String getPathRelative() {
        return path.replace("E:\\jornal-do-brasil\\src\\main\\java\\", "") + fileName + extension;
    }

    public void setPath(String path) {
        this.path = Env.PATH_BASE + "\\src\\main\\java\\" + path + "\\";
    }

    public String readFile(String pathWithFileName) {
        String data = "";
        try {
            File file = new File(pathWithFileName);
            Scanner reader = new Scanner(file);
            while (reader.hasNextLine()) {
                data += reader.nextLine();
            }
            reader.close();
        } catch (FileNotFoundException e) {
            System.out.println("Error read the file.");
            e.printStackTrace();
        } finally {
            return data;
        }        
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

    public void deleteFile(String pathWithFileName) {
        File file = new File(pathWithFileName);
        if (file.delete()) {
            System.out.println("Deleted the file: " + file.getName());
        } else {
            System.out.println("Failed to delete the file.");
        }
    }
}
