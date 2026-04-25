CREATE TABLE people (
    id SERIAL PRIMARY KEY,
    name TEXT,
    gender TEXT,
    is_happy BOOLEAN
);

CREATE TABLE worker (
    id SERIAL PRIMARY KEY,
    person_id INT UNIQUE REFERENCES people(id)
);

CREATE TABLE location (
    id SERIAL PRIMARY KEY,
    name TEXT,
    is_near_river BOOLEAN
);

CREATE TABLE dinosaurs (
    id SERIAL PRIMARY KEY,
    location_id INT REFERENCES location(id),
    type TEXT
);

CREATE TABLE work_object (
    id SERIAL PRIMARY KEY,
    name TEXT
);

CREATE TABLE work (
    id SERIAL PRIMARY KEY,
    worker_id INT REFERENCES worker(id),
    location_id INT REFERENCES location(id),
    work_object_id INT REFERENCES work_object(id),
    action TEXT,
    length INT
);

CREATE TABLE marker (
    id SERIAL PRIMARY KEY,
    work_object_id INT REFERENCES work_object(id),
    purpose TEXT,
    color TEXT
);

CREATE TABLE work_marker (
    marker_id INT PRIMARY KEY REFERENCES marker(id),
    from_work_id INT REFERENCES work(id),
    to_work_id INT REFERENCES work(id)
);

CREATE OR REPLACE FUNCTION prevent_self_marker()
RETURNS trigger AS $$
BEGIN
    IF NEW.from_work_id = NEW.to_work_id THEN
        RAISE EXCEPTION 'Marker cannot link work to itself';
    END IF;
    RETURN NEW;
END;
$$ LANGUAGE plpgsql;

CREATE TRIGGER trg_prevent_self_marker
BEFORE INSERT OR UPDATE ON work_marker
FOR EACH ROW
EXECUTE FUNCTION prevent_self_marker();

INSERT INTO people (name, gender, is_happy) VALUES
('Ivan', 'M', true),
('Anna', 'F', false);

INSERT INTO worker (person_id) VALUES
(1),
(2);

INSERT INTO location (name, is_near_river) VALUES
('Forest', true),
('Village', false);

INSERT INTO dinosaurs (location_id, type) VALUES
(1, 'Rex'),
(2, 'Triceratops');

INSERT INTO work_object (name) VALUES
('Marker'),
('Hammer');

INSERT INTO work (worker_id, location_id, work_object_id, action, length) VALUES
(1, 1, 1, 'place', 10),
(2, 2, 2, 'build', 20);

INSERT INTO marker (work_object_id, purpose, color) VALUES
(1, 'navigation', 'red');

INSERT INTO work_marker (marker_id, from_work_id, to_work_id)
VALUES (1, 1, 2);