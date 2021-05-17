## SeleniumTestPOM

### Primary goal
Test AUT.

### Brief description

This Project can be used for e2e test of application under test.It will provide below features:

1.Build Management-Maven(validate,compile,test,package,verify,install,deploy)

2.Configuration Management-Supports different environment configurations(Prod,test)

3.Page Object Model,Utils..

4.Add Logs(log4j)-Log mechanism for user

5.Reporting(Allure reports)- http://192.168.178.234:61891/index.html#packages/c9133c4d3ac0493e8740c17d8973a9f5/c4d2e5a9f2f6333e/

allure generate ./allure-results --clean

allure open ./allure-report/

### Selenium functions used in Tests

1. Entering text to all fileds on page
2. Handling presence of webelment and handling exception
3. Asserting error msgs
4. Switching to different tabs and perform tests
5. Take screenshot and add it to reports
6. Selecting value from dropdown


