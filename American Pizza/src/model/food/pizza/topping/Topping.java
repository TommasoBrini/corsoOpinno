package model.food.pizza.topping;

import model.food.pizza.Pizza;

public abstract class Topping implements Pizza {

    protected final Pizza pizza;

    public Topping(Pizza pizza) {
        this.pizza = pizza;

    }
}
