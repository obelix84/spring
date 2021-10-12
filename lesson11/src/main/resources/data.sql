INSERT INTO categories (id, name) VALUES (1, 'Игрушки'), (2, 'Хлеб'), (3, 'Молочные продукты'), (4, 'Продукты');

INSERT INTO products (id, name, description) VALUES (1, 'PS5', 'Игровая приставка'),
                                                    (2, 'Сдобная булка', 'Хлебо-булочное изделие с завода №4'),
                                                    (3, 'Хлеб Бородинский', 'Хлебо-булочное изделие с завода №4'),
                                                    (4, 'Молоко 3%', 'Молочные продукты с фермы'),
                                                    (5, 'Молоко 1%', 'Молочные продукты с фермы'),
                                                    (6, 'Кефир Фермерский 5%', 'Молочные продукты с фермы');

INSERT INTO products_categories (product_id, categories_id) VALUES (1,1),
                                                                   (2,2),
                                                                   (2,4),
                                                                   (3,2),
                                                                   (3,4),
                                                                   (4,3),
                                                                   (5,3),
                                                                   (6,3);

INSERT INTO users (username, password, enabled)
VALUES ('admin', 'admin_pass', 1),
       ('manager', 'manager_pass', 1),
       ('all', 'all_pass', 1),
       ('user', 'user_pass', 1);

INSERT INTO authorities (username, authority)
VALUES ('admin', 'ROLE_ADMIN'),
       ('manager', 'ROLE_MANAGER'),
       ('all', 'ROLE_ADMIN'),
       ('all', 'ROLE_MANAGER'),
       ('user', 'ROLE_USER');

INSERT INTO cart (id, username)
VALUES (1, 'user');