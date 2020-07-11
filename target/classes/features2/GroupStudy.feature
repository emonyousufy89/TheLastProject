#
#Feature: Login Test
  #I want to Login with my credential
#
  #
  #Scenario: Successfull login with valid Credential
    #Given User launch Chrome browser
    #When User opens URL "https://admin-demo.nopcommerce.com/"
    #Then User enters Email as "admin@yourstore.com" and Password as "admin"
    #And User clicks login button
    #And User should be on "Dashboard / NopCommerce News"
    #Then User clicks logout
    #And User shoud be on page "Welcome, please sign in!"
    #Then User close the browser
#
  #
  #Scenario Outline: Login with user Credential
    #Given User launch Chrome browser
    #When User opens URL "https://admin-demo.nopcommerce.com/"
    #Then User enters Email as "<email>" and Password as "<password>"
    #And User clicks login button
    #And User should be on "Dashboard / NopCommerce News"
    #Then User clicks logout
    #And User shoud be on page "Welcome, please sign in!"
    #Then User close the browser
    #Examples: 
      #| email  | password | status  |
      #| admin@yourstore.com | admin | success |
      #| admin@yourstore.com | Admin | Fail    |
