/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.sms.business.custom;

import java.util.ArrayList;
import lk.ijse.sms.business.SuperBO;
import lk.ijse.sms.dto.ModuleDTO;

/**
 *
 * @author Sahan Rajakaruna
 */
public interface ModuleBO extends SuperBO {

    public boolean AddModule(ModuleDTO module) throws Exception;

    public boolean UpdateModule(ModuleDTO module) throws Exception;

    public boolean DeleteModule(String id) throws Exception;

    public ModuleDTO findById(String id) throws Exception;

    public ArrayList<ModuleDTO> allModules() throws Exception;

    public String generateCustomId() throws Exception;

    public ArrayList<String> getID(String... args) throws Exception;

    public ArrayList<String> getCourseModules(String course_id) throws Exception;

    public String getModuleID(String course_title) throws Exception;

    public int moduleCount() throws Exception;
}
