import java.util.ArrayList;
import java.util.Scanner;

public class CarRentalSystem implements RentalService {

    ArrayList<Rental> rentalList = new ArrayList<Rental>();
    ArrayList<Car> carList = new ArrayList<Car>();
    ArrayList<Customer> customerList = new ArrayList<Customer>();

    public CarRentalSystem(){
        // constructor
    }

    @Override
    public void rentCar(Car car , Customer customer, int noOfDays) {
        if(car.isAvailable()){
            Rental newRental= new Rental(car, customer, noOfDays);
            rentalList.add(newRental);
            car.rent();
        }else{
            System.out.println("Car is not available");
        }
    }

    @Override
    public void returnCar(Car car, Customer customer) {

        for(Rental r : rentalList){
            if(r.car.getID() == car.getID() && r.getCustomer().getCustID() == customer.getCustID()){
               
                rentalList.remove(r);
                car.returnCar();
                break;
            }
        }
    }

    @Override
    public void addCar(Car car) {
        carList.add(car);
        
    }

    @Override
    public void addCustomer(Customer customer) {
        
        customerList.add(customer);
    }

    @Override
    public void userMenu() {

        System.out.println("--------------------------------------------------------------------------------");
        System.out.println("Welcome to the Car Rental System");
        System.out.println("1. Rent a car\n");
        System.out.println("2. Return a car\n");
        System.out.println("3. Quit\n");
        System.out.println("--------------------------------------------------------------------------------");

        int userChoice = 0;
        Scanner sc = new Scanner(System.in);

        System.out.printf("Please enter your name: ");
        String customerName = sc.nextLine();
        int customerID = customerList.size() + 1;
        Customer customer = new Customer(customerID, customerName);

        while(true){

            System.out.printf("Please enter your choice: ");
            userChoice = sc.nextInt();

            if(userChoice == 1){

                // available cars
                System.out.println("Available cars");
                for(Car c : carList){
                    if(c.isAvailable()){
                        System.out.println("Car ID: " + c.getID());
                        System.out.println("Car Model: " + c.getCarModel());
                        System.out.println("Car Brand: " + c.getCarBrand());
                        System.out.println("Car Base Price: " + c.getBasePrice());
                        System.out.println("--------------------------------------------------------------------------------");
                    }
                }

                System.out.printf("Please enter the car ID you want to rent: ");
                int carID = sc.nextInt();
                System.out.printf("Please enter the number of days you want to rent the car for: ");
                int noOfDays = sc.nextInt();

                Car car = null;
                
                addCustomer(customer);

                boolean isFound = false;
                for(Car c : carList){
                    if(c.getID() == carID && c.isAvailable()){
                        car = c;
                        isFound = true;
                        break;
                    }else{
                        continue;
                    }
                }
                    
                if(car != null && customer != null && isFound){

                    // print details of car
                    System.out.println("--------------------------------------------------------------------------------");
                    System.out.println("Car details: ");
                    System.out.println("Car ID: " + car.getID());
                    System.out.println("Car Model: " + car.getCarModel());
                    System.out.println("Car Brand: " + car.getCarBrand());
                    System.out.println("Car Base Price: " + car.getBasePrice());
                    System.out.println("Number of days: " + noOfDays);
                    System.out.println("Total price: " + car.calculatePrice(noOfDays));
                    System.out.println("--------------------------------------------------------------------------------");
                    
                    System.out.printf("Do you want to confirm the rental? (Y/N): ");
                    
                    char confirm = sc.next().charAt(0);

                    if(confirm == 'Y' || confirm == 'y'){
                        
                        rentCar(car, customer, noOfDays);
                        System.out.println("Car rented successfully");
                    }else{
                        System.out.println("Rental cancelled");
                    }
                    
                }else{
                    System.out.println("Invalid car/customer ID or car is not available");
                }

            }else if(userChoice == 2){

                System.out.printf("Please enter the car ID you want to return: ");
                int carID = sc.nextInt();

                Car car = null;
                Customer customer2 = null;

                for(Car c : carList){
                    if(c.getID() == carID && !c.isAvailable()){
                        car = c;
                        break;
                    }
                }

                for(Customer c : customerList){
                    if(c.getCustName() == customerName){
                        customer2 = c;
                        break;
                    }
                }

                if(car != null && customer2 != null){
                    returnCar(car, customer2);
                    System.out.println("Car returned successfully");
                }else{
                    System.out.println("Invalid car or customer ID");
                }

            }else if(userChoice == 3){
                System.out.println("Thank you for using the Car Rental System");
                break;
            }else{
                System.out.println("Invalid choice. Please try again.");
            }
        }

        sc.close();
        
    }
}
