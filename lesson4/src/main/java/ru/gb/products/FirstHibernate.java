package ru.gb.products;

import jdk.swing.interop.SwingInterOpUtils;

public class FirstHibernate {
    public static void main(String[] args) {
        ProductsDAO productsDAO = new ProductsDAO();
        for (int i = 0; i < 5; i++) {
            Product prod = new Product("prod" + i,100 * i);
            productsDAO.saveOrUpdate(prod);
        }
        //findAll
        System.out.println(productsDAO.findAll().toString());

        //изменить и сохранить объект
        Product updateProduct = new Product("prod_upd", 500);
        System.out.println(updateProduct);
        Product retProd = productsDAO.saveOrUpdate(updateProduct);
        System.out.println(retProd);
        retProd.setPrice(15000);
        retProd = productsDAO.saveOrUpdate(retProd);
        System.out.println(retProd);

        //найти объект по ID
        System.out.println(productsDAO.findById(3L));
        //Удалить объект
        productsDAO.deleteById(5L);

        //вывести всех
        System.out.println(productsDAO.findAll().toString());


    }
}
