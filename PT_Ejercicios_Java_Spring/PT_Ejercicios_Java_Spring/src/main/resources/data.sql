DROP TABLE IF EXISTS student;
DROP TABLE IF EXISTS course;
 
CREATE TABLE student (
  id INT IDENTITY NOT NULL PRIMARY KEY,
  rut VARCHAR(60),
  name VARCHAR(60),
  last_name VARCHAR(60),
  age INTEGER(2),
  course VARCHAR(60)
);

CREATE TABLE course (
  id INT IDENTITY NOT NULL PRIMARY KEY,
  name VARCHAR(60),
  code VARCHAR(60)
);
 
insert into student (id,rut,name,last_name,age,course)values(1,'26938034-9','Nombre1','ApellidoNombre1',35,'curso1');
insert into student (id,rut,name,last_name,age,course)values(2,'25638034-9','Nombre2','ApellidoNombre2',17,'curso2');
insert into student (id,rut,name,last_name,age,course)values(3,'21438034-9','Nombre3','ApellidoNombre3',29,'curso3');
insert into student (id,rut,name,last_name,age,course)values(4,'20861034-9','Nombre4','ApellidoNombre4',30,'curso4');

insert into course (id,name,code)values(1,'curso1', '123');
insert into course (id,name,code)values(2,'curso2', '678');
insert into course (id,name,code)values(3,'curso3', '149');
insert into course (id,name,code)values(4,'curso4', '864');