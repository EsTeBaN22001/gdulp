package Persistencia;

import Modelo.Alumno;
import Modelo.ConexionDB;
import Modelo.Inscripcion;
import Modelo.Materia;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class inscripcionData{

    public ArrayList<Inscripcion> obtenerInscripciones(){
        ArrayList<Inscripcion> inscripciones = new ArrayList<Inscripcion>();

        String sql = "SELECT * FROM inscripcion";

        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;

        try{
            conn = ConexionDB.getConexion();

            if( conn != null ){
                stmt = conn.createStatement();

                rs = stmt.executeQuery(sql);

                while( rs.next() ){
                    Inscripcion inscripcion = new Inscripcion();

                    inscripcion.setId(rs.getInt("idinscripto"));
                    inscripcion.setNota(rs.getDouble("nota"));

                    // Cargar alumno y materia asociados
                    Alumno alumno = new Alumno();
                    alumno.setId(rs.getInt("idalumno"));
                    inscripcion.setAlumno(alumno);

                    Materia materia = new Materia();
                    materia.setId(rs.getInt("idmateria"));
                    inscripcion.setMateria(materia);

                    inscripciones.add(inscripcion);
                }
            }

        } catch( SQLException e ){
            System.err.println("Error al obtener inscripciones: " + e.getMessage());
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

        return inscripciones;
    }

    public static boolean existeInscripcion(int idAlumno, int idMateria, int idInscripto){
        String sql = "SELECT COUNT(*) as total FROM inscripcion WHERE idalumno = ? AND idmateria = ? AND idinscripto != ?";

        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        try{
            conn = ConexionDB.getConexion();
            if( conn != null ){
                pstmt = conn.prepareStatement(sql);
                pstmt.setInt(1, idAlumno);
                pstmt.setInt(2, idMateria);
                pstmt.setInt(3, idInscripto);

                rs = pstmt.executeQuery();

                if( rs.next() ){
                    int total = rs.getInt("total");
                    return total > 0;
                }
            }
        } catch( SQLException e ){
            System.err.println("Error al verificar inscripcion: " + e.getMessage());
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

    public static Inscripcion buscarInscripcionPor(String criterio, String texto){
        Inscripcion inscripcion = null;
        String sql = "SELECT * FROM inscripcion WHERE ";

        switch( criterio ){
            case "ID":
                sql += "idinscripto = ?";
                break;
            case "ID Alumno":
                sql += "idalumno = ?";
                break;
            case "ID Materia":
                sql += "idmateria = ?";
                break;
            case "Nota":
                sql += "nota = ?";
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

                if( criterio.equals("Nota") ){
                    pstmt.setDouble(1, Double.parseDouble(texto));
                } else{
                    pstmt.setInt(1, Integer.parseInt(texto));
                }

                rs = pstmt.executeQuery();

                if( rs.next() ){
                    inscripcion = new Inscripcion();
                    inscripcion.setId(rs.getInt("idinscripto"));
                    inscripcion.setNota(rs.getDouble("nota"));

                    // Cargar alumno y materia asociados
                    Alumno alumno = new Alumno();
                    alumno.setId(rs.getInt("idalumno"));
                    inscripcion.setAlumno(alumno);

                    Materia materia = new Materia();
                    materia.setId(rs.getInt("idmateria"));
                    inscripcion.setMateria(materia);
                }
            }
        } catch( SQLException | NumberFormatException e ){
            System.err.println("Error al buscar inscripcion: " + e.getMessage());
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

        return inscripcion;
    }

    public static ArrayList<Inscripcion> obtenerInscripcionesPorAlumno(int idAlumno){
        ArrayList<Inscripcion> inscripciones = new ArrayList<Inscripcion>();
        String sql = "SELECT * FROM inscripcion WHERE idalumno = ?";

        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        try{
            conn = ConexionDB.getConexion();
            if( conn != null ){
                pstmt = conn.prepareStatement(sql);
                pstmt.setInt(1, idAlumno);

                rs = pstmt.executeQuery();

                while( rs.next() ){
                    Inscripcion inscripcion = new Inscripcion();
                    inscripcion.setId(rs.getInt("idinscripto"));
                    inscripcion.setNota(rs.getDouble("nota"));

                    Alumno alumno = new Alumno();
                    alumno.setId(rs.getInt("idalumno"));
                    inscripcion.setAlumno(alumno);

                    Materia materia = new Materia();
                    materia.setId(rs.getInt("idmateria"));
                    inscripcion.setMateria(materia);

                    inscripciones.add(inscripcion);
                }
            }
        } catch( SQLException e ){
            System.err.println("Error al obtener inscripciones por alumno: " + e.getMessage());
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

        return inscripciones;
    }

    public static ArrayList<Inscripcion> obtenerInscripcionesPorMateria(int idMateria){
        ArrayList<Inscripcion> inscripciones = new ArrayList<Inscripcion>();
        String sql = "SELECT * FROM inscripcion WHERE idmateria = ?";

        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        try{
            conn = ConexionDB.getConexion();
            if( conn != null ){
                pstmt = conn.prepareStatement(sql);
                pstmt.setInt(1, idMateria);

                rs = pstmt.executeQuery();

                while( rs.next() ){
                    Inscripcion inscripcion = new Inscripcion();
                    inscripcion.setId(rs.getInt("idinscripto"));
                    inscripcion.setNota(rs.getDouble("nota"));

                    Alumno alumno = new Alumno();
                    alumno.setId(rs.getInt("idalumno"));
                    inscripcion.setAlumno(alumno);

                    Materia materia = new Materia();
                    materia.setId(rs.getInt("idmateria"));
                    inscripcion.setMateria(materia);

                    inscripciones.add(inscripcion);
                }
            }
        } catch( SQLException e ){
            System.err.println("Error al obtener inscripciones por materia: " + e.getMessage());
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

        return inscripciones;
    }

    public static Inscripcion guardarInscripcion(Inscripcion inscripcion){
        String sql = "INSERT INTO inscripcion (nota, idalumno, idmateria) VALUES (?, ?, ?)";

        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        try{
            conn = ConexionDB.getConexion();
            if( conn != null ){
                pstmt = conn.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);

                pstmt.setDouble(1, inscripcion.getNota());
                pstmt.setInt(2, inscripcion.getAlumno().getId());
                pstmt.setInt(3, inscripcion.getMateria().getId());

                int filasAfectadas = pstmt.executeUpdate();

                if( filasAfectadas > 0 ){
                    rs = pstmt.getGeneratedKeys();
                    if( rs.next() ){
                        inscripcion.setId(rs.getInt(1));
                        System.out.println("Inscripcion cargada exitosamente con ID: " + inscripcion.getId());
                    }
                }
            }
        } catch( SQLException e ){
            System.err.println("Error al guardar la inscripcion: " + e.getMessage());
            e.printStackTrace();
            inscripcion = null;
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

        return inscripcion;
    }

    public static boolean actualizarInscripcion(Inscripcion inscripcion){
        String sql = "UPDATE inscripcion SET nota = ?, idalumno = ?, idmateria = ? WHERE idinscripto = ?";

        Connection conn = null;
        PreparedStatement pstmt = null;

        try{
            conn = ConexionDB.getConexion();
            if( conn != null ){
                pstmt = conn.prepareStatement(sql);

                pstmt.setDouble(1, inscripcion.getNota());
                pstmt.setInt(2, inscripcion.getAlumno().getId());
                pstmt.setInt(3, inscripcion.getMateria().getId());
                pstmt.setInt(4, inscripcion.getId());

                int filasAfectadas = pstmt.executeUpdate();

                if( filasAfectadas > 0 ){
                    System.out.println("Inscripcion actualizada exitosamente. ID: " + inscripcion.getId());
                    return true;
                } else{
                    System.out.println("No se encontro la inscripción con ID: " + inscripcion.getId());
                    return false;
                }
            }
        } catch( SQLException e ){
            System.err.println("Error al actualizar la inscripcion: " + e.getMessage());
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

    public static boolean eliminarInscripcion(int idInscripto){
        String sql = "DELETE FROM inscripcion WHERE idinscripto = ?";

        Connection conn = null;
        PreparedStatement pstmt = null;

        try{
            conn = ConexionDB.getConexion();
            if( conn != null ){
                pstmt = conn.prepareStatement(sql);
                pstmt.setInt(1, idInscripto);

                int filasAfectadas = pstmt.executeUpdate();

                if( filasAfectadas > 0 ){
                    System.out.println("Inscripcion eliminada exitosamente. ID: " + idInscripto);
                    return true;
                } else{
                    System.out.println("No se encontro la inscripción con ID: " + idInscripto);
                    return false;
                }
            }
        } catch( SQLException e ){
            System.err.println("Error al eliminar la inscripción: " + e.getMessage());
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

    public static boolean actualizarNota(int idInscripto, double nota){
        String sql = "UPDATE inscripcion SET nota = ? WHERE idinscripto = ?";

        Connection conn = null;
        PreparedStatement pstmt = null;

        try{
            conn = ConexionDB.getConexion();
            if( conn != null ){
                pstmt = conn.prepareStatement(sql);

                pstmt.setDouble(1, nota);
                pstmt.setInt(2, idInscripto);

                int filasAfectadas = pstmt.executeUpdate();

                if( filasAfectadas > 0 ){
                    System.out.println("Nota actualizada exitosamente. Inscripción ID: " + idInscripto);
                    return true;
                } else{
                    System.out.println("No se encontró la inscripción con ID: " + idInscripto);
                    return false;
                }
            }
        } catch( SQLException e ){
            System.err.println("Error al actualizar la nota: " + e.getMessage());
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
