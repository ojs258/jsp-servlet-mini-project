drop table NEWS;
drop table MEMBER;

create table MEMBER
(
    M_ID       INTEGER auto_increment
        primary key,
    M_EMAIL    CHARACTER VARYING(50) not null unique ,
    M_PASSWORD CHARACTER VARYING(30) not null,
    M_NAME     CHARACTER VARYING(10) not null
);

create table PUBLIC.NEWS
(
    N_ID      INTEGER auto_increment,
    N_TITLE   CHARACTER VARYING(20) not null,
    N_IMG     CHARACTER VARYING(100) not null,
    N_DATE    TIMESTAMP,
    N_CONTENT CHARACTER VARYING(1000000000) not null,
    M_ID      INTEGER,
    constraint NEWS_PK
        primary key (N_ID),
    constraint NEWS_MEMBER_FK
        foreign key (M_ID) references PUBLIC.MEMBER
);