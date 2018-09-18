/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.sms.dao.custom.impl;

import java.util.ArrayList;
import java.util.List;

import lk.ijse.sms.dao.CrudDAOImpl;
import lk.ijse.sms.dao.custom.BatchDAO;
import lk.ijse.sms.entity.Batch;
import lk.ijse.sms.entity.BatchExam;
import lk.ijse.sms.util.JPAUtil;
import org.hibernate.Session;
import org.hibernate.query.NativeQuery;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

/**
 *
 * @author Sahan Rajakaruna
 */
public class BatchDAOImpl extends CrudDAOImpl<Batch,String> implements BatchDAO {


    private EntityManagerFactory entityManagerFactory;

    public BatchDAOImpl() {
        entityManagerFactory = JPAUtil.getEntityManagerFactory();

    }

    //
//
//    @Override
//    public Batch findByID(String id) throws Exception {
//
//        ResultSet rs = CrudUtil.executeQuery("SELECT * FROM batch WHERE batch_no = ?", id);
//        if (rs.next()) {
//            return new Batch(rs.getString(1), rs.getBigDecimal(2), rs.getString(3));
//        } else {
//            return null;
//        }
//    }
//
//    @Override
//    public ArrayList<Batch> getAll() throws Exception {
//
//        ArrayList<Batch> getBatchs = new ArrayList<>();
//
//        ResultSet rs = CrudUtil.executeQuery("SELECT * FROM batch");
//        while (rs.next()) {
//            getBatchs.add(new Batch(rs.getString(1), rs.getBigDecimal(2), rs.getString(3)));
//
//        }
//        return getBatchs;
//    }
//
    @Override
    public ArrayList<String> getBatchesByCourse(String course_id) throws Exception {


        EntityManager entityManager =
                entityManagerFactory.createEntityManager();
        System.out.println(course_id);
        NativeQuery query = (NativeQuery) entityManager.createNativeQuery(" SELECT batch_no FROM Batch WHERE courseID= :id");
        query.setParameter("id",course_id);
        return (ArrayList<String>) query.list();

    }

    @Override
    public ArrayList<String> batchStudents(String batch_no) throws Exception {
        ArrayList<String> batchStudents = new ArrayList<>();
        EntityManager entityManager =
                entityManagerFactory.createEntityManager();

        NativeQuery nativeQuery = (NativeQuery) entityManager.createNativeQuery("SELECT s.fname,s.lname, s.sid FROM Student s INNER JOIN newStu.StudentBatch sb ON sb.sid=s.sid WHERE sb.batch_no=:id");
        nativeQuery.setParameter("id",batch_no);
        List<Object[]> list = nativeQuery.list();

        list.forEach(cols -> {
            batchStudents.add(cols[2] + " -  " + cols[0] + " " + cols[1] );
        });
        return batchStudents;
    }

    @Override
    public ArrayList<BatchExam> batchExams(String batch_no) throws Exception {
        ArrayList<BatchExam> batchExams = new ArrayList<>();
        EntityManager entityManager =
                entityManagerFactory.createEntityManager();


        NativeQuery nativeQuery = (NativeQuery) entityManager.createNativeQuery("SELECT DISTINCT m.module_id AS Module_code, m.modulename AS Exam_Module,C.course_id,e.exam_id FROM Module m INNER JOIN Exam e ON e.moduleID= m.module_id INNER JOIN Course c ON e.course_id=c.course_id INNER JOIN Batch b on c.course_id = b.course_id INNER JOIN StudentBatch sb ON sb.batch_no = b.batch_no where C.course_id=:id");
        nativeQuery.setParameter("id",batch_no);
        List list = nativeQuery.list();
        System.out.println(list);


       /* ResultSet rs = CrudUtil.executeQuery("SELECT DISTINCT m.module_id AS Module_code, m.modulename AS Exam_Module,C.course_id,e.exam_id FROM module m INNER JOIN exam e ON e.module_id= m.module_id INNER JOIN course c ON e.course_id=c.course_id INNER JOIN batch b on c.course_id = b.course_id INNER JOIN student_batch sb ON sb.batch_no = b.batch_no where C.course_id=?", batch_no);


        while (rs.next()) {
            batchExams.add(new BatchExam(rs.getInt(4), rs.getString(2)));
        }*/

        return batchExams;
    }
//
//    @Override
//    public String getLastID() throws Exception {
//        ResultSet rs = CrudUtil.executeQuery("SELECT batch_no FROM batch ORDER BY batch_no DESC LIMIT 1");
//        if (rs.next()) {
//            return rs.getString(1);
//        } else {
//            return null;
//        }
//    }
//
//    @Override
//    public int BatchCount() throws Exception {
//        ResultSet rs = CrudUtil.executeQuery("SELECT COUNT(*) FROM batch");
//        if (rs.next()) {
//            return rs.getInt(1);
//        } else {
//            return 0;
//        }
//    }
//
//    @Override
//    public ArrayList<String> allBatches() throws Exception {
//
//        ResultSet rs = CrudUtil.executeQuery("select batch_no from batch ");
//        ArrayList<String> batches = new ArrayList<>();
//        while (rs.next()) {
//            batches.add(rs.getString(1));
//        }
//        return batches;
//    }

}
