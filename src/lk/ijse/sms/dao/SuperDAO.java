/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.sms.dao;

import org.hibernate.Session;

import javax.persistence.EntityManager;

/**
 *
 * @author Sahan Rajakaruna
 */
public interface SuperDAO {

    public void setEntityManager(EntityManager entityManager);
}
