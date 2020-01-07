drop database if exists AutoSchool;
create database AutoSchool;
SET GLOBAL log_bin_trust_function_creators = 1;
use AutoSchool;

create table tb_equipos(
	idEquipo int not null auto_increment,
    ide int not null,
    ip nvarchar(14),
    estatus int(1) default 0,
    primary key(idEquipo)
    
);

create table tb_Estatus(
	idEstatus int not null,
    estatus nvarchar(100),
    primary key(idEstatus)
);


create table tb_TipoPersona(
	idTipoPersona int not null,
    tipoPersona nvarchar(100),
    primary key(idTipoPersona)
);
CREATE TABLE tb_Persona (
    idPersona INT NOT NULL,
    Nombre NVARCHAR(100) NOT NULL,
    apePat NVARCHAR(100) NOT NULL,
    apeMat NVARCHAR(100) NOT NULL,
    FingPr BLOB NOT NULL,
    idEstatus int not null,
    idTipoPersona int not null,
    Usr NVARCHAR(50) NOT NULL,
    Pswd NVARCHAR(32) NOT NULL,
    eMail nvarchar(100) not null,
    PRIMARY KEY (idPersona),
    foreign key(idEstatus) references tb_Estatus(idEstatus),
    foreign key(idTipoPersona) references tb_TipoPersona(idTipoPersona) 
);

CREATE TABLE tb_Grupo (
    idGrupo INT NOT NULL,
    Grupo NVARCHAR(6) NOT NULL,
    PRIMARY KEY (idGrupo)
);

create table tb_Alumno(
	idAlumno int not null,
    idPersona int not null,
    idGrupo int not null,
    primary key(idAlumno),
    foreign key(idPersona) references tb_Persona(idPersona),
    foreign key(idGrupo) references tb_Grupo(idGrupo)
);

create table tb_CatMat(
	idCatMat int not null,
    Materia nvarchar(60) not null,
    primary key(idCatMat)
);

create table tb_horas(
	idHoras int not null,
    inicio time,
    fin time,
    primary key (idHoras)
);

create table tb_catAula(
	idAula int not null,
    descripcion nvarchar(100),
    primary key (idAula)
);

create table tb_Clase(
	idClase int not null,
    idHora int not null,
    idCatMat int not null,
    idAula int not null,
    idGrupo int(2) not null,
    primary key (idClase),
    foreign key (idCatMat) references tb_CatMat(idCatMat),
    foreign key (idGrupo) references tb_Grupo(idGrupo),
    foreign key (idAula) references tb_catAula(idAula),
    foreign key (idHora) references tb_horas(idHoras)
);

create table tb_Maestro(
	idMaestro int not null,
    idPersona int,
    primary key(idMaestro),
    foreign key(idPersona) references tb_Persona(idPersona)
);

create table tb_Asistencia(
	idAsistencia int not null,
    idPersona int  not null,
    fechaEntrada datetime ,
    fechaSalida datetime,
    idClase int not null,
    primary key(idAsistencia),
    foreign key (idPersona) references tb_Persona(idPersona),
    foreign key(idClase) references tb_Clase(idClase)
);

create table tb_RelClaseMaestro(
	idRelClaseMaestro int not null,
    idClase int not null,
    idMaestro int not null,
    primary key(idRelClaseMaestro),
    foreign key(idClase) references tb_clase(idClase),
    foreign key(idMaestro) references tb_maestro(idMaestro)
);
#------------Llenado de catalogos para pruebas-----------------
insert into tb_equipos(ide,ip) values
	(0,'192.168.43.208'),
    (1,'192.168.43.46'),
    (2,'192.168.9.140'),
    (3,'192.168.9.140'),
    (4,'192.168.9.140'),
    (5,'192.168.9.140'),
    (6,'192.168.9.140'),
    (7,'192.168.9.140'),
    (8,'192.168.9.140'),
    (9,'192.168.9.140'),
    (10,'192.168.9.140'),
    (11,'192.168.9.140'),
    (12,'192.168.9.140'),
    (13,'192.168.9.140'),
    (14,'192.168.9.140'),
    (15,'192.168.9.140'),
    (16,'192.168.9.140'),
    (17,'192.168.9.140'),
    (18,'192.168.9.140'),
    (19,'192.168.9.140'),
    (20,'192.168.9.140'),
    (21,'192.168.9.140'),
    (22,'192.168.9.140'),
    (23,'192.168.9.140'),
    (24,'192.168.9.140'),
    (25,'192.168.9.140');

insert into tb_grupo values
	(1,'4IM6'),
    (2,'4IM7'),
    (3,'4IM8'),
    (4,'4IM9'),
    (5,'6IM6'),
    (6,'6IM7'),
    (7,'6IM8'),
    (8,'4IV6'),
    (9,'4IV7'),
    (10,'4IV8'),
    (11,'6IV5'),
    (12,'6IV6'),
    (123,'PROF');
    
insert into tb_catmat values
	(1,'APTI I'),
    (2,'LPTI I'),
    (3,'POO'),
    (4,'BD'),
    (5,'LPTI II'),
    (6,'PSW'),
    (7,'TPPC'),
    (8,'IIP'),
    (9,'ISD'),
    (10,'SWA'),
    (11,'LPTI III'),
    (12,'AP'),
    (13,'ISB'),
    (14,'LPTI IV'),
    (15,'MAP'),
    (16,'SS'),
    (17,'PI');
    
insert into tb_catAula values 
	(1, 'Bases de Datos'),
    (2, 'Desarrollo de Software'),
    (3, 'Nuevas Tecnologías');    
    
insert into tb_horas values 
	(1,'7:00','8:00'),
    (2,'8:00','9:00'),
    (3,'9:00','10:00'),
    (4,'10:00','11:00'),
    (5,'11:00','12:00'),
    (6,'12:00','13:00'),
    (7,'13:00','14:00'),
    (8,'14:00','15:00'),
    (9,'15:00','16:00'),
    (10,'16:00','17:00'),
    (11,'17:00','18:00'),
    (12,'18:00','19:00'),
    (13,'19:00','20:00'),
    (14,'20:00','21:00'),
    (15,'21:00','22:00');

insert into tb_clase values
	(1, 4, 6, 1, 6),
    (2, 3, 17, 1, 5),
    (3, 1, 11, 1, 5);
    
insert into tb_Estatus values
	(1, 'Inactivo'),
    (2, 'Activo'),
    (3, 'Baneado');
    
insert into tb_TipoPersona values
	(1, 'Administrador'),
	(2, 'Docente'),
    (3,'Alumno');
#------------Funciones----------------------
drop function if exists ft_concatNombre;
delimiter **
create function ft_concatNombre(nom nvarchar(100), pat nvarchar(100), mat nvarchar(100)) returns nvarchar(21845)
begin
	declare nomCompleto nvarchar(400);
    set nomCompleto = concat(nom, ' ', pat, ' ', mat);
    return nomCompleto;
end; **
delimiter ;
select ft_concatNombre(Nombre, apePat, apeMat) as Nombre from tb_persona;

drop function if exists ft_verificaPermiso;
delimiter **
create function ft_verificaPermiso( idxUsr int) returns int(2)
begin
	declare existePermiso int(2);
    set existePermiso = (select count(*) from tb_persona where idPersona = idxUsr and idTipoPersona = 1);
    return existePermiso;    
end; **
delimiter ;

#------------Procedimiento Almacenados------------------

drop procedure if exists sp_consultaEquipos;
delimiter **
create procedure sp_consultaEquipos()
begin
	select * from tb_equipos;
end;**
delimiter ;

drop procedure if exists prendeApaga;
delimiter **
create procedure prendeApaga(in stat int, in num int)
begin
	declare msj nvarchar(100);
    declare existe int;
    declare idx int;
    set existe = (select count(*) from tb_equipos where ide = num);
    if existe = 1 then
		if (stat = 1 or stat=0)then
			set idx=(select idEquipo from tb_equipos where ide = num) ;
            update tb_equipos set estatus = stat where idEquipo = idx;
            set msj = 'ok';
		else
         set msj = 'estatus no valido';
        end if;
    else
		set msj= 'equipo no encontrado';
    end if;
    select msj;
end;**
delimiter ;

drop procedure if exists sp_ValidaUsr;
delimiter **
create procedure sp_ValidaUsr(in usuario nvarchar(50), in contra nvarchar(50))
begin
	declare existeUsr int;
    declare idx int;
    declare xconfirmacion int;
	declare xmsj nvarchar(100);
    declare xtipoUsr int;
		
	set existeUsr = (select count(*) from tb_persona where Usr = usuario and Pswd = md5(contra));
    if(existeUsr = 1)  then
		set xconfirmacion = (select count(*) from tb_persona where Usr = usuario and Pswd = md5(contra) and idEstatus = 2);
        if(xconfirmación = 1) then
			set idx = (select idPersona from tb_persona where Usr = usuario and Pswd = md5(contra));
			set xtipoUsr = (select idTipoPersona from tb_persona where idPersona = idx);
			case xtipoUsr
				when 1 then 
					set xmsj = 'Bienvenido Administrador';
				when 2 then
					set xmsj = 'Bienvenido Docente';
				when 3 then 
					set xmsj = 'Bienvenido Alumno';
				else
					begin
						set  xmsj = 'Sin permisos';
					end;
				end case;
		else
			set idx = 0;
			set xmsj = 'No has confirmado tu usuario via email';
		end if;
	else 
		set xmsj = 'Usuario y/o Contraseña invalidos' ;
        set idx = 0;
        set xtipoUsr = 0;
    end if;
    select xMsj as Msj, idx as idUsr, xtipoUsr as tipoUsr;
end;**
delimiter ;

drop procedure if exists sp_RegistraUsr;
delimiter **
create procedure sp_RegistraUsr(in nom nvarchar(100), in apPaterno nvarchar(100), in apMaterno nvarchar(100), in huella blob, in usuario nvarchar(100), in contra nvarchar(32), in xtipoUsr int, in xGrupo nvarchar(6), in xmail nvarchar(100))
begin
	declare existeUsr int;
	declare idx int;
	declare idxTipoUsr int;
    declare idxGrupo int;
	declare xMsj nvarchar(100);

	set existeUsr = (select count(*) from tb_Persona where Usr = usuario OR Pswd = md5(contra) or FingPr = huella and Nombre = nom and apePat = apPaterno and apeMat = apMaterno);
	if(existeUsr = 0) then
		set idx = (select ifnull(max(idPersona), 0) + 1 from tb_persona);
        insert into tb_persona values
			(idx, nom, apPaterno, apMaterno, huella,1,xTipoUsr, usuario, md5(contra), xmail);
		if(xtipoUsr = 1) then
			#Administrador
            set xMsj = 'Administrador Registrado';
		else
            if(xtipoUsr = 3) then
            #Alumno
				set idxTipoUsr = (select ifnull(max(idAlumno) , 0) +1 from tb_alumno);
				set idxGrupo = (select idGrupo from tb_grupo where Grupo = xGrupo);
				insert into tb_alumno values
					(idxTipoUsr, idx, idxGrupo);
				set xMsj = 'Alumno registrado con exito';
			else
				if(xtipoUsr = 2)then
					#Maestro
					set idxTipoUsr = (select ifnull(max(idMaestro), 0) + 1 from tb_maestro);
					insert into tb_maestro values
						(idxTipoUsr, idx);
					set xMsj = 'Maestro registrado con exito';
                end if;
            end if;
		end if;
	else
		set xMsj = 'El usuario que desas agregar ya existe';
        set idx = 0;
        set idxTipoUsr = 0;
	end if;    
    
    select xMsj as Msj, idx as idUsr, idxTipoUsr as TipoUsr;
end;**
delimiter ;


drop procedure if exists spRegistraEntrada;
delimiter **
create procedure spRegistraEntrada(in xHuella blob, in xClase int, inout Msj nvarchar(100))
begin
	declare existeUsr int;
    declare existeClase int;
    declare existeSalida int;
    declare idxUsr int;
    declare idx int;
    declare entrada datetime;
    
    set existeUsr = (select count(*) from tb_persona where FingPr = xHuella);
    if(existeUsr = 1) then
		set existeClase = (select count(*) from tb_clase where idClase = xClase);
        if(existeClase = 1) then
			set idxUsr = (select idPersona from tb_persona where FingPr = xHuella);
            set existeSalida = (select count(*) from tb_asistencia where idPersona = idxUsr and fechaSalida is null);
            if(existeSalida = 0)then
				set idx = (select ifnull(max(idAsistencia), 0) + 1 from tb_asistencia);
				set entrada = current_timestamp();
				insert into tb_asistencia (idAsistencia, idPersona, fechaEntrada, idClase) values
					(idx, idxUsr, entrada, xClase);
				set Msj = concat('Entrada registrada ', entrada);
			else
				set Msj = 'Tienes una entrada previa';
            end if;
        else
			set Msj = 'La clase no existe';
            set idxUsr = 0;
            set idx = 0;
        end if;
    else
		set idxUsr =0;
        set idx = 0;
        set Msj = 'Sin coincidencias';
    end if;
end;**
delimiter ;

drop procedure if exists spRegistraSalida;
delimiter **
create procedure spRegistraSalida(in xhuella blob, inout Msj nvarchar(100))
begin
	declare existeUsr int;
    declare idxUsr int;
    declare idxAsistencia int;
    declare existeEntrada datetime;
    declare xfechaSalida datetime;
    
    set existeUsr = (select count(*) from tb_persona where FingPr = xhuella);
    if(existeUsr = 1)then
		set idxUsr = (select idPersona from tb_persona where FingPr = xhuella);
        set	idxAsistencia = (select max(idAsistencia) from tb_asistencia where idPersona = idxUsr);
		set existeEntrada = (select fechaEntrada from tb_asistencia where idAsistencia = idxAsistencia);
        if(existeEntrada = null)then
			set Msj = 'No has registrado tu entrada';
        else
			set xfechaSalida = current_timestamp();
            update tb_asistencia set fechaSalida = xfechaSalida where idAsistencia = idxAsistencia;
            set Msj = concat('Salida: ', xfechaSalida);
        end if;
    else
		set Msj = 'El usuario no existe';
    end if;
end;**
delimiter ;




drop procedure if exists spAgregaClases;
delimiter **
create procedure spAgregaClases(in idxMaestro int, in idxClase int)
begin
	declare idxRel int;
    declare existeRel int;
    declare existeMaestro int;
    declare existeClase int;
    declare xMsj nvarchar(100);
    
    set existeRel = (select count(*) from  tb_relclasemaestro where idClase = idxClase and idMaestro = idxMaestro);
    if(existeRel = 0) then
		set idxRel = (select ifnull(max(idRelClaseMaestro), 0) + 1 from tb_relclasemaestro);
        insert into tb_relclasemaestro values
			(idxRel, idxMaestro, idxClase);
		set xMsj = 'Relacion agregada con exito';
    else
		set xMsj = 'La relación ya existe';
        set idxRel = 0;
    end if;
    select xMsj as Msj, idxRel as idRelacion;
end;**
delimiter ;


drop procedure if exists spGrupo;
delimiter **
create procedure spGrupo(in idxGrupo int, in xGrupo nvarchar(50))
begin
	declare idx int;
    declare existeGrupo int;
    declare xMsj nvarchar(100);
    
    if(idxGrupo = 0) then
		set existeGrupo=(select count(*) from tb_grupo where Grupo = xGrupo);
        if (existeGrupo = 0) then
			set idx = (select ifnull(max(idGrupo), 0) + 1 from tb_grupo);
            insert into tb_grupo values
				(idx, xGrupo);
			set xMsj = 'Grupo agregado con exito';
		else
			set idx = 0;
			set xMsj = 'El grupo ya existe';
        end if;
    else
		update tb_grupo set Grupo = xGrupo where idGrupo = idxGrupo;
        set xMsj = 'Grupo actualizado';
        set idx = idxGrupo;
    end if;
    select xMsj as Msj, idx as idGrupo;
end; **
delimiter ;

drop procedure if exists spEliminaGrupo;
delimiter **
create procedure spEliminaGrupo(in idxGrupo int, in idxUsr int)
begin
	declare existeGrupo int;
    declare existePermiso int;
    declare xMsj nvarchar(100);
    set existeGrupo = (select count(*) from tb_grupo where idGrupo = idxGrupo);
    if(existeGrupo = 1)then
		set existePermiso = ft_verificaPermiso(idxUsr);
        if(existePermiso  = 1) then
			delete from tb_grupo where idGrupo = idxGrupo;
			set xMsj = 'El grupo ha sido eliminado ';
		else
			set xMsj = 'No tienes permisos para borrar';
        end if;
    else
		set xMsj = 'Lo que deseas eliminar no existe';
    end if; 
    select xMsj as Msj;
end ; **
delimiter ; 

drop procedure if exists spMaterias;
delimiter **
create procedure spMaterias (in idxMateria int,in xMateria nvarchar(60))
begin
	declare idx int;
    declare existeMateria int;
    declare xMsj nvarchar(100);
    
    if(idxMateria = 0) then
		set existeMateria = (select count(*) from tb_catmat where idCatMat = idxMateria);
        if (existeMateria = 0) then
			set idx = (select ifnull(max(idCatMat), 0) + 1 from tb_catmat);
            insert into tb_catmat values
				(idx, xMateria);
			set xMsj = 'Materia agregado con exito';
		else
			set idx = 0;
			set xMsj = 'La materia ya existe';
        end if;
    else
		update tb_catmat set Materia = xMateria where idCatMat = idxMateria;
        set xMsj = 'Materia actualizado';
        set idx = idxMateria;
    end if;
    select xMsj as Msj, idx as idMateria;
end; **
delimiter ;

drop procedure if exists spEliminaMateria;
delimiter **
create procedure spEliminaMateria(in idxMateria int,in idxUsr int)
begin
	declare existeMateria int;
    declare existePermiso int;
    declare xMsj nvarchar(100);
    set existeMateria = (select count(*) from tb_catmat where idCatMat = idxMateria);
    if(existeMateria = 1)then
		set existePermiso = ft_verificaPermiso(idxUsr);
        if(existePermiso = 1) then
			delete from tb_catmat where idCatMat = idxMateria;
			set xMsj = 'El materia ha sido eliminado ';
		else
			set xMsj = 'No tienes el permiso de borrar';
        end if;
    else
		set xMsj = 'Lo que deseas eliminar no existe';
    end if; 
    select xMsj as Msj;
end; **
delimiter ; 
drop procedure if exists spModificaUsr;

delimiter **
create procedure spModificaUsr(in idxPersona int, in xnom nvarchar(100), in xpat nvarchar(100), in xmat nvarchar(100), in xfinger int,in xUsr nvarchar(50), in xpswd nvarchar(32), in xmail nvarchar(100))
begin
	#xfinger es para comprobar se es alumno o profe
    #0 es profe
    #1 es alumno
	declare existeUsr int;
    declare ide int;
    declare ide2 int;
    declare xMsj nvarchar(100);
    
    set existeUsr = (select count(*) from tb_persona where idPersona = idxPersona);
    if(existeUsr = 1)then
		if(xfinger = 0)then
			if(xpswd = '')then
				update tb_persona set Nombre = xnom, apePat = xpat, apeMat = xmat, Usr = xUsr, eMail = xmail where idPersona = idxPersona;
				set xMsj = 'Usuario Actualizado';
			else
				update tb_persona set Nombre = xnom, apePat = xpat, apeMat = xmat, Usr = xUsr, Pswd = md5(xpswd), eMail = xmail where idPersona = idxPersona;
				set xMsj = 'Usuario Actualizado';
			end if;
		else
			
				update tb_persona set Nombre = xnom, apePat = xpat, apeMat = xmat, Usr = xUsr where idPersona = idxPersona;
                #xmail actua como grupo
                
                set ide2 = (select idGrupo from tb_Grupo where Grupo = xmail);
                update tb_Alumno set idGrupo = ide2 where idAlumno = idxPersona;
				set xMsj = 'Usuario Actualizado';
			
				
			
        end if;
    else
		set xMsj = 'El usuario que deseas modificar no existe';
        set idxPersona = 0;
    end if;
    select xMsj as xMsj, idxPersona as idPersona;
end; **
delimiter ;

drop procedure if exists spConsultaAlumnosGral;
delimiter **
create procedure spConsultaAlumnosGral()
begin
	select tb_persona.idPersona as idPersona, tb_alumno.idAlumno as idAlumno,ft_concatNombre(Nombre, apePat, apeMat) as Nombre , tb_persona.Usr as Usuario, tb_grupo.Grupo as Grupo from tb_alumno inner join tb_persona on tb_persona.idPersona = tb_alumno.idAlumno inner join tb_grupo on tb_grupo.idGrupo = tb_alumno.idGrupo; 
end; **
delimiter ;

drop procedure if exists spConsultaAlumno;
delimiter **
create procedure spConsultaAlumno(in xusr nvarchar(100))
begin
	select tb_persona.idPersona as idPersona, tb_alumno.idAlumno as idAlumno, tb_persona.Nombre as Nombre, tb_persona.apePat as ApellidoPaterno,  tb_persona.apeMat as ApellidoMaterno , tb_persona.Usr as Usuario, tb_persona.idEstatus as estado, tb_grupo.Grupo as Grupo from tb_persona inner join tb_alumno on tb_persona.idPersona = tb_alumno.idPersona inner join tb_grupo on tb_grupo.idGrupo = tb_alumno.idGrupo where tb_persona.Usr = xusr; 
end; **
delimiter ;

drop procedure if exists spConsultaMaestroGral;
delimiter **
create procedure spConsultaMaestroGral()
begin
	select tb_persona.idPersona as idPersona, tb_maestro.idMaestro as idMaestro, tb_persona.Nombre as Nombre, tb_persona.apePat as ApellidoPaterno,  tb_persona.apeMat as ApellidoMaterno, tb_persona.Usr as Usuario,tb_persona.Pswd as Contraseña, tb_persona.FingPr as Huella, tb_persona.eMail as Email from tb_maestro inner join tb_persona on tb_persona.idPersona = tb_maestro.idPersona;
end; **
delimiter ;

drop procedure if exists spConsultaMaestro;
delimiter **
create procedure spConsultaMaestro(in xusr nvarchar(100))
begin
	select tb_persona.idPersona as idPersona, tb_maestro.idMaestro as idMaestro, tb_persona.Nombre as Nombre, tb_persona.apePat as ApellidoPaterno,  tb_persona.apeMat as ApellidoMaterno, tb_persona.Usr as Usuario,tb_persona.Pswd as Contraseña, tb_persona.FingPr as Huella, tb_persona.eMail as Email from tb_maestro inner join tb_persona on tb_persona.idPersona = tb_maestro.idPersona where tb_persona.Usr = xusr;
end; **
delimiter ;

drop procedure if exists spEliminaUsr;
delimiter **
create procedure spEliminaUsr(in xusr nvarchar(100), in xtipoUsr int, in idxUsr int)
begin
	declare existeUsr int;
    declare idxPersona int;
    declare idxMaestro int;
    declare xMsj nvarchar(100);
    declare existePermiso int;
    set existePermiso = ft_verificaPermiso(idxUsr);
    if(existePermiso = 1) then
		if(xtipoUsr = 1) then
		#Alumno 
			set existeUsr = (select count(*) from tb_persona where Usr = xusr);
			if(existeUsr = 1) then
				set idxPersona =(select idPersona from tb_persona where Usr = xusr);
				delete from tb_alumno where idPersona = idxPersona;
				delete from tb_persona where idPersona = idxPersona;
				set xMsj = concat('Usuario Eliminado ', xusr);
			else
				set xMsj = 'El Usuario que deseas borrar no existe';
				set idxPersona = 0;
			end if;
		else
			if(xtipoUsr = 2) then
			#Maestro
				set idxPersona =(select idPersona from tb_persona where Usr = xusr); 
				set idxMaestro = (select idMaestro from tb_maestro where idPersona=idxPersona);
				delete from tb_relclasemaestro where idMaestro = idxMaestro;
				delete from tb_maestro where idPersona = idxPersona;
				delete from tb_persona where idPersona = idxPersona;
				set xMsj = concat('Usuario Eliminado ', xusr);
			else
				set xMsj = '';
				set idxPersona = 0;
			end if;
		end if;
	else
		set xMsj = 'No tienes permiso para borrar';
        set idxPersona = 0;
    end if;
    select xMsj as Msj, idxPersona as idPersona;
end; **
delimiter ;

drop procedure if exists spAgregaRelMaes;
delimiter **
create procedure spAgregaRelMaes(in xusr nvarchar(100), in xClase int)
begin
	declare idxPersona int;
    declare idxMaestro int;
    declare idxClase int;
    declare idxMateria int;
    declare idRelacion int;
    declare xMsj nvarchar(100);
	declare existePersona int;
    declare existeClase int;
    
    set existeClase = (select count(*) from tb_clase where idClase = xClase);
    set existePersona =(select count(*) from tb_persona where Usr = xusr);
    if(existeClase = 1 and existePersona = 1)then
		if (select count(*) from tb_relclasemaestro where idClase = xClase) = 0 then
        set idxPersona = (select idPersona from tb_persona where Usr = xusr);
        set idxMaestro = (select idMaestro from tb_maestro where idPersona = idxPersona);       
        set idRelacion = (select ifnull(max(idRelClaseMaestro), 0)+1 from tb_relclasemaestro);
        insert into tb_relclasemaestro values 
			(idRelacion, xClase, idxMaestro);
            set xMsj = 'Relacion agregada con exito';
        else
			set xMsj = 'Clase ya asignada';
        end if;
		
	else
		set xMsj = 'No existe el usuario y/o la clase';
        set idxPersona = 0;
        set idxClase = 0;
        set idxMateria = 0;
        set idxMaestro = 0;
    end if;
    select xMsj as Msj, idxPersona as idPersona, xClase as idClase;
end; **
delimiter ;

drop procedure if exists spModificaEstatus;
delimiter **
create procedure spModificaEstatus(in idxUsr int)
begin
	declare existeUsr int;
    declare existeEstado int;
    declare xMsj nvarchar(100);
    
    set existeUsr = (select count(*) from tb_Persona where idPersona = idxUsr);
    if(existeUsr = 1) then
		update tb_Persona set idEstatus = 2 where idPersona = idxUsr;
    else
		set xMsj = 'El usuario no existe';
    end if;
    set xMsj = 'Usuario activado';
    select xMsj as Msj;
end; **delimiter ;

drop procedure if exists  spMuestraAsisUser;
delimiter **
create procedure spMuestraAsisUser(in idxUsr int)
begin
	 select tb_asistencia.idAsistencia as ID, tb_asistencia.fechaEntrada as Entrada, tb_asistencia.fechaSalida as Salida,tb_clase.idHora as Hora,
     tb_clase.idAula as Aula, tb_catmat.Materia as Materia from tb_clase inner join tb_asistencia on tb_asistencia.idClase = tb_clase.idClase inner join tb_catmat on tb_catmat.idCatMat = tb_clase.idCatMat where tb_asistencia.idPersona = idxUsr;
end; **
delimiter ;



drop procedure if exists spMuestraAsisGrupo;
delimiter **
create procedure spMuestraAsisGrupo(in xGrupo nvarchar(100))
begin
	declare xidGrupo int;
    set xidGrupo = (select idGrupo from tb_grupo where Grupo = xGrupo);
    select  tb_persona.idPersona,ft_concatNombre(tb_persona.Nombre, tb_persona.apePat, tb_persona.apeMat) as nombre, tb_asistencia.fechaEntrada, tb_asistencia.fechaSalida,concat(tb_horas.inicio + " a " + tb_horas.fin) as Horario, tb_clase.idAula, tb_catmat.Materia from tb_asistencia inner join tb_persona on tb_persona.idPersona  = tb_asistencia.idPersona inner join tb_clase on tb_clase.idClase = tb_asistencia.idClase inner join tb_catmat on tb_catmat.idCatMat = tb_clase.idCatMat inner join tb_horas on tb_horas.idHoras = tb_clase.idHora where tb_clase.idGrupo = xidGrupo;
end; **
delimiter ;
call spMuestraAsisGrupo('5IM7');

drop procedure if exists spMuestraGruposProfe;
delimiter **
create procedure spMuestraGruposProfe(in xUser nvarchar(50))
begin
declare xIdPersona int;

 set xIdPersona = (select idPersona from tb_persona where usr = xUser);
 select tb_Grupo.grupo AS grupo,tb_clase.idclase, tb_Grupo.idgrupo from tb_grupo inner join tb_clase on tb_clase.idgrupo = tb_Grupo.idgrupo inner join tb_relclasemaestro on tb_relclasemaestro.idclase = tb_clase.idclase inner join tb_maestro on tb_maestro.idMaestro = tb_relclasemaestro.idmaestro where tb_maestro.idpersona = xIdPersona;
 # select tb_clase.idgrupo from tb_clase inner join tb_relclasemaestro on tb_relclasemaestro.idclase = tb_clase.idclase inner join tb_maestro on tb_maestro.idMaestro = tb_relclasemaestro.idmaestro where tb_maestro.idpersona = xIdPersona;

end;**
delimiter ;

drop procedure if exists spMuestraAlumnosGrupo;
drop procedure if exists spMuestraAlumnosGrupo2;
delimiter **
create procedure spMuestraAlumnosGrupo(in xIdGrupo int(2))
begin
select tb_persona.idPersona, tb_persona.Nombre, tb_persona.apePat, tb_persona.apeMat from tb_persona inner join tb_alumno on tb_alumno.idPersona = tb_persona.idPersona where tb_alumno.idgrupo = xIdGrupo;
end;**

create procedure spMuestraAlumnosGrupo2(in xIdGrupo nvarchar(4))
begin
declare xiid nvarchar(4);
set xiid = (select idGrupo from tb_Grupo where grupo = xIdGrupo);
select tb_persona.idPersona, tb_persona.Nombre, tb_persona.apePat, tb_persona.apeMat from tb_persona inner join tb_alumno on tb_alumno.idPersona = tb_persona.idPersona where tb_alumno.idgrupo = xiid;
end;**
delimiter ;


call spMuestraAlumnosGrupo2('5IM6');

drop procedure if exists spBuscaUsr;
delimiter **
create procedure spBuscaUsr(in xUsr nvarchar(100))
begin
	declare existeUsr int;
    declare idx int;
	declare xmsj nvarchar(100);
    declare xtipoUsr int;
		
	set existeUsr = (select count(*) from tb_persona where Usr = xUsr);
    if(existeUsr = 1)  then
		
			set idx = (select idPersona from tb_persona where Usr = xUsr);
			set xtipoUsr = (select idTipoPersona from tb_persona where idPersona = idx);
			set xmsj = 'Usuario encontrado' ;
	else 
		set xmsj = 'Usuario no encontrado' ;
        set idx = 0;
        set xtipoUsr = 0;
    end if;
    select xMsj as Msj, idx as idUsr, xtipoUsr as tipoUsr;
end; **
delimiter ;

drop procedure if exists actualizaHuella;
delimiter **
create procedure actualizaHuella( in huella blob, in usuario nvarchar(100), INOUT xmsj nvarchar(100))
begin
	declare idd int;
    declare existe int;
	
    set existe = (select count(*) from tb_persona where Usr = usuario);
    if(existe = 1)  then
		
			set idd = (select idPersona from tb_persona where Usr = usuario);
			update tb_Persona set FingPr = huella where idPersona = idd;
			set xmsj = 'Huella registrada' ;
	else 
		set xmsj = 'Usuario no encontrado' ;
        set idd = 0;
        
    end if;
    
end;**
delimiter ;

call autoschool.sp_RegistraUsr('Rosa Iliana', 'Fuentes', 'Cruz', '10110111', 'FUCR841010', 'fuentesCruz', 1, 5, 'ilifuentes09@gmail.com');
call autoschool.sp_RegistraUsr('Ricardo Alejandro', 'Almazán', 'Trejo', '1011001', '2015090019', 'bardo', 2, '6IM6', 'almazan624@gmail.com');
call autoschool.sp_RegistraUsr('Enrique', 'Sánchez', 'Foyo', '101111001', '2015090701', 'foyo', 3, '6IM7', 'foyo@gmail.com');
call autoschool.sp_RegistraUsr('Alvaro', 'Zuñiga', 'Pineda', '101111000', '2015090822', 'zuñi', 3, '6IM6', 'foy@gmail.com');
call autoschool.sp_RegistraUsr('sandy', 'Cespedes', 'Gutierres', '001111001', '2015090116', 'ted', 3, '6IM7', 'oyo@gmail.com');
call spModificaEstatus(1);
call spModificaEstatus(2);
call sp_ValidaUsr('2015090019','bardo');
select * from tb_persona;
call spConsultaAlumno('2015090822');
#call spModificaUsr(3,'Enrique','Sanchez','foyo',1,'foyo','','5IM7');
call spConsultaMaestro('2015090822');
call spConsultaMaestroGral();
call spAgregaRelMaes('2015090019',1);
call spAgregaRelMaes('2015090019',2);
call spAgregaRelMaes('2015090019',3);

 call spMuestraAsisGrupo('5IM6');

call spMuestraGruposProfe('2015090019');
call spMuestraAlumnosGrupo(5);
call spBuscaUsr('2015090019');
call sp_consultaEquipos();
insert into tb_asistencia (idAsistencia, idPersona, fechaEntrada, idClase) values				(2, 3,current_timestamp() , 1);
call spMuestraAsisGrupo('5IM7');
call spMuestraAlumnosGrupo2('6IM6');
call autoschool.spConsultaMaestro('2015090019');
call sp_consultaEquipos;

drop procedure if exists spAgregaClasesGrupo;
delimiter **
create procedure spAgregaClasesGrupo(in xHora time, in xMat nvarchar(50), in xAula nvarchar(100), in xGrupo nvarchar(6))
begin
	
    declare xIdeC int;
    declare xIdeMat int;
    declare xIdeAula int;
    declare xIdeGrupo int;
    declare exist int;
    declare verificaHora time;
    declare msj nvarchar(100);
		set exist = (select count(*) from tb_catmat where materia = xMat);
    if exist = 1 then
		set exist = (select count(*) from tb_catAula where descripcion = xAula);
        if exist = 1 then
			set exist = (select count(*) from tb_grupo where grupo = xGrupo);
            if exist = 1 then
				set xIdeC = (select ifnull(max(idClase), 0) + 1 from tb_Clase);
                set xIdeMat = (select idCatMat from tb_catmat where materia = xMat);
                set xIdeAula = (select idAula from tb_catAula where descripcion = xAula);
                set xIdeGrupo = (select idGrupo from tb_grupo where grupo = xGrupo);
                set exist = (select count(*) from tb_clase where idAula = xIdeAula and idGrupo = xIdeGrupo and hora between xHora and xHora + INTERVAL 1 hour );
                if exist = 0 then
					set exist = (select count(*) from tb_clase where idAula = xIdeAula and hora between xHora and xHora + INTERVAL 1 hour );
					if  exist = 0 then
						insert into tb_Clase values (xIdeC, xHora, xIdeMat, xIdeAula, xIdeGrupo);
						set msj = 'Clase agregada con éxito';
                    else
						set msj = 'Aula ocupada';
                    end if;
				else
					set msj = 'Clase ya existente';
                end if;
            else
				set msj = 'No existe el grupo';
            end if;
        else
			set msj = 'No existe el aula';
        end if;
    else
		set msj = 'No existe la materia';
    end if;
select msj;
end; **
delimiter ; 

call spAgregaClasesGrupo('11:05', 'POO' , 'Bases de Datos','5IM7');
call spAgregaRelMaes('richie4', 4 );