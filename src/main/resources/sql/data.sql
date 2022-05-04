INSERT INTO airlines (imgapi, name) VALUES ('https://storage.googleapis.com/tripi-flights/agenticons/Vietjet_Air_logo_transparent.png', 'Vietjet Air');
INSERT INTO airlines (imgapi, name) VALUES ('https://storage.googleapis.com/tripi-flights/agenticons/VietnamAirlines_logo_transparent.png', 'Vietname Arilines');
INSERT INTO airlines (imgapi, name) VALUES ('https://storage.googleapis.com/tripi-flights/agenticons/bamboo_airway.png', 'Bamboo Airway');
INSERT INTO airlines (imgapi, name) VALUES ('https://storage.googleapis.com/tripi-flights/agenticons/Pacific%20Airlines.png', 'Pacific Airlines');

INSERT INTO airplanes (code) VALUES ('Airbus A320');
INSERT INTO airplanes (code) VALUES ('Airbus A321');
INSERT INTO airplanes (code) VALUES ('Airbus A350');
INSERT INTO airplanes (code) VALUES ('Boeing 787');
INSERT INTO airplanes (code) VALUES ('VN262');
INSERT INTO airplanes (code) VALUES ('VN260');
INSERT INTO airplanes (code) VALUES ('VN321');
INSERT INTO airplanes (code) VALUES ('QH280');

INSERT INTO airlines_airplane_list (airline_id, airplane_list_id) VALUES (1, 2);
INSERT INTO airlines_airplane_list (airline_id, airplane_list_id) VALUES (2, 3);
INSERT INTO airlines_airplane_list (airline_id, airplane_list_id) VALUES (3, 1);
INSERT INTO airlines_airplane_list (airline_id, airplane_list_id) VALUES (4, 8);
INSERT INTO airlines_airplane_list (airline_id, airplane_list_id) VALUES (3, 7);
INSERT INTO airlines_airplane_list (airline_id, airplane_list_id) VALUES (4, 5);
INSERT INTO airlines_airplane_list (airline_id, airplane_list_id) VALUES (2, 6);
INSERT INTO airlines_airplane_list (airline_id, airplane_list_id) VALUES (1, 4);
INSERT INTO airlines_airplane_list (airline_id, airplane_list_id) VALUES (1, 2);

INSERT INTO airports (city, code, name) VALUES ('Hà Nội', 'HAN', 'Sân bay Nội Bài');
INSERT INTO airports (city, code, name) VALUES ('Hồ Chí Minh', 'SGN', 'Sân bay Tân Sơn Nhất');
INSERT INTO airports (city, code, name) VALUES ('Đà Nẵng', 'DAD', 'Sân bay Quốc Tế Đà Nẵng');
INSERT INTO airports (city, code, name) VALUES ('Nha Trang', 'CXR', 'Sân bay Cam Ranh');
INSERT INTO airports (city, code, name) VALUES ('Phú Quốc', 'PQC', 'Sân bay quốc tế Phú Quốc');
INSERT INTO airports (city, code, name) VALUES ('Huế', 'HUI', 'Sân bay Quốc tế Phú Bài');
INSERT INTO airports (city, code, name) VALUES ('Hải Phòng', 'HPH', 'Sân bay Quốc Tế Cát Bi');

INSERT INTO flight_class (code, description, name) VALUES ('ECL', 'Bay tiết kiệm, đáp ứng mọi nhu cầu cơ bản', 'Economy Class');
INSERT INTO flight_class (code, description, name) VALUES ('SEC', 'Chi phí hợp lý với bữa ăn ngon và chỗ để chân rộng rãi.', 'Special Economy Class');
INSERT INTO flight_class (code, description, name) VALUES ('BCL', 'Bay đẳng cấp, với quầy làm thủ tục và khu ghế ngồi riêng.', 'Business Class');
INSERT INTO flight_class (code, description, name) VALUES ('FCL', 'Bay đẳng cấp, với quầy làm thủ tục và khu ghế ngồi riêng.', 'First Class');

INSERT INTO roles (description, name) VALUES (null, 'USER');
INSERT INTO roles (description, name) VALUES (null, 'ADMIN');

INSERT INTO users (date_of_birth, email, enabled, full_name, gender, identity_number, is_exist, password, phone, username, role_id) VALUES ('1998-05-21', 'user@gmail.com', true, 'USER TEST', true, '1901040037', true, '$2a$10$G9xgysnAa5Y6Mj9jWRfsa.iKXEchPGKbkeWGqBT0yR2jBxUcdOV6G', '0987654321', 'user', 1);
INSERT INTO users (date_of_birth, email, enabled, full_name, gender, identity_number, is_exist, password, phone, username, role_id) VALUES ('1998-05-21', 'admin@gmail.com', true, 'ADMIN TEST', false, '123456789', true, '$2a$10$G9xgysnAa5Y6Mj9jWRfsa.iKXEchPGKbkeWGqBT0yR2jBxUcdOV6G', '0123456789', 'admin', 2);
INSERT INTO users (date_of_birth, email, enabled, full_name, gender, identity_number, is_exist, password, phone, username, role_id) VALUES ('1998-05-21', 'test@gmail.com', false, 'TESTED aaa', true, '655645646', false, '$2a$10$G9xgysnAa5Y6Mj9jWRfsa.iKXEchPGKbkeWGqBT0yR2jBxUcdOV6G', '1516554646', 'test12345', null);
INSERT INTO users (date_of_birth, email, enabled, full_name, gender, identity_number, is_exist, password, phone, username, role_id) VALUES ('1998-05-21', 'chien123@sdsd.com', true, 'Chien 123', false, '123456789', true, '$2a$10$2RpQkKvfSVntnjrIW/Hp6umGOjE9w6aR4DLHDKO0euFcIFhcznmKa', '0365801532', 'chiendao123', 1);
INSERT INTO users (date_of_birth, email, enabled, full_name, gender, identity_number, is_exist, password, phone, username, role_id) VALUES ('1998-05-21', 'chiendao123@sdsd.com', true, 'Chien Dao', false, '123456789', true, '$2a$10$wB0eLzUA0GduAIDcVvTeDO6iCzY/ZZaIiJs71Q7uuynVg7JHWzvtS', '0365801532', 'daochien', 1);
INSERT INTO users (date_of_birth, email, enabled, full_name, gender, identity_number, is_exist, password, phone, username, role_id) VALUES ('2022-04-20', 'adminadminadmin@gmail.com', false, 'adminadminadmin', false, null, false, '$2a$10$NC5cZBZX/j3K.vk/TUXTxeC6cjGXH3Q7p.6fowWu98BoCgdBJATPm', '0365801532', null, null);

INSERT INTO tickets (arrival_time, available, cost, departure_time, estimated_time, fees, hand_luggage, is_round_trip, registered_luggage, service_charge, taxes, airline_id, airplane_id, arrival_airport_id, departure_airport_id, flight_class_id) VALUES ('2022-04-04 15:20:25', true, 11111111, '2022-03-31 15:00:00', 2, 25000, 1, false, 1, 300000, 150000, 1, 8, 1, 4, 1);
INSERT INTO tickets (arrival_time, available, cost, departure_time, estimated_time, fees, hand_luggage, is_round_trip, registered_luggage, service_charge, taxes, airline_id, airplane_id, arrival_airport_id, departure_airport_id, flight_class_id) VALUES ('2022-04-04 08:20:25', true, 222222222, '2022-03-31 15:00:00', 1, 25000, 2, false, 2, 300000, 150000, 2, 7, 2, 3, 2);
INSERT INTO tickets (arrival_time, available, cost, departure_time, estimated_time, fees, hand_luggage, is_round_trip, registered_luggage, service_charge, taxes, airline_id, airplane_id, arrival_airport_id, departure_airport_id, flight_class_id) VALUES ('2022-04-04 08:20:25', true, 333333333, '2022-03-31 15:00:00', 5, 25000, 2, true, 3, 300000, 150000, 3, 6, 3, 5, 3);
INSERT INTO tickets (arrival_time, available, cost, departure_time, estimated_time, fees, hand_luggage, is_round_trip, registered_luggage, service_charge, taxes, airline_id, airplane_id, arrival_airport_id, departure_airport_id, flight_class_id) VALUES ('2022-04-04 08:20:25', true, 4444444, '2022-03-20 18:00:00', 2, 25000, 3, false, 3, 300000, 150000, 4, 5, 1, 2, 4);
INSERT INTO tickets (arrival_time, available, cost, departure_time, estimated_time, fees, hand_luggage, is_round_trip, registered_luggage, service_charge, taxes, airline_id, airplane_id, arrival_airport_id, departure_airport_id, flight_class_id) VALUES ('2022-04-04 08:20:25', true, 5555555, '2022-03-27 23:00:00', 3, 25000, 4, true, 2, 300000, 150000, 3, 3, 3, 4, 4);
INSERT INTO tickets (arrival_time, available, cost, departure_time, estimated_time, fees, hand_luggage, is_round_trip, registered_luggage, service_charge, taxes, airline_id, airplane_id, arrival_airport_id, departure_airport_id, flight_class_id) VALUES ('2022-04-04 08:20:25', true, 66666666, '2022-03-27 12:00:00', 5, 25000, 5, false, 1, 300000, 150000, 2, 2, 2, 1, 2);
INSERT INTO tickets (arrival_time, available, cost, departure_time, estimated_time, fees, hand_luggage, is_round_trip, registered_luggage, service_charge, taxes, airline_id, airplane_id, arrival_airport_id, departure_airport_id, flight_class_id) VALUES ('2022-04-04 08:20:25', true, 8888888, '2022-03-27 20:00:00', 8, 25000, 2, true, 1, 300000, 150000, 1, 4, 4, 2, 1);
INSERT INTO tickets (arrival_time, available, cost, departure_time, estimated_time, fees, hand_luggage, is_round_trip, registered_luggage, service_charge, taxes, airline_id, airplane_id, arrival_airport_id, departure_airport_id, flight_class_id) VALUES ('2022-04-04 08:20:25', true, 888888, '2022-03-27 18:00:00', 7, 25000, 3, false, 2, 300000, 150000, 4, 1, 1, 3, 3);
INSERT INTO tickets (arrival_time, available, cost, departure_time, estimated_time, fees, hand_luggage, is_round_trip, registered_luggage, service_charge, taxes, airline_id, airplane_id, arrival_airport_id, departure_airport_id, flight_class_id) VALUES ('2022-04-04 08:20:25', true, 66666666, '2022-03-27 12:00:00', 2, 25000, 3, false, 2, 300000, 150000, 1, 4, 2, 1, 1);
INSERT INTO tickets (arrival_time, available, cost, departure_time, estimated_time, fees, hand_luggage, is_round_trip, registered_luggage, service_charge, taxes, airline_id, airplane_id, arrival_airport_id, departure_airport_id, flight_class_id) VALUES ('2022-04-04 08:20:25', true, 66666666, '2022-03-27 12:00:00', 3, 25000, 2, false, 3, 300000, 150000, 3, 3, 2, 1, 3);
INSERT INTO tickets (arrival_time, available, cost, departure_time, estimated_time, fees, hand_luggage, is_round_trip, registered_luggage, service_charge, taxes, airline_id, airplane_id, arrival_airport_id, departure_airport_id, flight_class_id) VALUES ('2022-04-04 08:20:25', true, 66666666, '2022-03-27 12:00:00', 1, 25000, 1, false, 1, 300000, 150000, 4, 8, 2, 1, 4);

INSERT INTO payment (amount, status, transaction_date, adult_num, baby_num, child_num, payment_type) VALUES (600000, '1', '2022-03-20 14:47:44', 0, 0, 0, null);
INSERT INTO payment (amount, status, transaction_date, adult_num, baby_num, child_num, payment_type) VALUES (666666, '1', '2022-03-22 14:15:38', 0, 0, 0, null);
INSERT INTO payment (amount, status, transaction_date, adult_num, baby_num, child_num, payment_type) VALUES (0, 'Pending', '2022-04-13 22:27:11', 1, 0, 0, 'Bank transfer');
INSERT INTO payment (amount, status, transaction_date, adult_num, baby_num, child_num, payment_type) VALUES (0, 'Pending', '2022-04-13 22:32:13', 1, 0, 0, 'Bank transfer');
INSERT INTO payment (amount, status, transaction_date, adult_num, baby_num, child_num, payment_type) VALUES (0, 'Pending', '2022-04-14 09:43:38', 1, 0, 0, 'QR-Pay');

INSERT INTO passengers (date_of_birth, email, full_name, identity_number, phone_number, gender) VALUES ('2000-03-13', 'passenger@gmail.com', 'Passenger1', '1111111111111', '1234567890', false);
INSERT INTO passengers (date_of_birth, email, full_name, identity_number, phone_number, gender) VALUES ('2000-03-14', 'passenger1@gmail.com', 'Passenger2', '1111111111111', '0123456897', false);
INSERT INTO passengers (date_of_birth, email, full_name, identity_number, phone_number, gender) VALUES ('2000-03-15', 'passenger2@gmail.com', 'Passenger3', '1111111111111', '0123456897', false);
INSERT INTO passengers (date_of_birth, email, full_name, identity_number, phone_number, gender) VALUES ('2000-03-16', 'passenger2@gmail.com', 'Passenger4', '1111111111111', '0123456897', false);
INSERT INTO passengers (date_of_birth, email, full_name, identity_number, phone_number, gender) VALUES ('2000-03-17', 'passenger2@gmail.com', 'Passenger5', '1111111111111', '0123456897', false);
INSERT INTO passengers (date_of_birth, email, full_name, identity_number, phone_number, gender) VALUES ('2022-04-13', 'chiendao13092001@gmail.com', 'Đào Quyết Chiến', '456456456456456456', '+84365801570', false);
INSERT INTO passengers (date_of_birth, email, full_name, identity_number, phone_number, gender) VALUES ('2022-04-13', 'chiendao13092001@gmail.com', 'Đào Quyết Chiến', '456456456456456456', '+84365801570', false);
INSERT INTO passengers (date_of_birth, email, full_name, identity_number, phone_number, gender) VALUES ('2022-04-14', 'chiendao13092001@gmail.com', 'Đào Quyết Chiến', '445345345', '+84365801570', false);


INSERT INTO booking (booked_time, status, passenger_id, payment_id, ticket_id, user_id, code) VALUES ('2022-03-18 14:49:01', '1', 1, 1, 1, null, null);
INSERT INTO booking (booked_time, status, passenger_id, payment_id, ticket_id, user_id, code) VALUES ('2022-03-22 14:15:54', '1', 1, 2, 2, null, null);
INSERT INTO booking (booked_time, status, passenger_id, payment_id, ticket_id, user_id, code) VALUES ('2022-04-13 22:27:11', 'Pending', 8, 5, 6, null, '2022-04-13 22:27:11.347');

