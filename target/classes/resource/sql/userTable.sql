create table user(

  user_id varchar(20) not null PRIMARY key,

  login_name varchar(50) not null,

  password varchar(50) not NULL


);

alter table user comment '用户名';


alter table user modify column user_id varchar(20) comment '用户id';

alter table user modify column login_name varchar(20) comment '用户名';

alter table user modify column password varchar(20) comment '密码';
