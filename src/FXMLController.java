import Helper.*;
import Model.Bashekim;
import Model.Doktor;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;



public class FXMLController {

    @FXML
    private Button btn_doktor;

    @FXML
    private Button btn_hasta;

    @FXML
    private Button btn_register;

    @FXML
    private ImageView loginLogo;

    @FXML
    private PasswordField pwDoktor;

    @FXML
    private PasswordField pwHasta;

    @FXML
    private TextField tcDoktor;

    @FXML
    private TextField tcNoHasta;

    @FXML
    private TextField ekleAdSoyad;


    @FXML
    private PasswordField ekleSifre;

    @FXML
    private TextField ekleTcNo;

    @FXML
    void silmeIslemi(ActionEvent event) throws SQLException {
        silmeIslemi();
        doktorList();


    }


    @FXML
    void ekleIslemi(ActionEvent event) throws SQLException {
        if (tcNoCheck()) {
            ekleIslemi();
            doktorList();
        }
    }


    @FXML
    private TextField silKullaniciID;


    @FXML
    private TableView<Doktor> doktorTableView;

    @FXML
    private TableColumn<Doktor, Integer> idColumn;

    @FXML
    private TableColumn<Doktor, String> nameColumn;

    @FXML
    private TableColumn<Doktor, String> pwColumn;

    @FXML
    private TableColumn<Doktor, String> tcColumn;

    @FXML
    private Label usersTitle;

    public Label getUsersTitle() {
        return usersTitle;
    }

    @FXML
    void handleLoginButton(ActionEvent event) throws SQLException {
        doctorLogin();


    }

    @FXML
    void exitButon(ActionEvent event) throws IOException {
        exitButon();
    }


    public void exitButon() throws IOException {
        hospitalOtomGUI.loginScene();

    }

    private final DBConnection conn = new DBConnection();


    public void doctorLogin() {
        if (tcDoktor.getText().length() == 0 || pwDoktor.getText().length() == 0) {
            Helper.showMsg("fill");
        } else try {
            Connection con = conn.connDB();
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM users");

            while (rs.next()) {
                if (tcDoktor.getText().equals(rs.getString("tc_no")) & pwDoktor.getText().equals(rs.getString("password"))) {
                    Bashekim bashekim = new Bashekim();
                    bashekim.setId(rs.getInt("id"));
                    bashekim.setPassword(rs.getString("password"));
                    bashekim.setName(rs.getString("name"));
                    bashekim.setTc_no(rs.getString("tc_no"));
                    bashekim.setType(rs.getString("type"));

                    //Scene changing
                    hospitalOtomGUI.changeScene("View/bashekim.fxml", 750, 500, bashekim.getName());

                }
            }
        } catch (SQLException | IOException e) {
            e.printStackTrace();
        }

    }


    void doktorList() {
        try {
            Connection con = conn.connDB();
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM users WHERE type = 'doktor'");

            ObservableList<Doktor> fetchedDoktorList = FXCollections.observableArrayList();

            while (rs.next()) {
                Doktor doktor = new Doktor();
                doktor.setId(rs.getInt("id"));
                doktor.setPassword(rs.getString("password"));
                doktor.setName(rs.getString("name"));
                doktor.setTc_no(rs.getString("tc_no"));
                doktor.setType(rs.getString("type"));


                fetchedDoktorList.add(doktor);
            }


            // TableColumn'ları burada initialize et
            idColumn.setCellValueFactory(new PropertyValueFactory<>("id"));
            nameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
            pwColumn.setCellValueFactory(new PropertyValueFactory<>("password"));
            tcColumn.setCellValueFactory(new PropertyValueFactory<>("tc_no"));

            doktorTableView.setOnMouseClicked(event -> {
                Doktor selectedDoktor = doktorTableView.getSelectionModel().getSelectedItem();
                if (selectedDoktor != null) {
                    silKullaniciID.setText(String.valueOf(selectedDoktor.getId()));
                }
            });
            this.doktorTableView.setItems(fetchedDoktorList);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void silmeIslemi() throws SQLException {
        if (silKullaniciID.getText().length() == 0) {
            Helper.showMsg("Lütfen bir doktor seciniz.");
        } else {
            if (Helper.confirm("sure")) {
                boolean control = Bashekim.deleteDoktor(silKullaniciID.getText());
                if (control) {
                    silKullaniciID.setText(null);
                }
            }
        }
    }

    public void ekleIslemi() {
        if (ekleAdSoyad.getText().length() == 0 || ekleTcNo.getText().length() == 0 || ekleSifre.getText().length() == 0) {
            Helper.showMsg("fill");
        } else {
            boolean control = Bashekim.addDoktor(ekleTcNo.getText(), ekleSifre.getText(), ekleAdSoyad.getText());
            if (control) {
                Helper.showMsg("success");
                ekleTcNo.setText(null);
                ekleSifre.setText(null);
                ekleAdSoyad.setText(null);
            }
        }

    }

    public boolean tcNoCheck() throws SQLException {
        Connection con = conn.connDB();
        Statement st = con.createStatement();
        ResultSet rs = st.executeQuery("SELECT tc_no FROM users");

        while (rs.next()) {
            String existingTcNo = rs.getString("tc_no");
            if (ekleTcNo.getText().equals(existingTcNo)) {
                Helper.showMsg("check");
                ekleTcNo.setText(null);
                return false;
            }
        }
        return true;
    }


}











