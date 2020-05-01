/*insert role*/
insert into role(code,name) values('ADMIN','Quan tri');
insert into role(code,name) values('USER','Nguoi dung');

/*insert user*/
insert into user(username,password,email,address,phone)
values('admin','$2a$10$/RUbuT9KIqk6f8enaTQiLOXzhnUkiwEJRdtzdrMXXwU7dgnLKTCYG','admin@gmail.com','Ha Phong','09342433');
insert into user(username,password,email,address,phone)
values('nguyenvana','$2a$10$/RUbuT9KIqk6f8enaTQiLOXzhnUkiwEJRdtzdrMXXwU7dgnLKTCYG','vana@gmail.com','Ha Noi','09424234');
insert into user(username,password,email,address,phone)
values('nguyenvanb','$2a$10$/RUbuT9KIqk6f8enaTQiLOXzhnUkiwEJRdtzdrMXXwU7dgnLKTCYG','vanb@gmail.com','HCM','09424244');

INSERT INTO user_role(userid,roleid) VALUES (1,1);
INSERT INTO user_role(userid,roleid) VALUES (2,2);
INSERT INTO user_role(userid,roleid) VALUES (3,2);

/*insert book*/
insert into book(discount,img,price,shortdescription,title) 
values(50,'template/web/img/b1.jpg',200,'This is a book','The Hare with Amber Eyes');
insert into book(discount,img,price,shortdescription,title) 
values(50,'template/web/img/b2.jpg',100,'This is a book','Ther war of art');
insert into book(discount,img,price,shortdescription,title) 
values(50,'template/web/img/b3.jpg',200,'This is a book','Can love happen twice');
insert into book(discount,img,price,shortdescription,title) 
values(50,'template/web/img/b4.jpg',100,'This is a book','The Immortals of Meluha');
insert into book(discount,img,price,shortdescription,title) 
values(50,'template/web/img/b5.jpg',200,'This is a book','Life is what you make it');
insert into book(discount,img,price,shortdescription,title) 
values(50,'template/web/img/b6.jpg',200,'This is a book','Calico Joe');
insert into book(discount,img,price,shortdescription,title) 
values(50,'template/web/img/b7.jpg',100,'This is a book','The Long Dark Tea-Time of the Soul');
insert into book(discount,img,price,shortdescription,title) 
values(50,'template/web/img/b8.jpg',200,'This is a book','A walk across the Sun');
insert into book(discount,img,price,shortdescription,title) 
values(50,'template/web/img/b9.jpg',100,'This is a book','Marathon Baba');
insert into book(discount,img,price,shortdescription,title) 
values(50,'template/web/img/b10.jpg',200,'This is a book','The Armageddon Rag');
insert into book(discount,img,price,shortdescription,title) 
values(50,'template/web/img/b11.jpg',100,'This is a book','The Magic');
insert into book(discount,img,price,shortdescription,title) 
values(50,'template/web/img/b12.jpg',200,'This is a book','Crossroads');
insert into book(discount,img,price,shortdescription,title) 
values(50,'template/web/img/b14.jpg',100,'This is a book','The Sins of the father');
insert into book(discount,img,price,shortdescription,title) 
values(50,'template/web/img/b15.jpg',200,'This is a book','I never knew it was you');


/*insert category*/
insert into caterory(name) values ('Chilren');
insert into caterory(name) values ('Sience Fiction');
insert into caterory(name) values ('Fantasy');
insert into caterory(name) values ('Mystery');
insert into caterory(name) values ('Romance');
insert into caterory(name) values ('Horror');
insert into caterory(name) values ('Poetry');
insert into caterory(name) values ('Literature');
insert into caterory(name) values ('Crime');
