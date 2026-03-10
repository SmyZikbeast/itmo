-- 1. Локации
INSERT INTO LOCATION (NAME, IS_NEAR_RIVER) VALUES 
('Пойма реки', TRUE),
('Центральный парк', FALSE);

-- 2. Люди
INSERT INTO PEOPLE (NAME, GENDER, IS_HAPPY) VALUES 
('Иван', 'М', TRUE),
('Пётр', 'М', TRUE)
RETURNING ID, NAME;

-- 3. Работники
INSERT INTO WORKER (FUNCTION, PERSON_ID) VALUES 
('Озеленитель', 1), -- Иван
('Рабочий', 2); -- Пётр

-- 4. Объект работ
INSERT INTO WORK_OBJECT (NAME) VALUES 
('Деревце у реки'),
('Металлические крепления'),
('Метка');

-- 5. Метка 
INSERT INTO MARKER (COLOR, PURPOSE, PLACED_BY_ID, OBJECT_ID) VALUES 
('ЗЕЛЕНЫЙ', 'нужна подпорка', 2, 1);   -- 2 = Пётр (WORKER.ID), 1 = WORK_OBJECT.ID

-- 6. Работа 
INSERT INTO WORK (ACTION, LENGTH, SUBJECT_ID, OBJECT_ID, MARKER_ID) VALUES 
('выпрямить', 
 5,                -- минут
 2,                -- исполнитель Пётр (WORKER.ID)
 1,                -- объект (WORK_OBJECT.ID)
 NULL),
 ('убрать', 
 10,               -- минут
 2,                -- исполнитель Пётр (WORKER.ID)
 2,                -- объект (WORK_OBJECT.ID)
 NULL),
 ('поставить', 
 5,                -- минут
 2,                -- исполнитель Пётр (WORKER.ID)
 3,                -- объект (WORK_OBJECT.ID)
 1);               -- метка (MARKER.ID)

-- 7. Динозавр (в опасной зоне)
INSERT INTO DINOSAURUS (TYPE, LOCATION_ID) VALUES 
('ДИЛОФОЗАВР', 1);   -- 1 = LOCATION.ID (Пойма реки)