package RAYYAN;

public class Teacher extends Employee{
    public Teacher(String employeeName, int salary, int departmentId){
        super(employeeName, salary, departmentId);
    }
    public Teacher(Employee employee){
        super(employee.getEmployeeName(), employee.getSalary(), employee.getDepartmentId());
    }

}
