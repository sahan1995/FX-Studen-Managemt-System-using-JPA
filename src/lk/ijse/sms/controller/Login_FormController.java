/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.sms.controller;

import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import java.awt.Frame;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.Duration;
import java.util.Optional;
import java.util.Properties;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.animation.FadeTransition;
import javafx.animation.TranslateTransition;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Sahan Rajakaruna
 */
public class Login_FormController implements Initializable {

    @FXML
    private AnchorPane root;
    @FXML
    private Label lblMsg;
    @FXML
    private JFXTextField txtuname;
    @FXML
    private JFXPasswordField txtpass;
    @FXML
    private ImageView imgClose;
    @FXML
    private ImageView imgMin;
    @FXML
    private ImageView imgClose1;
    @FXML
    private ImageView imgMin1;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        imgMin.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                Stage stage = (Stage) ((ImageView) event.getSource()).getScene().getWindow();
                stage.setIconified(true);

            }
        });
    }

    @FXML
    private void txtpassPressed(KeyEvent event) {
        KeyCode code = event.getCode();
        if (code == KeyCode.ENTER) {
            log();
        }

    }

    @FXML
    private void btnLoginOnAction(ActionEvent event) {

        if (txtuname.getText().equals("") || txtpass.getText().equals("")) {
            lblMsg.setText("Please fill the required fields");
        } else {
            log();
        }

    }

    @FXML
    private void txtUsernamePress(KeyEvent event) {

    }

    @FXML
    private void imgClicked(MouseEvent event) {

        Alert a = new Alert(Alert.AlertType.WARNING, "Do You Want to Exit", ButtonType.NO, ButtonType.YES);
        Optional<ButtonType> result = a.showAndWait();
        if (result.get() == ButtonType.YES) {
            System.exit(0);
        }
    }

    public void log() {
        try {
            File loginPropertyFile = new File("resource/application.properties");

            FileReader myfile = new FileReader(loginPropertyFile);
            Properties loginProperties = new Properties();
            loginProperties.load(myfile);

            String uname = loginProperties.getProperty("uname");
            String pass = loginProperties.getProperty("password");

            if (txtuname.getText().equals("admin") && txtpass.getText().equals("admin")) {

                Parent root = null;

                root = FXMLLoader.load(this.getClass().getResource("/lk/ijse/sms/view/DashBoard.fxml"));

                if (root != null) {
                    Scene subScene = new Scene(root);
                    Stage primaryStage = (Stage) this.root.getScene().getWindow();
                    primaryStage.setScene(subScene);
                    primaryStage.centerOnScreen();
                    primaryStage.show();
                    TranslateTransition tt = new TranslateTransition(javafx.util.Duration.millis(350), subScene.getRoot());
                    tt.setFromX(-subScene.getWidth());
                    tt.setToX(0);
                    tt.play();

                }
                
            }else{
                new Alert(Alert.AlertType.ERROR, "User Name or Password is Worng").show();
                txtuname.requestFocus();
            }
        } catch (Exception e) {
        }

    }
}
