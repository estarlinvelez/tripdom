package edu.itla.tripdom.Entity;

/**
 * Created by Estarlin Velez on 15/11/17.
 */

public class Publicaciondetalle {
    private String id;
    private String publicacionid;
    private String lugar;
    private String descripcion;
    private String imagen;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPublicacionid() {
        return publicacionid;
    }

    public void setPublicacionid(String publicacionid) {
        this.publicacionid = publicacionid;
    }

    public String getLugar() {
        return lugar;
    }

    public void setLugar(String lugar) {
        this.lugar = lugar;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }
}
