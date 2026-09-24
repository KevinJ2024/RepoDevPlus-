package org.DevPlus;

import java.time.LocalDate;

public class AsignacionServicio {

    private String codigoAsignacionServicio;
    private LocalDate fechaAsignacion;
    private Servicio theServicio;
    private Proyecto theProyecto;

    public AsignacionServicio(String codigoAsignacionServicio, LocalDate fechaAsignacion) {
        this.codigoAsignacionServicio = codigoAsignacionServicio;
        this.fechaAsignacion = fechaAsignacion;
        theServicio = null;
        theProyecto = null;
    }

    //GETTERS Y SETTERS ----------

    public String getCodigoAsignacionServicio() {
        return codigoAsignacionServicio;
    }

    public void setCodigoAsignacionServicio(String codigoAsignacionServicio) {
        this.codigoAsignacionServicio = codigoAsignacionServicio;
    }

    public LocalDate getFechaAsignacion() {
        return fechaAsignacion;
    }

    public void setFechaAsignacion(LocalDate fechaAsignacion) {
        this.fechaAsignacion = fechaAsignacion;
    }

    public Servicio getTheServicio() {
        return theServicio;
    }

    public void setTheServicio(Servicio theServicio) {
        this.theServicio = theServicio;
    }

    public Proyecto getTheProyecto() {
        return theProyecto;
    }

    public void setTheProyecto(Proyecto theProyecto) {
        this.theProyecto = theProyecto;
    }
}
