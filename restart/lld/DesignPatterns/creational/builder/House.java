package restart.lld.DesignPatterns.creational.builder;

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

    public String getFoundation() {
        return foundation;
    }

    public String getStructure() {
        return structure;
    }

    public boolean hasGarage() {
        return hasGarage;
    }

    public boolean hasSwimmingPool() {
        return hasSwimmingPool;
    }

    public boolean hasGarden() {
        return hasGarden;
    }

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
