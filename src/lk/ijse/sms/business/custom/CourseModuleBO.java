/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.sms.business.custom;

import java.util.ArrayList;
import lk.ijse.sms.business.SuperBO;
import lk.ijse.sms.dto.CourseModuleDTO;

/**
 *
 * @author Sahan Rajakaruna
 */
public interface CourseModuleBO extends SuperBO {

    public boolean AddCourseModule(CourseModuleDTO courseModule) throws Exception;

    public boolean UpdateCourseModule(CourseModuleDTO courseModule) throws Exception;

    public boolean DeleteCourseModule(String course_id, String module_id) throws Exception;

    public CourseModuleDTO findById(String course_id, String module_id) throws Exception;

    public ArrayList<CourseModuleDTO> allCourseModules() throws Exception;

    public boolean addCourseModule(String courseid, String... moduleId) throws Exception;
}
