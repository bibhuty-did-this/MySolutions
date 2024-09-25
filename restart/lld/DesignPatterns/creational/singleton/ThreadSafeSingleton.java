package restart.lld.DesignPatterns.creational.singleton;

public class ThreadSafeSingleton {
    // Volatile keyword ensures visibility of changes to instance across threads
    private static volatile ThreadSafeSingleton instance;

    private ThreadSafeSingleton() { }

    // Double-checked locking to make sure Singleton is thread-safe and efficient
    public static ThreadSafeSingleton getInstance() {
        if (instance == null) {
            synchronized (ThreadSafeSingleton.class) {
                if (instance == null) {
                    instance = new ThreadSafeSingleton();
                }
            }
        }
        return instance;
    }

    public void showMessage() {
        System.out.println("Hello from Thread-Safe Singleton!");
    }
}