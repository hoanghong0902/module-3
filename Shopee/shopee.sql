CREATE SCHEMA `shopee`;

USE `shopee`;
CREATE TABLE `category` (
id INT NOT NULL PRIMARY KEY,
category_name VARCHAR(55)
);

CREATE TABLE `product`(
id INT NOT NULL PRIMARY KEY,
product_name VARCHAR(255),
price BIGINT,
category_id INT NOT NULL,
FOREIGN KEY (category_id) REFERENCES category(id)
);

CREATE TABLE `variant`(
id INT NOT NULL PRIMARY KEY,
color VARCHAR(55),
size VARCHAR(55),
product_id INT NOT NULL,
FOREIGN KEY (product_id) REFERENCES product(id)
);

CREATE TABLE `user`(
id INT NOT NULL PRIMARY KEY,
username VARCHAR(255),
phonenumber VARCHAR(10),
pass_word VARCHAR(255)
);

CREATE TABLE `cart`(
id INT NOT NULL PRIMARY KEY,
total_price BIGINT,
user_id INT NOT NULL UNIQUE,
FOREIGN KEY (user_id) REFERENCES `user`(id)
);

CREATE TABLE `cartline`(
id INT NOT NULL PRIMARY KEY,
quantity INT,
product_id INT NOT NULL,
cart_id INT NOT NULL,
variant_id INT NOT NULL,
FOREIGN KEY (product_id) REFERENCES product(id),
FOREIGN KEY (cart_id) REFERENCES cart(id),
FOREIGN KEY (variant_id) REFERENCES variant(id)
);


CREATE TABLE `order`(
id INT NOT NULL PRIMARY KEY,
total_price BIGINT,
user_id INT NOT NULL,
FOREIGN KEY (user_id) REFERENCES `user`(id)
);

CREATE TABLE `orderline`(
id INT NOT NULL PRIMARY KEY,
sub_price BIGINT,
address VARCHAR(255),
order_id INT NOT NULL,
FOREIGN KEY (order_id) REFERENCES `order`(id)
);


USE shopee;
INSERT INTO category
VALUES (1, 'Thời Trang Nam'),
		(2, 'Thời Trang Nu'),
        (3, 'Thiết Bị Điện Tử'),
        (4, 'Đồng Hồ'),
        (5, 'Giày Dép');


INSERT INTO product
VALUES (1, 'Áo thun ba lỗ', 100000, 1),
		(2, 'Quần baggy nam', 150000, 1),
        (3, 'Quần kaki', 150000, 1),
        (4, 'Áo Hoodie', 250000, 1),
        (5, 'Quần tây nam', 170000, 1),
        (6, 'Quần short đùi nữ', 160000, 2),
		(7, 'Quần baggy nữ', 200000, 2),
        (8, 'Áo chống nắng nữ', 220000, 2),
        (9, 'Đầm babydoll', 200000, 2),
        (10, 'Áo khoác nữ', 300000, 2),
        (11, 'Micro không dây', 250000, 3),
		(12, 'Loa Bluetooth', 550000, 3),
        (13, 'Tai nghe Bluetooth không dây', 450000, 3),
        (14, 'Tai nghe có dây', 350000, 3),
        (15, 'Cáp sạc Iphone', 150000, 3),
        (16, 'Đồng hồ nam', 750000, 4),
		(17, 'Đồng hồ nữ', 850000, 4),
        (18, 'Đồng hồ điện tử', 1500000, 4),
        (19, 'Đồng hồ thể thao', 500000, 4),
        (20, 'Apple Watch', 2050000, 4),
        (21, 'Dép đi trong nhà', 50000, 5),
		(22, 'Dép xỏ ngón', 80000, 5),
        (23, 'Giày thế thao nam', 750000, 5),
        (24, 'Giày thế thao nữ', 950000, 5),
        (25, 'Giày Sneaker', 1000000, 5);
        
INSERT INTO user
VALUES (1, 'hoanghong123', '0772416448', 'honghoang123'),
		(2, 'nguyenduong45', '0128633217', 'haha1234'),
        (3, 'hoangnguyen98', '0816371237', 'abcd12345'),
        (4, 'nganquynh2234', '0324523642', 'ngqn1256'),
        (5, 'thaotrinh1112', '0172362154', 'lttt0981');
        
INSERT INTO variant
VALUES (1, 'red', 'S', 1),
		(2, 'yellow', 'S', 1),
        (3, 'white', 'M', 10),
        (4, 'blue', 'L', 6),
        (5, 'black', 'L', 3),
        (6, 'red', 'S', 2),
		(7, 'yellow', 'S', 2),
        (8, 'white', 'M', 9),
        (9, 'blue', 'L', 8),
        (10, 'black', 'L', 4);
        
INSERT INTO cart 
VALUES (1, 0, 1),
		(2, 0, 2),
        (3, 0, 3),
        (4, 0, 4),
        (5, 0, 5);

INSERT INTO cartline
VALUES (1, 2, 1, 1, 1),
		(2, 1, 6, 1, 4),
        (3, 3, 3, 1, 5),
        (4, 2, 2, 1, 6),
        (5, 1, 9, 2, 8),
        (6, 2, 1, 2, 1),
		(7, 1, 6, 2, 4),
        (8, 3, 3, 2, 5),
        (9, 2, 2, 3, 6),
        (10, 1, 9, 3, 8),
        (11, 2, 1, 3, 1),
		(12, 1, 6, 3, 4),
        (13, 3, 3, 4, 5),
        (14, 2, 2, 4, 6),
        (15, 1, 9, 4, 8),
        (16, 2, 1, 4, 1),
		(17, 1, 6, 5, 4),
        (18, 3, 3, 5, 5),
        (19, 2, 2, 5, 6),
        (20, 1, 9, 5, 8);




SELECT * FROM category;
SELECT * FROM cartline;

SELECT * FROM product WHERE category_id = 1 ORDER BY price  LIMIT 3 OFFSET 0;

SELECT * FROM variant WHERE product_id = 2;

SELECT * FROM cart;
SELECT * FROM cartline WHERE cart_id = 1;
DELETE FROM cartline;


UPDATE cartline SET quantity = 5 WHERE product_id = 4;