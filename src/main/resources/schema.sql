DROP TABLE IF EXISTS employee;
DROP TABLE IF EXISTS company;

CREATE TABLE company (
    id int AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(128) NOT NULL,
    address VARCHAR(256)
);

CREATE TABLE employee (
    id int AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(128) NOT NULL,
    address VARCHAR(256),
    company int,
    FOREIGN KEY(company) REFERENCES company(id)
);