package by.baranov.webproject.util;

import by.baranov.webproject.command.*;
import by.baranov.webproject.command.impl.*;
import by.baranov.webproject.entity.User;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;

public class RequestHelper {

    private static RequestHelper instance = null;
    HashMap<String, Command> commands = new HashMap<String, Command>();

    public static RequestHelper getInstance() {
        if (instance == null) {
            instance = new RequestHelper();
        }
        return instance;
    }

    private RequestHelper() {
        commands.put("login", new LoginCommand());
        commands.put("logout", new LogoutCommand());
        commands.put("subjectAndTeacher", new SubjectAntTeacherCommand());
        commands.put("classes", new ClassesCommand());
        commands.put("users", new UsersCommand());
        commands.put("passwordRecovery", new PasswordRecoveryCommand());
        commands.put("beginLesson", new LessonCommand());
    }

    public Command getCommand(HttpServletRequest request) {
        String action = request.getParameter("command") != null ? request.getParameter("command") : (String) request.getAttribute("command");
        Command command = commands.get(action);
        if (command == null) {
            command = new NoCommand();
        }
        return command;
    }
}
