package persistance;

import model.food.FoodItem;
import model.food.drink.Drink;
import model.food.drink.Lemonade;
import model.food.drink.Water;
import model.food.drink.Wine;
import model.food.pizza.Pizza;
import model.food.pizza.base.Hawai;
import model.food.pizza.base.Margherita;
import model.food.pizza.base.Salami;
import model.food.pizza.famiglia.PizzaFamiglia;
import model.food.pizza.topping.*;
import model.franchising.Franchising;
import model.franchising.Mug;
import model.franchising.Shirt;

import java.util.ArrayList;
import java.util.List;

public class DummyDB {

    private List<Franchising> menuFranchising = new ArrayList<>();
    private List<Drink> menuDrinks = new ArrayList<>();
    private List<Pizza> menuPizza = new ArrayList<>();
    private List<Topping> menuTopping = new ArrayList<>();

    public List<Franchising> getMenuFranchising() {
        return menuFranchising;
    }

    public List<Drink> getMenuDrinks() {
        return menuDrinks;
    }

    public List<Pizza> getMenuPizza() {
        return menuPizza;
    }

    public List<Topping> getMenuTopping() {
        return menuTopping;
    }

    public void initDB(){
        menuFranchising.add(new Shirt());
        menuFranchising.add(new Mug());

        menuPizza.add(new Margherita());
        menuPizza.add(new Hawai());
        menuPizza.add(new Salami());
        menuPizza.add(new PizzaFamiglia(new Margherita()));

        menuDrinks.add(new Lemonade());
        menuDrinks.add(new Water());
        menuDrinks.add(new Wine());

        menuTopping.add(new Cheese(new Margherita()));
        menuTopping.add(new Ham(new Margherita()));
        menuTopping.add(new Onion(new Margherita()));
        menuTopping.add(new Pineapple(new Margherita()));
        menuTopping.add(new model.food.pizza.topping.Salami(new Margherita()));

    }
}
