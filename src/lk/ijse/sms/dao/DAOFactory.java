/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.sms.dao;

import lk.ijse.sms.dao.custom.impl.BatchDAOImpl;
import lk.ijse.sms.dao.custom.impl.CourseDAOImpl;
import lk.ijse.sms.dao.custom.impl.CourseModuleDAOImpl;
import lk.ijse.sms.dao.custom.impl.ExamDAOImpl;
import lk.ijse.sms.dao.custom.impl.ModuleDAOImpl;
import lk.ijse.sms.dao.custom.impl.QueryDAOImpl;
import lk.ijse.sms.dao.custom.impl.StudentBatchDAOImpl;
import lk.ijse.sms.dao.custom.impl.StudentDAOImpl;
import lk.ijse.sms.dao.custom.impl.StudentExamDAOImpl;

/**
 *
 * @author Sahan Rajakaruna
 */
public class DAOFactory {

    private static DAOFactory getDAOFactory;

    private DAOFactory() {

    }

    public static DAOFactory getInstance() {
        if (getDAOFactory == null) {
            getDAOFactory = new DAOFactory();
        }
        return getDAOFactory;
    }

    public enum DAOTypes {
        student, course, batch, module, student_batch, course_module, exam, student_exam, querydao;
    }

    public SuperDAO getDAO(DAOTypes dAOType) {
        switch (dAOType) {
            case student:
                return new StudentDAOImpl();

            case course:
                return new CourseDAOImpl();
            case batch:
                return new BatchDAOImpl();
            case module:
                return new ModuleDAOImpl();
            case student_batch:
                return new StudentBatchDAOImpl();
            case course_module:
                return new CourseModuleDAOImpl();
            case exam:
                return new ExamDAOImpl();
            case student_exam:
                return new StudentExamDAOImpl();
            case querydao:
                return new QueryDAOImpl();
            default:
                return null;
        }
    }
}
