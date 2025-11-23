import java.util.Scanner;
import OMAR.SchoolManagement;
import RAYYAN.Classroom;
import OMAR.Auditorium;
// import OMAR.Bus;
import OMAR.ClassEquipments;
import OMAR.Equipments;
// import OMAR.Playground;
import RAYYAN.Classroom;
// import RAYYAN.Department;
import RAYYAN.Employee;
// import RAYYAN.HigherSecondaryStudent;
import RAYYAN.Lab;
import RAYYAN.Teacher;
// import RAYYAN.NoticeBoard;
// import RAYYAN.PrimaryStudent;
// import RAYYAN.Student;
// import RAYYAN.Teacher;
import OMAR.LabEquipments;







public class Main {
    public static void main(String [] args){
        Scanner scanner = new Scanner(System.in);
        String schoolName = scanner.next();
        String address = scanner.next();
        int contactNumber = scanner.nextInt();
        String mediumOfStudy = scanner.next();

        SchoolManagement school = new SchoolManagement(schoolName, address, contactNumber, mediumOfStudy);
        Auditorium auditorium = new Auditorium(43);

        int countOfClassroom = 1;
        
        for(int i = 0; i < countOfClassroom; i++){
            int benchCount = 0;
            int fanCount = 0;
            int lightCount = 0;
            ClassEquipments classEquipments = new ClassEquipments(benchCount,fanCount,lightCount);
            int studentCount = 0;
            String className = "dslmf";
            Classroom classroom = new Classroom(studentCount,className);
        }
        int countOfLab = 1;
        for(int i = 0; i < countOfLab; i++){
            String labName = "s;flm";
            Lab lab = new Lab(labName);     
            int countOfLabEquipments = 1;
            for(int j = 0; j < countOfClassroom; j++){
                String equipmentName = "dakl";
                int equipmentCount = 0;
                LabEquipments labEquipments = new LabEquipments(equipmentName, equipmentCount);
                int benchCount = 0;
                int fanCount = 0;
                int lightCount = 0;
                ClassEquipments classEquipments = new ClassEquipments(benchCount,fanCount,lightCount);

             }
        }

        // Employee employee = new Employee();

        int countOfTeacher = 2;

        for(int i = 0; i < countOfTeacher; i++){
            String employeeName = "sd";
            int salary = 29;
            int departmentId = 29;
            Teacher teacher = new Teacher(employeeName, salary, departmentId);
        }
        for(int i = 0; i < countOfTeacher; i++){
            String employeeName = "sd";
            int salary = 29;
            int departmentId = 29;
            Teacher teacher = new Teacher(employeeName, salary, departmentId);
        }
        

        // Lab lab = new Lab("labName", {"lab equipment"}, {"classEquipment"});

        // String schoolName = scanner.next();
        


        
        
        scanner.close();
    }
}
