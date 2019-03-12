package by.baranov.webproject.command.impl;

import by.baranov.webproject.command.Command;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LogoutCommand implements Command {
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        String page="/index.jsp";
        request.getSession().setAttribute("userInSystem", null);
        return page;
    }
}
