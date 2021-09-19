public class Product {
    private final String name;
    private final String barCode;
    private int price;

    public Product(String name, String barCode) {
        this.name = name;
        this.barCode = barCode;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public String getBarCode() {
        return barCode;
    }

    public int getPrice() {
        return price;
    }
}
