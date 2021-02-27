# bbs-api (English)/([Japanese](README.md))
RESTful CRUD API for the BBS Application. (Groovy + Spring Boot)

## Environment
- Java 11
- MySQL 8

## How to run this api on local

### 1. Clone this repository
Open the Command Prompt and execute git command below.
```
git clone https://github.com/Tanishy/bbs-api.git
```

### 2. Create DB and Table
1. Log in to your MySQL server.

2. execute SQL below and create database `bbs`.
```
CREATE DATABASE bbs;
```

3. execute SQL below and create table `message`.
※This step is optional. The table is created automatically by Hibernate when you run the server.
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

### 3. Set DB connection
Change `username` and `password` in `application.yml` to account you crated.
```
spring:
    dataSource:
        url: jdbc:mysql://localhost:3306/bbs?serverTimezone=JST
        username: YOUR USERNAME
        password: YOUR PASSWORD
```

### 4. Run the server
Open the Command Prompt and execute gradle command below.
```
gradlew bootRun
```

### ※Attention
The message table is deleted each time when you stop the server.
If you would like to keep records you create, change the value of `jpa.hibernate.ddl-auto` to `update` in `application.yml`.