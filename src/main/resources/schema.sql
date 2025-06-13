CREATE TABLE "user" (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(100),
    email VARCHAR(100)
);

CREATE TABLE address (
    id INT AUTO_INCREMENT PRIMARY KEY,
    user_id INT,
    building VARCHAR(255),
    floor INT,
    room_no VARCHAR(50),
    street VARCHAR(255),
    city VARCHAR(100),
    state VARCHAR(100),
    country VARCHAR(100),
    zip_code VARCHAR(20),
    FOREIGN KEY (user_id) REFERENCES "user"(id)
);

CREATE TABLE product (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(100),
    description TEXT,
    price DOUBLE
);

CREATE TABLE inventory (
    id INT AUTO_INCREMENT PRIMARY KEY,
    product_id INT UNIQUE,
    quantity INT,
    FOREIGN KEY (product_id) REFERENCES product(id)
);

CREATE TABLE high_demand_product (
    id INT AUTO_INCREMENT PRIMARY KEY,
    product_id INT UNIQUE,
    max_quantity INT,
    FOREIGN KEY (product_id) REFERENCES product(id)
);

CREATE TABLE "order" (
    id INT AUTO_INCREMENT PRIMARY KEY,
    user_id INT,
    delivery_address_id INT,
    order_status VARCHAR(50),
    FOREIGN KEY (user_id) REFERENCES "user"(id),
    FOREIGN KEY (delivery_address_id) REFERENCES address(id)
);

CREATE TABLE order_detail (
    id INT AUTO_INCREMENT PRIMARY KEY,
    order_id INT,
    product_id INT,
    quantity INT,
    FOREIGN KEY (order_id) REFERENCES "order"(id),
    FOREIGN KEY (product_id) REFERENCES product(id)
);
