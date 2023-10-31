public interface PaymentStatus {

  public boolean unpaid();
  
  public boolean pending();
  
  public boolean completed();

  public boolean failed();

  public boolean declined();

  public boolean cancelled();

  public boolean abandoned();

}