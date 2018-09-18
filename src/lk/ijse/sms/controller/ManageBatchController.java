/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.sms.controller;

import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXListView;
import com.jfoenix.controls.JFXTextField;
import java.io.IOException;
import java.math.BigDecimal;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
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
import javafx.scene.control.SingleSelectionModel;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import lk.ijse.sms.business.BOFactory;
import lk.ijse.sms.business.custom.BatchBO;
import lk.ijse.sms.business.custom.CourseBO;
import lk.ijse.sms.dto.BatchDTO;
import lk.ijse.sms.dto.CourseDTO;

/**
 * FXML Controller class
 *
 * @author Sahan Rajakaruna
 */
public class ManageBatchController implements Initializable {

    private Pane paneDetails;
    /**
     * Initializes the controller class.
     */
    private CourseBO courseBO;
    private BatchBO batchBO;
    @FXML
    private JFXTextField txtBatchID;
    @FXML
    private JFXComboBox<String> cmbCourseName;
    @FXML
    private JFXTextField txtCourseFee;
    @FXML
    private JFXListView<String> lstStudents;

    private boolean newBatch = true;
    @FXML
    private ImageView imgHome;
    @FXML
    private AnchorPane root;

    public ManageBatchController() {
        this.batchBO = (BatchBO) BOFactory.getInstance().getBO(BOFactory.BOTypes.batch);
        this.courseBO = (CourseBO) BOFactory.getInstance().getBO(BOFactory.BOTypes.course);
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        lstStudents.setVisible(false);
        loadAllCourses();
        generateBatchNo();
    }

    @FXML
    private void btnRemoveOnAction(ActionEvent event) {
        Alert a = new Alert(Alert.AlertType.CONFIRMATION, "Are You Sure ?", ButtonType.YES, ButtonType.NO);
        a.showAndWait();
        if (a.getResult() == ButtonType.YES) {
            try {
                boolean result = batchBO.DeleteBatch(txtBatchID.getText());
                if (result) {
                    new Alert(Alert.AlertType.CONFIRMATION, "Batch Removed !").show();
                    txtBatchID.requestFocus();
                    txtCourseFee.setText("");
                }
            } catch (Exception e) {
                e.printStackTrace();
            }

        }
    }


    @FXML
    private void btnSaveOnAction(ActionEvent event) {
        if (newBatch == true) {
            try {
                String courseId = courseBO.findIdByTitle(cmbCourseName.getValue());

                System.out.println(courseId);
                boolean result = batchBO.RegisterBatch(new BatchDTO(txtBatchID.getText(), new BigDecimal(txtCourseFee.getText()), courseId));
                if (result) {
                    new Alert(Alert.AlertType.INFORMATION, "New Batch Added ! ").show();
                    txtBatchID.setText("");
                    txtCourseFee.setText("");
                    txtBatchID.requestFocus();
                    generateBatchNo();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }

        }
    }

    private void loadAllCourses() {
        ArrayList<String> allcourses = new ArrayList<>();
        try {
            ArrayList<CourseDTO> couseDTO = courseBO.allCourses();
            for (CourseDTO courseDTOs : couseDTO) {
                allcourses.add(courseDTOs.getCourse_title());
            }
            cmbCourseName.setItems(FXCollections.observableArrayList(allcourses));

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    private void batchStudents() {
        try {

            ArrayList<String> batchStu = batchBO.batchStudent(txtBatchID.getText());
            lstStudents.setItems(FXCollections.observableArrayList(batchStu));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void batchDetails() {
        try {
            BatchDTO batchDetails = batchBO.findById(txtBatchID.getText());
            if (batchDetails != null) {
                newBatch = false;
                txtCourseFee.setText("Rs " + batchDetails.getFee());
                //CourseDTO courseDetails = courseBO.findById(batchDetails.getCourse_id());
            } else {
                newBatch = true;
                new Alert(Alert.AlertType.CONFIRMATION, "No Batch Found !").show();
                lstStudents.setVisible(false);
                txtCourseFee.setText("");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void txtBatchIDKeyPress(KeyEvent event) {
        if (event.getCode() == KeyCode.ENTER) {
            lstStudents.setVisible(true);
            batchDetails();
            batchStudents();
        }
    }

    private void generateBatchNo() {
        try {
            String lastBatchNO = batchBO.getLastID();
            String[] Id = lastBatchNO.split("B");
            int id = Integer.parseInt(Id[1]) + 1;
            String batchNO = "B" + id;
            txtBatchID.setText(batchNO);
        } catch (Exception e) {
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
