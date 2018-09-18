/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.sms.dao.custom;

import java.util.ArrayList;
import lk.ijse.sms.dao.CrudDAO;
import lk.ijse.sms.entity.Module;

/**
 *
 * @author Sahan Rajakaruna
 */
public interface ModuleDAO extends CrudDAO<Module, String> {

//    public String getLastID() throws Exception;
//
    public ArrayList<String> getModuleId(String... args) throws Exception;
//
    public ArrayList<String> getModules(String course_id) throws Exception;
//
//    public String getModuleId(String moduleName) throws Exception;
//
//     public int moduleCount() throws Exception;

}
