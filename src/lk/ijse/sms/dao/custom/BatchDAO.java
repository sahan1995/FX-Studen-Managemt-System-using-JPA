/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.sms.dao.custom;

import java.util.ArrayList;
import lk.ijse.sms.dao.CrudDAO;
import lk.ijse.sms.entity.Batch;
import lk.ijse.sms.entity.BatchExam;

/**
 *
 * @author Sahan Rajakaruna
 */
public interface BatchDAO extends CrudDAO<Batch, String> {

    public ArrayList<String> getBatchesByCourse(String course_id) throws Exception;
//
    public ArrayList<String> batchStudents(String batch_no) throws Exception;
//
    public ArrayList<BatchExam> batchExams(String batch_no) throws Exception;
//
//    public String getLastID() throws Exception;
//
//    public int BatchCount() throws Exception;
//
//    public ArrayList<String> allBatches() throws Exception;
}
