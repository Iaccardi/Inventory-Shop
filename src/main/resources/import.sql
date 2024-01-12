-- Insert parts
INSERT INTO Parts (id, name, price, inv, minInv, maxInv, part_type, companyName)
VALUES (1, 'lettuce', 5, 15, 5, 25, 1, NULL)
    ON DUPLICATE KEY UPDATE inv = inv + VALUES(inv);

INSERT INTO Parts (id, name, price, inv, minInv, maxInv, part_type, companyName)
VALUES (2, 'cheese', 5, 15, 5, 25, 1, NULL)
    ON DUPLICATE KEY UPDATE inv = inv + VALUES(inv);

INSERT INTO Parts (id, name, price, inv, minInv, maxInv, part_type, companyName)
VALUES (3, 'mayo', 5, 15, 5, 25, 1, NULL)
    ON DUPLICATE KEY UPDATE inv = inv + VALUES(inv);

INSERT INTO Parts (id, name, price, inv, minInv, maxInv, part_type, companyName)
VALUES (4, 'salami', 5, 15, 5, 25, 2, 'Meat Market')
    ON DUPLICATE KEY UPDATE inv = inv + VALUES(inv);

INSERT INTO Parts (id, name, price, inv, minInv, maxInv, part_type, companyName)
VALUES (5, 'pastrami', 5, 15, 5, 25, 2, 'Meat Market')
    ON DUPLICATE KEY UPDATE inv = inv + VALUES(inv);


-- Sample Products
INSERT INTO products (id, name, price, inv) VALUES
(1, 'salami sandwich', 20, 15),
(2, 'pastrami sandwich', 20, 15),
(3, 'bologna sandwich', 20, 15),
(4, 'turkey sandwich', 20, 15),
(5, 'chicken sandwich', 20, 15);


--Associate each part with each product
INSERT INTO product_part (product_id, part_id) VALUES
(1, 1), (1, 2), (1, 3), (1, 4), (1, 5),
(2, 1), (2, 2), (2, 3), (2, 4), (2, 5),
(3, 1), (3, 2), (3, 3), (3, 4), (3, 5),
(4, 1), (4, 2), (4, 3), (4, 4), (4, 5),
(5, 1), (5, 2), (5, 3), (5, 4), (5, 5);