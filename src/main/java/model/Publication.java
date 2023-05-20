package model;
import java.util.Date;

public class Publication {
    private int idPubli;
    private String title;
    private String category;
    private String path;
    private int author;
    private Date date;

    public Publication(String title, String category, String path, int author, Date date){
        this.title = title;
        this.category = category;
        this.path = path;
        this.author = author;
        this.date = date;
    }
    public Publication(){

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
    public String getPath() {
        return path;
    }
    public void setPath(String path) {
        this.path = path;
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