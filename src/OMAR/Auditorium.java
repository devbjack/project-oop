public class Auditorium {
    private int totalSeats, seatsOccupied, eventDate, eventTime;
    private String eventName;
    
    public Auditorium(){

    }
    // setter
    public void setTotalSeats(int totalSeats){
        this.totalSeats = totalSeats;
    }
    public void setSeatsOccupied(int seatsOccupied){
        this.seatsOccupied = seatsOccupied;
    }
    public void setEventDate(int eventDate){
        this.eventDate = eventDate;
    }
    public void setEventTime(int eventTime){
        this.eventTime = eventTime;
    }

    public void setEventName(String eventName){
        this.eventName = eventName;
    }

    // getter
    public int getTotalSeats(){
        return this.totalSeats;
    }
    public int getSeatsOccupied(){
        return  this.seatsOccupied;
    }
    public int getEventDate(){
        return  this.eventDate;
    }
    public int getEventTime(){
        return  this.eventTime;
    }
    public String getEventName(){
        return this.eventName;
    }
}
