package restart.lld.DesignPatterns.creational.builder.example;

/**
 * Design a system for creating complex meal orders in a restaurant, where each meal consists of several customizable
 * parts, such as a main dish, side dish, beverage, and dessert. The restaurant allows customers to choose or omit any
 * part of the meal, and different types of meals may require different combinations of these parts. Ensure that the
 * system is flexible enough to easily create a variety of meal configurations while avoiding the complexity of
 * managing every possible combination manually.
 */
public class MealOrder {
    public static void main(String[] args) {
        var mainDish=new MainDish.MainDishBuilder().veg(1).chicken(2).build();
        var sideDish=new SideDish.SideDishBuilder().papad(1).build();
        var beverage=new Beverage.BeverageBuilder().wine(2).build();
        var dessert=new Dessert.DessertBuilder().pastry(1.5f).build();
        var meal=new Meal.MealBuilder().mainDish(mainDish).sideDish(sideDish).beverage(beverage).dessert(dessert).build();
        System.out.println(meal);
    }
}

