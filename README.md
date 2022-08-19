# Kahfy Shop

## About
Before moving into software development, I worked at a coffee shop for a little over three years. As a huge coffee lover, I thought it would be appropriate to base my capstone project on a generic coffee rewards system. Kahfy serves as a general OSS (Online Shopping System). A member of the Kahfy Shop can login or create their own account. Once they are logged in, they can browse through the different products and add whichever items they want to their cart. In their cart, they can edit the quantity of each particular item that they want, and decide to apply their rewards on certain products to reduce the total price, assuming they have enough rewards. Once they are satisfied with the fields of their purchase, they are able to checkout with the items, and their account details (amount of rewards) are updated accordingly.

## Tech Stacks
For this project, I had two separate projects encompassing three types of users that might enter the site: <br/><br/>
&emsp;Project 1: Administrators and B2B Users (Spring Boot, Spring Security, Maven, REST, Thymeleaf) <br/>
&emsp;&emsp;- In this project, administrators are able to perform full CRUD functionality on the two assets of Kahfy Shop: the members and the products. B2B Users can find their own portal, where they can access the API for Kahfy Shop Members and Kahfy Shop Products, in the form of JSON files. <br/><br/>
&emsp;Project 2: General Members (Spring MVC, Hibernate, JDBC, HTML, CSS, JavaScript, Bootstrap) <br/>
&emsp;&emsp;- In this project, general members are able to login or create their own account. Once logged in, members are able to add products to their carts, edit the quantites and apply rewards to each product, and checkout of the system. <br/><br/>
&emsp;Background: Database and Unit Testing (MySQL, JUnit) <br/>
&emsp;&emsp;- In the background, I have MySQL running my database, and JUnit testing the functionality of my repositories. <br/>
   
## User Stories
As a coffee shop member conscious of my spending habits and possible ways to save, I would like to see all products listed, with prices and rewards listed alongside each.

As a coffee shop member making a purchase, I would like to be able to add to, edit, and delete from my shopping cart.

As a coffee shop member concerned about the details about how my hard-earned rewards can be efficiently spent, I would like to see a live-updating review of everything in my shopping cart, and how my rewards can affect the price of my total purchase.

## Challenges
One challenge that I faced was dealing with Spring Security for the general member. I was able to configure Spring Security to validate inputted emails and passwords with fields in the database, but with time constraints, focused all of my Spring Security setup on a hard-coded admin login, leaving more time to deal with other aspects of my project. With more time, I believe I could figure out the technicalities of assigning roles and authorization for specific kinds of users to different parts of the site.
