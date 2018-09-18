/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.sms.business.custom;

import java.util.ArrayList;
import lk.ijse.sms.business.SuperBO;
import lk.ijse.sms.dto.StudentExamDTO;

/**
 *
 * @author Sahan Rajakaruna
 */
public interface StudentExamBO extends SuperBO {

    public boolean AddStudentExam(StudentExamDTO studentExam) throws Exception;

    public boolean UpdateStudentExam(StudentExamDTO studentExam) throws Exception;

    public boolean DeleteStudentExam(String sid, int exam_id) throws Exception;

    public StudentExamDTO FindbyID(String sid, int exam_id) throws Exception;

    public ArrayList<StudentExamDTO> allStudentExamD() throws Exception;
}
