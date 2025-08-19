-- Insert categories
INSERT INTO category (id, name, description) VALUES 
(1, 'Electronics', 'Electronic devices and gadgets'),
(2, 'Home & Kitchen', 'Products for home and kitchen use'),
(3, 'Books', 'Books of various genres'),
(4, 'Clothing', 'Clothing items for all ages'),
(5, 'Sports & Outdoors', 'Sports equipment and outdoor gear'),
(6, 'Beauty & Personal Care', 'Beauty and personal care products'),
(7, 'Toys & Games', 'Toys and games for all ages'),
(8, 'Health & Wellness', 'Health and wellness products'),
(9, 'Automotive', 'Automotive parts and accessories'),
(10, 'Office Supplies', 'Office and stationery products');

-- Insert products for Electronics category
INSERT INTO product (id, name, description, available_quantity, price, category_id) VALUES 
(101, 'Smartphone X', 'Latest smartphone with advanced features', 150, 799.99, 1),
(102, 'Laptop Pro', 'High-performance laptop for professionals', 75, 1299.99, 1),
(103, 'Wireless Headphones', 'Noise-cancelling wireless headphones', 200, 149.99, 1),
(104, 'Smart TV 55"', '55-inch 4K Smart TV with HDR', 60, 549.99, 1),
(105, 'Digital Camera', 'Professional digital camera with accessories', 40, 699.99, 1),
(106, 'Tablet Ultra', 'Lightweight tablet with high-resolution display', 120, 399.99, 1),
(107, 'Bluetooth Speaker', 'Portable Bluetooth speaker with deep bass', 180, 89.99, 1),
(108, 'Smartwatch', 'Fitness and health tracking smartwatch', 160, 199.99, 1);

-- Insert products for Home & Kitchen category
INSERT INTO product (id, name, description, available_quantity, price, category_id) VALUES 
(201, 'Coffee Maker', 'Programmable coffee maker with thermal carafe', 90, 79.99, 2),
(202, 'Blender Pro', 'High-speed blender for smoothies and more', 70, 129.99, 2),
(203, 'Cookware Set', '10-piece non-stick cookware set', 50, 199.99, 2),
(204, 'Air Fryer', 'Digital air fryer with multiple cooking modes', 85, 149.99, 2),
(205, 'Vacuum Cleaner', 'Cordless vacuum cleaner with strong suction', 60, 249.99, 2),
(206, 'Toaster Oven', 'Convection toaster oven with digital controls', 75, 89.99, 2),
(207, 'Stand Mixer', 'Professional stand mixer for baking', 45, 299.99, 2),
(208, 'Food Processor', 'Multi-function food processor', 55, 119.99, 2);

-- Insert products for Books category
INSERT INTO product (id, name, description, available_quantity, price, category_id) VALUES 
(301, 'Modern Programming', 'Complete guide to modern programming techniques', 100, 34.99, 3),
(302, 'Mystery Thriller', 'Bestselling mystery thriller novel', 150, 24.99, 3),
(303, 'Cookbook Deluxe', 'Gourmet recipes from around the world', 80, 39.99, 3),
(304, 'History Encyclopedia', 'Comprehensive history encyclopedia', 60, 49.99, 3),
(305, 'Science Fiction Collection', 'Collection of award-winning sci-fi stories', 90, 29.99, 3),
(306, 'Self-Help Guide', 'Practical self-improvement guide', 120, 19.99, 3),
(307, 'Business Strategy', 'Modern business strategy handbook', 85, 44.99, 3),
(308, 'Fantasy Epic', 'Epic fantasy novel series first book', 110, 27.99, 3);

-- Insert products for Clothing category
INSERT INTO product (id, name, description, available_quantity, price, category_id) VALUES 
(401, 'Casual T-Shirt', 'Comfortable cotton casual t-shirt', 200, 19.99, 4),
(402, 'Jeans Classic', 'Classic fit denim jeans', 150, 49.99, 4),
(403, 'Winter Jacket', 'Insulated winter jacket with hood', 80, 129.99, 4),
(404, 'Running Shoes', 'Lightweight running shoes with cushioning', 120, 89.99, 4),
(405, 'Dress Shirt', 'Formal dress shirt for professional settings', 100, 59.99, 4),
(406, 'Casual Hoodie', 'Casual hoodie with front pocket', 160, 39.99, 4),
(407, 'Athletic Shorts', 'Breathable athletic shorts', 180, 29.99, 4),
(408, 'Wool Sweater', 'Warm wool sweater for cold weather', 90, 69.99, 4);

-- Insert products for Sports & Outdoors category
INSERT INTO product (id, name, description, available_quantity, price, category_id) VALUES 
(501, 'Yoga Mat', 'Non-slip yoga mat with carrying strap', 120, 29.99, 5),
(502, 'Dumbbells Set', 'Adjustable dumbbells set with rack', 60, 149.99, 5),
(503, 'Tennis Racket', 'Professional tennis racket', 80, 89.99, 5),
(504, 'Hiking Backpack', 'Durable hiking backpack with hydration system', 70, 79.99, 5),
(505, 'Camping Tent', '4-person waterproof camping tent', 50, 199.99, 5),
(506, 'Basketball', 'Official size basketball', 100, 34.99, 5),
(507, 'Fitness Tracker', 'Advanced fitness and activity tracker', 150, 99.99, 5),
(508, 'Bicycle Helmet', 'Safety-certified bicycle helmet', 90, 54.99, 5);

-- Insert products for Beauty & Personal Care category
INSERT INTO product (id, name, description, available_quantity, price, category_id) VALUES 
(601, 'Face Cream', 'Hydrating face cream for all skin types', 130, 24.99, 6),
(602, 'Hair Dryer', 'Professional ionic hair dryer', 80, 59.99, 6),
(603, 'Perfume Set', 'Luxury perfume gift set', 70, 89.99, 6),
(604, 'Electric Shaver', 'Rechargeable electric shaver for men', 90, 79.99, 6),
(605, 'Makeup Kit', 'Complete makeup kit with case', 60, 99.99, 6),
(606, 'Facial Cleanser', 'Gentle facial cleanser for daily use', 110, 19.99, 6),
(607, 'Hair Styling Kit', 'Professional hair styling kit', 50, 129.99, 6),
(608, 'Manicure Set', 'Complete manicure and pedicure set', 85, 34.99, 6);

-- Insert products for Toys & Games category
INSERT INTO product (id, name, description, available_quantity, price, category_id) VALUES 
(701, 'Building Blocks', 'Creative building blocks set (500 pieces)', 100, 39.99, 7),
(702, 'Board Game Collection', 'Family board games collection', 70, 49.99, 7),
(703, 'Remote Control Car', 'High-speed remote control racing car', 80, 59.99, 7),
(704, 'Plush Teddy Bear', 'Soft plush teddy bear', 150, 24.99, 7),
(705, 'Educational Puzzle', 'Educational puzzle set for kids', 120, 29.99, 7),
(706, 'Action Figure Set', 'Collectible action figures set', 90, 34.99, 7),
(707, 'Dollhouse', 'Wooden dollhouse with furniture', 50, 99.99, 7),
(708, 'Science Kit', 'Educational science experiments kit', 65, 44.99, 7);

-- Insert products for Health & Wellness category
INSERT INTO product (id, name, description, available_quantity, price, category_id) VALUES 
(801, 'Vitamin Pack', 'Complete daily vitamin supplement pack', 200, 29.99, 8),
(802, 'Digital Scale', 'Digital bathroom scale with body composition', 80, 49.99, 8),
(803, 'Massage Gun', 'Deep tissue percussion massage gun', 70, 129.99, 8),
(804, 'First Aid Kit', 'Comprehensive first aid kit', 150, 39.99, 8),
(805, 'Essential Oils Set', 'Aromatherapy essential oils collection', 90, 59.99, 8),
(806, 'Sleep Monitor', 'Sleep quality monitoring device', 60, 89.99, 8),
(807, 'Blood Pressure Monitor', 'Digital blood pressure monitoring system', 75, 69.99, 8),
(808, 'Meditation Cushion', 'Comfortable meditation cushion set', 100, 44.99, 8);

-- Insert products for Automotive category
INSERT INTO product (id, name, description, available_quantity, price, category_id) VALUES 
(901, 'Car Wax', 'Premium car wax and polish', 120, 19.99, 9),
(902, 'Jump Starter', 'Portable car battery jump starter', 70, 89.99, 9),
(903, 'Dash Camera', 'HD dashboard camera with night vision', 80, 129.99, 9),
(904, 'Tire Pressure Gauge', 'Digital tire pressure gauge', 150, 24.99, 9),
(905, 'Car Seat Covers', 'Universal fit car seat covers set', 90, 59.99, 9),
(906, 'Car Vacuum Cleaner', 'Portable car vacuum cleaner', 100, 39.99, 9),
(907, 'Car Phone Mount', 'Adjustable car phone mount', 180, 19.99, 9),
(908, 'Car Air Fresheners', 'Long-lasting car air fresheners pack', 200, 14.99, 9);

-- Insert products for Office Supplies category
INSERT INTO product (id, name, description, available_quantity, price, category_id) VALUES 
(1001, 'Desk Organizer', 'Multi-compartment desk organizer', 100, 24.99, 10),
(1002, 'Fountain Pen', 'Luxury fountain pen with ink', 70, 49.99, 10),
(1003, 'Notebook Set', 'Premium ruled notebooks (set of 3)', 150, 19.99, 10),
(1004, 'Desk Lamp', 'Adjustable LED desk lamp', 80, 39.99, 10),
(1005, 'Office Chair', 'Ergonomic office chair with lumbar support', 50, 199.99, 10),
(1006, 'Paper Shredder', 'Cross-cut paper shredder', 60, 79.99, 10),
(1007, 'Stapler Set', 'Heavy-duty stapler with staples', 110, 14.99, 10),
(1008, 'Wireless Mouse', 'Ergonomic wireless computer mouse', 120, 29.99, 10);
