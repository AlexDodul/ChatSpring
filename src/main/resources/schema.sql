create table users
(
    id        bigint generated by default as identity
        primary key,
    user_name varchar(255)
);

alter table users
    owner to postgres;

create table user_messages
(
    id      bigint generated by default as identity
        primary key,
    date    timestamp,
    message text,
    user_id bigint
        constraint fk_message_user_id
            references users
);

alter table user_messages
    owner to postgres;
