import java.util.Scanner;

public class FlightSeat {

  private float fare; // loai ve
  private String reservationNumber; // Mã đặt chỗ


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
   public void setFare(Scanner sc) {
    fare=sc.nextFloat();
  }

  public void setReservationNumber(Scanner sc) {
    reservationNumber=sc.nextLine();
  }


}