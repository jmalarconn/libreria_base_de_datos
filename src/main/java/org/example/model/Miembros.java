package org.example.model;

import java.util.Date;

public class Miembros {
    private String miembroId;
    private String nombre;
    private String apellido;
    private Date fechaInscripcion;

    public Miembros(){
    }

    public Miembros(String nombre, String apellido, Date fechaInscripcion, String miembroId) {
        this.apellido = apellido;
        this.fechaInscripcion = fechaInscripcion;
        this.miembroId = miembroId;
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public java.sql.Date getFechaInscripcion() {
        return (java.sql.Date) fechaInscripcion;
    }

    public void setFechaInscripcion(Date fechaInscripcion) {
        this.fechaInscripcion = fechaInscripcion;
    }

    public String getMiembroId() {
        return miembroId;
    }

    public void setMiembroId(String miembroId) {
        this.miembroId = miembroId;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public String toString() {
        return "Miembros{" +
                "apellido='" + apellido + '\'' +
                ", miembroId='" + miembroId + '\'' +
                ", nombre='" + nombre + '\'' +
                ", fechaInscripcion=" + fechaInscripcion +
            '}';
}
}