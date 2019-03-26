package by.baranov.webproject.dao.impl;

import by.baranov.webproject.dao.AbstractDao;
import by.baranov.webproject.dao.UserDao;
import by.baranov.webproject.entity.User;
import by.baranov.webproject.dao.DaoException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserDaoImpl extends AbstractDao<User> implements UserDao {
    private final static Logger log = LogManager.getLogger();
    private final String USER_ID = "user_id";
    private final String FIRST_NAME = "first_name";
    private final String LAST_NAME = "last_name";
    private final String EMAIL = "email";
    private final String PHONE = "phone";
    private final String ADDRESS = "address";
    private final String PASSWORD = "password";
    private final String ROLE = "role";
    private final String DELETE_PUPIL_BY_ID = "DELETE FROM pupil WHERE user_id = ?";
    private final String ADD_PUPIL_TO_CLASS = "INSERT INTO pupil SET user_id = ?, class_name = ?";
    private final String FIND_CLAS_ALL_PUPIL = "SELECT user.user_id, user.first_name, user.last_name, user.email, " +
            "user.phone, user.address, user.password, user.role FROM user JOIN pupil ON user.user_id = pupil.user_id " +
            "WHERE pupil.class_name = ?";
    private final String FIND_ALL_TEACHER = "SELECT user_id, first_name, last_name, email, phone, address, password, role " +
            "FROM user WHERE role = \"TEACHER\"";
    private final String FIND_USER_BY_LOGIN = "SELECT user_id, first_name, last_name, email, phone, address, " +
            "role FROM user WHERE email=?";
    private final String FIND_USER_BY_LOGIN_AND_PASSWORD = "SELECT user_id, first_name, last_name, email, phone, address, " +
            "role FROM user WHERE email=? AND password=?";
    private final String FIND_ALL_USER = "SELECT user_id, first_name, last_name, email, phone, address, password, role " +
            "FROM user";
    private final String FIND_USER_BY_ID = "SELECT user_id, first_name, last_name, email, phone, address, password, role " +
            "FROM user WHERE user_id = ?";
    private final String DELETE_USER_BY_ID = "DELETE FROM user WHERE user_id = ?";
    private final String CREATE_USER = "INSERT INTO user SET first_name = ?, last_name = ?,email = ?, password = ?, " +
            "phone = ?, address = ?, role = ?";
    private final String UPDATE_USER =
            "UPDATE user SET " +
                    "first_name = ?, " + //1
                    "last_name = ?," +//2
                    "email = ?, " +//3
                    "phone = ?, " +//4
                    "address = ?, " +//5
                    "role = ? " +//6
                    "WHERE " +
                    "user_id = ?";//7

    @Override
    public List<User> findAll() throws DaoException {
        List<User> resultList = new ArrayList<>();
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;
        try {
            connection = getConnectionPool().getConnection();
            statement = connection.createStatement();
            resultSet = statement.executeQuery(FIND_ALL_USER);
            while (resultSet.next()) {
                long userId = resultSet.getLong(USER_ID);
                String firstName = resultSet.getString(FIRST_NAME);
                String lastName = resultSet.getString(LAST_NAME);
                String email = resultSet.getString(EMAIL);
                String password = resultSet.getString(PASSWORD);
                String phoneNumber = resultSet.getString(PHONE);
                String address = resultSet.getString(ADDRESS);
                String role = resultSet.getString(ROLE);
                resultList.add(new User(userId, firstName, lastName, email, password, phoneNumber, address, role));
            }
        } catch (SQLException e) {
            throw new DaoException(e);
        } finally {
            releaseResources(resultSet, statement, connection);
        }
        return resultList;
    }

    @Override
    public User findById(long id) throws DaoException {
        User result = null;
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try {
            connection = getConnectionPool().getConnection();
            preparedStatement = connection.prepareStatement(FIND_USER_BY_ID);
            preparedStatement.setLong(1, id);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                long userId = resultSet.getLong(USER_ID);
                String firstName = resultSet.getString(FIRST_NAME);
                String lastName = resultSet.getString(LAST_NAME);
                String email = resultSet.getString(EMAIL);
                String password = resultSet.getString(PASSWORD);
                String phoneNumber = resultSet.getString(PHONE);
                String address = resultSet.getString(ADDRESS);
                String role = resultSet.getString(ROLE);
                result = new User(userId, firstName, password, lastName, email, phoneNumber, address, role);
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
            preparedStatement = connection.prepareStatement(DELETE_USER_BY_ID);
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
    public boolean create(User user) throws DaoException {
        boolean result = false;
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            connection = getConnectionPool().getConnection();
            preparedStatement = connection.prepareStatement(CREATE_USER);
            preparedStatement.setString(1, user.getFirstName());
            preparedStatement.setString(2, user.getLastName());
            preparedStatement.setString(3, user.getEmail());
            preparedStatement.setString(4, user.getPassword());
            preparedStatement.setString(5, user.getPhoneNumber());
            preparedStatement.setString(6, user.getAddress());
            preparedStatement.setString(7, user.getRole());
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
    public boolean update(User user) throws DaoException {
        boolean result = false;
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            connection = getConnectionPool().getConnection();
            preparedStatement = connection.prepareStatement(UPDATE_USER);
            preparedStatement.setString(1, user.getFirstName());
            preparedStatement.setString(2, user.getLastName());
            preparedStatement.setString(3, user.getEmail());
            preparedStatement.setString(4, user.getPhoneNumber());
            preparedStatement.setString(5, user.getAddress());
            preparedStatement.setString(6, user.getRole());
            preparedStatement.setLong(7, user.getUserId());
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
    public User findUserByLoginAndPassword(String login, String password) throws DaoException {
        User user = null;
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try {
            connection = getConnectionPool().getConnection();
            preparedStatement = connection.prepareStatement(FIND_USER_BY_LOGIN_AND_PASSWORD);
            preparedStatement.setString(1, login);
            preparedStatement.setString(2, password);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                long userId = resultSet.getLong(USER_ID);
                String firstName = resultSet.getString(FIRST_NAME);
                String lastName = resultSet.getString(LAST_NAME);
                String email = resultSet.getString(EMAIL);
                String phoneNumber = resultSet.getString(PHONE);
                String address = resultSet.getString(ADDRESS);
                String role = resultSet.getString(ROLE);
                user = new User(userId, firstName, lastName, email, password, phoneNumber, address, role);
            }
        } catch (SQLException e) {
            throw new DaoException(e);
        } finally {
            releaseResources(preparedStatement, connection);
        }
        return user;
    }

    @Override
    public User findUserByLogin(String login) throws  DaoException{
        User user = null;
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try {
            connection = getConnectionPool().getConnection();
            preparedStatement = connection.prepareStatement(FIND_USER_BY_LOGIN);
            preparedStatement.setString(1, login);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                long userId = resultSet.getLong(USER_ID);
                String firstName = resultSet.getString(FIRST_NAME);
                String lastName = resultSet.getString(LAST_NAME);
                String email = resultSet.getString(EMAIL);
                String phoneNumber = resultSet.getString(PHONE);
                String address = resultSet.getString(ADDRESS);
                String role = resultSet.getString(ROLE);
                user = new User(userId, firstName, lastName, email, phoneNumber, address, role);
            }
        } catch (SQLException e) {
            throw new DaoException(e);
        } finally {
            releaseResources(preparedStatement, connection);
        }
        return user;
    }

    public List<User> findAllTeacher() throws DaoException {
        List<User> resultList = new ArrayList<>();
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;
        try {
            connection = getConnectionPool().getConnection();
            statement = connection.createStatement();
            resultSet = statement.executeQuery(FIND_ALL_TEACHER);
            while (resultSet.next()) {
                long userId = resultSet.getLong(USER_ID);
                String firstName = resultSet.getString(FIRST_NAME);
                String lastName = resultSet.getString(LAST_NAME);
                String email = resultSet.getString(EMAIL);
                String password = resultSet.getString(PASSWORD);
                String phoneNumber = resultSet.getString(PHONE);
                String address = resultSet.getString(ADDRESS);
                String role = resultSet.getString(ROLE);
                resultList.add(new User(userId, firstName, lastName, email, password, phoneNumber, address, role));
            }
        } catch (SQLException e) {
            throw new DaoException(e);
        } finally {
            releaseResources(resultSet, statement, connection);
        }
        return resultList;
    }

    public List<User> findAllPupilInClas(String clasName) throws DaoException {
        List<User> resultList = new ArrayList<>();
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try {
            connection = getConnectionPool().getConnection();
            preparedStatement = connection.prepareStatement(FIND_CLAS_ALL_PUPIL);
            preparedStatement.setString(1, clasName);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                long userId = resultSet.getLong(USER_ID);
                String firstName = resultSet.getString(FIRST_NAME);
                String lastName = resultSet.getString(LAST_NAME);
                String email = resultSet.getString(EMAIL);
                String password = resultSet.getString(PASSWORD);
                String phoneNumber = resultSet.getString(PHONE);
                String address = resultSet.getString(ADDRESS);
                String role = resultSet.getString(ROLE);
                resultList.add(new User(userId, firstName, lastName, email, password, phoneNumber, address, role));
            }
        } catch (SQLException e) {
            throw new DaoException(e);
        } finally {
            releaseResources(resultSet, preparedStatement, connection);
        }
        return resultList;
    }

    public boolean addPupilToClass(String clasName,User user) throws DaoException {
        boolean result = false;
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            connection = getConnectionPool().getConnection();
            preparedStatement = connection.prepareStatement(ADD_PUPIL_TO_CLASS);
            preparedStatement.setLong(1, user.getUserId());
            preparedStatement.setString(2, clasName);
            preparedStatement.executeUpdate();
            result = true;
        } catch (SQLException e) {
            throw new DaoException(e);
        } finally {
            releaseResources(preparedStatement, connection);
        }
        return result;
    }

    public boolean deletePupil(long id) throws DaoException {
        boolean result = false;
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            connection = getConnectionPool().getConnection();
            preparedStatement = connection.prepareStatement(DELETE_PUPIL_BY_ID);
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
}
