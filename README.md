## TnTechTask

- **Technology used:** Java, Selenium Webdriver, Maven, JUnit, SureFire Reporting
- **Framework used:** Cucumber, Page Object Model

### **Project Structure:**

The framework used is Cucumber alongside the use of a page object model.

Test scenarios are in BDD format and are found here:

* features > TestFeatures.feature

The individual test steps for the feature file are found here:

* src/test/java > stepDefinition > TestSteps.java

As the project is using a page object model then the detailed code for the test steps, along with the resuable components can be found in:

* src/test/java > pages > PageObjects.java

The test runner defines what is run by JUnit and additional configuration can be made here, by default it is set to run all scenarios and generate test reports in both html and json format, if you wish to only run certain scenarios you can add the following; tags = "@Scenario1" (where @Scenario1 is the tag you wish to run, if running multiple but not all, additional tags can be separated with a comma) the test runner can be found here:

* src/test/java > runner > TestRunner.java

----------------------------------------------------------------------------------------------------------

The following steps advise how you can run the tests (either from IDE or CMD).
### **Pre-requisites:**

1. Clone repository to local machine.
2. Go to: https://chromedriver.chromium.org/downloads and download chromedriver for your version of Chrome browser
3. Extract the chromedriver.exe file to your local machine and copy the file path
4. Open the project folder in your IDE and go to src/test/java > pages > PageObjects.java
5. Paste in the file path for chromedriver.exe next to 'String driverPath' in quotations.
6. Save changes to PageObjects.java
7. Download Maven dependencies by updating project/clean build


### **To run tests from within IDE:**

1. Right click on testRunner.java > run as > JUnit Test

### **To run tests from command line with Maven:**

1. Ensure Maven is installed on your local machine by following; https://maven.apache.org/install.html
2. Open CMD  and navigate to cloned project directory
3. Type command 'mvn test' and hit return
4. Tests will then compile and run

----------------------------------------------------------------------------------------------------------

### **Test reports:**
1. Following test run, reports can be found in the 'target' folder within the project
2. To access from within IDE refresh the project then go to Target > cucumber-htmlreport and access 'index.html'
3. Alternatively locate the above mentioned file from file explorer
- Other report formats can be found within the 'target' folder.
