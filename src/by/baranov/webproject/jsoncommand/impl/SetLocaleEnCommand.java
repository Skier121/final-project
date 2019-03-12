package by.baranov.webproject.jsoncommand.impl;

import by.baranov.webproject.jsoncommand.JsonCommand;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Locale;

public class SetLocaleEnCommand implements JsonCommand {
    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) {
        request.getSession().removeAttribute("locale");
        request.getSession().setAttribute("locale", new Locale("en"));
        response.setContentType("application/json");
        String result = "{\"locale\": \"" + "en" + "\"}";
        try {
            response.getWriter().write(result);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
