public class Seat {

  private String seatNumber;
  private SeatClass classS;

  public Seat(String seatNumber, SeatClass classs) {
    this.seatNumber = seatNumber;
    this.classS = classs; 
  }

  public String getSeatNumber() {
    return seatNumber;
  }

  public SeatClass getSeatType() {
    return classS;
  }

}