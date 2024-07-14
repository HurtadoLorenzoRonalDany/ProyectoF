/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

/**
 *
 * @author Computer
 */
public class InstitucionesOrdenador {
    //formato de orden para las 4 opciones
    public static void ordenarPorNivelModalidad(Instituciones[] instituciones) {
        for (int i = 0; i < instituciones.length - 1; i++) {
            for (int j = i + 1; j < instituciones.length; j++) {
                if (instituciones[i].getNivelModalidad().compareTo(instituciones[j].getNivelModalidad()) > 0) {
                    cambio(instituciones, i, j);
                }
            }
        }
    }
    
    public static void ordenarPorCantAlumnos(Instituciones[] instituciones) {
        for (int i = 0; i < instituciones.length - 1; i++) {
            for (int j = i + 1; j < instituciones.length; j++) {
                if (instituciones[i].getCantAlumnos() < instituciones[j].getCantAlumnos()) {
                    cambio(instituciones, i, j);
                }
            }
        }
    }
    
    public static void ordenarPorTipoGestion(Instituciones[] instituciones) {
        for (int i = 0; i < instituciones.length - 1; i++) {
            for (int j = i + 1; j < instituciones.length; j++) {
                if (instituciones[i].getTipoGestion().compareTo(instituciones[j].getTipoGestion()) > 0) {
                    cambio(instituciones, i, j);
                }
            }
        }
    }
    
    public static void ordenarPorNumAulas(Instituciones[] instituciones) {
        for (int i = 0; i < instituciones.length - 1; i++) {
            for (int j = i + 1; j < instituciones.length; j++) {
                if (instituciones[i].getNumAulas() < instituciones[j].getNumAulas()) {
                    cambio(instituciones, i, j);
                }
            }
        }
    }
    //metodo bubble sort repetitivo
    private static void cambio(Instituciones[] arr, int i, int j) {
        Instituciones temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
