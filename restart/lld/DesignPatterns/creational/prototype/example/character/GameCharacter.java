package restart.lld.DesignPatterns.creational.prototype.example.character;

import restart.lld.DesignPatterns.creational.prototype.example.SpecialAbility;

abstract class GameCharacter {
    float health;
    float attackPower;
    float defencePower;
    SpecialAbility specialAbility;

    public GameCharacter() {
        this.health = 0;
        this.attackPower = 0;
        this.defencePower = 0;
        this.specialAbility = null;
    }

    public GameCharacter(float health, float attackPower, float defencePower, SpecialAbility specialAbility) {
        this.health = health;
        this.attackPower = attackPower;
        this.defencePower = defencePower;
        this.specialAbility = specialAbility;
    }

    abstract GameCharacter copy();

    @Override
    public String toString() {
        return "GameCharacter{" +
                "health=" + health +
                ", attackPower=" + attackPower +
                ", defencePower=" + defencePower +
                ", specialAbility=" + specialAbility +
                '}';
    }
}
