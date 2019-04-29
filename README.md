# marvel-api


#### Run in docker container
```
Open the file "application.properties" and change the app keys from marvel.
./mvnw clean install dockerfile:build
```
```
docker run -d -p 8080:8080 marvel-api:latest to silent mode
docker run -p 8080:8080 marvel-api:latest to listen the application
Open your browser in http://localhost:8080
```

#### Stop the container
```
docker rm <containerID> -f
```

#### Run local without docker
```
Open the file "application.properties" and change the app keys from marvel.

cd .\marvel-api\

./mvnw spring-boot:run

Open your browser in http://localhost:8080
```
#### Technologies

* Java 8
* Spring framework 5
* Spring Boot 2.1.4
* Spring Reactor
* Spring Cache
* Lombok
* Swagger
* Eclipse
* Docker