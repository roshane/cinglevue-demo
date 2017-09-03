# cinglevue- spa demo

CingleVue Coding Challenge
Create a single page web application displaying a list of students, clicking on one item it will
show the student details and will be possible to edit the student. Provide also the possibility to
add a new student or deleting an existing one.
Use the JSON provided as guideline to build the form.


### pre-requisits
* jdk-8
* maven
* mongodb

### how to run the sample
* just execute `run.sh` file if you are in bash environment otherwise please use the  command `mvn clean compile spring-boot:run`
* application will initialize the db with sample data upon startup
* goto http://localhost:8080
* click the `search` => list all student details



### Tech stack
* spring-boot
* spring-data-mongodb
* mongodb


### todo
* proper validation need to be added
* UI design
* test cases
* front end pagination
	