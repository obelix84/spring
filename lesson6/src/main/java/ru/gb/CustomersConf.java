package ru.gb;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

@Configuration
public class CustomersConf {

        @Bean
        public EntityManager entityManager() {
            EntityManagerFactory factory = new org.hibernate.cfg.Configuration().configure("hibernate.cfg.xml")
                                            .buildSessionFactory();
            return factory.createEntityManager();
        }

        @Bean
        public CustomersDao customersDAO(EntityManager em) {
            return new CustomersDao(em);
        }

        @Bean
        public GoodsDao goodsDAO(EntityManager em) {
            return new GoodsDao(em);
        }

}
