create table company_diversity_info (company_id integer not null, company_description varchar(4000), company_name varchar(255), email_id varchar(255), mobile_number varchar(255), urls varchar(255), primary key (company_id)) engine=InnoDB;
create table company_diversity_info_leaders (company_id integer not null, leader_id integer not null, primary key (company_id, leader_id)) engine=InnoDB;
create table diversity_inclusion (id bigint not null, about_organization varchar(255), contacts varchar(255), email varchar(255), leader_name varchar(255), organization_name varchar(255), role varchar(255), states varchar(255), url varchar(255), primary key (id)) engine=InnoDB;
create table hibernate_sequence (next_val bigint) engine=InnoDB;
insert into hibernate_sequence values ( 1 );
create table tbl_div_leader (leader_id integer not null, color varchar(255), company_name varchar(255), email_id varchar(255), gender varchar(255), is_disable varchar(255), is_lgbt varchar(255), is_veteran varchar(255), language varchar(255), maritial_status varchar(255), mobile_number varchar(255), name varchar(255), nationality varchar(255), political_orientation varchar(255), religion varchar(255), primary key (leader_id)) engine=InnoDB;
alter table company_diversity_info_leaders add constraint UK_9533fcfv7uh127h9jvt1o33r5 unique (leader_id);
alter table company_diversity_info_leaders add constraint FKjdqo776g55da9j7ak07c0cm72 foreign key (leader_id) references tbl_div_leader (leader_id);
alter table company_diversity_info_leaders add constraint FK3ji1gmqanfdijh4l9nwd6lxki foreign key (company_id) references company_diversity_info (company_id);
