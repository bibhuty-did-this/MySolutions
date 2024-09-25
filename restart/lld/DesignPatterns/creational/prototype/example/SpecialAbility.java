package restart.lld.DesignPatterns.creational.prototype.example;

public class SpecialAbility {
    private final Ability ability;

    public SpecialAbility() {
        this.ability = null;
    }

    public SpecialAbility(Ability ability) {
        this.ability = ability;
    }

    public Ability getAbility() {
        return ability;
    }

    @Override
    public String toString() {
        return "SpecialAbility{" +
                "ability=" + ability +
                '}';
    }
}
