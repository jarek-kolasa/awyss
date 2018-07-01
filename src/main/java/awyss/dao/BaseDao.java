package awyss.dao;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;

@Transactional
public abstract class BaseDao<T extends Serializable> {

    public Class<T> clazz;

    @Autowired
    protected EntityManager entityManager;


    @SuppressWarnings("unchecked")
    protected BaseDao() {

        Type t = getClass().getGenericSuperclass();
        Type arg;
        if (t instanceof ParameterizedType) {
            arg = ((ParameterizedType) t).getActualTypeArguments()[0];
        } else if (t instanceof Class) {
            arg = ((ParameterizedType) ((Class) t).getGenericSuperclass())
                    .getActualTypeArguments()[0];

        } else {
            throw new RuntimeException("Can not handle type construction for '"
                    + getClass() + "'!");
        }

        if (arg instanceof Class) {
            this.clazz = (Class<T>) arg;
        } else if (arg instanceof ParameterizedType) {
            this.clazz = (Class<T>) ((ParameterizedType) arg).getRawType();
        } else {
            throw new RuntimeException("Problem dtermining generic class for '"
                    + getClass() + "'! ");
        }
    }

    @SuppressWarnings("unchecked")
    public T getById(Long o) {
        return (T) getHibernateSession().get(clazz, o);

    }

    public List<T> findAll() {
        return  getHibernateSession().createCriteria(clazz).list();

    }

    protected Session getHibernateSession() {
        return (Session) entityManager.getDelegate();
    }

    public void save(T t) {
        getHibernateSession().save(t);

    }

    public void saveOrUpdate(T t) {

        getHibernateSession().saveOrUpdate(t);

    }

    public void update(T t) {
        getHibernateSession().update(t);

    }

    public void delete(T t) {
        getHibernateSession().delete(t);

    }

}