package Modelo;

public class Materia {
    
    private int id;
    private String nombre;
    private int año;
    private boolean estado;
    private int idInscripto;

    // CONTRUCTOR //
    public Materia() {
    }
    public Materia(int id, String nombre, int año, boolean estado) {
        this.id = id;
        this.nombre = nombre;
        this.año = año;
        this.estado = estado;
    }

    public Materia(int id, String nombre, int año, boolean estado, int idInscripto) {
        this.id = id;
        this.nombre = nombre;
        this.año = año;
        this.estado = estado;
        this.idInscripto = idInscripto;
    }
    
    
    // GET - SET //
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public int getAño() {
        return año;
    }
    public void setAño(int año) {
        this.año = año;
    }
    public boolean isEstado() {
        return estado;
    }
    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    public int getIdInscripto() {
        return idInscripto;
    }

    public void setIdInscripto(int idInscripto) {
        this.idInscripto = idInscripto;
    }
    
    
    
    // TO STRING //
    @Override
    public String toString() {
        String estadoTexto = estado ? "Activa" : "Inactiva";
        return "Materia{"
                + "id=" + id
                + ", nombre='" + nombre + '\''
                + ", año=" + año
                + ", estado=" + estadoTexto
                + '}';
    }
    
/*
             /\_/\           ___
            = o_o =_______    \ \
             __^      __(  \.__) )
         (@)<_____>__(_____)____/
*/
    
    public int setIdInscripto() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    
}
