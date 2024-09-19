package restart.lld.DesignPatterns.singleton;

public class EagerSingleton {
    // Eager initialization - instance is created at the time of class loading
    private static final EagerSingleton INSTANCE = new EagerSingleton();

    // Private constructor prevents instantiation from other classes
    private EagerSingleton() { }

    // Method to provide global access to the instance
    public static EagerSingleton getInstance() {
        return INSTANCE;
    }

    public void showMessage() {
        System.out.println("Hello from Singleton!");
    }
}