public class FlightSeat {

  private float fare;
  private String reservationNumber;

  public FlightSeat(float fare, String reservationNumber) {
    this.fare = fare;
    this.reservationNumber = reservationNumber;
  }

  public float getFare() {
    return fare;
  }

  public String getReservationNumber() {
    return reservationNumber;
  }

}