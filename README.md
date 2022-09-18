# OhMyCode_BackEnd
En este repositorio se encuentra el proyecto de BackEnd de la prueba técnica de OhMyCode realizada por José Daniel Conejos Jiménez.

Para ejecutar es necesario importar las dependencias de maven.

Se ha utilizado una base de datos **postgreSQL**. Será necesario crear una nueva tabla con el nombre de **OhMyCode** y alojarla en el puerto **5432** (puerto por defecto de postgreSQL).

Dentro de `src/main/resources/application.properties` habrá que indicar el usuario y contraseña de la base de datos, en los atributos de `spring.datasource.username` y `spring.datasource.password` respectivamente.

Una vez configurado el sistema, se tendrá que ejecutar para crear las tablas de la base de datos. Estas tablas estarán vacías. Se ha creado un pequeño juego de pruebas para poder demostrar el funcionamiento del servidor. Para incorporar estos datos en la base de datos, se tendrá que ejecutar las siguientes sentencias directamente en la base de datos:

````
insert into address values(1, 'barcelona', 'españa', 'ramblas', '11111');
insert into address values(2, 'madrid', 'españa', 'gran via', '22222');

insert into user_entity values(1, 'paco', '$2a$10$uH86u9t04N88yt9fkjPdJeZpUivwvaD8Ptd6iGR5j2c7q6Iz3Zy2i', 'user1', 1);
insert into user_entity values(2, 'andres', '$2a$10$uH86u9t04N88yt9fkjPdJeZpUivwvaD8Ptd6iGR5j2c7q6Iz3Zy2i', 'user2', 2);
insert into user_entity values(3, 'vicenta', '$2a$10$uH86u9t04N88yt9fkjPdJeZpUivwvaD8Ptd6iGR5j2c7q6Iz3Zy2i', 'user3', 1);
insert into user_entity values(4, 'marisa', '$2a$10$uH86u9t04N88yt9fkjPdJeZpUivwvaD8Ptd6iGR5j2c7q6Iz3Zy2i', 'user4', 2);

insert into todos values(11, true, 'todo1', 1);
insert into todos values(12, false, 'todo2', 1);
insert into todos values(13, true, 'todo3', 2);
insert into todos values(14, false, 'todo4', 2);
insert into todos values(15, true, 'todo5', 3);
insert into todos values(16, false, 'todo6', 3);
insert into todos values(17, true, 'todo7', 4);
````

Los usuarios de este juego de pruebas se han creado con username: 'user1' - 'user4', todos con la contraseña: 'admin'. Para hacer el login habrá que ingresar el *username*, no el nombre.

Se han implementado todos las funcionalidades indicadas por el documento, incluyendo las funcionalidades bonus.
