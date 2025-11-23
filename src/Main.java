import java.util.ArrayList;
import OMAR.*;
import RAYYAN.*;




public class Main {
    public static void main(String [] args){
        String schoolName = "scanner.next()";
        String address = "scanner.next()";
        int contactNumber = 32;
        String mediumOfStudy = "scanner.next()";

        SchoolManagement school = new SchoolManagement(schoolName, address, contactNumber, mediumOfStudy);
        Auditorium auditorium = new Auditorium(43);

        int countOfClassroom = 1;
        ArrayList<Classroom> classroomList = new ArrayList<>();
        ArrayList<ClassEquipments> classEquipmentsList = new ArrayList<>();
        
        for(int i = 0; i < countOfClassroom; i++){
            int benchCount = 0;
            int fanCount = 0;
            int lightCount = 0;
            ClassEquipments classEquipments = new ClassEquipments(benchCount,fanCount,lightCount);
            classEquipmentsList.add(classEquipments);

            int studentCount = 0;
            String className = "dslmf";
            Classroom classroom = new Classroom(studentCount,className);
            classroomList.add(classroom);
        }
        
        int countOfLab = 1;
        ArrayList<Lab> labList = new ArrayList<>();

        for(int i = 0; i < countOfLab; i++){
            String labName = "s;flm";
            Lab lab = new Lab(labName);     
            int countOfLabEquipments = 1;
            
            ArrayList<LabEquipments> labEquipmentsList = new ArrayList<>();
            ArrayList<ClassEquipments> classEquipmentsList2 = new ArrayList<>();

            for(int j = 0; j < countOfClassroom; j++){
                String equipmentName = "dakl";
                int equipmentCount = 0;
                LabEquipments labEquipments = new LabEquipments(equipmentName, equipmentCount);
                labEquipmentsList.add(labEquipments);

                int benchCount = 0;
                int fanCount = 0;
                int lightCount = 0;
                ClassEquipments classEquipments = new ClassEquipments(benchCount,fanCount,lightCount);
                classEquipmentsList2.add(classEquipments);

             }
            labList.add(lab);

        }

        
        int countOfTeacher = 2;
        ArrayList<Teacher> teacherList = new ArrayList<>();
        
        for(int i = 0; i < countOfTeacher; i++){
            String employeeName = "sd";
            int salary = 29;
            int departmentId = 29;
            Teacher teacher = new Teacher(employeeName, salary, departmentId);
            teacherList.add(teacher);
        }
        int countOfTSupportStaff = 2;
        
        ArrayList<SupportStaff> supportStaffList = new ArrayList<>();

        for(int i = 0; i < countOfTSupportStaff; i++){
            String employeeName = "sd";
            int salary = 29;
            int departmentId = 29;
            SupportStaff supportStaff = new SupportStaff(employeeName, salary, departmentId);
            supportStaffList.add(supportStaff);
        }
        // Employee employee = new Employee();

        
        NoticeBoard noticeBoard = new NoticeBoard();
        
        char userInterface = 'A';

        Student student = null;
        Employee employee = null;
        Bus bus = null;
        Teacher teacher = null;
        SupportStaff supportStaff = null;
        switch(userInterface){
            case 'A': {
                int caseA = 0;
                switch(caseA){
                    case 1: {
                        int busId = 2;
                        int driverId = 2;
                        int busNumber = 2;
                        int capacity = 2;
                        bus = new Bus(busId, driverId, busNumber, capacity);
                        break;
                    }
                    case 2: {
                        String busDetails = bus.busDetails();                   
                        break;
                    }
                    case 3: {
                        String showSeats = bus.showSeats();                   
                        break;
                    }
                    case 4: {
                        // go back               
                        break;
                    }
                }
                break;
            }
            
            
            case 'B': {
                int caseB = 0;
                switch(caseB){
                    case 1: {
                        String studentName = "lskjf";
                        int classId = 2;
                        int section = 2;
                        int busId = 2;
                        student = new Student(studentName, classId, section, busId);
                        break;
                    }
                    case 2: {
                        String studentDetails = student.studentDetails();                   
                        break;
                    }
                    case 3: {
                        String payFees = student.payFees();                   
                        break;
                    }
                    case 4: {
                        // go back               
                        break;
                    }
                }
                break;
            }
            case 'C': {
                int caseC = 0;
                switch(caseC){
                case 1: {
                    int caseCTeacher = 1;
                    switch(caseCTeacher){
                        case 1: {
                            String employeeDetails = teacher.employeeDetails();
                            break;
                        }
                        case 2: {
                            boolean checkIn = teacher.checkIn();
                            break;
                        }
                        case 3: {
                                // go back
                            break;
                        }
                    }
                }
                case 2: {
                    int caseCSupportStaff = 1;
                    switch(caseCSupportStaff){
                        case 1: {
                            String employeeDetails = supportStaff.employeeDetails();
                            break;
                        }
                        case 2: {
                            boolean checkIn = supportStaff.checkIn();
                            break;
                        }
                        case 3: {
                                // go back
                            break;
                        }
                    }
                }

                case 4: {
                        // go back               
                        break;
                    }
                }
            };
            case 'D': {
                int caseD = 0;
                switch(caseD){
                    case 1: {
                        int studentId = 383;
                        student = new Student(studentId);
                        break;
                    }
                    case 2: {
                        int departmentId = 883;
                        teacher = new Teacher(departmentId);
                        break;
                    }
                    case 3: {
                        String showSeatsStudent = student.studentDetails();         
                        String showSeatsTeacher = teacher.employeeDetails(); 

                        break;
                    }
                    case 4: {
                        // go back               
                        break;
                    }
                }
                break;
            }
            case 'E': {
                int caseE = 0;
                switch(caseE){
                    case 1: {
                        String display = noticeBoard.display();
                        break;
                    }
                    case 2: {
                        noticeBoard.addContent();
                        break;
                    }
                    case 3: {
                        // go back               
                        break;
                    }
                }
                break;
            }
            case 'F': {
                int caseE = 0;
                switch(caseE){
                    case 1: {
                        String eventName = "ad";
                        int eventDate = 23;
                        int eventTime = 32;
                        int seatsOccupied = 329;
                        auditorium.bookAuditorium(eventName, eventDate, eventTime, seatsOccupied);
                        break;
                    }
                    case 2: {
                        String eventDetails =  auditorium.eventDetails();               
                        break;
                    }
                    case 3: {
                        auditorium.displaySeats();               
                        break;
                    }
                    case 4: {
                        // go back               
                        break;
                    }
                }
                break;
            }
            case 'G': {
                // schoolDetails = SchoolManagement.schoolDetails();
            }
            case 'H': {
                // exit from program
            }
            default: {
                // show the error in input
                break;
            }
        }
    }
}
