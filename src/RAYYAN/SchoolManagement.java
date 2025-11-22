package RAYYAN;
public class SchoolManagement {
    private String schoolName, address, mediumOfStudy;
    private int contactNumber;

    public SchoolManagement(){

    }
    public SchoolManagement(String schoolName, String address, int contactNumber, String mediumOfStudy){
        this.schoolName = schoolName;
        this.address = address;
        this.contactNumber = contactNumber;
        this.mediumOfStudy = mediumOfStudy;
    }
    
    // setter
    public void setSchoolName(String schoolName){
        this.schoolName = schoolName;
    }
    public void setContactNumber(int contactNumber){
        this.contactNumber = contactNumber;
    }
    public void setAddress(String address){
        this.address = address;
    }
    public void setMediumOfStudy(String mediumOfStudy){
        this.mediumOfStudy = mediumOfStudy;
    }
    
    // getter
    public String getSchoolName(){
        return schoolName;
    }
    public String getAddress(){
        return address;
    }
    public int getContactNumber(){
        return contactNumber;
    }
    public String getMediumOfStudy(){
        return mediumOfStudy;
    }
    
    //methods
    public boolean isOpen(){
        return true;
    }
    public String schoolDetails(){
        return String.format("School Name:  %s\nAddress:        %s\nContact:        %d\nMedium of Study: %s", schoolName, address, contactNumber, mediumOfStudy);
    }

}
