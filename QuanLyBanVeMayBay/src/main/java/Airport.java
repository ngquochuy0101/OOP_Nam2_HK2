public class Airport {

  private String name;
  private Address address;
  private String code;

  public Airport(String name, Address address, String code) {
    this.name = name;
    this.address = address;
    this.code = code;
  }

  public String getName() {
    return name;
  }

  public Address getAddress() {
    return address; 
  }

  public String getCode() {
    return code;
  }

  public FlightInstance[] getInstances() {
    // Trả về danh sách các chuyến bay cụ thể 
      return null;
    // Trả về danh sách các chuyến bay cụ thể 
  }

}