public class Employee {
    private int labId, salary, departmentId;
    private String employeeName;

    public Employee(){

    }

    //setter
    public void setLabId(int labId){
        this.labId = labId;
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
    public int getLabId(){
        return labId;
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
    
}
