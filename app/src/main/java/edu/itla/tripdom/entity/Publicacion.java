package edu.itla.tripdom.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by Estarlin Velez on 15/11/17.
 */

public class Publicacion {
    private int id;

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    private Date fecha;
    private String fechaviaje;
    private float costo;
    private String descripcion;
    private String estado;
    private Usuario usuario;

    public int getUsuarioid() {
        return usuarioid;
    }

    public void setUsuarioid(int usuarioid) {
        this.usuarioid = usuarioid;
    }

    private int usuarioid;
    private String origen;
    private int cupo;

    public void setCosto(float costo) {
        this.costo = costo;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public void setDetalle(List<Publicaciondetalle> detalle) {
        this.detalle = detalle;
    }

    private int userId;


    List <Publicaciondetalle> detalle;


    public List<Publicaciondetalle> getDetalle() {
        return detalle;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


    public String getFechaviaje() {
        return fechaviaje;
    }

    public void setFechaviaje(String fechaviaje) {
        this.fechaviaje = fechaviaje;
    }

    public float getCosto() {
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

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(int usuarioid) {
        this.usuario = usuario;
    }

    public String getOrigen() {
        return origen;
    }

    public void setOrigen(String origen) {
        this.origen = origen;
    }

    public int getCupo() {        return cupo;}

    public void setCupo(int cupo) {
        this.cupo = cupo;
    }

    public void addDetalle(Publicaciondetalle pd) {
        if (detalle == null){
            detalle = new ArrayList<>();

        }
        pd.setPublicacion(this);
        detalle.add(pd);
    }
}
