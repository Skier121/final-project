package by.baranov.webproject.command.impl;

import by.baranov.webproject.command.Command;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class NoCommand implements Command {

    public String execute(HttpServletRequest request, HttpServletResponse response){
        String page = "/index.jsp";
        return page;
    }
}
