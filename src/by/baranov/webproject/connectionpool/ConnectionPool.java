package by.baranov.webproject.connectionpool;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.concurrent.ConcurrentSkipListSet;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ConnectionPool {
    private final static Logger log= LogManager.getLogger();
    private static Lock lock=new ReentrantLock(true);
    private static ConnectionPool instance=null;
    private LinkedBlockingQueue<ProxyConnection> connectionQueue;
    private ConcurrentSkipListSet<ProxyConnection> connectionInUse;

    private ConnectionPool(/*final int POOL_SIZE*/) throws SQLException {
        connectionQueue = new LinkedBlockingQueue<>(10);
        createQueue();
        connectionInUse=new ConcurrentSkipListSet<>();
    }

    private void createQueue(){
        try {
            for (int i = 0; i < 10; i++) {
                connectionQueue.offer(ProxyConnectionFactory.getProxyConnection());
            }
        }catch (SQLException e){
            System.out.println("SQLException"+e);
        }
    }
    public ProxyConnection getConnection() {
        ProxyConnection connection =null;
        try {
            connection = connectionQueue.take();
            connectionInUse.add(connection);
        }catch (InterruptedException e){
            log.warn("Interrupted ", e);
        }
        return connection;
    }

    public void putConnection(Connection connection) {
        if (connectionInUse.contains(connection)){
            connectionQueue.offer((ProxyConnection) connection);
            connectionInUse.remove(connection);
        }
    }

    public static ConnectionPool getInstance(){

        if(instance==null){

            lock.lock();
            try {
                instance = new ConnectionPool();
            }catch (SQLException e){
                log.warn("error while getting instance",e);
            }finally {
                lock.unlock();
            }
        }
        return instance;
    }
}
