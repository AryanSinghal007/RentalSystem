public class Rental {

    Car car;
    Customer customer;
    public int noOfDays;

    public Rental(Car car, Customer customer, int noOfDays) {
        this.car = car;
        this.customer = customer;
        this.noOfDays = noOfDays;
    }
    
    public Car getCar() {
        return car;
    }

    
    public Customer getCustomer() {
        return customer;
    }


    public int getNoOfDays() {
        return noOfDays;
    }
}