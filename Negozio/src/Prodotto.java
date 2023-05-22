public class Prodotto {
    private String name;
    private double price;
    private int quantity;

    //COSTRUTTORE SENZA QUANTITA'
    public Prodotto(String name, double price) {
        new Prodotto(name,price,1);
    }

    public Prodotto(String name, double price, int quantity) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "Prodotto{" +
                "name='" + name + '\'' +
                ", price=" + price +
                ", quantity=" + quantity +
                '}';
    }
}
