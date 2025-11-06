

public class ClassEquipments {
    private int classId, benchCount, fanCount, lightCount;
    
    public ClassEquipments(){

    }
    // setter
    public void setClassId(int classId){
        this.classId = classId;
    }
    public void setBenchCount(int benchCount){
        this.benchCount = benchCount;
    }
    public void setFanCount(int fanCount){
        this.fanCount = fanCount;
    }
    public void setLightCount(int lightCount){
        this.lightCount = lightCount;
    }


    // getter
    public int getClassId(){
        return this.classId;
    }
    public int getBenchCount(){
        return  this.benchCount;
    }
    public int getFanCount(){
        return  this.fanCount;
    }
    public int getLightCount(){
        return  this.lightCount;
    }

}
