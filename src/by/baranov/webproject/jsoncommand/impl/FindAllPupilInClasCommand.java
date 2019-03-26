package by.baranov.webproject.jsoncommand.impl;

import by.baranov.webproject.entity.User;
import by.baranov.webproject.jsoncommand.JsonCommand;
import by.baranov.webproject.service.ServiceException;
import by.baranov.webproject.service.UserService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.stream.Collectors;

public class FindAllPupilInClasCommand implements JsonCommand {

    private final static Logger log= LogManager.getLogger();

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response){
        String result="";
        String clas=request.getParameter("clas");
        try {
            result = "[" + UserService.findAllPupilInClas(clas).stream().map(User::toString)
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
