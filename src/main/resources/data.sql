CREATE TABLE station (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    station_name VARCHAR(255) NOT NULL,
    location VARCHAR(255) NOT NULL,
    contact_information VARCHAR(255)
);

CREATE TABLE train (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    train_number VARCHAR(50) NOT NULL,
    departure_time TIMESTAMP NOT NULL,
    arrival_time TIMESTAMP NOT NULL,
    origin_station_id BIGINT,
    destination_station_id BIGINT,
    seat_capacity INT NOT NULL,
    ticket_price DOUBLE NOT NULL,
    FOREIGN KEY (origin_station_id) REFERENCES station(id),
    FOREIGN KEY (destination_station_id) REFERENCES station(id)
);

CREATE TABLE passenger (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    first_name VARCHAR(255),
    last_name VARCHAR(255),
    citizen_id VARCHAR(255),
    birth_date VARCHAR(255),
    mobile_no VARCHAR(255)
);

CREATE TABLE ticket (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    passenger_id BIGINT,
    train_id BIGINT,
    booking_date TIMESTAMP NOT NULL,
    price DOUBLE NOT NULL,
    seat_number INT NOT NULL,
    FOREIGN KEY (passenger_id) REFERENCES passenger(id),
    FOREIGN KEY (train_id) REFERENCES train(id)
);

-- Sample to populate DB --
INSERT INTO station (station_name, location, contact_information) VALUES
('Bangkok', 'Bangkok', '111'),
('Chiang Mai', 'Chiang Mai', '222'),
('Saraburi', 'Saraburi', '333'),
('Phuket', 'Phuket', '444'),
('Khon Kaen', 'Khon Kaen', '555'),
('Pattaya', 'Chonburi', '666');

-- Sample to populate DB --
INSERT INTO train (train_number, departure_time, arrival_time, origin_station_id, destination_station_id, seat_capacity, ticket_price)
VALUES
('T101', '2023-11-20 10:00:00', '2023-11-20 18:00:00', 1, 2, 200, 50.00),
('T102', '2023-11-21 08:30:00', '2023-11-21 16:30:00', 2, 3, 250, 60.00),
('T103', '2023-11-22 12:00:00', '2023-11-22 20:00:00', 3, 1, 180, 45.00),
('T104', '2023-11-23 09:15:00', '2023-11-23 17:15:00', 1, 4, 300, 70.00),
('T105', '2023-11-24 11:30:00', '2023-11-24 19:30:00', 4, 2, 220, 55.00),
('T106', '2023-11-25 07:45:00', '2023-11-25 15:45:00', 2, 1, 280, 65.00),
('T107', '2023-11-26 13:15:00', '2023-11-26 21:15:00', 3, 4, 150, 40.00),
('T108', '2023-11-27 10:00:00', '2023-11-27 18:00:00', 4, 3, 240, 60.00),
('T109', '2023-11-28 08:30:00', '2023-11-28 16:30:00', 1, 2, 210, 52.50),
('T110', '2023-11-29 12:00:00', '2023-11-29 20:00:00', 2, 3, 260, 62.50);

-- Sample to populate DB --
INSERT INTO ticket (passenger_id, train_id, booking_date, price, seat_number)
VALUES
(1, 1, '2023-11-19 10:00:00', 50.00, 1),
(2, 2, '2023-11-20 08:00:00', 60.00, 2),
(3, 3, '2023-11-21 11:00:00', 45.00, 3),
(4, 4, '2023-11-22 09:00:00', 70.00, 4),
(5, 5, '2023-11-23 11:00:00', 55.00, 5),
(6, 6, '2023-11-24 07:00:00', 65.00, 6),
(7, 7, '2023-11-25 12:00:00', 40.00, 7),
(8, 8, '2023-11-26 09:00:00', 60.00, 8),
(9, 9, '2023-11-27 10:00:00', 52.50, 9),
(10, 10, '2023-11-28 11:00:00', 62.50, 10);