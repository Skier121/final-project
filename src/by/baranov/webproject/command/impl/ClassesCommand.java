package by.baranov.webproject.command.impl;

import by.baranov.webproject.command.Command;
import by.baranov.webproject.util.JspHelper;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ClassesCommand implements Command {
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        String page= JspHelper.getPath("adminClasses");
        return page;
    }
}
