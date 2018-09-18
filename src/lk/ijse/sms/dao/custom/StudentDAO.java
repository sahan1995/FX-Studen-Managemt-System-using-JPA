/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.sms.dao.custom;

import java.util.ArrayList;
import lk.ijse.sms.dao.CrudDAO;
import lk.ijse.sms.entity.Student;
import lk.ijse.sms.entity.StudentCourse;

/**
 *
 * @author Sahan Rajakaruna
 */
public interface StudentDAO extends CrudDAO<Student, String> {


//    public String getLastID() throws Exception;
//
    public ArrayList<StudentCourse> getStudentCourses(String sid) throws Exception;
//
//    public int studentCount() throws Exception;
//
//    public ArrayList<String> getStudentBatch(String sid) throws Exception;
    
}
