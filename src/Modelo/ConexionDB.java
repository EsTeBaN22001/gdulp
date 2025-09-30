package Modelo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexionDB{

    private static final String URL = "jdbc:mysql://localhost:3306/sgulp";
    private static final String USUARIO = "root";
    private static final String PASSWORD = "";
    private static final String DRIVER = "com.mysql.cj.jdbc.Driver";

    private static Connection conexion = null;

    private ConexionDB(){

    }

    public static Connection getConexion(){
        if( conexion == null ){
            try{
                Class.forName(DRIVER);

                conexion = DriverManager.getConnection(URL, USUARIO, PASSWORD);
                System.out.println("Conexion exitosa a la base de datos");

            } catch( ClassNotFoundException e ){
                System.err.println("Error: No se encontro el driver de MySQL");
                System.err.println("Asegurate de tener el conector MySQL en tu proyecto");
                e.printStackTrace();
            } catch( SQLException e ){
                System.err.println("Error al conectar con la base de datos");
                System.err.println("Verifica que XAMPP esté ejecutandose y los datos de conexion sean correctos");
                e.printStackTrace();
            }
        }

        return conexion;
    }

    public static boolean isConectado(){
        try{
            return conexion != null && !conexion.isClosed();
        } catch( SQLException e ){
            return false;
        }
    }

    public static void cerrarConexion(){
        if( conexion != null ){
            try{
                conexion.close();
                conexion = null;
                System.out.println("Conexion cerrada correctamente");
            } catch( SQLException e ){
                System.err.println("Error al cerrar la conexion");
                e.printStackTrace();
            }
        }
    }

    public static void reconectar(){
        cerrarConexion();
        getConexion();
    }
}
