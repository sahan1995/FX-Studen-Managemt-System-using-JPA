/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.sms.view.util.tbmodel;

/**
 *
 * @author Sahan Rajakaruna
 */
public class ModuleTbModel {

    /**
     * @return the moduleCode
     */
    public String getModuleCode() {
        return moduleCode;
    }

    /**
     * @param moduleCode the moduleCode to set
     */
    public void setModuleCode(String moduleCode) {
        this.moduleCode = moduleCode;
    }

    /**
     * @return the moduleName
     */
    public String getModuleName() {
        return moduleName;
    }

    /**
     * @param moduleName the moduleName to set
     */
    public void setModuleName(String moduleName) {
        this.moduleName = moduleName;
    }
    private String moduleCode;
    private String moduleName;

    public ModuleTbModel() {
    }

    public ModuleTbModel(String moduleCode, String moduleName) {
        this.moduleCode = moduleCode;
        this.moduleName = moduleName;
    }

    @Override
    public String toString() {
        return "ModuleTbModel{" + "moduleCode=" + moduleCode + ", moduleName=" + moduleName + '}';
    }
    
}
