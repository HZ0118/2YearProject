# --- Created by Ebean DDL
# To stop Ebean DDL generation, remove this comment and start using Evolutions

# --- !Ups

create table aircraft (
  aircraft_id                   integer not null,
  aircraft_number               varchar(255),
  capacity                      integer,
  constraint pk_aircraft primary key (aircraft_id)
);
create sequence aircraft_seq;

create table booking (
  booking_id                    integer,
  booking_date                  varchar(255),
  departure_date                varchar(255),
  ticket_type                   varchar(255),
  passenger_passenger_id        integer,
  flight_schedule_flight_id     integer
);

create table flight_schedule (
  flight_id                     integer not null,
  flight_date                   varchar(255),
  departure_time                varchar(255),
  arrival_time                  varchar(255),
  aircraft_aircraft_id          integer,
  routes_route_id               integer,
  constraint pk_flight_schedule primary key (flight_id)
);
create sequence flight_schedule_seq;

create table passenger (
  passenger_id                  integer not null,
  name                          varchar(255),
  address                       varchar(255),
  age                           integer,
  nationality                   varchar(255),
  mobile                        varchar(255),
  constraint pk_passenger primary key (passenger_id)
);
create sequence passenger_seq;

create table route (
  route_id                      integer not null,
  route_code                    varchar(255),
  airport                       varchar(255),
  destination                   varchar(255),
  cost                          double,
  constraint pk_route primary key (route_id)
);
create sequence route_seq;

create table user (
  email                         varchar(255) not null,
  role                          varchar(255),
  name                          varchar(255),
  password                      varchar(255),
  constraint pk_user primary key (email)
);

alter table booking add constraint fk_booking_passenger_passenger_id foreign key (passenger_passenger_id) references passenger (passenger_id) on delete restrict on update restrict;
create index ix_booking_passenger_passenger_id on booking (passenger_passenger_id);

alter table booking add constraint fk_booking_flight_schedule_flight_id foreign key (flight_schedule_flight_id) references flight_schedule (flight_id) on delete restrict on update restrict;
create index ix_booking_flight_schedule_flight_id on booking (flight_schedule_flight_id);

alter table flight_schedule add constraint fk_flight_schedule_aircraft_aircraft_id foreign key (aircraft_aircraft_id) references aircraft (aircraft_id) on delete restrict on update restrict;
create index ix_flight_schedule_aircraft_aircraft_id on flight_schedule (aircraft_aircraft_id);

alter table flight_schedule add constraint fk_flight_schedule_routes_route_id foreign key (routes_route_id) references route (route_id) on delete restrict on update restrict;
create index ix_flight_schedule_routes_route_id on flight_schedule (routes_route_id);


# --- !Downs

alter table booking drop constraint if exists fk_booking_passenger_passenger_id;
drop index if exists ix_booking_passenger_passenger_id;

alter table booking drop constraint if exists fk_booking_flight_schedule_flight_id;
drop index if exists ix_booking_flight_schedule_flight_id;

alter table flight_schedule drop constraint if exists fk_flight_schedule_aircraft_aircraft_id;
drop index if exists ix_flight_schedule_aircraft_aircraft_id;

alter table flight_schedule drop constraint if exists fk_flight_schedule_routes_route_id;
drop index if exists ix_flight_schedule_routes_route_id;

drop table if exists aircraft;
drop sequence if exists aircraft_seq;

drop table if exists booking;

drop table if exists flight_schedule;
drop sequence if exists flight_schedule_seq;

drop table if exists passenger;
drop sequence if exists passenger_seq;

drop table if exists route;
drop sequence if exists route_seq;

drop table if exists user;

