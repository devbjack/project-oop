package RAYYAN;
import OMAR.*;

import java.util.ArrayList;
import java.util.Scanner;
import OMAR.ClassEquipments;

public class Main {
    static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {

        System.out.print("Enter the name of school: ");
        String schoolName = nextLine();

        System.out.print("Enter the address of school: ");
        String address = nextLine();

        System.out.print("Enter the contact number of school: ");
        int contactNumber = nextInt("Enter the contact number of school: ");nextLine();

        System.out.print("Enter the medium of study in the school: ");
        String mediumOfStudy = nextLine();

        SchoolManagement sm = new SchoolManagement(schoolName, address, contactNumber, mediumOfStudy);


        // Auditorium
        System.out.print("Enter the audit seats of auditorium: ");
        int auditSeats = nextInt("Enter the audit seats of auditorium: ");
        Auditorium auditorium = new Auditorium(auditSeats);
        
        // Playground
        System.out.print("Enter the area of playground: ");
        int area = nextInt("Enter the area of playground: ");
        Playground playground = new Playground(area);

        // Classroom
        System.out.print("Enter how many classroom: ");
        int classRoomCount = nextInt("Enter how many classroom: "); nextLine();
        Classroom[] classes =  new Classroom[classRoomCount];
        for(int i = 0; i < classRoomCount; i++){
        System.out.print("Enter ["+ i +"] class Name of classroom: ");
        String className = nextLine();
        System.out.print("Enter ["+ i +"] class student count of classroom: ");
        int studentCount = nextInt("Enter ["+ i +"] class student count of classroom: ");
        System.out.print("Enter ["+ i +"] class equipment id of classroom: ");
        int equipmentId = nextInt("Enter ["+ i +"] class equipment id of classroom: "); nextLine();
        classes[i] = new Classroom(className, studentCount, equipmentId);
        }

        // class Equipments

        ArrayList<ClassEquipments> classEquipments = new ArrayList<>();
        for (int i = 0; i < classes.length; i++) {

        System.out.print("Enter ["+ i +"] bench count class equipments: ");
        int benchCount = nextInt("Enter ["+ i +"] bench count of the class equipments: ");

        System.out.print("Enter ["+ i +"] fan count of class equipments: ");
        int fanCount = nextInt("Enter ["+ i +"] fan count of class equipments: ");

        System.out.print("Enter ["+ i +"] light count of class equipments: ");
        int lightCount = nextInt("Enter ["+ i +"] light count of class equipments: ");

            classEquipments.add(new ClassEquipments(classes[i].getEquipmentId(), classes[i].getClassId() ,benchCount, fanCount, lightCount));
        }

        
        // Labs

        // int labCount = 1;
        System.out.print("Enter how many labs: ");
        int labCount = nextInt("Enter how many labs: "); nextLine();

        Lab[] labs = new Lab[labCount];
        for (int i = 0; i < labCount; i++) {
            System.out.print("Enter the name of lab: ");
            String labName = nextLine();
            System.out.print("Enter how many lab Equipments: ");
            int eqCapacity = nextInt("Enter how many lab Equipments: "); nextLine();
            ArrayList<LabEquipments> labEquipments = new ArrayList<>();
            for(int j = 0; j < eqCapacity; j++){
                System.out.print("Enter equipment ["+ j +"] name: ");
                String eqName = nextLine();
                System.out.print("Enter equipment ["+ j +"] count: ");
                int eqCount = nextInt("Enter equipment ["+ j +"] count: ");
                labEquipments.add(new LabEquipments(eqName, eqCount));
            }

            labs[i] = new Lab(labName, eqCapacity, labEquipments);
            System.out.print("Enter how many class Equipments: ");

            int classEq = nextInt("Enter how many class Equipments: "); 

            int [] classEquipmentIds = new int[classEq];
            for (int j = 0; j < classEquipmentIds.length; j++) {

                System.out.print("Enter ["+ i +"] bench count class equipments: ");
                int benchCount = nextInt("Enter ["+ i +"] bench count of the class equipments: ");

                System.out.print("Enter ["+ i +"] fan count of class equipments: ");
                int fanCount = nextInt("Enter ["+ i +"] fan count of class equipments: ");

                System.out.print("Enter ["+ i +"] light count of class equipments: ");
                int lightCount = nextInt("Enter ["+ i +"] light count of class equipments: "); nextLine();

                ClassEquipments ce = new ClassEquipments(labs[i].getLabId(), benchCount, fanCount, lightCount);
                classEquipments.add(ce);
                classEquipmentIds[j] = ce.getEquipmentId();
            }
            labs[i].setEquipmentIds(classEquipmentIds);
        }

        // Staffs


        ArrayList<Employee> employees = new ArrayList<>();



        System.out.print("Enter how many teacher: ");
        int teacherCount = nextInt("Enter how many teacher: "); nextLine();

        for(int i = 0; i < teacherCount; i++){

            System.out.print("Enter ["+ i +"] employee name of teacher: ");
            String employeeName = nextLine();

            System.out.print("Enter ["+ i +"] salary of teacher: ");
            int salary = nextInt("Enter ["+ i +"] salary of teacher: ");

            System.out.print("Enter ["+ i +"] department id of teacher: ");
            int departmentId = nextInt("Enter ["+ i +"] department id of teacher: "); nextLine();
            employees.add(new Teacher(employeeName, salary, departmentId)); 
        }

        System.out.print("Enter how many support staff: ");
        int employeeCount = nextInt("Enter how many support staff: "); nextLine();

        for(int i = 0; i < employeeCount; i++){

            System.out.print("Enter ["+ i +"] employee name of support staff: ");
            String employeeName = nextLine();

            System.out.print("Enter ["+ i +"] salary of support staff: ");
            int salary = nextInt("Enter ["+ i +"] salary of support staff: ");

            System.out.print("Enter ["+ i +"] department id of support staff: ");
            int departmentId = nextInt("Enter ["+ i +"] department id of support staff: "); nextLine();
            employees.add(new SupportStaff(employeeName, salary, departmentId));
        }
        



        // Notice Boards
        NoticeBoard nb = new NoticeBoard();
        nb.setNewsList("Welcome to the School");

        // init
        sm.initialize(auditorium, playground, nb, employees, classes, labs, classEquipments);
        
        System.out.println(sm.schoolDetails());
        sm.runSchool();

  
    }

    static int nextInt(String str) {
        while (true) {
            try {
                int num = scanner.nextInt();
                return num;
            } catch (Exception e) {
                System.out.println("----> Invalid input!");
                System.out.print(str);
                scanner.nextLine(); // important: clear invalid input
            }
        }
    }
    static String nextLine(){
        try{
            return scanner.nextLine();
            } catch(Exception e){
                System.out.println("Invild input! <use only string>");
                return " ";
            }
    }
    static String next(){
        try{
        return scanner.next();
        } catch(Exception e){
            System.out.println("Invild input! <use only string>");
            return " ";
        }
    }
}
