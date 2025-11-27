package OMAR;
import java.util.ArrayList;

public class Bus {
    private static int defaultBusID = 100;
    private int busId, driverId, busNumber, capacity, occupied;
    private ArrayList<String> areaList = new ArrayList<>();
    

    
    public Bus(int driverId, int busNumber, int capacity){
        this.busId = defaultBusID++;
        this.driverId = driverId;
        this.busNumber = busNumber;
        this.capacity = capacity;
        this.occupied = 0;
    }
    

    public String busDetails(){
        String allArea = String.join(", ", areaList);
        return String.format(
            "%-1s: %d\n" +  
            "%-1s: %d\n" +  
            "%-1s: %d\n" +  
            "%-1s: %d\n" +
            "%-1s: %s\n",     
            "Lab ID", busId,
            "Bus ID ", driverId,
            "Driver ID ", busNumber,
            "Capacity ", capacity,
            "Area List ", allArea
        );
    }
    
    public void showSeats(){
        System.out.println("Capacity: " + capacity);
        System.out.println("Available: " + (capacity-occupied));
    }
    public void incOccupied(){
        occupied++;
    }
    
    
    // setter
    public void setBusId(int busId){
        this.busId = busId;
    }
    public void setDriverId(int driverId){
        this.driverId = driverId;
    }
    public void setBusNumber(int busNumber){
        this.busNumber = busNumber;
    }
    public void setCapacity(int capacity){
        this.capacity = capacity;
    }
    public void setAreaList(String o){
          areaList.add(o);
    }
    public void setOccupied(int occupied){
        this.occupied = occupied;
    }

    // getter
    public int getBusId(){
        return this.busId;
    }
    public int getDriverId(){
        return  this.driverId;
    }
    public int getBusNumber(){
        return  this.busNumber;
    }
    public int getCapacity(){
        return  this.capacity;
    }
    public Object getAreaList(){
        return this.areaList;
    }
    public int getOccupied(){
        return occupied;
    }


}
