package ru.gb;

import javax.persistence.EntityManager;
import java.util.List;

public class GoodsDao {

    private EntityManager entityManager;

    public GoodsDao() {
    }

    public GoodsDao(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public Good findById(int id) {
        return entityManager.find(Good.class, id);
    }

    public List<Good> findAll() {
        return entityManager
                .createQuery("select good from Good as good", Good.class)
                .getResultList();
    }

    public void deleteById(int id) {
        entityManager.getTransaction().begin();
        entityManager.remove(this.findById(id));
        entityManager.getTransaction().commit();
    }

    public Good saveOrUpdate(Good good) {
        entityManager.getTransaction().begin();
        good = entityManager.merge(good);
        entityManager.getTransaction().commit();
        return good;
    }

}
