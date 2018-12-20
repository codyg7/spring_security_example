# spring-security-example

## Files of interest Needed

* config/SeedData.java - create some users at runtime add give them some roles. look into this file to see the valid users you have to work with. admin, clerk, and accountant are all users with different roles. they all share the password of "password"
* config/SecurityConfiguration.java - Where routes require authentication and what roles can access what routes
* controllers/UserModelAdvice.java - makes sure that if we have a logged in user it is always passed to our view as a property called user
* models/Role.java - manages roles related to a user. Also an example of a relationship here between the User model
* models/User.java - the model that represents a user
* services/* - Files used for handling authentication for user and getting users from the database. No need to edit these
* templates/common/_nav.html - has good example code to check if a user is logged in
* templates/home/default.html is the homepage


