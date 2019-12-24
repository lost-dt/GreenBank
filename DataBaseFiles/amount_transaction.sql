create table green_bank.amount_transaction (
    id int auto_increment,
    user_email varchar(64) not null,
    amount_value float not null,
    status varchar(32) not null,
    creation_time datetime not null,
    handled_by varchar(64),
    handled_time datetime,
    primary key(id)
);