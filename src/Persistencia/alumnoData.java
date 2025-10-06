package Persistencia;

import Modelo.Alumno;
import Modelo.ConexionDB;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class alumnoData{

    public ArrayList<Alumno> obtenerTodos(){
        ArrayList<Alumno> alumnos = new ArrayList<Alumno>();

        String sql = "SELECT * FROM alumno";

        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;

        try{
            conn = ConexionDB.getConexion();

            if( conn != null ){
                stmt = conn.createStatement();

                rs = stmt.executeQuery(sql);

                while( rs.next() ){
                    Alumno alumno = new Alumno();

                    alumno.setId(rs.getInt("id"));
                    alumno.setDni(rs.getString("dni"));
                    alumno.setApellido(rs.getString("apellido"));
                    alumno.setNombre(rs.getString("nombre"));
                    alumno.setFechaNacimiento(rs.getDate("fechaNacimiento"));
                    alumno.setEstado(rs.getBoolean("estado"));

                    alumnos.add(alumno);
                }
            }
        } catch( SQLException e ){
            System.err.println("Error al obtener alumnos: " + e.getMessage());
            e.printStackTrace();
        } finally{
            try{
                if( rs != null ){ rs.close();}
                
                if( stmt != null ){stmt.close();}
                
            } catch( SQLException e ){
                System.err.println("Error al cerrar recursos: " + e.getMessage());
            }
        }

        return alumnos;
    }
    
    public Alumno buscarAlumnoPor(String criterio, String texto) {
        Alumno alumno = null;
        String sql = "SELECT * FROM alumno WHERE ";

        switch(criterio) {
            case "ID":
                sql += "id = ?";
                break;
            case "DNI":
                sql += "dni = ?";
                break;
            case "Apellido":
                sql += "apellido = ?";
                break;
            case "Nombre":
                sql += "nombre = ?";
                break;
            default:
                return null;
        }

        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        try {
            conn = ConexionDB.getConexion();
            if(conn != null) {
                pstmt = conn.prepareStatement(sql);

                if(criterio.equals("ID")) {
                    pstmt.setInt(1, Integer.parseInt(texto));
                } else {
                    pstmt.setString(1, texto);
                }

                rs = pstmt.executeQuery();

                if(rs.next()) {
                    alumno = new Alumno();
                    alumno.setId(rs.getInt("id"));
                    alumno.setDni(rs.getString("dni"));
                    alumno.setApellido(rs.getString("apellido"));
                    alumno.setNombre(rs.getString("nombre"));
                    alumno.setFechaNacimiento(rs.getDate("fechaNacimiento"));
                    alumno.setEstado(rs.getBoolean("estado"));
                }
            }
        } catch(SQLException | NumberFormatException e) {
            System.err.println("✗ Error al buscar alumno: " + e.getMessage());
            e.printStackTrace();
        } finally {
            try {
                if(rs != null) rs.close();
                if(pstmt != null) pstmt.close();
            } catch(SQLException e) {
                System.err.println("Error al cerrar recursos: " + e.getMessage());
            }
        }

        return alumno;
    }
    
    
    public Alumno guardarAlumno(Alumno alumno){
        
        String sql = "INSERT INTO alumno (dni, apellido, nombre, fechaNacimiento, estado) VALUES (?, ?, ?, ?, ?)";
    
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        try {
            conn = ConexionDB.getConexion();
            if(conn != null) {
                pstmt = conn.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
                
                pstmt.setString(1, alumno.getDni());
                pstmt.setString(2, alumno.getApellido());
                pstmt.setString(3, alumno.getNombre());
                pstmt.setDate(4, new java.sql.Date(alumno.getFechaNacimiento().getTime()));
                pstmt.setBoolean(5, alumno.isEstado());
                
                int filasAfectadas = pstmt.executeUpdate();

                if(filasAfectadas > 0) {
                    rs = pstmt.getGeneratedKeys();
                    if(rs.next()) {
                        alumno.setId(rs.getInt(1));
                        System.out.println("Alumno guardado exitosamente con ID: " + alumno.getId());
                    }
                }
            }
        } catch(SQLException e) {
            System.err.println("Error al guardar alumno: " + e.getMessage());
            e.printStackTrace();
            alumno = null;
        } finally {
            try {
                if(rs != null) rs.close();
                if(pstmt != null) pstmt.close();
            } catch(SQLException e) {
                System.err.println("Error al cerrar recursos: " + e.getMessage());
            }
        }

        return alumno;
    }

}
