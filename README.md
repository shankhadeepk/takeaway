#Takeaway
Takeaway Coding Project

The projects aims at providing Employee Management Service

RESTful services created for following:

1. GET http://localhost:9090/empmgmt/health
To check if the service is alive.
2. POST http://localhost:9090/empmgmt/employees
To add employee.
3. GET http://localhost:9090/empmgmt/employees/{employeeId}
To retrieve employee by Id.
4. PUT http://localhost:9090/empmgmt/employees/{employeeId}
To Update an eployee with Id.
5. DELETE http://localhost:9090/empmgmt/employees/{employeeId}
To Delete an employee
6. GET http://localhost:9090/empmgmt/events
To get all events happened on the above Rest endpoints.

Please follow following steps to execute Test cases or the Project:

1. Run the Mongodb instance using docker, by executing the command

> sudo docker run -d -p 27000:27017 --name mongo mongo

2. Run Kafka and Zookeper using the docker-compose.yml, executing the following command in the root directory of project where docker-compose.yml file is present

>  sudo docker-compose up

3. Then run the project first building it

> mvn clean install

4. Then by running the project using command

> java -jar ./target/empmgmt-1.0.0.jar

Swagger 2 is also implemented, The ui will be available at the location:

 http://localhost:9090/swagger-ui.html#/

