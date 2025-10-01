package Views;

import Modelo.Alumno;
import Persistencia.alumnoData;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

public class Main{

    public static void main(String[] args){

        ArrayList<Alumno> alumnos = new alumnoData().obtenerTodos();

// Formato 1: Simple y legible
        System.out.println("\n========================================");
        System.out.println("       LISTADO DE ALUMNOS");
        System.out.println("========================================\n");

        if( alumnos.isEmpty() ){
            System.out.println("No hay alumnos registrados");
        } else{
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

            for( int i = 0 ; i < alumnos.size() ; i++ ){
                Alumno a = alumnos.get(i);
                String fecha = (a.getFechaNacimiento() != null)
                  ? sdf.format(a.getFechaNacimiento()) : "Sin fecha";
                String estado = a.isEstado() ? " ACTIVO" : " INACTIVO";

                System.out.println((i + 1) + ". " + a.getApellido() + ", " + a.getNombre());
                System.out.println("   DNI: " + a.getDni() + " | Fecha Nac: " + fecha + " | Estado: " + estado);
                System.out.println();
            }

            System.out.println("========================================");
            System.out.println("Total de alumnos: " + alumnos.size());
            System.out.println("========================================\n");
        }

    }

}
