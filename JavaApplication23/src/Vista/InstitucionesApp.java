/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Vista;

import Controlador.ControladorPrincipal;
import Modelo.LoginUsuario;

/**
 *
 * @author Computer
 */
public class InstitucionesApp {
    public static void main(String[] args) {
        LoginUsuario autenticacion = new LoginUsuario();
        
        if (autenticacion.iniciarSesion()) {
            String archivo = "Instituciones1.txt"; // Ruta del archivo .txt con los datos de instituciones
            ControladorPrincipal controlador = new ControladorPrincipal(archivo);
            controlador.mostrarMenuPrincipal();
        }
    }
}
