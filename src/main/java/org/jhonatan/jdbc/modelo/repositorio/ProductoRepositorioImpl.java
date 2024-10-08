package org.jhonatan.jdbc.modelo.repositorio;

import java.sql.Connection;
import java.sql.PreparedStatement;
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
                Producto p = creaProducto(rs);
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
        Producto p = null;
        try ( PreparedStatement stmt = getConection()
                .prepareStatement("SELECT * FROM productos WHERE idproducto = ?")) {

            //parametro de la consulta
            stmt.setLong(1, id);

            //ejecutamos la consulta 
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                p = creaProducto(rs);
            }

            rs.close();
        } catch (Exception e) {
            System.out.println("Error por id: " + e.getMessage());
        }

        return p;
    }

    @Override
    public void guardar(Producto t) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void eliminar(Long id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public Producto creaProducto(ResultSet rs) throws SQLException {
        Producto p = new Producto();
        p.setId(rs.getLong("idproducto"));
        p.setNombre(rs.getString("nombre"));
        p.setPrecio(rs.getInt("precio"));
        p.setFechaRegistro(rs.getDate("fecha"));
        return p;
    }
}
