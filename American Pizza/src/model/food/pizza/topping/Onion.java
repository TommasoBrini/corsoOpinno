package model.food.pizza.topping;

import model.food.pizza.Pizza;

public class Onion extends Topping{
    private final String name = "Onions";
    private final Double price = 0.69;
    private final double calories = 22;

    public Onion(Pizza pizza){
        super(pizza);
    }

    @Override
    public String getName() {
        return this.pizza.getName() + " + " + name;
    }

    @Override
    public double getPrice() {
        return this.pizza.getPrice() + price;
    }

    @Override
    public String getMenuItemLine() {
        return this.name + " - calories: " + this.calories + " - price: " + this.price;
    }

    @Override
    public double getCalories() {
        return this.pizza.getCalories() + calories;
    }
}
