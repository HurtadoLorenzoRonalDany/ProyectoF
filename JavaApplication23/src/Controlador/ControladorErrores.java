/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 *
 * @author Computer
 */
public class ControladorErrores {
    public static void guardarError(String mensajeError) {
        // Nombre del archivo
        String nombreArchivo = "errores.log";

        // Obtener la fecha y hora actual
        LocalDateTime ahora = LocalDateTime.now();
        DateTimeFormatter formato = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String fechaHora = ahora.format(formato);

        // Texto que se va a escribir en el archivo
        String texto = fechaHora + " - " + mensajeError + "\n";

        // Crear el archivo si no existe y escribir en él
        try (FileWriter escritor = new FileWriter(new File(nombreArchivo), true)) {
            escritor.write(texto);
        } catch (IOException e) {
            // Manejar la excepción en caso de error
            System.err.println("Error al escribir en el archivo: " + e.getMessage());
        }
    }
}
