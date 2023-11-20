
import java.sql.Time;

public class FlightInstance implements FlightStatus// chuyen bay
{

  private Time departureTime; // gio khoi hanh
  private String gate; // cong

  FlightInstance() {

  }

    public Time getDepartureTime() {
        return departureTime;
    }

    public void setDepartureTime(Time departureTime) {
        this.departureTime = departureTime;
    }

    public String getGate() {
        return gate;
    }

    public void setGate(String gate) {
        this.gate = gate;
    }

  

  public boolean cancel() {
    // logic hủy chuyến bay
    return false;
    // logic hủy chuyến bay
  }

  public void updateStatus() {
    // logic cập nhật trạng thái bay
  }

  public boolean Departed() {
    return true;
  };

  public boolean InAir() {
    return true;
  };

  public boolean Arrived() {
    return true;
  };

  public boolean Canceled() {
    return true;
  };
}