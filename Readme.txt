How to run?

1. Import the project into Eclipse
2. After importing please run maven install to get all dependencies
3. Then run maven test
4. This will execute all the tests


Libs used: TestNg, Cucumber


How tests are run? (test runner setup)

- Maven test by default takes the testng to start execution
- Testng.xml has the testrunner class to be executed
- Testrunner class has cucumber feature files location, cucumber integration code, After class, Before class methods.
- ApplicationFunctionalities has Cucumber feature files.
- StepDefinitions.java files are present in stepdefs package


Please note that the test setup can be improved. Due to the time contraint I did a very basic setup.