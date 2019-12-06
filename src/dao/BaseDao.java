package dao;

import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.util.Properties;

public class BaseDao {

    static String JDBC_DRIVER = null;
    static String DB_URL = null;
    static String USER = null;
    static String PASS = null;
    static Connection conn = null;

    public static void init() {
        Properties properties = new Properties();
        String configFile = "database.properties";
        InputStream stream = BaseDao.class.getClassLoader().getResourceAsStream(configFile);

        try {
            properties.load(stream);
        } catch (IOException e) {
            e.printStackTrace();
        }

        JDBC_DRIVER = properties.getProperty("JDBC_DRIVER");
        DB_URL = properties.getProperty("DB_URL");
        USER = properties.getProperty("USER");
        PASS = properties.getProperty("PASS");

    }

    static { init(); }

    public static void getConn() throws Exception {
        Class.forName(JDBC_DRIVER);
        if (conn == null || conn.isClosed()) {
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
        }
    }

    public void close(Connection conn, Statement statement, ResultSet resultSet) throws SQLException {
        if (resultSet != null) {
            resultSet.close();
        }
        if (statement != null) {
            statement.close();
        }
        if (conn != null) {
            conn.close();
        }
    }

    public int executeUpdate(String sql) throws Exception {
        getConn();
        Statement statement = conn.createStatement();
        int result = statement.executeUpdate(sql);
        close(conn, statement, null);
        return  result;
    }

    public int executeUpdate(String sql, Object[] paras) throws Exception {
        getConn();
        PreparedStatement statement = conn.prepareStatement(sql);
        for (int i = 0; i < paras.length; i++) {
            statement.setObject(i+1, paras[i]);
        }
        int result = statement.executeUpdate();
        close(conn, statement, null);
        return  result;
    }

    public ResultSet executeQuery(String sql) throws Exception {
        getConn();
        Statement statement = conn.createStatement();
        ResultSet resultSet = statement.executeQuery(sql);
        return resultSet;
    }

    public ResultSet executeQuery(String sql, Object[] paras) throws Exception {
        getConn();
        PreparedStatement statement = conn.prepareStatement(sql);
        for (int i = 0; i < paras.length; i++) {
            statement.setObject(i+1, paras[i]);
        }
        ResultSet resultSet = statement.executeQuery();
        return resultSet;
    }
}
