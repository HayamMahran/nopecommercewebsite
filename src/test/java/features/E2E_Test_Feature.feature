 Feature: Automate End-to-End Tests
    I want to Test the integration of the website
     
   Scenario Outline: Customer place an order by purchasing an item from search
   Given the user is on the home page
   When he search for "<productname>"
   And choose to buy 2 items
   And moves to checkout cart and enter personal details on checkout page and place the order
   Then he can view the order and download the invoice
   
   Examples: 
   
   |productname|
   |Apple MacBook Pro 13-inch|
   