package org;

import org.cristoteama.vista.Agendota;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class Main {

    public static void main(String[] args) {

        // Intenta aplicar el estilo visual nativo del sistema operativo varia de max a windows
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException e) {
            System.err.println("Aviso: No se pudo cargar el tema visual del sistema. Se utilizará el tema por defecto.");
        }

        // Ejecución de la interfaz gráfica en el Event Dispatch Thread (EDT)
        SwingUtilities.invokeLater(() -> {

            // inicio de la ventana y la vista principal
            JFrame frame = new JFrame("Mi Agendota Hackathon");
            Agendota vista = new Agendota();

            // Configuración del contenedor y propiedades de la ventana
            frame.setContentPane(vista.getPanelPrincipal());
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.pack();                      // Ajusta la ventana al tamaño de los componentes
            frame.setLocationRelativeTo(null); // Centra la ventana en el monitor
            frame.setVisible(true);            // Despliega la interfaz, nomas es una pagina :)
        });
    }
}