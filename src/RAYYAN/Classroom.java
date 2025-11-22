package RAYYAN;
public class Classroom {
    private int classId, teacherId, studentCount, equipmentId;
    private String className;

    public Classroom(){

    }
    public Classroom(int classId, String className, int teacherId, int studentCount, int equipmentId){
        this.classId = classId;
        this.className = className;
        this.teacherId = teacherId;
        this.studentCount = studentCount;
        this.equipmentId = equipmentId;
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
}
