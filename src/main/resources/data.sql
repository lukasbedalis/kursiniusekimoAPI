-- Studentai
INSERT INTO student (vardas, pavarde, email) VALUES ('Jonas', 'Jonaitis', 'jonas@example.com');
INSERT INTO student (vardas, pavarde, email) VALUES ('Asta', 'Astaitytė', 'asta@example.com');

-- Moduliai (student_id pagal eilės tvarką bus 1 ir 2)
INSERT INTO module (pavadinimas, aprasymas, student_id) VALUES ('Matematika', 'Algebriniai skaičiavimai', 1);
INSERT INTO module (pavadinimas, aprasymas, student_id) VALUES ('Fizika', 'Mechanika ir optika', 2);

-- Užduotys (assignment)
INSERT INTO assignment (pavadinimas, busena, pazymys, module_id) VALUES ('1 kontrolinis', 'ATLIKTA', 9, 1);
INSERT INTO assignment (pavadinimas, busena, pazymys, module_id) VALUES ('Laboratorinis darbas', 'NEATLIKTA', null, 2);
