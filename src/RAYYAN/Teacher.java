package RAYYAN;
public class Teacher extends Employee {

    public Teacher(String employeeName, int salary, int departmentId){
        super(employeeName, salary, departmentId);
    }

    public Teacher(int departmentId){
        super(departmentId);
    }

}
