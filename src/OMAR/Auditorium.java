package OMAR;

public class Auditorium {
    private int eventDate, eventTime, seatsOccupied, totalSeats;
    private String eventName;

    public Auditorium(int totalSeats){
        this.totalSeats = totalSeats;
    }
    


    public void bookAuditorium(String eventName, int eventDate, int eventTime, int seatsOccupied){
        this.eventName = eventName;
        this.eventDate = eventDate;
        this.eventTime = eventTime;
        this.seatsOccupied = seatsOccupied;
    }
    public String eventDetails(){
        return null;
    }
    public void displaySeats(){

    }
    
    // setter
    public void setTotalSeats(int totalSeats){
        this.totalSeats = totalSeats;
    }
    public void setSeatsOccupied(int seatsOccupied){
        this.seatsOccupied = seatsOccupied;
    }
    public void setEventName(String eventName){
        this.eventName = eventName;
    }
    public void setEventDate(int eventDate){
        this.eventDate = eventDate;
    }
    public void setEventTime(int eventTime){
        this.eventTime = eventTime;
    }


    // getter
    public int getTotalSeats(){
        return this.totalSeats;
    }
    public int getSeatsOccupied(){
        return  this.seatsOccupied;
    }
    public String getEventName(){
        return this.eventName;
    }
    public int getEventDate(){
        return  this.eventDate;
    }
    public int getEventTime(){
        return  this.eventTime;
    }
}
