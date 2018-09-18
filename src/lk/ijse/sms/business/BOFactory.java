/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.sms.business;

import lk.ijse.sms.business.custom.StudentRegisterBO;
import lk.ijse.sms.business.custom.impl.BatchBOImpl;
import lk.ijse.sms.business.custom.impl.CourseBOImpl;
import lk.ijse.sms.business.custom.impl.CourseModuleBOImpl;
import lk.ijse.sms.business.custom.impl.ExamBOImpl;
import lk.ijse.sms.business.custom.impl.ModuleBOImpl;
import lk.ijse.sms.business.custom.impl.RegisterCourseBOImpl;
import lk.ijse.sms.business.custom.impl.RegistrationBOImpl;
import lk.ijse.sms.business.custom.impl.StudentBatchBOImpl;
import lk.ijse.sms.business.custom.impl.StudentExamBOImpl;
//import lk.ijse.sms.business.custom.impl.StudentRegisterBOImpl;
import lk.ijse.sms.business.custom.impl.StundetBOImpl;

/**
 *
 * @author Sahan Rajakaruna
 */
public class BOFactory {

    private static BOFactory getBOFactory;

    private BOFactory() {

    }

    public static BOFactory getInstance() {
        if (getBOFactory == null) {
            getBOFactory = new BOFactory();
        }
        return getBOFactory;
    }

    public enum BOTypes {
        batch, course, exam, module, student_batch, course_module, student_exam, student, student_register, course_register;
    }

    public SuperBO getBO(BOTypes bOType) {
        switch (bOType) {
            case batch:
                return new BatchBOImpl();
            case course:
                return new CourseBOImpl();
            case course_module:
                return new CourseModuleBOImpl();
            case exam:
                return new ExamBOImpl();
            case module:
                return new ModuleBOImpl();
            case student:
                return new StundetBOImpl();
            case student_batch:
                return new StudentBatchBOImpl();
            case student_exam:
                return new StudentExamBOImpl();
            case student_register:
                return new RegistrationBOImpl();
            case course_register:
                return new RegisterCourseBOImpl();
            default:
                return null;

        }
    }
}
