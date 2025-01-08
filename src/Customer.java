public class Customer {

    private int custID;
    private String custName;

    public Customer(int custId,String custName){
        this.custID=custId;
        this.custName=custName;
    }

    public int getCustID() {
        return custID;
    }

    public void setCustID(int custID) {
        this.custID = custID;
    }

    public String getCustName() {
        return custName;
    }

    public void setCustName(String custName) {
        this.custName = custName;
    }
    
}
