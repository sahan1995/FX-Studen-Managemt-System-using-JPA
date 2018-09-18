/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.sms.business.custom;

import java.util.ArrayList;
import lk.ijse.sms.business.SuperBO;
import lk.ijse.sms.dto.ExamDTO;

/**
 *
 * @author Sahan Rajakaruna
 */
public interface ExamBO extends SuperBO {

    public boolean AddExam(ExamDTO exam) throws Exception;

    public boolean UpdateExam(ExamDTO exam) throws Exception;

    public boolean DeleteExam(String id) throws Exception;

    public ExamDTO findById(String id) throws Exception;

    public ArrayList<ExamDTO> allExam() throws Exception;

    public boolean RemoveExam(String course_id, String module_code) throws Exception;
    
    
}
