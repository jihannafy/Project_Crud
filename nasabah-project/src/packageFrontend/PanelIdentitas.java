package packageFrontend;

import javax.swing.*;
import java.awt.*;

public class PanelIdentitas {

    private JPanel panelidentitas;

    public PanelIdentitas() {

        panelidentitas = new JPanel();
        panelidentitas.setLayout(new GridBagLayout());
        panelidentitas.setBorder(BorderFactory.createTitledBorder("Info Identitas"));

        GridBagConstraints gbcIdentitas = new GridBagConstraints();
        gbcIdentitas.gridx = 0;
        gbcIdentitas.gridy = 0;
        gbcIdentitas.anchor = GridBagConstraints.WEST;

        // Jenis Identitas
        panelidentitas.add(new JLabel("Jenis Identitas: "), gbcIdentitas);

        gbcIdentitas.gridx = 1;
        gbcIdentitas.gridy = 0;
        gbcIdentitas.gridwidth = 3;
        String[] jenisIdentitas = {"KTP", "SIM", "Passport"}; // Ganti dengan pilihan Anda
        JComboBox<String> comboBoxJenisIdentitas = new JComboBox<>(jenisIdentitas);
        panelidentitas.add(comboBoxJenisIdentitas, gbcIdentitas);

        // Masa Berlaku
        gbcIdentitas.gridx = 7;
        gbcIdentitas.gridy = 0;
        gbcIdentitas.gridwidth = 1;
        panelidentitas.add(new JLabel("Masa Berlaku: "), gbcIdentitas);

        gbcIdentitas.gridx = 8;
        gbcIdentitas.gridy = 0;
        JTextField fieldMasaBerlaku = new JTextField(15);
        panelidentitas.add(fieldMasaBerlaku, gbcIdentitas);

        // No Identitas
        gbcIdentitas.gridx = 0;
        gbcIdentitas.gridy = 1;
        gbcIdentitas.gridwidth = 1;
        panelidentitas.add(new JLabel("No Identitas: "), gbcIdentitas);

        gbcIdentitas.gridx = 1;
        gbcIdentitas.gridy = 1;
        gbcIdentitas.gridwidth = 5;
        JTextField fieldNoIdentitas = new JTextField(20);
        panelidentitas.add(fieldNoIdentitas, gbcIdentitas);

        // Alamat
        gbcIdentitas.gridx = 0;
        gbcIdentitas.gridy = 2;
        gbcIdentitas.gridwidth = 1;
        panelidentitas.add(new JLabel("Alamat: "), gbcIdentitas);

        gbcIdentitas.gridx = 1;
        gbcIdentitas.gridy = 2;
        gbcIdentitas.gridwidth = 5;
        JTextArea areaAlamat = new JTextArea(3, 20);
        JScrollPane scrollPaneAlamat = new JScrollPane(areaAlamat);
        panelidentitas.add(scrollPaneAlamat, gbcIdentitas);

        // RT/RW & Kode Pos
        gbcIdentitas.gridx = 0;
        gbcIdentitas.gridy = 3;
        gbcIdentitas.gridwidth = 1;
        panelidentitas.add(new JLabel("RT / RW: "), gbcIdentitas);

        gbcIdentitas.gridx = 1;
        gbcIdentitas.gridy = 3;
        JTextField fieldRTRW = new JTextField(5);
        panelidentitas.add(fieldRTRW, gbcIdentitas);

        gbcIdentitas.gridx = 2;
        gbcIdentitas.gridy = 3;
        panelidentitas.add(new JLabel("/"), gbcIdentitas);

        gbcIdentitas.gridx = 3;
        gbcIdentitas.gridy = 3;
        JTextField fieldRW = new JTextField(5);
        panelidentitas.add(fieldRW, gbcIdentitas);

        gbcIdentitas.gridx = 7;
        gbcIdentitas.gridy = 3;
        panelidentitas.add(new JLabel("Kode Pos: "), gbcIdentitas);

        gbcIdentitas.gridx = 8;
        gbcIdentitas.gridy = 3;
        JTextField fieldKodePos = new JTextField(8);
        panelidentitas.add(fieldKodePos, gbcIdentitas);

        // Kelurahan & Kecamatan
        gbcIdentitas.gridx = 0;
        gbcIdentitas.gridy = 4;
        panelidentitas.add(new JLabel("Kelurahan: "), gbcIdentitas);

        gbcIdentitas.gridx = 1;
        gbcIdentitas.gridy = 4;
        JTextField fieldKelurahan = new JTextField(20);
        panelidentitas.add(fieldKelurahan, gbcIdentitas);

        gbcIdentitas.gridx = 7;
        gbcIdentitas.gridy = 4;
        panelidentitas.add(new JLabel("Kecamatan: "), gbcIdentitas);

        gbcIdentitas.gridx = 8;
        gbcIdentitas.gridy = 4;
        JTextField fieldKecamatan = new JTextField(20);
        panelidentitas.add(fieldKecamatan, gbcIdentitas);

        // Provinsi & Kabupaten/Kota
        gbcIdentitas.gridx = 0;
        gbcIdentitas.gridy = 5;
        panelidentitas.add(new JLabel("Provinsi: "), gbcIdentitas);

        gbcIdentitas.gridx = 1;
        gbcIdentitas.gridy = 5;
        String[] provinsi = {"Provinsi 1", "Provinsi 2", "Provinsi 3"}; // Ganti dengan pilihan Anda
        JComboBox<String> comboBoxProvinsi = new JComboBox<>(provinsi);
        panelidentitas.add(comboBoxProvinsi, gbcIdentitas);

        gbcIdentitas.gridx = 7;
        gbcIdentitas.gridy = 5;
        panelidentitas.add(new JLabel("Kabupaten/Kota: "), gbcIdentitas);

        gbcIdentitas.gridx = 8;
        gbcIdentitas.gridy = 5;
        String[] kabupatenKota = {"Kabupaten/Kota 1", "Kabupaten/Kota 2", "Kabupaten/Kota 3"}; // Ganti dengan pilihan Anda
        JComboBox<String> comboBoxKabupatenKota = new JComboBox<>(kabupatenKota);
        panelidentitas.add(comboBoxKabupatenKota, gbcIdentitas);

        // Negara
        gbcIdentitas.gridx = 0;
        gbcIdentitas.gridy = 6;
        panelidentitas.add(new JLabel("Negara: "), gbcIdentitas);

        gbcIdentitas.gridx = 1;
        gbcIdentitas.gridy = 6;
        String[] negara = {"Negara 1", "Negara 2", "Negara 3"}; // Ganti dengan pilihan Anda
        JComboBox<String> comboBoxNegara = new JComboBox<>(negara);
        panelidentitas.add(comboBoxNegara, gbcIdentitas);

        // No NPWP
        gbcIdentitas.gridx = 0;
        gbcIdentitas.gridy = 7;
        gbcIdentitas.gridwidth = 1;
        panelidentitas.add(new JLabel("No NPWP: "), gbcIdentitas);

        gbcIdentitas.gridx = 1;
        gbcIdentitas.gridy = 7;
        gbcIdentitas.gridwidth = 5;
        JTextField fieldNoNPWP = new JTextField(20);
        panelidentitas.add(fieldNoNPWP, gbcIdentitas);

        //Keterangan
        gbcIdentitas.gridx = 7;
        gbcIdentitas.gridy = 7;
        gbcIdentitas.gridwidth = 1;
        panelidentitas.add(new JLabel("Keterangan: "), gbcIdentitas);

        gbcIdentitas.gridx = 8;
        gbcIdentitas.gridy = 7;
        JTextField fieldKeterangan = new JTextField(15);
        panelidentitas.add(fieldKeterangan, gbcIdentitas);

        // No HP
        gbcIdentitas.gridx = 0;
        gbcIdentitas.gridy = 8;
        gbcIdentitas.gridwidth = 1;
        panelidentitas.add(new JLabel("No HP: "), gbcIdentitas);

        gbcIdentitas.gridx = 1;
        gbcIdentitas.gridy = 8;
        gbcIdentitas.gridwidth = 5;
        JTextField fieldNoHP = new JTextField(20);
        panelidentitas.add(fieldNoHP, gbcIdentitas);
    }

    // No hp


    public JPanel getPanelidentitas() {
        return panelidentitas;
    }
}

