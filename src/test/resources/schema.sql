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

INSERT INTO company(name, address) VALUES('삼성전자', '경기도 수원시 영통구 삼성로 129');
INSERT INTO company(name, address) VALUES('LG전자', '서울시 영등포구 여의대로 128 LG트윈타워');
INSERT INTO company(name, address) VALUES('신한카드', '서울시 중구 을지로 100');

INSERT INTO employee(name, address, company)VALUES ('홍길동', '경기도 수원시 영통구 삼성로 129', 1);
INSERT INTO employee(name, address, company)VALUES ('홍길순', '경기도 수원시 영통구 삼성로 129', 1);
INSERT INTO employee(name, address, company)VALUES ('홍길철', '서울시 영등포구 여의대로 128 LG트윈타워', 2);
INSERT INTO employee(name, address, company)VALUES ('홍길자', '서울시 영등포구 여의대로 128 LG트윈타워', 2);