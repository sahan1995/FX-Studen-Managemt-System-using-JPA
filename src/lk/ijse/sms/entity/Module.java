/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.sms.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 *
 * @author Sahan Rajakaruna
 */
@Entity
public class Module {

    /**
     * @return the module_id
     */
    public String getModule_id() {
        return module_id;
    }

    /**
     * @param module_id the module_id to set
     */
    public void setModule_id(String module_id) {
        this.module_id = module_id;
    }

    /**
     * @return the module_name
     */
    public String getModule_name() {
        return module_name;
    }

    /**
     * @param module_name the module_name to set
     */
    public void setModule_name(String module_name) {
        this.module_name = module_name;
    }
    @Id
    private String module_id;
    private String module_name;

    public Module(String module_id) {
        this.module_id = module_id;
    }

    public Module() {
    }

    public Module(String module_id, String module_name) {
        this.module_id = module_id;
        this.module_name = module_name;
    }

    @Override
    public String toString() {
        return "Module{" + "module_id=" + module_id + ", module_name=" + module_name + '}';
    }
    
}
