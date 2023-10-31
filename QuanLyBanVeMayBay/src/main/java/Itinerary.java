
import java.util.Date;

public class Itinerary {

  private Date creationDate;
  private Airport startingAirport;
  private Airport finalAirport;

  public Itinerary(Date creationDate, Airport startingAirport, 
                   Airport finalAirport) {
    this.creationDate = creationDate;
    this.startingAirport = startingAirport;
    this.finalAirport = finalAirport;
  }

  public Date getCreationDate() {
    return creationDate;
  }

  public Airport getStartingAirport() {
    return startingAirport; 
  }

  public Airport getFinalAirport() {
    return finalAirport;
  }

  public boolean makeReservation() {
    // reservation logic
    return true;
  }

  public boolean makePayment() {
   // payment logic
   return true;
  }

}