package org.DevPlus;

import java.time.LocalDate;

public class AsignacionDesarrollador {

    private LocalDate fechaAsignacion;
    private Servicio theServicio;
    private Proyecto theProyecto;

    public AsignacionDesarrollador(LocalDate fechaAsignacion) {
        this.fechaAsignacion = fechaAsignacion;
        theServicio = null;
        theProyecto = null;
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
