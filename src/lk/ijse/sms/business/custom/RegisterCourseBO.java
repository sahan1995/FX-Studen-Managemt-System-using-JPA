/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.sms.business.custom;

import lk.ijse.sms.business.SuperBO;
import lk.ijse.sms.dto.CourseDTO;
import lk.ijse.sms.dto.CourseModuleDTO;
import lk.ijse.sms.dto.ExamDTO;

/**
 *
 * @author Sahan Rajakaruna
 */
public interface RegisterCourseBO extends SuperBO {

    public boolean registerCourse(CourseDTO course) throws Exception;
    public boolean coueseExam(ExamDTO exam,boolean bool) throws Exception;
    public boolean addCourseModules(CourseModuleDTO course_module) throws Exception;
    public boolean addExamandModule(ExamDTO examDTO,CourseModuleDTO courseModuleDTO) throws Exception;
    
}
