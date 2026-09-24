package org.DevPlus;

public class Servicio {
    private String codigo;
    private String nombreServicio;
    private String descripcion;
    private double precio;
    private String disponibilidad;

    private AsignacionServicio[] listAsigServicios;

    public Servicio(String codigo, String nombreServicio,
                    String descripcion, double precio,
                    String disponibilidad) {
        this.codigo = codigo;
        this.nombreServicio = nombreServicio;
        this.descripcion = descripcion;
        this.precio = precio;
        this.disponibilidad = disponibilidad;

        listAsigServicios = new AsignacionServicio[10];
    }

    public boolean nuevaAsignacion(AsignacionServicio nuevaAsignacion) {
        if (nuevaAsignacion != null) {
            for (int i = 0; i < listAsigServicios.length; i++) {
                if (listAsigServicios[i] == null) {
                    listAsigServicios[i] = nuevaAsignacion;
                    return true;
                }
            }
        }
        return false;
    }

    //GETTERS Y SETTERS ----------

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

    public String getDisponibilidad() {
        return disponibilidad;
    }

    public void setDisponibilidad(String disponibilidad) {
        this.disponibilidad = disponibilidad;
    }

    public AsignacionServicio[] getListAsigServicios() {
        return listAsigServicios;
    }

    public void setListAsigServicios(AsignacionServicio[] listAsigServicios) {
        this.listAsigServicios = listAsigServicios;
    }
}
