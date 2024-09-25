package restart.lld.DesignPatterns.creational.singleton.example;

public class DatabaseConnectionMain {
    public static void main(String[] args) {
        var connectionManager=DatabaseConnectionManager.getInstance();
        DatabaseConnection connection1 = connectionManager.getConnection();
        DatabaseConnection connection2 = connectionManager.getConnection();
        DatabaseConnection connection3 = connectionManager.getConnection();
        DatabaseConnection connection4 = connectionManager.getConnection();
        DatabaseConnection connection5 = connectionManager.getConnection();
        connectionManager.releaseConnection(connection1);
        connectionManager.releaseConnection(connection2);
        connectionManager.releaseConnection(connection3);
        connectionManager.releaseConnection(connection4);
        connectionManager.releaseConnection(connection5);
        connectionManager.releaseConnection(connection5);
    }
}
