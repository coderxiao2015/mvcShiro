create table role_permission(
	role_per_id varchar(20) not null PRIMARY key,

	role_id varchar(20) not null comment '角色id',

	per_id varchar(20) not null comment '权限id'


)comment='用户角色表';