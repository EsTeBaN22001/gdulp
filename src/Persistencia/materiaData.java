package Persistencia;

import Modelo.ConexionDB;
import Modelo.Materia;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class materiaData {
    
    public ArrayList<Materia> obtenerMaterias() {
        ArrayList<Materia> materias = new ArrayList<Materia>();
        
        String sql = "SELECT * FROM materia";
        
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;
        
        try {
            conn = ConexionDB.getConexion();
            
            if (conn != null) {
                stmt = conn.createStatement();
                
                rs = stmt.executeQuery(sql);
                
                while (rs.next()) {
                    Materia materia = new Materia();
                    
                    materia.setId(rs.getInt("id"));
                    materia.setNombre(rs.getString("nombre"));
                    materia.setAño(rs.getInt("año"));
                    materia.setEstado(rs.getBoolean("estado"));
                    
                    materias.add(materia);
                }
            }
            
        } catch (SQLException e) {
            System.err.println("✗ Error al obtener materias: " + e.getMessage());
            e.printStackTrace();
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
                if (stmt != null) {
                    stmt.close();
                }
            } catch (SQLException e) {
                System.err.println("Error al cerrar recursos: " + e.getMessage());
            }
        }
        
        return materias;
    }
/*
             /\_/\           ___
            = o_o =_______    \ \
             __^      __(  \.__) )
         (@)<_____>__(_____)____/
*/
    
}
