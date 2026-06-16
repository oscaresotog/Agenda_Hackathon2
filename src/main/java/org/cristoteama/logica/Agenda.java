package org.cristoteama.logica;

import org.cristoteama.modelo.Contacto;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List; // Importamos la interfaz List

public class Agenda {

    // Uso de interfaz List para mayor flexibilidad
    private List<Contacto> agenda = new ArrayList<>();
    private static final int CAPACIDAD = 10; // Límite de contactos

    // Valida antes de la inserción
    public String añadirContacto(Contacto c) {
        if (c.getNombre().trim().isEmpty() || c.getApellido().trim().isEmpty()) {
            return "El nombre y apellido no pueden estar vacíos.";
        }

        if (agendaLlena()) {
            return "La agenda está llena. No hay espacio disponible.";
        }

        if (existeContacto(c)) {
            return "El contacto ya existe.";
        }

        agenda.add(c);
        return "Contacto añadido correctamente.";
    }

    // Validación de duplicidad exclusivamente en nombre y apellido no en el telefono
    public boolean existeContacto(Contacto c) {
        for (Contacto contacto : agenda) {
            if (contacto.getNombre().equalsIgnoreCase(c.getNombre())
                    && contacto.getApellido().equalsIgnoreCase(c.getApellido())) {
                return true;
            }
        }
        return false;
    }

    // Retorna la colección ordenada alfabéticamente para la capa de vista
    public List<Contacto> obtenerContactos() {
        agenda.sort(
                Comparator.comparing(Contacto::getNombre)
                        .thenComparing(Contacto::getApellido)
        );
        return agenda;
    }

    // Búsqueda del objeto completo
    public Contacto buscarContacto(String nombre, String apellido) {
        for (Contacto c : agenda) {
            if (c.getNombre().equalsIgnoreCase(nombre) && c.getApellido().equalsIgnoreCase(apellido)) {
                return c;
            }
        }
        return null;
    }

    // Eliminación por coincidencia de nombre y apellido
    public String eliminarContacto(String nombre, String apellido) {
        for (int i = 0; i < agenda.size(); i++) {
            Contacto contacto = agenda.get(i);
            if (contacto.getNombre().equalsIgnoreCase(nombre)
                    && contacto.getApellido().equalsIgnoreCase(apellido)) {
                agenda.remove(i);
                return "Contacto eliminado exitosamente.";
            }
        }
        return "Error: El contacto no existe.";
    }

    public boolean agendaLlena() {
        return agenda.size() >= CAPACIDAD;
    }

    // Actualización del atributo sin modificar identificadores principales
    public String modificarTelefono(String nombre, String apellido, String nuevoTelefono) {
        for (Contacto contacto : agenda) {
            if (contacto.getNombre().equalsIgnoreCase(nombre)
                    && contacto.getApellido().equalsIgnoreCase(apellido)) {

                contacto.setTelefono(nuevoTelefono);
                return "Teléfono actualizado correctamente.";
            }
        }
        return "Error: El contacto no existe.";
    }

    public int espaciosLibres() {
        return CAPACIDAD - agenda.size();
    }
}