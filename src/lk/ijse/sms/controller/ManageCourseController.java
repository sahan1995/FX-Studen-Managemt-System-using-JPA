/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.sms.controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXListView;
import com.jfoenix.controls.JFXTextField;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import javafx.animation.FadeTransition;
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
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.util.Duration;
import lk.ijse.sms.business.BOFactory;
import lk.ijse.sms.business.custom.CourseBO;
import lk.ijse.sms.business.custom.CourseModuleBO;
import lk.ijse.sms.business.custom.ExamBO;
import lk.ijse.sms.business.custom.ModuleBO;
import lk.ijse.sms.business.custom.RegisterCourseBO;
import lk.ijse.sms.dto.CourseDTO;
import lk.ijse.sms.dto.CourseModuleDTO;
import lk.ijse.sms.dto.ExamDTO;
import lk.ijse.sms.dto.ModuleDTO;
import lk.ijse.sms.view.model.ModuleIDModel;
import lk.ijse.sms.view.util.tbmodel.ModuleTbModel;

/**
 * FXML Controller class
 *
 * @author Sahan Rajakaruna
 */
public class ManageCourseController implements Initializable {

    @FXML
    private Pane paneAddCourse;
    @FXML
    private JFXTextField txtCourseID;
    @FXML
    private JFXTextField txtCourseTitle;
    @FXML
    private JFXTextField txtCourseDuration;
    @FXML
    private JFXListView<String> lstAllMoudels;
    @FXML
    private JFXListView<String> lstSelectedModules;
    private FadeTransition fade = new FadeTransition(Duration.millis(400));
    private ModuleBO module = (ModuleBO) BOFactory.getInstance().getBO(BOFactory.BOTypes.module);
    private CourseBO course = (CourseBO) BOFactory.getInstance().getBO(BOFactory.BOTypes.course);
    private ExamBO exam = (ExamBO) BOFactory.getInstance().getBO(BOFactory.BOTypes.exam);
    private CourseModuleBO courseModuleBO;
    private RegisterCourseBO registerCourse;
    private ArrayList<String> selectedModules = new ArrayList<>();
    private ArrayList<String> moduleTbModels = new ArrayList<>();
    @FXML
    private JFXButton btnAddCourse;
    @FXML
    private JFXButton btnManageCourse;
    @FXML
    private Pane PaneManageCourse;
    @FXML
    private JFXTextField txtCourseDurationm;
    @FXML
    private JFXTextField txtCourseIDm;
    @FXML
    private JFXTextField txtCourseTitlem;
    @FXML
    private JFXListView<String> lstCourseModules;
    @FXML
    private JFXListView<String> lstalModulesM;
    @FXML
    private AnchorPane root;
    @FXML
    private ImageView imgHome;

    public ManageCourseController() {
        this.registerCourse = (RegisterCourseBO) BOFactory.getInstance().getBO(BOFactory.BOTypes.course_register);
        this.courseModuleBO = (CourseModuleBO) BOFactory.getInstance().getBO(BOFactory.BOTypes.course_module);
    }

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        getAllModules();
        CustomId();
        txtCourseID.requestFocus();
    }

    public void getAllModules() {

        try {

            ArrayList<ModuleDTO> allModules = module.allModules();
            for (ModuleDTO allModule : allModules) {
                moduleTbModels.add(allModule.getModule_name());
            }
            lstAllMoudels.setItems(FXCollections.observableArrayList(moduleTbModels));
            lstalModulesM.setItems(FXCollections.observableArrayList(moduleTbModels));
        } catch (Exception e) {

            System.out.println(e);
        }

    }

    @FXML
    private void btnSelectOnAction(ActionEvent event) {

        selectedModules.add(lstAllMoudels.getSelectionModel().getSelectedItem());
        lstSelectedModules.setItems(FXCollections.observableArrayList(selectedModules));

        moduleTbModels.remove(lstAllMoudels.getSelectionModel().getSelectedIndex());
        lstAllMoudels.getItems().remove(lstAllMoudels.getSelectionModel().getSelectedIndex());

    }

    @FXML
    private void btnRemoveOnAction(ActionEvent event) {

        moduleTbModels.add(lstSelectedModules.getSelectionModel().getSelectedItem());

        lstAllMoudels.setItems(FXCollections.observableArrayList(moduleTbModels));
        selectedModules.remove(lstSelectedModules.getSelectionModel().getSelectedIndex());
        lstSelectedModules.setItems(FXCollections.observableArrayList(selectedModules));

    }

    @FXML
    private void btnAddOnAction(ActionEvent event) {


        ArrayList<ModuleIDModel> allIDs = new ArrayList<>();
        int x = 1;
        try {

            registerCourse.registerCourse(new CourseDTO(txtCourseID.getText(), txtCourseTitle.getText(), txtCourseDuration.getText()));

            for (String selectedModule : selectedModules) {
                ArrayList<String> id1 = module.getID(selectedModule);

                allIDs.add(new ModuleIDModel(id1.toString()));
                registerCourse.addExamandModule(new ExamDTO("0", txtCourseID.getText(), id1.get(0)), new CourseModuleDTO(txtCourseID.getText(), id1.get(0)));
            }
            new Alert(Alert.AlertType.INFORMATION, "Course Added").show();

            System.out.println(allIDs);
        } catch (Exception e) {
            System.out.println(e);
        }

    }

    @FXML
    private void btnSOnAction(ActionEvent event) {
        if (event.getSource() == btnAddCourse) {

            fade.setNode(paneAddCourse);
            fade.setFromValue(0.0);
            fade.setToValue(1.0);
            fade.playFromStart();
            PaneManageCourse.toBack();
            paneAddCourse.toFront();

        } else if (event.getSource() == btnManageCourse) {

            fade.setNode(PaneManageCourse);
            fade.setFromValue(0.0);
            fade.setToValue(1.0);
            fade.playFromStart();
            PaneManageCourse.toFront();

        }

    }

    private void CustomId() {
        try {
            txtCourseID.setText(course.generateCoutomID());
            txtCourseTitle.requestFocus();
        } catch (Exception e) {
            System.out.println(e);
        }

    }

    private void findByid() {
        try {
            CourseDTO courseDetails = course.findById(txtCourseIDm.getText());
            if (courseDetails != null) {
                txtCourseTitlem.setText(courseDetails.getCourse_title());
                txtCourseDurationm.setText(courseDetails.getDuration());

            } else {
                new Alert(Alert.AlertType.ERROR, "No Course Found !").show();
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    private void CourseModules() {
        try {
            ArrayList<String> courseModules = module.getCourseModules(txtCourseIDm.getText());
            lstCourseModules.setItems(FXCollections.observableArrayList(courseModules));
        } catch (Exception e) {
        }
    }

    @FXML
    private void txtIDPresses(KeyEvent event) {

        if (event.getCode() == KeyCode.ENTER) {
            findByid();
            CourseModules();
        }
    }

    @FXML
    private void btnSaveOnAcion(ActionEvent event) {
        UpdateCourse();
    }

    @FXML
    private void btnRemoveModuleOnAction(ActionEvent event) {

        try {
            String moduleID = module.getModuleID(lstCourseModules.getSelectionModel().getSelectedItem());
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION, "Do You Want to Really Remove this Module ?", ButtonType.YES, ButtonType.NO);
            alert.showAndWait();
            if (alert.getResult() == ButtonType.YES) {
                boolean result = courseModuleBO.DeleteCourseModule(txtCourseIDm.getText(), moduleID);
                boolean result2 = exam.RemoveExam(txtCourseIDm.getText(), moduleID);

                if (result && result2) {
                    new Alert(Alert.AlertType.INFORMATION, "Module Removed !").show();
                    CourseModules();

                }
            }

        } catch (Exception e) {
            System.out.println(e);
        }

    }

    private void UpdateCourse() {
        try {

            boolean result = course.UpdateCourse(new CourseDTO(txtCourseIDm.getText(), txtCourseTitlem.getText(), txtCourseDurationm.getText()));
            if (result == true) {
                new Alert(Alert.AlertType.INFORMATION, "Module Updated !").show();
                findByid();
            }

        } catch (Exception e) {
            System.out.println(e);
        }
    }

    private void RemoveModule() {
        try {

            Alert alert = new Alert(Alert.AlertType.CONFIRMATION, "Are You Sure ?", ButtonType.YES, ButtonType.NO);
            alert.showAndWait();
            if (alert.getResult() == ButtonType.YES) {
                boolean result = course.DeleteCourse(txtCourseIDm.getText());

                if (result == true) {
                    new Alert(Alert.AlertType.INFORMATION, "Course Removed !").show();
                    txtCourseIDm.setText("");
                    txtCourseIDm.requestFocus();
                    txtCourseDurationm.setText("");
                    txtCourseDurationm.setText("");
                    lstCourseModules.getSelectionModel().clearSelection();

                }
            }
        } catch (Exception e) {
            System.out.println(e);
        }

    }

    @FXML
    private void btnRemoveOnAction1(ActionEvent event) {
        RemoveModule();
    }

    @FXML
    private void btnAddNewMdouleOnAction(ActionEvent event) {
        try {
            ArrayList<String> moduleId = module.getID(lstalModulesM.getSelectionModel().getSelectedItem());
            System.out.println(moduleId.get(0));
            boolean result1 = registerCourse.coueseExam(new ExamDTO("0", txtCourseIDm.getText(), moduleId.get(0)), true);
            boolean result2 = registerCourse.addCourseModules(new CourseModuleDTO(txtCourseIDm.getText(), moduleId.get(0)));
            if (result1 && result2 == true) {
                new Alert(Alert.AlertType.INFORMATION, "New Module Added to the Course ! ").show();
                CourseModules();

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
