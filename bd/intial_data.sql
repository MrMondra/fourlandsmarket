--INSERSTS PROFILES
INSERT INTO profiles (description, name) VALUES('Perfi administrador del marketplace', 'Admin');
INSERT INTO profiles (description, name) VALUES('Perfi administrador del marketplace', 'Enterprise');
INSERT INTO profiles (description, name) VALUES('Perfi administrador del marketplace', 'Client');

--INSERSTS STATES
INSERT INTO status (name,description) VALUES('PENDIENTE', 'La orden de compra esta pendiente.');
INSERT INTO status (name,description) VALUES('FINALIZADO', 'La orden de compra esta finalizada.');
INSERT INTO status (name,description ) VALUES('CANCELADO', 'La orden de compra ha sido cancelada.');

--INSERSTS PROMOTIONS
INSERT INTO promotions (description, discount, start_date, end_date) VALUES ('Mes la madre', 0.20, '1995-05-01', '1995-05-31');
INSERT INTO promotions (description, discount, start_date, end_date) VALUES('Mes del padre', 0.10, '1995-06-01', '1995-06-30');
INSERT INTO promotions (description, discount, start_date, end_date) VALUES('Mes del niño', 0.3, '1995-04-01', '1995-04-30');
INSERT INTO promotions (description, discount, start_date, end_date) VALUES('Halloween', 0.12, '1995-10-01', '1995-10-31');
INSERT INTO promotions (description, discount, start_date, end_date) VALUES('Navidad', 0.12, '1995-12-01', '1995-12-31');

--INSERSTS CATEGORIES
INSERT INTO categories (name, description, image_url) VALUES('Electrodomesticos', 'Electrodomesticos para el hogar', 'https://shorturl.at/ghtu4');
INSERT INTO categories (name, description, image_url) VALUES('Deportes', 'Deportes y vida fit', 'https://shorturl.at/ghtu4');
INSERT INTO categories (name, description, image_url) VALUES('Belleza', 'Belleza y cuidado de la piel', 'https://shorturl.at/ghtu4');
INSERT INTO categories (name, description, image_url) VALUES('Drogueria', 'Drogueria y salud', 'https://shorturl.at/ghtu4');
INSERT INTO categories (name, description, image_url) VALUES('Mercado', 'Productos de la canasta familiar', 'https://shorturl.at/ghtu4');
INSERT INTO categories (name, description, image_url) VALUES('Tecnologia', 'Tecnologia y entretenimiento', 'https://shorturl.at/ghtu4');

--INSERTS PRODUCTS
-- Tecnología
INSERT INTO products (name, description, price, image_url, id_category, stock) VALUES('Smartphone Pro', 'High-end smartphone with advanced features', 899, 'https://shorturl.at/ghtu4', 6, 35);
INSERT INTO products (name, description, price, image_url, id_category, stock) VALUES('Gaming Console', 'Next generation gaming console with VR capabilities', 499, 'https://shorturl.at/ghtu4', 6, 30);
INSERT INTO products (name, description, price, image_url, id_category, stock) VALUES('E-Reader', 'Lightweight e-reader with e-ink display', 130, 'https://shorturl.at/ghtu4', 6, 33);
INSERT INTO products (name, description, price, image_url, id_category, stock) VALUES('Electric Kettle', 'Fast boiling stainless steel kettle', 29, 'https://shorturl.at/ghtu4', 6, 22);
INSERT INTO products (name, description, price, image_url, id_category, stock) VALUES('Air Purifier', 'HEPA air purifier for allergy sufferers', 89, 'https://shorturl.at/ghtu4', 6, 18);

-- Deportes
INSERT INTO products (name, description, price, image_url, id_category, stock) VALUES('Raqueta', 'Raqueta profesional', 199, 'https://shorturl.at/ghtu4', 2, 20);
INSERT INTO products (name, description, price, image_url, id_category, stock) VALUES('Balon', 'Balon firmando por Messi', 24, 'https://shorturl.at/ghtu4', 2, 70);
INSERT INTO products (name, description, price, image_url, id_category, stock) VALUES('Gafas natación', 'Gafas geniales', 99, 'https://shorturl.at/ghtu4', 2, 40);
INSERT INTO products (name, description, price, image_url, id_category, stock) VALUES('Bate', 'Esos que dicen Tony Armas', 45, 'https://shorturl.at/ghtu4', 2, 34);

-- Belleza
INSERT INTO products (name, description, price, image_url, id_category, stock) VALUES('Mascarilla', 'Bonita y fresca', 120, 'https://shorturl.at/ghtu4', 3, 15);
INSERT INTO products (name, description, price, image_url, id_category, stock) VALUES('Crema facial', 'Previene arrugas', 150, 'https://shorturl.at/ghtu4', 3, 10);
INSERT INTO products (name, description, price, image_url, id_category, stock) VALUES('Lentes de contacto', 'Expresivos color café', 200, 'https://shorturl.at/ghtu4', 3, 12);

-- Droguería
INSERT INTO products (name, description, price, image_url, id_category, stock) VALUES('Pasta para el dolor de cabeza', 'Pasta grande 1 cada 8 horas', 250, 'https://shorturl.at/ghtu4', 4, 40);
INSERT INTO products (name, description, price, image_url, id_category, stock) VALUES('Pasta para el dolor de estomago', 'Pasta mediana 1 cada 8 horas', 120, 'https://shorturl.at/ghtu4', 4, 15);
INSERT INTO products (name, description, price, image_url, id_category, stock) VALUES('Pasta para el dolor muscular', 'Pasta pequeña 1 cada 8 horas', 160, 'https://shorturl.at/ghtu4', 4, 28);

-- Mercado
INSERT INTO products (name, description, price, image_url, id_category, stock) VALUES('Pera', 'Delicioso y fresco', 400, 'https://shorturl.at/ghtu4', 5, 25);
INSERT INTO products (name, description, price, image_url, id_category, stock) VALUES('Mango', 'Bueno y fresco', 85, 'https://shorturl.at/ghtu4', 5, 8);
INSERT INTO products (name, description, price, image_url, id_category, stock) VALUES('Fresa', 'Grande y fresco', 299, 'https://shorturl.at/ghtu4', 5, 15);

-- Electrodomésticos
INSERT INTO products (name, description, price, image_url, id_category, stock) VALUES('Lavadora', 'Lavadora de 10 lbs', 34, 'https://shorturl.at/ghtu4', 1, 50);
INSERT INTO products (name, description, price, image_url, id_category, stock) VALUES('Licuadora', 'Licuadora de 2 litros', 250, 'https://shorturl.at/ghtu4', 1, 7);

--INSERT USERS
INSERT INTO users ("name", email, "password", shipping_address, id_profile) VALUES('Carlos', 'carlos@carlos.com', '123XXX', 'Call 1 # 2-3', 1);
INSERT INTO users ("name", email, "password", shipping_address, id_profile) VALUES('Juan', 'juan@juan.com', '123XXX', 'Call 4 # 5-6', 1);
INSERT INTO users ("name", email, "password", shipping_address, id_profile) VALUES('Pedro', 'pedro@pedro.com', '123XXX', 'Call 7 # 8-9', 2);
INSERT INTO users ("name", email, "password", shipping_address, id_profile) VALUES('Mario', 'mario@mario.com', '123XXX', 'Call 10 # 11-12', 2);
INSERT INTO users ("name", email, "password", shipping_address, id_profile) VALUES('Luis', 'luis@luis.com', '123XXX', 'Call 13 # 13-14', 2);
INSERT INTO users ("name", email, "password", shipping_address, id_profile) VALUES('Fernando', 'fernando@fernando.com', '123XXX', 'Call 15 # 16-17', 3);
INSERT INTO users ("name", email, "password", shipping_address, id_profile) VALUES('Alex', 'alex@alex.com', '123XXX', 'Call 18 # 19-20', 3);
INSERT INTO users ("name", email, "password", shipping_address, id_profile) VALUES('Alejandra', 'alejandra@alejandra.com', '123XXX', 'Call 21 # 22-23', 3);
INSERT INTO users ("name", email, "password", shipping_address, id_profile) VALUES('Maria', 'maria@maria.com', '123XXX', 'Call 24 # 25-26', 3);
INSERT INTO users ("name", email, "password", shipping_address, id_profile) VALUES('Carla', 'carla@carla.com', '123XXX', 'Call 27 # 28-29', 3);

--INSERT REVIEWS
INSERT INTO reviews (id_product, id_user, rating, comment, date)
VALUES (1, 1, 5, 'Excellent smartphone with great performance!', CURRENT_TIMESTAMP);
INSERT INTO reviews (id_product, id_user, rating, comment, date)
VALUES (1, 2, 4, 'Good value for money.', CURRENT_TIMESTAMP);

INSERT INTO reviews (id_product, id_user, rating, comment, date)
VALUES (3, 3, 3, 'Decent headphones, but the battery life could be better.', CURRENT_TIMESTAMP);

INSERT INTO reviews (id_product, id_user, rating, comment, date)
VALUES (5, 4, 5, 'Amazing clarity with vibrant colors, best TV in this price range.', CURRENT_TIMESTAMP);
INSERT INTO reviews (id_product, id_user, rating, comment, date)
VALUES (5, 5, 5, 'Absolutely love this TV! The smart features are very user-friendly.', CURRENT_TIMESTAMP);

INSERT INTO reviews (id_product, id_user, rating, comment, date)
VALUES (7, 6, 4, 'Very useful for travel, charges quickly.', CURRENT_TIMESTAMP);
INSERT INTO reviews (id_product, id_user, rating, comment, date)
VALUES (7, 7, 4, 'Holds a lot of charge and is quite compact.', CURRENT_TIMESTAMP);
INSERT INTO reviews (id_product, id_user, rating, comment, date)
VALUES (7, 8, 3, 'Good but a bit heavy for my taste.', CURRENT_TIMESTAMP);

INSERT INTO reviews (id_product, id_user, rating, comment, date)
VALUES (10, 9, 5, 'Perfect for my adventure trips, very sturdy and reliable!', CURRENT_TIMESTAMP);
INSERT INTO reviews (id_product, id_user, rating, comment, date)
VALUES (10, 10, 5, 'Takes great underwater shots without any leakage.', CURRENT_TIMESTAMP);

--INSERT CATEGORY_PROMOTIONS
INSERT INTO category_promotions (id_promotion, id_category) VALUES(2, 2);
INSERT INTO category_promotions (id_promotion, id_category) VALUES(2, 1);
INSERT INTO category_promotions (id_promotion, id_category) VALUES(4, 4);
INSERT INTO category_promotions (id_promotion, id_category) VALUES(4, 5);

--INSERT PRODUCT_PROMOTIONS
INSERT INTO product_promotions (id_promotion, id_product) VALUES(2, 12);
INSERT INTO product_promotions (id_promotion, id_product) VALUES(3, 3);
INSERT INTO product_promotions (id_promotion, id_product) VALUES(4, 5);
INSERT INTO product_promotions (id_promotion, id_product) VALUES(4, 1);
INSERT INTO product_promotions (id_promotion, id_product) VALUES(5, 2);
INSERT INTO product_promotions (id_promotion, id_product) VALUES(5, 4);
INSERT INTO product_promotions (id_promotion, id_product) VALUES(5, 5);