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
 
insert into student (id,rut,name,last_name,age,course)values(1,'20400628-8','student1','lastName1',35,'course1');
insert into student (id,rut,name,last_name,age,course)values(2,'23572857-5','student2','lastName2',40,'course2');
insert into student (id,rut,name,last_name,age,course)values(3,'10827616-9','student3','lastName3',29,'course3');
insert into student (id,rut,name,last_name,age,course)values(4,'12613201-8','student4','lastName4',30,'course4');

insert into course (id,name,code)values(1,'course1', '123');
insert into course (id,name,code)values(2,'course2', '678');
insert into course (id,name,code)values(3,'course3', '149');
insert into course (id,name,code)values(4,'course4', '864');

commit;