create table usuario( id integer primary key auto_increment,
			nombre varchar(80));

create table prestamolibro(idpres integer primary key auto_increment,
				id_a integer,
				id_l integer,
				fecha date,
				cantidad int,
				total float,
				foreign key(id_a) references usuario(id),
				foreign key(id_l) references libro(id));
			
create table libro(id integer primary key auto_increment,
			nombre varchar(80),
			autor varchar(80),
			precio float);

