package restart.lld.DesignPatterns.builder.example;

class Meal {
    MainDish mainDish;
    SideDish sideDish;
    Beverage beverage;
    Dessert dessert;

    @Override
    public String toString() {
        return "Meal{" +
                "mainDish=" + mainDish +
                ", sideDish=" + sideDish +
                ", beverage=" + beverage +
                ", dessert=" + dessert +
                '}';
    }

    public Meal(MealBuilder mealBuilder) {
        this.mainDish = mealBuilder.mainDish;
        this.sideDish = mealBuilder.sideDish;
        this.beverage = mealBuilder.beverage;
        this.dessert = mealBuilder.dessert;
    }

    public static class MealBuilder {
        MainDish mainDish;
        SideDish sideDish;
        Beverage beverage;
        Dessert dessert;

        public MealBuilder mainDish(MainDish mainDish) {
            this.mainDish = mainDish;
            return this;
        }

        public MealBuilder sideDish(SideDish sideDish) {
            this.sideDish = sideDish;
            return this;
        }

        public MealBuilder beverage(Beverage beverage) {
            this.beverage = beverage;
            return this;
        }

        public MealBuilder dessert(Dessert dessert) {
            this.dessert = dessert;
            return this;
        }

        public Meal build() {
            return new Meal(this);
        }
    }
}
