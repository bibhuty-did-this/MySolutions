package restart.lld.DesignPatterns.builder.example;

class Dessert {
    float brownie;
    float pastry;

    public Dessert(DessertBuilder dessertBuilder) {
        this.brownie = dessertBuilder.brownie;
        this.pastry = dessertBuilder.pastry;
    }

    @Override
    public String toString() {
        return "Dessert{" +
                "brownie=" + brownie +
                ", pastry=" + pastry +
                '}';
    }

    public static class DessertBuilder {
        float brownie;
        float pastry;

        public DessertBuilder brownie(float brownie) {
            this.brownie = brownie;
            return this;
        }

        public DessertBuilder pastry(float pastry) {
            this.pastry = pastry;
            return this;
        }

        public Dessert build() {
            return new Dessert(this);
        }
    }
}
