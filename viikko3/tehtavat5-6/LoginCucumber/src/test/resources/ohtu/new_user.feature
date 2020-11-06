Feature: A new user account can be created if a proper unused username and password are given

    Scenario: creation is successful with valid username and password
        Given command new is selected
        When  username "ossi" and password "salainen33" are entered
        Then  system will respond with "new user registered"

    Scenario: creation fails with already taken username and valid password
        Given command new is selected
        When  username "ossi" and password "salainen33" are entered
        And command new is selected
        And username "ossi" and password "salainen33" are entered
        Then system will respond with "new user not registered"
    
    Scenario: creation fails with too short username and valid password
        Given command new is selected
        When  username "a" and password "salainen33" are entered
        Then  system will respond with "new user not registered"

    Scenario: creation fails with valid username and too short password
        Given command new is selected
        When  username "ossi" and password "3sssss" are entered
        Then  system will respond with "new user not registered"

     Scenario: creation fails with valid username and password long enough but consisting of only letters
        Given command new is selected
        When  username "ossi" and password "aaaaaaaaaaaaaaaaaaaa" are entered
        Then  system will respond with "new user not registered"

     Scenario: can login with successfully generated account
        Given command new is selected
        And  username "ossi" and password "salainen33" are entered
        And   command login is selected
        When  username "ossi" and password "salainen33" are entered
        Then  system will respond with "logged in"