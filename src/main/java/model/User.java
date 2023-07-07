package model;

public class User {
    private int idUser;
    private String name;
    private String surname;
    private String email;
    private String phone;
    private String password;
    private boolean acceptTerms;
    private String description;
    private String profilePhoto;
    private String extension;
    private String pathProfilePhoto;
    private int address;
    private int configuration;

    public User() {

    }

    public User(int idUser, String name, String surname, String email, String phone, String password,
            boolean acceptTerms, String description, String profilePhoto, String extension, String pathProfilePhoto,
            int address, int configuration) {
        this.idUser = idUser;
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.phone = phone;
        this.password = password;
        this.acceptTerms = acceptTerms;
        this.description = description;
        this.profilePhoto = profilePhoto;
        this.extension = extension;
        this.pathProfilePhoto = pathProfilePhoto;
        this.address = address;
        this.configuration = configuration;
    }

    public int getIdUser() {
        return idUser;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isAcceptTerms() {
        return acceptTerms;
    }

    public void setAcceptTerms(boolean acceptTerms) {
        this.acceptTerms = acceptTerms;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getProfilePhoto() {
        return profilePhoto;
    }

    public void setProfilePhoto(String profilePhoto) {
        this.profilePhoto = profilePhoto;
    }

    public String getExtension() {
        return extension;
    }

    public void setExtension(String extension) {
        this.extension = extension;
    }

    public String getPathProfilePhoto() {
        return pathProfilePhoto;
    }

    public void setPathProfilePhoto(String pathProfilePhoto) {
        this.pathProfilePhoto = pathProfilePhoto;
    }

    public int getAddress() {
        return address;
    }

    public void setAddress(int address) {
        this.address = address;
    }

    public int getConfiguration() {
        return configuration;
    }

    public void setConfiguration(int configuration) {
        this.configuration = configuration;
    }
}
