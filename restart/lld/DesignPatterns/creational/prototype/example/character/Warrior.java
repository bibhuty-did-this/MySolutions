package restart.lld.DesignPatterns.creational.prototype.example.character;

import restart.lld.DesignPatterns.creational.prototype.example.Ability;
import restart.lld.DesignPatterns.creational.prototype.example.SpecialAbility;

public class Warrior extends GameCharacter {
    public Warrior() {
        super(100, 100, 100, new SpecialAbility(Ability.RAGE));
    }

    public Warrior(float health, float attackPower, float defencePower, SpecialAbility specialAbility) {
        super(health, attackPower, defencePower, new SpecialAbility(specialAbility.getAbility()));
    }

    @Override
    public Warrior copy() {
        return new Warrior(this.health, this.attackPower, this.defencePower, new SpecialAbility(this.specialAbility.getAbility()));
    }
}
