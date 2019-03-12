package by.baranov.webproject.util;

public class JspHelper {
    public static String getPath(String fileName){
        String prefix="/WEB-INF/jsp/";
    String postfix=".jsp";
        return (prefix+fileName+postfix);
}
}
