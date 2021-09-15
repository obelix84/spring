package ru.gb;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class StartApp {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(CustomersConf.class);
        CustomersDao cust = context.getBean(CustomersDao.class);

        System.out.println(cust.findAll());
        System.out.println("-------------------");
        GoodsDao goodsDao = context.getBean(GoodsDao.class);
        System.out.println(goodsDao.findAll());
        Good good5 = goodsDao.findById(5);
        System.out.println(good5);
        System.out.println("-------------------");
        good5.setName("good55");
        goodsDao.saveOrUpdate(good5);
        System.out.println(goodsDao.findById(5));
    }
}
