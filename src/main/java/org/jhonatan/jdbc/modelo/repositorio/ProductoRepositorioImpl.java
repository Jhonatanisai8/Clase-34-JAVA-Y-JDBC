package org.jhonatan.jdbc.modelo.repositorio;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import org.jhonatan.jdbc.modelo.Producto;
import org.jhonatan.jdbc.util.ConexionBaseDatos;

public class ProductoRepositorioImpl
        implements Repositorio<Producto> {

    private Connection getConection() throws SQLException {
        return ConexionBaseDatos.getInstance();
    }

    @Override
    public List<Producto> listar() {
        List<Producto> productos = new ArrayList<>();
        try ( Statement stmt = getConection().createStatement();  ResultSet rs = stmt.executeQuery("SELECT * FROM productos")) {
            while (rs.next()) {
                Producto p = new Producto();
                p.setId(rs.getLong("idproducto"));
                p.setNombre(rs.getString("nombre"));
                p.setPrecio(rs.getInt("precio"));
                p.setFechaRegistro(rs.getDate("fecha"));
                //agregamos al arraylist
                productos.add(p);
            }
        } catch (Exception e) {
            System.out.println("error al listar: " + e.getMessage());
        }
        
        //revolvemos la lista
        return productos;
    }

    @Override
    public Producto porId(Long id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void guardar(Producto t) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void eliminar(Long id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
