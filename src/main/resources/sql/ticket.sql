use flightbooking;
create table ticket(
    id                  bigint auto_increment primary key       ,
    cost                int           ,
    departure           nvarchar(255) ,
    arrival             nvarchar(255) ,
    departure_time      TIMESTAMP     ,
    arrival_time        TIMESTAMP     ,
    hand_luggage        int           ,
    seat                nvarchar(255) ,
    cabin_class         nvarchar(255) ,
    registered_luggage  int           ,
    flight_number        nvarchar      ,
    primary key (id)
);
