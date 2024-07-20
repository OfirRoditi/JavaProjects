package CustomerOrder;

import java.util.ArrayList;
import java.util.Date;

public class Customer
{
    public String nameOfCustomer;
    public String phoneNumber;
    ArrayList <Order> orderList;//Array of orders
    public Customer(String nameOfCustomer,String phoneNumber)
    {
        this.nameOfCustomer=nameOfCustomer;
        this.phoneNumber=phoneNumber;
        this.orderList = new ArrayList<Order>();//Initializing the orderList arrays.
    }
    public void addOrder(Order order)
    {
        orderList.add(order);//Adding order to order list.
    }
    public double totalPrice(Date date)
    {
        double totalPriceOfOrder=0;

        for(Order fullOrder : orderList)//for each//run on orderList and checks for the same date//
        {
            if(fullOrder.getDateOfOrder().equals(date))//If it finds the same date in the order list it added.
            {
                totalPriceOfOrder += fullOrder.totalPrice();
            }
        }
        return totalPriceOfOrder;
    }

    @Override
    public String toString()
    {
        String newStr =
                "The name of the customer is: "
                        + nameOfCustomer+"\n"
                        +"Phone number is: "
                        + phoneNumber+"\n" + "The dates of orders are : "
                        +"\n";
        for(Order current : orderList )
        {
            newStr +=  current.getDateOfOrder()+"\n";
        }
        return newStr;
    }

    public String getNameOfCustomer() {
        return nameOfCustomer;
    }

//    public void setNameOfCustomer(String nameOfCustomer) {
//        this.nameOfCustomer = nameOfCustomer;
//    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

//    public void setPhoneNumber(String phoneNumber) {
//        this.phoneNumber = phoneNumber;
//    }

    public ArrayList<Order> getOrderList() {
        return orderList;
    }

    public void setOrderList(ArrayList<Order> orderList) {
        this.orderList = orderList;
    }
}

