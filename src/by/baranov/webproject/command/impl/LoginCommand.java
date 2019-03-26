package by.baranov.webproject.command.impl;

import by.baranov.webproject.command.Command;
import by.baranov.webproject.entity.User;
import by.baranov.webproject.service.ServiceException;
import by.baranov.webproject.service.UserService;
import by.baranov.webproject.util.JspHelper;
import by.baranov.webproject.util.PasswordHash;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Locale;
import java.util.ResourceBundle;

public class LoginCommand implements Command {
    private static final Logger log = LogManager.getLogger();
    public static final String PARAM_NAME_LOGIN = "login";
    public static final String PARAM_NAME_PASSWORD = "password";
    private static final String WRONG_USER_DATA = "login.wrongUserData";
    private Locale locale;
    private ResourceBundle resourceBundle;

    public String execute(HttpServletRequest request, HttpServletResponse response) {
        locale = (Locale) request.getSession().getAttribute("locale");
        resourceBundle = ResourceBundle.getBundle("/resources/l18n/page_content", locale);
        String page = null;
        String login = request.getParameter(PARAM_NAME_LOGIN);
        String password = request.getParameter(PARAM_NAME_PASSWORD);
        password = PasswordHash.doHashForPassword(password);
        if (login == null) {
            login = (String) request.getAttribute(PARAM_NAME_LOGIN);
            password = (String) request.getAttribute(PARAM_NAME_PASSWORD);
            password = PasswordHash.doHashForPassword(password);
        }
        User user = null;
        try {
            user = UserService.findUserByLoginAndPassword(login, password);
            request.getSession().setAttribute("userInSystem", user);
        } catch (ServiceException e) {
            log.warn("ServiceException occured", e);
            request.getSession().setAttribute("userInSystem", null);
        }
        if (user != null) {
            switch (user.getRole()) {
                case "ADMIN":
                    page = (JspHelper.getPath("admin_main"));
                    break;
                case "TEACHER":
                    page = (JspHelper.getPath("teacher_main"));
                    break;
                case "PUPIL":
                    page = (JspHelper.getPath("pupil_main"));
                    break;
                case "PARENT":
                    page = (JspHelper.getPath("parent_main"));
                    break;
                default:
                    page = "/index.jsp";
                    request.getSession().setAttribute("wrong_data", resourceBundle.getString(WRONG_USER_DATA));
            }
        } else {
            page = "/index.jsp";
            request.getSession().setAttribute("wrong_data", resourceBundle.getString(WRONG_USER_DATA));
        }
        return page;
    }
}
