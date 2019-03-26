package by.baranov.webproject.service;

import by.baranov.webproject.dao.DaoException;
import by.baranov.webproject.dao.impl.SubjectDaoImpl;
import by.baranov.webproject.dto.LessonDto;
import by.baranov.webproject.entity.Subject;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.Date;
import java.util.List;

public class SubjectService {
    private static final Logger log= LogManager.getLogger();

    public static Subject findSubjectById(int id) throws ServiceException{
        SubjectDaoImpl subjectDaoImpl =new SubjectDaoImpl();
        Subject subject=null;
        try {
            subject = subjectDaoImpl.findById(id);
        }catch (DaoException e){
            throw new ServiceException(e);
        }
        return subject;
    }

    public static boolean createSubject(String subjectName, long teacherId) throws ServiceException{
        boolean result=false;
        SubjectDaoImpl subjectDao=new SubjectDaoImpl();
        try {
            result=subjectDao.create(new Subject(subjectName, teacherId));
        }catch (DaoException e){
            throw new ServiceException(e);
        }
        return result;
    }

    public static List<Subject> findAll()throws ServiceException{
        List<Subject> result=null;
        SubjectDaoImpl subjectDao=new SubjectDaoImpl();
        try{
            result=subjectDao.findAll();
        }catch (DaoException e){
            throw new ServiceException(e);
        }
        return result;
    }

    public static boolean updateSubject(long subjectId, String subjectName, long teacherId) throws ServiceException{
        boolean result=false;
        SubjectDaoImpl subjectDao=new SubjectDaoImpl();
        try{
            result=subjectDao.update(new Subject(subjectId, subjectName, teacherId));
        }catch (DaoException e){
            throw new ServiceException(e);
        }
        return result;
    }

    public static boolean delete(long id) throws ServiceException{
        boolean result=false;
        SubjectDaoImpl subjectDao=new SubjectDaoImpl();
        try{
            result=subjectDao.delete(id);
        }catch (DaoException e){
            throw new ServiceException(e);
        }
        return result;
    }
    public static List<LessonDto> findAllTeacherSubject(long teacherId, Date date)throws ServiceException{
        List<LessonDto> result=null;
        SubjectDaoImpl subjectDao=new SubjectDaoImpl();
        try{
            result=subjectDao.findAllTeacherSubject(teacherId, date);
        }catch (DaoException e){
            throw new ServiceException(e);
        }
        return result;
    }
}
