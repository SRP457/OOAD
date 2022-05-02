Drop database project;
create database project;
USE project;

create table admin(
    adminid varchar(25),
    adminPassword varchar(25),
    firstName varchar(25),
    lastName varchar(25),
    phoneNumber varchar(25)
);

create table user(
    userid varchar(25),
    password varchar(25),
    firstName varchar(25),
    lastName varchar(25),
    phoneNumber varchar(25),
    package_type varchar(25)
);

create table trainer(
    trainerid varchar(25),
    password varchar(25),
    firstName varchar(25),
    lastName varchar(25),
    field varchar(25),
    phoneNumber varchar(25)
);

create table dietician(
    dieticianid varchar(25),
    password varchar(25),
    firstName varchar(25),
    lastName varchar(25),
    phoneNumber varchar(25)
);

create table diet_user (
    dieticianid varchar(25),
    userid varchar(25),
    diet_plan varchar(100)
);

create table trainer_user (
    trainerid varchar(25),
    userid varchar(25),
    exercise_plan varchar(100)
);

create table user_info(
    userid varchar(25),
    age varchar(25),
    gender varchar(25),
    height varchar(25),
    weight varchar(25),
    bmi varchar(25),
    calories_consumed varchar(25)
);

