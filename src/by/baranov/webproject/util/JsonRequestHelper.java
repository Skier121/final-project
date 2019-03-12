package by.baranov.webproject.util;

import by.baranov.webproject.jsoncommand.JsonCommand;
import by.baranov.webproject.jsoncommand.impl.*;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;

public class JsonRequestHelper {
    private static JsonRequestHelper instance = null;
    HashMap<String, JsonCommand> commands = new HashMap<>();

    public static JsonRequestHelper getInstance() {
        if (instance == null) {
            instance = new JsonRequestHelper();
        }
        return instance;
    }

    private JsonRequestHelper() {
        commands.put("findAllUsers", new FindAllUsersCommand());
        commands.put("createUser", new CreateUserCommand());
        commands.put("deleteUser", new DeleteUserCommand());
        commands.put("updateUser", new UpdateUserCommand());
        commands.put("setRu", new SetLocaleRuCommand());
        commands.put("setEn", new SetLocaleEnCommand());
    }

    public JsonCommand getCommand(HttpServletRequest request) {
        String action = request.getParameter("action");
        JsonCommand command = commands.get(action);
        return command;
    }
}
