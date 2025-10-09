package Persistencia;

import Modelo.ConexionDB;
import Modelo.Materia;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class materiaData {
    
    public static ArrayList<Materia> obtenerMaterias() {
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
            System.err.println("Error al obtener materias: " + e.getMessage());
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
    
    public static boolean existeNombre(String nombre, int id){
        String sql = "SELECT COUNT(*) as total FROM materia WHERE nombre = ? AND id != ?";

        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        try{
            conn = ConexionDB.getConexion();
            if( conn != null ){
                pstmt = conn.prepareStatement(sql);
                pstmt.setString(1, nombre);
                pstmt.setInt(2, id);

                rs = pstmt.executeQuery();

                if( rs.next() ){
                    int total = rs.getInt("total");
                    return total > 0;
                }
            }
        } catch( SQLException e ){
            System.err.println("Error al verificar Nombre: " + e.getMessage());
            e.printStackTrace();
        } finally{
            try{
                if( rs != null ){
                    rs.close();
                }
                if( pstmt != null ){
                    pstmt.close();
                }
            } catch( SQLException e ){
                System.err.println("Error al cerrar recursos: " + e.getMessage());
            }
        }

        return false;
    }
    
     public static Materia buscarMateriaPor(String criterio, String texto){
        Materia materia = null;
        String sql = "SELECT * FROM materia WHERE ";

        switch( criterio ){
            case "ID":
                sql += "id = ?";
                break;
            case "Nombre":
                sql += "nombre = ?";
                break;
            case "Año":
                sql += "año = ?";
                break;
            case "Estado":
                sql += "estado = ?";
                break;
            case "Id Inscripto":
                sql += "isInscripto = ?";
                break;
            default:
                return null;
        }

        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        try{
            conn = ConexionDB.getConexion();
            if( conn != null ){
                pstmt = conn.prepareStatement(sql);

                if( criterio.equals("ID") ){
                    pstmt.setInt(1, Integer.parseInt(texto));
                } else{
                    pstmt.setString(1, texto);
                }

                rs = pstmt.executeQuery();

                if( rs.next() ){
                    materia = new Materia();
                    materia.setId(rs.getInt("id"));
                    materia.setNombre(rs.getString("nombre"));
                    materia.setAño(rs.getInt("año"));
                    materia.setEstado(rs.getBoolean("estado"));
                    
                }
            }
        } catch( SQLException | NumberFormatException e ){
            System.err.println("Error al buscar materia: " + e.getMessage());
            e.printStackTrace();
        } finally{
            try{
                if( rs != null ){
                    rs.close();
                }
                if( pstmt != null ){
                    pstmt.close();
                }
            } catch( SQLException e ){
                System.err.println("Error al cerrar recursos: " + e.getMessage());
            }
        }

        return materia;
    }
    public static Materia guardarMateria(Materia materia){

        String sql = "INSERT INTO materia (id, nombre, año, estado, idinscripto) VALUES (?,?,?,?,?)";

        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        try{
            conn = ConexionDB.getConexion();
            if( conn != null ){
                pstmt = conn.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);

                pstmt.setInt(1, materia.getId());
                pstmt.setString(2, materia.getNombre());
                pstmt.setInt(3, materia.getAño());
                pstmt.setBoolean(4, materia.isEstado());

                int filasAfectadas = pstmt.executeUpdate();

                if( filasAfectadas > 0 ){
                    rs = pstmt.getGeneratedKeys();
                    if( rs.next() ){
                        materia.setId(rs.getInt(1));
                        System.out.println("Materia cargada exitosamente con ID: " + materia.getId());
                    }
                }
            }
        } catch( SQLException e ){
            System.err.println("Error al guardar la Materia: " + e.getMessage());
            e.printStackTrace();
            materia = null;
        } finally{
            try{
                if( rs != null ){
                    rs.close();
                }
                if( pstmt != null ){
                    pstmt.close();
                }
            } catch( SQLException e ){
                System.err.println("Error al cerrar recursos: " + e.getMessage());
            }
        }

        return materia;
    }
    
    public static boolean actualizarMateria(Materia materia){
        
        String sql = "UPDATE materia SET id = ?, nombre = ?, año = ?, estado = ?, idinscripto =? WHERE id = ?";

        Connection conn = null;
        PreparedStatement pstmt = null;

        try{
            conn = ConexionDB.getConexion();
            if( conn != null ){
                pstmt = conn.prepareStatement(sql);

                pstmt.setInt(1, materia.getId());
                pstmt.setString(2, materia.getNombre());
                pstmt.setInt(3, materia.getAño());
                pstmt.setBoolean(4, materia.isEstado());
                pstmt.setInt(5, materia.setIdInscripto());

                int filasAfectadas = pstmt.executeUpdate();

                if( filasAfectadas > 0 ){
                    System.out.println("Materia actualizada exitosamente. ID: " + materia.getId());
                    return true;
                } else{
                    System.out.println("No se encontró la Materia con ID: " + materia.getId());
                    return false;
                }
            }
        } catch( SQLException e ){
            System.err.println("Error al actualizar la Materia: " + e.getMessage());
            e.printStackTrace();
            return false;
        } finally{
            try{
                if( pstmt != null ){
                    pstmt.close();
                }
            } catch( SQLException e ){
                System.err.println("Error al cerrar recursos: " + e.getMessage());
            }
        }

        return false;
    }
    public static boolean eliminarMateria(int id){
        String sql = "DELETE FROM materia WHERE id = ?";

        Connection conn = null;
        PreparedStatement pstmt = null;

        try{
            conn = ConexionDB.getConexion();
            if( conn != null ){
                pstmt = conn.prepareStatement(sql);
                pstmt.setInt(1, id);

                int filasAfectadas = pstmt.executeUpdate();

                if( filasAfectadas > 0 ){
                    System.out.println("Materia eliminada exitosamente. ID: " + id);
                    return true;
                } else{
                    System.out.println("No se encontró la Materia con ID: " + id);
                    return false;
                }
            }
        } catch( SQLException e ){
            System.err.println("Error al eliminar Materia: " + e.getMessage());
            e.printStackTrace();
            return false;
        } finally{
            try{
                if( pstmt != null ){
                    pstmt.close();
                }
            } catch( SQLException e ){
                System.err.println("Error al cerrar recursos: " + e.getMessage());
            }
        }

        return false;
    }
    
    
/*
             /\_/\           ___
            = o_o =_______    \ \
             __^      __(  \.__) )
         (@)<_____>__(_____)____/
*/
    
}
