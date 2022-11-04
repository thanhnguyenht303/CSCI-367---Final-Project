create table orders (
	id binary(16) not null primary key,
    customer_name varchar(45) not null,
    phone_number varchar(12) not null,
    delivery_time datetime not null,
    delivery_address varchar(400) not null,
    package_description varchar(500),
    pickup_time datetime not null,
    pickup_address varchar(400) not null,
    status varchar(100) not null
);

insert into orders (id, customer_name, phone_number, delivery_time, delivery_address, package_description, pickup_time, pickup_address, status) 
values (uuid(), "Thanh", "6082074976", "2022-11-02 12:00:00", "700 College st", "food and beverage", "2022-11-02 09:00:00", "Ave restaurant, 168 Avenue st", "waiting for pick up");
