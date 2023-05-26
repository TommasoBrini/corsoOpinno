package model.food.pizza.base;

import model.food.pizza.Pizza;

public class PizzaBase implements Pizza {

    String name;
    double price;
    double calories;

    public PizzaBase(String name, double price, double caloria) {
        this.name = name;
        this.price = price;
        this.calories = caloria;
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
        return this.name + " - calories: " + this.calories + " - price: " + this.price;
    }

    @Override
    public double getCalories() {
        return this.calories;
    }
}
