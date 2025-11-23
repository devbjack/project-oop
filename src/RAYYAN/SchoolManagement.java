package RAYYAN;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class SchoolManagement {
    private String schoolName, address, mediumOfStudy;
    private int contactNumber;
    private Relations relations;
    private NoticeBoard noticeBoard;
    private Employee[] employees;
    private Classroom[] classes;
    private ArrayList<Student> students;
    private boolean isOpen = false;
    static Scanner sc = new Scanner(System.in);
    final static String twolines = "================================================";

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
        students = new ArrayList<>();
        relations = new Relations();
        
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
            String input1 = "h";
            switch (input1.toUpperCase()) {
                case "A":
                    System.out.println("[A] Bus");
                    System.out.println("\t1. Add Bus");
                    System.out.println("\t2. Show Bus Details");
                    System.out.println("\t3. Show Seats");
                    System.out.println("\t4. Go Back");

                case "B":
                    int input2 = 0;
                    while(input2!=4){
                        System.out.println("[B] Student");
                        System.out.println("\t1. Add Student");
                        System.out.println("\t2. Show Student Details");
                        System.out.println("\t3. Pay Fee");
                        System.out.println("\t4. Go Back");
                        input2 = sc.nextInt();

                        if (input2==1) {
                            System.out.print("Student ID: ");
                            int studentId = sc.nextInt();
                            System.out.print("\nName: ");
                            String name = sc.nextLine();
                            System.out.print("Class ID: ");
                            int classId = sc.nextInt();
                            System.out.print("\nSection: ");
                            int section = sc.nextInt();
                            System.out.print("\nBus ID: ");
                            int busId = sc.nextInt();
                            students.add(new Student(studentId, name, classId, section, busId));
                        }
                        else if(input2==2){
                            System.out.println("List of students:");
                            for (int i = 0; i < students.size(); i++) {
                                System.out.println((i+1) + ". " + students.get(i).getStudentName());
                            }
                            System.out.println(students.size() + ". Show All");
                            System.out.println("Choose which student you want to see the details");
                            int input3 = sc.nextInt();
                            if (input3 == students.size()){
                                for (Student std : students) {
                                    System.out.println(twolines);
                                    System.out.println(std.studentDetails());
                                }
                            }
                            else{
                                System.out.println(students.get(input3-1).studentDetails());
                            }
                        }
                        else if(input2==3){
                            // pay fee
                        }
                    }
                    break;
                    

                case "C":
                    input2 = 0;
                    while (input2 != 3) {
                        System.out.println("[C] Employee");
                        System.out.println("\t1. Teacher");
                        System.out.println("\t2. Support Staff");
                        System.out.println("\t3. Go Back");
                        
                        if (input2==1) {
                            String input3 = "";
                            while(input3.equalsIgnoreCase("c")){
                                System.out.println("1. Teacher");
                                System.out.println("\ta. Show Teacher Details");
                                System.out.println("\tb. Receive Salary");
                                System.out.println("\tc. Go Back");
                                input3 = sc.next();
                                if(input3.equalsIgnoreCase("a")){
                                    System.out.println("List of Teacher:");
                                    int numbering = 1;
                                    for (int i = 0; i < employees.length; i++) {
                                        if(employees[i] instanceof Teacher){
                                            System.out.println(numbering++ + ". " + employees[i].getEmployeeName());
                                        }
                                    }
                                    System.out.println(numbering + ". Show All");
                                    System.out.println("Choose which teacher you want to see the details");
                                    int input4 = sc.nextInt();
                                    if (input4 == numbering){
                                        numbering = 1;
                                        for (int i = 0; i < employees.length; i++) {
                                            if(employees[i] instanceof Teacher){
                                                System.out.println(twolines);
                                                System.out.println(numbering++ + ". " + employees[i].employeeDetails());
                                                // need to map employee with department
                                            }
                                        } 
                                    }
                                    else{
                                        try{
                                            System.out.println(employees[input4]);
                                        }catch (ArrayIndexOutOfBoundsException e){
                                            System.out.println("Teacher not found");
                                        }
                                    }
                                }
                                else if(input3.equalsIgnoreCase("b")){
                                    // receive salary
                                }
                            }
                        }
                        else if(input2==2){
                            String input3 = "";
                            while(input3.equalsIgnoreCase("c")){
                                System.out.println("1. Support Staff");
                                System.out.println("\ta. Show Support Staff Details");
                                System.out.println("\tb. Receive Salary");
                                System.out.println("\tc. Go Back");
                                input3 = sc.next();
                                if(input3.equalsIgnoreCase("a")){
                                    System.out.println("List of Support Staff:");
                                    int numbering = 1;
                                    for (int i = 0; i < employees.length; i++) {
                                        if(employees[i] instanceof SupportStaff){
                                            System.out.println(numbering++ + ". " + employees[i].getEmployeeName());
                                        }
                                    }
                                    System.out.println(numbering + ". Show All");
                                    System.out.println("Choose which support staff you want to see the details");
                                    int input4 = sc.nextInt();
                                    if (input4 == numbering){
                                        numbering = 1;
                                        for (int i = 0; i < employees.length; i++) {
                                            if(employees[i] instanceof SupportStaff){
                                                System.out.println(twolines);
                                                System.out.println(numbering++ + ". " + employees[i].employeeDetails());
                                                // need to map employee with department
                                            }
                                        } 
                                    }
                                    else{
                                        try{
                                            System.out.println(employees[input4]);
                                        }catch (ArrayIndexOutOfBoundsException e){
                                            System.out.println("Support Staff not found");
                                        }
                                    }
                                }
                                else if(input3.equalsIgnoreCase("b")){
                                    // receive salary
                                }
                            }
                        }
                    }
                    break;
                    
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
