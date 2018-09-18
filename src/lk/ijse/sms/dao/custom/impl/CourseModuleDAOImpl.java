/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.sms.dao.custom.impl;

import java.sql.ResultSet;
import java.util.ArrayList;

import lk.ijse.sms.dao.CrudDAOImpl;
import lk.ijse.sms.dao.CrudUtil;
import lk.ijse.sms.dao.custom.CourseModuleDAO;
import lk.ijse.sms.entity.CourseModule;
import lk.ijse.sms.entity.CourseModule_PK;

/**
 *
 * @author Sahan Rajakaruna
 */
public class CourseModuleDAOImpl extends CrudDAOImpl<CourseModule,CourseModule_PK> implements CourseModuleDAO {

//    @Override
//    public CourseModule findByID(CourseModule_PK id) throws Exception {
//
//        ResultSet rs = CrudUtil.executeQuery("SELECT * FROM course_module WHERE course_id =? AND module_id = ?", id.getCourse_id(), id.getModule_id());
//        if (rs.next()) {
//            return new CourseModule(rs.getString(1), rs.getString(2));
//        } else {
//            return null;
//        }
//
//    }
//
//    @Override
//    public ArrayList<CourseModule> getAll() throws Exception {
//        ArrayList<CourseModule> allCourseModules = new ArrayList<>();
//        ResultSet rs = CrudUtil.executeQuery("SELECT * FROM course_module ");
//        while (rs.next()) {
//            allCourseModules.add(new CourseModule(rs.getString(1), rs.getString(2)));
//        }
//        return allCourseModules;
//
//    }
//
//    @Override
//    public boolean addCourseModule(String courseid, String... moduleId) throws Exception {
//        boolean result = false;
//        for (int i = 0; i < moduleId.length; i++) {
//            result = CrudUtil.executeUpdate("INSERT INTO course_module VALUES(?,?)", courseid, moduleId[i]);
//
//        }
//        if (result == true) {
//            return true;
//        } else {
//            return false;
//        }
//    }

}
