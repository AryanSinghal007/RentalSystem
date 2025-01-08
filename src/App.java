public class App {
    public static void main(String[] args) throws Exception {
        
        Car car1 = new Car(1,"Civic","Honda",true,15000);
        Car car2 = new Car(2,"Camry","Toyota",true,30000);
        Car car3 = new Car(3,"X5","BMW",true,50000);
        Car car4 = new Car(4,"A6","Audi",true,50000);
        Car car5 = new Car(5,"Cayenne","Porsche",true,50000);


        CarRentalSystem carRentalSystem = new CarRentalSystem();
        carRentalSystem.addCar(car1);
        carRentalSystem.addCar(car2);
        carRentalSystem.addCar(car3);
        carRentalSystem.addCar(car4);
        carRentalSystem.addCar(car5);

        carRentalSystem.userMenu();

    }
}
