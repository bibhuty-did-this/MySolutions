### Prototype Pattern Question

Design a system where a game has several types of characters with complex configurations. Each character type has several attributes, like health, attack power, defense power, special abilities, etc. These attributes are customizable but should generally be initialized with common defaults for each character type.

When a new character is needed, it should be cloned from an existing character template (prototype) and then customized if necessary, instead of creating it from scratch.

Additionally, the system should support the following:

1. **Deep vs. Shallow Copy**: Some character attributes, such as special abilities, should be deeply cloned to avoid accidental sharing between instances.
2. **Prototype Registry**: Maintain a registry of character prototypes, so new instances can be created dynamically based on different character types (e.g., "Warrior," "Mage," "Archer"). Each type should be retrievable by name from this registry.
3. **Performance**: The cloning operation should be optimized to avoid unnecessary creation overhead.

#### Requirements:
- Implement the character creation system using the **Prototype Pattern**.
- Demonstrate how shallow vs. deep cloning would work for different attributes of the character.
- Implement a **Prototype Registry** to store and retrieve character prototypes based on type.
- Consider edge cases where modifying one instance should not affect others.