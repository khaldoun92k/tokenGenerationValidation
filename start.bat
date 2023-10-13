@echo off

REM Start generator Boot app on port 8081
start cmd /k "cd generator && mvn spring-boot:run -Dserver.port=8081"

REM Start validator Boot app on port 8082
start cmd /k "cd validator && mvn spring-boot:run -Dserver.port=8082"

REM Wait for the services to start
timeout /t 10

REM Start the React project on port 8080
set PORT=8080
cd frontend && npm install && npm start -o
