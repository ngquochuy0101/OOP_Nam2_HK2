
import static java.sql.Types.NULL;

public class Airline// hang hang khong
 {

  private String name;
  private String code;

  public Airline(String name, String code) {
    this.name = name;
    this.code = code;
  }

  public String getName() {
    return name;
  }

  public String getCode() {
    return code;
  }

  public Flight[] getFlights() {
    // return array of Flight objects operated by this airline
    Flight[] a= new Flight[1];
    return a;
  }
  
}

