select * from change;

show tables;

select * from user;

INSERT INTO user (username, password)
VALUES ('abc1234', '12345');

UPDATE user
SET role = 'ROLE_ADMIN'
where id = 10;

select * from user;

select * from exchange;

update exchange
    set createdAt = '2024-08-05'
where id = 27
;

DELETE FROM exchange
    where id = 84;

TRUNCATE TABLE exchange;

select * from chathistory;

SELECT table_schema AS `Database`,
       SUM(data_length + index_length) / 1024 / 1024 AS `Size (MB)`
FROM information_schema.TABLES
GROUP BY table_schema;

SELECT table_schema AS `Database`,
       SUM(data_length + index_length) / 1024 / 1024 AS `Size (MB)`
FROM information_schema.TABLES
WHERE table_schema = 'exchange'
GROUP BY table_schema;

create user 'abc11'@'%'

select * from User;
select * from Exchange;
select * from ChatHistory;



show tables;




