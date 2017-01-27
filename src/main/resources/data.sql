INSERT INTO contact(`name`,`email`,`telephone`,`address`) VALUES ('Thej','kishores1984@gmail.com','+1469-500-1061','800 S Wells Street,Apt 1114,Chicago,IL-60607');

insert into users(username,password,enabled) values('thej','kishore',true);
insert into users(username,password,enabled) values('shanaya','karuneegar',true);
insert into users(username,password,enabled) values('guest','guest',true);

insert into authorities(username,authority) values('thej','USER');
insert into authorities(username,authority) values('shanaya','ADMIN');
insert into authorities(username,authority) values('guest','USER');
