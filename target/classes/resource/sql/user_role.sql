create table user_role(
	user_role_id varchar(20) not null PRIMARY key,

	user_id varchar(20) not null comment '用户id',
	role_id varchar(20) not null comment '角色id'



)comment='用户角色表';