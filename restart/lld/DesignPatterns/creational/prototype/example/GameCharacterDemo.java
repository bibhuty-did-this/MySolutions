package restart.lld.DesignPatterns.creational.prototype.example;

import restart.lld.DesignPatterns.creational.prototype.example.character.*;

public class GameCharacterDemo {
    public static void main(String[] args) {
        var mage= CharacterRegistry.getGameCharacter(Mage.class.getSimpleName());
        var warrior=CharacterRegistry.getGameCharacter(Warrior.class.getSimpleName());
        var archer=CharacterRegistry.getGameCharacter(Archer.class.getSimpleName());
        System.out.println(mage);
        System.out.println(warrior);
        System.out.println(archer);
    }
}


