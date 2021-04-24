-- create DB

create table status
(
    -- Only integer types can be auto increment
    id   varchar not null
        constraint status_pkey
            primary key,
    name varchar                                            not null
);

alter table status
    owner to postgres;

create table class
(
    -- Only integer types can be auto increment
    id        varchar not null
        constraint class_pkey
            primary key,
    name      varchar                                           not null,
    status_id varchar
);

alter table class
    owner to postgres;

create table role
(
    -- Only integer types can be auto increment
    id   varchar not null
        constraint role_pkey
            primary key,
    name varchar                                          not null
);

alter table role
    owner to postgres;

create table room
(
    -- Only integer types can be auto increment
    id        varchar not null
        constraint room_pkey
            primary key,
    name      varchar                                          not null,
    status_id varchar
);

alter table room
    owner to postgres;

create table slot
(
    -- Only integer types can be auto increment
    id   varchar not null
        constraint slot_pkey
            primary key,
    name varchar                                          not null,
    time varchar,
    day  varchar
);

alter table slot
    owner to postgres;

create table semester
(
    -- Only integer types can be auto increment
    id   varchar not null
        constraint semester_pkey
            primary key,
    name varchar                                              not null
);

alter table semester
    owner to postgres;

create table "user"
(
    -- Only integer types can be auto increment
    id        varchar not null
        constraint user_pkey
            primary key,
    password  varchar                                          not null,
    full_name varchar,
    status_id varchar,
    role_id   varchar,
    point     varchar(1)
);

alter table "user"
    owner to postgres;

create table class_timetable
(
    id             serial not null
        constraint class_timetable_pkey
            primary key,
    class_id       varchar,
    course_user_id varchar
);

alter table class_timetable
    owner to postgres;

create table timetable
(
    id                 serial  not null
        constraint timetable_pkey
            primary key,
    class_timetable_id integer not null
        constraint timetable_class_timetable_id_fkey
            references class_timetable,
    slot_id            varchar,
    room_id            varchar
);

alter table timetable
    owner to postgres;

create table subject
(
    id           varchar not null
        constraint subject_pk
            primary key,
    subject_name varchar,
    total_slot   integer
);

alter table subject
    owner to postgres;

create unique index subject_subject_code_uindex
    on subject (id);

create table major
(
    id         varchar not null
        constraint major_pk
            primary key,
    major_name varchar
);

alter table major
    owner to postgres;

create unique index major_major_id_uindex
    on major (id);

create table course_user
(
    id        varchar not null
        constraint course_user_pk
            primary key,
    user_id   varchar,
    course_id integer
);

alter table course_user
    owner to postgres;

create table course
(
    id          serial not null
        constraint course_pkey
            primary key,
    semester_id varchar,
    major_id    varchar,
    subject_id  varchar,
    status_id   varchar
);

alter table course
    owner to postgres;

