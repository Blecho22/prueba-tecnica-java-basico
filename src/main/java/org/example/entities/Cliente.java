package org.example.entities;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "clientes")
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nombre;

    @Column(nullable = false)
    private String primerApellido;

    @Column(nullable = false)
    private String segundoApellido;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private GeneroCliente sexo;

    @Column(nullable = false)
    private String ciudad;

    @Column(nullable = false)
    private LocalDate fechaNacimiento;

    @Column(nullable = false)
    private String telefono;

    @Column(nullable = false, unique = true)
    private String email;

    public Cliente() {
    }

    public Cliente(String nombre, String primerApellido, String segundoApellido, GeneroCliente sexo,
                   String ciudad, LocalDate fechaNacimiento, String telefono, String email) {
        this.nombre = nombre;
        this.primerApellido = primerApellido;
        this.segundoApellido = segundoApellido;
        this.sexo = sexo;
        this.ciudad = ciudad;
        this.fechaNacimiento = fechaNacimiento;
        this.telefono = telefono;
        this.email = email;
    }

    //Getters y Setters
    public Long getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPrimerApellido() {
        return primerApellido;
    }

    public void setPrimerApellido(String primerApellido) {
        this.primerApellido = primerApellido;
    }

    public String getSegundoApellido() {
        return segundoApellido;
    }

    public void setSegundoApellido(String segundoApellido) {
        this.segundoApellido = segundoApellido;
    }

    public GeneroCliente getSexo() {
        return sexo;
    }

    public void setSexo(GeneroCliente sexo) {
        this.sexo = sexo;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public LocalDate getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(LocalDate fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    //Esto arregla que aparezcan bien todos los datos del clietne al listarlo
    @Override
    public String toString() {
        return "ID: " + id +
                ", Nombre: " + nombre +
                ", Apellidos: " + primerApellido + " " + segundoApellido +
                ", Sexo: " + sexo +
                ", Ciudad: " + ciudad +
                ", Fecha de nacimiento: " + fechaNacimiento +
                ", Teléfono: " + telefono +
                ", Correo Electrónico: " + email;

    }

    //Mostrar información de los clientes
    public void imprimirCliente() {
        System.out.println("ID: " + id);
        System.out.println("Nombre completo: " + nombre + " " + primerApellido + " " + segundoApellido);
        System.out.println("Sexo: " + sexo);
        System.out.println("Ciudad: " + ciudad);
        System.out.println("Fecha de nacimiento: " + fechaNacimiento);
        System.out.println("Teléfono: " + telefono);
        System.out.println("Email: " + email);
    }
}
