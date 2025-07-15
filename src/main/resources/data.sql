INSERT INTO Hardware (name, code, price, type, quantity) VALUES
('Intel Core i7', 'CPU123', 299.99, 'CPU', 10),
('NVIDIA RTX 4090', 'GPU999', 1999.99, 'GPU', 5),
('ASUS ROG Strix Z790', 'MBO456', 399.99, 'MBO', 7),
('Corsair Vengeance 32GB DDR5', 'RAM321', 169.99, 'RAM', 20),
('Samsung 970 EVO Plus 1TB', 'SSD101', 109.99, 'STORAGE', 15);

INSERT INTO Category (name, description) VALUES
('Procesori', 'Centralne procesorske jedinice za stolna računala'),
('Grafičke kartice', 'GPU uređaji za prikaz slike i 3D obradu'),
('Matične ploče', 'Ploče za povezivanje svih komponenti računala'),
('Radna memorija', 'Privremena memorija visokih performansi'),
('Pohrana', 'SSD i HDD uređaji za dugotrajno spremanje podataka');

INSERT INTO Article (name, description, price, category_id) VALUES
('Intel Core i9 13900K', '13. generacija procesora visokih performansi', 689.99, 1),
('AMD Ryzen 9 7950X', 'Napredni 16-jezgreni procesor za zahtjevne korisnike', 649.50, 1),
('NVIDIA GeForce RTX 4080', 'Gaming GPU nove generacije s podrškom za ray tracing', 1199.00, 2),
('ASUS ROG Strix Z790-E', 'Matična ploča s podrškom za DDR5 memoriju', 399.99, 3),
('Corsair Vengeance 32GB DDR5', 'Visokofrekventna memorija za multitasking', 169.99, 4),
('Samsung 980 PRO 1TB', 'NVMe SSD za brzi pristup podacima', 129.99, 5);
