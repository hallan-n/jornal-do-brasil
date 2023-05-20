package model;
public class Address {
    private int idAddress;
    private String number;
    private String complement;
    private String district;
    private String city;
    private String state;
    private String zipCode;

    public Address(String number, String complement, String district, String city, String state, String zipCode){
        this.number = number;
        this.complement = complement;
        this.district = district;
        this.city = city;
        this.state = state;
        this.zipCode = zipCode;
    }
    
    public Address(){

    }
    
    
    public int getIdAddress() {
        return idAddress;
    }
    public void setIdAddress(int idAddress) {
        this.idAddress = idAddress;
    }
    public String getNumber() {
        return number;
    }
    public void setNumber(String number) {
        this.number = number;
    }
    public String getComplement() {
        return complement;
    }
    public void setComplement(String complement) {
        this.complement = complement;
    }
    public String getDistrict() {
        return district;
    }
    public void setDistrict(String district) {
        this.district = district;
    }
    public String getCity() {
        return city;
    }
    public void setCity(String city) {
        this.city = city;
    }
    public String getState() {
        return state;
    }
    public void setState(String state) {
        this.state = state;
    }
    public String getZipCode() {
        return zipCode;
    }
    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

}
