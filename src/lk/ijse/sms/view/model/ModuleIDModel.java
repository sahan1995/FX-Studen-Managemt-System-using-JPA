/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.sms.view.model;

/**
 *
 * @author Sahan Rajakaruna
 */
public class ModuleIDModel {

    /**
     * @return the id
     */
    public String getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(String id) {
        this.id = id;
    }
    private static String id;

    public ModuleIDModel() {
    }

    public ModuleIDModel(String id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "" + id + ",";
    }

    public static String toArgs() {
        return "" + id + ",";
    }
}
