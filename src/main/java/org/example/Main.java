package org.example;

import org.example.controllers.ClienteController;
import org.example.entities.GeneroCliente;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        ClienteController controller = new ClienteController();
        Scanner scanner = new Scanner(System.in);

        boolean salir = false;

        while (!salir) {
            System.out.println("\n---- MENÚ DE GESTIÓN DE CLIENTES ----");
            System.out.println("1. Agregar cliente");
            System.out.println("2. Listar clientes");
            System.out.println("3. Actualizar cliente");
            System.out.println("4. Eliminar cliente");
            System.out.println("5. Buscar cliente por ciudad");
            System.out.println("6. Salir");
            System.out.print("Seleccione una opción: ");

            String opcion = scanner.nextLine();

            switch (opcion) {
                case "1":
                    controller.agregarCliente();
                    break;
                case "2":
                    controller.listarClientes();
                    break;
                case "3":
                    controller.actualizarCliente();
                    break;
                case "4":
                    controller.eliminarCliente();
                    break;
                case "5":
                    controller.buscarClientePorCiudad();
                    break;
                case "6":
                    salir = true;
                    System.out.println("Saliendo del sistema...");
                    break;
                default:
                    System.out.println("Opción no válida. Intente nuevamente.");
            }
        }

        scanner.close();
    }
}
