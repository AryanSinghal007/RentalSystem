public class Car{
    private int ID;
    private String carModel;
    private String carBrand;
    private boolean isAvailable;
    private int basePrice;

    public Car(int ID, String carModel, String carBrand, boolean isAvailable, int basePrice){
        this.ID = ID;
        this.carModel = carModel;
        this.carBrand = carBrand;
        this.isAvailable = isAvailable;
        this.basePrice = basePrice;
    }

    public void rent(){
        this.isAvailable = false;
    }
    public void returnCar(){
        this.isAvailable = true;
    }
    public int calculatePrice(Integer noOfDays){
        return basePrice * noOfDays;
    }

    // getters and setters
    public int getID() {
        return ID;
    }


    public String getCarModel() {
        return carModel;
    }

    public void setCarModel(String carModel) {
        this.carModel = carModel;
    }

    public String getCarBrand() {
        return carBrand;
    }

    public void setCarBrand(String carBrand) {
        this.carBrand = carBrand;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void setAvailable(boolean isAvailable) {
        this.isAvailable = isAvailable;
    }

    public int getBasePrice() {
        return basePrice;
    }

    public void setBasePrice(int basePrice) {
        this.basePrice = basePrice;
    }

}