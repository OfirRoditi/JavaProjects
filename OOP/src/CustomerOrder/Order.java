package CustomerOrder;

import java.util.ArrayList;
import java.util.Date;

public class Order
{
    ArrayList <Item> itemList ;//Array of Items from java calsses
    private Date dateOfOrder ;//Date
    public Order(Date dateOfOrder)
    {
        this.dateOfOrder = dateOfOrder;
        this.itemList = new ArrayList<Item>();//Initializing the itemList arrays.
    }
    public Order(Order other)
    {
        this.dateOfOrder = other.dateOfOrder;
        this.itemList = other.itemList;
    }
    public void addItem (Product newProduct, int amount)
    {
        boolean flag = true;
        for (int i = 0; i < itemList.size(); i++)
        {
            if (itemList.get(i).product.getProductName().equals(newProduct.getProductName()))//If it finds the name already exist so it w'ont add it.
            {
                flag = false;
            }
        }
        if (flag == true)
        {
            Item newItem = new Item(newProduct,amount);//Creating new item
            itemList.add(newItem);//Add the new item to the itemList array.
        }

    }
    public void updateAmount(String nameOfProduct , int newAmount)
    {
        boolean flag = true;
        for(int i = 0; i<itemList.size(); i++)
        {
            if(itemList.get(i).product.getProductName().equals(nameOfProduct) && flag == true)
            {
                itemList.get(i).setAmountOfProduct(newAmount);
                flag=true;
            }
            else flag=false;

        }
        if(flag == false)
            System.out.println("The product " + nameOfProduct+ " is not existent in the item List");
    }
    public double totalPrice()
    {
        double totalPriceOfItemList = 0;
        for(int i = 0; i<itemList.size();i++)
        {
            totalPriceOfItemList += itemList.get(i).getAmountOfProduct() * itemList.get(i).product.getPriceOfProduct();
        }
        //System.out.println("The total price is ==");
        return totalPriceOfItemList;
    }

    @Override
    public String toString()
    {
        String itemDetails = "";
        for(int i = 0;i < itemList.size();i++)
        {
            itemDetails +=
                    itemList.get(i).getProduct().toString()+"\n"+"The amount is: "+itemList.get(i).getAmountOfProduct()+"\n"+
                            "The total price of the product is:" + itemList.get(i).totalPrice()+ "\n"+ "\n";

        }
        itemDetails += "The total price is of the order is :" + totalPrice();
        return itemDetails;
    }

    public ArrayList<Item> getItemList() {
        return itemList;
    }
    public void setItemList(ArrayList<Item> itemList) {
        this.itemList = itemList;
    }

    public Date getDateOfOrder() {
        return dateOfOrder;
    }

    public void setDateOfOrder(Date dateOfOrder) {
        this.dateOfOrder = dateOfOrder;
    }
}
