
public class Employee {

    private int EMPID;
    private String name;
    private String sex;
    private int phone;
    private String email;
    private String address;

    public Employee(int EMPID, String name, String sex,
            int phone, String email, String address) {
        this.EMPID = EMPID;
        this.name = name;
        this.sex = sex;
        this.phone = phone;
        this.email = email;
        this.address = address;
    }

    public Employee() {
    }

    public int getEMPID() {
        return EMPID;
    }

    public void setEMPID(int EMPID) {
        this.EMPID = EMPID;
    }

    // other getters and setters
    public void create() {
        // logic to create employee 
    }

    public void update() {
        // logic to update employee
    }

}
