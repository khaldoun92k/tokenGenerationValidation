@echo off

REM Start generate Boot app on port 8081
cd generator && mvn spring-boot:run -Dserver.port=8081

REM Start validate Boot app on port 8082
cd validator && mvn spring-boot:run -Dserver.port=8082

REM Wait for the services to start
timeout /t 10

REM Start the React project on port 8080
set PORT=8080
cd frontend/app && npm start"
