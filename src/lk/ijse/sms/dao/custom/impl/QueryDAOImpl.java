/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.sms.dao.custom.impl;


import java.util.ArrayList;
import java.util.List;

import lk.ijse.sms.dao.custom.QueryDAO;
import lk.ijse.sms.entity.CustomEntity;
import org.hibernate.Session;
import org.hibernate.query.NativeQuery;

import javax.persistence.EntityManager;

/**
 *
 * @author Sahan Rajakaruna
 */
public class QueryDAOImpl implements QueryDAO {

    @Override
    public ArrayList<CustomEntity> batchExam(String batch_no) throws Exception {
//        ArrayList<CustomEntity> alExams = new ArrayList<>();
//        Session session = HibernateUtil.getSessionFactory().openSession();
//
//        NativeQuery nativeQuery = session.createNativeQuery("SELECT DISTINCT m.module_id AS Module_code, m.module_name AS Exam_Module,c.course_id,e.exam_id FROM Module m INNER JOIN Exam e ON e.moduleID= m.module_id INNER JOIN Course c ON e.course_id=c.course_id INNER JOIN Batch b on c.course_id = b.courseID INNER JOIN StudentBatch sb ON sb.batch_no = b.batch_no where c.course_id=:id");
//
//        nativeQuery.setParameter("id",batch_no);
//        List<Object[]> list = nativeQuery.list();
//        list.forEach(cols->{
//            CustomEntity customEntity = new CustomEntity(Integer.parseInt(cols[3] + ""), cols[1] + "");
//            alExams.add(customEntity);
//
//        });
//        return alExams;
        return null;
    }


    @Override
    public void setEntityManager(EntityManager entityManager) {

    }
}
