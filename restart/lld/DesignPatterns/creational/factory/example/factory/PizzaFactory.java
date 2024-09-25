package restart.lld.DesignPatterns.creational.factory.example.factory;

import restart.lld.DesignPatterns.creational.factory.example.enums.PizzaType;
import restart.lld.DesignPatterns.creational.factory.example.pizza.*;

import java.util.Objects;

public class PizzaFactory {
    public Pizza getPizzaByName(PizzaType type) {
        if (Objects.isNull(type)) {
            throw new IllegalStateException("Name of the pizza can't be empty");
        }
        Pizza pizza=null;
        switch (type) {
            case MARGHERITA:
                pizza = new Margherita();
                break;
            case VEGGIE:
                pizza = new Veggie();
                break;
            case PEPPERONI:
                pizza = new Pepperoni();
                break;
            case INDITANDOOR:
                pizza = new IndiTandoor();
                break;
        }
        return pizza;
    }
}
