package org.cristoteama.logica;

import org.cristoteama.modelo.Contacto;

import java.util.ArrayList;
import java.util.Comparator;

public class Agenda {
    ArrayList<Contacto> agenda = new ArrayList<>();
    private final int Capacidad = 10;

    public void añadirContacto(Contacto c) {

        if (c.getNombre().trim().isEmpty() ||
                c.getApellido().trim().isEmpty()) {
            System.out.println("El nombre y apellido no pueden estar vacíos.");
            return;
        }

        if (agenda.size() >= Capacidad) {
            System.out.println("La agenda está llena.");
            return;
        }

        if (existeContacto(c)) {
            System.out.println("El contacto ya existe.");
            return;
        }
        if (agendaLlena()) {
            System.out.println("La agenda está llena.");
            return;
        }

        agenda.add(c);
        System.out.println("Contacto añadido correctamente.");
    }

    public boolean existeContacto(Contacto c) {

        for (Contacto contacto : agenda) {
            if (contacto.getNombre().equalsIgnoreCase(c.getNombre())
                    && contacto.getApellido().equalsIgnoreCase(c.getApellido())) {
                return true;
            }
        }

        return false;
    }

    public void listarContactos() {

        agenda.sort(
                Comparator.comparing(Contacto::getNombre)
                        .thenComparing(Contacto::getApellido)
        );
        for (Contacto c : agenda) {
            System.out.println(c.getNombre()+" "+c.getApellido()+" - "+c.getTelefono());
        }
    }

    public void buscaContacto(String nombreCompleto) {

        for (Contacto c : agenda) {

            String nombreAgenda =
                    c.getNombre() + " " + c.getApellido();

            if (nombreAgenda.equalsIgnoreCase(nombreCompleto)) {
                System.out.println("Teléfono: " + c.getTelefono());
                return;
            }
        }

        System.out.println("Contacto no encontrado.");
    }

    public void eliminarContacto(Contacto c) {
        for (int i = 0; i < agenda.size(); i++) {
            Contacto contacto = agenda.get(i);
            if (contacto.getNombre().equalsIgnoreCase(c.getNombre())
            && contacto.getApellido().equalsIgnoreCase(c.getApellido())) {
                agenda.remove(i);
                System.out.println("Contacto eliminado.");
                return;
            }
        }
        System.out.println("El contacto no existe.");

    }
    public boolean agendaLlena() {
        if (agenda.size() >= Capacidad) {
            System.out.println("La agenda está llena. No hay espacio disponible.");
            return true;
        }
        System.out.println("La agenda aún tiene espacio disponible.");
        return false;
    }

    public void modificarTelefono(String nombre, String apellido, String nuevoTelefono) {

        for (Contacto contacto : agenda) {

            if (contacto.getNombre().equalsIgnoreCase(nombre)
                    && contacto.getApellido().equalsIgnoreCase(apellido)) {

                contacto.setTelefono(nuevoTelefono);
                System.out.println("Teléfono actualizado correctamente.");
                return;
            }
        }

        System.out.println("El contacto no existe.");
    }

    public void espaciosLibres() {

        int libres = Capacidad- agenda.size();

        System.out.println("Espacios libres: " + libres);
    }

}
