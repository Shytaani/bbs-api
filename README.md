# bbs-api
RESTful API for the BBS Application with Spring Boot

## Getting Started

### Install Java
Install JDK 8 or 11. (11 is recommended.)

### Install MySQL
Install MySQL 8.0.xx.

### Create DB and Table
1. Log in to your MySQL server by root.

2. execute SQL below and create database `bbs`.
```
CREATE DATABASE bbs;
```

3. execute SQL below and create table `message`.
```
CREATE TABLE message (
    id BIGINT NOT NULL PRIMARY KEY,
    name VARCHAR(20) NOT NULL,
    email varchar(254) NOT NULL,
    subject VARCHAR(40),
    content VARCHAR(400) NOT NULL,
    posted_date DATETIME NOT NULL
);
```

## Install Git ※If you haven't installed git yet

## Clone this repository
Open the Command Prompt and execute git command below.
```
git clone https://github.com/Tanishy/bbs-api.git
```

## Set DB connection
Change `username` and `password` in the file `bbs-api/src/main/resources/application.yml` to account you crated.
```
spring:
    dataSource:
        url: jdbc:mysql://localhost:3306/bbs?serverTimezone=JST
        username: YOUR USERNAME
        password: YOUR PASSWORD
```

## Run the Server
Open the Command Prompt and execute gradle command below.
```
gradlew bootRun
```