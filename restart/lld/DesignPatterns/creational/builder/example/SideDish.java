package restart.lld.DesignPatterns.creational.builder.example;

class SideDish {
    float papad;
    float tikka;

    public SideDish(SideDishBuilder sideDishBuilder) {
        this.papad = sideDishBuilder.papad;
        this.tikka = sideDishBuilder.tikka;
    }

    @Override
    public String toString() {
        return "SideDish{" +
                "papad=" + papad +
                ", tikka=" + tikka +
                '}';
    }

    public static class SideDishBuilder {
        float papad;
        float tikka;

        public SideDishBuilder papad(float papad) {
            this.papad = papad;
            return this;
        }

        public SideDishBuilder tikka(float tikka) {
            this.tikka = tikka;
            return this;
        }

        public SideDish build() {
            return new SideDish(this);
        }
    }
}
