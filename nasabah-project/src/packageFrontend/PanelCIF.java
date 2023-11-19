package packageFrontend;


import javax.swing.*;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import org.json.JSONObject;

import com.mysql.cj.x.protobuf.MysqlxNotice.Frame;

import java.net.URL;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import packageFrontend.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class PanelCIF {

    private JPanel panelCIF;
    private JTextField fieldNoCIF;
    private JComboBox<String> comboBoxCabang;
    private JComboBox<String> comboBoxOfficer;
    private JTextField fieldTglPembukuan;
    private JTextField fieldNamaLengkap;
    private JTextField fieldNamaSingkat;
    private JTextField fieldNamaAlias;
    private JTextField fieldNamaIbu;
    private JTextField fieldTempatLahir;
    private JTextField fieldTanggalLahir;
    private JRadioButton radioPerempuan;
    private JRadioButton radioLakiLaki;
    private ButtonGroup buttonGroup;

    private JTextField fieldNoIdentitas;
    private JTextField fieldAlamat;
    private JTextField fieldRT;
    private JTextField fieldRW;
    private JTextField fieldKodePos;
    private JTextField fieldKelurahan;
    private JTextField fieldKecamatan;
    private JComboBox<String> comboBoxProvinsi;
    private JTextField fieldKabupatenKota;
    private JComboBox<String> comboBoxNegara;
    private JTextField fieldNoNPWP;
    private JTextField fieldKeterangan;
    private JTextField fieldNoHP;
    private JTextField fieldMasaBerlaku;

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
        fieldNoCIF = new JTextField(20);
        fieldNoCIF.setEnabled(true); // Nonaktifkan field
        panelCIF.add(fieldNoCIF, gbc);

        gbc.gridx = 7;
        gbc.gridy = 0;
        gbc.gridwidth = 1;
        panelCIF.add(new JLabel("Tanggal Pembukuan: "), gbc);

        gbc.gridx = 8;
        gbc.gridy = 0;
        fieldTglPembukuan = new JTextField(20);
        fieldTglPembukuan.setEnabled(true); // Nonaktifkan field
        panelCIF.add(fieldTglPembukuan, gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.gridwidth = 1;
        panelCIF.add(new JLabel("Cabang: "), gbc);

        gbc.gridx = 1;
        gbc.gridy = 1;
        gbc.gridwidth = 3;
        String[] cabangOptions = {"Cabang Antapani"};
        comboBoxCabang = new JComboBox<>(cabangOptions);
        comboBoxCabang.setEnabled(true); // Nonaktifkan JComboBox
        panelCIF.add(comboBoxCabang, gbc);


        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.gridwidth = 1;
        panelCIF.add(new JLabel("Account Officer: "), gbc);

        gbc.gridx = 1;
        gbc.gridy = 2;
        gbc.gridwidth = 3;
        String[] officerOptions = {"Officer A", "Officer B", "Officer C"};
        comboBoxOfficer = new JComboBox<>(officerOptions);
        comboBoxOfficer.setEnabled(true); // Nonaktifkan JComboBox
        panelCIF.add(comboBoxOfficer, gbc);

        gbc.gridx = 0;
        gbc.gridy = 4;
        panelCIF.add(new JLabel("Nama Lengkap: "), gbc);

        gbc.gridx = 1;
        gbc.gridy = 4;
        gbc.gridwidth = 3;
        fieldNamaLengkap = new JTextField(20);
        fieldNamaLengkap.setEnabled(true);
        panelCIF.add(fieldNamaLengkap, gbc);

        gbc.gridx = 0;
        gbc.gridy = 5;
        gbc.gridwidth = 1;
        panelCIF.add(new JLabel("Nama Singkat: "), gbc);

        gbc.gridx = 1;
        gbc.gridy = 5;
        fieldNamaSingkat = new JTextField(20);
        fieldNamaSingkat.setEnabled(true);
        panelCIF.add(fieldNamaSingkat, gbc);

        gbc.gridx = 0;
        gbc.gridy = 6;
        panelCIF.add(new JLabel("Nama Alias: "), gbc);
        

        gbc.gridx = 1;
        gbc.gridy = 6;
        fieldNamaAlias = new JTextField(20);
        fieldNamaAlias.setEnabled(true);
        panelCIF.add(fieldNamaAlias, gbc);

        gbc.gridx = 0;
        gbc.gridy = 7;
        panelCIF.add(new JLabel("Nama Gadis Kandung: "), gbc);

        gbc.gridx = 1;
        gbc.gridy = 7;
        fieldNamaIbu = new JTextField(20);
        fieldNamaIbu.setEnabled(true);
        panelCIF.add(fieldNamaIbu, gbc);

        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.gridwidth = 4;
        panelCIF.add(new JLabel("Jenis Kelamin: "), gbc);

        gbc.gridx = 1;
        gbc.gridy = 3;
        gbc.gridwidth = 3;
        radioPerempuan = new JRadioButton("Perempuan");
        radioLakiLaki = new JRadioButton("Laki-laki");
        buttonGroup = new ButtonGroup();
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
        fieldTempatLahir = new JTextField(20);
        fieldTempatLahir.setEnabled(true);
        panelCIF.add(fieldTempatLahir, gbc);

        gbc.gridx = 3;
        gbc.gridy = 9;
        panelCIF.add(new JTextField(20), gbc);
        fieldTanggalLahir = new JTextField(20);
        fieldTanggalLahir.setEnabled(true);
        panelCIF.add(fieldTanggalLahir, gbc);



//tombol cektak simpan reset
        gbc.gridx = 18;
        gbc.gridy = 0;
        gbc.gridwidth = 1;
        JButton buttonSimpan = new JButton("Simpan");
        buttonSimpan.addActionListener(e -> {
            JSONObject dataToSend = prepareData(); // Fungsi untuk menyiapkan data dari komponen GUI

            // Kirim data ke backend
            sendDataToBackend(dataToSend);
        });
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

    private JSONObject prepareData() {
        JSONObject jsonObject = new JSONObject();
        // Ambil data dari komponen GUI dan masukkan ke dalam objek JSON
        jsonObject.put("noCif", fieldNoCIF.getText());
        jsonObject.put("cabang", comboBoxCabang.getSelectedItem().toString());
        jsonObject.put("accountOfficer", comboBoxOfficer.getSelectedItem().toString());
        jsonObject.put("tanggalPembukuan", fieldTglPembukuan.getText().toString());
        jsonObject.put("namaLengkap", fieldNamaLengkap.getText().toString());
        jsonObject.put("namaSingkat", fieldNamaSingkat.getText().toString());
        jsonObject.put("namaAlias", fieldNamaAlias.getText().toString());
        jsonObject.put("namaIbu", fieldNamaIbu.getText().toString());
        jsonObject.put("tempatLahir", fieldTempatLahir.getText().toString());
        jsonObject.put("tanggalLahir", fieldTanggalLahir.getText().toString());
        String jenisKelamin = "";
        if (buttonGroup.getSelection() != null) {
            if (radioPerempuan.isSelected()) {
                jenisKelamin = "Perempuan";
            } else if (radioLakiLaki.isSelected()) {
                jenisKelamin = "Laki-laki";
            }
        }
        jsonObject.put("jenis_kelamin", jenisKelamin);

        //dari panel identitas
        jsonObject.put("jenisIdentitas", fieldNoCIF.getText());
        jsonObject.put("noIdentitas", fieldNoIdentitas.getText().toString());
        jsonObject.put("alamat", fieldAlamat.getText().toString());
        jsonObject.put("rt", fieldRT.getText().toString());
        jsonObject.put("rw", fieldRW.getText().toString());
        jsonObject.put("kodePos", fieldKodePos.getText().toString());
        jsonObject.put("kelurahan", fieldKelurahan.getText().toString());
        jsonObject.put("kecamatan", fieldKecamatan.getText().toString());
        jsonObject.put("provinsi", comboBoxProvinsi.getSelectedItem().toString());
        jsonObject.put("negara", comboBoxNegara.getSelectedItem().toString());
        jsonObject.put("kabupatenKota", fieldKabupatenKota.getText().toString());
        jsonObject.put("noNPWP", fieldNoNPWP.getText().toString());
        jsonObject.put("keterangan", fieldKeterangan.getText().toString());
        jsonObject.put("noHp", fieldNoHP.getText().toString());
        jsonObject.put("masaBerlaku", fieldMasaBerlaku.getText().toString());
        

        return jsonObject;
    }

    private void sendDataToBackend(JSONObject data) {
        try {
            URL url = new URL("http://localhost:8081/api/your-entities");
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();

            conn.setRequestMethod("POST");
            conn.setRequestProperty("Content-Type", "application/json");
            conn.setDoOutput(true);

            OutputStream os = conn.getOutputStream();
            os.write(data.toString().getBytes());
            os.flush();

            if (conn.getResponseCode() != HttpURLConnection.HTTP_OK) {
                throw new RuntimeException("Failed : HTTP error code : " + conn.getResponseCode());
            }

            BufferedReader br = new BufferedReader(new InputStreamReader((conn.getInputStream())));

            String output;
            while ((output = br.readLine()) != null) {
                System.out.println(output);
            }

            conn.disconnect();
        } catch (Exception e){
            e.printStackTrace();
        }
    }


    public JPanel getPanelCIF() {
        return panelCIF;
    }
}