package OMAR;
public class Equipments {
    private int equipmentId, cost;

    public Equipments(){

    }

    
    
    public String equipmentDetails(){
        return String.format(
            "%-1s: %d\n" +  
            "%-1s: %d\n",     
            "Equipment ID", equipmentId,
            "Cost: ", cost
        );
    }

    public void purchaseEquipment(int count, int cost){

    }

    public void repair(){

    }


    // setter
    public void setEquipmentId(int equipmentId){
        this.equipmentId = equipmentId;
    }  
    public void setCost(int cost){
        this.cost = cost;
    }
    

    // getter
    public int getEquipmentId(){
        return this.equipmentId;
    }
    public int getCost(){
        return  this.cost;
    }

}
