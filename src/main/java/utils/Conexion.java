package utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {

    private static final String URL = "jdbc:mysql://localhost:3320/mysql-libreria";
    private static final String USUARIO = "root";
    private static final String CONTRASENA = "admin123";

    public static Connection getConnection() {
        Connection conexion = null;
        try {
            conexion = DriverManager.getConnection(URL, USUARIO, CONTRASENA);
        } catch (SQLException e) {
            System.out.println("ERROR: " + e.getMessage());
            e.printStackTrace();
        }
        return conexion;
}
}