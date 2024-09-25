package restart.lld.DesignPatterns.creational.prototype.example.character;

import restart.lld.DesignPatterns.creational.prototype.example.Ability;
import restart.lld.DesignPatterns.creational.prototype.example.SpecialAbility;

public class Archer extends GameCharacter {
    public Archer() {
        super(100, 100, 50, new SpecialAbility(Ability.MULTISHOT));
    }

    public Archer(float health, float attackPower, float defencePower, SpecialAbility specialAbility) {
        super(health, attackPower, defencePower, new SpecialAbility(specialAbility.getAbility()));
    }

    @Override
    public Archer copy() {
        return new Archer(this.health, this.attackPower, this.defencePower, new SpecialAbility(this.specialAbility.getAbility()));
    }
}
