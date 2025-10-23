
CREATE TABLE chathistory (
                             id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
                             message VARCHAR(255) NOT NULL,
                             timestamp DATETIME NOT NULL,
                             username VARCHAR(255) NOT NULL
);

CREATE TABLE exchange (
                          id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
                          data VARCHAR(255),
                          max VARCHAR(255),
                          min VARCHAR(255),
                          name VARCHAR(255),
                          createdAt DATE,
                          curName VARCHAR(255)
);

CREATE TABLE user (
                      id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
                      createdAt TEXT,
                      name VARCHAR(255),
                      password VARCHAR(255),
                      username VARCHAR(255),
                      year TEXT,
                      role VARCHAR(255)
);

INSERT INTO user (id, name, password, username, year, role) VALUES
                                                                           (2, 'admin', '1313', '관리자', '990726', 'ROLE_ADMIN');

insert into chathistory (id, message, timestamp, username) VALUES
                                                               (1,'테스트',now(),'테스트용')


INSERT INTO exchange (data, max, min, name, createdAt, curName)
VALUES ('1419', '1433.69', '1405.3', 'USD', '2025-10-17', '미국 달러');
INSERT INTO exchange (data, max, min, name, createdAt, curName)
VALUES ('940', '950.06', '931.25', 'JPY', '2025-10-17', '일본 옌');
INSERT INTO exchange (data, max, min, name, createdAt, curName)
VALUES ('1654', '1671.11', '1638.02', 'EUR', '2025-10-17', '유로');

UPDATE exchange
SET createdAt = '2025-10-20'
WHERE data = '1419';

select * from exchange;

INSERT INTO exchange (data, max, min, name, createdAt, curName)
VALUES
    ('1658', '1675.51', '1642.34', '유로',      '2025-10-16', 'EUR'),
    ('943',  '953.02',  '934.15',  '일본 엔',   '2025-10-16', 'JPY'),
    ('1424', '1438.64', '1410.15', '미국 달러', '2025-10-16', 'USD');

INSERT INTO exchange (data, max, min, name, createdAt, curName)
VALUES
    ('1657', '1674.09', '1640.94', '유로',      '2025-10-15', 'EUR'),
    ('940',  '950.28',  '931.47',  '일본 엔',   '2025-10-15', 'JPY'),
    ('1428', '1442.68', '1414.11', '미국 달러', '2025-10-15', 'USD');

select * from exchange;

UPDATE exchange SET
                    exchange.curName = 'eur'
where exchange.curName = '유로';