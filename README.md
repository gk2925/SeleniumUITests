# UI Automated tests for the app
* These are the UI Tests for the webpage tourradar.de
* Tests are written in Java
* Tool which is used for UI automation is Selenium V4.0
* Cucumber is used as an BDD instrument
* Features files are written with the help of Cucumber BDD 
* Maven is used as a build tool 
* Tests are written to work with Chrome 109 or higher

# Pre-requisites for running the tests 
* Java must be installed on system - Java 8 or higher 
* Maven must be installed on system 
* latest Chrome browser must be installed , please note it should be version 109 or higher

# How to run the tests 
- Clone the repo with the help of command
  ```git clone <path of the repo>  ```
- Now navigate to the root folder where you have cloned the repo 
- From the root run the below command :
  ```mvn clean test  ```
- above command will run the tests, and you can see that tests will be running in Chrome browser


