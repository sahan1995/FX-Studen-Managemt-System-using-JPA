/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.sms.dao.custom;

import lk.ijse.sms.dao.CrudDAO;
import lk.ijse.sms.entity.Course;
//import sun.text.normalizer.UBiDiProps;

/**
 *
 * @author Sahan Rajakaruna
 */
public interface CourseDAO extends CrudDAO<Course, String> {

    public String getIDByTitle(String courseTitle) throws Exception;
//
//    public String getLastID() throws Exception;
//
//    public int CourseCount() throws Exception;
//
//    public String courseId(String Batch_no) throws Exception;
}
