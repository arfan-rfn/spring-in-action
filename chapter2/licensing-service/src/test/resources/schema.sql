-- Drop tables if they exist
DROP TABLE IF EXISTS presidency;
DROP TABLE IF EXISTS membership;
DROP TABLE IF EXISTS organization;
DROP TABLE IF EXISTS person;

-- Create Person table
CREATE TABLE person (
    id SERIAL PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    major VARCHAR(255),
    dept VARCHAR(255),
    date_of_birth DATE,
    phone VARCHAR(255),
    email VARCHAR(255) UNIQUE
);

-- Create Organization table
CREATE TABLE organization (
    id SERIAL PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    category VARCHAR(50) NOT NULL,
    established_date DATE
);

-- Create Membership table
CREATE TABLE membership (
    person_id BIGINT,
    organization_id BIGINT,
    PRIMARY KEY (person_id, organization_id),
    FOREIGN KEY (person_id) REFERENCES person(id),
    FOREIGN KEY (organization_id) REFERENCES organization(id)
);

-- Create Presidency table
CREATE TABLE presidency (
    person_id BIGINT,
    organization_id BIGINT,
    PRIMARY KEY (person_id, organization_id),
    FOREIGN KEY (person_id) REFERENCES person(id),
    FOREIGN KEY (organization_id) REFERENCES organization(id)
);