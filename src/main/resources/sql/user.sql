use flightbooking;
create table user
(
    id            bigint auto_increment
        primary key,
    username      varchar(255)                           not null,
    password      varchar(255)                           not null,
    full_name     varchar(255) charset utf8              not null,
    phone         varchar(11)                            not null,
    date_of_birth date                                   not null,
    gender        tinyint(1)                             not null,
    role          varchar(6) charset utf8 default 'USER' null,
    email         varchar(255)                           not null
);



