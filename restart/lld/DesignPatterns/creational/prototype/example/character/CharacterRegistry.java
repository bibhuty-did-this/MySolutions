package restart.lld.DesignPatterns.creational.prototype.example.character;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class CharacterRegistry {
    private static CharacterRegistry instance;
    private static Map<String, GameCharacter> registry;

    private CharacterRegistry() {
        registry = new HashMap<>();
        register(Archer.class.getSimpleName(), new Archer());
        register(Mage.class.getSimpleName(), new Mage());
        register(Warrior.class.getSimpleName(), new Warrior());
    }

    private static CharacterRegistry getInstance() {
        if (Objects.isNull(instance)) {
            instance = new CharacterRegistry();
        }
        return instance;
    }

    private static void register(String name, GameCharacter character) {
        registry.put(name, character);
    }

    public static GameCharacter getGameCharacter(String character) {
        if (Objects.isNull(registry)) {
            getInstance();
        }
        GameCharacter gameCharacter = registry.get(character);
        if (Objects.isNull(gameCharacter)) {
            throw new IllegalStateException("The character is invalid");
        }
        return gameCharacter.copy();
    }
}
