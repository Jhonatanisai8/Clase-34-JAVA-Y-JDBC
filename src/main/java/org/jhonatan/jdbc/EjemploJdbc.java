package org.jhonatan.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.jhonatan.jdbc.util.ConexionBaseDatos;

public class EjemploJdbc {

    public static void main(String[] args) {
        System.out.println("JAVA Y JBDC");

        try (
                //le pasamos los parametros
                 Connection con = ConexionBaseDatos.getInstance();  Statement stmt = con.createStatement(); //resultado 
                  ResultSet resultado = stmt.executeQuery("SELECT * FROM productos")) {
            //movemos el cursor
            while (resultado.next()) {
                System.out.print(resultado.getInt("idproducto"));
                System.out.print(" | ");
                System.out.print(resultado.getString("nombre"));
                System.out.print(" | ");
                System.out.print(resultado.getDouble("precio"));
                System.out.print(" | ");
                System.out.println(resultado.getDate("fecha"));
            }

        } catch (SQLException ex) {
            Logger.getLogger(EjemploJdbc.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
