/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.sms.business.custom.impl;

import java.sql.Connection;
import lk.ijse.sms.business.custom.RegisterCourseBO;
import lk.ijse.sms.dao.DAOFactory;
import lk.ijse.sms.dao.custom.CourseDAO;
import lk.ijse.sms.dao.custom.CourseModuleDAO;
import lk.ijse.sms.dao.custom.ExamDAO;
import lk.ijse.sms.db.DbConnection;
import lk.ijse.sms.dto.CourseDTO;
import lk.ijse.sms.dto.CourseModuleDTO;
import lk.ijse.sms.dto.ExamDTO;
import lk.ijse.sms.entity.Course;
import lk.ijse.sms.entity.CourseModule;
import sun.security.pkcs11.Secmod;

/**
 *
 * @author Sahan Rajakaruna
 */
public class RegisterCourseBOImpl implements RegisterCourseBO {
//
//    private CourseDAO courseDAO = (CourseDAO) DAOFactory.getInstance().getDAO(DAOFactory.DAOTypes.course);
//    private CourseModuleDAO courseModuleDAO = (CourseModuleDAO) DAOFactory.getInstance().getDAO(DAOFactory.DAOTypes.course_module);
//    private ExamDAO examDAO = (ExamDAO) DAOFactory.getInstance().getDAO(DAOFactory.DAOTypes.exam);
    //private boolean result;

    private boolean firstTime = true;

    CourseBOImpl courseBOImpl = new CourseBOImpl();
    CourseModuleBOImpl courseModuleBOImpl = new CourseModuleBOImpl();
    ExamBOImpl examBOImpl = new ExamBOImpl();
    boolean registerCourse = false;
    // boolean result2 = false;

    private Connection conn;
    boolean result = false, result2 = false, result3 = false;



    @Override
    public boolean registerCourse(CourseDTO course) throws Exception {

        courseBOImpl.RegisterCourse(new CourseDTO(course.getCourse_id(), course.getCourse_title(), course.getDuration()));

        return true;

//        conn = DbConnection.getInstance().getConnection();
//        conn.setAutoCommit(false);
//
//        result = courseBOImpl.RegisterCourse(new CourseDTO(course.getCourse_id(), course.getCourse_title(), course.getDuration()));
//        if (result == true) {
//            return result;
//
//        } else {
//            conn.rollback();
//            return false;
//        }
    }

    @Override
    public boolean coueseExam(ExamDTO exam, boolean bool) throws Exception {

        try {
            if (result == true || bool == true) {
                System.out.println("ds");
                result2 = examBOImpl.AddExam(exam);
                if (result2 == true) {
                   
                    return result2;
                } else {
                    conn.rollback();
                    return false;
                }
            }
        } catch (Exception e) {
            conn.rollback();
            throw e;

        }
        if (result2 == true) {
           return result2;
        } else {
            return false;
        }

    }

    @Override
    public boolean addCourseModules(CourseModuleDTO course_module) throws Exception {
        
        Connection conn = DbConnection.getInstance().getConnection();
        conn.setAutoCommit(false);
        try {
            if (result2 == true) {
                result3 = courseModuleBOImpl.AddCourseModule(course_module);
                if (result3 == true) {
                    conn.commit();

                } else {
                    conn.rollback();
                }
            } else {
                conn.rollback();
            }

        } catch (Exception e) {
            conn.rollback();
            throw e;
        }finally{
            conn.setAutoCommit(true);
        }
        if (result3 == true) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public boolean addExamandModule(ExamDTO examDTO, CourseModuleDTO courseModuleDTO) throws Exception {

        examBOImpl.AddExam(new ExamDTO("0",examDTO.getCourse_id(),examDTO.getModule_id()));
        courseModuleBOImpl.AddCourseModule(new CourseModuleDTO(courseModuleDTO.getCourse_id(),courseModuleDTO.getModule_id()));
        return true;
    }

}
