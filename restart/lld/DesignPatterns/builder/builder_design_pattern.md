
# Builder Design Pattern

The **Builder Design Pattern** is a creational design pattern used to construct a complex object step by step. Unlike other creational patterns, the Builder doesn't require all properties of an object to be passed at once; instead, it allows the gradual construction of an object by assembling its parts one by one. This pattern is particularly useful when creating objects with many optional parameters or when the construction process involves several steps.

## Key Concepts:

1. **Builder**: The abstract interface (or class) defining the steps to build the object.
2. **Concrete Builder**: The class that implements the Builder interface, specifying how the object is built.
3. **Product**: The final object that is being built.
4. **Director**: (Optional) Controls the construction process by invoking the appropriate methods of the builder in a particular order. This can help manage the step-by-step process of object creation.

## Example in Java:

Let's say you are creating a `House` object that has optional parts like a garage, pool, and garden. Using the Builder pattern allows you to construct a `House` flexibly.

```java
// Product class
public class House {
    private String foundation;
    private String structure;
    private boolean hasGarage;
    private boolean hasSwimmingPool;
    private boolean hasGarden;

    // Private constructor, only accessible via the Builder
    private House(HouseBuilder builder) {
        this.foundation = builder.foundation;
        this.structure = builder.structure;
        this.hasGarage = builder.hasGarage;
        this.hasSwimmingPool = builder.hasSwimmingPool;
        this.hasGarden = builder.hasGarden;
    }

    // Getters for the fields

    public String getFoundation() { return foundation; }
    public String getStructure() { return structure; }
    public boolean hasGarage() { return hasGarage; }
    public boolean hasSwimmingPool() { return hasSwimmingPool; }
    public boolean hasGarden() { return hasGarden; }

    // Builder class
    public static class HouseBuilder {
        private String foundation;
        private String structure;
        private boolean hasGarage;
        private boolean hasSwimmingPool;
        private boolean hasGarden;

        // Required parameters
        public HouseBuilder(String foundation, String structure) {
            this.foundation = foundation;
            this.structure = structure;
        }

        // Optional parameters with builder-style methods
        public HouseBuilder setGarage(boolean hasGarage) {
            this.hasGarage = hasGarage;
            return this;
        }

        public HouseBuilder setSwimmingPool(boolean hasSwimmingPool) {
            this.hasSwimmingPool = hasSwimmingPool;
            return this;
        }

        public HouseBuilder setGarden(boolean hasGarden) {
            this.hasGarden = hasGarden;
            return this;
        }

        // Build method to create the actual House object
        public House build() {
            return new House(this);
        }
    }
}
```

### Usage:

```java
public class BuilderPatternDemo {
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
```

## Advantages:
- **Clarity**: Helps in constructing objects with many parameters in a readable way.
- **Immutability**: The constructed object is usually immutable (with final fields).
- **Customization**: Different configurations of the same type of object can be built easily.

## When to Use:
- When you have complex constructors with numerous parameters.
- When the object construction process involves several steps or conditional logic.
