package ru.gb.spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;
import java.util.Scanner;

public class MainApp {

    public static void main(String[] args) {
        System.out.println("Хотите сделать заказ?");
        System.out.println("Команды:");
        System.out.println("products - показывает список товаров");
        System.out.println("cart - показывыает содержимой корзины заказа");
        System.out.println("add идентификатор_товара - добавляет товары в корзину");
        System.out.println("remove идентификатор_товара - удаляет товар из корзины");
        System.out.println("new - создать новую корзину");
        System.out.println("exit - выход");
        System.out.println("Введите команду");

        ApplicationContext context = new AnnotationConfigApplicationContext(CartConfiguration.class);
        Cart cart = context.getBean(Cart.class);
        ProductRepository repository = context.getBean(ProductRepository.class);

        while(true) {
            System.out.print("--> ");
            Scanner scan = new Scanner(System.in);
            String command = scan.nextLine();
            if (command.startsWith("exit")) {
                break;
            } else if(command.startsWith("products")) {
                List<Product> products = repository.getAll();
                System.out.println("Products:");
                for (Product p: products) {
                    System.out.printf("%d - %s - %f\n", p.getId(), p.getName(), p.getPrice());
                }
            } else if(command.startsWith("cart")) {
                List<Product> products = cart.getContents();
                System.out.println("Cart:");
                for (Product p: products) {
                    System.out.printf("%d - %s - %f\n", p.getId(), p.getName(), p.getPrice());
                }
            }  else if(command.startsWith("add")) {
                String [] parts = command.split("\\s");
                cart.add(Integer.parseInt(parts[1]));
            } else if(command.startsWith("remove")) {
                String [] parts = command.split("\\s");
                cart.remove(Integer.parseInt(parts[1]));
            } else if (command.startsWith("new")) {
                System.out.println("Create new cart..");
                cart = context.getBean(Cart.class);
            }
        }
    }
}
