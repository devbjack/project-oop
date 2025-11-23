public class Lab {
    private int labId, inchargeId, equipmentId;
    private String labName;

    public Lab(){

    }

    //setter
    public void setLabId(int labId){
        this.labId = labId;
    }
    public void setInchargeId(int inchargeId){
        this.inchargeId = inchargeId;
    }
    public void setEquipmentId(int equipmentId){
        this.equipmentId = equipmentId;
    }
    public void setLabName(String labName){
        this.labName = labName;
    }

    //getter
    public int getLabId(){
        return labId;
    }
    public int getInchargeId(){
        return inchargeId;
    }
    public int getEquipmentId(){
        return equipmentId;
    }
    public String getLabName(){
        return labName;
    }
    //methods
    public String labDetails(){
        return String.format("Lab ID:       %d\nName:      %s\nIn-Charge:       %s\nEquipment ID:   %d", labId, labName, "dummy", equipmentId);
    }
    public boolean isOccupied(){
        return true;
    }
    public void payFine(){
        
    }
}
