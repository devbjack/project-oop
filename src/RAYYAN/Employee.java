package RAYYAN;
public class Employee {
    private int employeeId, salary, departmentId;
    private String employeeName;

    public Employee(int employeeId, String employeeName, int salary, int departmentId){
        this.employeeId = employeeId;
        this.employeeName = employeeName;
        this.salary = salary;
        this.departmentId = departmentId;
    }

    //setter
    public void setEmployeeId(int employeeId){
        this.employeeId = employeeId;
    }
    public void setSalary(int salary){
        this.salary = salary;
    }
    public void setDepartmentId(int departmentId){
        this.departmentId = departmentId;
    }
    public void setEmployeeName(String employeeName){
        this.employeeName = employeeName;
    }

    //getter
    public int getEmployeeId(){
        return employeeId;
    }
    public int getSalary(){
        return salary;
    }
    public int getDepartmentId(){
        return departmentId;
    }
    public String getEmployeeName(){
        return employeeName;
    }
    
    //methods
    public String employeeDetails(){
        return String.format("Employee ID:   %d\nName:      %s\nDepartment: %s", employeeId, employeeName, "dummy");
    }
    public boolean checkIn(){
        return true;
    }
    public void receiveSalary(){
        
    }
}
