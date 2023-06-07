# CencoPay-QA-Mobile-Testing-Automation with Appium.

### Pre requirements
Setting up the working environment:

•	Install Java 8 and configure the JAVA_HOME environment variable on your system.

•	Install maven.

•	Install IntelliJ IDEA.

•	Install Appium client.

•	Access to browserstack

### Executing the tests
To run automation for android in BrowserStack consider the following:
* The application must be loaded in the service with browserStack credentials in order to run the tests.

* Execute the command from terminal: `mvn clean verify -DtestPlatform=android -DrunOn=browserstack "-Dcucumber.filter.tags=@android" "-Dappium.hub=https://user:token@hub-cloud.browserstack.com/wd/hub" -Dappium.build=“Name for build”`.

To run automation for iOS on BrowserStack consider the following:

* Execute the command from terminal: ``.

### Report
To view the report navigate to the following path and open the file with a browser.
* `target/site/serenity/index.html`

### Description
The project is built with appium in java with the help of the serenity library in POM methodology which is page oriented, for the execution of the tests we plan to use BrowserStack which is a cloud service that can help us to make our tests run in a more optimal way when the project is in its beginning until it starts to grow.
