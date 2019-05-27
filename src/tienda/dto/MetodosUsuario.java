/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tienda.dto;

import java.sql.*;

/**
 *
 * @author aparcerozas
 */
public class MetodosUsuario {
    
    public Connection conectar() {
        String url = "jdbc:sqlite:tienda.db";
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(url);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return conn;
    }
    
    public void crearTablaUsuarios() {
        String sql1 = "DROP TABLE IF EXISTS usuarios;\n";
        String sql2 = "CREATE TABLE IF NOT EXISTS usuarios (\n"
                + "usuario text PRIMARY KEY,\n"
                + "contraseña text NOT NULL,\n"
                + "tipo text,\n"
                + ");";
        try (Connection conn = this.conectar();
            Statement stmt = conn.createStatement()) {
            stmt.execute(sql1);
            stmt.execute(sql2);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    
    public void registrarCliente(String usuario, String contraseña) {
        String sql = "INSERT INTO usuarios VALUES(?,?,'cliente')";
        try (Connection conn = this.conectar();
            PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, usuario);
            pstmt.setString(2, contraseña);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    
    public boolean buscarUsuario(String usuario, String contraseña, String tipo){
        boolean encontrado = false;
        String sql = "SELECT usuario,contraseña"
        + " FROM alumnos WHERE tipo = ?";
        try (Connection conn = this.conectar();
            PreparedStatement pstmt  = conn.prepareStatement(sql)){
            pstmt.setString(1, tipo);
            ResultSet rs  = pstmt.executeQuery();
            while (rs.next()) {
                if(rs.getString("usuario") == usuario & rs.getString("contraseña") == contraseña){
                    encontrado = true;
                    return encontrado;
                }
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            return encontrado;
        }
    }
    
}
