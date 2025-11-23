package RAYYAN;
import java.util.ArrayList;
import java.util.HashMap;

public class SchoolManagement {
    private String schoolName, address, mediumOfStudy;
    private int contactNumber;
    private Relations relations;
    private NoticeBoard noticeBoard;
    private Employee[] employees;
    private Classroom[] classes;
    private boolean isOpen = false;

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
        return isOpen;
    }
    public String schoolDetails(){
        return String.format("School Name:       %s\nAddress:        %s\nContact:        %d\nMedium of Study: %s", schoolName, address, contactNumber, mediumOfStudy);
    }
    public void initialize(/*Auditorium auditorium, Playground playground, */NoticeBoard noticeBoard, Employee[] employees, Classroom[] classes/* Lab[] labs*/){
        this.noticeBoard = noticeBoard;
        this.employees = employees;
        this.classes = classes;
    }

    // relation class
    class Relations{
        private HashMap<Integer, Employee> employeeMap;

        Relations(){
            employeeMap = new HashMap<>();
        }

        public void addEmployee(int id, Employee e){
            employeeMap.put(id, e);
        }

        public String getEmployee(int id){
            Employee e = employeeMap.get(id);
            if (e == null) {
                return "404: Not Found!";
            }
            return e.getEmployeeName() + "\n";
        }
    }
    public void runSchool(){
        isOpen = true;
        while (isOpen) {
            System.out.println("[A] Bus");
            System.out.println("[B] Student");
            System.out.println("[C] Employee");
            System.out.println("[D] Class");
            System.out.println("[E] Notice Board");
            System.out.println("[F] Auditorium");
            System.out.println("[G] School Details");
            System.out.println("[H] Exit");
            String input = "h";
            switch (input.toUpperCase()) {
                case "A":
                    System.out.println("[A] Bus");
                    System.out.println("\t1. Add Bus");
                    System.out.println("\t2. Show Bus Details");
                    System.out.println("\t3. Show Seats");
                    System.out.println("\t4. Go Back");

                case "B":
                    System.out.println("[B] Student");
                    System.out.println("\t1. Add Student");
                    System.out.println("\t2. Show Student Details");
                    System.out.println("\t3. Pay Fee");
                    System.out.println("\t4. Go Back");

                case "C":
                    System.out.println("[C] Employee");
                    System.out.println("\t1. Teacher");
                    System.out.println("\t2. Support Staff");
                    System.out.println("\t3. Go Back");

                case "D":
                    System.out.println("[D] Class");
                    System.out.println("\t1. Add Students");
                    System.out.println("\t2. Assign Teacher");
                    System.out.println("\t3. Show Details");
                    System.out.println("\t4. Go Back");

                case "E":
                    System.out.println("[E] Notice Board");
                    System.out.println("\t1. Display");
                    System.out.println("\t2. Add Content");
                    System.out.println("\t3. Go Back");

                case "F":
                    System.out.println("[F] Auditorium");
                    System.out.println("\t1. Book Auditorium");
                    System.out.println("\t2. Show Event Details");
                    System.out.println("\t3. Show Seats");
                    System.out.println("\t4. Go Back");

                case "G":
                    System.out.println("[G] School Details");
                    System.out.println(schoolDetails());
                case "H":
                    return;
            
                default:
                    break;
            }
        }
    }
}
