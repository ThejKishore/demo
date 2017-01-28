INSERT INTO contact(`name`,`email`,`telephone`,`address`) VALUES ('Vamsy Raju','vamsyraju@gmail.com','+1469-500-3223','Texas , US');
INSERT INTO contact(`name`,`email`,`telephone`,`address`) VALUES ('Madhan Babu','madhan123@gmail.com','+1469-500-1455','Mumbai , India');
INSERT INTO contact(`name`,`email`,`telephone`,`address`) VALUES ('Rackesh chandran','racky@gmail.com','+1469-500-5634','Chennai , India');

insert into users(username,password,enabled) values('admin','admin',true);
insert into users(username,password,enabled) values('admin1','password',true);
insert into users(username,password,enabled) values('guest','guest',true);

insert into authorities(username,authority) values('admin','ADMIN');
insert into authorities(username,authority) values('admin1','USER');
insert into authorities(username,authority) values('admin1','ADMIN');
insert into authorities(username,authority) values('guest','USER');
