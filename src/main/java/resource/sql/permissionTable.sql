create table permission(
	per_id varchar(20) not null PRIMARY key,

	per_code varchar(50) not null comment '权限码',

	per_name varchar(50) comment '权限名称'


)comment='权限';