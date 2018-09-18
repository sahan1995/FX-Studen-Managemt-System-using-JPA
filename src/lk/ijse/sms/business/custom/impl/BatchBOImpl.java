/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.sms.business.custom.impl;

import lk.ijse.sms.business.custom.BatchBO;
import lk.ijse.sms.dao.DAOFactory;
import lk.ijse.sms.dao.custom.BatchDAO;
import lk.ijse.sms.dao.custom.QueryDAO;
import lk.ijse.sms.dto.BatchDTO;
import lk.ijse.sms.dto.BatchExamDTO;
import lk.ijse.sms.dto.CustomDTO;
import lk.ijse.sms.entity.Batch;
import lk.ijse.sms.entity.Course;
import lk.ijse.sms.entity.CustomEntity;
import lk.ijse.sms.util.JPAUtil;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Sahan Rajakaruna
 */
public class BatchBOImpl implements BatchBO {

    private BatchDAO batchDAO;
    private QueryDAO queryDAO;
    private EntityManagerFactory entityManagerFactory;

    public BatchBOImpl() {
        this.queryDAO = (QueryDAO) DAOFactory.getInstance().getDAO(DAOFactory.DAOTypes.querydao);
        this.batchDAO = (BatchDAO) DAOFactory.getInstance().getDAO(DAOFactory.DAOTypes.batch);
        this.entityManagerFactory = JPAUtil.getEntityManagerFactory();
    }

    @Override
    public boolean RegisterBatch(BatchDTO batch) throws Exception {


        EntityManager entityManager = entityManagerFactory.createEntityManager();


        batchDAO.setEntityManager(entityManager);
        entityManager.getTransaction().begin();

        Course course = entityManager.find(Course.class, batch.getCourse_id());
        batchDAO.save(new Batch(batch.getBatch_no(), batch.getFee(), course));
        entityManager.getTransaction().commit();
        return true;

    }


    @Override
    public boolean UpdateBatch(BatchDTO batch) throws Exception {

        EntityManager entityManager = entityManagerFactory.createEntityManager();

        batchDAO.setEntityManager(entityManager);
        entityManager.getTransaction();
        Course course = entityManager.find(Course.class, batch.getCourse_id());
        batchDAO.update(new Batch(batch.getBatch_no(), batch.getFee(), course));
        entityManager.getTransaction().commit();
        return true;

    }


    @Override
    public boolean DeleteBatch(String id) throws Exception {

        try{
            EntityManager entityManager = entityManagerFactory.createEntityManager();
            batchDAO.setEntityManager(entityManager);
            entityManager.getTransaction();
            batchDAO.delete(id);
            entityManager.getTransaction().commit();
            return true;        }
        catch (HibernateException ex){
            return false;
        }



    }

    @Override
    public BatchDTO findById(String id) throws Exception {
        try {
            EntityManager entityManager = entityManagerFactory.createEntityManager();
            batchDAO.setEntityManager(entityManager);
            entityManager.getTransaction().begin();
            Batch batch = batchDAO.findByID(id);
            entityManager.getTransaction().commit();
            System.out.println(batch);
            return new BatchDTO(batch.getBatch_no(), batch.getFee(), batch.getCourse().getCourse_id());
        } catch (HibernateException ex) {
            return null;
        }
    }

    @Override
    public ArrayList<BatchDTO> allBatches() throws Exception {
        ArrayList<BatchDTO> AllBatchDTO = new ArrayList<>();

        try  {

            EntityManager entityManager = entityManagerFactory.createEntityManager();

            batchDAO.setEntityManager(entityManager);
            entityManager.getTransaction();
            List<Batch> allBatches = batchDAO.getAll();
            entityManager.getTransaction().commit();
            for (Batch batch : allBatches) {

                AllBatchDTO.add(new BatchDTO(batch.getBatch_no(), batch.getFee(), batch.getCourse().getCourse_id()));
            }
            return AllBatchDTO;
        } catch (HibernateException ex) {
            return null;
        }

    }

    @Override
    public ArrayList<String> findAllBachesByCourse(String courseID) throws Exception {
        return batchDAO.getBatchesByCourse(courseID);
    }

    @Override
    public ArrayList<String> batchStudent(String batch_no) throws Exception {
        return batchDAO.batchStudents(batch_no);
    }

    @Override
    public ArrayList<BatchExamDTO> batchExams(String batch_no) throws Exception {


//        ArrayList<BatchExam> batchExamsEntity = batchDAO.batchExams(batch_no);
//        ArrayList<BatchExamDTO> batchExam = new ArrayList<>();
//        for (BatchExam batchExamEn : batchExamsEntity) {
//            batchExam.add(new BatchExamDTO(batchExamEn.getExam_id(), batchExamEn.getExam_module()));
//        }
//        return batchExam;
        return null;

    }

    @Override
    public String getLastID() throws Exception {
//        return batchDAO.getLastID();
        return null;
    }

    @Override
    public int batchCount() throws Exception {
//        return batchDAO.BatchCount();
        return 0;
    }

    @Override
    public ArrayList<String> allBatchs() throws Exception {
//        return batchDAO.allBatches();
        return null;
    }

    @Override
    public ArrayList<CustomDTO> batchExam(String course_id) throws Exception {


        ArrayList<CustomEntity> batchExam = queryDAO.batchExam(course_id);
        ArrayList<CustomDTO> exam = new ArrayList<>();
        for (CustomEntity customEntity : batchExam) {
            exam.add(new CustomDTO(customEntity.getExam_id(), customEntity.getModule_name()));
        }
        return exam;
    }

}
