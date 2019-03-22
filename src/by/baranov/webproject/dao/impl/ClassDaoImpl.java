package by.baranov.webproject.dao.impl;

import by.baranov.webproject.dao.AbstractDao;
import by.baranov.webproject.dao.DaoException;
import by.baranov.webproject.entity.Clas;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ClassDaoImpl extends AbstractDao<Clas> {
    private final static Logger log = LogManager.getLogger();
    private final String CLAS_ID = "clas_id";
    private final String CLAS_NAME = "clas_name";
    private final String FIND_ALL_CLAS = "SELECT clas_id, clas_name FROM clas";
    private final String FIND_CLAS_BY_ID = "SELECT clas_id, clas_name FROM clas WHERE clas_id = ?";
    private final String DELETE_CLAS_BY_ID = "DELETE FROM clas WHERE clas_id = ?";
    private final String CREATE_CLAS = "INSERT INTO clas SET clas_name = ?";
    private final String UPDATE_CLAS = "UPDATE clas SET clas_name = ? WHERE clas_id = ?";

    @Override
    public List<Clas> findAll() throws DaoException {
        List<Clas> resultList = new ArrayList<>();
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;
        try {
            connection = getConnectionPool().getConnection();
            statement = connection.createStatement();
            resultSet = statement.executeQuery(FIND_ALL_CLAS);
            while (resultSet.next()) {
                long clasId = resultSet.getLong(CLAS_ID);
                String clasName = resultSet.getString(CLAS_NAME);
                resultList.add(new Clas(clasId, clasName));
            }
        } catch (SQLException e) {
            throw new DaoException(e);
        } finally {
            releaseResources(resultSet, statement, connection);
        }
        return resultList;
    }

    @Override
    public Clas findById(long id) throws DaoException {
        Clas result = null;
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try {
            connection = getConnectionPool().getConnection();
            preparedStatement = connection.prepareStatement(FIND_CLAS_BY_ID);
            preparedStatement.setLong(1, id);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int clasId = resultSet.getInt(CLAS_ID);
                String clasName = resultSet.getString(CLAS_NAME);
                result = new Clas(clasId, clasName);
            }
        } catch (SQLException e) {
            System.out.println("SQLException" + e);
            throw new DaoException(e);
        } finally {
            releaseResources(resultSet, preparedStatement, connection);
        }
        return result;
    }

    @Override
    public boolean delete(long id) throws DaoException {
        boolean result = false;
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            connection = getConnectionPool().getConnection();
            preparedStatement = connection.prepareStatement(DELETE_CLAS_BY_ID);
            preparedStatement.setLong(1, id);
            preparedStatement.executeUpdate();
            result = true;
        } catch (SQLException e) {
            throw new DaoException(e);
        } finally {
            releaseResources(preparedStatement, connection);
        }
        return result;
    }

    @Override
    public boolean create(Clas clas) throws DaoException {
        boolean result = false;
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            connection = getConnectionPool().getConnection();
            preparedStatement = connection.prepareStatement(CREATE_CLAS);
            preparedStatement.setString(1, clas.getName());
            preparedStatement.executeUpdate();
            result = true;
        } catch (SQLException e) {
            throw new DaoException(e);
        } finally {
            releaseResources(preparedStatement, connection);
        }
        return result;
    }

    @Override
    public boolean update(Clas clas) throws DaoException {
        boolean result = false;
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            connection = getConnectionPool().getConnection();
            preparedStatement = connection.prepareStatement(UPDATE_CLAS);
            preparedStatement.setString(1, clas.getName());
            preparedStatement.setLong(2, clas.getId());
            preparedStatement.executeUpdate();
            result = true;
        } catch (SQLException e) {
            throw new DaoException(e);
        } finally {
            releaseResources(preparedStatement, connection);
        }
        return result;
    }
}
