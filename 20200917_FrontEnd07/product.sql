use ssafyproduct;

create table book(
	id char(12) not null,
	name varchar(100) not null,
	price int(6) ,
	description varchar(4000),
	primary key(id)
);
INSERT INTO product VALUES('1000','삼성전자 시리즈Q','1768420','QHD 스마트 TV');
INSERT INTO product VALUES('2000','LG전자 디오스','1821590','양문형 냉장고');
INSERT INTO product VALUES('3000','삼성전자 비스포크','1704750','양문형 냉장고');
         
select * from product;