create table users
(
    id serial not null,
    login varchar(50) not null,
    password varchar not null,
    role_id int not null
);

create unique index users_id_uindex
    on users (id);

create unique index users_login_uindex
    on users (login);

alter table users
    add constraint users_pk
        primary key (id);

alter table users
    add constraint fk_users_roles
        foreign key (role_id)
            references roles (id);