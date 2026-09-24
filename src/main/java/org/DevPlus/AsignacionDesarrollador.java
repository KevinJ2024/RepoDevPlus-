package org.DevPlus;

import java.time.LocalDate;

public class AsignacionDesarrollador {

    private String codigoAsignacionDev;
    private LocalDate fechaAsignacion;
    private Desarrollador theDesarrollador;
    private Proyecto theProyecto;

    public AsignacionDesarrollador(String codigoAsignacionDev, LocalDate fechaAsignacion) {
        this.codigoAsignacionDev = codigoAsignacionDev;
        this.fechaAsignacion = fechaAsignacion;
        theDesarrollador = null;
        theProyecto = null;
    }


    //GETTERS Y SETTERS ----------

    public String getCodigoAsignacionDev() {
        return codigoAsignacionDev;
    }

    public void setCodigoAsignacionDev(String codigoAsignacionDev) {
        this.codigoAsignacionDev = codigoAsignacionDev;
    }

    public LocalDate getFechaAsignacion() {
        return fechaAsignacion;
    }

    public void setFechaAsignacion(LocalDate fechaAsignacion) {
        this.fechaAsignacion = fechaAsignacion;
    }

    public Desarrollador getTheDesarrollador() {
        return theDesarrollador;
    }

    public void setTheDesarrollador(Desarrollador theDesarrollador) {
        this.theDesarrollador = theDesarrollador;
    }

    public Proyecto getTheProyecto() {
        return theProyecto;
    }

    public void setTheProyecto(Proyecto theProyecto) {
        this.theProyecto = theProyecto;
    }
}
