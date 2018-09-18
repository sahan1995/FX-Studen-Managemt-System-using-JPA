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
import lk.ijse.sms.dao.custom.ExamDAO;
import lk.ijse.sms.entity.Exam;

/**
 *
 * @author Sahan Rajakaruna
 */
public class ExamDAOImpl extends CrudDAOImpl<Exam,Integer> implements ExamDAO {



//    @Override
//    public Exam findByID(Integer id) throws Exception {
//        ResultSet rs = CrudUtil.executeQuery("SELECT * FROM exam WHERE exam_id = ?", id);
//        if (rs.next()) {
//            return new Exam(rs.getInt(1), rs.getString(2), rs.getString(3));
//        } else {
//            return null;
//        }
//    }
//
//    @Override
//    public ArrayList<Exam> getAll() throws Exception {
//        ArrayList<Exam> allExams = new ArrayList<>();
//        ResultSet rs = CrudUtil.executeQuery("SELECT * FROM exam");
//        while (rs.next()) {
//            allExams.add(new Exam(rs.getInt(1), rs.getString(2), rs.getString(3)));
//        }
//        return allExams;
//    }
//
//    @Override
//    public boolean removeExam(String course_id, String module_code) throws Exception {
//        return CrudUtil.executeUpdate("DELETE FROM exam WHERE course_id = ? AND module_id = ?",course_id,module_code);
//    }

}
