/*Se crea la base de datos */
drop schema if exists santory; 
drop user if exists usuario11_Admin; 
CREATE SCHEMA santory;

/*Se crea un usuario para la base de datos llamado "usuario_admin" y tiene la contraseña "Usuario_Clave_admin."*/
create user 'usuario11_Admin'@'%' identified by 'Usuar1o_Clave11.'; 

/*Se asignan los privilegios sobre la base de datos santory al usuario creado */
grant all privileges on santory.* to 'usuario11_Admin'@'%'; 
flush privileges;

/* la tabla de categoria contiene categorias de productos*/ 
CREATE TABLE santory.nueva_Coleccion (
  id_nuevacoleccion INT NOT NULL AUTO_INCREMENT,
  precio DOUBLE NOT NULL,
  descripcion VARCHAR(1000) NOT NULL,
  cantidad_colores DOUBLE NOT NULL,
  talla VARCHAR(100) NOT NULL,
  activo BOOLEAN NOT NULL,
  ruta_imagen VARCHAR(1024),
  PRIMARY KEY (id_nuevacoleccion)
) ENGINE=InnoDB DEFAULT CHARACTER SET=utf8mb4;

CREATE TABLE santory.calzadoFemenino (
  id_calzadofemenino VARCHAR(50) NOT NULL,
  precio DOUBLE NOT NULL,
  descripcion VARCHAR(1000) NOT NULL,
  cantidad_colores DOUBLE NOT NULL,
  talla VARCHAR(100) NOT NULL,
  activo BOOLEAN NOT NULL,
  ruta_imagen VARCHAR(1024) NOT NULL,
  PRIMARY KEY (id_calzadofemenino)
) ENGINE=InnoDB DEFAULT CHARACTER SET=utf8mb4;

CREATE TABLE santory.promociones (
  id_promociones VARCHAR(50) NOT NULL,
  precio DOUBLE NOT NULL,
  descripcion VARCHAR(1000) NOT NULL,
  cantidad_colores DOUBLE NOT NULL,
  talla VARCHAR(100) NOT NULL,
  activo BOOLEAN NOT NULL,
  precio_promocion DOUBLE,
  ruta_imagen VARCHAR(1024) NOT NULL,
  PRIMARY KEY (id_promociones)
) ENGINE=InnoDB DEFAULT CHARACTER SET=utf8mb4;

CREATE TABLE santory.puntos_de_venta (
  id_sucursal INT AUTO_INCREMENT PRIMARY KEY,
  sucursal VARCHAR(100) NOT NULL,
  descripcion VARCHAR(255) NOT NULL,
  ubicacion VARCHAR(255) NOT NULL,
  horario VARCHAR(100) NOT NULL
);

CREATE TABLE santory.iniciar_sesion (
  id_iniciar_sesion INT AUTO_INCREMENT PRIMARY KEY,
  correo VARCHAR(255) NOT NULL,
  contraseña VARCHAR(255) NOT NULL
);

CREATE TABLE santory.crearcuenta (
  id_crearcuenta INT AUTO_INCREMENT PRIMARY KEY,
  nombre VARCHAR(100) NOT NULL,
  direccion VARCHAR(255) NOT NULL,
  telefono VARCHAR(20) NOT NULL,
  correo VARCHAR(255) NOT NULL,
  contraseña VARCHAR(255) NOT NULL,
  contraseña_r VARCHAR(255) NOT NULL
);

CREATE TABLE santory.agregarpago (
  id_agregarpago INT AUTO_INCREMENT PRIMARY KEY,
  nombre VARCHAR(100) NOT NULL,
  numero_tarjeta VARCHAR(255) NOT NULL,
  tipo_tarjeta VARCHAR(20) NOT NULL,
  fecha_expiracion VARCHAR(255) NOT NULL
);

CREATE TABLE santory.comentarios (
  id_comentarios INT AUTO_INCREMENT PRIMARY KEY,
  comentarios VARCHAR(255) NOT NULL,
  nota VARCHAR(255) NOT NULL
);

CREATE TABLE santory.carrusel (
  id_comentarios INT AUTO_INCREMENT PRIMARY KEY,
  ruta_imagen VARCHAR(1024) NOT NULL
);

/* Se insertan 6 registros en la tabla nuevaColeccion como ejemplo */
INSERT INTO santory.nueva_Coleccion (id_nuevacoleccion,precio, descripcion, cantidad_colores, talla, activo, ruta_imagen) 
VALUES  
('1', 33.990 , 'Tacones de cuña', 3, '30 a 37', true, 'https://scontent.fsyq1-1.fna.fbcdn.net/v/t39.30808-6/429889383_18225023866261012_4526814220045472137_n.jpg?_nc_cat=103&ccb=1-7&_nc_sid=5f2048&_nc_ohc=nh_e7N6oyR8AX-VPvQY&_nc_ht=scontent.fsyq1-1.fna&oh=00_AfASnrSj2VUbdnIylkGJjwB9Pehno-R3ggGt0Qs5oLN8aw&oe=66111134'), 
('2', 35.990, 'Zapatos Casuales negro, tacón versatil', 2, '30 a 37', true, 'https://scontent.fsyq1-1.fna.fbcdn.net/v/t39.30808-6/432918222_18226556464261012_3791558798204622225_n.jpg?_nc_cat=109&ccb=1-7&_nc_sid=5f2048&_nc_ohc=VND1bKcfiYAAX9bssFZ&_nc_ht=scontent.fsyq1-1.fna&oh=00_AfCebXsqHvDmYXCoWFw-Z_R_p8NJ2j9R3d4NdcoQ7pSS7w&oe=66111E30'), 
('3', 33.990, 'Los tenis negros que tu necesitas', 3, '30 a 37', true, 'https://scontent.fsyq1-1.fna.fbcdn.net/v/t39.30808-6/434146866_18227009983261012_2669282493296558767_n.jpg?_nc_cat=101&ccb=1-7&_nc_sid=5f2048&_nc_ohc=2uel7j7hPN4AX9BIwNk&_nc_ht=scontent.fsyq1-1.fna&oh=00_AfAykl4y6TnU95Pp30IQCQK3KEbs1jvjJRzwHRq7uDgVww&oe=6610FEA6'), 
('4', 32.990, 'Hermosas zapato con tacón cuadrado ', 1, '30 a 37', true, 'https://scontent.fsyq1-1.fna.fbcdn.net/v/t39.30808-6/434152779_18227120758261012_8184141444809732808_n.jpg?_nc_cat=111&ccb=1-7&_nc_sid=5f2048&_nc_ohc=Xh-nnW4HDYUAX86ENNX&_nc_ht=scontent.fsyq1-1.fna&oh=00_AfCB4X0tmC0imE1akXsroaJytUo6_fufY0fCvW78hadJUg&oe=6611298A'), 
('5', 32.990, 'Hermosas y delicado sandalia de cuña', 1, '30 a 37', true, 'https://scontent.fsyq1-1.fna.fbcdn.net/v/t39.30808-6/429844783_18225025267261012_5039331408297236333_n.jpg?_nc_cat=104&ccb=1-7&_nc_sid=5f2048&_nc_ohc=VKbYngoVsZsAX8LfLLl&_nc_ht=scontent.fsyq1-1.fna&oh=00_AfB7RHeQ7RCYskSDUbsgJD86uxrRZUiRUt6LGNUDYwuYzw&oe=66111B62'), 
('6', 33.990, 'Botines de CHAROL NEGRO', 1, '30 a 37', true, 'https://scontent.fsyq1-1.fna.fbcdn.net/v/t39.30808-6/429654342_18224486740261012_1645328151283247593_n.jpg?_nc_cat=109&ccb=1-7&_nc_sid=5f2048&_nc_ohc=kK2D_TUI7yQAX8TSV5N&_nc_ht=scontent.fsyq1-1.fna&oh=00_AfAqQ-YILSZOKaswIw6vSoMUHC4t44pYgNNd6MMWhijQ8Q&oe=66111F61');

/* Se insertan 6 registros en la tabla calzadoFemenino como ejemplo */
INSERT INTO santory.calzadoFemenino (id_calzadofemenino, precio, descripcion, cantidad_colores, talla, activo, ruta_imagen) VALUES 
('1', 32.900 , 'Hermosa Sandalia de Plataforma en tonos Plata con textura', 2, '30 a 37', true, 'https://scontent.fsjo6-1.fna.fbcdn.net/v/t39.30808-6/434778346_18227562880261012_79573498492049520_n.jpg?_nc_cat=108&ccb=1-7&_nc_sid=5f2048&_nc_ohc=R71Mqyt9ce4AX9uK4Ps&_nc_ht=scontent.fsjo6-1.fna&oh=00_AfDctsDYewe786Roe9BA_bXUE4OBSkLLMm9rdwFm0672RA&oe=66115749'),
('2', 33.990, 'Zapatos Casuales con tonalidades Cafes', 1, '30 a 37', true, 'https://scontent.fsjo6-1.fna.fbcdn.net/v/t39.30808-6/432782492_18226432903261012_7955609591458910186_n.jpg?_nc_cat=108&ccb=1-7&_nc_sid=5f2048&_nc_ohc=ll8TsCIbObwAX-ut-3w&_nc_ht=scontent.fsjo6-1.fna&oh=00_AfCX0NbINd9Egg-7nx088RYTLS51lDTAMKTT3Gd-d7ymaA&oe=66114D77'),
('3', 34.990, 'Hermosos Tacones comodos con tonalidad vino', 1, '30 a 37', true, 'https://scontent.fsjo6-1.fna.fbcdn.net/v/t39.30808-6/432994332_18226111153261012_7081523130729133078_n.jpg?_nc_cat=108&ccb=1-7&_nc_sid=5f2048&_nc_ohc=0RoQd4e7RO0AX9bTwMC&_nc_ht=scontent.fsjo6-1.fna&oh=00_AfDx5CBSCnT_Y02BK_OLKlzUwEFq3ZyQ4E-ouzx47mvPeg&oe=661160DE'),
('4', 38.990, 'Hermosas Alpargatas con elastico tonalidad nude', 1, '30 a 37', true, 'https://scontent.fsjo6-1.fna.fbcdn.net/v/t39.30808-6/430134774_18225348517261012_1851596409376565795_n.jpg?_nc_cat=101&ccb=1-7&_nc_sid=5f2048&_nc_ohc=-XfS0poqAU4AX_9kLjq&_nc_ht=scontent.fsjo6-1.fna&oh=00_AfDAm22yqk4KONYGsR0V28H5DSp3oevJsiWSYxHf7GfAQQ&oe=66113D11'),
('5', 33.990, 'Sandalias elegantes y de verano color negro', 1, '30 a 37', true, 'https://scontent.fsjo6-1.fna.fbcdn.net/v/t39.30808-6/429861851_18225023911261012_3931391359307917745_n.jpg?_nc_cat=108&ccb=1-7&_nc_sid=5f2048&_nc_ohc=srz_ZpNOonYAX8fxM19&_nc_ht=scontent.fsjo6-1.fna&oh=00_AfD5C_-pRBmjgvlgKSkI6AI7_rE-cZvnyZWMnU0LcK3LBw&oe=661167E2'),
('6', 32.990, 'Hermosos zapatos para Dama Cafes', 1, '30 a 37', true, 'https://scontent.fsjo6-1.fna.fbcdn.net/v/t39.30808-6/430092008_18224694433261012_2848940826479692718_n.jpg?_nc_cat=100&ccb=1-7&_nc_sid=5f2048&_nc_ohc=Rf1AWcwOuoYAX-hhbGW&_nc_oc=AdgyLFycB8fw4KT5vWEab_lJHkzAKumKQEwgpm21XpfY3UTTScQwQJCBZmnRB6DAT0BWJmk5HbKu7zQsLnuDWJYd&_nc_ht=scontent.fsjo6-1.fna&oh=00_AfCekD1MDwwe9QxOUPqtukYjqqlxP1keji9yzh54bcJQLQ&oe=661158A0');

/* Se insertan 6 registros en la tabla promociones como ejemplo */
INSERT INTO santory.promociones (id_promociones, precio, descripcion, cantidad_colores, talla, activo, precio_promocion, ruta_imagen) VALUES 
('1', 32.990, 'Charol negro y detalles', 1, '30 a 37', true, 29.990, 'https://scontent.fsyq4-2.fna.fbcdn.net/v/t39.30808-6/426934901_18222024355261012_4431778883428756166_n.jpg?_nc_cat=110&ccb=1-7&_nc_sid=5f2048&_nc_ohc=DaT8mfVAm4cAX8VlyRF&_nc_ht=scontent.fsyq4-2.fna&oh=00_AfCl2XdkYnWSq0b6xvpva24GNYLXR3ehcuFgNOre8I-9sA&oe=6609F63F'),
('2', 35.990, 'Tenis hermosas básicos indiscutibles', 1, '30 a 37', true, 32.990, 'https://scontent.fsyq4-1.fna.fbcdn.net/v/t39.30808-6/427107022_18222024403261012_6973178520421281572_n.jpg?_nc_cat=106&ccb=1-7&_nc_sid=5f2048&_nc_ohc=ZRPwGp3YCUIAX_N6YIQ&_nc_ht=scontent.fsyq4-1.fna&oh=00_AfBKHE9lmmDFC04Igy98zccNIfH09jC3xTZzp15WA9imIQ&oe=6608E57A'),
('3', 33.990, 'Oxford Favoritos', 2, '30 a 37', true, 30.990, 'https://scontent.fsyq4-2.fna.fbcdn.net/v/t39.30808-6/425818686_18221699968261012_3489203503402818769_n.jpg?_nc_cat=108&ccb=1-7&_nc_sid=5f2048&_nc_ohc=rgUHcvNRzSkAX-HwPjr&_nc_ht=scontent.fsyq4-2.fna&oh=00_AfDcLZqhsoNcFbiFeT8YbO1tVErMOCZR9KH9Dx1dWZl_sQ&oe=6608B8BB'),
('4', 35.990, 'Hermosas Alpargatas con elastico tonalidad nude', 1, '30 a 37', true, 30.990, 'https://scontent.fsjo6-1.fna.fbcdn.net/v/t39.30808-6/430134774_18225348517261012_1851596409376565795_n.jpg?_nc_cat=101&ccb=1-7&_nc_sid=5f2048&_nc_ohc=-XfS0poqAU4AX_9kLjq&_nc_ht=scontent.fsjo6-1.fna&oh=00_AfDAm22yqk4KONYGsR0V28H5DSp3oevJsiWSYxHf7GfAQQ&oe=66113D11'),
('5', 32.990, 'Sandalias elegantes y de verano color negro', 1, '30 a 37', true, 29.990, 'https://scontent.fsjo6-1.fna.fbcdn.net/v/t39.30808-6/429861851_18225023911261012_3931391359307917745_n.jpg?_nc_cat=108&ccb=1-7&_nc_sid=5f2048&_nc_ohc=srz_ZpNOonYAX8fxM19&_nc_ht=scontent.fsjo6-1.fna&oh=00_AfD5C_-pRBmjgvlgKSkI6AI7_rE-cZvnyZWMnU0LcK3LBw&oe=661167E2'),
('6', 32.990, 'Hermosos ', 1, '30 a 37', true, 29.990, 'https://scontent.fsjo6-1.fna.fbcdn.net/v/t39.30808-6/430092008_18224694433261012_2848940826479692718_n.jpg?_nc_cat=100&ccb=1-7&_nc_sid=5f2048&_nc_ohc=Rf1AWcwOuoYAX-hhbGW&_nc_oc=AdgyLFycB8fw4KT5vWEab_lJHkzAKumKQEwgpm21XpfY3UTTScQwQJCBZmnRB6DAT0BWJmk5HbKu7zQsLnuDWJYd&_nc_ht=scontent.fsjo6-1.fna&oh=00_AfCekD1MDwwe9QxOUPqtukYjqqlxP1keji9yzh54bcJQLQ&oe=661158A0');

/* Se inserta un registro en la tabla carrusel como ejemplo */
INSERT INTO santory.carrusel (ruta_imagen) VALUES 
('https://scontent.fsjo14-1.fna.fbcdn.net/v/t39.30808-6/305923989_3246290435638547_6050255729709782789_n.png?_nc_cat=108&ccb=1-7&_nc_sid=5f2048&_nc_ohc=DCYnxjVqsvsAX95DdI3&_nc_ht=scontent.fsjo14-1.fna&oh=00_AfAwj6R0ZGUHzxHLeiS6mDLhIXEcpSr-GNpvbkZfDH7D0g&oe=660FE063'),
('https://scontent.fsjo14-1.fna.fbcdn.net/v/t39.30808-6/295268925_3209634789304112_7376739896725703594_n.jpg?_nc_cat=110&ccb=1-7&_nc_sid=5f2048&_nc_ohc=AekL3F0mEFoAX8dFloe&_nc_ht=scontent.fsjo14-1.fna&oh=00_AfC_0M42DS7f2Tb0C-X8MaA2qej7ahgzJpFk2RuHjQWqAQ&oe=660FDD9C');