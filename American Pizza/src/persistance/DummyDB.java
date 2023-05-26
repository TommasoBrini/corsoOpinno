package persistance;

import model.food.FoodItem;
import model.food.drink.Drink;
import model.food.drink.Lemonade;
import model.food.drink.Water;
import model.food.drink.Wine;
import model.franchising.Franchising;
import model.franchising.Mug;
import model.franchising.Shirt;

import java.util.ArrayList;
import java.util.List;

public class DummyDB {

    private List<Franchising> menuFranchising = new ArrayList<>();

    private List<Drink> drinks = new ArrayList<>();

    public List<Franchising> getMenuFranchising() {
        return menuFranchising;
    }

    public List<Drink> getDrinks() {
        return drinks;
    }

    public void initDB(){
        menuFranchising.add(new Mug());
        menuFranchising.add(new Shirt());

        drinks.add(new Lemonade());
        drinks.add(new Water());
        drinks.add(new Wine());
    }
}
