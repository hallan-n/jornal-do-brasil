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
    private Address address;
    private String profilePhoto;
    private Configuration configuration;

    public User(String name, String surname, String email, String phone, String password, boolean acceptTerms, String description, Address address, String profilePhoto, Configuration configuration){
        this.name =  name;
        this.surname =  surname;
        this.email =  email;
        this.phone =  phone;
        this.password =  password;
        this.acceptTerms =  acceptTerms;
        this.description =  description;
        this.address =  address;
        this.profilePhoto =  profilePhoto;
        this.configuration =  configuration;
    }
    public User(){

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
    public Address getAddress() {
        return address;
    }
    public void setAddress(Address address) {
        this.address = address;
    }
    public String getProfilePhoto() {
        return profilePhoto;
    }
    public void setProfilePhoto(String profilePhoto) {
        this.profilePhoto = profilePhoto;
    }
    public Configuration getConfiguration() {
        return configuration;
    }
    public void setConfiguration(Configuration configuration) {
        this.configuration = configuration;
    }

}
