

INSERT INTO usuario (id, username, password, email, enabled, tipo) VALUES(2,	'pepe',	'$2a$10$zlD33q.JAxrRPsUGYGY7tedH/dQUn2MmlxQzjO7Y.oqK6rOjJdueq',	'pepe@gmail.com', 1, 'ADMIN');
INSERT INTO usuario (id, username, password, email, enabled, tipo) VALUES(5,	'admin',	'$2a$10$krlxeZI8Xm.n1fNz7v81Y.yzsHtoMoCnDCsStEAPeGkE9BUOBkwn2',	'admin@correo.com', 1, 'ADMIN');
INSERT INTO usuario (id, username, password, email, enabled, tipo) VALUES(7,	'obijuan',	'$2a$10$.EJQbCFZtHW1pavBGmMkw.VxOn2or6AL2oPP.8RVvCSqXQA/zwUom',	'darkside@starwars.com', 1, 'ADMIN');
INSERT INTO usuario (id, username, password, email, enabled, tipo) VALUES(13,	'gerente',	'$2a$10$hWkDEd0V0QgmiffgPcSkoe1.OMq5ew.wl7OFBMqii5XkfxtIwzZ92',	'gerencia@vdc.com', 1, 'ADMIN');

-- INSERT INTO usuario_rol (authority, user_username) VALUES ('ADMIN', 'obijuan');
-- INSERT INTO usuario_rol (authority, user_username) VALUES ('USER', 'obijuan');

INSERT INTO instalacion (id, nombre) VALUES (7,	'tenis arriba');
INSERT INTO instalacion (id, nombre) VALUES (8,	'tenis césped artificial');
INSERT INTO instalacion (id, nombre) VALUES (9,	'fútbol');
INSERT INTO instalacion (id, nombre) VALUES (10,	'baloncesto');
INSERT INTO instalacion (id, nombre) VALUES (11,	'squash');
INSERT INTO instalacion (id, nombre) VALUES (13,	'sauna mujeres');
INSERT INTO instalacion (id, nombre) VALUES (14,	'pista de pádel');
INSERT INTO instalacion (id, nombre) VALUES (16,	'sauna caballeros');


INSERT INTO horario (id, instalacion_id, hora_inicio, hora_fin) VALUES (1,	7,	'08:00:00',	'09:00:00');
INSERT INTO horario (id, instalacion_id, hora_inicio, hora_fin) VALUES (2,	7,	'09:00:00',	'10:00:00');
INSERT INTO horario (id, instalacion_id, hora_inicio, hora_fin) VALUES (3,	7,	'10:00:00',	'11:00:00');
INSERT INTO horario (id, instalacion_id, hora_inicio, hora_fin) VALUES (4,	7,	'11:00:00',	'12:00:00');
INSERT INTO horario (id, instalacion_id, hora_inicio, hora_fin) VALUES (5,	7,	'12:00:00',	'13:00:00');
INSERT INTO horario (id, instalacion_id, hora_inicio, hora_fin) VALUES (6,	7,	'13:00:00',	'14:00:00');
INSERT INTO horario (id, instalacion_id, hora_inicio, hora_fin) VALUES (7,	7,	'14:00:00',	'15:00:00');
INSERT INTO horario (id, instalacion_id, hora_inicio, hora_fin) VALUES (8,	7,	'15:00:00',	'16:00:00');
INSERT INTO horario (id, instalacion_id, hora_inicio, hora_fin) VALUES (9,	7,	'16:00:00',	'17:00:00');
INSERT INTO horario (id, instalacion_id, hora_inicio, hora_fin) VALUES (10,	7,	'17:00:00',	'18:00:00');
INSERT INTO horario (id, instalacion_id, hora_inicio, hora_fin) VALUES (11,	7,	'18:00:00',	'19:00:00');
INSERT INTO horario (id, instalacion_id, hora_inicio, hora_fin) VALUES (12,	7,	'19:00:00',	'20:00:00');
INSERT INTO horario (id, instalacion_id, hora_inicio, hora_fin) VALUES (13,	7,	'20:00:00',	'21:00:00');
INSERT INTO horario (id, instalacion_id, hora_inicio, hora_fin) VALUES (14,	7,	'21:00:00',	'22:00:00');
INSERT INTO horario (id, instalacion_id, hora_inicio, hora_fin) VALUES (15,	7,	'22:00:00',	'23:00:00');
INSERT INTO horario (id, instalacion_id, hora_inicio, hora_fin) VALUES (16,	8,	'08:00:00',	'09:00:00');
INSERT INTO horario (id, instalacion_id, hora_inicio, hora_fin) VALUES (17,	8,	'09:00:00',	'10:00:00');
INSERT INTO horario (id, instalacion_id, hora_inicio, hora_fin) VALUES (18,	8,	'10:00:00',	'11:00:00');
INSERT INTO horario (id, instalacion_id, hora_inicio, hora_fin) VALUES (19,	8,	'11:00:00',	'12:00:00');
INSERT INTO horario (id, instalacion_id, hora_inicio, hora_fin) VALUES (20,	8,	'12:00:00',	'13:00:00');
INSERT INTO horario (id, instalacion_id, hora_inicio, hora_fin) VALUES (21,	8,	'13:00:00',	'14:00:00');
INSERT INTO horario (id, instalacion_id, hora_inicio, hora_fin) VALUES (22,	8,	'14:00:00',	'15:00:00');
INSERT INTO horario (id, instalacion_id, hora_inicio, hora_fin) VALUES (23,	8,	'15:00:00',	'16:00:00');
INSERT INTO horario (id, instalacion_id, hora_inicio, hora_fin) VALUES (24,	8,	'16:00:00',	'17:00:00');
INSERT INTO horario (id, instalacion_id, hora_inicio, hora_fin) VALUES (25,	8,	'17:00:00',	'18:00:00');
INSERT INTO horario (id, instalacion_id, hora_inicio, hora_fin) VALUES (26,	8,	'18:00:00',	'19:00:00');
INSERT INTO horario (id, instalacion_id, hora_inicio, hora_fin) VALUES (27,	8,	'19:00:00',	'20:00:00');
INSERT INTO horario (id, instalacion_id, hora_inicio, hora_fin) VALUES (28,	8,	'20:00:00',	'21:00:00');
INSERT INTO horario (id, instalacion_id, hora_inicio, hora_fin) VALUES (29,	8,	'21:00:00',	'22:00:00');
INSERT INTO horario (id, instalacion_id, hora_inicio, hora_fin) VALUES (30,	8,	'22:00:00',	'23:00:00');
INSERT INTO horario (id, instalacion_id, hora_inicio, hora_fin) VALUES (31,	9,	'08:00:00',	'09:30:00');
INSERT INTO horario (id, instalacion_id, hora_inicio, hora_fin) VALUES (32,	9,	'09:30:00',	'11:00:00');
INSERT INTO horario (id, instalacion_id, hora_inicio, hora_fin) VALUES (33,	9,	'11:00:00',	'12:30:00');
INSERT INTO horario (id, instalacion_id, hora_inicio, hora_fin) VALUES (34,	9,	'12:30:00',	'14:00:00');
INSERT INTO horario (id, instalacion_id, hora_inicio, hora_fin) VALUES (35,	9,	'14:00:00',	'15:30:00');
INSERT INTO horario (id, instalacion_id, hora_inicio, hora_fin) VALUES (36,	9,	'15:30:00',	'17:00:00');
INSERT INTO horario (id, instalacion_id, hora_inicio, hora_fin) VALUES (37,	9,	'17:00:00',	'18:30:00');
INSERT INTO horario (id, instalacion_id, hora_inicio, hora_fin) VALUES (38,	9,	'18:30:00',	'20:00:00');
INSERT INTO horario (id, instalacion_id, hora_inicio, hora_fin) VALUES (39,	9,	'20:00:00',	'21:30:00');
INSERT INTO horario (id, instalacion_id, hora_inicio, hora_fin) VALUES (40,	9,	'21:30:00',	'23:00:00');
INSERT INTO horario (id, instalacion_id, hora_inicio, hora_fin) VALUES (41,	9,	'23:00:00',	'00:30:00');
INSERT INTO horario (id, instalacion_id, hora_inicio, hora_fin) VALUES (42,	10,	'08:00:00',	'09:00:00');
INSERT INTO horario (id, instalacion_id, hora_inicio, hora_fin) VALUES (43,	10,	'09:00:00',	'10:00:00');
INSERT INTO horario (id, instalacion_id, hora_inicio, hora_fin) VALUES (44,	10,	'10:00:00',	'11:00:00');
INSERT INTO horario (id, instalacion_id, hora_inicio, hora_fin) VALUES (45,	10,	'11:00:00',	'12:00:00');
INSERT INTO horario (id, instalacion_id, hora_inicio, hora_fin) VALUES (46,	10,	'12:00:00',	'13:00:00');
INSERT INTO horario (id, instalacion_id, hora_inicio, hora_fin) VALUES (47,	10,	'13:00:00',	'14:00:00');
INSERT INTO horario (id, instalacion_id, hora_inicio, hora_fin) VALUES (48,	10,	'14:00:00',	'15:00:00');
INSERT INTO horario (id, instalacion_id, hora_inicio, hora_fin) VALUES (49,	10,	'15:00:00',	'16:00:00');
INSERT INTO horario (id, instalacion_id, hora_inicio, hora_fin) VALUES (50,	10,	'16:00:00',	'17:00:00');
INSERT INTO horario (id, instalacion_id, hora_inicio, hora_fin) VALUES (51,	10,	'17:00:00',	'18:00:00');
INSERT INTO horario (id, instalacion_id, hora_inicio, hora_fin) VALUES (52,	10,	'18:00:00',	'19:00:00');
INSERT INTO horario (id, instalacion_id, hora_inicio, hora_fin) VALUES (53,	10,	'19:00:00',	'20:00:00');
INSERT INTO horario (id, instalacion_id, hora_inicio, hora_fin) VALUES (54,	10,	'20:00:00',	'21:00:00');
INSERT INTO horario (id, instalacion_id, hora_inicio, hora_fin) VALUES (55,	10,	'21:00:00',	'22:00:00');
INSERT INTO horario (id, instalacion_id, hora_inicio, hora_fin) VALUES (56,	10,	'22:00:00',	'23:00:00');
INSERT INTO horario (id, instalacion_id, hora_inicio, hora_fin) VALUES (57,	11,	'08:00:00',	'08:45:00');
INSERT INTO horario (id, instalacion_id, hora_inicio, hora_fin) VALUES (58,	11,	'08:45:00',	'09:30:00');
INSERT INTO horario (id, instalacion_id, hora_inicio, hora_fin) VALUES (59,	11,	'09:30:00',	'10:15:00');
INSERT INTO horario (id, instalacion_id, hora_inicio, hora_fin) VALUES (60,	11,	'10:15:00',	'11:00:00');
INSERT INTO horario (id, instalacion_id, hora_inicio, hora_fin) VALUES (61,	11,	'11:00:00',	'11:45:00');
INSERT INTO horario (id, instalacion_id, hora_inicio, hora_fin) VALUES (62,	11,	'11:45:00',	'12:30:00');
INSERT INTO horario (id, instalacion_id, hora_inicio, hora_fin) VALUES (63,	11,	'12:30:00',	'13:15:00');
INSERT INTO horario (id, instalacion_id, hora_inicio, hora_fin) VALUES (64,	11,	'13:15:00',	'14:00:00');
INSERT INTO horario (id, instalacion_id, hora_inicio, hora_fin) VALUES (65,	11,	'14:00:00',	'14:45:00');
INSERT INTO horario (id, instalacion_id, hora_inicio, hora_fin) VALUES (66,	11,	'14:45:00',	'15:30:00');
INSERT INTO horario (id, instalacion_id, hora_inicio, hora_fin) VALUES (67,	11,	'15:30:00',	'16:15:00');
INSERT INTO horario (id, instalacion_id, hora_inicio, hora_fin) VALUES (68,	11,	'16:15:00',	'17:00:00');
INSERT INTO horario (id, instalacion_id, hora_inicio, hora_fin) VALUES (69,	11,	'17:00:00',	'17:45:00');
INSERT INTO horario (id, instalacion_id, hora_inicio, hora_fin) VALUES (70,	11,	'17:45:00',	'18:30:00');
INSERT INTO horario (id, instalacion_id, hora_inicio, hora_fin) VALUES (71,	11,	'18:30:00',	'19:15:00');
INSERT INTO horario (id, instalacion_id, hora_inicio, hora_fin) VALUES (72,	11,	'19:15:00',	'20:00:00');
INSERT INTO horario (id, instalacion_id, hora_inicio, hora_fin) VALUES (73,	11,	'20:00:00',	'20:45:00');
INSERT INTO horario (id, instalacion_id, hora_inicio, hora_fin) VALUES (74,	11,	'20:45:00',	'21:30:00');
INSERT INTO horario (id, instalacion_id, hora_inicio, hora_fin) VALUES (75,	11,	'21:30:00',	'22:15:00');
INSERT INTO horario (id, instalacion_id, hora_inicio, hora_fin) VALUES (103,	13,	'09:00:00',	'09:30:00');
INSERT INTO horario (id, instalacion_id, hora_inicio, hora_fin) VALUES (104,	13,	'09:30:00',	'10:00:00');
INSERT INTO horario (id, instalacion_id, hora_inicio, hora_fin) VALUES (105,	13,	'10:00:00',	'10:30:00');
INSERT INTO horario (id, instalacion_id, hora_inicio, hora_fin) VALUES (106,	13,	'10:30:00',	'11:00:00');
INSERT INTO horario (id, instalacion_id, hora_inicio, hora_fin) VALUES (107,	13,	'11:00:00',	'11:30:00');
INSERT INTO horario (id, instalacion_id, hora_inicio, hora_fin) VALUES (108,	13,	'11:30:00',	'12:00:00');
INSERT INTO horario (id, instalacion_id, hora_inicio, hora_fin) VALUES (109,	13,	'12:00:00',	'12:30:00');
INSERT INTO horario (id, instalacion_id, hora_inicio, hora_fin) VALUES (110,	13,	'12:30:00',	'13:00:00');
INSERT INTO horario (id, instalacion_id, hora_inicio, hora_fin) VALUES (111,	13,	'13:00:00',	'13:30:00');
INSERT INTO horario (id, instalacion_id, hora_inicio, hora_fin) VALUES (112,	13,	'13:30:00',	'14:00:00');
INSERT INTO horario (id, instalacion_id, hora_inicio, hora_fin) VALUES (113,	13,	'14:00:00',	'14:30:00');
INSERT INTO horario (id, instalacion_id, hora_inicio, hora_fin) VALUES (114,	13,	'14:30:00',	'15:00:00');
INSERT INTO horario (id, instalacion_id, hora_inicio, hora_fin) VALUES (115,	13,	'15:00:00',	'15:30:00');
INSERT INTO horario (id, instalacion_id, hora_inicio, hora_fin) VALUES (116,	13,	'15:30:00',	'16:00:00');
INSERT INTO horario (id, instalacion_id, hora_inicio, hora_fin) VALUES (117,	13,	'16:00:00',	'16:30:00');
INSERT INTO horario (id, instalacion_id, hora_inicio, hora_fin) VALUES (118,	13,	'16:30:00',	'17:00:00');
INSERT INTO horario (id, instalacion_id, hora_inicio, hora_fin) VALUES (119,	13,	'17:00:00',	'17:30:00');
INSERT INTO horario (id, instalacion_id, hora_inicio, hora_fin) VALUES (120,	13,	'17:30:00',	'18:00:00');
INSERT INTO horario (id, instalacion_id, hora_inicio, hora_fin) VALUES (121,	13,	'18:00:00',	'18:30:00');
INSERT INTO horario (id, instalacion_id, hora_inicio, hora_fin) VALUES (122,	13,	'18:30:00',	'19:00:00');
INSERT INTO horario (id, instalacion_id, hora_inicio, hora_fin) VALUES (123,	13,	'19:00:00',	'19:30:00');
INSERT INTO horario (id, instalacion_id, hora_inicio, hora_fin) VALUES (124,	13,	'19:30:00',	'20:00:00');
INSERT INTO horario (id, instalacion_id, hora_inicio, hora_fin) VALUES (125,	13,	'20:00:00',	'20:30:00');
INSERT INTO horario (id, instalacion_id, hora_inicio, hora_fin) VALUES (126,	13,	'20:30:00',	'21:00:00');
INSERT INTO horario (id, instalacion_id, hora_inicio, hora_fin) VALUES (127,	13,	'21:00:00',	'21:30:00');
INSERT INTO horario (id, instalacion_id, hora_inicio, hora_fin) VALUES (128,	13,	'21:30:00',	'22:00:00');
INSERT INTO horario (id, instalacion_id, hora_inicio, hora_fin) VALUES (129,	13,	'22:00:00',	'22:30:00');
INSERT INTO horario (id, instalacion_id, hora_inicio, hora_fin) VALUES (130,	14,	'08:00:00',	'09:30:00');
INSERT INTO horario (id, instalacion_id, hora_inicio, hora_fin) VALUES (131,	14,	'09:30:00',	'11:00:00');
INSERT INTO horario (id, instalacion_id, hora_inicio, hora_fin) VALUES (132,	14,	'11:00:00',	'12:30:00');
INSERT INTO horario (id, instalacion_id, hora_inicio, hora_fin) VALUES (133,	14,	'12:30:00',	'14:00:00');
INSERT INTO horario (id, instalacion_id, hora_inicio, hora_fin) VALUES (134,	14,	'14:00:00',	'15:30:00');
INSERT INTO horario (id, instalacion_id, hora_inicio, hora_fin) VALUES (135,	14,	'15:30:00',	'17:00:00');
INSERT INTO horario (id, instalacion_id, hora_inicio, hora_fin) VALUES (136,	14,	'17:00:00',	'18:30:00');
INSERT INTO horario (id, instalacion_id, hora_inicio, hora_fin) VALUES (137,	14,	'18:30:00',	'20:00:00');
INSERT INTO horario (id, instalacion_id, hora_inicio, hora_fin) VALUES (138,	14,	'20:00:00',	'21:30:00');
INSERT INTO horario (id, instalacion_id, hora_inicio, hora_fin) VALUES (139,	14,	'21:30:00',	'23:00:00');
INSERT INTO horario (id, instalacion_id, hora_inicio, hora_fin) VALUES (140,	14,	'23:00:00',	'00:30:00');



INSERT INTO reserva (id, usuario_id, horario_id, fecha) VALUES (1,	2,	130,	'2019-10-12');
INSERT INTO reserva (id, usuario_id, horario_id, fecha) VALUES (2,	2,	130,	'2019-10-13');
INSERT INTO reserva (id, usuario_id, horario_id, fecha) VALUES (4,	7,	120,	'2019-11-11');
INSERT INTO reserva (id, usuario_id, horario_id, fecha) VALUES (5,	7,	130,	'2019-11-21');



-- INSERT INTO `usuario_rol` (`authority`, `user_id`) VALUES ('Admin', '5');

-- INSERT INTO `usuario_rol` (`authority`, `user_id`) VALUES ('Admin', '7');
-- INSERT INTO `usuario_rol` (`authority`, `user_id`) VALUES ('User', '7');
-- INSERT INTO `usuario_rol` (`authority`, `user_id`) VALUES ('Operator', '7');


-- INSERT INTO `usuario_rol` (`authority`, `user_id`) VALUES ('Admin', '13');
-- INSERT INTO `usuario_rol` (`authority`, `user_id`) VALUES ('User', '13');
-- INSERT INTO `usuario_rol` (`authority`, `user_id`) VALUES ('Operator', '13');
