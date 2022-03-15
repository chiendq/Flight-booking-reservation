create table airlines
(
    id     bigint auto_increment
        primary key,
    imgapi varchar(255) null,
    name   varchar(255) null
);

INSERT INTO flightbooking.airlines (id, imgapi, name) VALUES (1, 'https://storage.googleapis.com/tripi-flights/agenticons/Vietjet_Air_logo_transparent.png', 'Vietjet Air');
INSERT INTO flightbooking.airlines (id, imgapi, name) VALUES (2, 'https://storage.googleapis.com/tripi-flights/agenticons/VietnamAirlines_logo_transparent.png', 'Vietname Arilines');
INSERT INTO flightbooking.airlines (id, imgapi, name) VALUES (3, 'https://storage.googleapis.com/tripi-flights/agenticons/bamboo_airway.png', 'Bamboo Airway');
INSERT INTO flightbooking.airlines (id, imgapi, name) VALUES (4, 'https://storage.googleapis.com/tripi-flights/agenticons/Pacific%20Airlines.png', 'Pacific Airlines
');

create table fly_class
(
    id          bigint auto_increment
        primary key,
    code        varchar(255) null,
    description varchar(255) null,
    name        varchar(255) null,
    constraint UK_xx5cuhr4urgdndwovarm3bd2
        unique (code)
);

INSERT INTO flightbooking.fly_class (id, code, description, name) VALUES (1, 'ECL', 'Bay tiết kiệm, đáp ứng mọi nhu cầu cơ bản', 'Economy Class');
INSERT INTO flightbooking.fly_class (id, code, description, name) VALUES (2, 'SEC', 'Chi phí hợp lý với bữa ăn ngon và chỗ để chân rộng rãi.', 'Special Economy Class');
INSERT INTO flightbooking.fly_class (id, code, description, name) VALUES (3, 'BCL', 'Bay đẳng cấp, với quầy làm thủ tục và khu ghế ngồi riêng.', 'Business Class');
INSERT INTO flightbooking.fly_class (id, code, description, name) VALUES (4, 'FCL', 'Bay đẳng cấp, với quầy làm thủ tục và khu ghế ngồi riêng.', 'First Class');

create table locations
(
    id      bigint       not null
        primary key,
    airport varchar(255) null,
    code    varchar(255) null,
    city    varchar(255) null
);

INSERT INTO flightbooking.locations (id, airport, code, city) VALUES (1, 'Sân bay Nội Bài', 'HAN', 'Hà Nội');
INSERT INTO flightbooking.locations (id, airport, code, city) VALUES (2, 'Sân bay Tân Sơn Nhất', 'SGN', 'Hồ Chí Minh');
INSERT INTO flightbooking.locations (id, airport, code, city) VALUES (3, 'Sân bay Quốc Tế Đà Nẵng', 'DAD', 'Đà Nẵng');
INSERT INTO flightbooking.locations (id, airport, code, city) VALUES (4, 'Sân bay Cam Ranh', 'CXR', 'Nha Trang');
INSERT INTO flightbooking.locations (id, airport, code, city) VALUES (5, 'Sân bay quốc tế Phú Quốc', 'PQC', 'Phú Quốc');
INSERT INTO flightbooking.locations (id, airport, code, city) VALUES (6, 'Sân bay Quốc tế Phú Bài', 'HUI', 'Huế');
INSERT INTO flightbooking.locations (id, airport, code, city) VALUES (7, 'Sân bay Quốc Tế Cát Bi', 'HPH', 'Hải Phòng');

create table roles
(
    role_id int auto_increment
        primary key,
    name    varchar(255) null
);

INSERT INTO flightbooking.roles (role_id, name) VALUES (1, 'USER');
INSERT INTO flightbooking.roles (role_id, name) VALUES (2, 'ADMIN');

create table tickets
(
    id                    bigint auto_increment
        primary key,
    airlines              varchar(255) null,
    airplane              varchar(255) null,
    arrival_time          datetime     null,
    cost                  int          null,
    departure_time        datetime     null,
    estimated_time        int          not null,
    sold                  bit          not null,
    hand_luggage          int          null,
    registered_luggage    int          null,
    service_charge        int          null,
    taxes                 int          null,
    fly_class_id          bigint       null,
    arrival_location_id   bigint       null,
    departure_location_id bigint       null,
    fly_class_code        varchar(255) null,
    airlines_id           bigint       null,
    luggage_iconurl       varchar(255) null,
    fees                  int          null
);

INSERT INTO flightbooking.tickets (id, airlines, airplane, arrival_time, cost, departure_time, estimated_time, sold, hand_luggage, registered_luggage, service_charge, taxes, fly_class_id, arrival_location_id, departure_location_id, fly_class_code, airlines_id, luggage_iconurl, fees) VALUES (1, 'VietName Arilines', 'Airbus A320', '2022-03-10 16:00:00', 250000, '2022-03-11 16:06:02', 2, false, 7, 0, 35000, 25000, 1, 2, 4, 'ECL', 1, 'https://www.iconpacks.net/icons/2/free-baggage-icon-1834-thumb.png', 10000);
INSERT INTO flightbooking.tickets (id, airlines, airplane, arrival_time, cost, departure_time, estimated_time, sold, hand_luggage, registered_luggage, service_charge, taxes, fly_class_id, arrival_location_id, departure_location_id, fly_class_code, airlines_id, luggage_iconurl, fees) VALUES (2, 'Vietjet Air', 'VJ139', '2022-03-10 16:21:24', 300000, '2022-03-10 16:21:28', 3, false, 20, 1, 29000, 15000, 2, 3, 5, 'FCL', 2, 'https://www.iconpacks.net/icons/2/free-baggage-icon-1834-thumb.png', 11000);

create table users
(
    user_id     bigint auto_increment
        primary key,
    enabled     bit          not null,
    password    varchar(255) null,
    username    varchar(255) null,
    dateofbirth date         null,
    email       varchar(255) null,
    fullname    varchar(255) null,
    gender      bit          not null,
    is_exist    bit          not null,
    phone       varchar(11)  null
);

INSERT INTO flightbooking.users (user_id, enabled, password, username, dateofbirth, email, fullname, gender, is_exist, phone) VALUES (1, true, '$2a$10$94SrHjVk2T8GM6jMPTqtSei6QHeuVsqk9Iasd2Kw2ZJ26..UVzMqy', 'user', null, null, null, false, true, null);
INSERT INTO flightbooking.users (user_id, enabled, password, username, dateofbirth, email, fullname, gender, is_exist, phone) VALUES (2, true, '$2a$10$94SrHjVk2T8GM6jMPTqtSei6QHeuVsqk9Iasd2Kw2ZJ26..UVzMqy', 'admin', null, null, null, false, true, null);
INSERT INTO flightbooking.users (user_id, enabled, password, username, dateofbirth, email, fullname, gender, is_exist, phone) VALUES (3, true, '$2a$10$94SrHjVk2T8GM6jMPTqtSei6QHeuVsqk9Iasd2Kw2ZJ26..UVzMqy', '12345678', '2022-03-16', 'sdfdff@gmail.com', 'Đào Quyết Chiến', false, true, '0136580147');
INSERT INTO flightbooking.users (user_id, enabled, password, username, dateofbirth, email, fullname, gender, is_exist, phone) VALUES (4, false, '$2a$10$ycP7OHrB6c4BxV57LVLNiu9fOdYXC6pwoBgvNSJ93uPzz.2/KLMOm', '190104015322', '2022-03-17', 'chiendao13092001@gmail.com', 'Đào Quyết Chiến', false, false, '0365801532');
INSERT INTO flightbooking.users (user_id, enabled, password, username, dateofbirth, email, fullname, gender, is_exist, phone) VALUES (5, false, '$2a$10$ix3ran7bsKSr0b9nTEoBc.2VO.9Vt6eyeP7j9w2dcGrBrLBTUoVWe', '190104015322222', '2022-03-11', 'chiendao1309202201@sdsd.com', '190104015322', false, false, '0365801532');

create table users_roles
(
    user_id bigint not null,
    role_id int    not null,
    primary key (user_id, role_id)
);


INSERT INTO flightbooking.users_roles (user_id, role_id) VALUES (1, 1);
INSERT INTO flightbooking.users_roles (user_id, role_id) VALUES (2, 2);
