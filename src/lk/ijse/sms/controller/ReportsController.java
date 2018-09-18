/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.sms.controller;

import com.jfoenix.controls.JFXTextField;
import java.io.InputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.layout.Pane;
import lk.ijse.sms.db.DbConnection;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanArrayDataSource;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.engine.xml.JasperPrintFactory;
import net.sf.jasperreports.view.JasperViewer;

/**
 * FXML Controller class
 *
 * @author Sahan Rajakaruna
 */
public class ReportsController implements Initializable {

    @FXML
    private JFXTextField txtID;
    @FXML
    private Pane pane;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    @FXML
    private void btnClickOnAction(ActionEvent event) {
        try {

            InputStream resourceAsStream = getClass().getResourceAsStream("/lk/ijse/sms/report/Blank_A4.jasper");
            HashMap<String, Object> parameters = new HashMap<>();
            parameters.put("name", txtID.getText());

            JasperPrint jasper = JasperFillManager.fillReport(resourceAsStream, parameters, DbConnection.getInstance().getConnection());
            JasperViewer.viewReport(jasper);

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void dsd() {

        try {
            InputStream resourceAsStream = getClass().getResourceAsStream("/lk/ijse/sms/report/AllStudents.jasper");
            HashMap hash = new HashMap();

            JasperPrint jasper = JasperFillManager.fillReport(resourceAsStream, hash, DbConnection.getInstance().getConnection());
            JasperViewer.viewReport(jasper);
            
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
