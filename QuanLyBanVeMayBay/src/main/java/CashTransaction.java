public class CashTransaction {

  private double cashTendered;

  public CashTransaction(double cashTendered) {
    this.cashTendered = cashTendered;
  }

  public double getCashTendered() {
    return cashTendered; 
  }

  public void setCashTendered(double cashTendered) {
    this.cashTendered = cashTendered;
  }

  public double calculateChange() {
    // Logic to calculate change
    return 0;
  }

}