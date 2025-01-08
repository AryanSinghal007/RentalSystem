public interface RentalService {
    
    
    public void rentCar(Car car , Customer customer, int noOfDays);
    public void returnCar(Car car, Customer customer);
    public void addCar(Car car);
    public void addCustomer(Customer customer);
    public void userMenu();
    
}
