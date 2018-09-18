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
import lk.ijse.sms.dao.custom.StudentBatchDAO;
import lk.ijse.sms.dao.custom.StudentDAO;
import lk.ijse.sms.entity.Student;
import lk.ijse.sms.entity.StudentBatch;
import lk.ijse.sms.entity.StudentBatch_PK;

/**
 *
 * @author Sahan Rajakaruna
 */
public class StudentBatchDAOImpl extends CrudDAOImpl<StudentBatch,StudentBatch_PK> implements StudentBatchDAO {

//
//    @Override
//    public StudentBatch findByID(StudentBatch_PK id) throws Exception {
//
//        ResultSet rs = CrudUtil.executeQuery("SELECT * FROM student_batch WHERE sid = ? batch_no = ?", id.getSid(), id.getBatch_no());
//        if (rs.next()) {
//            return new StudentBatch(rs.getString(1), rs.getString(2));
//        } else {
//            return null;
//        }
//
//    }
//
//    @Override
//    public ArrayList<StudentBatch> getAll() throws Exception {
//        ArrayList<StudentBatch> allStudentBatchs = new ArrayList<>();
//        ResultSet rs = CrudUtil.executeQuery("SELECT * FROM student_batch");
//        while (rs.next()) {
//            allStudentBatchs.add(new StudentBatch(rs.getString(1), rs.getString(2)));
//        }
//        return allStudentBatchs;
//
//    }

}
