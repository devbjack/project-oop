package RAYYAN;

public class SupportStaff extends Employee{
    public SupportStaff(int employeeId, String employeeName, int salary, int departmentId){
        super(employeeId, employeeName, salary, departmentId);
    }
    public SupportStaff(Employee employee){
        super(employee.getEmployeeId(), employee.getEmployeeName(), employee.getSalary(), employee.getDepartmentId());
    }
}