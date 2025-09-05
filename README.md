#  Veterinaria App (Android + MySQL Workbench)

Aplicación Android nativa para la **gestión de mascotas en una veterinaria**, conectada directamente a una base de datos **MySQL** alojada en MySQL Workbench (local o remoto).  
A diferencia de un CRUD típico en Android con SQLite y DBHelper, esta app utiliza **JDBC + MySQL Connector** para trabajar directamente con la base de datos remota o en red local.  

---

##  Características

-  **Registro de mascotas** → Inserta datos en la base de datos MySQL.  
-  **Listado de mascotas** → Muestra todos los registros en un `ListView`.  
-  **Búsqueda por ID** → Encuentra una mascota ingresando su identificador.  
-  **Edición** → Actualiza los datos de una mascota ya registrada.  
-  **Eliminación** → Borra registros con confirmación.  

---

##  Tecnologías utilizadas

- **Android Studio (Java)**  
- **MySQL Workbench** (base de datos remota/local)  
- **JDBC MySQL Connector** (`mysql-connector-java-x.x.x.jar`)  
- **Java SQL API** (`Connection`, `Statement`, `ResultSet`)  

---

##  Estructura de la base de datos

Ejecutar en MySQL Workbench:

```sql
CREATE DATABASE Webveterinaria;
USE Webveterinaria;

CREATE TABLE veterinaria(
Id int auto_increment primary key,
Nombre	varchar(40) not null,
Tipo	enum("perro", "gato"),	
Raza	varchar(40) not null,	
Color 	varchar(40) not null,
Peso	decimal(2),
Genero	enum("macho","hembra")
)ENGINE = INNODB;

insert into veterinaria (Id, Nombre, Tipo, Raza, Color , Peso, Genero) values("1","cucho","perro","golden retriver","mostaza","30","macho");
insert into veterinaria (Id, Nombre, Tipo, Raza, Color , Peso, Genero) values("2","lili","gato","australian","blanco","6","hembra");

select * from veterinaria;

