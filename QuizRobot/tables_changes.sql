delete from user_info;
alter table user_info add password varchar2(200) not null;

select * from user_info;

alter table user_info modify nick_name varchar2(200);

alter table user_info add constraint nick_name_uk1 unique(nick_name);

delete from grouptable;

alter table grouptable drop column username;

alter table grouptable add nick_name VARCHAR2(200) not null;

alter table grouptable add constraint grouptable_username_fk foreign key(nick_name) REFERENCES  user_info(nick_name) ON DELETE CASCADE;

drop table usertable;

create table science_section
(
    section_id number(2) not null,
    science_section varchar2(200) default 'general' not null,
    constraint section_id_pk primary key (section_id)
);

alter table question add section_id number(2);
    
alter table question add constraint section_id_fk foreign key(section_id) references science_section(section_id);

update QUESTION set SECTION_ID = 1;


insert into SCIENCE_SECTION(SECTION_ID, SCIENCE_SECTION)
values(1, 'English');

insert into USER_INFO(USER_ID, NICK_NAME, PASSWORD)
values(111, 'admin', 'qwerty');

insert into USER_INFO(USER_ID, NICK_NAME, PASSWORD)
values(222, 'user', '12345678');

insert into USER_INFO(USER_ID, NICK_NAME, PASSWORD)
values(333, 'yuranich', 'yuranich');

insert into GROUPTABLE(GROUPNAME, NICK_NAME)
values('ADMIN', 'admin');

insert into GROUPTABLE(GROUPNAME, NICK_NAME)
values('USER', 'user');

insert into GROUPTABLE(GROUPNAME, NICK_NAME)
values('YURANICH', 'yuranich');
