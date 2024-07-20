package CompanyCar;

import java.io.PrintWriter;

public class Car {
    /**
     * Fields of Class
     */
    private String idOfCar;
    private int createdYear;
    private String nameOfCreator;
    private int km;
    private double price;

    /**
     *
     * @param idOfCar
     * @param createdYear
     * @param nameOfCreator
     * @param km
     * @param price
     * @throws Exception any time I use this constructor I will use try and catch to get the execption
     */
    public Car(String idOfCar, int createdYear, String nameOfCreator, int km, double price) throws Exception {
        if (idOfCar.length() != 6) {
            throw new Exception("IdOfCar must be exactly 6 digits");
        } else this.idOfCar = idOfCar;

        if (createdYear < 2017 || createdYear > 2023) {
            throw new Exception("Created year must be between 2017-2023");
        } else this.createdYear = createdYear;

        this.nameOfCreator = nameOfCreator;
        if(km<0)
            throw new Exception("Km must be positive");
        this.km = km;

        if (price < 0)
            throw new Exception("Price must be positive");
        else this.price = price;
    }

    public String toString() {
        return idOfCar + " " + createdYear + " " + nameOfCreator + " " + km + " " + price;
    }

    /**
     * Method that lowering the value of the car but has 2 coinditions:
     * 1) precentage must be positive
     * 2)the new value can not be more than 5000US compare to the old value
     * @param precentage
     */
    public void loweringValueOfCar(double precentage)
    {
        try {
            if (precentage < 0)
            {
                throw new Exception("Percentage must be positive");
            }
            double newPercentage = 100 - precentage;
            double oldPrice = price;
            price = (price * newPercentage) / 100;

            if ((oldPrice - price) >= 5000)
            {
                throw new Exception("The reduction in value is too high");
            }
            System.out.println(price);

        } catch (Exception e)
        {
            System.out.println(e.getMessage());
        }
    }

    /**
     * get flie of PrintWriter and put the car details inside it.
     * @param file
     */
    public void sellingCar(PrintWriter file)
    {
        file.write(this.toString() + "\n");
        //No close here because we need to use it more.
    }
    public String getIdOfCar() {
        return idOfCar;
    }
    public int getCreatedYear() {
        return createdYear;
    }
    public String getNameOfCreator() {
        return nameOfCreator;
    }
    public int getKm() {
        return km;
    }
    public double getPrice() {
        return price;
    }
}


