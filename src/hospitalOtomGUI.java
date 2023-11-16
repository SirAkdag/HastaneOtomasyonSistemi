import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class hospitalOtomGUI extends Application {

    private static Stage stg;

    @Override
    public void start(Stage primaryStage) throws Exception {
        stg = primaryStage;
        Parent root = FXMLLoader.load(getClass().getResource("View/login.fxml"));
        Scene loginScene = new Scene(root,501,450);

        primaryStage.setTitle("Hastane Otomasyon Sistemi");
        primaryStage.setScene(loginScene);
        primaryStage.setResizable(false);
        primaryStage.show();

    }
    public void changeScene(String fxml) throws IOException{
        Parent root = FXMLLoader.load(getClass().getResource(fxml));
        stg.getScene().setRoot(root);
    }


    public static void main(String[] args) {
        launch(args);
    }
}
