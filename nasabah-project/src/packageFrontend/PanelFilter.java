package packageFrontend;
import javax.swing.*;
import java.awt.*;
import javax.swing.table.DefaultTableCellRenderer;

public class PanelFilter {
    private JPanel panelFilter;

    public PanelFilter() {
        panelFilter = new JPanel(new BorderLayout());
        panelFilter.setBorder(BorderFactory.createTitledBorder("Filter"));

        //ImageIcon searchIcon = new ImageIcon("/packageFrontend/search_icon.png");
        //JLabel labelSearchIcon = new JLabel(searchIcon);
        JTextField fieldSearch = new JTextField(20);
        JPanel searchPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        //searchPanel.add(labelSearchIcon);
        searchPanel.add(fieldSearch);
        panelFilter.add(searchPanel, BorderLayout.NORTH);

        JPanel tablePanel = new JPanel(new BorderLayout());
        String[] columnNames = {"No", "Nama Lengkap", "No CIF", "Acc Officer", "Tgl Buka", "Jenis Kelamin"};
        Object[][] data = {
                {"1", "John Doe", "12345", "Alice", "2023-01-01", "Laki-laki"},
                {"2", "Jane Smith", "67890", "Bob", "2023-02-02", "Perempuan"},
                //
        };

        JPanel buttonPanel = new JPanel(new GridBagLayout());
        panelFilter.add(buttonPanel, BorderLayout.EAST);

        GridBagConstraints gbcButton = new GridBagConstraints();
        gbcButton.gridx = 0;
        gbcButton.gridy = 0;
        gbcButton.gridwidth = 1;
        gbcButton.anchor = GridBagConstraints.WEST;

        JButton buttonAdd = new JButton("Add");
        buttonPanel.add(buttonAdd, gbcButton);

        gbcButton.gridy = 1;
        JButton buttonDelete = new JButton("Delete");
        buttonPanel.add(buttonDelete, gbcButton);

        gbcButton.gridy = 2;
        JButton buttonEdit = new JButton("Edit");
        buttonPanel.add(buttonEdit, gbcButton);


        // Membuat JTable dengan model tabel khusus untuk mengatur format tanggal
        JTable table = new JTable(data, columnNames);
        table.getColumnModel().getColumn(4).setCellRenderer(new DateRenderer());

        JScrollPane scrollPane = new JScrollPane(table); // Tambahkan JTable ke JScrollPane
        scrollPane.setPreferredSize(new Dimension(400, 200)); // Atur ukuran sesuai kebutuhan
        tablePanel.add(scrollPane, BorderLayout.CENTER);

        panelFilter.add(tablePanel, BorderLayout.CENTER);
    }

    public JPanel getPanelFilter() {
        return panelFilter;
    }

    // Custom TableCellRenderer untuk menampilkan format tanggal yang benar
    private class DateRenderer extends DefaultTableCellRenderer {
        public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
            if (value instanceof String) {
                value = ((String) value).replace("-", "/");
            }
            return super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
        }
    }
}

