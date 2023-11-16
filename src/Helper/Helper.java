package Helper;

import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;

import javax.swing.*;

public class Helper {

    public static void showMsg(String str){
        String msg;

        switch (str){
            case "fill":
                msg = "Lütfen tüm alanlari doldurunuz.";
                break;
            default:
                msg = str;
        }
        Alert dialog = new Alert(Alert.AlertType.INFORMATION,msg, ButtonType.OK);
        dialog.setHeaderText("Mesaj");
        dialog.showAndWait();
    }
}
