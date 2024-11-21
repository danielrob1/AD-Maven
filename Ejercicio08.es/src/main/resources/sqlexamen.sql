create schema fechas;
use fechas;
create table fechas(
	id_fecha integer auto_increment not null primary key,
    fecha date
    );
    select * from fechas;
    
    create table provincias(
		id_provincia integer auto_increment not null primary key,
        provincia varchar(100)
        );
        
    
    drop table fechas;
