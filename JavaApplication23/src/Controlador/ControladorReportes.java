/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import Modelo.Instituciones;
import java.io.FileWriter;
import java.io.IOException;

/**
 *
 * @author Computer
 */
public class ControladorReportes {
    //metodo de impresion de reporte
    public static void imprimirReporte(Instituciones[] instituciones, String criterioOrdenamiento) {
        //formato de ordenamiento y encabezado de la lista
        if (criterioOrdenamiento.equals("nivelModalidad")) {
            OrdenadorInstituciones.ordenarPorNivelModalidad(instituciones);
            System.out.println("Numero         Nivel de modalidad                     Instituciones educativas");
        } else if (criterioOrdenamiento.equals("cantAlumnos")) {
            OrdenadorInstituciones.ordenarPorCantAlumnos(instituciones);
            System.out.println("Numero  Cantidad de alumnos          Instituciones educativas");
        } else if (criterioOrdenamiento.equals("tipoGestion")) {
            OrdenadorInstituciones.ordenarPorTipoGestion(instituciones);
            System.out.println("Numero           Tipo de gestion              Cantidad de alumnos");
        } else if (criterioOrdenamiento.equals("numAulas")) {
            OrdenadorInstituciones.ordenarPorNumAulas(instituciones);
            System.out.println("Numero  Numero de aulas          Instituciones educativas");
        }
        //formato de la lista
        for (int i = 0; i < instituciones.length; i++) {
            Instituciones institucion = instituciones[i];
            if (institucion != null) {
                if (criterioOrdenamiento.equals("nivelModalidad")) {
                    System.out.printf("%6d   %-44s %-12s\n", i + 1, institucion.getNivelModalidad(), institucion.getNombre());
                } else if (criterioOrdenamiento.equals("cantAlumnos")) {
                    System.out.printf("%6d     %16d   %-40s\n", i + 1, institucion.getCantAlumnos(), institucion.getNombre());
                } else if (criterioOrdenamiento.equals("tipoGestion")) {
                    System.out.printf("%6d     %-35s %18d\n", i + 1, institucion.getTipoGestion(), institucion.getCantAlumnos());
                } else if (criterioOrdenamiento.equals("numAulas")) {
                    System.out.printf("%6d     %12d   %-40s\n", i + 1, institucion.getNumAulas(), institucion.getNombre());
                }
            }
        }
    }
    //metodo de impresion para exportacion
    public static void exportarReporte(Instituciones[] instituciones, String criterioOrdenamiento) {
        //formato de ordenamiento
        if (criterioOrdenamiento.equals("nivelModalidad")) {
            OrdenadorInstituciones.ordenarPorNivelModalidad(instituciones);
        } else if (criterioOrdenamiento.equals("cantAlumnos")) {
            OrdenadorInstituciones.ordenarPorCantAlumnos(instituciones);
        } else if (criterioOrdenamiento.equals("tipoGestion")) {
            OrdenadorInstituciones.ordenarPorTipoGestion(instituciones);
        } else if (criterioOrdenamiento.equals("numAulas")) {
            OrdenadorInstituciones.ordenarPorNumAulas(instituciones);
        }
        //formato de encabezado
        try (FileWriter writer = new FileWriter("reporte.txt")) {
            if (criterioOrdenamiento.equals("nivelModalidad")) {
                writer.append("Numero         Nivel de modalidad                        Instituciones educativas\n");
            } else if (criterioOrdenamiento.equals("cantAlumnos")) {
                writer.append("Numero  Cantidad de alumnos          Instituciones educativas\n");
            } else if (criterioOrdenamiento.equals("tipoGestion")) {
                writer.append("Numero           Tipo de gestion             Cantidad de alumnos\n");
            } else if (criterioOrdenamiento.equals("numAulas")) {
                writer.append("Numero  Numero de aulas          Instituciones educativas\n");
            }
            //formato de lista
            for (int i = 0; i < instituciones.length; i++) {
                Instituciones institucion = instituciones[i];
                if (institucion != null) {
                    if (criterioOrdenamiento.equals("nivelModalidad")) {
                        writer.append(String.format("%6d   %-44s %12s\n",i+1,institucion.getNivelModalidad(),institucion.getNombre()));
                    } else if (criterioOrdenamiento.equals("cantAlumnos")) {
                        writer.append(String.format("%6d     %16d   %-40s\n",i+1,institucion.getCantAlumnos(),institucion.getNombre()));
                    } else if (criterioOrdenamiento.equals("tipoGestion")) {
                        writer.append(String.format("%6d     %-35s %18d\n",i+1,institucion.getTipoGestion(),institucion.getCantAlumnos()));
                    } else if (criterioOrdenamiento.equals("numAulas")) {
                        writer.append(String.format("%6d     %12d   %-40s\n",i+1,institucion.getNumAulas(),institucion.getNombre()));
                    }
                }
            }
            writer.close();
            System.out.println("El reporte ha sido exportado a: reporte.txt");
        } catch (IOException e) {
            System.out.println("Error al exportar el archivo: " + e.getMessage());
        }
    }
}
