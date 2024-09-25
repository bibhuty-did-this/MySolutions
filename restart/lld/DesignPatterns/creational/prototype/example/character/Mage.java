package restart.lld.DesignPatterns.creational.prototype.example.character;

import restart.lld.DesignPatterns.creational.prototype.example.Ability;
import restart.lld.DesignPatterns.creational.prototype.example.SpecialAbility;

public class Mage extends GameCharacter {
    public Mage() {
        super(100, 0, 100, new SpecialAbility(Ability.INVISIBLITY));
    }

    public Mage(float health, float attackPower, float defencePower, SpecialAbility specialAbility) {
        super(health, attackPower, defencePower, new SpecialAbility(specialAbility.getAbility()));
    }

    @Override
    public Mage copy() {
        return new Mage(this.health, this.attackPower, this.defencePower, new SpecialAbility(this.specialAbility.getAbility()));
    }
}
