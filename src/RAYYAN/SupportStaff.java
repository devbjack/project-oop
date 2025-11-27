package RAYYAN;

public class SupportStaff extends Employee{
    public SupportStaff(String employeeName, int salary, int departmentId){
        super(employeeName, salary, departmentId);
    }
    public SupportStaff(Employee employee){
        super(employee.getEmployeeName(), employee.getSalary(), employee.getDepartmentId());
    }
}