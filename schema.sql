insert into Zona (id, nombre)
values(1, 'CABA');

insert into Zona (id, nombre)
values(2, 'ZONA NORTE');

insert into Zona (id, nombre)
values(3, 'ZONA SUR');

insert into Zona (id, nombre)
values(4, 'ZONA ESTE');

insert into Zona (id, nombre)

values(5, 'ZONA OESTE');


insert into tipo_asistencia (id, nombre)
values (1, 'CUIDADO POR DÍA');

insert into tipo_asistencia (id, nombre)
values (2, 'CUIDADO POR SEMANA');

insert into tipo_asistencia (id, nombre)
values (3, 'CUIDADO POR MES');

insert into tipo_asistencia (id, nombre)
values (4, 'CUIDADO POR HORA');

insert into tipo_asistencia (id, nombre)
values (5, 'CUIDADO POR NOCHE');

insert into tipo_turno(id, franja)
values(1, 'MAÑANA');

insert into tipo_turno(id, franja)
values(2, 'TARDE');

insert into tipo_turno(id, franja)
values(3, 'NOCHE');

insert into rol(id, descripcion)
values(1, 'CLIENTE');

insert into rol(id, descripcion)
values(2, 'PROFESIONAL');

insert into usuario(activo, email, password, cuenta_id, rol_id, perfilProfesional_id)
values(0, 'profesional@gmail.com', 'hola', 1, 2 , null);

insert into usuario(activo, email, password, cuenta_id, rol_id, perfilProfesional_id)
values(0, 'cliente@gmail.com', 'hola', 2, 1 , null);

insert into asistencia(camaAdentro, descripcion, nombre, tarifa, idFrecuencia_id, idTurno_id, usuario_id, zona_id)
values(0, 'Enfermero', 'Martina', 456, 2, 1, 1, 3);

insert into asistencia(camaAdentro, descripcion, nombre, tarifa, idFrecuencia_id, idTurno_id, usuario_id, zona_id)
values(0, 'Cuidador', 'Pedro', 433, 4, 1, 1, 4);
