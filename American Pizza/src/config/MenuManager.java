package config;

import model.food.FoodItem;
import model.food.drink.Drink;
import model.food.pizza.Pizza;
import model.food.pizza.topping.Topping;
import model.franchising.Franchising;
import persistance.DummyDB;

public class MenuManager {
    DummyDB dummyDB;

    public MenuManager() {
        this.dummyDB = new DummyDB();
        dummyDB.initDB();
    }

    public void printDB(){
//        System.out.println("**** PRINT MENU ****");
//        System.out.println("**** FRANCHISING ****");
//        for(Franchising pizza : dummyDB.getMenuFranchising()){
//            System.out.println(pizza.getMenuItemLine());
//        }
//        System.out.println("**** DRINKS");
//        for(Drink drink : dummyDB.getDrinks()){
//            System.out.println(drink.getMenuItemLine());
//        }
        System.out.println("**** PRINT MENU ****");
        System.out.println("**** PIZZAS ****");
        for (Pizza pizza : dummyDB.getMenuPizza()){
            System.out.println(pizza.getMenuItemLine());
        }
        System.out.println("**** TOPPINGS ****");
        for (Topping top : dummyDB.getMenuTopping()){
            System.out.println(top.getMenuItemLine());
        }
        System.out.println("**** DRINKS ****");
        for (Drink drink : dummyDB.getMenuDrinks()){
            System.out.println(drink.getMenuItemLine());
        }
        System.out.println("**** FRANCHISE ****");
        for(Franchising franchising : dummyDB.getMenuFranchising()){
            System.out.println(franchising.getMenuItemLine());
        }
    }
}
