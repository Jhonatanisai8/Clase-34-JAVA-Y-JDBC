package org.jhonatan.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

public class EjemploJdbc {

    public static void main(String[] args) {
        System.out.println("JAVA Y JBDC");
        //indicamos la zona horario para evitar el error de la zona horaria
        String ruta = "jdbc:mysql://localhost:3306/java_curso?serverTimezone=UTC";
        String userName = "root";
        String password = "1234";

        try {

            //le pasamos los parametros
            Connection con = DriverManager.getConnection(ruta, userName, password);

            //creamos una sentencia 
            Statement stmt = con.createStatement();

            //resultado 
            ResultSet resultado = stmt.executeQuery("SELECT * FROM productos");

            //movemos el cursor
            while (resultado.next()) {
                System.out.println(resultado.getString("nombre"));
            }

            //cerramos los recursos
            resultado.close();
            stmt.close();
            con.close();
        } catch (SQLException ex) {
            Logger.getLogger(EjemploJdbc.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
}
