-- Clear all tables first (in correct order due to foreign key constraints)
DELETE FROM presidency;
DELETE FROM membership;
DELETE FROM organization;
DELETE FROM person;

-- Reset sequences
ALTER SEQUENCE person_id_seq RESTART WITH 1;
ALTER SEQUENCE organization_id_seq RESTART WITH 1;

-- Insert Persons
INSERT INTO person (name, major, dept, date_of_birth, phone, email)
VALUES
('John Doe', 'Computer Science', 'Engineering', '1990-01-01', '123-456-7890', 'john.doe@example.com'),
('Jane Smith', 'Physics', 'Science', '1992-05-15', '098-765-4321', 'jane.smith@example.com'),
('Bob Johnson', 'Mathematics', 'Science', '1988-08-22', '555-123-4567', 'bob.johnson@example.com'),
('Alice Brown', 'Literature', 'Arts', '1995-03-30', '777-888-9999', 'alice.brown@example.com'),
('Charlie Wilson', 'Chemistry', 'Science', '1991-07-12', '444-555-6666', 'charlie.wilson@example.com'),
('Diana Miller', 'Art History', 'Arts', '1993-11-25', '222-333-4444', 'diana.miller@example.com');

-- Insert Organizations (using exact enum values)
INSERT INTO organization (name, category, established_date)
VALUES
('Chess Club', 'Arts', '2010-01-01'),
('Swimming Team', 'Sports', '2015-06-15'),
('Book Club', 'Literature', '2018-03-10'),
('Yoga Group', 'Fitness', '2019-09-20'),
('Literature Society', 'Literature', '2017-02-28'),
('Drama Club', 'Arts', '2016-08-15');

-- Insert Memberships
INSERT INTO membership (person_id, organization_id)
VALUES
-- John Doe's memberships
(1, 1),  -- Chess Club
(1, 2),  -- Swimming Team
(1, 5),  -- Science Society

-- Jane Smith's memberships
(2, 2),  -- Swimming Team
(2, 5),  -- Science Society

-- Bob Johnson's memberships
(3, 1),  -- Chess Club
(3, 3),  -- Book Club
(3, 5),  -- Science Society

-- Alice Brown's memberships
(4, 3),  -- Book Club
(4, 4),  -- Yoga Group
(4, 6),  -- Drama Club

-- Charlie Wilson's memberships
(5, 2),  -- Swimming Team
(5, 5),  -- Science Society

-- Diana Miller's memberships
(6, 4),  -- Yoga Group
(6, 6);  -- Drama Club

-- Insert Presidencies
INSERT INTO presidency (person_id, organization_id)
VALUES
(1, 1),  -- John Doe leads Chess Club
(2, 2),  -- Jane Smith leads Swimming Team
(3, 3),  -- Bob Johnson leads Book Club
(4, 4),  -- Alice Brown leads Yoga Group
(5, 5),  -- Charlie Wilson leads Science Society
(6, 6);  -- Diana Miller leads Drama Club