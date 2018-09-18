/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.sms.controller;

import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;
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
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import lk.ijse.sms.business.BOFactory;
import lk.ijse.sms.business.custom.CourseBO;
import lk.ijse.sms.business.custom.StudentBO;
import lk.ijse.sms.db.DbConnection;
import lk.ijse.sms.dto.StudentDTO;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.view.JasperViewer;

/**
 * FXML Controller class
 *
 * @author Sahan Rajakaruna
 */
public class ExamResultSheetController implements Initializable {

    @FXML
    private JFXComboBox<String> cmbStudentBatched;
    @FXML
    private JFXTextField txtsid;
    @FXML
    private Label lblStudentname;
    /**
     * Initializes the controller class.
     */
    private StudentBO studentBO;
    private CourseBO courseBO;
    @FXML
    private AnchorPane root;
    @FXML
    private ImageView imgHome;
    @FXML
    private ImageView imgBack;

    public ExamResultSheetController() {
        this.courseBO = (CourseBO) BOFactory.getInstance().getBO(BOFactory.BOTypes.course);
        this.studentBO = (StudentBO) BOFactory.getInstance().getBO(BOFactory.BOTypes.student);
    }
    @Override
    public void initialize(URL url, ResourceBundle rb) {
       txtsid.requestFocus();
       lblStudentname.setVisible(false);
    }    

    @FXML
    private void btnGenerateReportOnAction(ActionEvent event) {
         try {
             
            InputStream resourceAsStream = getClass().getResourceAsStream("/lk/ijse/sms/report/ResultSheet.jasper");
            HashMap<String, Object> parameters = new HashMap<>();
            // String coursrId = courseBO.getCoursrId(cmbStudentBatched.getValue());
            parameters.put("sid", txtsid.getText());
            parameters.put("batchno", cmbStudentBatched.getValue());
            
            JasperPrint jasper = JasperFillManager.fillReport(resourceAsStream, parameters, DbConnection.getInstance().getConnection());
            JasperViewer.viewReport(jasper,false);

        } catch (Exception e) {
            e.printStackTrace();
        }
        
        
        
    }
    
    private void studentBatches(){
        
        try {
            ArrayList<String> studentBatch = studentBO.getStudentBatch(txtsid.getText());
            
            if(studentBatch!=null){
                 cmbStudentBatched.setItems(FXCollections.observableArrayList(studentBatch));
                
            }else{
                new Alert(Alert.AlertType.ERROR, "No Student Found ! ").show();
            }
           
            
        } catch (Exception e) {
            System.out.println(e);
        }
        
        
        
    }
    private void getStudentName(){
        try {
            StudentDTO details = studentBO.findById(txtsid.getText());
            if(details!=null){
                lblStudentname.setVisible(true);
                lblStudentname.setText(details.getFname()+" "+details.getLname());
                
            }else{
                lblStudentname.setVisible(false);
                lblStudentname.setText("");
                new Alert(Alert.AlertType.ERROR, "No Student Found ").show();
            }
        } catch (Exception e) {
        }
            
    }

    @FXML
    private void txtSidPressed(KeyEvent event) {
        if(event.getCode()==KeyCode.ENTER){
            studentBatches();
            getStudentName();
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
