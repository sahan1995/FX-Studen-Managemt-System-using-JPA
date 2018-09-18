/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.sms.business.custom;

import java.util.ArrayList;
import lk.ijse.sms.business.SuperBO;
import lk.ijse.sms.dto.BatchDTO;
import lk.ijse.sms.dto.BatchExamDTO;
import lk.ijse.sms.dto.CustomDTO;

/**
 *
 * @author Sahan Rajakaruna
 */
public interface BatchBO extends SuperBO {

    public boolean RegisterBatch(BatchDTO batch) throws Exception;

    public boolean UpdateBatch(BatchDTO batch) throws Exception;

    public boolean DeleteBatch(String id) throws Exception;

    public BatchDTO findById(String id) throws Exception;

    public ArrayList<BatchDTO> allBatches() throws Exception;

    public ArrayList<String> findAllBachesByCourse(String courseID) throws Exception;

    public ArrayList<String> batchStudent(String batch_no) throws Exception;

    public ArrayList<BatchExamDTO> batchExams(String batch_no) throws Exception;

    public String getLastID() throws Exception;

    public int batchCount() throws Exception;

    public ArrayList<String> allBatchs() throws Exception;
    
    public ArrayList<CustomDTO> batchExam (String course_id) throws Exception;
    
    
}
