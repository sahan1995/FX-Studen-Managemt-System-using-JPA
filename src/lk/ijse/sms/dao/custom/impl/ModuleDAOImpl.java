/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.sms.dao.custom.impl;

import java.util.ArrayList;
import java.util.List;

import lk.ijse.sms.dao.CrudDAOImpl;
import lk.ijse.sms.dao.custom.ModuleDAO;
import lk.ijse.sms.entity.Module;
import lk.ijse.sms.util.JPAUtil;
import org.hibernate.Session;
import org.hibernate.query.NativeQuery;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

/**
 *
 * @author Sahan Rajakaruna
 */
public class ModuleDAOImpl extends CrudDAOImpl<Module,String> implements ModuleDAO {

    private EntityManagerFactory entityManagerFactory;

    public ModuleDAOImpl() {
        entityManagerFactory = JPAUtil.getEntityManagerFactory();
    }

    //
//    @Override
//    public Module findByID(String id) throws Exception {
//
//        ResultSet rs = CrudUtil.executeQuery("SELECT * FROM module WHERE module_id =? ", id);
//        if (rs.next()) {
//            return new Module(rs.getString(1), rs.getString(2));
//        } else {
//            return null;
//        }
//
//    }
//
//    @Override
//    public ArrayList<Module> getAll() throws Exception {
//
//        ArrayList<Module> allModules = new ArrayList<>();
//        ResultSet rs = CrudUtil.executeQuery("SELECT * FROM module");
//        while (rs.next()) {
//            allModules.add(new Module(rs.getString(1), rs.getString(2)));
//        }
//        return allModules;
//    }
//
//    @Override
//    public String getLastID() throws Exception {
//        ResultSet rs = CrudUtil.executeQuery("SELECT module_id FROM module ORDER BY module_id DESC LIMIT 1");
//        if (rs.next()) {
//            return rs.getString(1);
//        } else {
//            return null;
//        }
//    }
//
//    @Override
    public ArrayList<String> getModuleId(String... args) throws Exception {

        EntityManager entityManager =
                entityManagerFactory.createEntityManager();

        ArrayList<String> getId = new ArrayList<>();
        List<?> list=null;
        for (int i = 0; i < args.length; i++) {
            NativeQuery nativeQuery = (NativeQuery) entityManager.createNativeQuery("SELECT module_id FROM Module WHERE module_name =:id");
            nativeQuery.setParameter("id",args[i]);
             list = nativeQuery.list();
        }
        return (ArrayList<String>) list;
    }

    @Override
    public ArrayList<String> getModules(String course_id) throws Exception {
        System.out.println("Im Here");
        ArrayList<String> courseModules  = new ArrayList<>();
        EntityManager entityManager =
                entityManagerFactory.createEntityManager();

        NativeQuery nativeQuery = (NativeQuery) entityManager.createNativeQuery("SELECT m.module_name from Module m INNER JOIN CourseModule cm ON m.module_id =cm.module_id WHERE cm.course_id=:id");
        nativeQuery.setParameter("id",course_id);
        List list = nativeQuery.list();

        for (Object modules : list) {
            courseModules.add(modules+"");
        }
        return courseModules;
    }
//
//    @Override
//    public String getModuleId(String moduleName) throws Exception {
//        ResultSet rs = CrudUtil.executeQuery("SELECT module_id FROM module WHERE modulename = ?", moduleName);
//        if(rs.next()){
//            return rs.getString(1);
//        }else{
//            return null;
//        }
//    }
//
//    @Override
//    public int moduleCount() throws Exception {
//         ResultSet rs = CrudUtil.executeQuery("SELECT COUNT(*) FROM module");
//        if (rs.next()) {
//            return rs.getInt(1);
//        } else {
//            return 0;
//        }
//    }

}
