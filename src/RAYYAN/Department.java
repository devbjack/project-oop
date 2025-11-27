package RAYYAN;
import java.util.ArrayList;

public class Department {
    private static int defaultDepartmentId = 0;
    private int departmentId;
    private String departmentName, inchargeName;
    private ArrayList<Employee> memberList = new ArrayList<>();

    public Department(String departmentName){
        this.departmentId = defaultDepartmentId++;
        this.departmentName = departmentName;
        this.inchargeName = "";
    }
    

    // setter
    public void setDepartmentId(int departmentId){
        this.departmentId = departmentId;
    }
    public void setDepartmentName(String departmentName){
        this.departmentName = departmentName;
    }
    public void setInchargeName(String inchargeName){
        this.inchargeName = inchargeName;
    }
    public void setMemberList(Employee e){
        memberList.add(e);
    }

    // getter
    public int getDepartmentId(){
        return departmentId;
    }
    public String getDepartmentName(){
        return departmentName;
    }
    public String getInchargeName(){
        return inchargeName;
    }
    public ArrayList<Employee> getMemberList(){
        return memberList;
    }
    public Employee getMember(int i){
        return memberList.get(i);
    }

    // methods

    public String departmentDetails(){
        return String.format(
            "%-1s: %d\n" +  
            "%-1s: %s\n" +  
            "%-1s: %s\n" +  
            "%-1s: %d\n",     
            "Default Department ID: ", defaultDepartmentId,
            "Department ID: ", departmentId,
            "SepartmentcName: ", departmentName,
            "Incharge Name: ", inchargeName,
            "All Meber List: ", memberList.toString()
        );
    }
}
