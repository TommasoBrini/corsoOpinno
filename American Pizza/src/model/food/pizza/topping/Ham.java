package model.food.pizza.topping;

import model.food.pizza.Pizza;

public class Ham extends Topping{

    private final String name = "Ham";
    private final Double price = 0.99;
    private final double calories = 35;

    public Ham(Pizza pizza){
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
