package by.baranov.webproject.dao;

import by.baranov.webproject.connectionpool.ConnectionPool;
import by.baranov.webproject.entity.Entity;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.*;
import java.util.List;

public abstract class AbstractDao<T extends Entity> {
    private final static Logger log= LogManager.getLogger();
    private ConnectionPool connectionPool=ConnectionPool.getInstance();

    public abstract List<T> findAll()throws DaoException;

    public abstract T findById(long id)throws DaoException;

    public abstract boolean delete(long id)throws DaoException;

    //public abstract boolean delete(T entity)throws DaoException;

    public abstract boolean create(T entity)throws DaoException;

    public abstract boolean update(T entity) throws DaoException;

    protected void releaseResources(ResultSet resultSet, Statement statement, Connection connection){
        if(resultSet!=null){
            try {
                resultSet.close();
            }catch(SQLException e){
                log.warn("unable close result set",e);
            }
        }
        if(statement!=null) {
            try {
                statement.close();
            }catch (SQLException e){
                log.warn("unable to close statement",e);
            }
        }
        connectionPool.putConnection(connection);
    }

    protected void releaseResources(PreparedStatement statement, Connection connection){
        if(statement!=null) {
            try {
                statement.close();
            }catch (SQLException e){
                log.warn("unable to close statement",e);
            }
        }
        connectionPool.putConnection(connection);
    }

    public ConnectionPool getConnectionPool() {
        return connectionPool;
    }
}
