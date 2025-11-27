package RAYYAN;
public class Classroom {
    private static int defaultClassId = 400;
    private int classId, teacherId, studentCount, equipmentId;
    private String className;


    public Classroom(int studentCount, String className){
        this.studentCount = studentCount;
        this.className = className;

    }
    
    public Classroom(String className, int studentCount, int equipmentId){
        this.className = className;
        this.studentCount = studentCount;
        this.equipmentId = equipmentId;
        this.classId = defaultClassId++;
        teacherId = 0;
    }
    // setter
    public void setClassId(int classId){
        this.classId = classId;
    }
    public void setClassName(String className){
        this.className = className;
    }
    public void setTeacherId(int teacherId){
        this.teacherId = teacherId;
    }
    public void setStudentCount(int studentCount){
        this.studentCount = studentCount;
    }
    public void setEquipmentId(int equipmentId){
        this.equipmentId = equipmentId;
    }    


    // getter
    public int getClassId(){
        return classId;
    }
    public String getClassName(){
        return className;
    }
    public int getTeacherId(){
        return teacherId;
    }
    public int getStudentCount(){
        return studentCount;
    }
    public int getEquipmentId(){
        return equipmentId;
    }

    //methods
    public String classDetails(){
        return String.format(
            "%-1s: %d\n" +  
            "%-1s: %s\n" +  
            "%-1s: %s\n" +  
            "%-1s: %d\n",     
            "Class ID: ", classId,
            "Name: ", className,
            "Teacher: ", "dummy",
            "Student Count: ", studentCount
        );
    }
    public void addStudentCount(){
        this.studentCount++;
    }

}
