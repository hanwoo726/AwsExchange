INSERT INTO user (id, password, role, username) VALUES
                                                    (1, '1234', 'user', '테스트');

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