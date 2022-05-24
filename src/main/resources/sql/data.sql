-- vaccination_center_table
insert into vaccination_center_table values (default,CURRENT_TIMESTAMP(),CURRENT_TIMESTAMP(), 'ТЦ "ACADEM City" вул. Академіка Палладіна, буд. 16');
insert into vaccination_center_table values (default,CURRENT_TIMESTAMP(),CURRENT_TIMESTAMP(), 'БМ "Агромат" вул. Академіка Булаховського, буд. 4');
insert into vaccination_center_table values (default, CURRENT_TIMESTAMP(), CURRENT_TIMESTAMP(), 'ТЦ "ART Mall" вул. Академіка Заболотного, буд. 37');
insert into vaccination_center_table values (default, CURRENT_TIMESTAMP(), CURRENT_TIMESTAMP(), 'ТЦ "АЛАДДІН" вул. Михайла Гришка, буд. 3А');
insert into vaccination_center_table values (default, CURRENT_TIMESTAMP(), CURRENT_TIMESTAMP(), '"Optimum busines center" вул. Полтавський шлях, буд. 56');
insert into vaccination_center_table values (default, CURRENT_TIMESTAMP(), CURRENT_TIMESTAMP(), 'ТРЦ "Французький бульвар" вул. Академіка Павлова, буд. 44Б');
insert into vaccination_center_table values (default, CURRENT_TIMESTAMP(), CURRENT_TIMESTAMP(), 'ТРЦ "Nikolsky" вул. Пушкінська, буд. 2');
insert into vaccination_center_table values (default, CURRENT_TIMESTAMP(), CURRENT_TIMESTAMP(), 'ТРЦ "КАРАВАН" вул. Лугова, буд. 12');
insert into vaccination_center_table values (default,CURRENT_TIMESTAMP(),CURRENT_TIMESTAMP(), 'ТЦ "Мануфактура" вул. Академіка Палладіна, буд. 16');
insert into vaccination_center_table values (default,CURRENT_TIMESTAMP(),CURRENT_TIMESTAMP(), 'БМ "Березка" вул. Академіка Булаховського, буд. 4');
insert into vaccination_center_table values (default, CURRENT_TIMESTAMP(), CURRENT_TIMESTAMP(), 'ТЦ "Атриум" вул. Академіка Заболотного, буд. 37');
insert into vaccination_center_table values (default, CURRENT_TIMESTAMP(), CURRENT_TIMESTAMP(), 'ТЦ "Портал" вул. Михайла Гришка, буд. 3А');
insert into vaccination_center_table values (default, CURRENT_TIMESTAMP(), CURRENT_TIMESTAMP(), '"Oshean Plaza" вул. Полтавський шлях, буд. 56');
insert into vaccination_center_table values (default, CURRENT_TIMESTAMP(), CURRENT_TIMESTAMP(), 'ТРЦ "Романтика" вул. Академіка Павлова, буд. 44Б');
insert into vaccination_center_table values (default, CURRENT_TIMESTAMP(), CURRENT_TIMESTAMP(), 'ТРЦ "Барса" вул. Пушкінська, буд. 2');
insert into vaccination_center_table values (default, CURRENT_TIMESTAMP(), CURRENT_TIMESTAMP(), 'ТРЦ "Милан" вул. Лугова, буд. 12');

-- users_table
insert into users_table values ('ADMIN', default, CURRENT_TIMESTAMP(),CURRENT_TIMESTAMP(), 'drobenko@gmail.com', 1, 'drobenko@gmail.com', 'ROLE_ADMIN', 'Male',  null, null, null, null, null);
insert into users_table values ('DOCTOR', default, CURRENT_TIMESTAMP(),CURRENT_TIMESTAMP(), 'doc1@gmail.com', 1, 'doc1', 'ROLE_DOCTOR', 'Male', 'David', 'Davidov', 'Davidovich', null, 1);
insert into users_table values ('DOCTOR', default, CURRENT_TIMESTAMP(),CURRENT_TIMESTAMP(), 'doc2@gmail.com', 1, 'doc2', 'ROLE_DOCTOR', 'Male', 'David', 'Davidov', 'Davidovich', null, 2);
insert into users_table values ('PATIENT', default, CURRENT_TIMESTAMP(),CURRENT_TIMESTAMP(), 'pat1@gmail.com', 1, 'pat1', 'ROLE_PATIENT', 'Male', 'David', 'Davidov', 'Davidovich', '1974-05-01', null);
insert into users_table values ('PATIENT', default, CURRENT_TIMESTAMP(),CURRENT_TIMESTAMP(), 'pat2@gmail.com', 1, 'pat2', 'ROLE_PATIENT', 'Male', 'Bob', 'Bobov', 'Bobovich', '1974-05-01', null);

-- vaccine_table
insert into vaccine_table values (default,CURRENT_TIMESTAMP(),CURRENT_TIMESTAMP(), 0, 'CoronaVac');
insert into vaccine_table values (default,CURRENT_TIMESTAMP(),CURRENT_TIMESTAMP(), 0, 'Moderna');
insert into vaccine_table values (default,CURRENT_TIMESTAMP(),CURRENT_TIMESTAMP(), 0, 'Johnson & Johnson');
insert into vaccine_table values (default,CURRENT_TIMESTAMP(),CURRENT_TIMESTAMP(), 0, 'Pfizer_BioTech');
insert into vaccine_table values (default,CURRENT_TIMESTAMP(),CURRENT_TIMESTAMP(), 0, 'AstroZeneca');

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
insert into vaccination_center_vaccine values (3, 1);
insert into vaccination_center_vaccine values (3, 2);
insert into vaccination_center_vaccine values (4, 4);
insert into vaccination_center_vaccine values (4, 5);
insert into vaccination_center_vaccine values (4, 1);
insert into vaccination_center_vaccine values (5, 2);
insert into vaccination_center_vaccine values (5, 1);
insert into vaccination_center_vaccine values (6, 2);
insert into vaccination_center_vaccine values (6, 4);
insert into vaccination_center_vaccine values (6, 5);
insert into vaccination_center_vaccine values (7, 1);
insert into vaccination_center_vaccine values (7, 2);
insert into vaccination_center_vaccine values (8, 1);
insert into vaccination_center_vaccine values (8, 2);
insert into vaccination_center_vaccine values (8, 4);
insert into vaccination_center_vaccine values (9, 5);
insert into vaccination_center_vaccine values (10, 1);
insert into vaccination_center_vaccine values (11, 2);
insert into vaccination_center_vaccine values (12, 1);
insert into vaccination_center_vaccine values (13, 2);
insert into vaccination_center_vaccine values (13, 4);
insert into vaccination_center_vaccine values (13, 5);
insert into vaccination_center_vaccine values (14, 1);
insert into vaccination_center_vaccine values (15, 2);
insert into vaccination_center_vaccine values (15, 1);
insert into vaccination_center_vaccine values (15, 3);
insert into vaccination_center_vaccine values (15, 4);
insert into vaccination_center_vaccine values (16, 5);
insert into vaccination_center_vaccine values (16, 1);
insert into vaccination_center_vaccine values (16, 2);

-- coronavirus_statistics_t
--insert into covid_api_statistics_table values (1, '4832005', '19586', '4943428', '19748', '2022-02-20', '111423', '162', '0.0225', '2022-02-21 04:21:05', '0', '0');