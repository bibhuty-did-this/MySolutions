package restart.lld.DesignPatterns.creational.singleton.example;

class DatabaseConnection {
    private final String name;

    public DatabaseConnection(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "DatabaseConnection{" +
                "name='" + name + '\'' +
                '}';
    }
}
