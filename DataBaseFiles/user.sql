create table green_bank.user (
    email varchar(64) not null,
    password varchar(64) not null,
    first_name varchar(64) not null,
    last_name varchar(64) not null,
    role varchar(64) not null,
    address varchar(64) not null,
    city varchar(64) not null,
    branch varchar(64) not null,
    zip varchar(64) not null,
    phone_number varchar(64) not null,
    amount float not null,
    primary key(email)
);