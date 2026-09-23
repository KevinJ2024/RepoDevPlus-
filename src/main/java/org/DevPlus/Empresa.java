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

    public Empresa(String NIT, String nombreComercial,
                   String direccion, String telefono,
                   String paginaWeb) {
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
                break;
            case 2:
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
                        "\n 4. Eliminar Proyecto" +
                        "\n 0. Regresar"));

        switch (option) {
            case 1:
                break;
            case 2:
                break;
            case 3:
                break;
            case 4:
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
                break;
            case 0:
                break;
            default:
                JOptionPane.showMessageDialog(null, "Ingrese una opcion valida");
        }
    }
}