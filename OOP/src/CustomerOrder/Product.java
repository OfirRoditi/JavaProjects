package CustomerOrder;

public class Product
{
    public String productName;
    static int id;
    private double priceOfProduct;
    public double weight;

    public Product(String productName,double price,double weight)
    {
        int i=0;
        this.productName=productName;
        this.priceOfProduct = price;
        this.weight=weight;
        id = i;
        i++;
    }

    public Product(Product other)
    {
        this.productName=other.productName;
        this.priceOfProduct =other.priceOfProduct;
        this.weight=other.weight;
    }

    public void upProductPrice(int percentage)
    {
        this.priceOfProduct =(priceOfProduct *(100+percentage)) / 100;
    }

    public String toString()
    {
        return "Product name is :" + productName + "\n"+
                "The price is :" + priceOfProduct + "\n" +
                "The weight is :"+ weight;
    }

    public String getProductName() {
        return productName;
    }

    public static int getId() {
        return id;
    }

    public double getPriceOfProduct() {
        return priceOfProduct;
    }

    public void setPriceOfProduct(double priceOfProduct) {
        this.priceOfProduct = priceOfProduct;
    }

    public double getWeight() {
        return weight;
    }


}

