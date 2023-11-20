import java.util.Scanner;

public class Seat implements SeatClass{

  private String seatNumber;
  private boolean SeatType;

  public Seat(String seatNumber, boolean classs) {
    this.seatNumber = seatNumber;
    this.SeatType = classs;
  }

  public String getSeatNumber() {
    return seatNumber;
  }

  public boolean getSeatType() {
    return SeatType;
  }

  public void setSeatNumber(Scanner sc) {
    seatNumber = sc.nextLine();
  }

  public boolean typeSeat() {
    if(SeatType==true)
      return true;
    return false;
  }
}