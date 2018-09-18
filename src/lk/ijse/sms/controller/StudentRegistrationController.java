/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.sms.controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;
import com.jfoenix.validation.RequiredFieldValidator;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.animation.FadeTransition;
import javafx.animation.TranslateTransition;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.util.Duration;
import lk.ijse.sms.business.BOFactory;
import lk.ijse.sms.business.custom.BatchBO;
import lk.ijse.sms.business.custom.CourseBO;
import lk.ijse.sms.business.custom.RegistrationBO;
import lk.ijse.sms.business.custom.StudentBO;
import lk.ijse.sms.dto.BatchDTO;
import lk.ijse.sms.dto.CourseDTO;
import lk.ijse.sms.dto.StudentBatchDTO;
import lk.ijse.sms.dto.StudentCourseDTO;
import lk.ijse.sms.dto.StudentDTO;
import lk.ijse.sms.view.util.tbmodel.StudentCourseTbModel;

/**
 * FXML Controller class
 *
 * @author Sahan Rajakaruna
 */
public class StudentRegistrationController implements Initializable {

    @FXML
    private AnchorPane anchorpaneManage;
    @FXML
    private Pane paneRegister;
    @FXML
    private JFXButton btnRegister;
    @FXML
    private JFXButton btnManage;
    @FXML
    private Pane paneManage;

    private FadeTransition fade = new FadeTransition(Duration.millis(400));
    @FXML
    private JFXTextField txtFname;
    @FXML
    private JFXTextField txtLname;
    @FXML
    private JFXTextField txtNIC;
    @FXML
    private JFXTextField txtContact;
    @FXML
    private JFXTextField txtAddress;
    @FXML
    private JFXComboBox<String> cmbCourse;
    @FXML
    private JFXTextField txtCourseFee;
    @FXML
    private JFXComboBox<String> cmbBatch;
    @FXML
    private JFXTextField txtsid;

    private CourseBO course;
    private BatchBO batch;
    private StudentBO student;
    private RegistrationBO registrationB;

    private boolean newStudent = true;
    @FXML
    private Label lblCourseID;
    @FXML
    private TableView<StudentCourseTbModel> tblStudentCourses;
    @FXML
    private JFXTextField txtFnamem;
    @FXML
    private JFXTextField txtLnamem;
    @FXML
    private JFXTextField txtNICm;
    @FXML
    private JFXTextField txtContactm;
    @FXML
    private JFXTextField txtAddressm;
    @FXML
    private JFXTextField txtsidm;
    @FXML
    private AnchorPane root;
    @FXML
    private ImageView imgHome;

    public StudentRegistrationController() {
        this.registrationB = (RegistrationBO) BOFactory.getInstance().getBO(BOFactory.BOTypes.student_register);
        this.student = (StudentBO) BOFactory.getInstance().getBO(BOFactory.BOTypes.student);
        this.batch = (BatchBO) BOFactory.getInstance().getBO(BOFactory.BOTypes.batch);
        this.course = (CourseBO) BOFactory.getInstance().getBO(BOFactory.BOTypes.course);
    }

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
            getCourseNames();
        generateCustomId();
        txtFname.focusedProperty().addListener(new ChangeListener<Boolean>() {
            @Override
            public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) {
                if (newValue == true) {
                    txtFname.setText("");
                    txtLname.setText("");
                    txtNIC.setText("");
                    txtContact.setText("");
                    txtAddress.setText("");

                    GetStudentDetails(txtsid.getText());
                }
            }
        });
        RequiredFieldValidator validator = new RequiredFieldValidator();
        txtFname.getValidators().add(validator);
        txtLname.getValidators().add(validator);
        txtContact.getValidators().add(validator);
        txtAddress.getValidators().add(validator);
        txtNIC.getValidators().add(validator);

        validator.setMessage("No Input Given");
        txtFname.focusedProperty().addListener(new ChangeListener<Boolean>() {
            @Override
            public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) {
                if (!newValue) {
                    txtFname.validate();
                }
            }
        });

        tblStudentCourses.getColumns().get(0).setCellValueFactory(new PropertyValueFactory<>("batchNo"));
        tblStudentCourses.getColumns().get(1).setCellValueFactory(new PropertyValueFactory<>("courseTitle"));

    }

    @FXML
    private void btnOnAction(ActionEvent event) {

        if (event.getSource() == btnManage) {

            fade.setNode(paneManage);
            fade.setFromValue(0.0);
            fade.setToValue(1.0);
            fade.playFromStart();
            paneManage.toFront();

        } else if (event.getSource() == btnRegister) {

            fade.setNode(paneRegister);
            fade.setFromValue(0.0);
            fade.setToValue(1.0);
            fade.playFromStart();
            paneRegister.toFront();
        }

    }

    @FXML
    private void btnRegisterOnAction(ActionEvent event) {
        try {
            if (newStudent == true) {

                String nic = txtNIC.getText();
                boolean validate = nic.matches("^\\d{9}[V|v]$");
                if (validate != true) {
                    new Alert(Alert.AlertType.ERROR, "Invalid NIC Format").show();
                    return;
                }

                boolean result = registrationB.RegisterNewStudent(new StudentDTO(txtsid.getText(), txtFname.getText(), txtLname.getText(), txtNIC.getText(), txtContact.getText(), txtAddress.getText()), new StudentBatchDTO(txtsid.getText(), cmbBatch.getValue()));
                if (result == true) {
                    new Alert(Alert.AlertType.INFORMATION, "New Student Registred !").show();
                    txtFname.setText("");
                    txtLname.setText("");
                    txtNIC.setText("");
                    txtContact.setText("");
                    txtAddress.setText("");
                    txtCourseFee.setText("");
                    generateCustomId();
                    txtsid.requestFocus();

                } else {
                    new Alert(Alert.AlertType.INFORMATION, "Student Not Registerd !").show();
                }
            } else {
                registrationB.RegisterToBatch(new StudentBatchDTO(txtsid.getText(), cmbBatch.getValue()));
                new Alert(Alert.AlertType.INFORMATION, " Student Registred to Batch !").show();
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    @FXML
    private void lblResetClicked(MouseEvent event) {
    }

    //getCourseNames
    public void getCourseNames() {
        try {


            ArrayList<CourseDTO> allCourses = course.allCourses();
            ArrayList<String> allCourseNames = new ArrayList<>();
            for (CourseDTO allCourse : allCourses) {
                allCourseNames.add(allCourse.getCourse_title());

            }
            cmbCourse.setItems(FXCollections.observableArrayList(allCourseNames));
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void getBatches(String course_title) {


        try {
            String ID = course.findIdByTitle(course_title);
            System.out.println(ID);
            lblCourseID.setText(ID);
            ArrayList<String> findAllBachesByCourse = batch.findAllBachesByCourse(ID);
            cmbBatch.setItems(FXCollections.observableList(findAllBachesByCourse));

        } catch (Exception e) {
            System.out.println(e);
        }

    }

    public void getCourseFee(String batch_id) {
        System.out.println(batch_id);
        try {
            BatchDTO batchDetail = batch.findById(batch_id);
            txtCourseFee.setText(batchDetail.getFee() + "");

        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void generateCustomId() {
        try {
            String customId = student.generateCustomId();
            txtsid.setText(customId);
        } catch (Exception e) {
            System.out.println(e);
        }

    }

    private void GetStudentDetails(String id) {
        try {
            StudentDTO StudentDetails = student.findById(id);
            if (StudentDetails != null) {
                txtFname.setText(StudentDetails.getFname());
                txtLname.setText(StudentDetails.getLname());
                txtNIC.setText(StudentDetails.getNic());
                txtContact.setText(StudentDetails.getContact());
                txtAddress.setText(StudentDetails.getAddress());
                newStudent = false;
            } else {
                newStudent = true;
            }

        } catch (Exception e) {
            System.out.println(e);
        }

    }

    @FXML
    private void cmbCourseOnAction(ActionEvent event) {
        getBatches(cmbCourse.getValue());

    }

    @FXML
    private void cmbBatchOnAction(ActionEvent event) {
        getCourseFee(cmbBatch.getValue());
    }

    @FXML
    private void btnSearchOnAction(ActionEvent event) {

        getStudentDetails();

    }

    private void getStudentCourse(String sid) {
        try {
            ArrayList<StudentCourseTbModel> studentCourseTbModels = new ArrayList<>();
            ArrayList<StudentCourseDTO> studentCourse = student.studentCourse(sid);
            for (StudentCourseDTO studentCourseDTO : studentCourse) {
                studentCourseTbModels.add(new StudentCourseTbModel(studentCourseDTO.getBatchId(), studentCourseDTO.getCourse_title()));

            }
            tblStudentCourses.setItems(FXCollections.observableArrayList(studentCourseTbModels));
        } catch (Exception e) {
            System.out.println(e);
        }

    }

    @FXML
    private void btnUpdateOnAction(ActionEvent event) {
        try {
            boolean result = student.UpdateStudent(new StudentDTO(txtsidm.getText(), txtFnamem.getText(), txtLnamem.getText(), txtNICm.getText(), txtContactm.getText(), txtAddressm.getText()));
            if (result == true) {
                new Alert(Alert.AlertType.WARNING, " Student Updated !").show();
            }
        } catch (Exception e) {
            System.out.println(e);
        }

    }

    @FXML
    private void btnRemoveOnAction(ActionEvent event) {

        Alert alert = new Alert(Alert.AlertType.WARNING, "Are You Sure ? ", ButtonType.YES, ButtonType.NO);
        alert.showAndWait();
        if (alert.getResult() == ButtonType.YES) {
            try {
                boolean result = student.DeleteStudent(txtsidm.getText());
                if (result == true) {
                    new Alert(Alert.AlertType.INFORMATION, "Student Removed !").show();
                }
            } catch (Exception e) {
                System.out.println(e);
            }

        }

    }

    @FXML
    private void lblResetClickedM(MouseEvent event) {

        txtFnamem.setText("");
        txtLnamem.setText("");
        txtNICm.setText("");
        txtContactm.setText("");
        txtAddressm.setText("");
        txtsidm.setText("");
        txtsidm.requestFocus();
        for (int i = 0; i < tblStudentCourses.getItems().size(); i++) {
            tblStudentCourses.getItems().clear();
        }

    }

    private void getStudentDetails() {
        try {
            StudentDTO studentDetail = student.findById(txtsidm.getText());
            if (studentDetail != null) {
                txtFnamem.setText(studentDetail.getFname());
                txtLnamem.setText(studentDetail.getLname());
                txtContactm.setText(studentDetail.getContact());
                txtNICm.setText(studentDetail.getNic());
                txtAddressm.setText(studentDetail.getAddress());
                getStudentCourse(txtsidm.getText());
            } else {
                new Alert(Alert.AlertType.WARNING, "No Student Found !").show();
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
