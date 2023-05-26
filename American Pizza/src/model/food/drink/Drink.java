package model.food.drink;

import model.food.FoodItem;

public class Drink implements FoodItem {

    private double calories;
    private String name;

    private double price;

    public Drink(double calories, String name, double price) {
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
        return "item: " + name + " - price " + price + " - calories: " + calories;
    }

    @Override
    public double getCalories() {
        return calories;
    }
}
