package Views;

import Modelo.Alumno;
import Modelo.Materia;
import Persistencia.alumnoData;
import Persistencia.materiaData;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

public class Main{

    public static void main(String[] args){

        ArrayList<Alumno> alumnos = new alumnoData().obtenerTodos();
        ArrayList<Materia> materia = new materiaData().obtenerMaterias();
        
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
                System.out.println("   ID: " + a.getId() + " | DNI: " + a.getDni() + " | Fecha Nac: " + fecha + " | Estado: " + estado);
                System.out.println();
            }

            System.out.println("========================================");
            System.out.println("Total de alumnos: " + alumnos.size());
            System.out.println("========================================\n");
            
        }
        
        System.out.println("\n========================================");
        System.out.println("       LISTADO DE MATERIAS");
        System.out.println("========================================\n");
        if (materia.isEmpty()) {
            System.out.println("No hay Materias registradas");
        } else {
            for (int i = 0; i < materia.size(); i++) {
                Materia m = materia.get(i);
                String estado = m.isEstado() ? "ACTIVA" : "INACTIVA";
                System.out.println((i + 1) + ". " + m.getNombre());
                System.out.println("   ID: " + m.getId() + " | Año: " + m.getAño() + "° | Estado: " + estado);
                System.out.println();
            }
            System.out.println("========================================");
            System.out.println("Total de Materias: " + materia.size());
            System.out.println("========================================\n");
        }
        
        

    }
    
    /*
             /\_/\           ___
            = o_o =_______    \ \
             __^      __(  \.__) )
         (@)<_____>__(_____)____/
     */

}
