package Persistencia;

import Modelo.Alumno;
import Modelo.ConexionDB;
import java.sql.Connection;
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
            System.err.println("✗ Error al obtener alumnos: " + e.getMessage());
            e.printStackTrace();
        } finally{
            try{
                if( rs != null ){
                    rs.close();
                }
                if( stmt != null ){
                    stmt.close();
                }
            } catch( SQLException e ){
                System.err.println("Error al cerrar recursos: " + e.getMessage());
            }
        }

        return alumnos;
    }

}
