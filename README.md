# eventdriven-fuel-springboot-application
This project is based on event driven microservices architecture which uses following

# Technical Stack:
Java 1.8

Spring Boot 2.2.6.RELEASE

Apache Maven 3.6.3

JPA w Hibernate 1.0.0.Final

PostgreSql 42.2.18

Swagger2 API Documentation 2.7.0

RabbitMq 3.8.9

# The architecture of the service is built with the following components:
DataTransferObjects: Objects which are used for outside communication via the API.

Controller: Implements the processing logic of the service.

Service: Implements the business logic and handles the access to the DataAccessObjects.

DataAccessObjects: Interface for the database. Inserts, updates, deletes and reads objects from the database.

# Working with Project:
This project starts with Producer Service can triggers the event using API call or is automatically scheduled using Spring Scheduler.

The details such as EventType either true or false, passing random city and random mileage can be passed to the API call to trigger the event manually and publishing it to queue.

This event is scheduled event triggerring every 2 minutes and publishing it to queue with RabbitMq as message broker.
Consumer Service recieves the sent Event details including EventType, Random City and Random Mileage from the queue and Service class recives the objects and do the calculation for Amount of Fuel got into the tank and Price according to the price of fuel for the given city.

Price of the fuel of cities is fetched using JPARepository from the Entity table created "fuel" using PostgreSql.

# Prerequisites:
The following things should be installed in your system:
1. Java 8 or newer
2. Eclipse IDE or any preferred IDE
3. RabbitMq and ErlangOTP
4. PostgreSql
5. Git commandLine tool

# Steps:
1. On the Command Line:

git clone https://github.com/meghash02/eventdriven-fuel-springboot-application.git

2. Import the project into the IDE

3. Look for Application classes to start the application:

  -> EventDrivenFuelProducer

  -> EventDrivenFuelConsumer
 
 # Test on the browser via Swagger:
 
http://localhost:8091/swagger-ui.html

http://localhost:8091/swagger-ui.html#/fuel45controller

# Enter the details for JSON request:
 {
  "city": "string",
  "mileage": 0.0
}
 and eventType as "true" or "false"
 
 # Properties for the project:
 
Server port : 8091

# RabbitMq configuration:
spring.rabbitmq.host=localhost
spring.rabbitmq.port=5672
spring.rabbitmq.username=guest
spring.rabbitmq.password=guest

# database configuration:
spring.datasource.url=jdbc:postgresql://localhost:5432/postgres
spring.datasource.username=postgres
spring.datasource.password=
spring.jpa.generate-ddl=true

# Points missed in the assignment:
Project is not Dockerized.
Caching is not added.
