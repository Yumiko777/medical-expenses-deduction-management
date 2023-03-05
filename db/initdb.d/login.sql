CREATE SCHEMA login;

USE login;

CREATE TABLE users(
    username VARCHAR(255) NOT NULL PRIMARY KEY,
    password VARCHAR(255) NOT NULL,
    enabled BOOLEAN NOT NULL
);

CREATE TABLE authorities(
    username VARCHAR(255) NOT NULL,
    authority VARCHAR(255) NOT NULL,
    FOREIGN KEY(username) REFERENCES users (username)
);

CREATE TABLE medical_cost(
    id BIGINT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    date DATE,
    person NVARCHAR(255) NOT NULL,
    hospital NVARCHAR(255) NOT NULL,
    classification NVARCHAR(255),
    amount BIGINT NOT NULL,
    username VARCHAR(255) NOT NULL,
    FOREIGN KEY (username) REFERENCES users (username)
);
