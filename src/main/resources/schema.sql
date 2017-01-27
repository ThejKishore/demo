DROP TABLE if exists contact;
CREATE TABLE contact (
  id int(11) NOT NULL AUTO_INCREMENT,
  name varchar(30) DEFAULT NULL,
  email varchar(50) DEFAULT NULL,
  telephone varchar(15) DEFAULT NULL,
  address varchar(250) DEFAULT NULL,
  PRIMARY KEY (`id`)
);

drop table if exists users;
create table users(id bigint auto_increment, username varchar(255), password varchar(255), enabled boolean);
drop table if exists authorities;
create table authorities(username  varchar(255),authority  varchar(255), UNIQUE(username,authority));
