/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 *
 * @author Computer
 */
public class Instituciones {
    //Atributos de la clase
    private String nombre;
    private String nivelModalidad;
    private int cantAlumnos;
    private String tipoGestion;
    private int numAulas;
    //Constructor parametrizado ompleto
    public Instituciones(String nombre,String nivelModalidad,int cantAlumnos,String tipoGestion,int numAulas){
        this.nombre=nombre;
        this.nivelModalidad=nivelModalidad;
        this.cantAlumnos=cantAlumnos;
        this.tipoGestion=tipoGestion;
        this.numAulas=numAulas;
    }
    //lector de archivo con validador
    public static Instituciones[] leerInstituciones(String archivo) throws IOException {
        int maxItem=199;
        int contador=0;
        Instituciones[] instituciones = new Instituciones[maxItem];
        try (BufferedReader breader = new BufferedReader(new FileReader(archivo))) {
            breader.readLine(); //ignorar la primera línea
            String linea;
            while ((linea = breader.readLine()) != null && contador<maxItem) {
                String[] datos = linea.split("\t");
                String nombre = datos[7];
                String nivelModalidad = datos[8];
                String tipoGestion = datos[9];
                int cantAlumnos = Integer.parseInt(datos[11]);
                int numAulas = Integer.parseInt(datos[13]);
                instituciones[contador++] = new Instituciones(nombre, nivelModalidad, cantAlumnos, tipoGestion, numAulas);
            }
            breader.close();
        }
        return instituciones;
    }
    //Getters y setters
    public String getNombre() {
        return nombre;
    }
    
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    public String getNivelModalidad() {
        return nivelModalidad;
    }
    
    public void setNivelModalidad(String nivelModalidad) {
        this.nivelModalidad = nivelModalidad;
    }
    
    public int getCantAlumnos() {
        return cantAlumnos;
    }
    
    public void setCantAlumnos(int cantAlumnos) {
        this.cantAlumnos = cantAlumnos;
    }
    
    public String getTipoGestion() {
        return tipoGestion;
    }
    
    public void setTipoGestion(String tipoGestion) {
        this.tipoGestion = tipoGestion;
    }
    
    public int getNumAulas() {
        return numAulas;
    }
    
    public void setNumAulas(int numAulas) {
        this.numAulas = numAulas;
    }
}
