/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.sms.business.custom;

import java.util.ArrayList;
import lk.ijse.sms.business.SuperBO;
import lk.ijse.sms.dto.StudentBatchDTO;

/**
 *
 * @author Sahan Rajakaruna
 */
public interface StudentBatchBO extends SuperBO {

    public boolean AddStudentBatch(StudentBatchDTO studentBatch) throws Exception;

    public boolean UpdateStudentBatch(StudentBatchDTO studentBatch) throws Exception;

    public boolean DeleteStudentBatch(String sid, String batch_id) throws Exception;

    public StudentBatchDTO findById(String sid, String batch_id) throws Exception;

    public ArrayList<StudentBatchDTO> allStudentBatchs() throws Exception;

}
