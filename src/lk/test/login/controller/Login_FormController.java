/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.test.login.controller;

import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;

/**
 * FXML Controller class
 *
 * @author Sahan Rajakaruna
 */
public class Login_FormController implements Initializable {

    @FXML
    private AnchorPane root;
    @FXML
    private ImageView imgClose;
    @FXML
    private ImageView imgMin;
    @FXML
    private JFXTextField txtuname;
    @FXML
    private JFXPasswordField txtpass;
    @FXML
    private Label lblMsg;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void imgClicked(MouseEvent event) {
    }

    @FXML
    private void txtUsernamePress(KeyEvent event) {
    }

    @FXML
    private void txtpassPressed(KeyEvent event) {
    }

    @FXML
    private void btnLoginOnAction(ActionEvent event) {
    }
    
}
