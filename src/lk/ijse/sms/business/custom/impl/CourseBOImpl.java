/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.sms.business.custom.impl;

import lk.ijse.sms.business.custom.CourseBO;
import lk.ijse.sms.dao.DAOFactory;
import lk.ijse.sms.dao.custom.CourseDAO;
import lk.ijse.sms.dto.CourseDTO;
import lk.ijse.sms.entity.Course;
import lk.ijse.sms.util.JPAUtil;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Sahan Rajakaruna
 */
public class CourseBOImpl implements CourseBO {

    private CourseDAO courseDAO;
    private EntityManagerFactory entityManagerFactory;

    public CourseBOImpl() {
        this.courseDAO = (CourseDAO) DAOFactory.getInstance().getDAO(DAOFactory.DAOTypes.course);
        this.entityManagerFactory = JPAUtil.getEntityManagerFactory();

        System.out.println(entityManagerFactory);
    }

    @Override
    public boolean RegisterCourse(CourseDTO course) throws Exception {
        try {

            EntityManager entityManager =
                    entityManagerFactory.createEntityManager();


            courseDAO.setEntityManager(entityManager);
            entityManager.getTransaction().begin();

            courseDAO.save(new Course(course.getCourse_id(), course.getCourse_title(), course.getDuration()));

            entityManager.getTransaction().commit();
            return true;

        } catch (HibernateException ex) {
            System.out.println("HERE");
            return false;
        }

    }

    @Override
    public boolean UpdateCourse(CourseDTO course) throws Exception {
        try  {

            EntityManager entityManager =
                    entityManagerFactory.createEntityManager();

            courseDAO.setEntityManager(entityManager);
            entityManager.getTransaction().begin();

            courseDAO.update(new Course(course.getCourse_id(), course.getCourse_title(), course.getDuration()));


            entityManager.getTransaction().commit();
            return true;

        } catch (HibernateException ex) {
            return false;
        }
    }

    @Override
    public boolean DeleteCourse(String id ) throws Exception {
        try {

            EntityManager entityManager =
                    entityManagerFactory.createEntityManager();
            courseDAO.setEntityManager(entityManager);
            entityManager.getTransaction().begin();
            courseDAO.delete(id);
            entityManager.getTransaction().commit();
            return true;

        } catch (HibernateException ex) {
            return false;
        }
    }

    @Override
    public CourseDTO findById(String id) throws Exception {
        try  {


            EntityManager entityManager =
                    entityManagerFactory.createEntityManager();

            courseDAO.setEntityManager(entityManager);
            entityManager.getTransaction().begin();

            Course courseEntity = courseDAO.findByID(id);
            entityManager.getTransaction().commit();

            return  new CourseDTO(courseEntity.getCourse_id(),courseEntity.getCourse_title(),courseEntity.getDuration());


        } catch (HibernateException ex) {
            return null;
        }


    }

    @Override
    public ArrayList<CourseDTO> allCourses() throws Exception {

        ArrayList<CourseDTO> allCourseDTO = new ArrayList<>();
        try  {

            EntityManager entityManager =
                    entityManagerFactory.createEntityManager();


            courseDAO.setEntityManager(entityManager);
            entityManager.getTransaction().begin();
            List<Course> courseEntity = courseDAO.getAll();

            entityManager.getTransaction().commit();
            for (Course course : courseEntity) {

                allCourseDTO.add(new CourseDTO(course.getCourse_id(), course.getCourse_title(), course.getDuration()));

            }
            return allCourseDTO;

        } catch (HibernateException ex) {
            return null;
        }
    }

    @Override
    public String findIdByTitle(String courseTitle) throws Exception {

        return courseDAO.getIDByTitle(courseTitle);

    }

    @Override
    public String generateCoutomID() throws Exception {
//
//        String id = courseDAO.getLastID();
//        String[] part = id.split("C");
//        int no = Integer.parseInt(part[1]);
//        no++;
//        String customID = "C" + formatNumber(no);
//        System.out.println(customID);
//        return customID;
        return null;

    }

    private String formatNumber(long number) {
        NumberFormat nf = NumberFormat.getInstance();

        nf.setGroupingUsed(false);
        nf.setMaximumFractionDigits(0);
        nf.setMinimumFractionDigits(0);
        nf.setMaximumIntegerDigits(3);
        nf.setMinimumIntegerDigits(3);

        return nf.format(number);
    }

    @Override
    public int courseCount() throws Exception {
//        return courseDAO.CourseCount();
        return 0;
    }

    @Override
    public String getCoursrId(String batch_no) throws Exception {

//        return courseDAO.courseId(batch_no);
        return null;
    }

}
