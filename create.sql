create table diversity_inclusion (id bigint not null AUTO_INCREMENT, about_organization varchar(4000), contacts varchar(255), email varchar(255), leader_name varchar(255), organization_name varchar(255), role varchar(255), states varchar(255), url varchar(255), primary key (id)) engine=InnoDB;
create table hibernate_sequence (next_val bigint) engine=InnoDB;
insert into hibernate_sequence values ( 1 );
