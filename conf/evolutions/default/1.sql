# --- Created by Ebean DDL
# To stop Ebean DDL generation, remove this comment and start using Evolutions

# --- !Ups

create table flight (
  flight_id                     integer not null,
  flight_date                   varchar(255),
  dep_time                      varchar(255),
  arr_time                      varchar(255),
  aircraft_id                   integer,
  route_id                      integer,
  constraint pk_flight primary key (flight_id)
);
create sequence flight_seq;

create table user (
  email                         varchar(255) not null,
  role                          varchar(255),
  name                          varchar(255),
  password                      varchar(255),
  constraint pk_user primary key (email)
);


# --- !Downs

drop table if exists flight;
drop sequence if exists flight_seq;

drop table if exists user;

