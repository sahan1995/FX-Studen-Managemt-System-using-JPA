/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.sms.controller;

import com.jfoenix.controls.JFXTextField;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.animation.TranslateTransition;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import lk.ijse.sms.business.BOFactory;
import lk.ijse.sms.business.custom.ModuleBO;
import lk.ijse.sms.dto.ModuleDTO;
import lk.ijse.sms.view.util.tbmodel.ModuleTbModel;

/**
 * FXML Controller class
 *
 * @author Sahan Rajakaruna
 */
public class ManageModuleController implements Initializable {

    @FXML
    private JFXTextField txtModuleName;
    @FXML
    private JFXTextField txtModuleCode;

    private ModuleBO modue;
    @FXML
    private TableView<ModuleTbModel> tblModules;

    private boolean newModule = true;
    @FXML
    private AnchorPane root;
    @FXML
    private ImageView imgHome;

    public ManageModuleController() {
        this.modue = (ModuleBO) BOFactory.getInstance().getBO(BOFactory.BOTypes.module);
    }

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        tblModules.getColumns().get(0).setCellValueFactory(new PropertyValueFactory<>("moduleCode"));
        tblModules.getColumns().get(1).setCellValueFactory(new PropertyValueFactory<>("moduleName"));
        txtModuleName.requestFocus();
        loadAllModules();
        try {
            txtModuleCode.setText(modue.generateCustomId());
        } catch (Exception ex) {
            System.out.println(ex);
        }
    }

    @FXML
    private void btnRemoveOnAction(ActionEvent event) {

        Alert alert = new Alert(Alert.AlertType.WARNING, "Are You Sure ?", ButtonType.YES, ButtonType.NO);
        alert.showAndWait();
        if (alert.getResult() == ButtonType.YES) {
            try {
                boolean result = modue.DeleteModule(txtModuleCode.getText());
                if (result == true) {
                    new Alert(Alert.AlertType.INFORMATION, "Module Removed !").show();
                    txtModuleName.setText("");
                    txtModuleName.requestFocus();
                    tblModules.getSelectionModel().clearSelection();
                    txtModuleCode.setText(modue.generateCustomId());
                    loadAllModules();

                }
            } catch (Exception e) {
                System.out.println(e);
            }

        }

    }

    @FXML
    private void btnUpdateOnAction(ActionEvent event) {
      UpdateModule();
    }

    @FXML
    private void btnSaveOnAction(ActionEvent event) {
        if (newModule == false || tblModules.getSelectionModel().getSelectedIndex() >= 0) {
            UpdateModule();

        } else {
            saveModule();
        }

    }

    @FXML
    private void txtModuleCodeKeyPresses(KeyEvent event) {
        if (event.getCode() == KeyCode.ENTER) {
            getDetails();
        }
    }

    @FXML
    private void btnAddnewOnAction(ActionEvent event) {
        newModule = true;
        txtModuleName.setText("");
        txtModuleName.requestFocus();
        try {
            txtModuleCode.setText(modue.generateCustomId());
        } catch (Exception e) {
            System.out.println(e);
        }
        tblModules.getSelectionModel().clearSelection();

    }

    @FXML
    private void tblMouseClicked(MouseEvent event) {
        txtModuleCode.setText(tblModules.getSelectionModel().getSelectedItem().getModuleCode());

        txtModuleName.setText(tblModules.getSelectionModel().getSelectedItem().getModuleName());

    }

    private void getDetails() {
        try {
            ModuleDTO moduleDTO = modue.findById(txtModuleCode.getText());
            if (moduleDTO != null) {
                txtModuleName.setText(moduleDTO.getModule_name());
                newModule = false;
            } else {
                newModule = true;
                new Alert(Alert.AlertType.WARNING, "No Module Found").show();
            }

        } catch (Exception e) {
            System.out.println(e);
        }

    }

    private void loadAllModules() {
        ArrayList<ModuleTbModel> allModuleTbModels = new ArrayList<>();
        try {

            ArrayList<ModuleDTO> allModulesDTO = modue.allModules();
            for (ModuleDTO moduleDTO : allModulesDTO) {
                allModuleTbModels.add(new ModuleTbModel(moduleDTO.getModule_id(), moduleDTO.getModule_name()));
            }

        } catch (Exception e) {
            System.out.println(e);
        }
        tblModules.setItems(FXCollections.observableArrayList(allModuleTbModels));
    }

    private void saveModule() {
        try {
            boolean result = modue.AddModule(new ModuleDTO(txtModuleCode.getText(), txtModuleName.getText()));
            if (result == true) {
                new Alert(Alert.AlertType.INFORMATION, "Module Added ! ").show();
                loadAllModules();
                txtModuleCode.setText(modue.generateCustomId());
                txtModuleName.requestFocus();
                txtModuleName.setText("");

            }

        } catch (Exception e) {
        e.printStackTrace();
        }

    }

    private void UpdateModule() {
        try {
            boolean result = modue.UpdateModule(new ModuleDTO(txtModuleCode.getText(), txtModuleName.getText()));
            if (result == true) {
                loadAllModules();
                new Alert(Alert.AlertType.INFORMATION, "Module Updated ").show();
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    @FXML
    private void imgHomeClicked(MouseEvent event) throws IOException {
        if (event.getSource() instanceof ImageView) {
            ImageView img = (ImageView) event.getSource();
            Parent root = null;
            switch (img.getId()) {
                case "imgHome":
                    root = FXMLLoader.load(this.getClass().getResource("/lk/ijse/sms/view/DashBoard.fxml"));
                    break;

            }
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
        }
    }

}
