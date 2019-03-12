package by.baranov.webproject.jsoncommand;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface JsonCommand {
    void execute(HttpServletRequest request, HttpServletResponse response);
}
