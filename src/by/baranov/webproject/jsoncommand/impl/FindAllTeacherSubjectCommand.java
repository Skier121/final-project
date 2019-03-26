package by.baranov.webproject.jsoncommand.impl;

import by.baranov.webproject.dto.LessonDto;
import by.baranov.webproject.entity.User;
import by.baranov.webproject.jsoncommand.JsonCommand;
import by.baranov.webproject.service.ServiceException;
import by.baranov.webproject.service.SubjectService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Date;
import java.util.stream.Collectors;

public class FindAllTeacherSubjectCommand implements JsonCommand {

    private final static Logger log= LogManager.getLogger();

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response){
        String result="";
        User user= (User)request.getAttribute("user");
        long teacherId= user.getUserId();
        Date date= (Date)request.getAttribute("date");
        try {
            result = "[" + SubjectService.findAllTeacherSubject(teacherId, date).stream().map(LessonDto::toString)
                    .collect(Collectors.joining(",")) + "]";
        } catch (ServiceException e) {
            log.warn("Service Exception occured", e);
            result = "{\"error\": \"" + e.getMessage() + "\"}";
        }finally{
            try {
                response.getWriter().write(result);
            }catch (IOException e){
                log.warn("IOException occured", e);
            }
        }
    }
}
