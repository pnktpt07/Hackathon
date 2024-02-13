# Selenium Automation Hackathon Project: EMICalculator.net
 
## Project Overview
 
This Selenium automation testing project focuses on automating tasks related to the "EMICalculator.net". The primary objectives include , giving the value to the text box and use of scale to get the car loan price , navigating through the different loan menu, verifying the presence of text box & scales, and  Re-use the same validation for Loan Amount Calculator & Loan Tenure Calculator . The project uses various dependencies and libraries to facilitate automation.
 
## Project Structure
 
### 1. Maven Repository
 
- **Maven Version**: 3.12.1
 
### 2. Dependencies
 
1 **Apache POI**
 - Version: 5.2.4
 - Purpose: Used for reading and writing Excel files, facilitating data-driven testing.
 
2 **TestNG**
 - Version: 7.9.0
 - Purpose: Framework for test automation that allows for parallel execution and flexible test configuration.
 
3 **Extent Report**
 - Version: 5.1.1
 - Purpose: Generates interactive and detailed HTML reports to enhance test result analysis.
 
4 **Selenium**
 - Version: 4.16.1
 - Purpose: Enables interaction with web elements, navigation, and form submission in the browser.

5. **Loggers:**
 - Version:2.2.2.0
 - Provides logging capabilities for better debugging and tracebility.
 
## Automation Test Flow
 
1. **Open EMICalculator.net page**
 - Navigate to the Car Loan.
 
2. **Click on Car Loan**
 - Give the value to the textbox for loan amount , Interest rate and tenure.
 - Scroll down and take the value of principal amount and itrest amount.
 - Print the value and take screenshots.
 
3. **Verify and Navigate to Home Loan EMI calculator**
 - Fill the Home Loan details.
 - Get all the data from  year on year table.
 - Print the data and store the data in excel sheet.
 
4. **Verify and Navigate to Loan calculator**
 - Verify the title "Loan Calculator — Calculate EMI, Affordability, Tenure & Interest Rate".
 
5. **Click on EMi Calculator**
 - Validate all the text box given .
 - Validate the all the scales before and after giving the value .
 - Take Screeshot of the page.
 - Re-use the same validation for Loan Amount Calculator & Loan Tenure Calculator
 
 
## How to Run the Tests
 
1. **Open Eclipse IDE:**
 - Launch Eclipse IDE on your machine.
 
2. **Import Project:**
 - Select `File` -> `Import` from the menu.
 - Choose `Existing Maven Projects` and click `Next`.
 - Browse to the directory where you cloned the repository and select the project.
 
3. **Update Maven Project:**
 - Right-click on the project in the Project Explorer.
 - Choose `Maven` -> `Update Project`.
 - Click `OK` to update dependencies.
 
4. **Run Test Suite:**
 - Locate the test suite file (e.g., `src/test/java/TestSuite.java`).
 - Right-click on the file and choose `Run As` -> `1 TestNG Suite`.
 
6. **View Reports:**
 - After execution, open the `test-output` folder.
 - Find the Extent Report HTML file (`index.html`) for detailed test reports.

7. **View Loggers:**
 - After execution, open the `logs` folder.
 - Find the Log Report  file  for detailed test info.

8. **Create Selenium Grid:**
 - Using Selenium grid run the program on different OS.

9. **GIT & GITHub:**
 - Push the project using Git to the GitHub.

10. **Jenkins:**
 - Using GitHub create Jenkins to run the project.

 
## Author Information
 
 - **Priyanka Tripathy**

## Future Enhancements 

1. **Test Automation Framework:**
   - Implement an end-to-end test automation framework using Selenium WebDriver and TestNG.

2. **Headless Browser Mode:**
   - Incorporate a headless browser mode for faster test execution and better support for continuous integration.

3. **Screenshot Comparison:**
   - Utilize a screenshot comparison tool to detect visual regressions in the application's UI.

4. **Test Data Management:**
   - Integrate with a test data management system to handle dynamic test data and increase test coverage.

5. **Reporting Tools:**
   - Incorporate reporting tools like Extent Reports for better visualization of test results.

6. **Automatic Cleanup:**
   - Implement a mechanism for automatic cleanup after test execution to maintain a clean test environment.

7. **CI/CD Pipeline Integration:**
    - Consider implementing a CI/CD pipeline to automate the entire testing process, including deployment.

 
## Disclaimer
 
This project is intended for educational and testing purposes only. The authors are not responsible for any unauthorized use or modification of the code. Use at your own risk.