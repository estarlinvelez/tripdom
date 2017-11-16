package edu.itla.tripdom.Entity;

/**
 * Created by Estarlin Velez on 15/11/17.
 */

public class Publicacion {
    private String id;
    private String fecha;
    private String fechaviaje;
    private int costo;
    private String descripcion;
    private String estado;
    private int usuarioid;
    private String origen;
    private int cupo;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getFechaviaje() {
        return fechaviaje;
    }

    public void setFechaviaje(String fechaviaje) {
        this.fechaviaje = fechaviaje;
    }

    public int getCosto() {
        return costo;
    }

    public void setCosto(int costo) {
        this.costo = costo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public int getUsuarioid() {
        return usuarioid;
    }

    public void setUsuarioid(int usuarioid) {
        this.usuarioid = usuarioid;
    }

    public String getOrigen() {
        return origen;
    }

    public void setOrigen(String origen) {
        this.origen = origen;
    }

    public int getCupo() {
        return cupo;
    }

    public void setCupo(int cupo) {
        this.cupo = cupo;
    }
}
