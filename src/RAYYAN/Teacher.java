package RAYYAN;
<<<<<<< HEAD
public class Teacher extends Employee{
    public Teacher(int employeeId, String employeeName, int salary, int departmentId){
        super(employeeId, employeeName, salary, departmentId);
    }
=======
public class Teacher extends Employee {

    public Teacher(String employeeName, int salary, int departmentId){
        super(employeeName, salary, departmentId);
    }

    public Teacher(int departmentId){
        super(departmentId);
    }

>>>>>>> main
}
