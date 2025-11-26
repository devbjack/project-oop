package OMAR;
public class LabEquipments extends Equipments{
    private int equipmentCount;
    private String equipmentName;
    
    public LabEquipments(String equipmentName, int equipmentCount){
        this.equipmentName = equipmentName;
        this.equipmentCount = equipmentCount;

    }
    

    @Override
    public String equipmentDetails(){
        return String.format(
            "%-1s: %d\n" +  
            "%-1s: %d\n" +
            "%-1d: %s\n" +  
            "%-1s: %d\n" 
            ,     
            "Equipment ID", this.getEquipmentId(),
            "Cost: ", this.getCost(),
            "Equipment Name: ", equipmentName,
            "Equipment Count: ", equipmentCount
        );
    }

    @Override
    public void purchaseEquipment(int newCount, int newCost) {
        this.equipmentCount += newCount;
        super.setCost(newCost);
        System.out.println("Purchased " + newCount + " of " + equipmentName);
    }

    @Override
    public void repair() {
        System.out.println("Repairing Lab Equipment: " + equipmentName);
        System.out.println("Status check: Calibrating...");
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
