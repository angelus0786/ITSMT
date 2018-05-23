package mx.edu.itsmt.angelus.tarea2;

import java.io.Serializable;

public class Persona implements Serializable {

    String nombre;
    String apellidos;
    String correo;
    String genero;
    String fecha;

    //constructor
    public Persona(String nombre, String apellidos, String correo,
                   String genero, String fecha) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.correo = correo;
        this.genero = genero;
        this.fecha = fecha;
    }
    //getter and Setter
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }
}//fin clase persona
