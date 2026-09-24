package org.DevPlus;

import java.time.LocalDate;

public class Proyecto {
    private String codigo;
    private LocalDate fechaSolicitud;
    private LocalDate fechaInicio;
    private LocalDate fechaFin;
    private String estado;
    private String metodoPago;
    private double valorTotal;

    private AsignacionServicio[] listAsigServicio;
    private AsignacionDesarrollador[] listAsigDesarrollador;

    public Proyecto(String codigo, LocalDate fechaSolicitud,
                    LocalDate fechaInicio, LocalDate fechaFin,
                    String estado, String metodoPago,
                    double valorTotal) {
        this.codigo = codigo;
        this.fechaSolicitud = fechaSolicitud;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.estado = estado;
        this.metodoPago = metodoPago;
        this.valorTotal = valorTotal;

        listAsigServicio = new AsignacionServicio[10];
        listAsigDesarrollador = new AsignacionDesarrollador[10];
    }

    public int encontrarIndexListAsigDev(String codigoAsignacionDev) {
        int index = -1;

        for (int i = 0; i < listAsigDesarrollador.length; i++) {
            if (listAsigDesarrollador[i] != null) {
                if (listAsigDesarrollador[i].getCodigoAsignacionDev().equals(codigoAsignacionDev)) {
                    index = i;
                }
            }
        }
        return index;
    }

    public int encontrarIndexListAsigServicio(String codigoAsignacionServicio) {
        int index = -1;

        for (int i = 0; i < listAsigServicio.length; i++) {
            if (listAsigServicio[i] != null) {
                if (listAsigServicio[i].getCodigoAsignacionServicio().equals(codigoAsignacionServicio)) {
                    index = i;
                }
            }
        }
        return index;
    }

    public double calcularValorAdicional() {
        return 0.0;
    }

    public void agregarDesarrollador(Desarrollador nuevoDev) {

    }

    public void agregarServicio(Servicio nuevoServicio) {

    }

    //GETTERS Y SETTERS ----------

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public LocalDate getFechaSolicitud() {
        return fechaSolicitud;
    }

    public void setFechaSolicitud(LocalDate fechaSolicitud) {
        this.fechaSolicitud = fechaSolicitud;
    }

    public LocalDate getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(LocalDate fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public LocalDate getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(LocalDate fechaFin) {
        this.fechaFin = fechaFin;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getMetodoPago() {
        return metodoPago;
    }

    public void setMetodoPago(String metodoPago) {
        this.metodoPago = metodoPago;
    }

    public double getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(double valorTotal) {
        this.valorTotal = valorTotal;
    }

    public AsignacionServicio[] getListAsigServicio() {
        return listAsigServicio;
    }

    public void setListAsigServicio(AsignacionServicio[] listAsigServicio) {
        this.listAsigServicio = listAsigServicio;
    }

    public AsignacionDesarrollador[] getListAsigDesarrollador() {
        return listAsigDesarrollador;
    }

    public void setListAsigDesarrollador(AsignacionDesarrollador[] listAsigDesarrollador) {
        this.listAsigDesarrollador = listAsigDesarrollador;
    }
}
