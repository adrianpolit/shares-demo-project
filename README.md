# Kotlin + Spring Boot demo project

#### By Adrián Polit

> "If I had more time, I would have written a shorter letter"   ~ Some smart guy, probably.

## Index
0. [Dependencies](#dependencies)
1. [The premise](#the-premise)
2. [Features](#features)
3. [Run it](#run-it)
4. [Important TODOs](#important-todos)


#### Dependencies
- JVM 11
- Docker

## The premise
This little project was born from a code challenge sent to me by a company I was interested in joining.
I have reshaped the code a little to erase any references to this company, to be able to publish it on GitHub.

The challenge was something along the lines of:
> We need a project that would manage and fetch share info about companies. There should be REST endpoints to show:  
> - The list of companies you have share info from.
> - Share info on each specific company, letting the user choose a time series (hour, day, week). 
> 
> You will need to simulate the fetching of this shares' data from a third party. 

So I developed this. Now, take into account, **this is something I developed in as few hours as possible, so there are a ton of TODOs and a ton of cut corners**.  

My intention is to keep working on this project from time to time, updating it and improving it.

## Features
- Hexagonal Arch
- Swagger
- Dockerized MongoDB with auto initialization
- Spring JPA for MongoDB integration

## Run it
Execute `docker-compose up -d` before attempting to run this program. This will start a mongoDB server and initialize it via the file `mongo-init.js`.  
Once the program is running, [Swagger is here to make your life easier ;) ](http://localhost:8080/swagger-ui/index.html)

## Important TODOs
- Implement Integration Tests (using `testcontainers`)
- Develop some new functionality using TDD
