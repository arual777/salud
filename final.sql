CREATE TABLE `asistencia` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `camaAdentro` bit(1) DEFAULT NULL,
  `descripcion` varchar(255) DEFAULT NULL,
  `nombre` varchar(255) DEFAULT NULL,
  `tarifa` double DEFAULT NULL,
  `idFrecuencia_id` bigint DEFAULT NULL,
  `idTurno_id` bigint DEFAULT NULL,
  `usuario_id` bigint DEFAULT NULL,
  `zona_id` bigint DEFAULT NULL,
  `latitud` double DEFAULT NULL,
  `longitud` double DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK82y3w90524wqm3mmsjdy027tg` (`idFrecuencia_id`),
  KEY `FK6dje5w16qdn7edx806lqgvau5` (`idTurno_id`),
  KEY `FKlhu11jtt1imrwsrjvr99qel1b` (`usuario_id`),
  KEY `FKkiobtrwr1h9aoumonp3odgxmf` (`zona_id`),
  CONSTRAINT `FK6dje5w16qdn7edx806lqgvau5` FOREIGN KEY (`idTurno_id`) REFERENCES `tipo_turno` (`id`),
  CONSTRAINT `FK82y3w90524wqm3mmsjdy027tg` FOREIGN KEY (`idFrecuencia_id`) REFERENCES `tipo_asistencia` (`id`),
  CONSTRAINT `FKkiobtrwr1h9aoumonp3odgxmf` FOREIGN KEY (`zona_id`) REFERENCES `zona` (`id`),
  CONSTRAINT `FKlhu11jtt1imrwsrjvr99qel1b` FOREIGN KEY (`usuario_id`) REFERENCES `usuario` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE `contacto` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `email` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `subject` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `idx_contacto_name` (`name`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE `cuenta` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `creada` datetime(6) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE `mensaje` (
  `idMensaje` bigint NOT NULL AUTO_INCREMENT,
  `pregunta` varchar(255) DEFAULT NULL,
  `respuesta` varchar(255) DEFAULT NULL,
  `asistencia_id` bigint DEFAULT NULL,
  `usuario_id` bigint DEFAULT NULL,
  `respuestaLeida` bit(1) DEFAULT NULL,
  PRIMARY KEY (`idMensaje`),
  KEY `FK7q9y46pf1mhl7shvbxfee8j0l` (`asistencia_id`),
  KEY `FKh2h320alx2b44492vwkemkfa5` (`usuario_id`),
  CONSTRAINT `FK7q9y46pf1mhl7shvbxfee8j0l` FOREIGN KEY (`asistencia_id`) REFERENCES `asistencia` (`id`),
  CONSTRAINT `FKh2h320alx2b44492vwkemkfa5` FOREIGN KEY (`usuario_id`) REFERENCES `usuario` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE `perfilprofesional` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `email` varchar(255) NOT NULL,
  `experiencia` varchar(255) NOT NULL,
  `fechaNacimiento` varchar(255) NOT NULL,
  `nombreCompleto` varchar(255) NOT NULL,
  `numeroTelefono` varchar(255) NOT NULL,
  `idUsuario_id` bigint DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKpvp1lcs73lyltc3c01fvuk7ik` (`idUsuario_id`),
  CONSTRAINT `FKpvp1lcs73lyltc3c01fvuk7ik` FOREIGN KEY (`idUsuario_id`) REFERENCES `usuario` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE `postulacion` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `Aceptado` bit(1) DEFAULT NULL,
  `asistencia_id` bigint DEFAULT NULL,
  `profesional_id` bigint DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKj94qr2vnkpqnbo6rjajtetrw2` (`asistencia_id`),
  KEY `FK7wagiiro8kkaefmgoy0six0ya` (`profesional_id`),
  CONSTRAINT `FK7wagiiro8kkaefmgoy0six0ya` FOREIGN KEY (`profesional_id`) REFERENCES `usuario` (`id`),
  CONSTRAINT `FKj94qr2vnkpqnbo6rjajtetrw2` FOREIGN KEY (`asistencia_id`) REFERENCES `asistencia` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE `resenia` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `calificacion` int DEFAULT NULL,
  `comentario` varchar(255) DEFAULT NULL,
  `idUsuarioCliente_id` bigint DEFAULT NULL,
  `idUsuarioProfesional_id` bigint DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK4t69qc0rbf350uojve74eeter` (`idUsuarioCliente_id`),
  KEY `FK99sslthmqckqrb97i3yi20a4e` (`idUsuarioProfesional_id`),
  CONSTRAINT `FK4t69qc0rbf350uojve74eeter` FOREIGN KEY (`idUsuarioCliente_id`) REFERENCES `usuario` (`id`),
  CONSTRAINT `FK99sslthmqckqrb97i3yi20a4e` FOREIGN KEY (`idUsuarioProfesional_id`) REFERENCES `usuario` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE `reseniaacliente` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `calificacion` int DEFAULT NULL,
  `comentario` varchar(255) DEFAULT NULL,
  `idUsuarioCliente_id` bigint DEFAULT NULL,
  `idUsuarioProfesional_id` bigint DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKfo2h4sf1ryvdti0ujktq5jusg` (`idUsuarioCliente_id`),
  KEY `FKnmr0wcu20etsu3vod40leurqa` (`idUsuarioProfesional_id`),
  CONSTRAINT `FKfo2h4sf1ryvdti0ujktq5jusg` FOREIGN KEY (`idUsuarioCliente_id`) REFERENCES `usuario` (`id`),
  CONSTRAINT `FKnmr0wcu20etsu3vod40leurqa` FOREIGN KEY (`idUsuarioProfesional_id`) REFERENCES `usuario` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE `reseniaaprofesional` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `calificacion` int DEFAULT NULL,
  `comentario` varchar(255) DEFAULT NULL,
  `idUsuarioCliente_id` bigint DEFAULT NULL,
  `idUsuarioProfesional_id` bigint DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK6hdun2februwo84yjlrw8od86` (`idUsuarioCliente_id`),
  KEY `FKr8hrwoeg932thhsq4ekom5m10` (`idUsuarioProfesional_id`),
  CONSTRAINT `FK6hdun2februwo84yjlrw8od86` FOREIGN KEY (`idUsuarioCliente_id`) REFERENCES `usuario` (`id`),
  CONSTRAINT `FKr8hrwoeg932thhsq4ekom5m10` FOREIGN KEY (`idUsuarioProfesional_id`) REFERENCES `usuario` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE `rol` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `descripcion` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE `tipo_asistencia` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `nombre` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE `tipo_turno` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `franja` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE `usuario` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `activo` bit(1) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `cuenta_id` bigint DEFAULT NULL,
  `perfilProfesional_id` bigint DEFAULT NULL,
  `rol_id` bigint DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKb2wjq49wwd6rm6ohh2sbuwogh` (`cuenta_id`),
  KEY `FKss882b5sd0nas6jji9btsxed1` (`perfilProfesional_id`),
  KEY `FK1v1biusy9gsnms5f0fjhqag68` (`rol_id`),
  CONSTRAINT `FK1v1biusy9gsnms5f0fjhqag68` FOREIGN KEY (`rol_id`) REFERENCES `rol` (`id`),
  CONSTRAINT `FKb2wjq49wwd6rm6ohh2sbuwogh` FOREIGN KEY (`cuenta_id`) REFERENCES `cuenta` (`id`),
  CONSTRAINT `FKss882b5sd0nas6jji9btsxed1` FOREIGN KEY (`perfilProfesional_id`) REFERENCES `perfilprofesional` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE `zona` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `nombre` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
