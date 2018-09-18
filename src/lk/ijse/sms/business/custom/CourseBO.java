/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.sms.business.custom;

import java.util.ArrayList;
import lk.ijse.sms.business.SuperBO;
import lk.ijse.sms.dto.CourseDTO;
import lk.ijse.sms.dto.StudentDTO;

/**
 *
 * @author Sahan Rajakaruna
 */
public interface CourseBO extends SuperBO {

    public boolean RegisterCourse(CourseDTO course) throws Exception;

    public boolean UpdateCourse(CourseDTO course) throws Exception;

    public boolean DeleteCourse(String id) throws Exception;

    public CourseDTO findById(String id) throws Exception;

    public ArrayList<CourseDTO> allCourses() throws Exception;

    public String findIdByTitle(String courseTitle) throws Exception;

    public String generateCoutomID() throws Exception;

    public int courseCount() throws Exception;

    public String getCoursrId(String batch_no) throws Exception;
}
