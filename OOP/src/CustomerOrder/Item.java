package CustomerOrder;

public class Item
{
    Product product;
    public int amountOfProduct;//Amount of product
    public Item(Product product,int amount)
    {
        this.product = new Product(product);//Deep Copy:// this ensures that this.product is a completely separate object
                                                // from the original product. Changes to one will not affect the other.
        this.amountOfProduct = amount;
    }
    public double totalPrice()
    {
        double totalPriceOfProduct = amountOfProduct * product.getPriceOfProduct() ;//amount * product price(getting it from Product class)
        return totalPriceOfProduct;
    }
    public String toString()
    {
        return product.toString()
                +"\n"
                +"The amount is : " + this.amountOfProduct
                +"\n"
                +"The total price is : "+ this.totalPrice()
                +"\n"+"\n";
    }

    public Product getProduct() {
        return product;
    }
    public int getAmountOfProduct() {
        return amountOfProduct;
    }
    public void setAmountOfProduct(int amountOfProduct) {
        this.amountOfProduct = amountOfProduct;
    }
}

