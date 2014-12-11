# --- !Ups

create table quotes (id BIGINT auto_increment PRIMARY KEY,author VARCHAR NOT NULL,text VARCHAR NOT NULL);

# --- !Downs

drop table quotes;

