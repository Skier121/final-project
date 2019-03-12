package by.baranov.webproject.service;

import by.baranov.webproject.dao.DaoException;
import by.baranov.webproject.dao.impl.ClassDaoImpl;
import by.baranov.webproject.entity.Clas;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;

public class ClasService {
    private static final Logger log= LogManager.getLogger();

    public static Clas findClasById(int id) throws ServiceException{
        ClassDaoImpl clasDao =new ClassDaoImpl();
        Clas clas=null;
        try {
            clas = clasDao.findById(id);
        }catch (DaoException e){
            throw new ServiceException(e);
        }
        return clas;
    }

    public static boolean createClas(long clasId, String clasName)
            throws ServiceException{
        boolean result=false;
        ClassDaoImpl clasDao =new ClassDaoImpl();
        try {
            result=clasDao.create(new Clas(0, clasName));
        }catch (DaoException e){
            throw new ServiceException(e);
        }
        return result;
    }

    public static List<Clas> findAll()throws ServiceException{
        List<Clas> result=null;
        ClassDaoImpl clasDao =new ClassDaoImpl();
        try{
            result=clasDao.findAll();
        }catch (DaoException e){
            throw new ServiceException(e);
        }
        return result;
    }

    public static boolean updateClas(long id, String clasName)
            throws ServiceException{
        boolean result=false;
        ClassDaoImpl clasDao =new ClassDaoImpl();
        try{
            result=clasDao.update(new Clas(id, clasName));
        }catch (DaoException e){
            throw new ServiceException(e);
        }
        return result;
    }

    public static boolean delete(long id) throws ServiceException{
        boolean result=false;
        ClassDaoImpl clasDao =new ClassDaoImpl();
        try{
            result=clasDao.delete(id);
        }catch (DaoException e){
            throw new ServiceException(e);
        }
        return result;
    }
}
