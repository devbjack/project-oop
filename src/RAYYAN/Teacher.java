package RAYYAN;

public class Teacher extends Employee{
    public Teacher(int employeeId, String employeeName, int salary, int departmentId){
        super(employeeId, employeeName, salary, departmentId);
    }
    public Teacher(Employee employee){
        super(employee.getEmployeeId(), employee.getEmployeeName(), employee.getSalary(), employee.getDepartmentId());
    }

}
