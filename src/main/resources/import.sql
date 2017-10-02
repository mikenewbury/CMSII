insert into Role(id,name,description) values (1,'ROLE1','Role 1');
insert into Role(id,name,description) values (2,'ROLE2','Role 2');
insert into Role(id,name,description) values (3,'ADMIN','Admin');

insert into cmsgroup (id, name) values (1, 'Admin Group');
insert into cmsgroup (id, name) values (2, 'U30 User Group');

insert into cmsgroup_role (groups_id , roles_id) values (1,1);
insert into cmsgroup_role (groups_id , roles_id) values (1,2);
insert into cmsgroup_role (groups_id , roles_id) values (1,3);

insert into cmsgroup_role (groups_id , roles_id) values (2,1);

insert into cmsuser (id, name, real_name, email, enabled, locked, password) values (1, 'adminuser' , 'Adminstrator', 'admin@cms.com', true, false, 'cmsam');
insert into cmsuser (id, name, real_name, email, enabled, locked, password) values (2, 'basic' ,'Basic User', 'basic@cms.com', true, false, 'password');

--insert into cmsuser (id, name, password) values (3, 'U01' , 'password');
--insert into cmsuser (id, name, password) values (4, 'U02' , 'password');
--insert into cmsuser (id, name, password) values (5, 'U03' , 'password');
--insert into cmsuser (id, name, password) values (6, 'U04' , 'password');
--insert into cmsuser (id, name, password) values (7, 'U05' , 'password');
--insert into cmsuser (id, name, password) values (8, 'U06' , 'password');
--insert into cmsuser (id, name, password) values (9, 'U07' , 'password');
--insert into cmsuser (id, name, password) values (10, 'U08' , 'password');
--insert into cmsuser (id, name, password) values (11, 'U09' , 'password');
--insert into cmsuser (id, name, password) values (12, 'U30' , 'password');
--insert into cmsuser (id, name, password) values (13, 'U11' , 'password');
--insert into cmsuser (id, name, password) values (14, 'U12' , 'password');
--insert into cmsuser (id, name, password) values (15, 'U13' , 'password');
--insert into cmsuser (id, name, password) values (16, 'U14' , 'password');
--insert into cmsuser (id, name, password) values (17, 'U15' , 'password');
--insert into cmsuser (id, name, password) values (18, 'U16' , 'password');
--insert into cmsuser (id, name, password) values (19, 'U17' , 'password');
--insert into cmsuser (id, name, password) values (20, 'U18' , 'password');
--insert into cmsuser (id, name, password) values (21, 'U19' , 'password');
--insert into cmsuser (id, name, password) values (22, 'U30' , 'password');
--insert into cmsuser (id, name, password) values (23, 'U21' , 'password');
--insert into cmsuser (id, name, password) values (24, 'U22' , 'password');
--insert into cmsuser (id, name, password) values (25, 'U23' , 'password');
--insert into cmsuser (id, name, password) values (26, 'U24' , 'password');
--insert into cmsuser (id, name, password) values (27, 'U25' , 'password');
--insert into cmsuser (id, name, password) values (28, 'U26' , 'password');
--insert into cmsuser (id, name, password) values (29, 'U27' , 'password');
--insert into cmsuser (id, name, password) values (30, 'U28' , 'password');
--insert into cmsuser (id, name, password) values (31, 'U29' , 'password');
--insert into cmsuser (id, name, password) values (32, 'U30' , 'password');
--insert into cmsuser (id, name, password) values (33, 'U31' , 'password');
--insert into cmsuser (id, name, password) values (34, 'U32' , 'password');
--insert into cmsuser (id, name, password) values (35, 'U33' , 'password');
--insert into cmsuser (id, name, password) values (36, 'U34' , 'password');
--insert into cmsuser (id, name, password) values (37, 'U35' , 'password');
--insert into cmsuser (id, name, password) values (38, 'U36' , 'password');
--insert into cmsuser (id, name, password) values (39, 'U37' , 'password');
--insert into cmsuser (id, name, password) values (40, 'U38' , 'password');
--insert into cmsuser (id, name, password) values (41, 'U39' , 'password');


insert into cmsuser_cmsgroup (users_id, groups_id) values (1, 1);
insert into cmsuser_cmsgroup (users_id, groups_id) values (2, 2);

insert into cmsuser_role (user_id, roles_id) values (1,2);


-- TERM AVAILABILITY

insert into term_availability (id, code, display_value,note, modified_by, modified_date)
values (1, 'Availability Code 1', 'Availability Display Value 1', 'Availability Note 1', 'Modified by 1' , current_timestamp());

insert into term_availability (id, code, display_value,note, modified_by, modified_date)
values (2, 'Availability Code 2', 'Availability Display Value 2', 'Availability Note 2', 'Modified by 2' , current_timestamp());


-- TERM STATUS
insert into term_status (id, code, display_value,note, modified_by, modified_date)
values (1, 'Status Code 1', 'Status Display Value 1', 'Status Note 1', 'Modified by 1' , current_timestamp());

insert into term_status (id, code, display_value,note, modified_by, modified_date)
values (2, 'Status Code 2', 'Status Display Value 2', 'Status Note 2', 'Modified by 2' , current_timestamp());
