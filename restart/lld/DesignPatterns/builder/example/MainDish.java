package restart.lld.DesignPatterns.builder.example;

class MainDish {
    float veg;

    float chicken;

    public MainDish(MainDishBuilder mainDishBuilder) {
        this.veg = mainDishBuilder.veg;
        this.chicken = mainDishBuilder.chicken;
    }

    @Override
    public String toString() {
        return "MainDish{" +
                "veg=" + veg +
                ", chicken=" + chicken +
                '}';
    }

    public static class MainDishBuilder {
        float veg;

        float chicken;

        public MainDishBuilder veg(float veg) {
            this.veg = veg;
            return this;
        }

        public MainDishBuilder chicken(float chicken) {
            this.chicken = chicken;
            return this;
        }

        public MainDish build() {
            return new MainDish(this);
        }
    }
}
