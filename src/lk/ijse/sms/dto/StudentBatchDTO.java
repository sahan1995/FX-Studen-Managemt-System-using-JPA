/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.sms.dto;

/**
 *
 * @author Sahan Rajakaruna
 */
public class StudentBatchDTO {
    
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

    /**
     * @return the batch_bo
     */
    public String getBatch_bo() {
        return batch_bo;
    }

    /**
     * @param batch_bo the batch_bo to set
     */
    public void setBatch_bo(String batch_bo) {
        this.batch_bo = batch_bo;
    }
    private String id;
    private String batch_bo;

    public StudentBatchDTO() {
    }

    public StudentBatchDTO(String id, String batch_bo) {
        this.id = id;
        this.batch_bo = batch_bo;
    }

    @Override
    public String toString() {
        return "StudentBatchDTO{" + "id=" + id + ", batch_bo=" + batch_bo + '}';
    }
    
    
}
