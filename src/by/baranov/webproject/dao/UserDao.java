package by.baranov.webproject.dao;

import by.baranov.webproject.entity.User;

public interface UserDao {
    User findUserByLoginAndPassword(String login, String password) throws DaoException;
    boolean findUserByLogin(String login) throws DaoException;
}
