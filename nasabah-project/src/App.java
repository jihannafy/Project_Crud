import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.InputStreamReader;
import java.net.InetSocketAddress;
import java.sql.*;
import java.util.*;
import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpServer;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;


public class App {

    // Ini setup connection ke DB
    private static final String JDBC_URL = "jdbc:mysql://localhost:3306/db_nasabah?serverTimezone=UTC";
    private static final String USER = "root";
    private static final String PASSWORD = "";
    private static final String DRIVER_CLASS = "com.mysql.cj.jdbc.Driver";

    

    public static void main(String[] args) throws IOException {
        try {
            Class.forName(DRIVER_CLASS);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            System.exit(1);
}
        HttpServer server = HttpServer.create(new InetSocketAddress(8081), 0);
        server.createContext("/api/your-entities", new MyHandler());
        server.setExecutor(null); // creates a default executor
        server.start();
    }

    static class MyHandler implements HttpHandler {
        @Override
        public void handle(HttpExchange t) throws IOException {
            String method = t.getRequestMethod();
            String response = "";

            switch (method) {
                case "GET":
                    response = handleGetRequest();
                    break;
                case "POST":
                    try {
                        response = handlePostRequest(t);
                    } catch (JSONException | ParseException e) {
                        e.printStackTrace();
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                    break;
                case "PUT":
                    try{
                        response = handlePutRequest(t);
                    } catch (JSONException | ParseException e) {
                        e.printStackTrace();
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                    break;
                case "DELETE":
                    response = handleDeleteRequest(t);
                    break;
            }

        
            t.sendResponseHeaders(200, response.length());
            OutputStream os = t.getResponseBody();
            os.write(response.getBytes());
            os.close();
        }

        // Fungsi buat parse string to date
        private java.util.Date parseDate(String dateString) throws ParseException {
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            return dateFormat.parse(dateString);
        }

        // Fungsi buat storing ke table mst_cif
        private boolean storeInfoCif(
            String noCif, 
            String cabang, 
            String accOfficer, 
            String namaLengkap, 
            String namaSingkat,
            String namaAlias, 
            String namaIbu, 
            String jenisKelamin, 
            String tempatLahir, 
            Date tanggalLahir, 
            Date tanggalPembukuan 
        ){
            try (Connection connection = DriverManager.getConnection(JDBC_URL, USER, PASSWORD)) {
                String query = "INSERT INTO mst_cif (no_cif, cabang, account_officer, nama_lengkap, nama_singkat, nama_alias, nama_ibu, jenis_kelamin, tempat_lahir, tgl_lahir, tgl_pembukuan) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
                try (PreparedStatement statement = connection.prepareStatement(query)) {
                    statement.setString(1, noCif);
                    statement.setString(2, cabang);
                    statement.setString(3, accOfficer);
                    statement.setString(4, namaLengkap);
                    statement.setString(5, namaSingkat);
                    statement.setString(6, namaAlias);
                    statement.setString(7, namaIbu);
                    statement.setString(8, jenisKelamin);
                    statement.setString(9, tempatLahir);
                    statement.setDate(10, new java.sql.Date(tanggalLahir.getTime()));
                    statement.setDate(11, new java.sql.Date(tanggalPembukuan.getTime()));
                    
                    
                    int rowsAffected = statement.executeUpdate();
                    return rowsAffected > 0;
                }
            } catch (Exception e) {
                e.printStackTrace();
                return false;
            }
        }

        // Fungsi buat store data ke table mst_cifpersnl
        private boolean storeInfoIdentitias(
            String jenisIdentitas,
            String noIdentitas,
            String alamat,
            Integer rt,
            String kelurahan,
            String provinsi,
            String negara,
            String noNPWP,
            String noHp,
            Integer masaBerlaku,
            String kodePos,
            String kecamatan,
            String kabupatenKota,
            String keterangan,
            Integer rw
        ){
            try (Connection connection = DriverManager.getConnection(JDBC_URL, USER, PASSWORD)) {
                String query = "INSERT INTO mst_cifpersnl (jenis_identitas, no_identitas, alamat, rt, kelurahan, provinsi, negara, no_npwp, no_hp, masa_berlaku, kode_pos, kecamatan, kabupaten_kota, keterangan, rw) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
                try (PreparedStatement statement = connection.prepareStatement(query)) {
                    statement.setString(1, jenisIdentitas);
                    statement.setString(2, noIdentitas);
                    statement.setString(3, alamat);
                    statement.setInt(4, rt);
                    statement.setString(5, kelurahan);
                    statement.setString(6, provinsi);
                    statement.setString(7, negara);
                    statement.setString(8, noNPWP);
                    statement.setString(9, noHp);
                    statement.setInt(10, masaBerlaku);
                    statement.setString(11, kodePos);
                    statement.setString(12, kecamatan);
                    statement.setString(13, kabupatenKota);
                    statement.setString(14, keterangan);
                    statement.setInt(15, rw);

                    
                    int rowsAffected = statement.executeUpdate();
                    return rowsAffected > 0;
                }
            } catch (Exception e) {
                e.printStackTrace();
                return false;
            }
        }

        private boolean updateInfoCIF(
                String noCif,
                String cabang,
                String accOfficer,
                String namaLengkap,
                String namaSingkat,
                String namaAlias,
                String namaIbu,
                String jenisKelamin,
                String tempatLahir,
                Date tanggalLahir,
                Date tanggalPembukuan) {
            try (Connection connection = DriverManager.getConnection(JDBC_URL, USER, PASSWORD)) {
                String query = "UPDATE mst_cif SET cabang=?, account_officer=?, nama_lengkap=?, nama_singkat=?, nama_alias=?, nama_ibu=?, jenis_kelamin=?, tempat_lahir=?, tgl_lahir=?, tgl_pembukuan=? WHERE no_cif=?";
                try (PreparedStatement statement = connection.prepareStatement(query)) {
                    statement.setString(1, cabang);
                    statement.setString(2, accOfficer);
                    statement.setString(3, namaLengkap);
                    statement.setString(4, namaSingkat);
                    statement.setString(5, namaAlias);
                    statement.setString(6, namaIbu);
                    statement.setString(7, jenisKelamin);
                    statement.setString(8, tempatLahir);
                    statement.setDate(9, new java.sql.Date(tanggalLahir.getTime()));
                    statement.setDate(10, new java.sql.Date(tanggalPembukuan.getTime()));
                    statement.setString(11, noCif);

                    int rowsAffected = statement.executeUpdate();
                    return rowsAffected > 0;
                }
            } catch (Exception e) {
                e.printStackTrace();
                return false;
            }
        }

        private boolean updateInfoIdentitias(
                String jenisIdentitas,
                String noIdentitas,
                String alamat,
                Integer rt,
                String kelurahan,
                String provinsi,
                String negara,
                String noNPWP,
                String noHp,
                Integer masaBerlaku,
                String kodePos,
                String kecamatan,
                String kabupatenKota,
                String keterangan,
                Integer rw) {
            try (Connection connection = DriverManager.getConnection(JDBC_URL, USER, PASSWORD)) {
                String query = "UPDATE mst_cifpersnl SET jenis_identitas=?, alamat=?, rt=?, kelurahan=?, provinsi=?, negara=?, no_npwp=?, no_hp=?, masa_berlaku=?, kode_pos=?, kecamatan=?, kabupaten_kota=?, keterangan=?, rw=? WHERE no_identitas=?";
                try (PreparedStatement statement = connection.prepareStatement(query)) {
                    statement.setString(1, jenisIdentitas);
                    statement.setString(2, alamat);
                    statement.setInt(3, rt);
                    statement.setString(4, kelurahan);
                    statement.setString(5, provinsi);
                    statement.setString(6, negara);
                    statement.setString(7, noNPWP);
                    statement.setString(8, noHp);
                    statement.setInt(9, masaBerlaku);
                    statement.setString(10, kodePos);
                    statement.setString(11, kecamatan);
                    statement.setString(12, kabupatenKota);
                    statement.setString(13, keterangan);
                    statement.setInt(14, rw);
                    statement.setString(15, noIdentitas);

                    int rowsAffected = statement.executeUpdate();
                    return rowsAffected > 0;
                }
            } catch (Exception e) {
                e.printStackTrace();
                return false;
            }
        }

        private boolean deleteDataByid(String no_cif, String no_identitas) {
            try (Connection connection = DriverManager.getConnection(JDBC_URL, USER, PASSWORD)) {
                String queryCIF = "DELETE FROM mst_cif WHERE no_cif = ?";
                String queryCIFPersnl = "DELETE FROM mst_cifpersnl WHERE no_identitas = ?";

                try (PreparedStatement statementCIF = connection.prepareStatement(queryCIF);
                        PreparedStatement statementCIFPersnl = connection.prepareStatement(queryCIFPersnl)) {

                    statementCIF.setString(1, no_cif);
                    statementCIFPersnl.setString(1, no_identitas);

                    int rowsAffectedCIF = statementCIF.executeUpdate();
                    int rowsAffectedCIFPersnl = statementCIFPersnl.executeUpdate();

                    return rowsAffectedCIF > 0 && rowsAffectedCIFPersnl > 0;
                }
            } catch (SQLException e) {
                e.printStackTrace();
                return false;
            }
        }

        private String handleGetRequest() {
            try (Connection connection = DriverManager.getConnection(JDBC_URL, USER, PASSWORD)) {
                String query = "SELECT * FROM mst_cif";
                try (PreparedStatement statement = connection.prepareStatement(query);
                     ResultSet resultSet = statement.executeQuery()) {

                    // StringBuilder resultBuilder = new StringBuilder();
                    JSONArray jsonArray = new JSONArray();
                    while (resultSet.next()) {
                        String namaLengkap = resultSet.getString("nama_lengkap");
                        String noCif = resultSet.getString("no_cif");
                        String accountOfficer = resultSet.getString("account_officer");
                        java.sql.Date tanggalPembukuan = resultSet.getDate("tgl_pembukuan");
                        String jenisKelamin = resultSet.getString("jenis_kelamin");
                        
                        JSONObject jsonObject = new JSONObject();

                        
                        jsonObject.put("nama_lengkap", namaLengkap);
                        jsonObject.put("no_cif", noCif);
                        jsonObject.put("account_officer", accountOfficer);
                        jsonObject.put("tgl_pembukuan", tanggalPembukuan);
                        jsonObject.put("jenis_kelamin", jenisKelamin);

                        jsonArray.put(jsonObject);
                        
                    }

                    return jsonArray.toString();
                }
            } catch (SQLException e) {
                e.printStackTrace();
                return "Error reading data from the database.";
            }
        }

        public String handlePostRequest(HttpExchange t) throws IOException, JSONException, ParseException, SQLException {
            InputStream requestBody = t.getRequestBody();
            BufferedReader reader = new BufferedReader(new InputStreamReader(requestBody));
            StringBuilder requestBodyBuilder = new StringBuilder();
            String line;
            while ((line = reader.readLine()) != null) {
                requestBodyBuilder.append(line);
            }

            JSONObject jsonInput = new JSONObject(requestBodyBuilder.toString());

            // Object mapping for table mst_cif
            String noCif = jsonInput.getString("noCif");
            String cabang = jsonInput.getString("cabang");
            String accountOfficer = jsonInput.getString("accountOfficer");
            String namaLengkap = jsonInput.getString("namaLengkap");
            String namaSingkat = jsonInput.getString("namaSingkat");
            String namaAlias = jsonInput.getString("namaAlias");
            String namaIbu = jsonInput.getString("namaIbu");
            String jenisKelamin = jsonInput.getString("jenisKelamin");
            String tempatLahir = jsonInput.getString("tempatLahir");
            java.util.Date tanggalLahir = parseDate(jsonInput.getString("tanggalLahir"));
            java.util.Date tanggalPembukuan = parseDate(jsonInput.getString("tanggalPembukuan"));

            // Object mapping for table mst_cifpersnl
            String jenisIdentitas = jsonInput.getString("jenisIdentitas");
            String noIdentitas = jsonInput.getString("noIdentitas");
            String alamat = jsonInput.getString("alamat");
            Integer rt = jsonInput.getInt("rt");
            String kelurahan = jsonInput.getString("kelurahan");
            String provinsi = jsonInput.getString("provinsi");
            String negara = jsonInput.getString("negara");
            String noNPWP = jsonInput.getString("noNPWP");
            String noHp = jsonInput.getString("noHp");
            Integer masaBerlaku = jsonInput.getInt("masaBerlaku");
            String kodePos = jsonInput.getString("kodePos");
            String kecamatan = jsonInput.getString("kecamatan");
            String kabupatenKota = jsonInput.getString("kabupatenKota");
            String keterangan = jsonInput.getString("keterangan");
            Integer rw = jsonInput.getInt("rw");

            if (storeInfoCif(noCif, cabang, accountOfficer, namaLengkap, namaSingkat, namaAlias, namaIbu, jenisKelamin, tempatLahir, tanggalLahir, tanggalPembukuan) && 
            storeInfoIdentitias(jenisIdentitas, noIdentitas, alamat, rt, kelurahan, provinsi, negara, noNPWP, noHp, masaBerlaku, kodePos, kecamatan, kabupatenKota, keterangan, rw)){
                return new JSONObject().put("message", "Data stored successfully").toString();
            } else {
                return new JSONObject().put("message", "Failed to store data").toString();
            }
        }

private String handlePutRequest(HttpExchange t) throws IOException, JSONException, ParseException, SQLException {
    InputStream requestBody = t.getRequestBody();
    BufferedReader reader = new BufferedReader(new InputStreamReader(requestBody));
    StringBuilder requestBodyBuilder = new StringBuilder();
    String line;
    while ((line = reader.readLine()) != null) {
        requestBodyBuilder.append(line);
    }
    JSONObject jsonInput = new JSONObject(requestBodyBuilder.toString());

    // Object mapping for table mst_cif
    String noCif = jsonInput.getString("noCif");
    String cabang = jsonInput.getString("cabang");
    String accountOfficer = jsonInput.getString("accountOfficer");
    String namaLengkap = jsonInput.getString("namaLengkap");
    String namaSingkat = jsonInput.getString("namaSingkat");
    String namaAlias = jsonInput.getString("namaAlias");
    String namaIbu = jsonInput.getString("namaIbu");
    String jenisKelamin = jsonInput.getString("jenisKelamin");
    String tempatLahir = jsonInput.getString("tempatLahir");
    java.util.Date tanggalLahir = parseDate(jsonInput.getString("tanggalLahir"));
    java.util.Date tanggalPembukuan = parseDate(jsonInput.getString("tanggalPembukuan"));

    // Object mapping for table mst_cifpersnl
    String jenisIdentitas = jsonInput.getString("jenisIdentitas");
    String noIdentitas = jsonInput.getString("noIdentitas");
    String alamat = jsonInput.getString("alamat");
    Integer rt = jsonInput.getInt("rt");
    String kelurahan = jsonInput.getString("kelurahan");
    String provinsi = jsonInput.getString("provinsi");
    String negara = jsonInput.getString("negara");
    String noNPWP = jsonInput.getString("noNPWP");
    String noHp = jsonInput.getString("noHp");
    Integer masaBerlaku = jsonInput.getInt("masaBerlaku");
    String kodePos = jsonInput.getString("kodePos");
    String kecamatan = jsonInput.getString("kecamatan");
    String kabupatenKota = jsonInput.getString("kabupatenKota");
    String keterangan = jsonInput.getString("keterangan");
    Integer rw = jsonInput.getInt("rw");

    if (updateInfoCIF(noCif, cabang, accountOfficer, namaLengkap, namaSingkat, namaAlias, namaIbu, jenisKelamin, tempatLahir, tanggalLahir, tanggalPembukuan) &&
        updateInfoIdentitias(jenisIdentitas, noIdentitas, alamat, rt, kelurahan, provinsi, negara, noNPWP, noHp, masaBerlaku, kodePos, kecamatan, kabupatenKota, keterangan, rw)) {
        return new JSONObject().put("message", "Data updated successfully").toString();
    } else {
        return new JSONObject().put("message", "Failed to update data").toString();
    }        
}

public String handleDeleteRequest(HttpExchange t) {
    try {
        String path = t.getRequestURI().getPath();
        String[] pathParts = path.split("/");
        String no_cif = pathParts[pathParts.length - 2]; 
        String no_identitas = pathParts[pathParts.length - 1];

        boolean deleted = deleteDataByid(no_cif, no_identitas); 

        if (deleted) {
            return new JSONObject().put("message", "Data deleted successfully").toString();
        } else {
            return new JSONObject().put("message", "Failed to delete data").toString();
        }
    } catch (Exception e) {
        e.printStackTrace();
        return new JSONObject().put("message", "Error while processing the request").toString();
    }
}

        // private String handleDeleteRequest(HttpExchange t) {
        //     return "Handling DELETE request";
        // }
    }
}
