package controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import models.Account;

import java.io.IOException;

public class HomeController {
    private Account account;
    private @FXML Button accountsBtn;
    private @FXML Label firstNameLabel ;
    private @FXML Label lastNameLabel ;


    public void setUser(Account account) {
        this.account = account;
        firstNameLabel.setText(account.getFirstName());
        lastNameLabel.setText(account.getLastName());
    }

    public void logoutOnAction(ActionEvent event) throws IOException {
        Button button = (Button) event.getSource();
        Stage stage = (Stage) button.getScene().getWindow();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/Login.fxml"));
        stage.setScene(new Scene(loader.load()));
        stage.show();
    }

    public void accountsOnAction(ActionEvent event) throws IOException {
        Button button = (Button) event.getSource();
        Stage stage = (Stage) button.getScene().getWindow();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/accountView.fxml"));
        stage.setScene(new Scene(loader.load()));
        AccountsController accountsController = loader.getController();
        accountsController.setUser(account);
        stage.show();
    }

    public void addMedicineOnAction(ActionEvent event) throws IOException{
        Button button = (Button) event.getSource();
        Stage stage = (Stage) button.getScene().getWindow();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/AddMedicineController.fxml"));
        stage.setScene(new Scene(loader.load()));
        AddMedicineController addMedicineController = loader.getController();
        addMedicineController.setUser(account);
        stage.show();
    }

}
