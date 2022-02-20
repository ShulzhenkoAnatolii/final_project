-- vaccination_center_table
insert into vaccination_center_table values (default,CURRENT_TIMESTAMP(),CURRENT_TIMESTAMP(), 'ТЦ "ACADEM City" вул. Академіка Палладіна, буд. 16');
insert into vaccination_center_table values (default,CURRENT_TIMESTAMP(),CURRENT_TIMESTAMP(), 'БМ "Агромат" вул. Академіка Булаховського, буд. 4');

-- users_table
insert into users_table values ('ADMIN', default, CURRENT_TIMESTAMP(),CURRENT_TIMESTAMP(), 'drobenko@gmail.com', 1, 'drobenko@gmail.com', 'ROLE_ADMIN',  null, null, null, null, null);
insert into users_table values ('DOCTOR', default, CURRENT_TIMESTAMP(),CURRENT_TIMESTAMP(), 'doc1@gmail.com', 1, 'doc1', 'ROLE_DOCTOR', 'David', 'Davidov', 'Davidovich', null, 1);
insert into users_table values ('DOCTOR', default, CURRENT_TIMESTAMP(),CURRENT_TIMESTAMP(), 'doc2@gmail.com', 1, 'doc2', 'ROLE_DOCTOR', 'David', 'Davidov', 'Davidovich', null, 2);
insert into users_table values ('PATIENT', default, CURRENT_TIMESTAMP(),CURRENT_TIMESTAMP(), 'pat1@gmail.com', 1, 'pat1', 'ROLE_PATIENT', 'David', 'Davidov', 'Davidovich', '1974-05-01', null);
insert into users_table values ('PATIENT', default, CURRENT_TIMESTAMP(),CURRENT_TIMESTAMP(), 'pat2@gmail.com', 1, 'pat2', 'ROLE_PATIENT', 'Bob', 'Bobov', 'Bobovich', '1974-05-01', null);

-- vaccine_table
insert into vaccine_table values (default,CURRENT_TIMESTAMP(),CURRENT_TIMESTAMP(), 'CoronaVac');
insert into vaccine_table values (default,CURRENT_TIMESTAMP(),CURRENT_TIMESTAMP(), 'Moderna');
insert into vaccine_table values (default,CURRENT_TIMESTAMP(),CURRENT_TIMESTAMP(), 'Johnson & Johnson');
insert into vaccine_table values (default,CURRENT_TIMESTAMP(),CURRENT_TIMESTAMP(), 'Pfizer_BioTech');
insert into vaccine_table values (default,CURRENT_TIMESTAMP(),CURRENT_TIMESTAMP(), 'AstroZeneca');

-- record_table
insert into records_table values (default,CURRENT_TIMESTAMP(),CURRENT_TIMESTAMP(), 1, 1, 1, 1);
insert into records_table values (default,CURRENT_TIMESTAMP(),CURRENT_TIMESTAMP(), 2, 2, 2, 2);

-- vaccination_center_vaccine
insert into vaccination_center_vaccine values (1, 1);
insert into vaccination_center_vaccine values (1, 2);
insert into vaccination_center_vaccine values (1, 4);
insert into vaccination_center_vaccine values (1, 5);
insert into vaccination_center_vaccine values (2, 1);
insert into vaccination_center_vaccine values (2, 2);