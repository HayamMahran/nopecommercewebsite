Feature: User Registration
   I want to check that the user can register in our e-commerce website
   
   
    Scenario Outline: User Registration
    Given the user in the home page
    When I click on register link
    And I entered "<firstname>" , "<lastname>" , "<email>" , "<password>"
    Then the registration page displayed successfully 
    
    Examples:
    | firstname | lastname | email | password |
    | Hayam | Mahran | hayammah@text.com | 123456789 |
    
    