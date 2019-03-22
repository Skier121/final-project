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

public class RecoverPasswordCommand implements JsonCommand {
    private final static Logger log=LogManager.getLogger();

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) {
        String result="";
        String login=request.getParameter("email");
        try {
            result=UserService.passwordRecovery(login);
        } catch (ServiceException e) {
            log.warn("Service Exception occured", e);
            result = "{\"result\": \"error\": \"" + e.getMessage() + "\"}";
        } finally {
            try {
                response.getWriter().write(result);
            } catch (IOException e) {
                log.warn("IOException occured", e);
            }
        }
    }
}
