package restart.lld.DesignPatterns.creational.builder.example;

class Beverage {
    float soda;
    float wine;

    public Beverage(BeverageBuilder beverageBuilder) {
        this.soda = beverageBuilder.soda;
        this.wine = beverageBuilder.wine;
    }

    @Override
    public String toString() {
        return "Beverage{" +
                "soda=" + soda +
                ", wine=" + wine +
                '}';
    }

    public static class BeverageBuilder {
        float soda;
        float wine;

        public BeverageBuilder soda(float soda) {
            this.soda = soda;
            return this;
        }

        public BeverageBuilder wine(float wine) {
            this.wine = wine;
            return this;
        }

        public Beverage build() {
            if(this.soda==0 || this.wine==0){
                throw new IllegalStateException("At least one beverage should be selected");
            }
            return new Beverage(this);
        }
    }
}
