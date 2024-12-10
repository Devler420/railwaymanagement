CREATE TABLE station (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    station_name VARCHAR(255) NOT NULL,
    location VARCHAR(255) NOT NULL,
    contact_information VARCHAR(255)
);

CREATE TABLE train (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    train_number VARCHAR(50),
    departure_time TIMESTAMP,
    arrival_time TIMESTAMP,
    origin_station_id BIGINT,
    destination_station_id BIGINT,
    seat_capacity INT,
    ticket_price DOUBLE,
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
    booking_date TIMESTAMP,
    price DOUBLE,
    seat_number INT,
    FOREIGN KEY (passenger_id) REFERENCES passenger(id),
    FOREIGN KEY (train_id) REFERENCES train(id)
);

--INSERT INTO passenger (first_name, last_name, citizen_id, birth_date, mobile_no)
--VALUES
--('John', 'Doe', 'C123456789', '1990-01-01', '0812345678'),
--('Jane', 'Smith', 'C234567890', '1992-02-02', '0823456789'),
--('Michael', 'Johnson', 'C345678901', '1991-03-03', '0834567890'),
--('Emily', 'Brown', 'C456789012', '1993-04-04', '0845678901'),
--('David', 'Wilson', 'C567890123', '1994-05-05', '0856789012'),
--('Olivia', 'Davis', 'C678901234', '1995-06-06', '0867890123'),
--('James', 'Miller', 'C789012345', '1996-07-07', '0878901234'),
--('Sophia', 'Moore', 'C890123456', '1997-08-08', '0889012345'),
--('William', 'Taylor', 'C901234567', '1998-09-09', '0890123456'),
--('Ava', 'Anderson', 'C012345678', '1999-10-10', '0801234567');
--
--INSERT INTO station (station_name, location, contact_information) VALUES
--('Bangkok', 'Bangkok', '111'),
--('Chiang Mai', 'Chiang Mai', '222'),
--('Saraburi', 'Saraburi', '333'),
--('Phuket', 'Phuket', '444'),
--('Khon Kaen', 'Khon Kaen', '555'),
--('Pattaya', 'Chonburi', '666');
--
--INSERT INTO train (train_number, departure_time, arrival_time, origin_station_id, destination_station_id, seat_capacity, ticket_price)
--VALUES
--('T101', '2023-11-20 10:00:00', '2023-11-20 18:00:00', 1, 2, 200, 50.00),
--('T102', '2023-11-21 08:30:00', '2023-11-21 16:30:00', 2, 3, 250, 60.00),
--('T103', '2023-11-22 12:00:00', '2023-11-22 20:00:00', 3, 1, 180, 45.00),
--('T104', '2023-11-23 09:15:00', '2023-11-23 17:15:00', 1, 4, 300, 70.00),
--('T105', '2023-11-24 11:30:00', '2023-11-24 19:30:00', 4, 2, 220, 55.00),
--('T106', '2023-11-25 07:45:00', '2023-11-25 15:45:00', 2, 1, 280, 65.00),
--('T107', '2023-11-26 13:15:00', '2023-11-26 21:15:00', 3, 4, 150, 40.00),
--('T108', '2023-11-27 10:00:00', '2023-11-27 18:00:00', 4, 3, 240, 60.00),
--('T109', '2023-11-28 08:30:00', '2023-11-28 16:30:00', 1, 2, 210, 52.50),
--('T110', '2023-11-29 12:00:00', '2023-11-29 20:00:00', 2, 3, 260, 62.50);
--
--INSERT INTO ticket (passenger_id, train_id, booking_date, price, seat_number)
--VALUES
--(1, 1, '2023-11-19 10:00:00', 50.00, 1),
--(2, 2, '2023-11-20 08:00:00', 60.00, 2),
--(3, 3, '2023-11-21 11:00:00', 45.00, 3),
--(4, 4, '2023-11-22 09:00:00', 70.00, 4),
--(5, 5, '2023-11-23 11:00:00', 55.00, 5),
--(6, 6, '2023-11-24 07:00:00', 65.00, 6),
--(7, 7, '2023-11-25 12:00:00', 40.00, 7),
--(8, 8, '2023-11-26 09:00:00', 60.00, 8),
--(9, 9, '2023-11-27 10:00:00', 52.50, 9),
--(10, 10, '2023-11-28 11:00:00', 62.50, 10);