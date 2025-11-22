package RAYYAN;
import java.util.ArrayList;

public class Department {
    private int departmentId;
    private String departmentName, inchargeName;
    private ArrayList<Object> memberList = new ArrayList<>();

    public Department(){

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
    public void setMemberList(Object o){
        memberList.add(o);
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
    public Object getMemberList(){
        for (Object object : memberList) {
            return object;
        }
        return memberList;
    }

    public void departmentDetails(){
        
    }
}
