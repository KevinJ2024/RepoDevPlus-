package org.DevPlus;

import java.time.LocalDate;

public class AsignacionServicio {

    private LocalDate fechaAsignacion;
    private Desarrollador theDesarrollador;
    private Proyecto theProyecto;

    public AsignacionServicio(LocalDate fechaAsignacion) {
        this.fechaAsignacion = fechaAsignacion;
        theDesarrollador = null;
        theProyecto = null;
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
