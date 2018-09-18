/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.sms.business.custom.impl;

import java.util.ArrayList;
import java.util.List;

import lk.ijse.sms.business.custom.StudentBatchBO;
import lk.ijse.sms.dao.DAOFactory;
import lk.ijse.sms.dao.custom.StudentBatchDAO;
import lk.ijse.sms.dto.StudentBatchDTO;
import lk.ijse.sms.entity.StudentBatch;
import lk.ijse.sms.entity.StudentBatch_PK;
import lk.ijse.sms.util.JPAUtil;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

/**
 *
 * @author Sahan Rajakaruna
 */
public class StudentBatchBOImpl implements StudentBatchBO {

    private StudentBatchDAO studentBatchDAO;
    private EntityManagerFactory entityManagerFactory;
    public StudentBatchBOImpl() {
        this.studentBatchDAO = (StudentBatchDAO) DAOFactory.getInstance().getDAO(DAOFactory.DAOTypes.student_batch);
        this.entityManagerFactory = JPAUtil.getEntityManagerFactory();
    }

    @Override
    public boolean AddStudentBatch(StudentBatchDTO studentBatch) throws Exception {

        try{
            EntityManager entityManager =
                    entityManagerFactory.createEntityManager();
            studentBatchDAO.setEntityManager(entityManager);
            entityManager.getTransaction().begin();
            studentBatchDAO.save(new StudentBatch(studentBatch.getId(),studentBatch.getBatch_bo()));
            entityManager.getTransaction().commit();
            return true;
        }catch (HibernateException ex){
            return false;
        }

    }

    @Override
    public boolean UpdateStudentBatch(StudentBatchDTO studentBatch) throws Exception {

        try {
            EntityManager entityManager =
                    entityManagerFactory.createEntityManager();
            studentBatchDAO.setEntityManager(entityManager);
            entityManager.getTransaction().begin();
            studentBatchDAO.update(new StudentBatch(studentBatch.getId(),studentBatch.getBatch_bo()));
            entityManager.getTransaction().commit();
            return true;
        }catch (HibernateException ex){
            return false;
        }

    }

    @Override
    public boolean DeleteStudentBatch(String sid, String batch_id) throws Exception {

        try {


            EntityManager entityManager =
                    entityManagerFactory.createEntityManager();


            studentBatchDAO.setEntityManager(entityManager);
            entityManager.getTransaction().begin();
            studentBatchDAO.delete(new StudentBatch_PK(sid,batch_id));
            entityManager.getTransaction().commit();
            return true;
        }catch (HibernateException ex){
            return false;
        }
    }

    @Override
    public StudentBatchDTO findById(String sid, String batch_id) throws Exception {

        try {
            EntityManager entityManager =
                    entityManagerFactory.createEntityManager();

            studentBatchDAO.setEntityManager(entityManager);
            entityManager.getTransaction().begin();
            StudentBatch student = studentBatchDAO.findByID(new StudentBatch_PK(sid, batch_id));
            entityManager.getTransaction().commit();
            return new StudentBatchDTO(student.getStudent().getSid(),student.getBatch().getBatch_no());
        }catch (HibernateException ex){
            return null;
        }
    }

    @Override
    public ArrayList<StudentBatchDTO> allStudentBatchs() throws Exception {

        try {
            EntityManager entityManager =
                    entityManagerFactory.createEntityManager();

            studentBatchDAO.setEntityManager(entityManager);
            entityManager.getTransaction().begin();
            List<StudentBatch> allStudentBatchEntity = studentBatchDAO.getAll();
            ArrayList<StudentBatchDTO> allStudentBatchDTO = new ArrayList<>();
            entityManager.getTransaction().commit();
            for (StudentBatch studentBatch : allStudentBatchEntity) {

                allStudentBatchDTO.add(new StudentBatchDTO(studentBatch.getStudentBatch_PK().getSid(), studentBatch.getStudentBatch_PK().getBatch_no()));

            }
            return allStudentBatchDTO;
            }catch (HibernateException ex){
            return null;
        }
    }

}
