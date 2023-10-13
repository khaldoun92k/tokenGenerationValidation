#!/bin/bash

cd generator 
mvn spring-boot:run -Dserver.port=8081 &

cd ..
cd validator 
mvn spring-boot:run -Dserver.port=8082 &

cd ..
export PORT=8080
cd frontend && npm install && npm start -o
