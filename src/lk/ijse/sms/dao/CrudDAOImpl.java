package lk.ijse.sms.dao;

import lk.ijse.sms.entity.Exam;
import lk.ijse.sms.entity.StudentExam;
import org.hibernate.Session;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import java.lang.reflect.ParameterizedType;
import java.util.ArrayList;
import java.util.List;

public class CrudDAOImpl<T ,ID> implements CrudDAO<T,ID>
{


//    private Session session;

    protected EntityManager entityManager;
    private Class<T> entity;

    public CrudDAOImpl() {
        entity = (Class<T>)(((ParameterizedType)this.getClass().getGenericSuperclass()).getActualTypeArguments()[0]);
    }

    @Override
    public void save(T entity) throws Exception {

        entityManager.persist(entity);
    }

    @Override
    public void update(T entity) throws Exception {
        entityManager.persist(entity);
    }

    @Override
    public void delete(ID id) throws Exception {
        T t = entityManager.find(entity, id);
        entityManager.remove(t);
    }

    @Override
    public T findByID(ID id) throws Exception {
        return  entityManager.find(entity, id);
    }

    @Override
    public List<T> getAll() throws Exception {
        System.out.println(entity.getName());
       return entityManager.createQuery("FROM "+entity.getName()).getResultList();
    }

    @Override
    public void setEntityManager(EntityManager entityManager) {
        this.entityManager=entityManager;
    }


}
