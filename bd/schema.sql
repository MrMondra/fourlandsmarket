
CREATE TABLE IF NOT EXISTS categories (
	category_id serial NOT NULL,
	name varchar(255) NULL,
	description text NULL,
	image_url text NULL,
	CONSTRAINT categories_pkey PRIMARY KEY (category_id)
);


CREATE TABLE IF NOT EXISTS profiles (
	profile_id serial NOT NULL,
	description varchar(100) NULL,
	name varchar(250) NULL,
	CONSTRAINT profiles_pk PRIMARY KEY (profile_id)
);


CREATE TABLE IF NOT EXISTS promotions (
	promotion_id serial NOT NULL,
	description text NULL,
	discount numeric(5,2) NULL,
	start_date date NULL,
	end_date date NULL,
	CONSTRAINT promotions_pkey PRIMARY KEY (promotion_id)
);

CREATE TABLE IF NOT EXISTS category_promotions (
	promotion_id int4 NOT NULL,
	category_id int4 NOT NULL,
	CONSTRAINT category_promotions_pk PRIMARY KEY (promotion_id, category_id),
	CONSTRAINT category_promotions_category_id_fk FOREIGN KEY (category_id) REFERENCES categories(category_id),
	CONSTRAINT category_promotions_promotion_id_fk FOREIGN KEY (promotion_id) REFERENCES promotions(promotion_id)
);


CREATE TABLE IF NOT EXISTS products (
	product_id serial NOT NULL,
	name varchar(255) NULL,
	description text NULL,
	price numeric(10,2) NULL,
	image_url text NULL,
	category_id int4 NULL,
	stock int4 NULL,
	CONSTRAINT products_pkey PRIMARY KEY (product_id),
	CONSTRAINT products_category_id_fkey FOREIGN KEY (category_id) REFERENCES categories(category_id)
);


CREATE TABLE IF NOT EXISTS stock_histories (
	stock_history_id serial NOT NULL,
	product_id int4 NULL,
	date timestamp NULL DEFAULT CURRENT_TIMESTAMP,
	quantity_in int4 NULL,
	quantity_out int4 NULL,
	CONSTRAINT stock_histories_pkey PRIMARY KEY (stock_history_id),
	CONSTRAINT stock_histories_product_id_fkey FOREIGN KEY (product_id) REFERENCES products(product_id)
);


CREATE TABLE IF NOT EXISTS users (
	user_id serial NOT NULL,
	name varchar(255) NULL,
	email varchar(255) NULL,
	password varchar(255) NULL,
	shipping_address text NULL,
	is_admin bool NULL DEFAULT false,
	profile_id int4 NULL,
	CONSTRAINT users_email_key UNIQUE (email),
	CONSTRAINT users_pkey PRIMARY KEY (user_id),
	CONSTRAINT users_profiles_id_fk FOREIGN KEY (profile_id) REFERENCES profiles(profile_id)
);


CREATE TABLE IF NOT EXISTS orders (
	order_id serial NOT NULL,
	user_id int4 NULL,
	date timestamp NULL DEFAULT CURRENT_TIMESTAMP,
	status varchar(50) NULL,
	total numeric(10,2) NULL,
	CONSTRAINT orders_pkey PRIMARY KEY (order_id),
	CONSTRAINT orders_user_id_fkey FOREIGN KEY (user_id) REFERENCES users(user_id)
);


CREATE TABLE IF NOT EXISTS product_promotions (
	promotion_id int4 NOT NULL,
	product_id int4 NOT NULL,
	CONSTRAINT product_promotions_pkey PRIMARY KEY (promotion_id, product_id),
	CONSTRAINT product_promotions_product_id_fkey FOREIGN KEY (product_id) REFERENCES products(product_id),
	CONSTRAINT product_promotions_promotion_id_fkey FOREIGN KEY (promotion_id) REFERENCES promotions(promotion_id)
);


CREATE TABLE IF NOT EXISTS reviews (
	review_id serial NOT NULL,
	product_id int4 NULL,
	user_id int4 NULL,
	rating int4 NULL,
	comment text NULL,
	date timestamp NULL DEFAULT CURRENT_TIMESTAMP,
	CONSTRAINT reviews_pkey PRIMARY KEY (review_id),
	CONSTRAINT reviews_rating_check CHECK (((rating >= 1) AND (rating <= 5))),
	CONSTRAINT reviews_product_id_fkey FOREIGN KEY (product_id) REFERENCES products(product_id),
	CONSTRAINT reviews_user_id_fkey FOREIGN KEY (user_id) REFERENCES users(user_id)
);


CREATE TABLE public.user_session (
	session_id serial NOT NULL,
	user_id int4 NULL,
	start_date timestamp NULL DEFAULT CURRENT_TIMESTAMP,
	end_date timestamp NULL,
	session_token text NULL,
	CONSTRAINT user_session_pkey PRIMARY KEY (session_id),
	CONSTRAINT user_session_user_id_fkey FOREIGN KEY (user_id) REFERENCES users(user_id)
);


CREATE TABLE public.order_details (
	order_detail_id serial NOT NULL,
	order_id int4 NULL,
	product_id int4 NULL,
	quantity int4 NULL,
	unit_price numeric(10,2) NULL,
	discount numeric(5,2) NULL DEFAULT 0,
	CONSTRAINT order_details_pkey PRIMARY KEY (order_detail_id),
	CONSTRAINT order_details_order_id_fkey FOREIGN KEY (order_id) REFERENCES orders(order_id),
	CONSTRAINT order_details_product_id_fkey FOREIGN KEY (product_id) REFERENCES products(product_id)
);