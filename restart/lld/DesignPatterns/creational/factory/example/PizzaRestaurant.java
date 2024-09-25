package restart.lld.DesignPatterns.creational.factory.example;

import restart.lld.DesignPatterns.creational.factory.example.enums.PizzaType;
import restart.lld.DesignPatterns.creational.factory.example.factory.PizzaFactory;

public class PizzaRestaurant {
    public static void main(String[] args) {
        var factory=new PizzaFactory();
        System.out.println(factory.getPizzaByName(PizzaType.MARGHERITA));;
        System.out.println(factory.getPizzaByName(PizzaType.VEGGIE));;
        System.out.println(factory.getPizzaByName(PizzaType.PEPPERONI));
        System.out.println(factory.getPizzaByName(PizzaType.INDITANDOOR));;
    }
}

