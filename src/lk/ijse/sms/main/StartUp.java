/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.sms.main;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.hibernate.SessionFactory;

/**
 *
 * @author Sahan Rajakaruna
 */
public class StartUp extends Application {
    
    @Override
    public void start(Stage primaryStage) {
        try {

//
//            try (Session session = sessionFactory.openSession()) {
//
////                CourseDAO courseDAO = (CourseDAO) DAOFactory.getInstance().getDAO(DAOFactory.DAOTypes.course);
////                ExamDAO examDAO = (ExamDAO) DAOFactory.getInstance().getDAO(DAOFactory.DAOTypes.exam);
////                CourseModuleDAO courseModuleDAO = (CourseModuleDAO) DAOFactory.getInstance().getDAO(DAOFactory.DAOTypes.course_module);
//                session.beginTransaction();
////                examDAO.setSession(session);
////                List<Course> courseEntity = courseDAO.getAll();
////                courseModuleDAO.setSession(session);
////                courseModuleDAO.save(new CourseModule(new CourseModule_PK("C002","M002")));
////                examDAO.save(new Exam(new Module("M007"),new Course("C005")));
//
////                session.getTransaction().commit();
////                System.out.println(courseEntity);
//
//
//            } catch (HibernateException ex) {
//                System.out.println(ex);
//
//            } catch (Exception e) {
//                System.out.println(e);
//            }

//
//                Module m001 = session.get(Module.class, "M001");
//
//                Course c002 = session.get(Course.class, "C002");
//
//                Exam exam = new Exam(m001,c002);
//
//                session.persist(exam);
//                CourseModule courseModule = new CourseModule(new CourseModule_PK("C002", "M001"));
//                session.persist(courseModule);
//                Course c001 = new Course("C002", "DEP", "2 Years");
//                session.persist(c001);
//
//                Batch batch = new Batch("B001", new BigDecimal(60000.00), c001);
//
//                session.persist(batch);
//                session.get
//
//                Student Student = new Student("STU002", "SAHAN", "Rajakaruna", "951433705V", "0713025052", "Rathnapura");
//
//                Student.addStudetBatch(new StudentBatch(Student.getSid(),"B001"));
//
//                session.persist(Student);
//                session.getTransaction().commit();

//            sessionFactory.close();


            Parent root = FXMLLoader.load(this.getClass().getResource("/lk/ijse/sms/view/DashBoard.fxml"));
            
            Scene mainScene = new Scene(root);
            
            primaryStage.setTitle("Student Manage Panel");
            primaryStage.setScene(mainScene);
        
            primaryStage.setResizable(false);
            
            primaryStage.show();
            
        } catch (IOException ex) {
            Logger.getLogger(StartUp.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Throwable ex) {
            Logger.getLogger(StartUp.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
