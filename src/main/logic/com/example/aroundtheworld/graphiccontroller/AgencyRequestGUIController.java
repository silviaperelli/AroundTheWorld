package com.example.aroundtheworld.graphiccontroller;

import com.example.aroundtheworld.bean.FamilyRequestBean;
import com.example.aroundtheworld.bean.ResidenceRequestBean;
import com.example.aroundtheworld.appcontroller.ReserveRoomController;
import com.example.aroundtheworld.engineering.Session;
import com.example.aroundtheworld.engineering.observer.Observer;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.List;
import java.util.Objects;

public class AgencyRequestGUIController implements Observer {
    @FXML
    private HBox confirmedReqList;
    @FXML
    private HBox modifiedReqList;
    @FXML
    private HBox pendingReqList;

    public void backToAccess() throws IOException {
        Session.closeSession();
        Stage stage = Main.getStage();
        Parent root = FXMLLoader.load(Objects.requireNonNull(Main.class.getResource("accessPage.fxml")));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void toHomepageAgency() throws IOException {
        AgencyGUIController agencyGUIController = new AgencyGUIController();
        agencyGUIController.toHomepageAgency();
    }

    public void setAgencyRequests() throws IOException {

        ReserveRoomController reserveRoomController = new ReserveRoomController();
        List<ResidenceRequestBean> requestList = reserveRoomController.getResidenceRequests();

        for(ResidenceRequestBean requestBean: requestList){
            FXMLLoader fxmlLoader = new FXMLLoader();
            fxmlLoader.setLocation(getClass().getResource("requestAgencyItem.fxml"));
            Pane requestBox = fxmlLoader.load();
            requestBean.register(this);

            ResidenceRequestItemGUIController residenceRequestItemGUIController = fxmlLoader.getController();
            residenceRequestItemGUIController.setPane(requestBox);
            residenceRequestItemGUIController.setResidenceRequest(requestBean);

            if (requestBean.getStatus() == 0){
                pendingReqList.getChildren().add(requestBox);
            } else if (requestBean.getStatus() == 1){
                modifiedReqList.getChildren().add(requestBox);
            } else if(requestBean.getStatus() == 2){
                confirmedReqList.getChildren().add(requestBox);
            }
        }
    }

    @Override
    public void updateResidencePage(ResidenceRequestBean requestBean, Pane pane) {
        if (pendingReqList.getChildren().contains(pane))
            pendingReqList.getChildren().remove(pane);

        if (requestBean.getStatus() == 1) {
            modifiedReqList.getChildren().add(pane);
        } else if (requestBean.getStatus() == 2) {
            confirmedReqList.getChildren().add(pane);
        }
    }

    @Override
    public void update() {
        //ignore
    }

    @Override
    public void updateFamilyPage(FamilyRequestBean requestBean, Pane pane){
        //ignore
    }
}
