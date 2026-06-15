package org;


import org.cristoteama.logica.Agenda;
import org.cristoteama.modelo.Contacto;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Agenda agenda = new Agenda();

        int opcion;

        do {
            System.out.println("\n=== AGENDA ===");
            System.out.println("1. Añadir contacto");
            System.out.println("2. Buscar contacto");
            System.out.println("3. Listar contactos");
            System.out.println("4. Existe contacto");
            System.out.println("5. Eliminar contacto");
            System.out.println("6. Modificar teléfono");
            System.out.println("7. Agenda llena");
            System.out.println("8. Espacios libres");
            System.out.println("9. Salir");
            System.out.print("Seleccione una opción: ");

            opcion = sc.nextInt();
            sc.nextLine(); // limpiar buffer

            switch (opcion) {

                case 1:
                    System.out.print("Nombre: ");
                    String nombre = sc.nextLine();

                    System.out.print("Apellido: ");
                    String apellido = sc.nextLine();

                    System.out.print("Teléfono: ");
                    String telefono = sc.nextLine();

                    Contacto contacto = new Contacto(nombre, apellido, telefono);
                    agenda.añadirContacto(contacto);
                    break;

                case 2:
                    System.out.print("Nombre y apellido a buscar: ");
                    String nombreBusqueda = sc.nextLine();

                    agenda.buscaContacto(nombreBusqueda);
                    break;

                case 3:
                    agenda.listarContactos();
                    break;

                case 4:
                    System.out.print("Nombre del contacto a eliminar: ");
                    String nombreEliminar = sc.nextLine();

                    System.out.print("Apellido del contacto a eliminar: ");
                    String apellidoEliminar = sc.nextLine();
                    Contacto contactoEliminar =
                            new Contacto(nombreEliminar, apellidoEliminar, "");

                    agenda.eliminarContacto(contactoEliminar);
                    break;
                case 5:
                    System.out.println("Saliendo...");
                    break;
                case 6:
                    System.out.print("Nombre: ");
                    String nombreMod = sc.nextLine();

                    System.out.print("Apellido: ");
                    String apellidoMod = sc.nextLine();

                    System.out.print("Nuevo teléfono: ");
                    String nuevoTelefono = sc.nextLine();

                    agenda.modificarTelefono(nombreMod, apellidoMod, nuevoTelefono);
                    break;
                case 7:
                    agenda.agendaLlena();
                    break;
                case 8:
                    agenda.espaciosLibres();
                    break;
                default:
                    System.out.println("Opción no válida.");
            }

        } while (opcion != 9);


    }
}