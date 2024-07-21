package CompanyCar;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class CarDealership {
    static Scanner sc = new Scanner(System.in);//scanner field I can use here.

    /**
     * @param list getting random list and sorted it by its own compare to
     * @param <T>
     */
    public static <T extends Comparable<T>> void sortingObject(ArrayList<T> list) {
        Collections.sort(list);
        //By calling to Collections class it goes to the compare to of the class
        //and sorted it by the rules I made.
        Collections.reverse(list);

        for (T object : list) {
            System.out.println(object.toString() + "\n");
        }
    }

    public static void main()
    {
        //Change the path that adjust to the CarDealership file location
        File file = new File("C:\\Users\\ofirr\\Desktop\\Sold.txt");//Creating new object of file
        PrintWriter printWriterSoldFile = null;
        try {
            printWriterSoldFile = new PrintWriter(new FileWriter(file, true));
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        int choiseOfUser = 0;
        //list of car and emplyee objects.
        ArrayList<Car> carArrayList = carArrayList();
        ArrayList<Employee> employeeArrayList = employeeArrayList();

        do {
            System.out.println("\nThe menu: \n 1 - Employee list of company \n 2 - Car that has not been sold." +
                    " \n" + " 3 - Selling a car \n 4 - Add a car to the selling list \n 5 - Exit");
            choiseOfUser = sc.nextInt();
            switch (choiseOfUser) {
                case 1:
                    EmployeeListofCompany(employeeArrayList);
                    break;
                case 2:
                    CarThatHasNotBeenSold(carArrayList);
                    break;
                case 3:
                    SellingACar(employeeArrayList, carArrayList, printWriterSoldFile);
                    break;
                case 4:
                    AddACarToTheSellingList(carArrayList);
                    break;
                case 5:
                    Exit(carArrayList,printWriterSoldFile);
                default:
                    System.out.println("Thank you.");
            }
        } while (choiseOfUser != 5);
    }

    private static void Exit(ArrayList<Car> carArrayList,PrintWriter printWriterSoldFile) {
        try {
            //Change the path that adjust to the CarDealership file location
            File file = new File("C:\\Users\\ofirr\\Desktop\\CarDealership.txt");
            int numOfCar = 0;
            /**
             * Numbers of cars in the list
             */
            for (Car car : carArrayList) {
                numOfCar++;
            }
            PrintWriter printwriter = new PrintWriter(file);
            printwriter.println(numOfCar);
            for (Car car : carArrayList) {
                printwriter.print(car.getIdOfCar() + " " + car.getCreatedYear() + " " +
                        car.getNameOfCreator() + " " + car.getKm() + " " + car.getPrice() + " ");
                printwriter.println();
            }
            System.out.println("New list created");
            printwriter.close();
            printWriterSoldFile.close();

        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }

    private static void SellingACar(ArrayList<Employee> employeeArrayList, ArrayList<Car> carArrayList, PrintWriter soldFile) {
        Employee employeeChoosen = null;
        Car carOfUser = null;
        //Employee choose//
        System.out.println("These are the sellers : \n Please choose the ID of the seller");
        int i = 0;
        for (Employee employee : employeeArrayList) {
            System.out.print(i + " - ");
            i++;
            System.out.println(employee.toString());
        }
        boolean flagOfId = false;
        do {
            System.out.println("Please enter id : ");
            boolean flag = true;

            String idOfSeller = sc.next();
            try {
                for (Employee employee : employeeArrayList) {
                    if (employee.getId().equals(idOfSeller) && flag == true) {
                        flag = false;
                        flagOfId = false;
                        employeeChoosen = employee;
                        System.out.println("This is the choosen employee :");
                        System.out.println(employeeChoosen.toString());
                    }
                }
                if (flag == true) {
                    throw new Exception("Id is not defined\n Please try again");
                }
            } catch (Exception e) {
                System.out.println(e.getMessage());
                flagOfId = true;
            }
        } while (flagOfId == true);

        //Car choose//

        int z = 0;
        boolean flagOfIdCar = true;
        boolean flag1 = true;

        System.out.println("\nThese are the car : ");
        for (Car car : carArrayList) {
            System.out.println(z + " - " + car.toString());
            z++;
        }
        do {
            System.out.println("Please enter the ID of the car : ");
            String idOfCar = sc.next();
            try {
                for (Car car : carArrayList) {
                    if (car.getIdOfCar().equals(idOfCar) && flag1 == true) {
                        flag1 = false;
                        flagOfIdCar = false;
                        carOfUser = car;
                        System.out.println("This is the car detail: \n" + carOfUser.toString());
                    }
                }
                if (flag1 == true) {
                    flagOfIdCar = true;
                    throw new Exception("Id of is not defined \n Please try again");
                }
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        } while (flagOfIdCar == true);
//        soldFile.println(carOfUser.getIdOfCar() + " " + carOfUser.getCreatedYear() + " " + carOfUser.getNameOfCreator()
//                + " " + carOfUser.getKm() + " " + carOfUser.getPrice());

        carArrayList.remove(carOfUser);
        System.out.println(("Car removed from the list"));
        //Adding the sold car to the sold File from the Emplyee class.
        employeeChoosen.employeeSellingCar(carOfUser, soldFile);


    }

    /**
     * All the cars that are still available
     *
     * @param carArrayList
     */
    private static void CarThatHasNotBeenSold(ArrayList<Car> carArrayList) {
        for (Car car : carArrayList)
            System.out.println(car.toString());
    }
    private static void AddACarToTheSellingList(ArrayList carArrayList) {
        System.out.println("Enter the details of the car \n ");
        try {
            System.out.println("idOfCar : ");
            String id = sc.next();
            System.out.println("Created year : ");
            int createdYear = sc.nextInt();
            System.out.println("Name of creator : ");
            String nameOfCreator = sc.next();
            System.out.println("Km of the car : ");
            int km = sc.nextInt();
            System.out.println("Price of car : ");
            double price = sc.nextDouble();

            /**
             * we send the details to the constructor of car and over there we have throwing exceptions
             * to each parameter and here we have the catch of the execptions
             */
            Car newCar = new Car(id, createdYear, nameOfCreator, km, price);
            //Adding the new car to the list
            carArrayList.add(newCar);
            System.out.println("Car created");
        } catch (Exception e) {
            System.out.println(e.getMessage() + "\nCar is not created");
        }
    }

    /**
     * send all the emplyeee list to sorted method that use compare to from emplyee class
     */
    private static void EmployeeListofCompany(ArrayList employeeArrayList) {

        sortingObject(employeeArrayList);

    }

    /**
     * @return the list of all employee from the note
     */
    private static ArrayList employeeArrayList() {
        ArrayList<Employee> employeesArrayList = new ArrayList<>();

        try {
            //Change the path that adjust to the Employee file location
            File emplyeeFile = new File("C:\\Users\\ofirr\\Desktop\\Employee.txt");
            if (emplyeeFile.exists() == false)
                throw new FileNotFoundException();

            Scanner scanner = new Scanner(emplyeeFile);
            scanner.nextLine();//Pass the number of employees

            while (scanner.hasNext()) {
                String line = scanner.nextLine();
                Scanner lineScanner = new Scanner(line);

                String nameOfEmployee = lineScanner.next();
                String id = lineScanner.next();
                int numOfSales = lineScanner.nextInt();

                Employee employee = new Employee(nameOfEmployee, id);
                employee.setNumOfSales(numOfSales);
                employeesArrayList.add(employee);
                //System.out.println("Employee created");

            }
            scanner.close();
//            for (Employee object : employeesArrayList)
//                System.out.println(object.toString());
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return employeesArrayList;
    }

    /**
     * @return list of car from the note
     */
    private static ArrayList carArrayList() {

        ArrayList<Car> carList = new ArrayList();
        try {
            //Change the path that adjust to the CarDealership file location
            File file = new File("C:\\Users\\ofirr\\Desktop\\CarDealership.txt");
            if (file.exists() == false)
                throw new FileNotFoundException();
            ;
            Scanner scanner = new Scanner(file);
            scanner.nextLine();//pass the number of cars in the list
            while (scanner.hasNext()) // check if there  is still content in the file to read
            {
                String line = scanner.nextLine();//Taking the first line and so on.
                Scanner lineScanner = new Scanner(line);

                // Read the values from the line using the Scanner

                String idOfCar = lineScanner.next();
                int createdYear = lineScanner.nextInt();
                String nameOfCreator = lineScanner.next();
                int km = lineScanner.nextInt();
                double price = lineScanner.nextDouble();

                Car c1 = new Car(idOfCar, createdYear, nameOfCreator, km, price);
                carList.add(c1);
                //System.out.println("Car created");
            }
            scanner.close();
//            for (Car object : carList)
//                System.out.println(object.toString());

        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return carList;
    }

}


