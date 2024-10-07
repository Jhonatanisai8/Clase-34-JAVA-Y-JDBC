package org.jhonatan.jdbc;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.jhonatan.jdbc.modelo.Producto;
import org.jhonatan.jdbc.modelo.repositorio.ProductoRepositorioImpl;
import org.jhonatan.jdbc.modelo.repositorio.Repositorio;
import org.jhonatan.jdbc.util.ConexionBaseDatos;

public class EjemploJdbc {

    public static void main(String[] args) {
        System.out.println("JAVA Y JBDC");

        try ( //le pasamos los parametros
                 Connection con = ConexionBaseDatos.getInstance();) {

            Repositorio<Producto> repositorio = new ProductoRepositorioImpl();
            repositorio.listar().forEach(p -> System.out.println(p.getNombre()));

        } catch (SQLException ex) {
            Logger.getLogger(EjemploJdbc.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
