package RAYYAN;
import java.util.ArrayList;
import java.util.HashMap;

public class SchoolManagement {
    private String schoolName, address, mediumOfStudy;
    private int contactNumber;
    private Relations relations;
    private ArrayList<Classroom> classList;
    private ArrayList<Employee> employeeList;

    public SchoolManagement(){

    }
    public SchoolManagement(String schoolName, String address, int contactNumber, String mediumOfStudy){
        this.schoolName = schoolName;
        this.address = address;
        this.contactNumber = contactNumber;
        this.mediumOfStudy = mediumOfStudy;
        classList = new ArrayList<>();
        employeeList = new ArrayList<>();
    }
    
    // setter
    public void setSchoolName(String schoolName){
        this.schoolName = schoolName;
    }
    public void setContactNumber(int contactNumber){
        this.contactNumber = contactNumber;
    }
    public void setAddress(String address){
        this.address = address;
    }
    public void setMediumOfStudy(String mediumOfStudy){
        this.mediumOfStudy = mediumOfStudy;
    }
    public void addClassroom(Classroom c){
        this.classList.add(c);
    }
    public void addEmployee(Employee e){
        this.employeeList.add(e);
    }
    
    
    // getter
    public String getSchoolName(){
        return schoolName;
    }
    public String getAddress(){
        return address;
    }
    public int getContactNumber(){
        return contactNumber;
    }
    public String getMediumOfStudy(){
        return mediumOfStudy;
    }
    public Object[] getClassroom(){
        return classList.toArray();
    }
    public Object[] getEmployee(){
        return employeeList.toArray();
    }
    
    //methods
    public boolean isOpen(){
        return true;
    }
    public String schoolDetails(){
        return String.format("School Name:  %s\nAddress:        %s\nContact:        %d\nMedium of Study: %s", schoolName, address, contactNumber, mediumOfStudy);
    }

    // relation class
    class Relations{
        private HashMap<Integer, Employee> employeeMap;

        Relations(){
            employeeMap = new HashMap<>();
        }

        public void addEmployee(int id, Employee e){
            employeeMap.put(id, e);
        }

        public String getEmployee(int id){
            Employee e = employeeMap.get(id);
            if (e == null) {
                return "404: Not Found!";
            }
            return e.getEmployeeName() + "\n";
        }
    }

}
