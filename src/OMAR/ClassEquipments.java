package OMAR;

public class ClassEquipments extends Equipments{
    private int classId, benchCount, fanCount, lightCount;
    
    public ClassEquipments(int benchCount, int fanCount, int lightCount){
        this.benchCount = benchCount;
        this.fanCount = fanCount;
        this.lightCount = lightCount;
    }
    
    
    
    @Override
    public String equipmentDetails(){
        return String.format(
            "%-1s: %d\n" +  
            "%-1s: %d\n" +
            "%-1d: %s\n" +  
            "%-1s: %d\n" +  
            "%-1s: %d\n" +
            "%-1d: %d\n" 
            ,     
            "Equipment ID", this.getEquipmentId(),
            "Cost: ", this.getCost(),
            "Class ID: ", classId,
            "Bench Count: ", benchCount,
            "Fan Count: ", fanCount,
            "Light Count: ", lightCount

        );
    }

    @Override
    public void purchaseEquipment(int count, int cost) {
        System.out.println("Purchase Generic Class Equipment updated cost to: " + cost);
        super.setCost(cost);
    }
    
    @Override
    public void repair() {
        System.out.println("Maintenance team sent to Class ID: " + classId);
        System.out.println("Checking Benches, Fans, and Lights...");
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
