package Modelo;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Alumno{

    private int id;
    private String dni;
    private String apellido;
    private String nombre;
    private Date fechaNacimiento;
    private boolean estado;

    // CONTRUCTOR //
    public Alumno(){
    }

    public Alumno(int id, String dni, String apellido, String nombre, Date fechaNacimiento, boolean estado){
        this.id = id;
        this.dni = dni;
        this.apellido = apellido;
        this.nombre = nombre;
        this.fechaNacimiento = fechaNacimiento;
        this.estado = estado;
    }

    public Alumno(String dni, String apellido, String nombre, Date fechaNacimiento, boolean estado){
        this.dni = dni;
        this.apellido = apellido;
        this.nombre = nombre;
        this.fechaNacimiento = fechaNacimiento;
        this.estado = estado;
    }

    // GET - SET //
    public int getId(){
        return id;
    }

    public void setId(int id){
        this.id = id;
    }

    public String getDni(){
        return dni;
    }

    public void setDni(String dni){
        this.dni = dni;
    }

    public String getApellido(){
        return apellido;
    }

    public void setApellido(String apellido){
        this.apellido = apellido;
    }

    public String getNombre(){
        return nombre;
    }

    public void setNombre(String nombre){
        this.nombre = nombre;
    }

    public Date getFechaNacimiento(){
        return fechaNacimiento;
    }

    public void setFechaNacimiento(Date fechaNacimiento){
        this.fechaNacimiento = fechaNacimiento;
    }

    public boolean getEstado(){
        return estado;
    }

    public void setEstado(boolean estado){
        this.estado = estado;
    }

    // TO STRING //
    @Override
    public String toString(){
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        String fechaFormateada = (fechaNacimiento != null) ? sdf.format(fechaNacimiento) : "Sin fecha";
        String estadoTexto = estado ? "Activo" : "Inactivo";

        return "Alumno{"
          + "id=" + id
          + ", dni='" + dni + '\''
          + ", apellido='" + apellido + '\''
          + ", nombre='" + nombre + '\''
          + ", fechaNacimiento=" + fechaFormateada
          + ", estado=" + estadoTexto
          + '}';
    }
    
    public String getNombreCompleto() {
        return "ID: "+ id + " || " + nombre + " " + apellido;
    }


}
