package RAYYAN;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

import OMAR.*;

public class SchoolManagement {
    private String schoolName, address, mediumOfStudy;
    private int contactNumber;
    private NoticeBoard noticeBoard;
    private Auditorium auditorium;
    private Playground playground;
    private boolean isOpen = false;
    static Scanner sc = new Scanner(System.in);
    final static String twolines = "================================================";

    // data storage
    private HashMap<Integer, Teacher> teachers;
    private HashMap<Integer, SupportStaff> supportStaffs;
    private HashMap<Integer, Classroom> classes;
    private HashMap<Integer, Lab> labs;
    private HashMap<Integer, Department> departments;
    private HashMap<Integer, Student> students;
    private HashMap<Integer, ClassEquipments> classEquipments;
    private HashMap<Integer, Bus> buses;

    public SchoolManagement(String schoolName, String address, int contactNumber, String mediumOfStudy) {
        this.schoolName = schoolName;
        this.address = address;
        this.contactNumber = contactNumber;
        this.mediumOfStudy = mediumOfStudy;
    }

    // setter
    public void setSchoolName(String schoolName) {
        this.schoolName = schoolName;
    }

    public void setContactNumber(int contactNumber) {
        this.contactNumber = contactNumber;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setMediumOfStudy(String mediumOfStudy) {
        this.mediumOfStudy = mediumOfStudy;
    }

    // getter
    public String getSchoolName() {
        return schoolName;
    }

    public String getAddress() {
        return address;
    }

    public int getContactNumber() {
        return contactNumber;
    }

    public String getMediumOfStudy() {
        return mediumOfStudy;
    }

    // methods
    public boolean isOpen() {
        return isOpen;
    }

    public String schoolDetails() {
        return String.format(
            "%-1s: %s\n" +  
            "%-1s: %s\n" +  
            "%-1s: %d\n" +  
            "%-1s: %s\n",     
            "School Name: ", schoolName,
            "Address: ", address,
            "Contact: ", contactNumber,
            "Medium of Study: ", mediumOfStudy
        );
    }

    public void initialize(Auditorium auditorium, Playground playground, NoticeBoard noticeBoard,
            ArrayList<Employee> employees, Classroom[] classes, Lab[] labs, ArrayList<ClassEquipments> classEquipments) {
        this.auditorium = auditorium;
        this.playground = playground;
        this.noticeBoard = noticeBoard;
        this.classes = new HashMap<>();
        this.labs = new HashMap<>();
        this.teachers = new HashMap<>();
        this.supportStaffs = new HashMap<>();
        this.departments = new HashMap<>();
        this.students = new HashMap<>();
        this.classEquipments = new HashMap<>();
        this.buses = new HashMap<>();
        initClasses(classes);
        initLabs(labs);
        initClassEquipments(classEquipments);
        getTeacherFromEmployee(employees);
        getSupportStaffFromEmployee(employees);
        initDept();
        
        initDeptMember();
    }

    private void initClasses(Classroom[] classArr) {
        for (int i = 0; i < classArr.length; i++) {
            classes.put(classArr[i].getClassId(), classArr[i]);
        }
    }

    private void initLabs(Lab[] labArr) {
        for (int i = 0; i < labArr.length; i++) {
            labs.put(labArr[i].getLabId(), labArr[i]);
        }
    }

    private void initClassEquipments(ArrayList<ClassEquipments> classEquipments) {
        for (ClassEquipments classEquipment : classEquipments) {
            this.classEquipments.put(classEquipment.getEquipmentId(), classEquipment);
        }
    }

    private void initDept() {
        Department[] departments = new Department[] {
                new Department("Science"),
                new Department("English"),
                new Department("Art"),
                new Department("Literature")
        };
        for (int i = 0; i < departments.length; i++) {
            this.departments.put(departments[i].getDepartmentId(), departments[i]);
        }
    }
    private void initDeptMember() {
        for (Teacher teacher : teachers.values()) {
            Department dept = departments.get(teacher.getDepartmentId());
            if (dept == null) {
                System.out.println("Warning: Teacher " + teacher.getEmployeeName() +
                                " has invalid department id " + teacher.getDepartmentId());
                continue;
            }
            dept.setMemberList(teacher);
        }
        for (Department department : departments.values()) {
            if (department.getMemberList() == null || department.getMemberList().isEmpty()) {
                department.setInchargeName("None"); 
            } else {
                department.setInchargeName(department.getMember(0).getEmployeeName());
            }
        }
    }
    private void getTeacherFromEmployee(ArrayList<Employee> employees) {
        for (Employee employee : employees) {
            if(employee instanceof Teacher){
                teachers.put(employee.getEmployeeId(), new Teacher(employee));
            }
        }
        for (HashMap.Entry<Integer, Teacher> teacher : teachers.entrySet()) {
            teacher.getValue().setEmployeeId(teacher.getKey());
        }
    }

    private void getSupportStaffFromEmployee(ArrayList<Employee> employees) {
        for (Employee employee : employees) {
            if(employee instanceof SupportStaff){
                supportStaffs.put(employee.getEmployeeId(), new SupportStaff(employee));
            }
        }
        for (HashMap.Entry<Integer, SupportStaff> supportStaff : supportStaffs.entrySet()) {
            supportStaff.getValue().setEmployeeId(supportStaff.getKey());
        }
    }

    public void runSchool() {
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
            String input1 = nextLine();
            switch (input1.toUpperCase()) {
                case "A":
                    caseA();
                    break;
                case "B":
                    runB();
                    break;

                case "C":
                    runC();
                    break;

                case "D":
                    runD();
                    break;

                case "E":
                    runE();
                    break;

                case "F":
                    caseF();
                    break;
                case "G":
                    System.out.println("[G] School Details");
                    System.out.println(schoolDetails());
                    break;
                case "H":
                    System.out.println("Thank you.");
                    isOpen = false;
                    break;
                default:
                    System.out.println("Option not found!");
                    break;
            }
        }
    }

    private void runB() {
        int input1 = 0;
        while (input1 != 4) {
            System.out.println("[B] Student");
            System.out.println("\t1. Add Student");
            System.out.println("\t2. Show Student Details");
            System.out.println("\t3. Pay Fee");
            System.out.println("\t4. Go Back");
            input1 = nextInt(
                "[B] Student\n\t1. Add Student\n\t2. Show Student Details\n\t3. Pay Fee\n\t4. Go Back"
            );
            nextLine();

            if (input1 == 1) {
                System.out.print("\nName: ");
                String name = nextLine();
                System.out.print("Section: ");
                int section = nextInt("Section: ");
                Student stu = new Student(name, section);
                listClasses();
                System.out.print("Class ID: ");
                int classId = nextInt("Class ID: ");
                if (classes.get(classId) == null) {
                    System.out.println("Class not found!");
                } else {
                    stu.setClassIds(classId);
                    classes.get(classId).addStudentCount();
                }
                listBuses();
                System.out.print("\nBus ID: ");
                int busId = nextInt("\nBus ID: ");
                if (buses.get(busId) == null) {
                    System.out.println("Bus not found");
                } else{
                    stu.setBusId(busId);
                    buses.get(busId).incOccupied();
                }
                students.put(stu.getStudentId(), stu);
            } else if (input1 == 2) {
                System.out.println("List of students:");
                int i = 1;
                for (Student student : students.values()) {
                    System.out.println((i++) + ". " + student.getStudentName() + " " + student.getStudentId());
                }
                System.out.println(students.size() + ". Show All");
                System.out.println("Choose which student you want to see the details (input ID)");
                int stuID = nextInt("Choose which student you want to see the details (input ID)");nextLine();
                if (stuID == students.size()) {
                    for (Student std : students.values()) {
                        System.out.println(twolines);
                        System.out.println(std.studentDetails());
                    }
                } else {
                    System.out.println(students.get(stuID).studentDetails());
                }
            } else if (input1 == 3) {
                System.out.println("Students pay fees");
            } else if (input1 == 4) {
                // loop again
            } else {
                System.out.println("Option not found!");
            }
        }
    }

    private void runC() {
        int input1 = 0;
        while (input1 != 3) {
            System.out.println("[C] Employee");
            System.out.println("\t1. Teacher");
            System.out.println("\t2. Support Staff");
            System.out.println("\t3. Go Back");
            input1 = nextInt(
                "[C] Employee\n\t1. Teacher\n\t2. Support Staff\n\t3. Go Back"
            );nextLine();
            if (input1 == 1) {
                String input2 = "";
                while (!input2.equalsIgnoreCase("c")) {
                    System.out.println("1. Teacher");
                    System.out.println("\ta. Show Teacher Details");
                    System.out.println("\tb. Receive Salary");
                    System.out.println("\tc. Go Back");
                    input2 = next(); nextLine();
                    if (input2.equalsIgnoreCase("a")) {
                        System.out.println("List of Teacher:");
                        int numbering = 1;
                        for (Teacher teacher : teachers.values()) {
                            System.out.println(
                                    numbering++ + ". " + teacher.getEmployeeId() + " " + teacher.getEmployeeName());
                        }
                        System.out.println(numbering + ". Show All");
                        System.out.println("Choose which teacher you want to see the details (input ID)");
                        int input3 = nextInt("Choose which teacher you want to see the details (input ID)");nextLine();
                        if (input3 == numbering) {
                            numbering = 1;
                            for (HashMap.Entry<Integer, Teacher> teacher : teachers.entrySet()) {
                                System.out.println(twolines);
                                System.out.print(numbering++ + ". " + teacher.getValue().employeeDetails());
                                System.out.println(departments.get(teacher.getKey()));
                            }
                        } else {
                            Teacher teacher = teachers.get(input3);
                            if (teacher == null) {
                                System.out.println("Teacher not found");
                            } else {
                                System.out.print(teacher.employeeDetails());
                                System.out.println(departments.get(teacher.getDepartmentId()));
                            }
                        }
                    } else if (input2.equalsIgnoreCase("b")) {
                        System.out.println("Teachers take salary");
                    } else if (input2.equalsIgnoreCase("c")) {
                        // loop again
                    } else {
                        System.out.println("Option not found!");
                    }
                }
            } else if (input1 == 2) {
                String input2 = "";
                while (!input2.equalsIgnoreCase("c")) {
                    System.out.println("1. Support Staff");
                    System.out.println("\ta. Show Support Staff Details");
                    System.out.println("\tb. Receive Salary");
                    System.out.println("\tc. Go Back");
                    input2 = nextLine();
                    if (input2.equalsIgnoreCase("a")) {
                        System.out.println("List of Support Staff:");
                        int numbering = 1;
                        for (SupportStaff supportStaff : supportStaffs.values()) {
                            System.out.println(
                                    numbering++ + ". " + supportStaff.getEmployeeId() + " "
                                            + supportStaff.getEmployeeName());
                        }
                        System.out.println(numbering + ". Show All");
                        System.out.println("Choose which support staff you want to see the details (input ID)");
                        int input3 = nextInt("Choose which support staff you want to see the details (input ID)"); nextLine();
                        if (input3 == numbering) {
                            numbering = 1;
                            for (HashMap.Entry<Integer, SupportStaff> supportStaff : supportStaffs.entrySet()) {
                                System.out.println(twolines);
                                System.out.print(numbering++ + ". " + supportStaff.getValue().employeeDetails());
                                System.out.println(departments.get(supportStaff.getKey()));
                            }
                        } else {
                            SupportStaff supportStaff = supportStaffs.get(input3);
                            if (supportStaff == null) {
                                System.out.println("Teacher not found");
                            } else {
                                System.out.print(supportStaff.employeeDetails());
                                System.out.println(departments.get(supportStaff.getDepartmentId()));
                            }
                        }
                    } else if (input2.equalsIgnoreCase("b")) {
                        System.out.println("Support Staffs take salary");
                    } else if (input2.equalsIgnoreCase("c")) {
                        // loop again
                    } else {
                        System.out.println("Option not found!");
                    }
                }
            } else if (input1 == 3) {
                // loop again
            } else {
                System.out.println("Option not found!");
            }
        }
    }

    private void runD() {
        int input1 = 0;
        while (input1 != 4) {
            System.out.println("[D] Class");
            System.out.println("\tChoose which class do you want to edit (Class ID)");
            int numbering = 1;
            for (HashMap.Entry<Integer, Classroom> classroom : classes.entrySet()) {
                System.out.println(numbering++ + ". " + classroom.getKey() + " " + classroom.getValue().getClassName());
            }
            System.out.println(numbering + ". Go Back");
            int cID = nextInt(
                "[D] Class\n\tChoose which class do you want to edit (Class ID)"
            ); nextLine();
            if(cID == numbering) break;
            Classroom classroom = classes.get(cID);
            if (classroom == null) {
                System.out.println("Classroom not found!");
                continue;
            }

            System.out.println("Class " + classroom.getClassName());
            System.out.println("\t1. Add Students");
            System.out.println("\t2. Assign Teacher");
            System.out.println("\t3. Show Details");
            System.out.println("\t4. Go Back");
            input1 = nextInt(
                "Class " + classroom.getClassName() +
                "\n\t1. Add Students\n\t2. Assign Teacher\n\t3. Show Details\n\t4. Go Back"
            );nextLine();
            if (input1 == 1) {
                listStudents();
                System.out.print("Input Student ID you want to assign to the class: ");
                int stdID = nextInt("Input Student ID you want to assign to the class: "); nextLine();
                while (students.get(stdID) == null) {
                    System.out.println("Student not Found!");
                    stdID = nextInt("Student not Found!");nextLine();
                }
                students.get(stdID).setClassIds(classroom.getClassId());
                classroom.addStudentCount();
            } else if (input1 == 2) {
                listTeachers();
                System.out.print("Input Teacher ID you want to assign to the class: ");
                int tchID = nextInt("Input Teacher ID you want to assign to the class: ");
                while (teachers.get(tchID) == null) {
                    System.out.println("Teacher not found!");
                    tchID = nextInt("Teacher not found!");
                }
                classroom.setTeacherId(tchID);
            } else if (input1 == 3) {
                System.out.println(classroom.classDetails());
            } else if (input1 == 4) {
                // loop again
            } else {
                System.out.println("Option not found!");
            }
        }
    }

    private void runE() {
        int input1 = 0;
        while (input1 != 3) {
            System.out.println("[E] Notice Board");
            System.out.println("\t1. Display");
            System.out.println("\t2. Add Content");
            System.out.println("\t3. Go Back");
            input1 = nextInt(
                "[E] Notice Board\n\t1. Display\n\t2. Add Content\n\t3. Go Back"
            );nextLine();
            if (input1 == 1) {
                System.out.println( noticeBoard.display());
            } else if (input1 == 2) {
                System.out.println("Input the news you want to add:");
                String news = nextLine();
                noticeBoard.getNewsList().add(news);
            } else if (input1 == 3) {
                // loop again
            } else {
                System.out.println("Option not found!");
            }
        }
    }

    void caseA() {
        boolean loop = true;
        while (loop) {
            System.out.println("[A] Bus");
            System.out.println("\t1. Add Bus");
            System.out.println("\t2. Show Bus Details");
            System.out.println("\t3. Show Seats");
            System.out.println("\t4. Go Back");
            int choose = nextInt(
                "[A] Bus\n\t1. Add Bus\n\t2. Show Bus Details\n\t3. Show Seats\n\t4. Go Back"
            );
            nextLine();
            switch (choose) {
                case 1 -> addBus();
                case 2 -> showBusDetails();
                case 3 -> showBusSeats();
                case 4 -> loop = false;
            }
        }
    }

    void addBus() {
        System.out.print("Driver ID: ");
        int driverId = nextInt("Driver ID: ");nextLine();
        System.out.println("Bus Number: ");
        int busNumber = nextInt("Bus Number: ");nextLine();
        System.out.println("Bus Capacity: ");
        int capacity = nextInt("Bus Capacity: ");nextLine();
        System.out.println("Bus added successfully.");
        Bus bus = new Bus(driverId, busNumber, capacity);
        buses.put(bus.getBusId(), bus);
    }

    void showBusDetails() {
        listBuses();
        System.out.println((buses.size() + 1) + ". Show All");
        System.out.println("Choose which bus you want to see the details (input ID)");
        int input = nextInt("Choose which bus you want to see the details (input ID)");
        if (input == buses.size() + 1) {
            int numbering = 1;
            for (HashMap.Entry<Integer, Bus> bus : buses.entrySet()) {
                System.out.println(twolines);
                System.out.print(numbering++ + ". " + bus.getValue().busDetails());
            }
        } else {
            Bus bus = buses.get(input);
            if (bus == null) {
                System.out.println("Bus not found");
            } else {
                System.out.print(bus.busDetails());
            }
        }
    }

    void showBusSeats() {
        listBuses();
        System.out.println("Choose which bus you want to see the seats (input ID)");
        int busID = nextInt("Choose which bus you want to see the seats (input ID)");
        nextLine();
        if (busID == buses.size() + 1) {
            int numbering = 1;
            for (Bus bus : buses.values()) {
                System.out.println(twolines);
                System.out.println(numbering++ + ". Bus " + bus.getBusId());
                bus.showSeats();
            }
            return;
        }
        Bus bus = buses.get(busID);
        if(bus == null){
            System.out.println("Bus not found!");
            return;
        }
        bus.showSeats();
    }

    void listBuses() {
        System.out.println("List of buses: ");
        int numbering = 1;
        for (Bus bus : buses.values()) {
            System.out.println(
                    numbering++ + ". Bus " + bus.getBusId());
        }
    }

    void listClasses() {
        System.out.println("List of classes: ");
        int numbering = 1;
        for (Classroom classroom : classes.values()) {
            System.out.println(
                    numbering++ + ". Class " + classroom.getClassId());
        }
    }
    void listStudents(){
        System.out.println("List of students: ");
        int numbering = 1;
        for (Student stu : students.values()) {
            System.out.println(
                    numbering++ + ".  " + stu.getStudentId()+ " " + stu.getStudentName());
        }
    }
    void listTeachers(){
        System.out.println("List of teachers: ");
        int numbering = 1;
        for (Teacher teacher : teachers.values()) {
            System.out.println(
                    numbering++ + ".  " + teacher.getEmployeeId()+ " " + teacher.getEmployeeName());
        }
    }

    void caseF() {
        boolean loop = true;
        while (loop) {
            System.out.println("[F] Auditorium");
            System.out.println("\t1. Book Auditorium");
            System.out.println("\t2. Show Event Details");
            System.out.println("\t3. Show Seats");
            System.out.println("\t4. Go Back");
            int choose = nextInt(
                "[F] Auditorium\n\t1. Book Auditorium\n\t2. Show Event Details\n\t3. Show Seats\n\t4. Go Back"
            );
            nextLine();
            switch (choose) {
                case 1 -> caseFChoose1(auditorium);
                case 2 -> caseFChoose2(auditorium);
                case 3 -> caseFChoose3(auditorium);
                case 4 -> loop = false;
            }
        }
    }

    void caseFChoose1(Auditorium auditorium) {
        if(auditorium.getIsOccupied()){
            System.out.println("The Auditorium is occupied");
            return;
        }
        System.out.print("Enter the event name: ");
        String eventName = nextLine();
        System.out.println("Enter the event date: ");
        int eventDate = nextInt("Enter the event date: ");nextLine();
        System.out.print("Enter event time: ");
        int eventTime = nextInt("Enter event time: ");nextLine();
        System.out.println("Enter seats booked: ");
        int seatsOccupied = nextInt("Enter seats booked: ");nextLine();
        while(auditorium.getSeatsOccupied() - seatsOccupied < 0){
            System.out.print("Insufficient seats on the auditorium! enter again: ");
            seatsOccupied = nextInt("Insufficient seats on the auditorium! enter again: ");nextLine();
        }
        auditorium.bookAuditorium(eventName, eventDate, eventTime, seatsOccupied);
    }

    void caseFChoose2(Auditorium auditorium) {
        if (auditorium == null){
            System.out.println("There are no auditorium");
            return;
        }
        String eventDetails = auditorium.eventDetails();
        System.out.println(eventDetails);

    }

    void caseFChoose3(Auditorium auditorium) {
        if (auditorium == null)
            return;
        auditorium.displaySeats();
        return;
    }
    
    static int nextInt(String str) {
        while (true) {
            try {
                int num = sc.nextInt();
                return num;
            } catch (Exception e) {
                System.out.println("----> Invalid input!");
                System.out.print(str);
                sc.nextLine(); // important: clear invalid input
            }
        }
    }
    static String nextLine(){
        try{
            return sc.nextLine();
            } catch(Exception e){
                System.out.println("Invild input! <use only string>");
                return " ";
            }
    }
    static String next(){
        try{
        return sc.next();
        } catch(Exception e){
            System.out.println("Invild input! <use only string>");
            return " ";
        }
    }}

