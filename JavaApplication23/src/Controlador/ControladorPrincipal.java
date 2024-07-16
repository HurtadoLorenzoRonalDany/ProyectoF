/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import Modelo.Instituciones;
import static Modelo.Instituciones.leerInstituciones;
import java.io.IOException;
import java.util.Scanner;

/**
 *
 * @author Computer
 */
public class ControladorPrincipal {
    private Instituciones[] instituciones;
    private Scanner scanner;
    //constructor del controlador
    public ControladorPrincipal(String archivo) {
        this.scanner = new Scanner(System.in);
        try {
            this.instituciones = leerInstituciones(archivo);
        } catch (IOException e) {
            System.out.println("Error al leer el archivo: " + e.getMessage());
            ControladorErrores.guardarError("Error al leer el archivo: " + e.getMessage());
        }
    }
    //opciones de menu principal
    public void mostrarMenuPrincipal() {
        int opcion;
        do {
            System.out.println("------ MENU PRINCIPAL ------");
            System.out.println("1. Instituciones por nivel de modalidad");
            System.out.println("2. Instituciones de acuerdo al numero de alumnos");
            System.out.println("3. Cantidad de alumnos por tipo de gestion");
            System.out.println("4. Instituciones de acuerdo al numero de aulas");
            System.out.println("5. Salir del programa");
            System.out.print("Ingrese su opcion: ");
            opcion = scanner.nextInt();
            switch (opcion) {
                case 1:
                    mostrarSubMenu("nivelModalidad");
                    break;
                case 2:
                    mostrarSubMenu("cantAlumnos");
                    break;
                case 3:
                    mostrarSubMenu("tipoGestion");
                    break;
                case 4:
                    mostrarSubMenu("numAulas");
                    break;
                case 5:
                    System.out.println("Cerrando el programa");
                    break;
                default:
                    System.out.println("Opcion no valida. Intente de nuevo.");
                    break;
            }
        } while (opcion != 5);
    }
    //opciones de menu secundario
    private void mostrarSubMenu(String criterioOrdenamiento) {
        int opcion;
        do {
            System.out.println("------ SUB-MENU ------");
            System.out.println("1. Imprimir reporte en consola");
            System.out.println("2. Exportar reporte");
            System.out.println("3. Volver al menu anterior");
            System.out.print("Ingrese su opcion: ");
            opcion = scanner.nextInt();
            switch (opcion) {
                case 1:
                    ControladorReportes.imprimirReporte(instituciones, criterioOrdenamiento);
                    break;
                case 2:
                    ControladorReportes.exportarReporte(instituciones, criterioOrdenamiento);
                    break;
                case 3:
                    System.out.println("Volviendo al menu principal.");
                    break;
                default:
                    System.out.println("Opcion no valida. Intente de nuevo.");
                    break;
            }
        } while (opcion != 3);
    }
}
