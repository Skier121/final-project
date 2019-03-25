package by.baranov.webproject.jsoncommand.impl;

import by.baranov.webproject.jsoncommand.JsonCommand;
import by.baranov.webproject.service.ServiceException;
import by.baranov.webproject.service.SubjectService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class UpdateSubjectCommand implements JsonCommand {
    private final static Logger log= LogManager.getLogger();

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) {
        boolean updateResult;
        String result="";
        try {
            updateResult= SubjectService.updateSubject(
                    Long.parseLong(request.getParameter("subjectId")),
                    request.getParameter("subjectName"),
                    Long.parseLong(request.getParameter("teacherId")));
            if(updateResult) {
                result = "{\"result\": \"success!\"}";
            }
        } catch (ServiceException e) {
            log.warn("Service Exception occured", e);
            result = "{\"error\": \"" + e.getMessage() + "\"}";
        }finally {
            try {
                response.getWriter().write(result);
            }catch (IOException e){
                log.warn("IOException occured", e);
            }
        }
    }
}
