package org.DevPlus;

import java.time.LocalDate;

public class Desarrollador {

    private String id;
    private String nombreCompleto;
    private String equipoTrabajo;
    private String nivel;
    private int cantMaxProyectos;
    private double tarifaDia;
    private String estado;

    private AsignacionDesarrollador[] listAsigDesarrolladores;

    public Desarrollador(String id, String nombreCompleto,
                         String equipoTrabajo, String nivel,
                         int cantMaxProyectos, double tarifaDia,
                         String estado) {
        this.id = id;
        this.nombreCompleto = nombreCompleto;
        this.equipoTrabajo = equipoTrabajo;
        this.nivel = nivel;
        this.cantMaxProyectos = cantMaxProyectos;
        this.tarifaDia = tarifaDia;
        this.estado = estado;

        listAsigDesarrolladores = new AsignacionDesarrollador[10];
    }

    public void actualizarDisponibilidad(boolean nuevaDisponibilidad) {

    }

    public boolean validarDisponibilidad(LocalDate fechaInicio, LocalDate fechaFin) {
        boolean estaLibre = false;

        //Validar que el desarrollador este libre entre dos fechas
        if (estado.equals("Disponible")
                && obtenerCantidadProyectosActuales() < cantMaxProyectos
                && !validarFechas(fechaInicio, fechaFin)) {
            estaLibre = true;
        }
        return estaLibre;
    }

    //funcion para validar fechas de proyectos asociados a el desarrollador y verificar que no se crucen fechas con las nuevas
    private boolean validarFechas(LocalDate nuevaFechaInicio, LocalDate nuevaFechaFin) {
        for (int i = 0; i < listAsigDesarrolladores.length; i++) {
            AsignacionDesarrollador asig = listAsigDesarrolladores[i];

            if (asig != null && asig.getTheProyecto() != null) {
                Proyecto proyectoExistente = asig.getTheProyecto();

                LocalDate inicioExistente = proyectoExistente.getFechaInicio();
                LocalDate finExistente = proyectoExistente.getFechaFin();

                boolean seCruzan = !nuevaFechaInicio.isAfter(finExistente) && !nuevaFechaFin.isBefore(inicioExistente);

                if (seCruzan) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean removerAsignacion(AsignacionDesarrollador asigARemover) {
        if (asigARemover == null) return false;
        for (int i = 0; i < this.listAsigDesarrolladores.length; i++) {
            if (this.listAsigDesarrolladores[i] == asigARemover) {
                this.listAsigDesarrolladores[i] = null;
                return true;
            }
        }
        return false;
    }

    public boolean nuevaAsignacion(AsignacionDesarrollador nuevaAsignacion) {
        if (nuevaAsignacion != null) {
            for (int i = 0; i < listAsigDesarrolladores.length; i++) {
                if (listAsigDesarrolladores[i] == null) {
                    listAsigDesarrolladores[i] = nuevaAsignacion;
                    this.setEstado("Asignado");
                    return true;
                }
            }
        }
        return false;
    }

    public int obtenerCantidadProyectosActuales() {
        int contador = 0;
        for (int i = 0; i < listAsigDesarrolladores.length; i++) {
            if (listAsigDesarrolladores[i] != null) {
                contador++;
            }
        }
        return contador;
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

    public AsignacionDesarrollador[] getListAsigDesarrolladores() {
        return listAsigDesarrolladores;
    }

    public void setListAsigDesarrolladores(AsignacionDesarrollador[] listAsigDesarrolladores) {
        this.listAsigDesarrolladores = listAsigDesarrolladores;
    }
}
