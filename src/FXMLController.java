import Helper.*;
import Model.Bashekim;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
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
    private Button btn_exit;

    public Label getUsersTitle() {
        return usersTitle;
    }

    @FXML
    private Label usersTitle;



    @FXML
    void handleLoginButton(ActionEvent event) {
        doctorLogin();
    }
    @FXML
    void exitButon(ActionEvent event) throws IOException {
        exitButon();
    }

    private DBConnection conn = new DBConnection();

    public void exitButon() throws IOException {
        hospitalOtomGUI.changeScene("View/login.fxml",501,450,null);

    }

    public void doctorLogin() {
        if (tcDoktor.getText().length() == 0 || pwDoktor.getText().length() == 0) {
            Helper.showMsg("fill");
        } else {
            try {
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
                        hospitalOtomGUI.changeScene("View/bashekim.fxml", 750, 500,bashekim.getName());


                    }

                }
            } catch (SQLException | IOException e) {
                e.printStackTrace();
            }
        }

    }

}
