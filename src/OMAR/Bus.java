package OMAR;
import java.util.ArrayList;

public class Bus {
    private int busId, driverId, busNumber, capacity;
    private ArrayList<Object> areaList = new ArrayList<>();
    private String studentName;
    
    public Bus(){

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
    public void setAreaList(Object o){
          areaList.add(o);
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
}
