package org.cristoteama.modelo;
import java.util.Objects;



public class Contacto {
    private String nombre;
    private String apellido;
    private String telefono;

    //constructor
    public Contacto(String nombre, String telefono, String apellido) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.telefono = telefono;
    }

    //getters y setters
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

    // Sobrescritura de equal: son dos contactos iguales si solo el nombre coincide
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Contacto contacto = (Contacto) obj;
        return this.nombre.equalsIgnoreCase(contacto.nombre);
    }

    @Override
    public int hashCode() {
        if (nombre == null) {
            return 0;
        }
        return Objects.hash(nombre.toLowerCase());
    }

    @Override
    public String toString(){
        return nombre + " - " + telefono;
        }
    }