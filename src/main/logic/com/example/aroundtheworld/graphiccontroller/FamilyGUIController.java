package com.example.aroundtheworld.graphiccontroller;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;

public class FamilyGUIController {

    public void toFamilyProfile() throws IOException {
        Stage stage = Main.getStage();
        FXMLLoader fxmlLoader = new FXMLLoader();
        fxmlLoader.setLocation(Main.class.getResource("profileFamily.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        FamilyProfileGUIController familyProfileGUIController = fxmlLoader.getController();
        familyProfileGUIController.initializeProfile();
        stage.setScene(scene);
        stage.show();
    }
    public void toRequestFamily() throws IOException {
        Stage stage = Main.getStage();
        FXMLLoader fxmlLoader = new FXMLLoader();
        fxmlLoader.setLocation(Main.class.getResource("requestFamily.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        FamilyRequestGUIController familyRequestGUIController = fxmlLoader.getController();
        familyRequestGUIController.displayFamilyRequests();
        stage.setScene(scene);
        stage.show();
    }

    public void toHomepageFamily() throws IOException {
        Stage stage = Main.getStage();
        Parent root = FXMLLoader.load(Objects.requireNonNull(Main.class.getResource("homepageFamily.fxml")));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    public void logout() throws IOException {
        LogoutGUIController logoutGUIController = new LogoutGUIController();
        logoutGUIController.logout();
    }
}
