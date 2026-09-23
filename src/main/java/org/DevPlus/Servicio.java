package org.DevPlus;

public class Servicio {
    private String codigo;
    private String nombreServicio;
    private String descripcion;
    private double precio;
    private boolean disponibilidad;

    private AsignacionServicio[] listAsigServicios;

    public Servicio(String codigo, String nombreServicio,
                    String descripcion, double precio,
                    boolean disponibilidad) {
        this.codigo = codigo;
        this.nombreServicio = nombreServicio;
        this.descripcion = descripcion;
        this.precio = precio;
        this.disponibilidad = disponibilidad;

        listAsigServicios = new AsignacionServicio[10];
    }



    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNombreServicio() {
        return nombreServicio;
    }

    public void setNombreServicio(String nombreServicio) {
        this.nombreServicio = nombreServicio;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public boolean isDisponibilidad() {
        return disponibilidad;
    }

    public void setDisponibilidad(boolean disponibilidad) {
        this.disponibilidad = disponibilidad;
    }

    public AsignacionServicio[] getListAsigServicios() {
        return listAsigServicios;
    }

    public void setListAsigServicios(AsignacionServicio[] listAsigServicios) {
        this.listAsigServicios = listAsigServicios;
    }
}
