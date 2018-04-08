create table role(
role_id varchar(20) not null PRIMARY key ,

role_name varchar(50) not null comment '角色名称',

role_code varchar(100) comment '权限码',

is_valide int(1) comment '角色是否有效'

)comment='角色表';