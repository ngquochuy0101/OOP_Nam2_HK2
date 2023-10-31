
import static java.sql.Types.NULL;

public class Airline {

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
    Flight[] a= NULL;
    return;
  }

}

