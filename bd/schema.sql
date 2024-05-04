
CREATE TABLE IF NOT EXISTS categories (
	id_category serial NOT NULL,
	name varchar(255) NULL,
	description text NULL,
	image_url text NULL,
	CONSTRAINT categories_pkey PRIMARY KEY (id_category)
);

CREATE TABLE IF NOT EXISTS status (
	id_status serial NOT NULL,
	description varchar(250) NULL,
	name varchar(100) NULL,
	CONSTRAINT status_pk PRIMARY KEY (id_status)
);

CREATE TABLE IF NOT EXISTS profiles (
	id_profile serial NOT NULL,
	description varchar(100) NULL,
	name varchar(250) NULL,
	CONSTRAINT profiles_pk PRIMARY KEY (id_profile)
);


CREATE TABLE IF NOT EXISTS promotions (
	id_promotion serial NOT NULL,
	description text NULL,
	discount numeric(5,2) NULL,
	start_date date NULL,
	end_date date NULL,
	CONSTRAINT promotions_pkey PRIMARY KEY (id_promotion)
);

CREATE TABLE IF NOT EXISTS category_promotions (
	id_promotion int4 NOT NULL,
	id_category int4 NOT NULL,
	CONSTRAINT category_promotions_pk PRIMARY KEY (id_promotion, id_category),
	CONSTRAINT category_promotions_id_category_fk FOREIGN KEY (id_category) REFERENCES categories(id_category),
	CONSTRAINT category_promotions_id_promotion_fk FOREIGN KEY (id_promotion) REFERENCES promotions(id_promotion)
);


CREATE TABLE IF NOT EXISTS products (
	id_product serial NOT NULL,
	name varchar(255) NULL,
	description text NULL,
	price numeric(10,2) NULL,
	image_url text NULL,
	id_category int4 NULL,
	stock int4 NULL,
	CONSTRAINT products_pkey PRIMARY KEY (id_product),
	CONSTRAINT products_id_category_fkey FOREIGN KEY (id_category) REFERENCES categories(id_category)
);


CREATE TABLE IF NOT EXISTS stock_histories (
	id_stock_history serial NOT NULL,
	id_product int4 NULL,
	date timestamp NULL DEFAULT CURRENT_TIMESTAMP,
	quantity_in int4 NULL,
	quantity_out int4 NULL,
	CONSTRAINT stock_histories_pkey PRIMARY KEY (id_stock_history),
	CONSTRAINT stock_histories_id_product_fkey FOREIGN KEY (id_product) REFERENCES products(id_product)
);


CREATE TABLE IF NOT EXISTS users (
	id_user serial NOT NULL,
	name varchar(255) NULL,
	email varchar(255) NULL,
	password varchar(255) NULL,
	shipping_address text NULL,
	id_profile int4 NULL,
	CONSTRAINT users_email_key UNIQUE (email),
	CONSTRAINT users_pkey PRIMARY KEY (id_user),
	CONSTRAINT users_profiles_id_fk FOREIGN KEY (id_profile) REFERENCES profiles(id_profile)
);


CREATE TABLE IF NOT EXISTS orders (
	id_order serial NOT NULL,
	id_user int4 NULL,
	date timestamp NULL DEFAULT CURRENT_TIMESTAMP,
	id_status int4 NULL,
	total numeric(10,2) NULL,
	CONSTRAINT orders_pkey PRIMARY KEY (id_order),
	CONSTRAINT orders_id_user_fkey FOREIGN KEY (id_user) REFERENCES users(id_user),
	CONSTRAINT orders_id_status_fkey FOREIGN KEY (id_status) REFERENCES status(id_status)
);


CREATE TABLE IF NOT EXISTS product_promotions (
	id_promotion int4 NOT NULL,
	id_product int4 NOT NULL,
	CONSTRAINT product_promotions_pkey PRIMARY KEY (id_promotion, id_product),
	CONSTRAINT product_promotions_id_product_fkey FOREIGN KEY (id_product) REFERENCES products(id_product),
	CONSTRAINT product_promotions_id_promotion_fkey FOREIGN KEY (id_promotion) REFERENCES promotions(id_promotion)
);


CREATE TABLE IF NOT EXISTS reviews (
	id_review serial NOT NULL,
	id_product int4 NULL,
	id_user int4 NULL,
	rating int4 NULL,
	comment text NULL,
	date timestamp NULL DEFAULT CURRENT_TIMESTAMP,
	CONSTRAINT reviews_pkey PRIMARY KEY (id_review),
	CONSTRAINT reviews_rating_check CHECK (((rating >= 1) AND (rating <= 5))),
	CONSTRAINT reviews_id_product_fkey FOREIGN KEY (id_product) REFERENCES products(id_product),
	CONSTRAINT reviews_id_user_fkey FOREIGN KEY (id_user) REFERENCES users(id_user)
);


CREATE TABLE IF NOT EXISTS user_session (
	id_session serial NOT NULL,
	id_user int4 NULL,
	start_date timestamp NULL DEFAULT CURRENT_TIMESTAMP,
	end_date timestamp NULL,
	session_token text NULL,
	CONSTRAINT user_session_pkey PRIMARY KEY (id_session),
	CONSTRAINT user_id_session_user_fkey FOREIGN KEY (id_user) REFERENCES users(id_user)
);


CREATE TABLE IF NOT EXISTS order_details (
	id_order_detail serial NOT NULL,
	id_order int4 NULL,
	id_product int4 NULL,
	quantity int4 NULL,
	unit_price numeric(10,2) NULL,
	discount numeric(5,2) NULL DEFAULT 0,
	CONSTRAINT order_details_pkey PRIMARY KEY (id_order_detail),
	CONSTRAINT order_details_id_order_fkey FOREIGN KEY (id_order) REFERENCES orders(id_order),
	CONSTRAINT order_details_id_product_fkey FOREIGN KEY (id_product) REFERENCES products(id_product)
);