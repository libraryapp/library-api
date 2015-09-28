### This *should* get the app up and running:
---
Ensure java JDK version 1.8 is installed.  unfortunately ubunut repositories do not have a source for v1.8 upgrading may need to be googled
e.g. [http://stackoverflow.com/questions/30177455/moving-from-jdk-1-7-to-jdk-1-8-on-ubuntu]

 1. [Install Gradle](https://docs.gradle.org/current/userguide/installation.html) to compile and run the app
 2. Set up a database - [currently configured for MySQL](http://dev.mysql.com/doc/refman/5.6/en/installing.html) - see below for how to get set up on Ubuntu
 3. Can use the eg_db.sql file to get the basic database structure and a couple of dummy entries.
 4. In the terminal, run ``./gradlew build``
 5. Then ``./gradlew run``
 6. Then visit [http://localhost:8080/books]



setting up SQL - for linux (ubuntu 14.04)

1. Install the MySql server using: 
> ``sudo apt-get install mysql-server``
 
2. enter password during install (and remember this)

3. log into mysql shell using
> ``mysql -u root -p``
 
4. create database from inside this shell
> ``create database bookshelf;``
 
5. chose to use this database (may be unecessary?)
> ``use bookshelf``
 
6. use the 'eg_db.sql' script to generate tables by pasting the script into the shell

7. test by showing what is in the tables
> ``select * from books``
 
8. create a new user, credentials are defined in 'configuration.yml'

> ``create user 'admin'@'localhost' identified by 'password';``
> ``grant all privileges on *.* to 'admin'@'localhost' with grant option;``

Until swagger gets involved, view all books at [localhost:8080/books](http://localhost:8080/books) and an individual book like [localhost:8080/books/1](http://localhost:8080/books/1)