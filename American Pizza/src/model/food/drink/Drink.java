package model.food.drink;

import model.food.FoodItem;

public class Drink implements FoodItem {

    private double calories;
    private String name;

    private double price;

    public Drink(String name, double calories,  double price) {
        this.calories = calories;
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
        return name + " - calories: " + calories + " - price " + price;
    }

    @Override
    public double getCalories() {
        return calories;
    }
}
