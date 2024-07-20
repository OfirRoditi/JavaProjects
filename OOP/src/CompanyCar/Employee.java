package CompanyCar;

import java.io.PrintWriter;

public class Employee implements Comparable <Employee> {

    private String nameOfEmployee;
    private String id;
    private int numOfSales;

    public Employee(String nameOfEmployee, String id) throws Exception      {

            if (!nameOfEmployee.matches("[a-zA-Z]+"))
            {
                throw new Exception("Name must contain only letters");
            }
            this.nameOfEmployee = nameOfEmployee;
            if (id.length() != 9)
            {
                throw new Exception("id must contain exactly 9 numbers.");
            }
            this.id = id;
            this.numOfSales = getNumOfSales();
    }

     /**
     * we go to the sellingCar method at car class from the car object and add it to the file
     * @param car Object of car is sent
     * @param file file of PrintWriter is sent
     */
    public void employeeSellingCar(Car car, PrintWriter file)
    {
        car.sellingCar(file);
        numOfSales++;
    }
    public double employeeSalary()
    {
        double baseSalray = 6000;
        int salaryForCars = 100*this.numOfSales;
        return baseSalray+(double)salaryForCars;
    }
    public String toString()
    {
        return nameOfEmployee + " " + id + " " + numOfSales + " " +  employeeSalary() ;
    }

    /**
     *
     * @param other the object to be compared.
     * @return check witch employee has the most number of sales.
     */
    @Override
    public int compareTo(Employee other)
    {
        if(this.numOfSales == other.numOfSales)
            return 0;
        else if(this.numOfSales < other.numOfSales)
            return -1;
        else return 1;
    }
    public String getNameOfEmployee() {
        return nameOfEmployee;
    }
    public String getId() {
        return id;
    }
    public void setNumOfSales(int numOfSales) {
        this.numOfSales = numOfSales;
    }
    public int getNumOfSales() {
        return numOfSales;
    }
}
