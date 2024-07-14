/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

/**
 *
 * @author Computer
 */
public class LoginUsuario {
    private static final String ARCHIVO_USUARIOS = "usuarios.txt";
    private Scanner scanner;
    //constructor del login
    public LoginUsuario() {
        this.scanner = new Scanner(System.in);
    }
    //revision de elementos del login
    public boolean iniciarSesion() {
        int intentos = 0;
        boolean exito = false;
        
        while (intentos < 3 && !exito) {
            System.out.print("Ingrese su nombre de usuario: ");
            String usuario = scanner.nextLine();
            System.out.print("Ingrese su contraseña: ");
            String contrasena = scanner.nextLine();

            if (validarCredenciales(usuario, contrasena)) {
                System.out.println("Inicio de sesión exitoso. Bienvenido, " + usuario + "!");
                exito = true;
            } else {
                intentos++;
                System.out.println("Credenciales incorrectas. Intento " + intentos + " de 3.");
            }
        }
        if (!exito) {
            System.out.println("Ha superado el número máximo de intentos. Saliendo del programa.");
        }
        return exito;
    }
    //validador de credenciales
    private boolean validarCredenciales(String usuario, String contrasena) {
        try (BufferedReader br = new BufferedReader(new FileReader(ARCHIVO_USUARIOS))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                String[] credenciales = linea.split(":");
                if (credenciales.length == 2) {
                    String usuarioArchivo = credenciales[0];
                    String contrasenaArchivo = credenciales[1];
                    if (usuarioArchivo.equals(usuario) && contrasenaArchivo.equals(contrasena)) {
                        return true;
                    }
                }
            }
        } catch (IOException e) {
            System.out.println("Error al leer el archivo de usuarios: " + e.getMessage());
        }
        return false;
    }
}
