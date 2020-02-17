@SmokeTest
Feature: Login feature
         Verify Login feature of Mercury Tours application

Background: User access Login screen of Mercury Tours application
            When user opens "chrome" browser
            And user enters application url "http://www.newtours.demoaut.com/mercurywelcome.php"
            And user waits "15" seconds to load login page
            And user maximizes chrome browser
            Then user is on login screen of Mercury Tours application

  @SmokeTest
  Scenario: Verify that valid user able to login into Mercury Tours application by using valid username and password
            Given user access login screen of Mercury Tours application
            When user enters "cjc1" as username
            And user enters "pass1" as password
            And user clicks on Signin button
            Then user is on Flight Finder screen
            When user clicks on Signoff link
            Then user is on Signon screen
  