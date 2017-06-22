# cucumber-test

Prerequisites:
* Java 8
* Maven or Gradle
* Latest FireFox browser
* GeckoDriver - found in your system path (https://github.com/mozilla/geckodriver/releases)

To run:
* Maven - mvn test
* Gradle - gradle cucumber

* * *
## Technical details

Cucumber is built with Behavior-Driven Development in mind. Cucumber tests should be simulations of actual end user behavior with the product.

Cucumber tests are written in readable form in .feature files. There are three parts for each .feature file.
* Background: This sets up the test, making sure that all dependencies are in place before the test is run.
* Scenario: This defines each test case
* Steps: This list individual behavior for each scenario

Each behavior is defined through Java code located in specific Steps classes.

Cucumber leverages Selenium Web Driver to run its tests. The steps definition are using Selenium's API for each action.

## Quick thoughts
The following are recommendations on how I forsee Cucumber can be used for Jarvis. However, many of these recommendations have not been fully tested yet. (Gabe)

* Leverage the Background task to make sure that each test has the right data in place. Because many pieces in Jarvis depends on existing data (i.e. Projects require a client), the Background task can check if the environment is ready for each test scenario.
* Create several Steps java classes. 
  * One class should contain very generic steps, such as "I click on button with text ${text}". This step can be reused in various test scenarios.
  * Each feature should have its own verification step class. This class will define steps that verify the test scenarios ran.
  * Each feature may have its own custom step class. This class will contain step definitions unique to its respective feature.
