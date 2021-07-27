INSERT INTO STUDENT(ID, NAME, SURNAME, MAIL) VALUES
(1,'MARTINA', 'MALLOZZI', 'martina.mallozzi@mail.com'),
(2,'FEDERICA','PIERDOMENICO', 'federica.pierdomenico@mail.com'),
(3,'ANTONELLA', 'TOMERI','antonella.tomeri@mail.com'),
(4, 'YARI', 'ABBONDANZA', 'yari.abbondanza@mail.com'),
(5, 'GIANNI', 'COLAMATTEO', 'gianni.colamatteo@mail.com'),
(6, 'MARTA', 'COSTANZO', 'marta.costanzo@mail.com'),
(7, 'ALESSANDRA', 'DEL DUCA', 'alessandra.delduca@mail.com'),
(8, 'EMANUELE', 'DI ZAZZO', 'emanuele.dizazzo@mail.com'),
(9, 'NICHOLAS', 'VENDITELLI', 'nicholas.venditelli@mail.com'),
(10, 'MATTEO', 'CASALUCE', 'matteo.casaluce@mail.com');

INSERT INTO COURSE (ID, NAME, DESCRIPTION, CFU) VALUES
(1, 'FISICA', 'Corso di Fisica Generale', 12),
(2,'ANALISI MATEMATICA 1','Corso di Matematica 1', 12),
(3, 'BASI DI DATI', 'Corso di database e SQL', 6),
(4, 'LETTERATURA ITALIANA 1', 'Corso di letteratura', 9),
(5, 'FILOLOGIA ROMANZA' , 'Corso di filologia', 6),
(6, 'ECONOMIA ED ORGANIZZAZIONE AZIENDALE', 'Corso di economia base', 6);

INSERT INTO STUDENT_COURSE(STUDENT_ID, COURSE_ID) VALUES
(1,4), (1,5), 
(2,1),(2,2),(2,3),
(3,4),(3,5),
(4,1),(4,2),(4,3),
(5,6),
(6,1),(6,2),(6,3),(6,6),
(7,6),(7,2),
(8,1),
(9,4),(9,5),
(10,5);
