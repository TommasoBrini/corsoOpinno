package model.food.pizza.base;

import model.food.pizza.Pizza;

public class PizzaBase implements Pizza {
    @Override
    public String getName() {
        return null;
    }

    @Override
    public double getPrice() {
        return 0;
    }

    @Override
    public String getMenuItemLine() {
        return null;
    }

    @Override
    public double getCalories() {
        return 0;
    }
}
