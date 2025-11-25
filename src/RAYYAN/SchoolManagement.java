package RAYYAN;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class SchoolManagement {
    private String schoolName, address, mediumOfStudy;
    private int contactNumber;
    private NoticeBoard noticeBoard;
    private boolean isOpen = false;
    static Scanner sc = new Scanner(System.in);
    final static String twolines = "================================================";

    // data storage
    private HashMap<Integer, Teacher> teachers;
    private HashMap<Integer, SupportStaff> supportStaffs;
    private HashMap<Integer, Classroom> classes;
    private HashMap<Integer, Department> departments;
    private HashMap<Integer, Student> students;

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
        return String.format("School Name:       %s\nAddress:        %s\nContact:        %d\nMedium of Study: %s",
                schoolName, address, contactNumber, mediumOfStudy);
    }

    public void initialize(/* Auditorium auditorium, Playground playground, */NoticeBoard noticeBoard,
            Employee[] employees, Classroom[] classes/* Lab[] labs */) {
        this.noticeBoard = noticeBoard;
        initClasses(classes);
        getTeacherFromEmployee(employees);
        getSupportStaffFromEmployee(employees);
        students = new HashMap<>();
        initDept();
        initDeptMember();
    }

    private void initClasses(Classroom[] classArr) {
        for (int i = 0; i < classArr.length; i++) {
            classes.put(classArr[i].getClassId(), classArr[i]);
        }
    }

    private void initDept() {
        Department[] departments = new Department[] {
                new Department(801, "Science"),
                new Department(802, "English"),
                new Department(803, "Art")
        };
        for (int i = 0; i < departments.length; i++) {
            this.departments.put(departments[i].getDepartmentId(), departments[i]);
        }
    }

    private void initDeptMember() {
        for (Teacher teacher : teachers.values()) {
            departments.get(teacher.getDepartmentId()).setMemberList(teacher);
        }
        for (Department department : departments.values()) {
            department.setInchargeName(department.getMember(0).getEmployeeName());
        }

    }

    private void getTeacherFromEmployee(Employee[] employees) {
        for (int i = 0; i < employees.length; i++) {
            if (employees[i] instanceof Teacher) {
                teachers.put(employees[i].getEmployeeId(), new Teacher(employees[i]));
            }
        }
    }

    private void getSupportStaffFromEmployee(Employee[] employees) {
        for (int i = 0; i < employees.length; i++) {
            if (employees[i] instanceof SupportStaff) {
                supportStaffs.put(employees[i].getEmployeeId(), new SupportStaff(employees[i]));
            }
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
            String input1 = "h";
            switch (input1.toUpperCase()) {
                case "A":
                    System.out.println("[A] Bus");
                    System.out.println("\t1. Add Bus");
                    System.out.println("\t2. Show Bus Details");
                    System.out.println("\t3. Show Seats");
                    System.out.println("\t4. Go Back");

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

    private void runB() {
        int input1 = 0;
        while (input1 != 4) {
            System.out.println("[B] Student");
            System.out.println("\t1. Add Student");
            System.out.println("\t2. Show Student Details");
            System.out.println("\t3. Pay Fee");
            System.out.println("\t4. Go Back");
            input1 = sc.nextInt();

            if (input1 == 1) {
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
                students.put(studentId, new Student(studentId, name, classId, section, busId));
            } else if (input1 == 2) {
                System.out.println("List of students:");
                for (int i = 0; i < students.size(); i++) {
                    System.out.println((i + 1) + ". " + students.get(i).getStudentName());
                }
                System.out.println(students.size() + ". Show All");
                System.out.println("Choose which student you want to see the details");
                int input2 = sc.nextInt();
                if (input2 == students.size()) {
                    for (Student std : students.values()) {
                        System.out.println(twolines);
                        System.out.println(std.studentDetails());
                    }
                } else {
                    System.out.println(students.get(input2 - 1).studentDetails());
                }
            } else if (input1 == 3) {
                // pay fee
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

            if (input1 == 1) {
                String input2 = "";
                while (input2.equalsIgnoreCase("c")) {
                    System.out.println("1. Teacher");
                    System.out.println("\ta. Show Teacher Details");
                    System.out.println("\tb. Receive Salary");
                    System.out.println("\tc. Go Back");
                    input2 = sc.next();
                    if (input2.equalsIgnoreCase("a")) {
                        System.out.println("List of Teacher:");
                        int numbering = 1;
                        for (Teacher teacher : teachers.values()) {
                            System.out.println(
                                    numbering++ + ". " + teacher.getEmployeeId() + " " + teacher.getEmployeeName());
                        }
                        System.out.println(numbering + ". Show All");
                        System.out.println("Choose which teacher you want to see the details (input ID)");
                        int input3 = sc.nextInt();
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
                        // receive salary
                    } else {
                        System.out.println("Option not found!");
                    }
                }
            } else if (input1 == 2) {
                String input2 = "";
                while (input2.equalsIgnoreCase("c")) {
                    System.out.println("1. Support Staff");
                    System.out.println("\ta. Show Support Staff Details");
                    System.out.println("\tb. Receive Salary");
                    System.out.println("\tc. Go Back");
                    input2 = sc.next();
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
                        int input3 = sc.nextInt();
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
                        // receive salary
                    } else {
                        System.out.println("Option not found!");
                    }
                }
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
            int cID = sc.nextInt();
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
            if (input1 == 1) {
                System.out.print("Input Student ID you want to assign to the class: ");
                int stdID = sc.nextInt();
                while (students.get(stdID) == null) {
                    System.out.println("Student not Found!");
                    stdID = sc.nextInt();
                }
                students.get(stdID).setClassId(classroom.getClassId());
            } else if (input1 == 2) {
                System.out.print("Input Teacher ID you want to assign to the class: ");
                int tchID = sc.nextInt();
                while (teachers.get(tchID) == null) {
                    System.out.println("Teacher not Found!");
                    tchID = sc.nextInt();
                }
                classroom.setTeacherId(tchID);
            } else if (input1 == 3) {
                System.out.println(classroom.classDetails());
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
            input1 = sc.nextInt();
            if(input1 == 1){
                noticeBoard.display();
            }else if(input1 == 2){
                System.out.println("Input the news you want to add:");
                String news = sc.nextLine();
                noticeBoard.getNewsList().add(news);
            }else {
                System.out.println("Option not found!");
            }
        }

    }
}
