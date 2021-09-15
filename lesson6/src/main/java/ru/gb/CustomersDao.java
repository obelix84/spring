package ru.gb;

import javax.persistence.EntityManager;
import java.util.List;

public class CustomersDao {

    private EntityManager entityManager;

    public CustomersDao(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public Customer findById(int id) {
        return entityManager.find(Customer.class, id);
    }

    public List<Customer> findAll() {
        return entityManager
                .createQuery("select cust from Customer as cust", Customer.class)
                .getResultList();
    }

    public void deleteById(int id) {
        entityManager.getTransaction().begin();
        entityManager.remove(this.findById(id));
        entityManager.getTransaction().commit();
    }

    public Customer saveOrUpdate(Customer customers) {
        entityManager.getTransaction().begin();
        customers = entityManager.merge(customers);
        entityManager.getTransaction().commit();
        return customers;
    }
}
