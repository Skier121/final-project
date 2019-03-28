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
        commands.put("createClas", new CreateClasCommand());
        commands.put("findAllClas", new FindAllClasCommand());
        commands.put("deleteClas", new DeleteClasCommand());
        commands.put("updateClas", new UpdateClasCommand());
        commands.put("recoverPassword", new RecoverPasswordCommand());
        commands.put("createSubject", new CreateSubjectCommand());
        commands.put("updateSubject", new UpdateSubjectCommand());
        commands.put("deleteSubject", new DeleteSubjectCommand());
        commands.put("findAllSubject", new FindAllSubjectCommand());
        commands.put("findAllTeacher", new FindAllTeacherCommand());
        commands.put("findAllPupilInClas", new FindAllPupilInClasCommand());
        commands.put("addPupilToClas", new AddPupilToClasCommand());
        commands.put("deletePupil", new DeletePupilCommand());
        commands.put("findAllTeacherSubject", new FindAllTeacherSubjectCommand());
        commands.put("findAllMarks", new FindAllMarksCommand());
        commands.put("findAllLessonsAndHomework", new FindAllLessonsAndHomeworkCommand());
        commands.put("newPassword", new NewPasswordCommand());
        commands.put("updateUserData", new UpdateUserDataCommand());
        commands.put("findUserData", new FindUserDataCommand());
    }

    public JsonCommand getCommand(HttpServletRequest request) {
        String action = request.getParameter("action");
        JsonCommand command = commands.get(action);
        return command;
    }
}
