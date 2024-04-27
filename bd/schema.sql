-- Create tables in PostgreSQL

-- User
CREATE TABLE IF NOT EXISTS user (
    user_id SERIAL PRIMARY KEY,
    name VARCHAR(255),
    email VARCHAR(255) UNIQUE,
    password VARCHAR(255),
    shipping_address TEXT,
    is_admin BOOLEAN DEFAULT FALSE
);

-- Product Category
CREATE TABLE IF NOT EXISTS category (
    category_id SERIAL PRIMARY KEY,
    name VARCHAR(255),
    description TEXT,
    image_url TEXT
);

-- Product
CREATE TABLE IF NOT EXISTS product (
    product_id SERIAL PRIMARY KEY,
    name VARCHAR(255),
    description TEXT,
    price NUMERIC(10, 2),
    discount NUMERIC(5, 2) DEFAULT 0,
    image_url TEXT,
    category_id INT REFERENCES category(category_id),
    stock INT
);

-- Order
CREATE TABLE IF NOT EXISTS order (
    order_id SERIAL PRIMARY KEY,
    user_id INT REFERENCES user(user_id),
    date TIMESTAMP WITHOUT TIME ZONE DEFAULT CURRENT_TIMESTAMP,
    status VARCHAR(50),
    total NUMERIC(10, 2)
);

-- Order Detail
CREATE TABLE IF NOT EXISTS order_detail (
    order_detail_id SERIAL PRIMARY KEY,
    order_id INT REFERENCES order(order_id),
    product_id INT REFERENCES product(product_id),
    quantity INT,
    unit_price NUMERIC(10, 2),
    discount NUMERIC(5, 2) DEFAULT 0
);

-- Promotion
CREATE TABLE IF NOT EXISTS promotion (
    promotion_id SERIAL PRIMARY KEY,
    description TEXT,
    discount NUMERIC(5, 2),
    start_date DATE,
    end_date DATE
);

-- Promoted Product
CREATE TABLE IF NOT EXISTS product_promotion (
    promotion_id INT REFERENCES promotion(promotion_id),
    product_id INT REFERENCES product(product_id),
    PRIMARY KEY (promotion_id, product_id)
);

-- Review
CREATE TABLE IF NOT EXISTS review (
    review_id SERIAL PRIMARY KEY,
    product_id INT REFERENCES product(product_id),
    user_id INT REFERENCES user(user_id),
    rating INT CHECK (rating >= 1 AND rating <= 5),
    comment TEXT,
    date TIMESTAMP WITHOUT TIME ZONE DEFAULT CURRENT_TIMESTAMP
);

-- Stock History
CREATE TABLE IF NOT EXISTS stock_history (
    stock_history_id SERIAL PRIMARY KEY,
    product_id INT REFERENCES product(product_id),
    date TIMESTAMP WITHOUT TIME ZONE DEFAULT CURRENT_TIMESTAMP,
    quantity_in INT,
    quantity_out INT
);

-- User Session
CREATE TABLE IF NOT EXISTS user_session (
    session_id SERIAL PRIMARY KEY,
    user_id INT REFERENCES user(user_id),
    start_date TIMESTAMP WITHOUT TIME ZONE DEFAULT CURRENT_TIMESTAMP,
    end_date TIMESTAMP WITHOUT TIME ZONE,
    session_token TEXT
);
