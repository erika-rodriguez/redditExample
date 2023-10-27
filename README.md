<!-- PROJECT LOGO -->
<div align="center">
  <h1 align="center">Reddit Testing Practice</h1>
  <p align="center">Web Testing Project</p>
</div>

<!-- TABLE OF CONTENTS -->
  <summary>Table of Contents</summary>
  <ol>
    <li>
      <a href="#about-the-project">About The Project</a>
      <ul>
        <li><a href="#built-with">Built With</a></li>
      </ul>
    </li>
    <li>
      <a href="#getting-started">Getting Started</a>
      <ul>
        <li><a href="#prerequisites">Prerequisites</a></li>
        <li><a href="#installation">Installation</a></li>
      </ul>
    </li>
    <li><a href="#usage">Usage</a></li>
    <li><a href="#workflow">Workflow</a></li>
    <li><a href="#useful documentation">Useful Documentation</a></li>
  </ol>

<!-- ABOUT THE PROJECT -->
## About The Project

The project focuses on testing the Reddit website using core testing tools such as Java, the Carina framework, and Selenium Web Driver. The testing process is integrated with Jenkins and using TestRail to provide a comprehensive testing experience. The goal of the project is to improve testing skills and gain experience in web testing.

### Built With

* Programming Language: Java
* CI Tools: Jenkins
* Frameworks: Carina by Zebrunner, Selenium Web Driver
* Test Management Tools: TestRail

<!-- GETTING STARTED -->
## Getting Started


### Prerequisites

- [ ] Install Java +11
- [ ] Download chromedriver and selenium server standalone
- [ ] Install Jenkins

### Installation
- [ ] Download chromedriver for your Chrome browser version, save it in Downloads.
- [ ] Download selenium-server-standalone-3.141.59.jar, save it in Downloads. 
- [ ] Clone the repo.
- [ ] Run selenium standalone openning a new terminal in Downloads and run this command: java -jar selenium-server-standalone-3.141.59.jar
- [ ] Modify the -config.properties file with browsername and version.
- [ ] Add a _testdata.properties file with TestRail's credentials data (testRailUrl, testRailUsername, testRailPassword).

<!-- USAGE EXAMPLES AND STUDY CASES-->
## Usage

- [ ] Run tests from testng.xml files to create automatically a test run in TestRail.

## Implementation details

### Study case: work with iframe
- An iframe is a separate page. Therefore, if we need to work with the internal structure of an iframe, we need to create a separate class for it inherited from AbstractPage, in which we already paint its internal structure.
- When we click in login button, an iframe is opened, you can check this by inspecting the website and reading the DOM. To work with the ui elements inside the iframe, we need to implement the carina solution for it.
- In LoginPage class, we create the locator for the iframe component, searching in DOM the <iframe> tag, and we create a method to switch to the iframe and be able to work with the elements from it.
```
driver.switchTo().frame(iframe.getElement());
```
### Study case: disable popup notifications
- To disable popup notifications on the LoginTest class, we can use the ChromeOptions to disable them or set it up in the -config.properties file
```
ChromeOptions options=new ChromeOptions();
options.addArguments("--disable-notifications");
```

### Study case: shadow DOM elements
- Elements within a shadow DOM are encapsulated and not directly accessible using standard CSS or XPath selectors. Shadow DOM is often used for encapsulation and styling of web components.
- When we try to find the Shadow DOM elements using Selenium locators, we get NoSuchElementException as it is not directly accessible to the DOM.
- To locate elements within a shadow DOM, we have two options:
1. Using JavaScriptExecutor: create an instance of JavascriptExecutor to implement the method executeScript() using as argument the nested hierarchy of tags until we get the element.  

We can verify this hierarchy by inspecting the website, go to console and execute the commands and verify the result, if we find a shadow root tag, we use the method shadowRoot() and continue navigating through the DOM. Example: document.querySelector('').shadowRoot.querySelector('').shadowRoot.querySelector('').

Finally we can save the result in a WebElement variable and use it in our tests.
```
JavascriptExecutor jse=(JavascriptExecutor) driver;
WebElement shadowedElement=(WebElement) jse.executeScript("return document.querySelector('shreddit-overlay-display[class=\"theme-beta\"]').shadowRoot.querySelector('shreddit-signup-drawer').shadowRoot.querySelector('shreddit-slotter[slot-name=\"login\"]').shadowRoot.querySelector('#login-username').shadowRoot.querySelector('faceplate-form-helper-text[placeholder=\" \"]').shadowRoot.querySelector('#helper-text')");
```
2. Using Selenium WebDriver’s getShadowDom() method.


<!-- WORKFLOW -->
## Workflow

1. Check tickets assigned to you defined in the Project Management Tool (e.g. Trello)
2. Check TestRail's test case: preconditions, steps, expected results
3. Create your Feature Branch following naming convention [TCXX]-testName
4. Add components and pages as needed, using Page Object Model Design Pattern
5. Commit your changes, push them to your branch and create a pull request assigning a reviewer
6. Merge changes to master branch

<!-- USEFUL DOCUMENTATION -->
## Useful Documentation

* [Carina Framework](https://zebrunner.github.io/carina/)
* [TestRail](https://support.gurock.com/hc/en-us)
* [Reddit url](https://www.reddit.com/)
* [TestNG](https://testng.org/doc/documentation-main.html)
* [Appium](https://appium.io/docs/en/writing-running-appium/caps/)
