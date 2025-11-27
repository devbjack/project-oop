package RAYYAN;

import java.util.ArrayList;

public class Student {
    private static int defaultStudentId = 200;
    private int studentId, section, busId;
    private String studentName;
    private ArrayList<Integer> classIds;
    
    public Student(String studentName, int section){
        this.studentId = defaultStudentId++;
        this.studentName = studentName; 
        this.classIds = new ArrayList<>(); 
        this.section = section;
        this.busId = 0; 
    }

    // setter
    public void setStudentId(int studentId){
        this.studentId = studentId;
    }
    public void setStudentName(String studentName){
        this.studentName = studentName;
    }
    public void setClassIds(int classId){
        this.classIds.add(classId);
    }
    public void setSection(int section){
        this.section = section;
    }
    public void setBusId(int busId){
        this.busId = busId;
    }

    // getter
    public int getStudentId(){
        return studentId;
    }
    public String getStudentName(){
        return studentName;
    }
    public ArrayList<Integer> getClassIds(){
        return classIds;
    }
    public int getSection(){
        return section;
    }
    public int getBusId(){
        return busId;
    }

    //methods


    public String studentDetails(){
        return String.format(
            "%-1s: %-20d\n" +  
            "%-1s: %-20s\n" +  
            "%-1s: %-20s\n" +  
            "%-1s: %-20d\n",     
            "Student ID ", studentId,
            "Name ", studentName,
            "Class ID ", classIds.toString(),
            "nSection ", section
        );
    }
    public void payFees(){
        
    }
}
