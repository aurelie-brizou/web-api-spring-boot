drop table if exists utilisateur;

create table utilisateur (
id serial primary key,
prenom varchar(75) not null,
nom varchar(75) not null
);
