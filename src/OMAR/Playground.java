package OMAR;


public class Playground {
    private int area, classId;
    
    public Playground(int area){
        this.area = area;
    }

    
    
    boolean IsOccupied(int classId){
        if(classId != 0) return true;
        return false;
    }
    
    // setter
    public void setArea(int area){
        this.area = area;
    }
    public void setClassId(int classId){
        this.classId = classId;
    }
    

    // getter
    public int getArea(){
        return this.area;
    }
    public int getClassId(){
        return  this.classId;
    }

}
