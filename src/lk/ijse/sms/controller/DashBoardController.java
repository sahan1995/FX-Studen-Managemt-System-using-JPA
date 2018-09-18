/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.sms.controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.animation.FadeTransition;
import javafx.animation.ScaleTransition;
import javafx.animation.TranslateTransition;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import javafx.util.Duration;
import lk.ijse.sms.business.BOFactory;
import lk.ijse.sms.business.custom.BatchBO;
import lk.ijse.sms.business.custom.CourseBO;
import lk.ijse.sms.business.custom.ModuleBO;
import lk.ijse.sms.business.custom.StudentBO;

/**
 * FXML Controller class
 *
 * @author Sahan Rajakaruna
 */
public class DashBoardController implements Initializable {

    @FXML
    private Label lblStudents;
    @FXML
    private Label lblCourses;
    @FXML
    private Label lblBatches;
    @FXML
    private Label lblModules;
    @FXML
    private Pane pane1;
    @FXML
    private ImageView imgStudent;
    @FXML
    private ImageView imgCourse;
    @FXML
    private ImageView imgBatch;
    @FXML
    private ImageView imgModule;
    @FXML
    private ImageView imgExam;
    @FXML
    private ImageView imgReports;
    @FXML
    private AnchorPane root;
    /**
     * Initializes the controller class.
     */
    private StudentBO studentBO;
    private CourseBO courseBO;
    private ModuleBO moduleBO;
    private BatchBO batchBO;

    public DashBoardController() {
        this.batchBO = (BatchBO)  BOFactory.getInstance().getBO(BOFactory.BOTypes.batch);
        this.moduleBO = (ModuleBO) BOFactory.getInstance().getBO(BOFactory.BOTypes.module);
        this.courseBO = (CourseBO) BOFactory.getInstance().getBO(BOFactory.BOTypes.course);
        this.studentBO = (StudentBO) BOFactory.getInstance().getBO(BOFactory.BOTypes.student);
    }
            
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        FadeTransition fadeIn = new FadeTransition(Duration.millis(2000), root);
        fadeIn.setFromValue(0.0);
        fadeIn.setToValue(1.0);
        fadeIn.play();
        counts();
    }

    @FXML
    private void Pane1MouseEnterd(MouseEvent event) {

    }

    @FXML
    private void imgClicked(MouseEvent event) throws IOException {

        if (event.getSource() instanceof ImageView) {
            ImageView icon = (ImageView) event.getSource();

            Parent root = null;

            switch (icon.getId()) {
                case "imgStudent":
                    root = FXMLLoader.load(this.getClass().getResource("/lk/ijse/sms/view/StudentRegistration.fxml"));
                    break;
                case "imgCourse":
                    root = FXMLLoader.load(this.getClass().getResource("/lk/ijse/sms/view/ManageCourse.fxml"));
                    break;
                case "imgBatch":
                    root = FXMLLoader.load(this.getClass().getResource("/lk/ijse/sms/view/ManageBatch.fxml"));

                    break;
                case "imgModule":
                    root = FXMLLoader.load(this.getClass().getResource("/lk/ijse/sms/view/ManageModule.fxml"));

                    break;
                case "imgExam":
                    root = FXMLLoader.load(this.getClass().getResource("/lk/ijse/sms/view/StudentExam.fxml"));

                    break;
                case "imgReports":
                    root = FXMLLoader.load(this.getClass().getResource("/lk/ijse/sms/view/ReportDashBoard.fxml"));

                    break;
            }

            if (root != null) {
                Scene subScene = new Scene(root);
                Stage primaryStage = (Stage) this.root.getScene().getWindow();
                primaryStage.setScene(subScene);
                primaryStage.centerOnScreen();

//                TranslateTransition tt = new TranslateTransition(Duration.millis(350), subScene.getRoot());
//                tt.setFromX(-subScene.getWidth());
//                tt.setToX(0);
//                tt.play();
                FadeTransition fadeIn = new FadeTransition(Duration.millis(2000), subScene.getRoot());
                fadeIn.setFromValue(0.0);
                fadeIn.setToValue(1.0);
                fadeIn.play();
                 
            }
        }

    }

    @FXML
    private void imgMouseExit(MouseEvent event) {
        ImageView icon = (ImageView) event.getSource();
        ScaleTransition scaleT = new ScaleTransition(Duration.millis(200), icon);
        scaleT.setToX(1);
        scaleT.setToY(1);
        scaleT.play();

        icon.setEffect(null);
    }

    @FXML
    private void imgMouseEnter(MouseEvent event) {
        ImageView icon = (ImageView) event.getSource();
        ScaleTransition scaleT = new ScaleTransition(Duration.millis(200), icon);
        scaleT.setToX(1.2);
        scaleT.setToY(1.2);
        scaleT.play();

        DropShadow glow = new DropShadow();
        glow.setColor(Color.CORNFLOWERBLUE);
        glow.setWidth(20);
        glow.setHeight(20);
        glow.setRadius(20);
        icon.setEffect(glow);
    }
    
    public void counts(){
        try {
            int studentCount = studentBO.getStudentCount();
            int batchCount = batchBO.batchCount();
            int moduleCount = moduleBO.moduleCount();
            int courseCount = courseBO.courseCount();
            lblStudents.setText(""+studentCount);
            lblBatches.setText(""+batchCount);
            lblCourses.setText(""+courseCount);
            lblModules.setText(""+moduleCount);
        } catch (Exception e) {
            System.out.println(e);
        }
      
    }

}
