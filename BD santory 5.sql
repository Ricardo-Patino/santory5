/*Se crea la base de datos */

drop schema if exists santory; 
drop user if exists usuario11_Admin; 
CREATE SCHEMA santory;



/Se crea un usuario para la base de datos llamado "usuario_admin" y tiene la contraseña "Usuario_Clave_admin."/
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
  existencias int,  
  activo BOOLEAN NOT NULL,
  ruta_imagen VARCHAR(1024),
  PRIMARY KEY (id_nuevacoleccion)
) ENGINE=InnoDB DEFAULT CHARACTER SET=utf8mb4;


CREATE TABLE santory.calzadoFemenino (
  id_calzadofemenino INT NOT NULL AUTO_INCREMENT,
  precio DOUBLE NOT NULL,
  descripcion VARCHAR(1000) NOT NULL,
  cantidad_colores DOUBLE NOT NULL,
  talla VARCHAR(100) NOT NULL,
  existencias int,  
  activo BOOLEAN NOT NULL,
  ruta_imagen VARCHAR(1024),
  PRIMARY KEY (id_calzadofemenino)

) ENGINE=InnoDB DEFAULT CHARACTER SET=utf8mb4;



CREATE TABLE santory.promociones (

  id_promociones INT NOT NULL AUTO_INCREMENT,
  precio DOUBLE NOT NULL,
  descripcion VARCHAR(1000) NOT NULL,
  cantidad_colores DOUBLE NOT NULL,
  talla VARCHAR(100) NOT NULL,
  activo BOOLEAN NOT NULL,
  precio_promocion DOUBLE,
  ruta_imagen VARCHAR(1024) ,
  PRIMARY KEY (id_promociones)
) ENGINE=InnoDB DEFAULT CHARACTER SET=utf8mb4;


CREATE TABLE santory.puntos_de_venta (

  id_sucursal INT NOT NULL AUTO_INCREMENT,
  sucursal VARCHAR(100) NOT NULL,
  descripcion VARCHAR(255) NOT NULL,
  ubicacion VARCHAR(255) NOT NULL,
  horario VARCHAR(100) NOT NULL,
  activo BOOLEAN NOT NULL,
  ruta_imagen VARCHAR(1024),
  PRIMARY KEY (id_sucursal)

) ENGINE=InnoDB DEFAULT CHARACTER SET=utf8mb4;

/*create table santory.venta (
  id_venta INT NOT NULL AUTO_INCREMENT,
  id_factura INT NOT NULL,
  id_producto INT NOT NULL,
  precio double, 
  cantidad int,
  PRIMARY KEY (id_venta),
  foreign key fk_ventas_factura (id_factura) references factura(id_factura),
  foreign key fk_ventas_producto (id_producto) references producto(id_producto) 
)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4;*/



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

INSERT INTO santory.nueva_Coleccion (id_nuevacoleccion,precio, descripcion, cantidad_colores, talla, existencias, activo, ruta_imagen) 
VALUES  
('1', 33990.00 , 'Charol Negro y Corazones', 3, '30 a 37', '20', true, 'https://i.pinimg.com/474x/85/3b/fd/853bfd2812e4bc65e720274a06b60416.jpg'), 
('2', 35990.00, 'Tacón Hermoso con tanalidad beige', 2, '30 a 37', '30',true, 'https://i.pinimg.com/474x/5b/53/bd/5b53bda16e19d5b92d99138eb908260d.jpg'), 
('3', 33990.00, 'Botines de Charol Negro Matte', 3, '30 a 37', '40', true, 'https://i.pinimg.com/474x/c0/3f/26/c03f26441989772c405672161ab13200.jpg'), 
('4', 32990.00, 'Tacones de Cuña', 1, '30 a 37', '50',true, 'https://i.pinimg.com/474x/c9/8f/30/c98f30518032ed074d5ce88a9b8772ec.jpg'), 
('5', 32990.00, 'Hermosas zapatos de plataforma', 1, '30 a 37', '70',true, 'https://i.pinimg.com/474x/79/26/b2/7926b2f61a99f878eaad4c8850242594.jpg'), 
('6', 33990.00, 'Sandalias de vestir Negras', 1, '30 a 37', '10',true, 'https://i.pinimg.com/474x/9e/1e/33/9e1e337944c960e3ee8d64d0177021a8.jpg');


/* Se insertan 6 registros en la tabla calzadoFemenino como ejemplo */

INSERT INTO santory.calzadoFemenino (id_calzadofemenino, precio, descripcion, cantidad_colores, talla, existencias, activo, ruta_imagen) VALUES 
('1', 32900.00 , 'Sandalia de Plataforma en tonos Plata', 2, '30 a 37', '50', true, 'https://i.pinimg.com/474x/ff/43/59/ff4359e1021578d69e80857f643d0af7.jpg'),
('2', 33990.00, 'Zapatos con tonalidad Café', 1, '30 a 37', '35',true, 'https://i.pinimg.com/474x/e4/99/19/e49919081534b78cfe5c4f302de8469e.jpg'),
('3', 34990.00, 'Tacones con tonalidad vino', 1, '30 a 37', '25',true, 'https://i.pinimg.com/474x/5c/7a/63/5c7a63cdc1de38fb42842c0b25f75657.jpg'),
('4', 38990.00, 'Alpargatas con elastico  azules', 1, '30 a 37', '60',true, 'https://i.pinimg.com/474x/03/ff/fc/03fffc4700cabd130a3e9cb00488a6e3.jpg'),
('5', 33990.00, 'Sandalias de verano', 1, '30 a 37', '35',true, 'https://i.pinimg.com/474x/c9/97/a2/c997a2bb22c77409e07247c2139cff6e.jpg'),
('6', 32990.00, 'Tacones Cafes Transparente ', 1, '30 a 37', '20',true, 'https://i.pinimg.com/474x/d1/72/04/d172042ea3db1738513ac3b58672a595.jpg');


/* Se insertan 6 registros en la tabla promociones como ejemplo */

INSERT INTO santory.promociones (id_promociones, precio, descripcion, cantidad_colores, talla, activo, precio_promocion, ruta_imagen) VALUES 

('1', 32990.00 , 'Tenis blancas con Corazón', 1, '30 a 37', true, 29990.00, 'https://i.pinimg.com/474x/7e/d7/8c/7ed78c759a9d21e3cc9b054acc9dbdf0.jpg'),
('2', 35990.00, 'Tenis básicos subtonio rosa', 1, '30 a 37', true, 32990.00, 'https://i.pinimg.com/474x/39/e6/97/39e6979e9d88d6b60f11a45b50c12d65.jpg'),
('3', 33990.00, 'Zapatos de Charol Negro brillos', 2, '30 a 37', true, 30990.00, 'https://i.pinimg.com/474x/66/9f/0b/669f0bbf0b0ff810f0b0012c8c1fc4d5.jpg'),
('4', 35990.00, 'Tenis de plataforma con brillos', 1, '30 a 37', true, 30990.00, 'https://i.pinimg.com/474x/42/e5/57/42e557d6e3c4f938e9237db6157b5254.jpg'),
('5', 32990.00, 'Botines de Charol negro', 1, '30 a 37', true, 29990.00, 'https://i.pinimg.com/474x/59/bc/0c/59bc0c59e1579818fa76ca026c893a16.jpg'),
('6', 32990.00, 'Zapatos cafes', 1, '30 a 37', true, 29990.00, 'https://i.pinimg.com/474x/d5/59/bc/d559bcf266447046a4e2bd2097e6c1e4.jpg');



/* Se insertan 6 registros en la tabla Puntosde venta como ejemplo */

INSERT INTO santory.puntos_de_venta (id_sucursal, sucursal, descripcion, ubicacion, horario, activo, ruta_imagen) VALUES 
('1', 'Heredia' , 'Santory posee 2 sucursales, ven a la más cercana y disfruta de un buen calzado', 'Plaza SanFancisco, Heredia, Santa Cecilia', 'Lunes a Sábado: 10:30a.m - 7:30p.m y Domingo: 10:30a.m - 6p.m', true, 'https://i.pinimg.com/474x/e6/49/3f/e6493f0ae4c79142456fdf5ea39d9bdc.jpg'),
('2', 'San José' , 'Santory posee 2 sucursales, ven a la más cercana y disfruta de un buen calzado', 'Centro Comercial Plaza América, San José, Hatillo Centro', 'Lunes a Sábado: 10:30a.m - 7:30p.m y Domingo: 10:30a.m - 6p.m', true, 'https://i.pinimg.com/474x/04/95/c9/0495c90cb078afa3b37292ec866c3c95.jpg');



/* Se inserta un registro en la tabla carrusel como ejemplo */

INSERT INTO santory.carrusel (ruta_imagen) VALUES 
('https://scontent.fsjo14-1.fna.fbcdn.net/v/t39.30808-6/305923989_3246290435638547_6050255729709782789_n.png?_nc_cat=108&ccb=1-7&_nc_sid=5f2048&_nc_ohc=DCYnxjVqsvsAX95DdI3&_nc_ht=scontent.fsjo14-1.fna&oh=00_AfAwj6R0ZGUHzxHLeiS6mDLhIXEcpSr-GNpvbkZfDH7D0g&oe=660FE063'),
('https://scontent.fsjo14-1.fna.fbcdn.net/v/t39.30808-6/295268925_3209634789304112_7376739896725703594_n.jpg?_nc_cat=110&ccb=1-7&_nc_sid=5f2048&_nc_ohc=AekL3F0mEFoAX8dFloe&_nc_ht=scontent.fsjo14-1.fna&oh=00_AfC_0M42DS7f2Tb0C-X8MaA2qej7ahgzJpFk2RuHjQWqAQ&oe=660FDD9C');


/*Se crea la tabla de clientes llamada cliente... igual que la clase Cliente */
CREATE TABLE santory.usuario (
  id_usuario INT NOT NULL AUTO_INCREMENT,
  username varchar(20) NOT NULL,
  password varchar(512) NOT NULL,
  nombre VARCHAR(20) NOT NULL,
  apellidos VARCHAR(30) NOT NULL,
  correo VARCHAR(25) NULL,
  telefono VARCHAR(15) NULL,
  ruta_imagen varchar(1024),
  activo boolean,
  PRIMARY KEY (id_usuario))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4;

create table santory.factura (
  id_factura INT NOT NULL AUTO_INCREMENT,
  id_usuario INT NOT NULL,
  fecha date,  
  total double,
  estado int,
  PRIMARY KEY (id_factura),
  foreign key fk_factura_usuario (id_usuario) references usuario(id_usuario)  
)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4;

create table santory.venta (
  id_venta INT NOT NULL AUTO_INCREMENT,
  id_factura INT NOT NULL,
  id_nuevacoleccion INT NOT NULL,
  precio double, 
  cantidad int,
  PRIMARY KEY (id_venta),
  foreign key fk_ventas_factura (id_factura) references factura(id_factura),
  foreign key fk_ventas_nueva_Coleccion (id_nuevacoleccion) references nueva_Coleccion(id_nuevacoleccion) 
)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4;

/*Se insertan 3 registros en la tabla cliente como ejemplo */
INSERT INTO santory.usuario (id_usuario, username,password,nombre, apellidos, correo, telefono,ruta_imagen,activo) VALUES 
(1,'juan','$2a$10$P1.w58XvnaYQUQgZUCk4aO/RTRl8EValluCqB3S2VMLTbRt.tlre.','Juan', 'Castro Mora',    'jcastro@gmail.com',    '4556-8978', 'https://upload.wikimedia.org/wikipedia/commons/thumb/2/2a/Juan_Diego_Madrigal.jpg/250px-Juan_Diego_Madrigal.jpg',true),
(2,'rebeca','$2a$10$GkEj.ZzmQa/aEfDmtLIh3udIH5fMphx/35d0EYeqZL5uzgCJ0lQRi','Rebeca',  'Contreras Mora', 'acontreras@gmail.com', '5456-8789','https://upload.wikimedia.org/wikipedia/commons/0/06/Photo_of_Rebeca_Arthur.jpg',true),
(3,'pedro','rol$2a$10$koGR7eS22Pv5KdaVJKDcge04ZB53iMiw76.UjHPY.XyVYlYqXnPbO','Pedro', 'Mena Loria',     'lmena@gmail.com',      '7898-8936','https://upload.wikimedia.org/wikipedia/commons/thumb/f/fd/Eduardo_de_Pedro_2019.jpg/480px-Eduardo_de_Pedro_2019.jpg?20200109230854',true);

/Se crean 6 facturas */   /'Activa','Pagada','Anulada')*/
INSERT INTO santory.factura (id_factura,id_usuario,fecha,total,estado) VALUES
(1,1,'2022-01-05',33990,2),
(2,2,'2022-01-07',35990,2),
(3,3,'2022-01-07',33990,2),
(4,1,'2022-01-15',32990,1),
(5,2,'2022-01-17',32990,1),
(6,3,'2022-01-21',33990,1);

INSERT INTO santory.venta (id_venta,id_factura,id_nuevacoleccion,precio,cantidad) values
(1,1,1,33990,3),
(2,1,2,35990,2),
(3,1,3,33990,3),
(4,2,4,32990,1),
(5,2,5,32990,1),
(6,2,6,33990,1)
;

create table santory.rol (
  id_rol INT NOT NULL AUTO_INCREMENT,
  nombre varchar(20),
  id_usuario int,
  PRIMARY KEY (id_rol),
  foreign key fk_rol_usuario (id_usuario) references usuario(id_usuario)
)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4;

insert into santory.rol (id_rol, nombre, id_usuario) values
 (1,'ROLE_ADMIN',1),
 (2,'ROLE_VENDEDOR',2),
 (3,'ROLE_USER',3);