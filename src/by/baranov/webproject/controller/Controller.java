package by.baranov.webproject.controller;

import by.baranov.webproject.command.Command;
import by.baranov.webproject.entity.User;
import by.baranov.webproject.util.RequestHelper;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static by.baranov.webproject.command.impl.LoginCommand.PARAM_NAME_LOGIN;
import static by.baranov.webproject.command.impl.LoginCommand.PARAM_NAME_PASSWORD;

@WebServlet("/controller")
public class Controller extends HttpServlet {

    private RequestHelper requestHelper = RequestHelper.getInstance();

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        processRequest(request, response);
        User user = (User) request.getSession().getAttribute("userInSystem");
        if (user != null){
            request.setAttribute(PARAM_NAME_LOGIN, user.getEmail());
            request.setAttribute(PARAM_NAME_PASSWORD, user.getPassword());
            request.setAttribute("command", "login");
        }
        processRequest(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        processRequest(request, response);
    }

    private void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String page = null;
        String action = request.getParameter("command");
        Command command = requestHelper.getCommand(request);
        page = command.execute(request, response);
        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(page);
        dispatcher.forward(request, response);
    }
}
