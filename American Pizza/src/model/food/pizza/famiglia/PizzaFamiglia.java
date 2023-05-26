package model.food.pizza.famiglia;

import model.food.pizza.Pizza;

public class PizzaFamiglia implements Pizza {

    private Pizza pizza;
    private final double perCalories = 2;
    private final double plusPrice = 4.15;

    public PizzaFamiglia(Pizza pizza){
        this.pizza = pizza;
    }

    @Override
    public String getName() {
        return this.getPizza().getName() + " + " + "Family size";
    }

    public Pizza getPizza() {
        return pizza;
    }
    @Override
    public double getPrice() {
        return this.getPizza().getPrice() + this.plusPrice;
    }

    @Override
    public String getMenuItemLine() {
        return "Family size for Pizza" + " - Calories: x" + this.perCalories + " - Price: +" + this.plusPrice;
    }

    @Override
    public double getCalories() {
        return this.getPizza().getCalories() * this.perCalories;
    }
}
