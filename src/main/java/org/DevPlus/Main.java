package org.DevPlus;

import javax.swing.*;
import java.time.LocalDate;

public class Main {
    static Empresa devPlus = new Empresa("1234", "DevPlus",
            "aa", "123456",
            "https://");

    public static void main(String[] args) {
        int option = 0;
        do {
            option = Integer.parseInt(JOptionPane.showInputDialog(
                    "MENU DevPlus " +
                            "\n 1. Menu de Clientes" +
                            "\n 2. Menu de Desarrolladores" +
                            "\n 3. Menu de Proyectos" +
                            "\n 4. Menu de Servicios" +
                            "\n 5. Menu de Estadisticas" +
                            "\n 0. Salir del sistema"));

            switch (option) {
                case 1:
                    menuClientes();
                    break;
                case 2:
                    menuDesarrolladores();
                    break;
                case 3:
                    menuProyectos();
                    break;
                case 4:
                    menuServicios();
                    break;
                case 5:
                    menuEstadisticas();
                    break;
                case 0:
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Ingrese una opcion valida");
            }

        } while (option != 0);

    }

    public static void menuClientes() {
        int option = Integer.parseInt(JOptionPane.showInputDialog(
                "Menu Clientes" +
                        "\n 1. Registrar Cliente" +
                        "\n 2. Consultar por telefono" +
                        "\n 0. Regresar"));

        switch (option) {
            case 1:
                Cliente datos = devPlus.ingresarDatosRegistroCliente();
                boolean res = devPlus.registrarCliente(datos);

                if (res) {
                    JOptionPane.showMessageDialog(null, "Se registro exitosamente el cliente");
                } else {
                    JOptionPane.showMessageDialog(null, "No se pudo guardar el cliente");
                }
                break;
            case 2:
                long telefonoConsultado = devPlus.ingresarTelefonoCliente();
                Cliente clienteEncontrado = devPlus.consultarClienteTelefono(telefonoConsultado);
                if (clienteEncontrado != null) {
                    devPlus.imprimirResultadoConsultaCliente(clienteEncontrado);
                } else {
                    JOptionPane.showMessageDialog(null, "El cliente no existe o no pudo ser encontrado");
                }
                break;
            case 0:
                break;
            default:
                JOptionPane.showMessageDialog(null, "Ingrese una opcion valida");
        }
    }

    public static void menuDesarrolladores() {
        int option = Integer.parseInt(JOptionPane.showInputDialog(
                "Menu Desarrolladores" +
                        "\n 1. Registrar Desarrollador" +
                        "\n 0. Regresar"));

        switch (option) {
            case 1:
                Desarrollador datos = devPlus.ingresarDatosRegistroDesarrollador();
                boolean res = devPlus.registrarDesarrollador(datos);

                if (res) {
                    JOptionPane.showMessageDialog(null, "Se registro exitosamente el desarrollador");
                } else {
                    JOptionPane.showMessageDialog(null, "No se pudo guardar el desarrollador");
                }
                break;
            case 0:
                break;
            default:
                JOptionPane.showMessageDialog(null, "Ingrese una opcion valida");
        }
    }

    public static void menuProyectos() {
        int option = Integer.parseInt(JOptionPane.showInputDialog(
                "Menu Proyectos" +
                        "\n 1. Registrar Proyecto" +
                        "\n 2. Consultar Proyecto" +
                        "\n 3. Actualizar Proyecto" +
                        "\n 4. Añadir Desarrollador" +
                        "\n 5. Añador Servicio" +
                        "\n 0. Regresar"));

        switch (option) {
            case 1:
                Proyecto datosRegistrar = devPlus.ingresarDatosRegistroProyecto();
                boolean res = devPlus.registrarProyecto(datosRegistrar);

                if (res) {
                    JOptionPane.showMessageDialog(null, "Se registro exitosamente el proyecto");
                } else {
                    JOptionPane.showMessageDialog(null, "No se pudo guardar el proyecto");
                }
                break;
            case 2:
                String codigoClienteConsultar = devPlus.ingresarCodigoProyecto();
                Proyecto proyectoEncontrado = devPlus.consultarProyectoCodigo(codigoClienteConsultar);
                if (proyectoEncontrado != null) {
                    devPlus.imprimirResultadoConsultaProyecto(proyectoEncontrado);
                } else {
                    JOptionPane.showMessageDialog(null, "El proyecto no existe o no pudo ser encontrado");
                }
                break;
            case 3:
                String codigoProyectoActualizar = devPlus.ingresarCodigoProyecto();
                Proyecto proyectoActualizar = devPlus.consultarProyectoCodigo(codigoProyectoActualizar);
                Proyecto datosActualizar = devPlus.ingresarDatosActualizarProyecto(proyectoActualizar);

                if (devPlus.actualizarProyecto(codigoProyectoActualizar, datosActualizar)) {
                    JOptionPane.showMessageDialog(null, "Se actualizo exitosamente el proyecto");
                } else {
                    JOptionPane.showMessageDialog(null, "No se pudo actualizar el proyecto");
                }
                break;
            case 4:
                String codigoProyectoDev = devPlus.ingresarCodigoProyecto();
                Proyecto proyectoAnadirDev = devPlus.consultarProyectoCodigo(codigoProyectoDev);

                String idDesarrolladorAnadir = devPlus.ingresarIdDesarrollador();
                Desarrollador desarrolladorEncontradoAnadir = devPlus.consultarDesarrolladorId(idDesarrolladorAnadir);

                if (proyectoAnadirDev.agregarDesarrollador(desarrolladorEncontradoAnadir)) {
                    JOptionPane.showMessageDialog(null, "Se añadio correctamente el desarrollador al proyecto");
                } else {
                    JOptionPane.showMessageDialog(null, "No se pudo añadir al desarrollador al proyecto");
                }
                break;
            case 5:
                String codigoProyectoServicio = devPlus.ingresarCodigoProyecto();
                Proyecto proyectoAnadirServicio = devPlus.consultarProyectoCodigo(codigoProyectoServicio);

                String codigoServicioAnadir = devPlus.ingresarCodigoServicio();
                Servicio servicioEncontradoAnadir = devPlus.consultarServicioCodigo(codigoServicioAnadir);

                if (proyectoAnadirServicio.agregarServicio(servicioEncontradoAnadir)) {
                    JOptionPane.showMessageDialog(null, "Se añadio correctamente el servicio al proyecto");
                } else {
                    JOptionPane.showMessageDialog(null, "No se pudo añadir el servicio al proyecto");
                }
                break;
            case 0:
                break;
            default:
                JOptionPane.showMessageDialog(null, "Ingrese una opcion valida");
        }
    }

    public static void menuServicios() {
        int option = Integer.parseInt(JOptionPane.showInputDialog(
                "Menu Servicios" +
                        "\n 1. Registrar Servicio" +
                        "\n 0. Regresar"));

        switch (option) {
            case 1:
                Servicio datos = devPlus.ingresarDatosRegistroServicio();
                boolean res = devPlus.registrarServicio(datos);

                if (res) {
                    JOptionPane.showMessageDialog(null, "Se registro exitosamente el servicio");
                } else {
                    JOptionPane.showMessageDialog(null, "No se pudo guardar el servicio");
                }
                break;
            case 0:
                break;
            default:
                JOptionPane.showMessageDialog(null, "Ingrese una opcion valida");
        }
    }

    public static void menuEstadisticas() {
        int option = Integer.parseInt(JOptionPane.showInputDialog(
                "Menu Estadisticas" +
                        "\n 1. Consultar Ingresos" +
                        "\n 0. Regresar"));

        switch (option) {
            case 1:
                LocalDate fechaSolicitudIngresos = devPlus.ingresarFechaSolicitudIngresos();

                double ingresos = devPlus.calcularIngresosEmpresa(fechaSolicitudIngresos);
                JOptionPane.showMessageDialog(null, "Los ingresos de la empresa por los proyectos con fecha solicitud de" +
                        "\n" + fechaSolicitudIngresos +
                        "\n fueron de: " + ingresos);
                break;
            case 0:
                break;
            default:
                JOptionPane.showMessageDialog(null, "Ingrese una opcion valida");
        }
    }


}