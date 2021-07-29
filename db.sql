
drop database embro;

create database embro;


use embro;


create table garment_types( id int(9) auto_increment primary key, name varchar(125), description varchar(125));


create table garment_materials(id int(9) auto_increment primary key, name varchar(125), description varchar(125));

create table colors (id int(9) auto_increment primary key, name varchar(125), description varchar(125));


create table orders(id int(9) auto_increment primary key, order_number varchar(125), garment_type_id int(9),garment_material_id int(9), color_id int(9),
date_received date , date_started date, time_processed int(9) DEFAULT 0, notes varchar(125), design varchar(125), machine int(9)  DEFAULT 0 , is_done int(1)  DEFAULT 0,
FOREIGN KEY (`garment_type_id`) REFERENCES `garment_types` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
FOREIGN KEY (`garment_material_id`) REFERENCES `garment_materials` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION, 
FOREIGN KEY (`color_id`) REFERENCES `colors` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
);

create table shipping(id int(9) auto_increment primary key, order_id int(9), shipping_courier varchar(125), tracking_details varchar(125),reference_number varchar(125),
FOREIGN KEY (`order_id`) REFERENCES `orders` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
);

-- create table on_going_orders(id int(9) auto_increment primary key, order_id int(9), machine_id int(9),
-- FOREIGN KEY (`order_id`) REFERENCES `orders` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
-- );

insert into colors(name) values ('Blue'), ('Green'),('Red');

insert into garment_types(name) values ('T-Shirt'), ('Hoodie'),('Polo Shirt');

insert into garment_materials(name) values ('MicroFibre'), ('Wool'),('Cotton');



