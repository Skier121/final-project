package by.baranov.webproject.command.impl;

import by.baranov.webproject.command.Command;
import by.baranov.webproject.util.JspHelper;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LessonCommand implements Command {
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        String lessonId=request.getParameter("lessonId");
        request.getSession().removeAttribute("lessonId");
        request.getSession().setAttribute("lessonId", lessonId);
        String page= JspHelper.getPath("lesson");
        return page;
    }
}
