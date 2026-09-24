package org.DevPlus;

public class Desarrollador {

    private String id;
    private String nombreCompleto;
    private String equipoTrabajo;
    private String nivel;
    private int cantMaxProyectos;
    private double tarifaDia;
    private String estado;
    private String disponibilidad;

    private AsignacionDesarrollador[] listAsigDesarrolladores;

    public Desarrollador(String id, String nombreCompleto,
                         String equipoTrabajo, String nivel,
                         int cantMaxProyectos, double tarifaDia,
                         String estado, String disponibilidad) {
        this.id = id;
        this.nombreCompleto = nombreCompleto;
        this.equipoTrabajo = equipoTrabajo;
        this.nivel = nivel;
        this.cantMaxProyectos = cantMaxProyectos;
        this.tarifaDia = tarifaDia;
        this.estado = estado;
        this.disponibilidad = disponibilidad;

        listAsigDesarrolladores = new AsignacionDesarrollador[10];
    }

    public void actualizarDisponibilidad(boolean nuevaDisponibilidad) {

    }

    //GETTERS Y SETTERS ----------

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNombreCompleto() {
        return nombreCompleto;
    }

    public void setNombreCompleto(String nombreCompleto) {
        this.nombreCompleto = nombreCompleto;
    }

    public String getEquipoTrabajo() {
        return equipoTrabajo;
    }

    public void setEquipoTrabajo(String equipoTrabajo) {
        this.equipoTrabajo = equipoTrabajo;
    }

    public String getNivel() {
        return nivel;
    }

    public void setNivel(String nivel) {
        this.nivel = nivel;
    }

    public int getCantMaxProyectos() {
        return cantMaxProyectos;
    }

    public void setCantMaxProyectos(int cantMaxProyectos) {
        this.cantMaxProyectos = cantMaxProyectos;
    }

    public double getTarifaDia() {
        return tarifaDia;
    }

    public void setTarifaDia(double tarifaDia) {
        this.tarifaDia = tarifaDia;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String isDisponibilidad() {
        return disponibilidad;
    }

    public void setDisponibilidad(String disponibilidad) {
        this.disponibilidad = disponibilidad;
    }

    public AsignacionDesarrollador[] getListAsigDesarrolladores() {
        return listAsigDesarrolladores;
    }

    public void setListAsigDesarrolladores(AsignacionDesarrollador[] listAsigDesarrolladores) {
        this.listAsigDesarrolladores = listAsigDesarrolladores;
    }
}
