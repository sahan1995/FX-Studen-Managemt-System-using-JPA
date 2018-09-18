/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.sms.controller;

import com.jfoenix.controls.JFXComboBox;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.ResourceBundle;
import javafx.animation.TranslateTransition;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import lk.ijse.sms.business.BOFactory;
import lk.ijse.sms.business.custom.BatchBO;
import lk.ijse.sms.db.DbConnection;
import lk.ijse.sms.dto.BatchDTO;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.view.JasperViewer;

/**
 * FXML Controller class
 *
 * @author Sahan Rajakaruna
 */
public class BatchJasperRepostController implements Initializable {

    @FXML
    private JFXComboBox<String> cmbBatch;
    /**
     * Initializes the controller class.
     */
    private BatchBO batchBO;
    @FXML
    private ImageView imgHome;
    @FXML
    private ImageView imgBack;
    @FXML
    private AnchorPane root;

    public BatchJasperRepostController() {
        this.batchBO = (BatchBO) BOFactory.getInstance().getBO(BOFactory.BOTypes.batch);
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        loadAllBatches();
    }

    @FXML
    private void btnSreportOnAction(ActionEvent event) {
         try {

            InputStream resourceAsStream = getClass().getResourceAsStream("/lk/ijse/sms/report/BatchStudents.jasper");
            HashMap<String, Object> parameters = new HashMap<>();
            parameters.put("batchno", cmbBatch.getValue());

            JasperPrint jasper = JasperFillManager.fillReport(resourceAsStream, parameters, DbConnection.getInstance().getConnection());
            JasperViewer.viewReport(jasper,false);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void btnAttendenceOnAction(ActionEvent event) {
        try {

            InputStream resourceAsStream = getClass().getResourceAsStream("/lk/ijse/sms/report/BatchAttendenceSheet.jasper");
            HashMap<String, Object> parameters = new HashMap<>();
            parameters.put("batchno", cmbBatch.getValue());

            JasperPrint jasper = JasperFillManager.fillReport(resourceAsStream, parameters, DbConnection.getInstance().getConnection());
            JasperViewer.viewReport(jasper,false);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void loadAllBatches() {
        try {

            cmbBatch.setItems(FXCollections.observableArrayList(batchBO.allBatchs()));
        } catch (Exception e) {
            e.printStackTrace();
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

    @FXML
    private void imgBackClicked(MouseEvent event) throws IOException {
               if (event.getSource() instanceof ImageView) {
            ImageView img = (ImageView) event.getSource();
            Parent root = null;
            switch (img.getId()) {
                case "imgBack":
                    root = FXMLLoader.load(this.getClass().getResource("/lk/ijse/sms/view/ReportDashBoard.fxml"));
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
