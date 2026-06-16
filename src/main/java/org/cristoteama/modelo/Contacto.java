package org.cristoteama.modelo;

import java.util.Objects; // Necesario para el hashCode

public class Contacto {

    // Atributos encapsulados
    private String nombre;
    private String apellido;
    private String telefono;

    // Constructor con inicialización de estado
    public Contacto(String nombre, String apellido, String telefono) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.telefono = telefono;
    }

    // --- Getters y Setters ---

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    // --- Métodos Sobrescritos de la clase Object ---

    // La identidad lógica del contacto se basa exclusivamente en Nombre y Apellido
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;

        Contacto contacto = (Contacto) obj;

        // Ignoramos mayúsculas/minúsculas para evitar duplicados accidentales (ej. "Bruno" vs "bruno")
        return this.nombre.equalsIgnoreCase(contacto.nombre) &&
                this.apellido.equalsIgnoreCase(contacto.apellido);
    }

    // Contrato de Java: Al sobrescribir equals(), se debe generar un hash coherente
    @Override
    public int hashCode() {
        // Usamos toLowerCase para mantener la coherencia con equalsIgnoreCase
        return Objects.hash(nombre.toLowerCase(), apellido.toLowerCase());
    }

    // Representación en texto del objeto (ideal para logs o depuración rápida)
    @Override
    public String toString() {
        return String.format("%s %s - %s", nombre, apellido, telefono);
    }
}