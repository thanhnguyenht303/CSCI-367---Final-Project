create database project;

create table customer (
	id int not null auto_increment primary key,
    name varchar(100) not null,
    phone_number varchar(12) not null
);

create table address (
	id int not null auto_increment primary key,
    address varchar(400) not null
);

create table status (
	id int not null auto_increment primary key,
    status_name varchar(100) not null
);
create table orders (
	id binary(16) not null primary key,
    customer_id int not null,
    delivery_id int not null,
    delivery_time datetime not null,
    pickup_id int not null,
    pickup_time datetime not null,
    package_description varchar(300) not null,
    status_id int not null,
    foreign key (customer_id) references customer(id),
    foreign key (delivery_id) references address(id),
    foreign key (pickup_id) references address(id),
    foreign key (status_id) references status(id)
);

insert into customer (name, phone_number) values ("Thanh", "6082074796"), ("Jay", "5026334877");
insert into address (address) values ("700 College st"), ("648 Avenue st");
insert into address (address) values ("900 High st"), ("897 W.Dc st"); 
insert into status (status_name) values ("Waiting for pick up"), ("Picked up"), ("Delivering"), ("Delivered");
insert into orders (id, customer_id, delivery_id, delivery_time, pickup_id, pickup_time, package_description, status_id) 
values (uuid(), 1, 1, "2022-11-05 9:00:00" ,3, "2022-11-08 10:00:00" ,"food and beverage", 1), (uuid(), 2, 2, "2022-11-06 1PM", 4, "2022-11-07 4:30PM", "Amazon package", 1);
