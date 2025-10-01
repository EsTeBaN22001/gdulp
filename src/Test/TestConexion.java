//package test;
//
//import Modelo.ConexionDB;
//import java.sql.Connection;
//import java.sql.ResultSet;
//import java.sql.Statement;
//
///**
// * Clase para probar la conexión a la base de datos
// */
//public class TestConexion{
//
//    public static void main(String[] args){
//        System.out.println("=== Prueba de Conexión a MySQL ===\n");
//
//        // Obtener la conexión
//        Connection conn = ConexionDB.getConexion();
//
//        if( conn != null ){
//            System.out.println("Estado: " + (ConexionDB.isConectado() ? "CONECTADO" : "DESCONECTADO"));
//
//            // Ejemplo de consulta simple
//            try{
//                Statement stmt = conn.createStatement();
//                ResultSet rs = stmt.executeQuery("SELECT DATABASE() as db");
//
//                if( rs.next() ){
//                    System.out.println("Base de datos actual: " + rs.getString("db"));
//                }
//
//                rs.close();
//                stmt.close();
//
//            } catch( Exception e ){
//                System.err.println("Error al ejecutar consulta de prueba");
//                e.printStackTrace();
//            }
//
//            // Cerrar la conexión al finalizar
////            ConexionDB.cerrarConexion();
////            System.out.println("\nEstado final: " + (ConexionDB.isConectado() ? "CONECTADO" : "DESCONECTADO"));
//        } else{
//            System.err.println("No se pudo establecer la conexión");
//        }
//    }
//}
