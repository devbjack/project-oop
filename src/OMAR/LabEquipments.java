package OMAR;
public class LabEquipments {
    private int equipmentCount;
    private String equipmentName;
    
    public LabEquipments(String equipmentName, int equipmentCount){
        this.equipmentName = equipmentName;
        this.equipmentCount = equipmentCount;


        
    }
    
    // setter
    public void setEquipmentCount(int equipmentCount){
        this.equipmentCount = equipmentCount;
    }
    public void setEquipmentName(String equipmentName){
        this.equipmentName = equipmentName;
    }


    // getter
    public int getEquipmentCount(){
        return this.equipmentCount;
    }
    public String getEquipmentName(){
        return  this.equipmentName;
    }

}
