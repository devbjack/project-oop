package OMAR;

public class Auditorium {
    private int totalSeats, seatsOccupied, eventDate, eventTime;
    private String eventName;
    private boolean isOccupied;
    
    public Auditorium(int totalSeats){
        this.totalSeats = totalSeats;
        this.eventName = null;
    }
    
    


    public void bookAuditorium(String eventName, int eventDate, int eventTime, int seatsOccupied){
        isOccupied = true;
        this.eventName = eventName;
        this.eventDate = eventDate;
        this.eventTime = eventTime;
        this.seatsOccupied = seatsOccupied;
    }

    public String eventDetails(){
        if(eventName==null){
            System.out.println("Auditorium has no event");
            return "\n";
        }
        return String.format(
            "%-1s: %s\n" +  
            "%-1s: %d\n" +  
            "%-1s: %d\n" +  
            "%-1s: %d\n" +
            "%-1s: %d\n",     
            "Event Name: ", eventName,
            "Total Seats: ", totalSeats,
            "Seats Occupied: ", seatsOccupied,
            "Event Date: ", eventDate,
            "Event Time: ", eventTime
        );
    }

    public void displaySeats(){
        System.out.println("Total Seats: " + totalSeats);
        System.out.println("Seats Occcupied: " + seatsOccupied);
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
    public boolean getIsOccupied(){
        return isOccupied;
    }
}

