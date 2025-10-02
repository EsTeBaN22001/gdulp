package Modelo;

public class Inscripcion {
    
    private int id;
    private double nota;
    private Alumno alumno;
    private Materia materia;

    
    // CONTRUCTOR //
    public Inscripcion() {
    }
    public Inscripcion(int id, double nota, Alumno alumno, Materia materia) {
        this.id = id;
        this.nota = nota;
        this.alumno = alumno;
        this.materia = materia;
    }
    
    // GET - SET //
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public double getNota() {
        return nota;
    }
    public void setNota(double nota) {
        this.nota = nota;
    }
    public Alumno getAlumno() {
        return alumno;
    }
    public void setAlumno(Alumno alumno) {
        this.alumno = alumno;
    }
    public Materia getMateria() {
        return materia;
    }
    public void setMateria(Materia materia) {
        this.materia = materia;
    }

    // TO STRING //
    @Override
    public String toString() {
        return "Inscripcion{"
                + "id=" + id
                + ", nota=" + nota
                + ", alumno=" + (alumno != null ? alumno.getApellido() + " " + alumno.getNombre() : "Sin alumno")
                + ", materia=" + (materia != null ? materia.getNombre() : "Sin materia")
                + '}';
    }
    
/*
             /\_/\           ___
            = o_o =_______    \ \
             __^      __(  \.__) )
         (@)<_____>__(_____)____/
*/
    
}
