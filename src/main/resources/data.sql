-- Users
INSERT INTO "user" (id, name, email) VALUES
(1, 'Alice Johnson', 'alice@example.com'),
(2, 'Bob Smith', 'bob@example.com');

-- Addresses
INSERT INTO address (id, user_id, building, floor, room_no, street, city, state, country, zip_code) VALUES
(1, 1, 'Apt 101', 1, '101', 'Maple Street', 'New York', 'NY', 'USA', '10001'),
(2, 2, 'Block B', 2, '202', 'Oak Avenue', 'Los Angeles', 'CA', 'USA', '90001');

-- Products
INSERT INTO product (id, name, description, price) VALUES
(1, 'Laptop', 'High performance laptop', 1200.00),
(2, 'Smartphone', 'Latest model smartphone', 800.00),
(3, 'Headphones', 'Noise-cancelling headphones', 150.00);

-- Inventory
INSERT INTO inventory (id, product_id, quantity) VALUES
(1, 1, 10),
(2, 2, 20),
(3, 3, 50);

-- High Demand Products
INSERT INTO high_demand_product (id, product_id, max_quantity) VALUES
(1, 1, 1),   -- Laptop max 1 per order
(2, 2, 2);   -- Smartphone max 2 per order

-- Order
INSERT INTO "order" (id, user_id, delivery_address_id, order_status) VALUES
(1, 1, 1, 'PLACED'),
(2, 2, 2, 'SHIPPED');

-- Order Details
INSERT INTO order_detail (id, order_id, product_id, quantity) VALUES
(1, 1, 1, 1),   -- Order 1, Laptop x1
(2, 1, 3, 2),   -- Order 1, Headphones x2
(3, 2, 2, 1);   -- Order 2, Smartphone x1
