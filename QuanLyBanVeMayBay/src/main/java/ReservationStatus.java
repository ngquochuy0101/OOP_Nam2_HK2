
//tinh trang cho ngoi
public interface ReservationStatus {

  public boolean requested();

  public boolean pending();

  public boolean confirmed();

  public boolean checkedIn();

  public boolean canceled();

}