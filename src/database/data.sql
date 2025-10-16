INSERT INTO MarcaAuto (ID) VALUES
                               ('porsche'),
                               ('ferrari'),
                               ('lamborghini'),
                               ('rolls-royce'),
                               ('bugatti'),
                               ('maserati'),
                               ('mclaren'),
                               ('mercedes'),
                               ('audi'),
                               ('bmw');





-- Porsche
INSERT INTO ModelloAuto (ID, ID_MarcaAuto, Prezzo, Categoria, Descrizione, Anno) VALUES
                                                                                     ('Taycan', 'porsche', 108669.50, 'coupe', '680 CV, 260 km/h.', 2024),
                                                                                     ('Cayenne', 'porsche', 87123.75, 'suv', '474 CV, 275 km/h.', 2024);

-- Ferrari
INSERT INTO ModelloAuto (ID, ID_MarcaAuto, Prezzo, Categoria, Descrizione, Anno) VALUES
                                                                                     ('298 GT3', 'ferrari', 345890.00, 'supercar', '830 CV, 330 km/h.', 2024),
                                                                                     ('Roma', 'ferrari', 249780.00, 'coupe', '620 CV, 320 km/h.', 2024),
                                                                                     ('SF90', 'ferrari', 598500.00, 'supercar', '1000 CV, 340 km/h.', 2024);

-- Lamborghini
INSERT INTO ModelloAuto (ID, ID_MarcaAuto, Prezzo, Categoria, Descrizione, Anno) VALUES
                                                                                     ('Huracan', 'lamborghini', 243567.00, 'supercar', '640 CV, 325 km/h.', 2024),
                                                                                     ('Aventador', 'lamborghini', 438120.00, 'supercar', '770 CV, 350 km/h.', 2021),
                                                                                     ('Urus', 'lamborghini', 245999.00, 'suv', '666 CV, 305 km/h.', 2024),
                                                                                     ('Revuelto', 'lamborghini', 615450.00, 'supercar', '1015 CV, 350 km/h.', 2024);

-- Rolls-Royce
INSERT INTO ModelloAuto (ID, ID_MarcaAuto, Prezzo, Categoria, Descrizione, Anno) VALUES
                                                                                     ('Wraith', 'rolls-royce', 335250.00, 'coupe', '632 CV, 250 km/h.', 2022),
                                                                                     ('Spectre', 'rolls-royce', 425700.00, 'coupe', '584 CV, 250 km/h.', 2024);

-- Bugatti
INSERT INTO ModelloAuto (ID, ID_MarcaAuto, Prezzo, Categoria, Descrizione, Anno) VALUES
                                                                                     ('Chiron', 'bugatti', 3550000.00, 'supercar', '1600 CV, 440 km/h.', 2023),
                                                                                     ('Bolide', 'bugatti', 4100000.00, 'supercar', '1850 CV, 500+ km/h.', 2024),
                                                                                     ('divo', 'bugatti', 5850000.00, 'supercar', '1500 CV, 380 km/h.', 2020),
                                                                                     ('Veyron', 'bugatti', 2250000.00, 'supercar', '1200 CV, 410 km/h.', 2015);

-- Maserati
INSERT INTO ModelloAuto (ID, ID_MarcaAuto, Prezzo, Categoria, Descrizione, Anno) VALUES
                                                                                     ('MC20', 'maserati', 242777.00, 'supercar', '630 CV, 325 km/h.', 2024),
                                                                                     ('Levante', 'maserati', 173450.00, 'suv', '580 CV, 302 km/h.', 2022),
                                                                                     ('Ghibli', 'maserati', 98765.00, 'cabrio', '330 CV, 255 km/h.', 2022),
                                                                                     ('Quattroporte', 'maserati', 123890.00, 'cabrio', '580 CV, 326 km/h.', 2023);

-- McLaren
INSERT INTO ModelloAuto (ID, ID_MarcaAuto, Prezzo, Categoria, Descrizione, Anno) VALUES
                                                                                     ('Artura', 'mclaren', 241550.00, 'supercar', '680 CV, 330 km/h.', 2024),
                                                                                     ('720s', 'mclaren', 308900.00, 'supercar', '720 CV, 341 km/h.', 2023);

-- Mercedes
INSERT INTO ModelloAuto (ID, ID_MarcaAuto, Prezzo, Categoria, Descrizione, Anno) VALUES
                                                                                     ('Amg GT', 'mercedes', 183210.00, 'supercar', '585 CV, 318 km/h.', 2024),
                                                                                     ('EQS', 'mercedes', 137890.00, 'coupe', '523 CV, 210 km/h.', 2024);

-- Audi
INSERT INTO ModelloAuto (ID, ID_MarcaAuto, Prezzo, Categoria, Descrizione, Anno) VALUES
                                                                                     ('R8', 'audi', 203500.00, 'supercar', '620 CV, 331 km/h.', 2023),
                                                                                     ('Q8 e tron', 'audi', 83120.00, 'suv', '408 CV, 200 km/h.', 2024),
                                                                                     ('tt', 'audi', 74250.00, 'coupe', '400 CV, 280 km/h.', 2021);

-- BMW
INSERT INTO ModelloAuto (ID, ID_MarcaAuto, Prezzo, Categoria, Descrizione, Anno) VALUES
                                                                                     ('M8', 'bmw', 140150.00, 'coupe', '625 CV, 250 km/h.', 2025),
                                                                                     ('I7', 'bmw', 142300.00, 'coupe', '544 CV, 240 km/h.', 2025),
                                                                                     ('X6', 'bmw', 136875.00, 'suv', '625 CV, 250 km/h.', 2025),
                                                                                     ('Z4', 'bmw', 68100.00, 'cabrio', '340 CV, 250 km/h.', 2025);




-- Ricambi per Ferrari 298 GT3
INSERT INTO Ricambi (ID, Prezzo, Categoria, Quantità, Anno, ID_ModelloAuto, ID_MarcaAuto)
VALUES
    ('Engine 298 GT3', 12000.00, 'engine', 4, 2024, '298 GT3', 'ferrari'),
    ('Car-body 298 GT3', 9000.00, 'car-body', 3, 2024, '298 GT3', 'ferrari'),
    ('Suspension 298 GT3', 2500.00, 'suspension', 7, 2024, '298 GT3', 'ferrari'),
    ('Tires 298 GT3', 1400.00, 'tires', 20, 2024, '298 GT3', 'ferrari');

-- Ricambi per Ferrari Roma
INSERT INTO Ricambi (ID, Prezzo, Categoria, Quantità, Anno, ID_ModelloAuto, ID_MarcaAuto)
VALUES
    ('Clutch Roma', 3800.00, 'clutch', 6, 2024, 'Roma', 'ferrari'),
    ('Filters Roma', 550.00, 'filters', 15, 2024, 'Roma', 'ferrari'),
    ('Chain Roma', 800.00, 'chain', 11, 2024, 'Roma', 'ferrari');

-- Ricambi per Lamborghini Huracan
INSERT INTO Ricambi (ID, Prezzo, Categoria, Quantità, Anno, ID_ModelloAuto, ID_MarcaAuto)
VALUES
    ('Engine Huracan', 11000.00, 'engine', 3, 2024, 'Huracan', 'lamborghini'),
    ('Clutch Huracan', 4000.00, 'clutch', 5, 2024, 'Huracan', 'lamborghini'),
    ('Car-body Huracan', 8000.00, 'car-body', 2, 2024, 'Huracan', 'lamborghini'),
    ('Suspension Huracan', 2100.00, 'suspension', 8, 2024, 'Huracan', 'lamborghini');

-- Ricambi per Lamborghini Aventador
INSERT INTO Ricambi (ID, Prezzo, Categoria, Quantità, Anno, ID_ModelloAuto, ID_MarcaAuto)
VALUES
    ('Filters Aventador', 620.00, 'filters', 12, 2021, 'Aventador', 'lamborghini'),
    ('Engine Aventador', 13500.00, 'engine', 3, 2021, 'Aventador', 'lamborghini');

-- Ricambi per Bugatti Divo
INSERT INTO Ricambi (ID, Prezzo, Categoria, Quantità, Anno, ID_ModelloAuto, ID_MarcaAuto)
VALUES
    ('Clutch Divo', 8000.00, 'clutch', 4, 2020, 'Divo', 'bugatti'),
    ('Suspension Divo', 3500.00, 'suspension', 3, 2020, 'Divo', 'bugatti');

-- Ricambi per Bugatti Veyron
INSERT INTO Ricambi (ID, Prezzo, Categoria, Quantità, Anno, ID_ModelloAuto, ID_MarcaAuto)
VALUES
    ('Filters Veyron', 1500.00, 'filters', 6, 2015, 'Veyron', 'bugatti'),
    ('Chain Veyron', 1100.00, 'chain', 5, 2015, 'Veyron', 'bugatti');

-- Ricambi per Maserati Levante
INSERT INTO Ricambi (ID, Prezzo, Categoria, Quantità, Anno, ID_ModelloAuto, ID_MarcaAuto)
VALUES
    ('Engine Levante', 8200.00, 'engine', 4, 2022, 'Levante', 'maserati'),
    ('Clutch Levante', 2800.00, 'clutch', 8, 2022, 'Levante', 'maserati');

-- Ricambi per Maserati Quattroporte
INSERT INTO Ricambi (ID, Prezzo, Categoria, Quantità, Anno, ID_ModelloAuto, ID_MarcaAuto)
VALUES
    ('Filters Quattroporte', 700.00, 'filters', 13, 2023, 'Quattroporte', 'maserati'),
    ('Car-body Quattroporte', 6000.00, 'car-body', 2, 2023, 'Quattroporte', 'maserati');

-- Ricambi per Mercedes Amg GT
INSERT INTO Ricambi (ID, Prezzo, Categoria, Quantità, Anno, ID_ModelloAuto, ID_MarcaAuto)
VALUES
    ('Engine Amg GT', 9200.00, 'engine', 4, 2024, 'Amg GT', 'mercedes'),
    ('Car-body Amg GT', 6100.00, 'car-body', 2, 2024, 'Amg GT', 'mercedes'),
    ('Suspension Amg GT', 2100.00, 'suspension', 7, 2024, 'Amg GT', 'mercedes');




