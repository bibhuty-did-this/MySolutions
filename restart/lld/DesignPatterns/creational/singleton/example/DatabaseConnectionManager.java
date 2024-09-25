package restart.lld.DesignPatterns.creational.singleton.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class DatabaseConnectionManager {
    private static DatabaseConnectionManager databaseConnectionManager;
    private List<DatabaseConnection> connectionPool;
    private static final int POOL_SIZE=5;

    private DatabaseConnectionManager(){
        connectionPool =new ArrayList<>(POOL_SIZE);
        for(int i=0;i<POOL_SIZE;++i){
            connectionPool.add(new DatabaseConnection("Connection "+(i+1)));
        }
    }

    public static DatabaseConnectionManager getInstance(){
        if(Objects.isNull(databaseConnectionManager)){
            synchronized (DatabaseConnectionManager.class){
                if(Objects.isNull(databaseConnectionManager)){
                    databaseConnectionManager = new DatabaseConnectionManager();
                }
            }
        }
        return databaseConnectionManager;
    }

    public synchronized DatabaseConnection getConnection(){
        if(connectionPool.isEmpty()){
            throw new RuntimeException("No available connection");
        }
        return connectionPool.remove(connectionPool.size()-1);
    }

    public synchronized void releaseConnection(DatabaseConnection connection){
        if(connectionPool.size()==POOL_SIZE){
            throw new RuntimeException("Illegal operation, can't release non-existent connection");
        }
        connectionPool.add(connection);
    }

    protected Object readResolve(){
        return databaseConnectionManager;
    }
}
