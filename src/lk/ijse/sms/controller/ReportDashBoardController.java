/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.sms.controller;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.HashMap;
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
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.util.Duration;
import lk.ijse.sms.db.DbConnection;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.view.JasperViewer;

/**
 * FXML Controller class
 *
 * @author Sahan Rajakaruna
 */
public class ReportDashBoardController implements Initializable {

    @FXML
    private AnchorPane root;
    @FXML
    private ImageView imgStuReport;
    @FXML
    private ImageView imgResults;
    @FXML
    private ImageView imgBatch;
    @FXML
    private Label lblMsg;
    @FXML
    private ImageView imgHome;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    @FXML
    private void imgClicked(MouseEvent event) throws IOException {

        if (event.getSource() instanceof ImageView) {
            ImageView icon = (ImageView) event.getSource();

            Parent root = null;

            switch (icon.getId()) {
                case "imgStuReport":

                    try {

                        InputStream resourceAsStream = getClass().getResourceAsStream("/lk/ijse/sms/report/AllStudents.jasper");
                        
                        InputStream subReportStream = this.getClass().getResourceAsStream("/lk/ijse/sms/report/ChartStu.jasper");
                        JasperReport subReport = (JasperReport) JRLoader.loadObject(subReportStream);
                        
                        HashMap<String, Object> parameters = new HashMap<>();
                        
                        parameters.put("subReport", subReport);

                        JasperPrint jasper = JasperFillManager.fillReport(resourceAsStream, parameters, DbConnection.getInstance().getConnection());
                        JasperViewer.viewReport(jasper,false);

                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    System.out.println("aklh");
                    break;

                case "imgResults":
                    root = FXMLLoader.load(this.getClass().getResource("/lk/ijse/sms/view/ExamResultSheet.fxml"));
                    break;
                case "imgBatch":
                    root = FXMLLoader.load(this.getClass().getResource("/lk/ijse/sms/view/BatchJasperRepost.fxml"));

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
        if (event.getSource() instanceof ImageView) {
            FadeTransition fadeIn = new FadeTransition(Duration.millis(1500), lblMsg);
            fadeIn.setFromValue(0.0);
            fadeIn.setToValue(1.0);
            fadeIn.play();
            ImageView icon = (ImageView) event.getSource();

            Parent root = null;

            switch (icon.getId()) {

                case "imgResults":
                    lblMsg.setText("Report DashBoard");
                    break;
                case "imgBatch":
                    lblMsg.setText("Report DashBoard");

                    break;

            }
        }
        ImageView icon = (ImageView) event.getSource();
        ScaleTransition scaleT = new ScaleTransition(Duration.millis(200), icon);
        scaleT.setToX(1);
        scaleT.setToY(1);
        scaleT.play();

        icon.setEffect(null);
    }

    @FXML
    private void imgMouseEnterd(MouseEvent event) throws IOException {
        if (event.getSource() instanceof ImageView) {
            ImageView icon = (ImageView) event.getSource();

            Parent root = null;
            FadeTransition fadeIn = new FadeTransition(Duration.millis(1500), lblMsg);
            fadeIn.setFromValue(0.0);
            fadeIn.setToValue(1.0);
            fadeIn.play();
            switch (icon.getId()) {
                case "imgStudent":
                    root = FXMLLoader.load(this.getClass().getResource("/lk/ijse/sms/view/StudentRegistration.fxml"));
                    break;
                case "imgResults":
                    lblMsg.setText("Exam Result Sheets");

                    break;
                case "imgBatch":
                    lblMsg.setText("Batch Students and Attendence Sheets");

                    break;

            }
        }
        ImageView icon = (ImageView) event.getSource();
        DropShadow glow = new DropShadow();
        glow.setColor(Color.CORNFLOWERBLUE);
        glow.setWidth(20);
        glow.setHeight(20);
        glow.setRadius(20);
        icon.setEffect(glow);
    }

    @FXML
    private void s(MouseEvent event) {
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
