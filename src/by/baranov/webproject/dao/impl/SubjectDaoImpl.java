package by.baranov.webproject.dao.impl;

import by.baranov.webproject.dao.AbstractDao;
import by.baranov.webproject.dao.DaoException;
import by.baranov.webproject.dto.LessonDto;
import by.baranov.webproject.entity.Subject;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class SubjectDaoImpl extends AbstractDao<Subject> {
    private final static Logger log = LogManager.getLogger();
    private final String SUBJECT_SUBJECT_NAME = "subject.subject_name";
    private final String TIMETABLE_CLASS_NAME = "timetable.class_name";
    private final String TIMETABLE_LESSON_NUMBER = "timetable.lesson_number";
    private final String SUBJECT_ID = "subject_id";
    private final String SUBJECT_NAME = "subject_name";
    private final String TEACHER_ID = "teacher_id";
    private final String FIND_ALL_TEACHER_SUBJECT = "SELECT subject.subject_name IN (SELECT subject_name FROM subject" +
            " WHERE subject.subject_id = timetable.subject_id), timetable.class_name, timetable.lesson_number FROM timetable" +
            " WHERE timetable.subject_id IN (SELECT subject_id FROM subject WHERE teacher_id = ?) AND timetable.date = ?";
    private final String FIND_ALL_SUBJECT = "SELECT subject_id, subject_name, teacher_id FROM subject";
    private final String FIND_SUBJECT_BY_ID = "SELECT subject_id, subject_name, teacher_id FROM subject WHERE subject_id = ?";
    private final String DELETE_SUBJECT_BY_ID = "DELETE FROM subject WHERE subject_id = ?";
    private final String CREATE_SUBJECT = "INSERT INTO subject SET subject_name = ?, teacher_id = ?";
    private final String UPDATE_SUBJECT = "UPDATE subject SET subject_name = ?, teacher_id = ? WHERE subject_id = ?";

    @Override
    public List<Subject> findAll() throws DaoException {
        List<Subject> resultList = new ArrayList<>();
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;
        try {
            connection = getConnectionPool().getConnection();
            statement = connection.createStatement();
            resultSet = statement.executeQuery(FIND_ALL_SUBJECT);
            while (resultSet.next()) {
                long subjectId = resultSet.getLong(SUBJECT_ID);
                String subjectName = resultSet.getString(SUBJECT_NAME);
                long teacherId = resultSet.getLong(TEACHER_ID);
                resultList.add(new Subject(subjectId, subjectName, teacherId));
            }
        } catch (SQLException e) {
            throw new DaoException(e);
        } finally {
            releaseResources(resultSet, statement, connection);
        }
        return resultList;
    }

    @Override
    public Subject findById(long id) throws DaoException {
        Subject result = null;
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try {
            connection = getConnectionPool().getConnection();
            preparedStatement = connection.prepareStatement(FIND_SUBJECT_BY_ID);
            preparedStatement.setLong(1, id);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                long subjectId = resultSet.getLong(SUBJECT_ID);
                String subjectName = resultSet.getString(SUBJECT_NAME);
                long teacherId = resultSet.getLong(TEACHER_ID);
                result = new Subject(subjectId, subjectName, teacherId);
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
            preparedStatement = connection.prepareStatement(DELETE_SUBJECT_BY_ID);
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
    public boolean create(Subject subject) throws DaoException {
        boolean result = false;
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            connection = getConnectionPool().getConnection();
            preparedStatement = connection.prepareStatement(CREATE_SUBJECT);
            preparedStatement.setString(1, subject.getSubjectName());
            preparedStatement.setLong(2, subject.getTeacherId());
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
    public boolean update(Subject subject) throws DaoException {
        boolean result = false;
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            connection = getConnectionPool().getConnection();
            preparedStatement = connection.prepareStatement(UPDATE_SUBJECT);
            preparedStatement.setString(1, subject.getSubjectName());
            preparedStatement.setLong(2, subject.getTeacherId());
            preparedStatement.setLong(3, subject.getSubjectId());
            preparedStatement.executeUpdate();
            result = true;
        } catch (SQLException e) {
            throw new DaoException(e);
        } finally {
            releaseResources(preparedStatement, connection);
        }
        return result;
    }

    public List<LessonDto> findAllTeacherSubject(long teacherId, Date date) throws DaoException {
        List<LessonDto> resultList = new ArrayList<>();
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;
        PreparedStatement preparedStatement = null;
        try {
            connection = getConnectionPool().getConnection();
            preparedStatement = connection.prepareStatement(FIND_ALL_TEACHER_SUBJECT);
            preparedStatement.setLong(1, teacherId);
            preparedStatement.setDate(2, date);
            while (resultSet.next()) {
                int lessonNumber = resultSet.getInt(TIMETABLE_LESSON_NUMBER);
                String subjectName = resultSet.getString(SUBJECT_SUBJECT_NAME);
                String className = resultSet.getString(TIMETABLE_CLASS_NAME);
                resultList.add(new LessonDto(lessonNumber, subjectName, className));
            }
        } catch (SQLException e) {
            throw new DaoException(e);
        } finally {
            releaseResources(resultSet, preparedStatement, connection);
        }
        return resultList;
    }
}
