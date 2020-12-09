# Splunk Interview Challenge

## Service Requirements
This repository was created by Omair Nasri as part of the interview for Mark Moore, for Splunk's Software Engineer position on the Advanced Security Analytics team.

#### Requirements:
Create a java service that reads a log file on startup. The service needs to have a REST endpoint that outputs the internally stored log data. Assume that the file has less than 1000 entries.

## Design
### Dependencies and Testing
I chose to use Java's Spring Boot web framework because it is a lightweight framework ideal for creating a demo service such as this requirement. Maven is used to manage dependencies and unit tests.

### Code
The project is organized into two main categories, the source and test folders. 

#### Source Code
The source code is separated into controller and service logic.

##### Controller 
The controller logic involves reading in the log text data, and handle the routing logic. The controller is a higher level component in comparison to the Service component, which does the heavy lifting.

##### Service
The service component includes methods to abstract away the logic of reading in the log file data and storing it internally.


#### Test Code
The testing component includes using MockMvc which enbables us to call our endpoint and ensure the correct data is recieved sent in the response. Specifically, the tests check that the response we get from /data is an OK response with a status code of 200, and compare the first element of the response object to some data that we are expecting. We're also checking to ensure there are 1200 entries in the JSON objects array, which contains entries that were parsed from the log file.
The test log data file can be found [here](/src/main/resources/test.log). This contains mock data in a Log4j format.


## Testing or using the service
#### Setup
Run `mvn install` to ensure you have project dependencies

##### To Test
Run `mvn test` to run tests

##### To run service
Run `java -jar target/SampleService-0.0.1-SNAPSHOT.jar`  
Navigate to localhost:8080/data to see the data being output to this endpoint
