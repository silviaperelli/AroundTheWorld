package com.example.aroundtheworld.graphiccontroller;

import com.example.aroundtheworld.bean.CompatibleFamilyBean;
import com.example.aroundtheworld.bean.FamilyRequestBean;
import com.example.aroundtheworld.engineering.Printer;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Region;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.List;
import java.util.Objects;


public class FamilyListGUIController {
    @FXML
    private GridPane familyGrid = new GridPane();

    public void backToForm(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("contactFamilyForm.fxml")));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(new Scene(root,918,560));
        stage.centerOnScreen();
        stage.show();
    }

    public int displayCompatibleFamilies(List<CompatibleFamilyBean> compatibleFamilies, FamilyRequestBean familyRequestBean) {
        int column = 0;
        int row = 1;
        int count = 0;

        try {

            for (CompatibleFamilyBean family : compatibleFamilies) {
                FXMLLoader fxmlLoader = new FXMLLoader();
                fxmlLoader.setLocation(getClass().getResource("familyItem.fxml"));
                AnchorPane anchorPane = fxmlLoader.load();

                FamilyItemGUIController familyItemGUIController = fxmlLoader.getController();

                if (count == 0 && family.getCompatibility() >= 50.0) {
                    count++;
                }

                familyItemGUIController.setData(family, familyRequestBean);

                if (column == 3) {
                    column = 0;
                    row++;
                }

                familyGrid.add(anchorPane, column++, row);

                familyGrid.setMinWidth(Region.USE_COMPUTED_SIZE);
                familyGrid.setPrefWidth(Region.USE_COMPUTED_SIZE);
                familyGrid.setMaxWidth(Region.USE_PREF_SIZE);

                familyGrid.setMinHeight(Region.USE_COMPUTED_SIZE);
                familyGrid.setPrefHeight(Region.USE_COMPUTED_SIZE);
                familyGrid.setMaxHeight(Region.USE_PREF_SIZE);

                GridPane.setMargin(anchorPane, new Insets(10));
            }

        } catch (IOException e) {
            Printer.printError(e.getMessage());
        }

        return count;
    }

    public void close(ActionEvent event) {
        ((Node)event.getSource()).getScene().getWindow().hide();
    }
}
