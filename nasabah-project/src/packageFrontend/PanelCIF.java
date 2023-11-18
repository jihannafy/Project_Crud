package packageFrontend;


import javax.swing.*;

import org.json.JSONObject;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class PanelCIF {

     private JPanel panelCIF;
    // private JTextField fieldNoCIF;
    // private JComboBox<String> comboBoxCabang;
    // private JComboBox<String> comboBoxOfficer;
    // private JTextField fieldTglPembukuan;
    // private JTextField fieldNamaLengkap;
    // private JTextField fieldNamaSingkat;
    // private JTextField fieldNamaAlias;
    // private JTextField fieldNamaIbu;
    // private JTextField fieldTempatLahir;
    // private JTextField fieldTanggalLahir;
    // private JRadioButton radioPerempuan;
    // private JRadioButton radioLakiLaki;
    // private ButtonGroup buttonGroup;


    public PanelCIF() {
        panelCIF = new JPanel();
        panelCIF.setLayout(new GridBagLayout());
        panelCIF.setBorder(BorderFactory.createTitledBorder("Info CIF Perorangan"));

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.WEST;

        //no CUF
        panelCIF.add(new JLabel("No CIF: "), gbc);

        gbc.gridx = 1;
        gbc.gridy = 0;
        gbc.gridwidth = 3;
        JTextField fieldNoCIF = new JTextField(20);
        fieldNoCIF.setEnabled(false); // Nonaktifkan field
        panelCIF.add(fieldNoCIF, gbc);

        gbc.gridx = 7;
        gbc.gridy = 0;
        gbc.gridwidth = 1;
        panelCIF.add(new JLabel("Tanggal Pembukuan: "), gbc);

        gbc.gridx = 8;
        gbc.gridy = 0;
        JTextField fieldTglPembukuan = new JTextField(20);
        fieldTglPembukuan.setEnabled(false); // Nonaktifkan field
        panelCIF.add(fieldTglPembukuan, gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.gridwidth = 1;
        panelCIF.add(new JLabel("Cabang: "), gbc);

        gbc.gridx = 1;
        gbc.gridy = 1;
        gbc.gridwidth = 3;
        String[] cabangOptions = {"Cabang Antapani"};
        JComboBox<String> comboBoxCabang = new JComboBox<>(cabangOptions);
        comboBoxCabang.setEnabled(false); // Nonaktifkan JComboBox
        panelCIF.add(comboBoxCabang, gbc);


        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.gridwidth = 1;
        panelCIF.add(new JLabel("Account Officer: "), gbc);

        gbc.gridx = 1;
        gbc.gridy = 2;
        gbc.gridwidth = 3;
        String[] officerOptions = {"Officer A", "Officer B", "Officer C"};
        JComboBox<String> comboBoxOfficer = new JComboBox<>(officerOptions);
        comboBoxOfficer.setEnabled(true); // Nonaktifkan JComboBox
        panelCIF.add(comboBoxOfficer, gbc);

        gbc.gridx = 0;
        gbc.gridy = 4;
        panelCIF.add(new JLabel("Nama Lengkap: "), gbc);

        gbc.gridx = 1;
        gbc.gridy = 4;
        gbc.gridwidth = 3;
        JTextField fieldNamaLengkap = new JTextField(20);
        fieldNamaLengkap.setEnabled(true);
        panelCIF.add(fieldNamaLengkap, gbc);

        gbc.gridx = 0;
        gbc.gridy = 5;
        gbc.gridwidth = 1;
        panelCIF.add(new JLabel("Nama Singkat: "), gbc);

        gbc.gridx = 1;
        gbc.gridy = 5;
        JTextField fieldNamaSingkat = new JTextField(20);
        fieldNamaSingkat.setEnabled(true);
        panelCIF.add(fieldNamaSingkat, gbc);

        gbc.gridx = 0;
        gbc.gridy = 6;
        panelCIF.add(new JLabel("Nama Alias: "), gbc);
        

        gbc.gridx = 1;
        gbc.gridy = 6;
        JTextField fieldNamaAlias = new JTextField(20);
        fieldNamaAlias.setEnabled(true);
        panelCIF.add(fieldNamaAlias, gbc);

        gbc.gridx = 0;
        gbc.gridy = 7;
        panelCIF.add(new JLabel("Nama Gadis Kandung: "), gbc);

        gbc.gridx = 1;
        gbc.gridy = 7;
        JTextField fieldNamaIbu = new JTextField(20);
        fieldNamaIbu.setEnabled(true);
        panelCIF.add(fieldNamaIbu, gbc);

        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.gridwidth = 4;
        panelCIF.add(new JLabel("Jenis Kelamin: "), gbc);

        gbc.gridx = 1;
        gbc.gridy = 3;
        gbc.gridwidth = 3;
        JRadioButton radioPerempuan = new JRadioButton("Perempuan");
        JRadioButton radioLakiLaki = new JRadioButton("Laki-laki");
        ButtonGroup buttonGroup = new ButtonGroup();
        buttonGroup.add(radioPerempuan);
        buttonGroup.add(radioLakiLaki);
        JPanel panelRadio = new JPanel();
        panelRadio.add(radioPerempuan);
        panelRadio.add(radioLakiLaki);
        panelCIF.add(panelRadio, gbc);

        gbc.gridx = 0;
        gbc.gridy = 9;
        panelCIF.add(new JLabel("Tempat, Tanggal Lahir: "), gbc);
        gbc.gridx = 1;
        gbc.gridy = 9;
        panelCIF.add(new JTextField(20), gbc);
        JTextField fieldTempatLahir = new JTextField(20);
        fieldTempatLahir.setEnabled(true);
        panelCIF.add(fieldTempatLahir, gbc);

        gbc.gridx = 3;
        gbc.gridy = 9;
        panelCIF.add(new JTextField(20), gbc);
        JTextField fieldTanggalLahir = new JTextField(20);
        fieldTanggalLahir.setEnabled(true);
        panelCIF.add(fieldTanggalLahir, gbc);



//tombol cektak simpan reset
        gbc.gridx = 18;
        gbc.gridy = 0;
        gbc.gridwidth = 1;
        JButton buttonSimpan = new JButton("Simpan");
        // buttonSimpan.addActionListener(new ActionListener() {
        //     @Override
        //     public void actionPerformed(ActionEvent e) {
        //         JSONObject jsonObject = prepareData();
        //         sendData(jsonObject);

        //         DataNasabah dataNasabah =ambilDataNasabah();
        //         simpanDataNasabah(dataNasabah);

        //     }
        // });
        panelCIF.add(buttonSimpan, gbc);

        gbc.gridx = 18;
        gbc.gridy = 1;
        gbc.gridwidth = 1;
        JButton buttonCetak = new JButton("Cetak");
        panelCIF.add(buttonCetak, gbc);

        gbc.gridx = 18;
        gbc.gridy = 2;
        gbc.gridwidth = 1;
        JButton buttonReset = new JButton("Reset");
        panelCIF.add(buttonReset, gbc);
    }

    // private JSONObject prepareData() {

    //     JSONObject jsonObject = new JSONObject();
    //     JTextField fieldNoCIF = (JTextField) panelCIF.getComponent(JTextField.fieldNoCIF); // Ganti dengan field yang sesuai
    //     jsonObject.put("cabang", comboBoxCabang.getSelectedItem().toString()); // Ganti dengan field yang sesuai
    //     jsonObject.put("accountOfficer", comboBoxOfficer.getSelectedItem().toString());
    // }

    public JPanel getPanelCIF() {
        return panelCIF;
    }
}