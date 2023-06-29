package model;
import java.util.Date;

public class Publication {
    private int idPubli;
    private String title;
    private String category;
    private String description;

    private String fileName;
    private String extension;
    private String pathFileName;

    private String thumb;
    private String pathThumb;
    
    private int author;
    private Date date;

    public Publication() {

    }

    public Publication(String title, String category, String description, String fileName, String extension,
            String pathFileName, String thumb, String pathThumb, int author, Date date) {
        this.title = title;
        this.category = category;
        this.description = description;
        this.fileName = fileName;
        this.extension = extension;
        this.pathFileName = pathFileName;
        this.thumb = thumb;
        this.pathThumb = pathThumb;
        this.author = author;
        this.date = date;
    }

    public int getIdPubli() {
        return idPubli;
    }

    public void setIdPubli(int idPubli) {
        this.idPubli = idPubli;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
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
        this.extension = extension;
    }

    public String getPathFileName() {
        return pathFileName;
    }

    public void setPathFileName(String pathFileName) {
        this.pathFileName = pathFileName;
    }

    public String getThumb() {
        return thumb;
    }

    public void setThumb(String thumb) {
        this.thumb = thumb;
    }

    public String getPathThumb() {
        return pathThumb;
    }

    public void setPathThumb(String pathThumb) {
        this.pathThumb = pathThumb;
    }

    public int getAuthor() {
        return author;
    }

    public void setAuthor(int author) {
        this.author = author;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}