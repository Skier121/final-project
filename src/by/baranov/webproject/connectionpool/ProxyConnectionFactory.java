package by.baranov.webproject.connectionpool;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class ProxyConnectionFactory {

    public static ProxyConnection getProxyConnection()throws SQLException {
        ResourceBundle resource=ResourceBundle.getBundle("/resources/connection");
        String url=resource.getString("db.url");
        String user=resource.getString("db.user");
        String pwd=resource.getString("db.pwd");
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        Connection connection = DriverManager.getConnection(url, user, pwd);
        ProxyConnection proxyConnection = new ProxyConnection(connection);
        return proxyConnection;
    }
}
