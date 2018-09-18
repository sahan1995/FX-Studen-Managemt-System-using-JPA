/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.sms.dao.custom;

import java.util.ArrayList;
import lk.ijse.sms.dao.SuperDAO;
import lk.ijse.sms.entity.CustomEntity;

/**
 *
 * @author Sahan Rajakaruna
 */
public interface QueryDAO extends SuperDAO {

    public ArrayList<CustomEntity> batchExam(String batch_no) throws Exception;
}
