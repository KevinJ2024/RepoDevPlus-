package org.DevPlus;

import javax.swing.*;

public class Empresa {

    private String NIT;
    private String nombreComercial;
    private String direccion;
    private String telefono;
    private String paginaWeb;

    private Cliente[] listClientes;
    private Desarrollador[] listDesarrolladores;
    private Proyecto[] listProyectos;
    private Servicio[] listServicios;

    public Empresa(String NIT, String nombreComercial, String direccion, String telefono, String paginaWeb) {
        this.NIT = NIT;
        this.nombreComercial = nombreComercial;
        this.direccion = direccion;
        this.telefono = telefono;
        this.paginaWeb = paginaWeb;

        listClientes = new Cliente[10];
        listDesarrolladores = new Desarrollador[10];
        listProyectos = new Proyecto[10];
        listServicios = new Servicio[10];
    }

    //FUNCIONES AUXILIARES ----------
    public int encontrarIndexCliente(String idCliente) {
        int index = -1;

        for (int i = 0; i < listClientes.length; i++) {
            if (listClientes[i] != null) {
                if (listClientes[i].getId().equals(idCliente)) {
                    index = i;
                }
            }
        }

        return index;
    }

    public int encontrarIndexDesarrollador(String idDesarrollador) {
        int index = -1;

        for (int i = 0; i < listDesarrolladores.length; i++) {
            if (listDesarrolladores[i] != null) {
                if (listDesarrolladores[i].getId().equals(idDesarrollador)) {
                    index = i;
                }
            }
        }

        return index;
    }

    public int encontrarIndexServicio(String codigoServicio) {
        int index = -1;

        for (int i = 0; i < listServicios.length; i++) {
            if (listServicios[i] != null) {
                if (listServicios[i].getCodigo().equals(codigoServicio)) {
                    index = i;
                }
            }
        }

        return index;
    }

    // FUNCIONES DE INGRESO DE DATOS ----------

    public Cliente ingresarDatosRegistroCliente() {
        String id = JOptionPane.showInputDialog("Ingrese el ID del cliente: ");
        String nombreCompleto = JOptionPane.showInputDialog("Ingrese el nombre completo del cliente: ");
        String razonSocial = JOptionPane.showInputDialog("Ingrese la razon social");
        long telefono = Long.parseLong(JOptionPane.showInputDialog("Ingrese el telefono del cliente"));
        String correo = JOptionPane.showInputDialog("Ingrese el correo del cliente");
        String paisProcedencia = JOptionPane.showInputDialog("Ingrese el pais de procedencia");

        return new Cliente(id, nombreCompleto, razonSocial, telefono, correo, paisProcedencia);
    }

    public long ingresarTelefonoCliente() {

        return Long.parseLong(JOptionPane.showInputDialog("Ingrese el telefono del cliente a consultar"));
    }

    public Desarrollador ingresarDatosRegistroDesarrollador() {
        String id = JOptionPane.showInputDialog("Ingrese el ID del desarrollador: ");
        String nombreCompleto = JOptionPane.showInputDialog("Ingrese el nombre completo del desarrollador: ");
        String equipoTrabajo = JOptionPane.showInputDialog("Ingrese el equipo de trabajo del desarrollador");
        String nivel = JOptionPane.showInputDialog("Ingrese el nivel del desarrollador");
        int cantMaxProyectos = Integer.parseInt(JOptionPane.showInputDialog("Ingrese la cantidad maxima de proyectos simultaneos del desarrollador"));
        double tarifaDia = Double.parseDouble(JOptionPane.showInputDialog("Ingrese la tarifa diaria del desarrollador"));
        String estado = JOptionPane.showInputDialog("Ingrese el estado del desarrollador");
        String disponibilidad = JOptionPane.showInputDialog("Ingrese la disponibilidad del servicio libre/ocupado");

        return new Desarrollador(id, nombreCompleto, equipoTrabajo, nivel, cantMaxProyectos, tarifaDia, estado, disponibilidad);
    }

    public Servicio ingresarDatosRegistroServicio() {
        String codigo = JOptionPane.showInputDialog("Ingrese el codigo del servicio: ");
        String nombre = JOptionPane.showInputDialog("Ingrese el nombre del servicio: ");
        String descripcion = JOptionPane.showInputDialog("Ingrese la descripcion del servicio");
        double precio = Double.parseDouble(JOptionPane.showInputDialog("Ingrese el precio del servicio"));
        String disponibilidad = JOptionPane.showInputDialog("Ingrese la disponibilidad del servicio libre/ocupado");

        return new Servicio(codigo, nombre, descripcion, precio, disponibilidad);
    }

    // FUNCIONES DE REGISTRO ----------

    public boolean registrarCliente(Cliente nuevoCliente) {
        if (encontrarIndexCliente(nuevoCliente.getId()) == -1) {
            for (int i = 0; i < listClientes.length; i++) {
                if (listClientes[i] == null) {
                    listClientes[i] = nuevoCliente;
                    return true;
                }
            }
        }
        return false;
    }

    public boolean registrarDesarrollador(Desarrollador nuevoDesarrollador) {
        if (encontrarIndexDesarrollador(nuevoDesarrollador.getId()) == -1) {
            for (int i = 0; i < listDesarrolladores.length; i++) {
                if (listDesarrolladores[i] == null) {
                    listDesarrolladores[i] = nuevoDesarrollador;
                    return true;
                }
            }
        }
        return false;
    }

    public boolean registrarServicio(Servicio nuevoServicio) {
        if (encontrarIndexServicio(nuevoServicio.getCodigo()) == -1) {
            for (int i = 0; i < listServicios.length; i++) {
                if (listServicios[i] == null) {
                    listServicios[i] = nuevoServicio;
                    return true;
                }
            }
        }
        return false;
    }

    //FUNCIONES DE CONSULTA ----------
    public Cliente consultarClienteTelefono(long telefono) {
        Cliente clienteEncontrado = null;
        if (telefono >= 0) {
            for (int i = 0; i < listClientes.length; i++) {
                if (listClientes[i] != null) {
                    if (listClientes[i].getTelefono() == telefono) {
                        clienteEncontrado = listClientes[i];
                    }
                }
            }
        }

        return clienteEncontrado;
    }

    public void imprimirResultadoConsultaCliente(Cliente clienteEncontrado) {
        // comprobamos si el telefono es perfecto
        boolean esPerfecto = clienteEncontrado.esTelefonoPerfecto();

        JOptionPane.showMessageDialog(null,
                "Cliente Encontrado" +
                        "\n ID: " + clienteEncontrado.getId() +
                        "\n Nombre: " + clienteEncontrado.getNombreCompleto() +
                        "\n Razon Social: " + clienteEncontrado.getRazonSocial() +
                        "\n Telefono: " + clienteEncontrado.getTelefono() +
                        "\n Correo: " + clienteEncontrado.getCorreo() +
                        "\n Pais: " + clienteEncontrado.getPaisProcedencia() +
                        "\n Es numero perfecto el telefono: " + esPerfecto);
    }

    //GETTERS Y SETTERS ----------

    public String getNIT() {
        return NIT;
    }

    public void setNIT(String NIT) {
        this.NIT = NIT;
    }

    public String getNombreComercial() {
        return nombreComercial;
    }

    public void setNombreComercial(String nombreComercial) {
        this.nombreComercial = nombreComercial;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getPaginaWeb() {
        return paginaWeb;
    }

    public void setPaginaWeb(String paginaWeb) {
        this.paginaWeb = paginaWeb;
    }

    public Cliente[] getListClientes() {
        return listClientes;
    }

    public void setListClientes(Cliente[] listClientes) {
        this.listClientes = listClientes;
    }

    public Desarrollador[] getListDesarrolladores() {
        return listDesarrolladores;
    }

    public void setListDesarrolladores(Desarrollador[] listDesarrolladores) {
        this.listDesarrolladores = listDesarrolladores;
    }

    public Proyecto[] getListProyectos() {
        return listProyectos;
    }

    public void setListProyectos(Proyecto[] listProyectos) {
        this.listProyectos = listProyectos;
    }

    public Servicio[] getListServicios() {
        return listServicios;
    }

    public void setListServicios(Servicio[] listServicios) {
        this.listServicios = listServicios;
    }
}
