package RAYYAN;
import OMAR.*;
import java.util.ArrayList;

public class Lab {
    private static int defaultlabId = 400;
    private int labId, inchargeId;
    private String labName;
    private ArrayList<LabEquipments> labEquipmentList;
    private ArrayList<ClassEquipments> classEquipmentList;
    private int[] equipmentIds;
    boolean occupied = false;

    
    public Lab(String labName, int capacityOfLabEquipment, ArrayList<LabEquipments> labEquipments) {
        this.labId = defaultlabId++;
        this.labName = labName;
        labEquipmentList = new ArrayList<LabEquipments>();
        this.labEquipmentList = labEquipments;
    }

    public String labDetails(){
        StringBuilder labBuilder = new StringBuilder();

        for (LabEquipments labEquipment : labEquipmentList) {
            labBuilder.append(labEquipment.equipmentDetails()).append("\n");
        }

        String allLabEquipmentList = labBuilder.toString();
        StringBuilder classBuilder = new StringBuilder();

        for (ClassEquipments classEquipments : classEquipmentList) {
            labBuilder.append(classEquipments.equipmentDetails()).append("\n");
        }

        String allClassEquipmentList = classBuilder.toString();
        return String.format(
            "%-1s: %d\n" +  
            "%-1s: %s\n" +  
            "%-1s: %d\n" +  
            "%-1s: %s" +  
            "%-1s: %s",     
            "Lab ID", labId,
            "Lab Name: ", labName,
            "Incharge ID: ", inchargeId,
            "All Lab Equipment List: ", allLabEquipmentList,
            "All Class Equipment List: ", allClassEquipmentList

        );
    }

    public boolean IsOccupied(){
        return occupied;
    }

    public void PayFine(Student student, String equipmentName, double fineAmount) {
        System.out.println("\n--- Lab Fine Report ---");
        System.out.println("\tStudent Name: " + student.getStudentName());
        System.out.println("\tStudent ID: " + student.getStudentId());
        System.out.println("\tDamaged Equipment: " + equipmentName);
        System.out.printf("\tFine Amount Required: %.2f SAR\n", fineAmount);
        System.out.println("\t-----------------------");
    }

    //setter  
    public void setLabId(int labId){
        this.labId = labId;
    }
    public void setInchargeId(int inchargeId){
        this.inchargeId = inchargeId;
    }
    public void setEquipmentIds(int[] equipmentIds){
        this.equipmentIds = equipmentIds;
    }
    public void setLabName(String labName){
        this.labName = labName;
    }
    public void setOccupied(boolean occupied){
        this.occupied = occupied;
    }
    //getter
    public int getLabId(){
        return labId;
    }
    public int getInchargeId(){
        return inchargeId;
    }
    public int[] getEquipmentIds(){
        return equipmentIds;
    }
    public String getLabName(){
        return labName;
    }
    public boolean getOccupied(){
        return occupied;
    }

}
