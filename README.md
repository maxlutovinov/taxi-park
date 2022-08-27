# Taxi Service

<!-- TOC -->

* [Description](#description)
* [Features](#features)
* [Deployed application](#deployed-application)
* [Structure](#structure)
* [Technology stack](#technology-stack)
* [Usage](#usage)

<!-- TOC -->

## Description

Hello! This is my first web project on my journey of learning Java. The goal was a simple web application that supports
basic authentication, registration, login/logout and CRUD operations.

## Features

Web-application:

- Registration as a driver
- Authentication as a driver
- Logout
- Create/remove a manufacturer
- Create/remove a car
- Create/remove a driver
- Add a driver to the car
- Display list of all manufacturers
- Display list of all drivers
- Display list of all cars
- Display cars of logged driver

In addition, the web application can be enhanced with functionality that is already implemented in project on 
Dao and Service layers:

- Update a manufacturer
- Update a driver
- Update a car
- Remover a driver from the car

## Deployed application

The web application is available on [Heroku](https://www.heroku.com/about) here:

[https://fathomless-oasis-taxi.herokuapp.com](https://fathomless-oasis-taxi.herokuapp.com)

Simply sign up for the web app as a driver, then log in and use it. You can also clone the project locally and run the
web application on your database locally or deploy as described in the [Usage](#usage) section of this page.

Please keep in mind that the database records you can see in my deployed application to Heroku this is your doing
:slightly_smiling_face:

## Structure

The project have a three-tier architecture that include the following layers of functionality:

- [Controller](src/main/java/taxi/controller) layer processes a user request sent from the user interface and responds
  to the user.
- [Service](src/main/java/taxi/service) layer is responsible for the business logic of the application on request from
  the controller.
- [DAO](src/main/java/taxi/dao) layer works with the database on request from the service.

The project operates with three models - Manufacturer, Car and Driver. The properties of each model are represented
in the corresponding classes in [model](src/main/java/taxi/model) package of the project.

## Technology stack

Java 11, JDBC, Java EE 8 (Servlets, Java Server Pages), SQL, Maven, Tomcat 9, Heroku Webapp Runner.

## Usage

### Clone

    git clone https://github.com/maxlutovinov/taxi-service.git

### Create database

File [init_db.sql](src/main/resources/init_db.sql) in `resources` folder contains SQL scripts for creating the project
database.

### Set up connection to database

Change the database connection data to yours in [application.properties](src/main/resources/application.properties) file.<br>
Example:

    db.url=jdbc:mysql://localhost:3306/taxi_service
    db.username=root
    db.password=12345678
    jdbc.driver=com.mysql.cj.jdbc.Driver

#### DB connection error:

If you can't connect to your db because of an error like this:

`The server time zone value ‘EEST’ is unrecognized or represents more than one time zone`

Try to set timezone explicitly in your connection URL. <br>Example:

`...localhost:3306/your_schema?serverTimezone=UTC`

### Build

Run on command line from the root directory of the project:

    mvn package

### Run with Heroku Webapp Runner

Run on command line from the root directory of the project:

    java -jar target/dependency/webapp-runner.jar target/*.war

[Webapp Runner](https://github.com/heroku/webapp-runner) allows you to launch an application in your filesystem into a
tomcat container with a simple java -jar command. No previous steps to install Tomcat are required when using Webapp
Runner.<br>
The Maven dependency plugin is already added in [pom.xml](pom.xml) to download webapp-runner as part of your build.

After launching the application successfully, open it in your browser:

    http://localhost:8080/

This will bring you to the login page of application. Then sign up, log in and use. 

### Run in IDE

Download [Tomcat](https://tomcat.apache.org/download-90.cgi), configure it for the project in your IDE and run.

### Deploy on Heroku cloud platform

[Heroku app deployment instructions](https://devcenter.heroku.com/articles/java-webapp-runner)
