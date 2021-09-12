package ru.gb.products;

import org.hibernate.cfg.Configuration;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import java.util.List;

public class ProductsDAO {
    private EntityManagerFactory factory;
    private EntityManager entityManager;

    public ProductsDAO() {
        this.factory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
        this.entityManager = factory.createEntityManager();
    }

    public Product findById(Long id) {
        //когда делал запросы типа SELECT транзакцию не открывал, может и не надо...
        return entityManager.find(Product.class, id);
    }

    public List<Product> findAll() {
        return entityManager
                .createQuery("select prod from Product as prod", Product.class)
                .getResultList();

    }

    public void deleteById(Long id) {
        entityManager.getTransaction().begin();
        entityManager.remove(this.findById(id));
        entityManager.getTransaction().commit();
    }

    public Product saveOrUpdate(Product product) {
        entityManager.getTransaction().begin();
        product = entityManager.merge(product);
        entityManager.getTransaction().commit();
     return product;
    }

}
