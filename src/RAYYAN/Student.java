package RAYYAN;
public class Student {
    private int studentId, classId, section, busId;
    private String studentName;
    
    public Student(int studentId, String studentName, int classId, int section, int busId){
        this.studentId = studentId;
        this.studentName = studentName; 
        this.classId = classId; 
        this.section = section; 
        this.busId = busId; 
    }

    // setter
    public void setStudentId(int studentId){
        this.studentId = studentId;
    }
    public void setStudentName(String studentName){
        this.studentName = studentName;
    }
    public void setClassId(int classId){
        this.classId = classId;
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
    public int getClassId(){
        return classId;
    }
    public int getSection(){
        return section;
    }
    public int getBusId(){
        return busId;
    }

    //methods
    public String studentDetails(){
        return String.format("Student ID:   %d\nName:       %s\nClass ID:   %d\nSection:    %d\n", studentId, studentName, classId, section);
    }
    public void payFees(){
        
    }
}
