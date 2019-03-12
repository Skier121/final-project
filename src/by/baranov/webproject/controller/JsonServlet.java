package by.baranov.webproject.controller;

import by.baranov.webproject.jsoncommand.JsonCommand;
import by.baranov.webproject.util.JsonRequestHelper;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/json")
public class JsonServlet extends HttpServlet {
    private static final Logger log= LogManager.getLogger();
    private JsonRequestHelper requestHelper = JsonRequestHelper.getInstance();

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
    }

    private void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("application/json");
        JsonCommand jsonCommand = requestHelper.getCommand(request);
        jsonCommand.execute(request, response);
        System.out.println(request.getSession().getAttribute("locale"));
    }
}
