package org.example.controllers;

import org.example.entities.Cliente;
import org.example.entities.GeneroCliente;
import org.example.persistence.ClienteJPA;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.List;
import java.util.Scanner;

public class ClienteController {
    private final Scanner scanner;
    private final ClienteJPA clienteJPA;

    public ClienteController() {
        this.scanner = new Scanner(System.in);
        this.clienteJPA = new ClienteJPA();
    }

    //Agregar un nuevo cliente
    public void agregarCliente() {
        System.out.println("\n--- Agregar nuevo cliente ---");

        System.out.print("Nombre: ");
        String nombre = leerNoVacio();

        System.out.print("Primer apellido: ");
        String primerApellido = leerNoVacio();

        System.out.print("Segundo apellido: ");
        String segundoApellido = leerNoVacio();

        System.out.print("Ciudad: ");
        String ciudad = leerNoVacio();

        System.out.print("Teléfono: ");
        String telefono = leerNoVacio();

        System.out.print("Email: ");
        String email = leerNoVacio();

        LocalDate fechaNacimiento = null;
        while (fechaNacimiento == null) {
            System.out.print("Fecha de nacimiento (YYYY-MM-DD): ");
            try {
                fechaNacimiento = LocalDate.parse(scanner.nextLine());
            } catch (DateTimeParseException e) {
                System.out.println("Formato inválido. Vuelva a intentarlo.");
            }
        }

        GeneroCliente genero = null;
        while (genero == null) {
            System.out.print("Sexo (MASCULINO / FEMENINO / OTRO): ");
            try {
                genero = GeneroCliente.valueOf(scanner.nextLine().toUpperCase());
            } catch (IllegalArgumentException e) {
                System.out.println("Sexo no válido. Vuelva a intentarlo.");
            }
        }

        Cliente cliente = new Cliente(nombre, primerApellido, segundoApellido, genero, ciudad, fechaNacimiento, telefono, email);
        clienteJPA.guardarCliente(cliente);
        System.out.println("Cliente guardado correctamente.");
    }

    //Listar todos los clientes
    public void listarClientes() {
        System.out.println("\n--- Lista de clientes ---");
        List<Cliente> clientes = clienteJPA.listarClientes();
        if (clientes.isEmpty()) {
            System.out.println("No hay clientes registrados.");
        } else {
            clientes.forEach(System.out::println);
        }
    }


    //Actualizar información de un cliente
    public void actualizarCliente() {
        System.out.print("Ingrese el ID del cliente a actualizar: ");
        Long id = Long.parseLong(scanner.nextLine());
        Cliente cliente = clienteJPA.buscarPorId(id);

        if (cliente == null) {
            System.out.println("Cliente no encontrado.");
            return;
        }

        System.out.println("Deje en blanco para mantener el valor actual.");

        System.out.print("Nuevo nombre (" + cliente.getNombre() + "): ");
        String nombre = scanner.nextLine();
        if (!nombre.isEmpty()) cliente.setNombre(nombre);

        System.out.print("Nuevo primer apellido (" + cliente.getPrimerApellido() + "): ");
        String primerApellido = scanner.nextLine();
        if (!primerApellido.isEmpty()) cliente.setPrimerApellido(primerApellido);

        System.out.print("Nuevo segundo apellido (" + cliente.getSegundoApellido() + "): ");
        String segundoApellido = scanner.nextLine();
        if (!segundoApellido.isEmpty()) cliente.setSegundoApellido(segundoApellido);

        System.out.print("Nueva ciudad (" + cliente.getCiudad() + "): ");
        String ciudad = scanner.nextLine();
        if (!ciudad.isEmpty()) cliente.setCiudad(ciudad);

        System.out.print("Nuevo teléfono (" + cliente.getTelefono() + "): ");
        String telefono = scanner.nextLine();
        if (!telefono.isEmpty()) cliente.setTelefono(telefono);

        System.out.print("Nuevo email (" + cliente.getEmail() + "): ");
        String email = scanner.nextLine();
        if (!email.isEmpty()) cliente.setEmail(email);

        System.out.print("Nueva fecha de nacimiento (" + cliente.getFechaNacimiento() + "): ");
        String fecha = scanner.nextLine();
        if (!fecha.isEmpty()) {
            try {
                cliente.setFechaNacimiento(LocalDate.parse(fecha));
            } catch (DateTimeParseException e) {
                System.out.println("Fecha inválida. Se mantiene la anterior.");
            }
        }

        System.out.print("Nuevo sexo (" + cliente.getSexo() + "): ");
        String sexo = scanner.nextLine();
        if (!sexo.isEmpty()) {
            try {
                cliente.setSexo(GeneroCliente.valueOf(sexo.toUpperCase()));
            } catch (IllegalArgumentException e) {
                System.out.println("Sexo inválido. Se mantiene el anterior.");
            }
        }

        clienteJPA.actualizarCliente(cliente);
        System.out.println("Cliente actualizado correctamente.");
    }

    //Eliminar un cliente
    public void eliminarCliente() {
        System.out.print("Ingrese el ID del cliente a eliminar: ");
        Long id = Long.parseLong(scanner.nextLine());

        Cliente cliente = clienteJPA.buscarPorId(id);
        if (cliente == null) {
            System.out.println("Cliente no encontrado.");
            return;
        }

        clienteJPA.eliminarCliente(cliente);
        System.out.println("Cliente eliminado correctamente.");
    }

    //Buscar clientes por ciudad
    public void buscarClientePorCiudad() {
        System.out.print("Ingrese la ciudad: ");
        String ciudad = scanner.nextLine();

        List<Cliente> clientes = clienteJPA.buscarPorCiudad(ciudad);
        if (clientes.isEmpty()) {
            System.out.println("No se encontraron clientes en esa ciudad.");
        } else {
            clientes.forEach(System.out::println);
        }
    }

    //Metodo para que no haya respuestas vacías
    private String leerNoVacio() {
        String entrada = scanner.nextLine();
        while (entrada.isBlank()) {
            System.out.print("Este campo es obligatorio. Ingrese de nuevo: ");
            entrada = scanner.nextLine();
        }
        return entrada;
    }
}
