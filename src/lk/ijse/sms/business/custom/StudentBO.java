/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.sms.business.custom;

import java.util.ArrayList;
import lk.ijse.sms.business.SuperBO;
import lk.ijse.sms.dto.StudentCourseDTO;
import lk.ijse.sms.dto.StudentDTO;

/**
 *
 * @author Sahan Rajakaruna
 */
public interface StudentBO extends SuperBO {

    public boolean RegisterStudent(StudentDTO student) throws Exception;

    public boolean UpdateStudent(StudentDTO student) throws Exception;

    public boolean DeleteStudent(String id) throws Exception;

    public StudentDTO findById(String id) throws Exception;

    public ArrayList<StudentDTO> allStudents() throws Exception;

    public String generateCustomId() throws Exception;

    public ArrayList<StudentCourseDTO> studentCourse(String sid) throws Exception;

    public int getStudentCount() throws Exception;
    
     public ArrayList<String> getStudentBatch(String sid) throws Exception;
}
