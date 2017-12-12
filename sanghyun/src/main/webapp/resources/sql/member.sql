CREATE TABLE member (
	id      VARCHAR(20)  NOT NULL,
	passwd  VARCHAR(15)  NOT NULL,
	name    VARCHAR(20)  NOT NULL,
	email   VARCHAR(50)  NOT NULL,
	tel     VARCHAR(13)  NOT NULL,
	regDate DATETIME     NOT NULL
);

select *
from member

 INSERT INTO member (id, passwd, name, email,tel, regDate)
 VALUES ('qudwls92', '12341234', 'parksang', 'ghkdqudwls92@naver.com', '01059233534' ,now());	
 
delete from member