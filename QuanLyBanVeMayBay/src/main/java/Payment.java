public class Payment {

  private String field;
  
  public Payment(String field) {
    this.field = field;
  }
  public Payment(){
    
  }
  public String getField() {
    return field;
  }

  public void setField(String field) {
    this.field = field;
  }

  public double method(double amount) {
    // payment processing logic
    return amount; 
  }

}