package restart.lld.DesignPatterns.builder;
public class BuilderDesignPattern {
    public static void main(String[] args) {
        House house = new House.HouseBuilder("Concrete", "Wooden")
                .setGarage(true)
                .setSwimmingPool(false)
                .setGarden(true)
                .build();

        System.out.println("House with Garage: " + house.hasGarage());
        System.out.println("House with Pool: " + house.hasSwimmingPool());
        System.out.println("House with Garden: " + house.hasGarden());
    }
}
