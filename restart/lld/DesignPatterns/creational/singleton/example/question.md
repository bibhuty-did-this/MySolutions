### Design a Singleton class for managing database connections

You are required to design a `DatabaseConnectionManager` class using the Singleton pattern. The class should provide functionality for managing database connections and ensuring that only one instance of the connection manager is ever created during the application's lifetime.

**Requirements:**
1. The class should restrict instantiation to a single instance.
2. It should have a method `connect()` to establish a connection and `disconnect()` to close the connection.
3. If an attempt is made to call `connect()` after the connection has already been established, it should return the existing connection without re-establishing it.
4. Implement lazy initialization for the singleton instance (i.e., the instance should only be created when first needed).
5. Consider thread safety in the design, ensuring that concurrent requests to access the singleton are properly handled.
6. If the class is serialized and deserialized, it should not create a new instance after deserialization.

**Bonus:**
- Implement a way to measure the total number of connections handled by the singleton during its lifecycle.


**NOTE:**
This question involves:
- Singleton class implementation.
- Lazy initialization.
- Thread safety (synchronization).
- Serialization handling (to ensure true singleton behavior).

It also has a bonus section that can be used to challenge more advanced knowledge of Singleton design.