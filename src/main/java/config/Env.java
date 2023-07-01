package config;

import java.util.UUID;

public class Env {
    public String uuid = new UUID(0, 0).randomUUID().toString();
    // public static final String PATH_BASE = "C:\\Users\\anast\\OneDrive\\Documents\\jornal-do-brasil";
    public static final String PATH_BASE = "E:\\jornal-do-brasil";
    public static final String db_USER = "root";
    public static final String db_PASSWORD = "123456";
    public static final String db_URL = "jdbc:mysql://127.0.0.1:3306/db_jornal_do_brasil";
    public static final String db_DRIVER = "com.mysql.jdbc.Driver";
}