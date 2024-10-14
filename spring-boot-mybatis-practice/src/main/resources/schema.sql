create database spring default character set utf8 default collate utf8_general_ci;
 use spring;
 -- users 테이블 생성
 create table boards (
                       id int auto_increment primary key,
                       title varchar(50) not null,
                       content varchar(100) not null,
                       writer varchar(10) not null,
                       registered timestamp default current_timestamp
);
 -- 더미 데이터 삽입
 insert into boards (title, content, writer) values
	("사탕", "커피 사탕이 많아요.", "동그라미"),
    ("과자", "감자 과자 맛있어.", "세모"),
    ("붕어빵", "팥 먹을래 슈크림 먹을래", "네모");

 select * from boards;