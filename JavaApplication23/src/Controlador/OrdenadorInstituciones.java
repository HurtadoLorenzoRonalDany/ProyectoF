/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import Modelo.Instituciones;

/**
 *
 * @author Computer
 */
public class OrdenadorInstituciones {
    //formato de orden para instituciones por nivel de modalidad
    public static void ordenarPorNivelModalidad(Instituciones[] instituciones) {
        for (int i = 0; i < instituciones.length - 1; i++) {
            for (int j = i + 1; j < instituciones.length; j++) {
                if (instituciones[i].getNivelModalidad().compareTo(instituciones[j].getNivelModalidad()) > 0) {
                    // Método de intercambio
                    Instituciones temp = instituciones[i];
                    instituciones[i] = instituciones[j];
                    instituciones[j] = temp;
                }
            }
        }
    }
    // Método combinado que ordena por cantidad de alumnos utilizando método de intercambio
    public static void ordenarPorCantAlumnos(Instituciones[] instituciones) {
        for (int i = 0; i < instituciones.length - 1; i++) {
            for (int j = i + 1; j < instituciones.length; j++) {
                if (instituciones[i].getCantAlumnos() < instituciones[j].getCantAlumnos()) {
                    // Método de intercambio
                    Instituciones temp = instituciones[i];
                    instituciones[i] = instituciones[j];
                    instituciones[j] = temp;
                }
            }
        }
    }
    // Método combinado que ordena por tipo de gestión utilizando método de intercambio
    public static void ordenarPorTipoGestion(Instituciones[] instituciones) {
        for (int i = 0; i < instituciones.length - 1; i++) {
            for (int j = i + 1; j < instituciones.length; j++) {
                if (instituciones[i].getTipoGestion().compareTo(instituciones[j].getTipoGestion()) > 0) {
                    // Método de intercambio
                    Instituciones temp = instituciones[i];
                    instituciones[i] = instituciones[j];
                    instituciones[j] = temp;
                }
            }
        }
    }
    // Método combinado que ordena por número de aulas utilizando método de intercambio
    public static void ordenarPorNumAulas(Instituciones[] instituciones) {
        for (int i = 0; i < instituciones.length - 1; i++) {
            for (int j = i + 1; j < instituciones.length; j++) {
                if (instituciones[i].getNumAulas() < instituciones[j].getNumAulas()) {
                    // Método de intercambio
                    Instituciones temp = instituciones[i];
                    instituciones[i] = instituciones[j];
                    instituciones[j] = temp;
                }
            }
        }
    }
}
