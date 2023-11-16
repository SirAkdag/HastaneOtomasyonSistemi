import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class hospitalOtomGUI extends Application {

    private static Stage primaryStage;
    private static FXMLController fxmlController;


    @Override
    public void start(Stage primaryStage) throws Exception {
        hospitalOtomGUI.primaryStage = primaryStage;
        Parent root = FXMLLoader.load(getClass().getResource("View/login.fxml"));
        Scene loginScene = new Scene(root, 501, 450);

        primaryStage.setTitle("Hastane Otomasyon Sistemi");
        primaryStage.setScene(loginScene);
        primaryStage.setResizable(false);
        primaryStage.show();
    }

    public static void changeScene(String fxml, double width, double height, String userName) throws IOException {
        FXMLLoader loader = new FXMLLoader(hospitalOtomGUI.class.getResource(fxml));
        Parent root = loader.load();

        // Get the controller instance
        FXMLController controller = loader.getController();

        // Update the scene with the new dimensions
        Scene newScene = new Scene(root, width, height);

        // Set the new scene
        primaryStage.setScene(newScene);

        // Access and update usersTitle through the controller
        controller.getUsersTitle().setText(userName);
    }

    public static void main(String[] args) {
        launch(args);
    }
}
