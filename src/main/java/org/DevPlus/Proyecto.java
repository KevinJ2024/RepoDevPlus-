package org.DevPlus;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

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

    //Funcion para obtener el valor total adicional tomando en cuenta los servicios y desarrolladores asignados
    public double calcularValorAdicional() {
        double suma = 0.0;

        for (int i = 0; i < listAsigServicio.length; i++) {
            if (listAsigServicio[i] != null && listAsigServicio[i].getTheServicio() != null) {
                suma += listAsigServicio[i].getTheServicio().getPrecio();
            }
        }

        long diasProyecto = ChronoUnit.DAYS.between(this.fechaInicio, this.fechaFin) + 1;

        for (int j = 0; j < listAsigDesarrollador.length; j++) {
            if (listAsigDesarrollador[j] != null && listAsigDesarrollador[j].getTheDesarrollador() != null) {

                double tarifaDiaria = listAsigDesarrollador[j].getTheDesarrollador().getTarifaDia();

                double pagoDesarrollador = diasProyecto * tarifaDiaria;

                suma += pagoDesarrollador;
            }
        }

        return suma;
    }

    public boolean agregarDesarrollador(Desarrollador nuevoDev) {
        boolean estaAnadido = false;
        boolean seAnadioNuevo = false;

        // validacion de estado, cantidad proyectos y de fechas para asignar un desarrollador
        if (!nuevoDev.validarDisponibilidad(this.fechaInicio, this.fechaFin)){
            return false;
        }

        //Validacion de no existir el desarrollador en la lista actual de desarrolladores del proyecto
        if (nuevoDev != null){
            for (int i = 0; i < listAsigDesarrollador.length; i++){
                if (listAsigDesarrollador[i] != null){
                    if(listAsigDesarrollador[i].getTheDesarrollador().getId().equals(nuevoDev.getId())){
                        estaAnadido = true;
                    }
                }
            }

            //Si no esta añadido se añade
            if (!estaAnadido){
                seAnadioNuevo = crearAsignacionDev(nuevoDev);
            }
        }
        return seAnadioNuevo;
    }

    public boolean crearAsignacionDev(Desarrollador nuevoDev){
        for (int i = 0; i < listAsigDesarrollador.length; i++){
            if (listAsigDesarrollador[i] == null){
                int nuevoCodigo = 1;
                if (i > 0){
                    nuevoCodigo = Integer.parseInt(listAsigDesarrollador[i-1].getCodigoAsignacionDev()) + 1;
                }

                AsignacionDesarrollador nuevaAsig = new AsignacionDesarrollador(String.valueOf(nuevoCodigo), LocalDate.now());
                nuevaAsig.setTheDesarrollador(nuevoDev);
                nuevaAsig.setTheProyecto(this);

                listAsigDesarrollador[i] = nuevaAsig;
                nuevoDev.nuevaAsignacion(nuevaAsig);
                return true;
            }
        }
        return false;
    }

    public boolean agregarServicio(Servicio nuevoServicio) {
        boolean estaAnadido = false;
        boolean seAnadioNuevo = false;

        //Validar que el desarrollador este libre
        if (nuevoServicio.getDisponibilidad().equals("Ocupado")){
            return false;
        }

        //Validacion de no existir el desarrollador en la lista actual de desarrolladores del proyecto
        if (nuevoServicio != null){
            for (int i = 0; i < listAsigServicio.length; i++){
                if (listAsigServicio[i] != null){
                    if(listAsigServicio[i].getTheServicio().getCodigo().equals(nuevoServicio.getCodigo())){
                        estaAnadido = true;
                    }
                }
            }

            //Si no esta añadido se añade
            if (!estaAnadido){
                seAnadioNuevo = crearAsignacionServicio(nuevoServicio);
            }
        }
        return seAnadioNuevo;
    }

    public boolean crearAsignacionServicio(Servicio nuevoServicio){
        for (int i = 0; i < listAsigServicio.length; i++){
            if (listAsigServicio[i] == null){
                int nuevoCodigo = 1;
                if (i > 0){
                    nuevoCodigo = Integer.parseInt(listAsigServicio[i-1].getCodigoAsignacionServicio()) + 1;
                }

                AsignacionServicio nuevaAsig = new AsignacionServicio(String.valueOf(nuevoCodigo), LocalDate.now());
                nuevaAsig.setTheServicio(nuevoServicio);
                nuevaAsig.setTheProyecto(this);

                listAsigServicio[i] = nuevaAsig;
                nuevoServicio.nuevaAsignacion(nuevaAsig);
                return true;
            }
        }
        return false;
    }

    public int obtenerCantidadDesarrolladores(){
        int contador = 0;
        for (int i = 0; i < listAsigDesarrollador.length; i++){
            if(listAsigDesarrollador[i] != null){
                contador += 1;
            }
        }
        return contador;
    }

    public int obtenerCantidadServicios(){
        int contador = 0;
        for (int i = 0; i < listAsigServicio.length; i++){
            if(listAsigServicio[i] != null){
                contador += 1;
            }
        }
        return contador;
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
