# FABIII-Central-REST-API-Endpoint
Central REST API Endpoint built with Spring Boot framework

The FAB III API works as an intermediary between each Member State’s exposed Bailiff data and the corresponding response FAB III produces. This means that internally the FAB III API works as follows:
* A controller handles the incoming request;
* A service is called by the controller that sends a request to the corresponding Member State’s exposed endpoint;
* Each Member State's data is saved into a class hierarchy;
* The aforementioned hierarchy is then transformed into the correct response schema;
* The transformed data is sent as a response.

### Requirements

- Java SDK v1.8
- Maven v3.3
- Spring Boot v2.2.6
- Tomcat 9.0 v4.0
