package model.franchising;

import model.Menu;

public class Franchising implements Menu {

    private String name;

    private double price;

    public Franchising(String name, double price) {
        this.name = name;
        this.price = price;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public double getPrice() {
        return price;
    }

    @Override
    public String getMenuItemLine() {
        return "item: " + name + " - price " + price;
    }
}
