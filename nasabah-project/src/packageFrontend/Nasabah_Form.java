package packageFrontend;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;



public class Nasabah_Form extends JFrame {

    public Nasabah_Form() {
        setTitle("Formulir Nasabah Bank");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Membuat panel CIF
        PanelCIF panelCIF = new PanelCIF();
        add(panelCIF.getPanelCIF(), BorderLayout.NORTH);

        // Membuat panel CIF Personal
        PanelIdentitas panelIdentitas = new PanelIdentitas();
        add(panelIdentitas.getPanelidentitas(), BorderLayout.CENTER);

        // Membuat panel Filter
        PanelFilter panelFilter = new PanelFilter();
        JScrollPane scrollPaneFilter = new JScrollPane(panelFilter.getPanelFilter());
        scrollPaneFilter.setPreferredSize(new Dimension(getWidth(), 50));
        add(panelFilter.getPanelFilter(), BorderLayout.SOUTH);

        pack();
        setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new Nasabah_Form();
        });
    }
}

