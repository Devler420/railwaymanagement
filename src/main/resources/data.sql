CREATE TABLE station (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    station_name VARCHAR(255) NOT NULL,
    location VARCHAR(255) NOT NULL,
    contact_information VARCHAR(255)
);

--INSERT INTO station (station_name, location, contact_information) VALUES ('Mo Chit', 'Bangkok', '111');
--INSERT INTO station (station_name, location, contact_information) VALUES ('Saphan Kwai', 'Bangkok', '222');
--INSERT INTO station (station_name, location, contact_information) VALUES ('Ari', 'Bangkok', '333');
--INSERT INTO station (station_name, location, contact_information) VALUES ('Siam', 'Bangkok', '444');
--INSERT INTO station (station_name, location, contact_information) VALUES ('Victory Monument', 'Bangkok', '555');

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