package controllers;

import databases.AccountsDBConnect;
import databases.DbConnect;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import models.Account;

import java.io.IOException;
import java.sql.*;

public class LoginController {

    @FXML private TextField user;
    @FXML private PasswordField pass;
    @FXML private Label label;

    @FXML
    void login(MouseEvent event) throws SQLException, IOException {


        String username, password;


        username = user.getText();
        password = pass.getText();

        Connection connection = DbConnect.getInstance().getConnection();

        Statement statement = connection.createStatement();

        ResultSet resultSet = statement.executeQuery("select * from Accounts where Username" +
                " = '" + username + "' and password = '" + password + "'");

        Account account = AccountsDBConnect.isLogin(username,password);
        if (resultSet.next()) {
//            label.setText("correct");
            Button button = (Button) event.getSource();
            Stage stage = (Stage) button.getScene().getWindow();
            FXMLLoader loader = new FXMLLoader( getClass().getResource("/Home.fxml"));
            stage.setScene(new Scene(loader.load()));
            HomeController homeController = loader.getController();
            homeController.setUser(account);
            stage.show();



        }else{
            label.setText("wrong");
        }


    }


}
