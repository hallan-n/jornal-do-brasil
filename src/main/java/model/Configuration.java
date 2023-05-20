package model;
public class Configuration {
    private int idConfig;
    private boolean notification;
    private boolean sound;
    private boolean showProfilePhoto;
    private boolean showdescription;
    private boolean showNumber;
    private boolean showEmail;
    private String theme;
    
    public Configuration(boolean notification, boolean sound, boolean showProfilePhoto, boolean showdescription, boolean showNumber, boolean showEmail, String theme){
        this.notification = notification;
        this.sound = sound;
        this.showProfilePhoto = showProfilePhoto;
        this.showdescription = showdescription;
        this.showNumber = showNumber;
        this.showEmail = showEmail;
        this.theme = theme;
    }
    public Configuration(){

    }
    
    public int getIdConfig() {
        return idConfig;
    }
    public void setIdConfig(int idConfig) {
        this.idConfig = idConfig;
    }
    public boolean isNotification() {
        return notification;
    }
    public void setNotification(boolean notification) {
        this.notification = notification;
    }
    public boolean isSound() {
        return sound;
    }
    public void setSound(boolean sound) {
        this.sound = sound;
    }
    public boolean isShowProfilePhoto() {
        return showProfilePhoto;
    }
    public void setShowProfilePhoto(boolean showProfilePhoto) {
        this.showProfilePhoto = showProfilePhoto;
    }
    public boolean isShowdescription() {
        return showdescription;
    }
    public void setShowdescription(boolean showdescription) {
        this.showdescription = showdescription;
    }
    public boolean isShowNumber() {
        return showNumber;
    }
    public void setShowNumber(boolean showNumber) {
        this.showNumber = showNumber;
    }
    public boolean isShowEmail() {
        return showEmail;
    }
    public void setShowEmail(boolean showEmail) {
        this.showEmail = showEmail;
    }
    public String getTheme() {
        return theme;
    }
    public void setTheme(String theme) {
        this.theme = theme;
    }

}
