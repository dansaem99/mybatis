drop user mybatis cascade;

create user mybatis identified by mybatis default tablespace users;
grant connect, resource to mybatis;
    
create table mybatis.users(
    user_id number(2),
    user_name varchar2(12),
    reg_date date);

create table mybatis.addresses(
    user_id number(2),
    address varchar2(30));

create table mybatis.posts (
    post_id number(3),
    post_title varchar2(60),
    pist_content varchar2(120),
    user_id number(2));
    
alter table mybatis.users
    add constraint user_userid_pk primary key(user_id);
alter table mybatis.addresses
    add constraint addr_userid_pk primary key(user_id);
alter table mybatis.posts
    add constraint post_postid_pk primary key(post_id);
    
alter table mybatis.addresses
    add constraint addr_userid_fk foreign key(user_id)
    references mybatis.users(user_id);
alter table mybatis.posts
    add constraint post_userid_fk foreign key(user_id)
    references mybatis.users(user_id);
    
insert into mybatis.users
    values(1, 'john', to_date('2023-01-26', 'yyyy-mm-dd'));
insert into mybatis.users
    values(2, 'terry', to_date('2023-01-27', 'yyyy-mm-dd'));

insert into mybatis.addresses
    values(1, '서울시 마포구');
insert into mybatis.addresses
    values(2, '성남시 분당구');
    
insert into mybatis.posts
    values(101, '사랑', '너와 나의 연결고리', 1);
insert into mybatis.posts
    values(102, '정의', '너와 나의 연대고리', 1);
insert into mybatis.posts
    values(201, '김치', '네가 있어야 밥을 먹지.', 2);
insert into mybatis.posts
    values(202, '비빔밥', '동학농민항쟁이 만든 음식이다.', 2);
insert into mybatis.posts
    values(203, '찹쌀떡', '네가 그리워.', 2);
    
commit;