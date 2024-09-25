package restart.lld.DesignPatterns.creational.singleton;

public class LazySingleton {
    // Lazy initialization - instance is created only when needed
    private static LazySingleton instance;

    // Private constructor prevents instantiation from other classes
    private LazySingleton() { }

    // Synchronized method to control simultaneous access
    public static synchronized LazySingleton getInstance() {
        if (instance == null) {
            instance = new LazySingleton();
        }
        return instance;
    }

    public void showMessage() {
        System.out.println("Hello from Lazy Singleton!");
    }
}
