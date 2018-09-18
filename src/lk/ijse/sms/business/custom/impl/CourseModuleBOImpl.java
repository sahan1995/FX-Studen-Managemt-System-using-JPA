/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.sms.business.custom.impl;

import java.util.ArrayList;
import java.util.List;

import lk.ijse.sms.business.custom.CourseModuleBO;
import lk.ijse.sms.dao.DAOFactory;
import lk.ijse.sms.dao.custom.CourseModuleDAO;
import lk.ijse.sms.dto.CourseModuleDTO;
import lk.ijse.sms.entity.CourseModule;
import lk.ijse.sms.entity.CourseModule_PK;
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
public class CourseModuleBOImpl implements CourseModuleBO {

    private CourseModuleDAO courseModuleDAO;
    private EntityManagerFactory entityManagerFactory;
    public CourseModuleBOImpl() {
        this.courseModuleDAO = (CourseModuleDAO) DAOFactory.getInstance().getDAO(DAOFactory.DAOTypes.course_module);
        this.entityManagerFactory = JPAUtil.getEntityManagerFactory();
    }

    @Override
    public boolean AddCourseModule(CourseModuleDTO courseModule) throws Exception {
        System.out.println("HERE courseModule");
        try  {

            EntityManager entityManager =
                    entityManagerFactory.createEntityManager();



            courseModuleDAO.setEntityManager(entityManager);
            entityManager.getTransaction().begin();

            System.out.println(courseModule);
            courseModuleDAO.save(new CourseModule(courseModule.getCourse_id(),courseModule.getModule_id()));

            entityManager.getTransaction().commit();

            return true;
        }catch (HibernateException ex){
            System.out.println("HERE"+ex);
            return false;
        }


    }

    @Override
    public boolean UpdateCourseModule(CourseModuleDTO courseModule) throws Exception {

        try {


            EntityManager entityManager =
                    entityManagerFactory.createEntityManager();

            courseModuleDAO.setEntityManager(entityManager);
            entityManager.getTransaction().begin();
            courseModuleDAO.update(new CourseModule(courseModule.getCourse_id(),courseModule.getModule_id()));

            entityManager.getTransaction().commit();

            return true;
        }catch (HibernateException ex){
            return false;
        }
    }

    @Override
    public boolean DeleteCourseModule(String course_id, String module_id) throws Exception {

        try  {



            EntityManager entityManager =
                    entityManagerFactory.createEntityManager();

            courseModuleDAO.setEntityManager(entityManager);
            entityManager.getTransaction().begin();
            courseModuleDAO.delete(new CourseModule_PK(course_id,module_id));

            entityManager.getTransaction().commit();

            return true;
        }catch (HibernateException ex){
            return false;
        }
    }

    @Override
    public CourseModuleDTO findById(String course_id, String module_id) throws Exception {
        try {

            EntityManager entityManager =
                    entityManagerFactory.createEntityManager();


            courseModuleDAO.setEntityManager(entityManager);
            entityManager.getTransaction().begin();

            CourseModule courseModule = courseModuleDAO.findByID(new CourseModule_PK(course_id, module_id));
            entityManager.getTransaction().commit();

            return new CourseModuleDTO(courseModule.getCourseModule_PK().getCourse_id(),courseModule.getCourseModule_PK().getModule_id());
        }catch (HibernateException ex){
            return null;
        }

    }

    @Override
    public ArrayList<CourseModuleDTO> allCourseModules() throws Exception {
        ArrayList<CourseModuleDTO> allCourseModuleDTO = new ArrayList<>();
        try {

            EntityManager entityManager =
                    entityManagerFactory.createEntityManager();

            courseModuleDAO.setEntityManager(entityManager);
            entityManager.getTransaction().begin();

            List<CourseModule> allCourseModulesEntity = courseModuleDAO.getAll();
            entityManager.getTransaction().commit();
            for (CourseModule courseModule : allCourseModulesEntity) {
                allCourseModuleDTO.add(new CourseModuleDTO(courseModule.getCourseModule_PK().getCourse_id(), courseModule.getCourseModule_PK().getModule_id()));
            }
            return allCourseModuleDTO;
        }catch (HibernateException ex){
            return null;
        }
    }

    @Override
    public boolean addCourseModule(String courseid, String... moduleId) throws Exception {
//        return courseModuleDAO.addCourseModule(courseid, moduleId);
        return false;
    }

}
