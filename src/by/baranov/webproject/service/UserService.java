package by.baranov.webproject.service;

import by.baranov.webproject.dao.impl.UserDaoImpl;
import by.baranov.webproject.util.EmailSender;
import by.baranov.webproject.entity.User;
import by.baranov.webproject.dao.DaoException;
import by.baranov.webproject.util.PasswordGenerator;
import by.baranov.webproject.util.PasswordHash;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;

public class UserService {
    private static final Logger log= LogManager.getLogger();

    public static User findUserById(int id) throws ServiceException{
        UserDaoImpl userDaoImpl =new UserDaoImpl();
        User user=null;
        try {
            user = userDaoImpl.findById(id);
        }catch (DaoException e){
            throw new ServiceException(e);
        }
        return user;
    }

    public static User findUserByLoginAndPassword(String email, String password)throws ServiceException {
        User user=null;
        UserDaoImpl userDaoImpl=new UserDaoImpl();
        try{
           user=userDaoImpl.findUserByLoginAndPassword(email, password);
        }catch (DaoException e){
            throw new ServiceException(e);
        }
        return user;
    }

    public static boolean createUser(String email, String firstName,String lastName, String phone, String address, String role)
                                    throws ServiceException{
        boolean result=false;
        String password= PasswordGenerator.generatePassword();
        String hashedPassword= PasswordHash.doHashForPassword(password);
        UserDaoImpl userDao=new UserDaoImpl();
        try {
            result=userDao.create(new User(0, firstName, lastName, email, hashedPassword, phone, address, role));
            if(result) {
                String message="username: " + email + "\n password: " + password;
                result= EmailSender.sendMail(email, message);
            }
        }catch (DaoException e){
            throw new ServiceException(e);
        }
        return result;
    }

    public static List<User> findAll()throws ServiceException{
        List<User> result=null;
        UserDaoImpl userDao=new UserDaoImpl();
        try{
            result=userDao.findAll();
        }catch (DaoException e){
            throw new ServiceException(e);
        }
        return result;
    }

    public static boolean updateUser(long id, String email, String firstName,String lastName, String phone,
                                     String address, String role)
                                    throws ServiceException{
        boolean result=false;
        UserDaoImpl userDao= new UserDaoImpl();
        try{
            result=userDao.update(new User(id, firstName, lastName, email, phone, address, role));
        }catch (DaoException e){
            throw new ServiceException(e);
        }
        return result;
    }

    public static boolean delete(long id) throws ServiceException{
        boolean result=false;
        UserDaoImpl userDao= new UserDaoImpl();
        try{
            result=userDao.delete(id);
        }catch (DaoException e){
            throw new ServiceException(e);
        }
        return result;
    }
}
