package com.example.aroundtheworld.graphiccontroller;

import com.example.aroundtheworld.bean.CompatibleFamilyBean;
import com.example.aroundtheworld.bean.FamilyRequestBean;
import com.example.aroundtheworld.appcontroller.ContactFamilyController;
import com.example.aroundtheworld.engineering.Session;
import com.example.aroundtheworld.engineering.ShowExceptionSupport;
import com.example.aroundtheworld.exception.FormEmptyException;
import com.example.aroundtheworld.exception.MessageException;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.RadioButton;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.List;

public class ContactFamilyGUIController {
    @FXML
    private RadioButton animalN;
    @FXML
    private RadioButton animalY;
    @FXML
    private DatePicker arrivalBox;
    @FXML
    private CheckBox booksC;
    @FXML
    private CheckBox cookingC;
    @FXML
    private DatePicker departureBox;
    @FXML
    private CheckBox filmC;
    @FXML
    private CheckBox natureC;
    @FXML
    private RadioButton noPrefRB;
    @FXML
    private RadioButton sharedH;
    @FXML
    private RadioButton siblingN;
    @FXML
    private RadioButton siblingY;
    @FXML
    private RadioButton singleH;
    @FXML
    private CheckBox sportC;
    @FXML
    private CheckBox travelsC;
    @FXML
    private RadioButton veganRB;
    @FXML
    private RadioButton vegetarianRB;
    @FXML
    private CheckBox videogamesC;
    @FXML
    ChoiceBox<String> cityBox;
    @FXML
    ObservableList<String> cityList = FXCollections.observableArrayList("London","Rome","Paris","New York","Valencia");

    @FXML
    public void initialize() {
        cityBox.setItems(cityList);
    }

    public void backButton(ActionEvent event) {
        ((Node)event.getSource()).getScene().getWindow().hide();
    }

    public void contactFamily(ActionEvent event) throws IOException {
        int siblings = 0;
        int animals = 0;
        int idStudent = Session.getCurrentSession().getStudentBean().getId();

        try {
            if (cityBox.getValue() == null)
                throw new FormEmptyException("City");
            if (arrivalBox.getValue() == null)
                throw new FormEmptyException("Arrival");
            if (departureBox.getValue() == null)
                throw new FormEmptyException("Departure");
            if (!vegetarianRB.isSelected() && !veganRB.isSelected() && !noPrefRB.isSelected())
                throw new FormEmptyException("Food Diet Preferences");
            if (!singleH.isSelected() && !sharedH.isSelected())
                throw new FormEmptyException("House");
            if (!siblingY.isSelected() && !siblingN.isSelected())
                throw new FormEmptyException("Siblings");
            if (!animalY.isSelected() && !animalN.isSelected())
                throw new FormEmptyException("Animals");

            if(siblingY.isSelected()){
                siblings = 1;
            }
            if(animalY.isSelected()){
                animals = 1;
            }

            FamilyRequestBean familyRequestBean = new FamilyRequestBean(cityBox.getValue(),arrivalBox.getValue().toString(),departureBox.getValue().toString(),siblings,animals,idStudent);
            setRequestPreferences(familyRequestBean);

            ContactFamilyController contactFamilyController = new ContactFamilyController();
            List<CompatibleFamilyBean> families = contactFamilyController.getCompatibleFamilies(familyRequestBean);

            Stage stage =  (Stage) ((Node) event.getSource()).getScene().getWindow();
            FXMLLoader fxmlLoader = new FXMLLoader();
            fxmlLoader.setLocation(getClass().getResource("familyList.fxml"));
            Main.setSecondaryStage(stage);

            Scene scene = new Scene(fxmlLoader.load());

            FamilyListGUIController familyListGUIController = fxmlLoader.getController();
            int count = familyListGUIController.displayCompatibleFamilies(families, familyRequestBean);

            stage.setScene(scene);
            stage.show();

            if(count==0){
                throw new MessageException("No families with compatibility \n greater than 50%");
            }

        } catch (FormEmptyException | MessageException  e) {
            ShowExceptionSupport.showException(e.getMessage());
        }
    }

    private void setRequestPreferences(FamilyRequestBean familyRequestBean) {

        String room;
        int vegetarian = 0;
        int vegan = 0;
        int travels = checkSelectionCB(travelsC);
        int sport = checkSelectionCB(sportC);
        int books = checkSelectionCB(booksC);
        int nature = checkSelectionCB(natureC);
        int film = checkSelectionCB(filmC);
        int videoGames = checkSelectionCB(videogamesC);
        int cooking = checkSelectionCB(cookingC);

        if (vegetarianRB.isSelected()) {
            vegetarian = 1;
        } else if (veganRB.isSelected()) {
            vegan = 1;
        }

        if (singleH.isSelected())
            room = "single";
        else
            room = "shared";

        familyRequestBean.setFood(vegetarian, vegan);
        familyRequestBean.setHobbies(travels, sport, books, nature, film, videoGames, cooking);
        familyRequestBean.setHouse(room);
    }

    private int checkSelectionCB(CheckBox box) {
        if(box.isSelected()){
            return 1;
        }
        return 0;
    }


}
