package CustomerOrder;

import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class MainFunctions
{
    private static ArrayList <Customer> customerList = new ArrayList<>();
    public static Scanner scanner = new Scanner(System.in);

    public static void main(String [] args)
    {
        System.out.println("Menu:");
        int choise;
        do
        {
            System.out.println("1 - Create a customer"+"\n"+"2 - Highest value of order of customer" +
                    "\n"+"3 - Order list by date"+"\n"+ "4 - Highest seller product" +
                    "\n" + "5 - Exit");
            System.out.println("Please enter your choise: ");
            choise = scanner.nextInt();
            switch (choise)
            {
                case (1):
                    createCustomerAndOrder();
                    break;
                case (2):
                    highestValueOfOrderOfCustomers();
                    break;
                case (3):
                    customerNamesBySpecificDate();
                    break;
                case (4):
                    TheBestSellingProduct();
                    break;
                case (5):
                    System.out.println("Exit");
                    break;
                default:
                    System.out.println("Invalid choise, please try again.");
                    break;
            }
        }while (choise != 5);
    }
    private static void TheBestSellingProduct()
    {
        int maxQuantity=0;
        String newStr ="";

        for(Customer customer: customerList)
        {
            for(Order order: customer.orderList)
            {
                for (Item item : order.getItemList())
                {
                    if (item.getAmountOfProduct() > maxQuantity)
                    {
                        maxQuantity = item.getAmountOfProduct();
                        newStr = item.getProduct().toString();
                    }
                }
            }
        }
        System.out.println(newStr);
    }
    private static void customerNamesBySpecificDate()
    {
        System.out.println("Please enter the date by following order: (Year,Month,Day)");
        int Year = scanner.nextInt();
        int Month = scanner.nextInt();
        int Day = scanner.nextInt();
        ArrayList <String> stringsName = new ArrayList<>();
        Date dateByUser = new Date(Year - 1900,Month - 1,Day);

        for(Customer customer: customerList)
        {
            for(Order order : customer.getOrderList())
            {
                Date orderDate = new Date(order.getDateOfOrder().getYear(),
                        order.getDateOfOrder().getMonth(),
                        order.getDateOfOrder().getDate());
                if (dateByUser.compareTo(orderDate) == 0 )//If the date input is equal to order's date.
                {
                    String name = customer.getNameOfCustomer();
                    if (!stringsName.contains(name))//Check if wether the name is already present in stringName.
                    {
                        stringsName.add(name);
                    }
                }
            }
        }
        System.out.println(stringsName.toString());
    }
    private static void highestValueOfOrderOfCustomers()
    //עלות ההזמנה הגבוה ביותר
    {
        double highestValue=0;
        String newStr ="";

        for(Customer customer: customerList)
        {
            double sumOfOrder=0;
            for(Order order : customer.getOrderList())
            {
                sumOfOrder += order.totalPrice();
            }
            if(sumOfOrder>highestValue)
            {
                highestValue=sumOfOrder;
                newStr="The customer with the highest order price is: "+"\n"+ customer.getNameOfCustomer()+"\n"+customer.getPhoneNumber();
            }
        }
        System.out.println(newStr);
    }
    private static void createCustomerAndOrder()
    {
        String answerCustomer = new String();
        do {
            //Creating new customer//
            System.out.println("Creating new customer : " + "\n" + "Please enter details in the following order (Name , Phone number)");
            String nameOfCustomer = scanner.next();
            String phoneNumber = scanner.next();
            Customer customer = new Customer(nameOfCustomer, phoneNumber);
            customerList.add(customer);//Add customer to customerList.
            System.out.println("The customer just created successfully.\n");


            //Creating new order//
            String answerOrder = new String();
            do {
                System.out.println("Presenting item: " + "\n"
                        + "Please enter details in the following order (Name of product, price and weight):");
                String nameOfProduct = scanner.next();
                double priceOfProduct = scanner.nextDouble();
                double weightOfProduct = scanner.nextDouble();
                scanner.nextLine();
                Product product = new Product(nameOfProduct, priceOfProduct, weightOfProduct);

                //Add order to Order list//
                Date date = new Date();
                Order order = new Order(date);
                customer.addOrder(order);

                //Add item to Item list//
                System.out.println("Please enter the amount of the product:");
                int amountOfProduct = scanner.nextInt();
                scanner.nextLine();
                order.addItem(product, amountOfProduct);
                System.out.println("Product added.");

                //Creating another item//
                System.out.println("Do you want to add another product to the order? (y/n) ");
                answerOrder = scanner.next();

            } while (answerOrder.equals("y"));
            System.out.println("The order is finished");

            System.out.println("Do you want to create another customer?");
            answerCustomer = scanner.next();

        }while (answerCustomer.equals("y"));

    }
}
