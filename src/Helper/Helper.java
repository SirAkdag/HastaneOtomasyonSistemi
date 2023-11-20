package Helper;

import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;

import java.util.Optional;

public class Helper {

    public static void showMsg(String str){
        String msg;

        switch (str){
            case "fill":
                msg = "Lütfen tüm alanlari doldurunuz.";
                break;
            case "success":
                msg = "Kisi eklemesi basarili.";
                break;
            default:
                msg = str;
        }
        Alert dialog = new Alert(Alert.AlertType.INFORMATION,msg, ButtonType.OK);
        dialog.setHeaderText("Mesaj");
        dialog.showAndWait();
    }
    public static boolean confirm(String str){
        String msg;
        switch (str){
            case "sure":
                msg = "Bu islemi gerceklestirmek istiyor musunuz ?";
                break;
            default:
                msg = str;
                break;
        }
        Alert dialog = new Alert(Alert.AlertType.CONFIRMATION,msg,ButtonType.YES,ButtonType.NO);
        dialog.setTitle("Dikkat");
        Optional<ButtonType> result = dialog.showAndWait();
        return result.isPresent() & result.get() == ButtonType.YES;
    }
}
