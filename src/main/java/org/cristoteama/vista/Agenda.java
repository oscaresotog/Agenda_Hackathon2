package org.cristoteama.vista;

import org.cristoteama.modelo.Contacto;

import javax.swing.*;
import java.util.List;

public class Agenda {

    // Componentes de la interfaz gráfica swing vinculados al archivo .form
    private JPanel panel1;
    private JButton agregarContactoButton;
    private JButton eliminarContactoButton;
    private JButton buscarContactoButton;
    private JButton verEstadoDeAgendaButton;
    private JTextField textField1; // Input Nombre
    private JTextField textField2; // Input Apellido
    private JTextField textField3; // Input Teléfono
    private JList<String> list1;   // Vista de lista principal
    private JButton modificarTelefonoButton;

    // Dependencias lógicas y modelo de datos para la vista
    private final org.cristoteama.logica.Agenda miAgenda;
    private final DefaultListModel<String> modeloLista;

    // Constructor: Inicialización de componentes base
    public Agenda() {
        this.miAgenda = new org.cristoteama.logica.Agenda();
        this.modeloLista = new DefaultListModel<>();
        this.list1.setModel(modeloLista);

        configurarListeners();
    }

    // Encapsulamiento de la configuración de eventos
    private void configurarListeners() {

        // Acción: Agregar nuevo contacto
        agregarContactoButton.addActionListener(e -> {
            String nombre = textField1.getText().trim();
            String apellido = textField2.getText().trim();
            String telefono = textField3.getText().trim();

            Contacto nuevoContacto = new Contacto(nombre, apellido, telefono);
            String resultado = miAgenda.añadirContacto(nuevoContacto);

            JOptionPane.showMessageDialog(null, resultado, "Registro de Contacto", JOptionPane.INFORMATION_MESSAGE);

            if (resultado.equals("Contacto añadido correctamente.")) {
                actualizarListaVisual();
                limpiarCampos();
            }
        });

        // Acción: Modificar teléfono existente
        modificarTelefonoButton.addActionListener(e -> {
            String nombre = textField1.getText().trim();
            String apellido = textField2.getText().trim();
            String nuevoTelefono = textField3.getText().trim();

            if (nombre.isEmpty() || apellido.isEmpty() || nuevoTelefono.isEmpty()) {
                JOptionPane.showMessageDialog(null, "Por favor, completa Nombre, Apellido y el Nuevo Teléfono.", "Validación", JOptionPane.WARNING_MESSAGE);
                return;
            }

            String resultado = miAgenda.modificarTelefono(nombre, apellido, nuevoTelefono);

            if (resultado.equals("Teléfono actualizado correctamente.")) {
                JOptionPane.showMessageDialog(null, resultado, "Actualización Exitosa", JOptionPane.INFORMATION_MESSAGE);
                actualizarListaVisual();
                limpiarCampos();
            } else {
                JOptionPane.showMessageDialog(null, resultado, "Error de Actualización", JOptionPane.ERROR_MESSAGE);
            }
        });

        // Acción: Buscar contacto y resaltarlo en la JList
        buscarContactoButton.addActionListener(e -> {
            String nombre = textField1.getText().trim();
            String apellido = textField2.getText().trim();

            Contacto encontrado = miAgenda.buscarContacto(nombre, apellido);

            if (encontrado != null) {
                textField3.setText(encontrado.getTelefono());

                String textoLista = encontrado.getNombre() + " " + encontrado.getApellido() + " - " + encontrado.getTelefono();
                int index = modeloLista.indexOf(textoLista);

                if (index != -1) {
                    list1.setSelectedIndex(index);
                    list1.ensureIndexIsVisible(index);
                }

                String mensajeDetallado = String.format("¡Contacto encontrado!\n\nNombre: %s\nApellido: %s\nTeléfono: %s",
                        encontrado.getNombre(), encontrado.getApellido(), encontrado.getTelefono());

                JOptionPane.showMessageDialog(null, mensajeDetallado, "Búsqueda Exitosa", JOptionPane.INFORMATION_MESSAGE);

            } else {
                list1.clearSelection();
                JOptionPane.showMessageDialog(null, "El contacto no existe en la agenda.", "Error de Búsqueda", JOptionPane.WARNING_MESSAGE);
            }
        });

        // Acción: Eliminar contacto
        eliminarContactoButton.addActionListener(e -> {
            String nombre = textField1.getText().trim();
            String apellido = textField2.getText().trim();

            String resultado = miAgenda.eliminarContacto(nombre, apellido);
            JOptionPane.showMessageDialog(null, resultado, "Eliminación", JOptionPane.INFORMATION_MESSAGE);

            actualizarListaVisual();
            limpiarCampos();
        });

        // Acción: Consultar disponibilidad de la agenda
        verEstadoDeAgendaButton.addActionListener(e -> {
            int libres = miAgenda.espaciosLibres();
            boolean llena = miAgenda.agendaLlena();

            String estado = llena ? "¡LA AGENDA ESTÁ LLENA!\n" : "Estado: Con espacio disponible.\n";
            estado += "Espacios libres restantes: " + libres;

            JOptionPane.showMessageDialog(null, estado, "Estado de la Agenda", JOptionPane.INFORMATION_MESSAGE);
        });
    }

    // --- Métodos de utilidad de la Interfaz Gráfica ---

    // Sincroniza la información
    private void actualizarListaVisual() {
        modeloLista.clear();

        List<Contacto> contactos = miAgenda.obtenerContactos();
        for (Contacto c : contactos) {
            modeloLista.addElement(c.getNombre() + " " + c.getApellido() + " - " + c.getTelefono());
        }
    }

    // Restablece los campos de entrada y enfoca el cursor
    private void limpiarCampos() {
        textField1.setText("");
        textField2.setText("");
        textField3.setText("");
        textField1.requestFocus(); // UX: Regresa el cursor al primer campo automáticamente
    }

    public JPanel getPanelPrincipal() {
        return panel1;
    }
}