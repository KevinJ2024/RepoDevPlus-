package org.DevPlus;

import javax.swing.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Date;

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

    public int encontrarIndexProyecto(String codigoProyecto) {
        int index = -1;

        for (int i = 0; i < listProyectos.length; i++) {
            if (listProyectos[i] != null) {
                if (listProyectos[i].getCodigo().equals(codigoProyecto)) {
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
        String nivel = JOptionPane.showInputDialog("Ingrese el nivel del desarrollador" +
                "\n Junior, Semisenior, Senior");
        int cantMaxProyectos = Integer.parseInt(JOptionPane.showInputDialog("Ingrese la cantidad maxima de proyectos simultaneos del desarrollador"));
        double tarifaDia = Double.parseDouble(JOptionPane.showInputDialog("Ingrese la tarifa diaria del desarrollador"));
        String estado = JOptionPane.showInputDialog("Ingrese el estado del desarrollador" +
                "\n Disponible, Asignado, Ocupado, En capacitación");

        return new Desarrollador(id, nombreCompleto, equipoTrabajo, nivel, cantMaxProyectos, tarifaDia, estado);
    }

    public Servicio ingresarDatosRegistroServicio() {
        String codigo = JOptionPane.showInputDialog("Ingrese el codigo del servicio: ");
        String nombre = JOptionPane.showInputDialog("Ingrese el nombre del servicio: ");
        String descripcion = JOptionPane.showInputDialog("Ingrese la descripcion del servicio");
        double precio = Double.parseDouble(JOptionPane.showInputDialog("Ingrese el precio del servicio"));
        String disponibilidad = JOptionPane.showInputDialog("Ingrese la disponibilidad del servicio " +
                "\n libre/ocupado");

        return new Servicio(codigo, nombre, descripcion, precio, disponibilidad);
    }

    public Proyecto ingresarDatosRegistroProyecto() {
        DateTimeFormatter formateador = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        LocalDate fechaInicio = null;
        LocalDate fechaFin = null;

        String codigo = JOptionPane.showInputDialog("Ingrese el codigo del proyecto: ");
        LocalDate fechaSolicitud = LocalDate.now(); // se toma del momento de la creacion del proyecto

        //Fecha inicio
        String inputInicio = JOptionPane.showInputDialog("Ingrese la fecha de inicio (dd/mm/aaaa): ");
        if (inputInicio == null) return null;
        fechaInicio = LocalDate.parse(inputInicio, formateador);

        //Fecha fin
        String inputFin = JOptionPane.showInputDialog("Ingrese la fecha de fin (dd/mm/aaaa):");
        if (inputFin == null) return null;
        fechaFin = LocalDate.parse(inputFin, formateador);

        // validar que no sea antes que la de inicio
        if (fechaFin.isBefore(fechaInicio)) {
            JOptionPane.showMessageDialog(null, "La fecha de fin no puede ser anterior a la fecha de inicio.");
            fechaFin = null;
        }

        String estado = JOptionPane.showInputDialog("Ingrese el estado del proyecto: " +
                "\n Pendiente, Confirmado, En curso, Finalizado, Cancelado");
        String metodoPago = JOptionPane.showInputDialog("Ingrese el metodo de pago del proyecto");
        double valorTotal = Double.parseDouble(JOptionPane.showInputDialog("Ingrese el valor base del proyecto"));

        return new Proyecto(codigo, fechaSolicitud, fechaInicio, fechaFin, estado, metodoPago, valorTotal);
    }

    //Funcion para pedir datos para actualizar al mismo tiempo que se muestran los anteriores
    public Proyecto ingresarDatosActualizarProyecto(Proyecto proyectoActualizar) {
        if (proyectoActualizar == null) {
            JOptionPane.showMessageDialog(null, "No se proporcionó un proyecto para actualizar.", "Error", JOptionPane.ERROR_MESSAGE);
            return null;
        }

        DateTimeFormatter formateador = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        String codigo = proyectoActualizar.getCodigo();
        LocalDate fechaSolicitud = proyectoActualizar.getFechaSolicitud();

        LocalDate fechaInicio = null;
        LocalDate fechaFin = null;

        String fechaInicioActualTexto = proyectoActualizar.getFechaInicio().format(formateador);
        String fechaFinActualTexto = proyectoActualizar.getFechaFin().format(formateador);

        while (fechaInicio == null) {
            String inputInicio = (String) JOptionPane.showInputDialog(
                    null, "Modifique la fecha de inicio:", "Actualizar Fecha Inicio",
                    JOptionPane.QUESTION_MESSAGE, null, null, fechaInicioActualTexto
            );
            if (inputInicio == null) return null; // Cancelar operación
            fechaInicio = LocalDate.parse(inputInicio, formateador);

        }

        while (fechaFin == null) {
            String inputFin = (String) JOptionPane.showInputDialog(
                    null, "Modifique la fecha de fin:", "Actualizar Fecha Fin",
                    JOptionPane.QUESTION_MESSAGE, null, null, fechaFinActualTexto
            );
            if (inputFin == null) return null;
            fechaFin = LocalDate.parse(inputFin, formateador);

            // Validar que no sea anterior a la de inicio
            if (fechaFin.isBefore(fechaInicio)) {
                JOptionPane.showMessageDialog(null, "La fecha de fin no puede ser anterior a la fecha de inicio.", "Error", JOptionPane.ERROR_MESSAGE);
                fechaFin = null;
            }
        }

        String estado = (String) JOptionPane.showInputDialog(
                null, "Modifique el estado del proyecto:\n(Pendiente, Confirmado, En curso, Finalizado, Cancelado)",
                "Actualizar Estado", JOptionPane.QUESTION_MESSAGE, null, null, proyectoActualizar.getEstado()
        );
        if (estado == null) return null;

        String metodoPago = (String) JOptionPane.showInputDialog(
                null, "Modifique el método de pago del proyecto:",
                "Actualizar Método de Pago", JOptionPane.QUESTION_MESSAGE, null, null, proyectoActualizar.getMetodoPago()
        );
        if (metodoPago == null) return null;

        double valorTotal = 0;
        boolean valorValido = false;
        String valorActualTexto = String.valueOf(proyectoActualizar.getValorTotal()); // o getValorBase() según tu atributo

        while (!valorValido) {
            String inputValor = (String) JOptionPane.showInputDialog(
                    null, "Modifique el valor base del proyecto:",
                    "Actualizar Valor Base", JOptionPane.QUESTION_MESSAGE, null, null, valorActualTexto
            );
            if (inputValor == null) return null;
            valorTotal = Double.parseDouble(inputValor);
            valorValido = true;
        }

        return new Proyecto(codigo, fechaSolicitud, fechaInicio, fechaFin, estado, metodoPago, valorTotal);
    }

    public String ingresarCodigoProyecto() {
        return JOptionPane.showInputDialog("Ingrese el codigo del proyecto");
    }

    public String ingresarIdDesarrollador() {
        return JOptionPane.showInputDialog("Ingrese el ID del desarrollador");
    }

    public String ingresarCodigoServicio() {
        return JOptionPane.showInputDialog("Ingrese el codigo del servicio");
    }

    // FUNCIONES DE REGISTRO Y ACTUALIZAR ----------

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

    public boolean registrarProyecto(Proyecto nuevoProyecto) {
        if (encontrarIndexProyecto(nuevoProyecto.getCodigo()) == -1) {
            for (int i = 0; i < listProyectos.length; i++) {
                if (listProyectos[i] == null) {
                    listProyectos[i] = nuevoProyecto;
                    return true;
                }
            }
        }
        return false;
    }

    public boolean actualizarProyecto(String codigoProyectoActualizar, Proyecto nuevoProyecto) {
        int index = encontrarIndexProyecto(codigoProyectoActualizar);

        if (index != -1 && nuevoProyecto != null) {
            Proyecto proyectoExistente = listProyectos[index];

            // Si el estado cambia a "Confirmado", llamamos a la función auxiliar
            if (nuevoProyecto.getEstado().equals("Confirmado")) {
                desvincularYLimpiarDesarrolladores(proyectoExistente);
            }

            // Actualizamos los atributos con los nuevos datos
            proyectoExistente.setFechaInicio(nuevoProyecto.getFechaInicio());
            proyectoExistente.setFechaFin(nuevoProyecto.getFechaFin());
            proyectoExistente.setEstado(nuevoProyecto.getEstado());
            proyectoExistente.setMetodoPago(nuevoProyecto.getMetodoPago());
            proyectoExistente.setValorTotal(nuevoProyecto.getValorTotal());

            return true;
        }
        return false;
    }

    /*Funcion para limpiar tabla de desarrolladores del proyecto y asi mismo
     eliminar el proyecto de la tabla de proyectos del desarrollador*/
    private void desvincularYLimpiarDesarrolladores(Proyecto proyecto) {
        AsignacionDesarrollador[] asignaciones = proyecto.getListAsigDesarrollador();

        if (asignaciones == null) return;

        for (int i = 0; i < asignaciones.length; i++) {
            AsignacionDesarrollador asig = asignaciones[i];

            if (asig != null && asig.getTheDesarrollador() != null) {
                Desarrollador dev = asig.getTheDesarrollador();

                dev.removerAsignacion(asig);

                if (dev.obtenerCantidadProyectosActuales() == 0) {
                    dev.setEstado("Disponible");
                }

                asig.setTheDesarrollador(null);
            }

            asignaciones[i] = null;
        }
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

    public Desarrollador consultarDesarrolladorId(String id) {
        Desarrollador desarrolladorEncontrado = null;
        if (!id.isEmpty()) {
            for (int i = 0; i < listDesarrolladores.length; i++) {
                if (listDesarrolladores[i] != null) {
                    if (listDesarrolladores[i].getId().equals(id)) {
                        desarrolladorEncontrado = listDesarrolladores[i];
                    }
                }
            }
        }
        return desarrolladorEncontrado;
    }

    public Servicio consultarServicioCodigo(String codigo) {
        Servicio servicioEncontrado = null;
        if (!codigo.isEmpty()) {
            for (int i = 0; i < listServicios.length; i++) {
                if (listServicios[i] != null) {
                    if (listServicios[i].getCodigo().equals(codigo)) {
                        servicioEncontrado = listServicios[i];
                    }
                }
            }
        }
        return servicioEncontrado;
    }

    public Proyecto consultarProyectoCodigo(String codigo) {
        Proyecto proyectoEncontrado = null;
        if (!codigo.isEmpty()) {
            for (int i = 0; i < listProyectos.length; i++) {
                if (listProyectos[i] != null) {
                    if (listProyectos[i].getCodigo().equals(codigo)) {
                        proyectoEncontrado = listProyectos[i];
                    }
                }
            }
        }
        return proyectoEncontrado;
    }

    //FUNCIONES DE IMPRESION ----------

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

    public void imprimirResultadoConsultaProyecto(Proyecto proyectoEncontrado) {

        double valorBase = proyectoEncontrado.getValorTotal();
        double valorAdicional = proyectoEncontrado.calcularValorAdicional();
        double valorTotal = valorBase + valorAdicional;

        JOptionPane.showMessageDialog(null,
                "Proyecto Encontrado" +
                        "\n Codigo: " + proyectoEncontrado.getCodigo() +
                        "\n Fecha de la Solicitud: " + proyectoEncontrado.getFechaSolicitud() +
                        "\n Fecha de Inicio: " + proyectoEncontrado.getFechaInicio() +
                        "\n Fecha de Fin: " + proyectoEncontrado.getFechaFin() +
                        "\n Estado: " + proyectoEncontrado.getEstado() +
                        "\n Metodo de Pago: " + proyectoEncontrado.getMetodoPago() +
                        "\n Cantidad de Desarrolladores: " + proyectoEncontrado.obtenerCantidadDesarrolladores() +
                        "\n Cantidad de Servicios: " + proyectoEncontrado.obtenerCantidadServicios() +
                        "\n Valor Base: " + valorBase +
                        "\n Valor Adicional por servicios: " + valorAdicional +
                        "\n Valor Total: " + valorTotal);
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
