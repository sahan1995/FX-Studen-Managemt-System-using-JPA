/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.sms.controller;

import com.jfoenix.controls.JFXListView;
import com.jfoenix.controls.JFXTextField;
import java.io.IOException;
import java.math.BigDecimal;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.function.Consumer;
import javafx.animation.TranslateTransition;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import lk.ijse.sms.business.BOFactory;
import lk.ijse.sms.business.custom.BatchBO;
import lk.ijse.sms.business.custom.ExamBO;
import lk.ijse.sms.business.custom.StudentExamBO;
import lk.ijse.sms.dto.BatchDTO;
import lk.ijse.sms.dto.BatchExamDTO;
import lk.ijse.sms.dto.CustomDTO;
import lk.ijse.sms.dto.StudentExamDTO;
import lk.ijse.sms.view.util.tbmodel.StudentExamTbmodel;

/**
 * FXML Controller class
 *
 * @author Sahan Rajakaruna
 */
public class StudentExamController implements Initializable {

    @FXML
    private TableView<StudentExamTbmodel> tblExamMarks;
    @FXML
    private TableColumn<StudentExamDTO, String> clmExamMark;
    @FXML
    private JFXTextField txtBatchNO;
    @FXML
    private JFXListView<String> lstStudents;
    /**
     * Initializes the controller class.
     */
    private BatchBO batchBO;
    private StudentExamBO studentExamBO;
    private String course_id;
    private ArrayList<StudentExamTbmodel> batchExam = new ArrayList<>();
    private ArrayList<String> batchStunts = new ArrayList<>();

    @FXML
    private AnchorPane root;
    @FXML
    private ImageView imgHome;

    public StudentExamController() {
        this.studentExamBO = (StudentExamBO) BOFactory.getInstance().getBO(BOFactory.BOTypes.student_exam);
        this.batchBO = (BatchBO) BOFactory.getInstance().getBO(BOFactory.BOTypes.batch);
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        tblExamMarks.getColumns().get(0).setCellValueFactory(new PropertyValueFactory<>("exam_id"));
        tblExamMarks.getColumns().get(1).setCellValueFactory(new PropertyValueFactory<>("module_name"));
        clmExamMark.setCellValueFactory(new PropertyValueFactory<StudentExamDTO, String>("mark"));
        //addSample();
        tblExamMarks.setEditable(true);
        clmExamMark.setCellFactory(TextFieldTableCell.forTableColumn());
    }

    private void addSample() {
        ArrayList<StudentExamTbmodel> sample = new ArrayList<>();
        sample.add(new StudentExamTbmodel(1, "Java", ""));
        sample.add(new StudentExamTbmodel(2, "RMI", ""));
        sample.add(new StudentExamTbmodel(3, "PHP", ""));
        sample.add(new StudentExamTbmodel(4, "DBMS", ""));
        tblExamMarks.setItems(FXCollections.observableArrayList(sample));
    }

    @FXML
    private void AddMarks(TableColumn.CellEditEvent eddditedCell) {
        StudentExamTbmodel selectedModule = tblExamMarks.getSelectionModel().getSelectedItem();
        selectedModule.setMark(String.valueOf(eddditedCell.getNewValue()));

    }

    @FXML
    private void txtBatchNokeyPressed(KeyEvent event) {
        if (event.getCode() == KeyCode.ENTER) {
            test();
            getBatcStudents();
        }
    }

    @FXML
    private void btnAddMarksOnAction(ActionEvent event) {

        EnterExamResults();

    }

    private void test() {
        try {

            batchExam.clear();

            BatchDTO batchDTO = batchBO.findById(txtBatchNO.getText());
            if (batchDTO == null) {
                new Alert(Alert.AlertType.ERROR, "No Batch Found !").show();
                return;
            }
            course_id = batchDTO.getCourse_id();
            ArrayList<CustomDTO> batchCustom = batchBO.batchExam(course_id);
            for (CustomDTO customDTO : batchCustom) {
                batchExam.add(new StudentExamTbmodel(customDTO.getExam_id(), customDTO.getModule_name(), ""));
            }
            tblExamMarks.setItems(FXCollections.observableArrayList(batchExam));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void getBatchExams() {
        try {
            batchExam.clear();
            BatchDTO batchDTO = batchBO.findById(txtBatchNO.getText());
            if (batchDTO == null) {
                new Alert(Alert.AlertType.ERROR, "No Batch Found !").show();
                return;
            }
            course_id = batchDTO.getCourse_id();
            ArrayList<BatchExamDTO> batchExamsDTO = batchBO.batchExams(course_id);

            for (BatchExamDTO batchExamDTO : batchExamsDTO) {

                batchExam.add(new StudentExamTbmodel(batchExamDTO.getExam_id(), batchExamDTO.getExam_module(), ""));
            }

            tblExamMarks.setItems(FXCollections.observableArrayList(batchExam));
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    private void getBatcStudents() {

        try {
            batchStunts.clear();
            ArrayList<String> batchStudent = batchBO.batchStudent(txtBatchNO.getText());

            batchStudent.forEach((String t) -> {
                batchStunts.add(t);
            });
            lstStudents.setItems(FXCollections.observableArrayList(batchStudent));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void EnterExamResults() {
        try {

            String student = lstStudents.getSelectionModel().getSelectedItem();
            String[] part = student.split("-");
            String sid = part[0];

            for (StudentExamTbmodel results : batchExam) {

                boolean result = studentExamBO.AddStudentExam(new StudentExamDTO(sid, (Integer) results.getExam_id(), new BigDecimal(results.getMark())));
                if (result) {
                    new Alert(Alert.AlertType.INFORMATION, "Exam Results Added !").show();

                }
            }
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
}
