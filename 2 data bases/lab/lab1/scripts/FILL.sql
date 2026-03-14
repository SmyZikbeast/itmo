-- 1. Локации
INSERT INTO LOCATION (NAME, IS_NEAR_RIVER) VALUES 
('Пойма реки', TRUE),
('Холм у реки', TRUE),
('Центральный парк', FALSE),
('База', FALSE);

-- 2. Люди
INSERT INTO PEOPLE (ID, NAME, GENDER, IS_HAPPY) VALUES 
(1, 'Иван', 'М', TRUE),
(2, 'Малдун', 'М', TRUE),
(3, 'Даниил', 'М', TRUE),
(4, 'Федор', 'М', TRUE);


-- 3. Работники
INSERT INTO WORKER (ID, FUNCTION, PERSON_ID) VALUES 
(1, 'Озеленитель', 1), -- Иван
(2, 'Рабочий', 2), -- Малдун
(3, 'Рабочий', 3), -- Даниил
(4, 'Рабочий', 4); -- Федор

-- 4. Объект работ
INSERT INTO WORK_OBJECT (NAME) VALUES 
('Деревце у реки'),
('Металлические крепления'),
('Метка 1'),
('Подпорка'),
('Метка 2'),
('Метка 3'),
('Метка 4'),
('Метка 5'),
('Забор'),
('Метка 6');

-- 5. Метка 
INSERT INTO MARKER (COLOR, PURPOSE, PLACED_BY_ID, OBJECT_ID, WORK_OBJECT_ID) VALUES 
('ЗЕЛЕНЫЙ', 'нужна подпорка', 2, 1, 3), -- МАЛДУН, ДЕРЕВЦЕ У РЕКИ, МЕТКА 1
('КРАСНЫЙ', 'нужна помощь', 2, 2, 5),
('ЗЕЛЕНЫЙ', 'нужна подмога', 2, 4, 6),
('КРАСНЫЙ', 'нужна поддержка', 2, 1, 7),
('ЗЕЛЕНЫЙ', 'нужен полив', 2, 1, 8),
('КРАСНЫЙ', 'нужен пропол', 2, 4, 10);

-- 6. Работа 
INSERT INTO WORK (ACTION, LENGTH, WORKER_ID, OBJECT_ID, LOCATION_ID, MARKER_ID) VALUES 
  ('выпрямить', 
 5,                -- минут
 2,                -- исполнитель Малдун (WORKER.ID)
 1,                -- объект (WORK_OBJECT.ID)
 1,				   -- локация
 NULL),
  ('убрать', 
 10,               -- минут
 2,                -- исполнитель Малдун (WORKER.ID)
 2,                -- объект (WORK_OBJECT.ID)
 3,
 NULL),
  ('поставить', 
 5,                -- минут
 2,                -- исполнитель Малдун (WORKER.ID)
 3,                -- объект (WORK_OBJECT.ID)
 1,
 NULL),            
  ('установить', 
 5,                -- минут
 1,                -- исполнитель Иван (WORKER.ID)
 4,                -- объект (WORK_OBJECT.ID)
 1,
 1),			   -- метка (MARKER.ID)
  ('поставить', 
 5,                -- минут
 3,                -- исполнитель Даниил (WORKER.ID)
 5,                -- объект (WORK_OBJECT.ID)
 1,
 NULL), 
  ('убрать', 
 5,                -- минут
 3,                -- исполнитель Даниил (WORKER.ID)
 6,                -- объект (WORK_OBJECT.ID)
 4,
 NULL), 
  ('поставить', 
 5,                -- минут
 4,                -- исполнитель Федор (WORKER.ID)
 7,                -- объект (WORK_OBJECT.ID)
 1,
 NULL), 
  ('поставить', 
 5,                -- минут
 4,                -- исполнитель Федор (WORKER.ID)
 8,                -- объект (WORK_OBJECT.ID)
 2,
 NULL), 
  ('поставить', 
 5,                -- минут
 3,                -- исполнитель Даниил (WORKER.ID)
 9,                -- объект (WORK_OBJECT.ID)
 1,
 NULL), 
  ('поставить', 
 5,                -- минут
 4,                -- исполнитель Федор (WORKER.ID)
 10,               -- объект (WORK_OBJECT.ID)
 1,
 NULL);             

-- 7. Динозавр 
INSERT INTO DINOSAURUS (TYPE, LOCATION_ID) VALUES 
('ДИЛОФОЗАВР', 1);   -- 1 = LOCATION.ID (Пойма реки)
