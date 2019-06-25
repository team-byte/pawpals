## Pawpals  
**Version**: 1.1.0  

## Authors 
- Chai Narukulla
- Timothy J Busch
- Kent Ketter
- Peter Tynan
- Stephen Chu

## Overview and User Stories

- As a new user, I should be able to create a new profile with a user name and password selected by me.
- As a registered user, I should be able to update my profile.
- As a registered user, I want to be able to create a pet profile and automatically have it associated my user profile.
- As a registered user, I want to be able to delete a pet profile and have all instances of the pet removed from PawPals.
- As a registered user, I want to be able to review other pets and users that I’ve had contact with.
- As a registered user, I want to look at the profiles of other users and their pets.
- As a registered user, I want a way to show my time availability on my profile.
- As a non registered user I want to see the login page and pet image carosel. 


## API

- ```"/"```
    - default page is the login page
- ```/login```
    - users can login
- ```/signup```
    - user can sign up when visiting for the first time
- ```/users```
    - display the users based on username
-  ```/myprofile```
    - shows the individual profile of a user
- ```details```
    - see the details of a user when clicking



## Getting Started

Clone this repository to your local machine.
```git clone https://github.com/team-byte/pawpals.git```

Once downloaded, change directory into the `pawpals` directory.
```
$ cd pawpals
```
- IntelliJ
    - open pawpals.java
    - run pawpalsApplication.java 
- Terminal
    - ```psql CREATE DB pawpals;```
    - ```./gradlew test```
    
    - build and run ```./gradlew bootRun```



### Reference Documentation
For further reference, please consider the following sections:

* [Official Gradle documentation](https://docs.gradle.org)

### Guides
The following guides illustrate how to use some features concretely:

* [Accessing Data with JPA](https://spring.io/guides/gs/accessing-data-jpa/)
* [Building a RESTful Web Service](https://spring.io/guides/gs/rest-service/)
* [Serving Web Content with Spring MVC](https://spring.io/guides/gs/serving-web-content/)
* [Building REST services with Spring](https://spring.io/guides/tutorials/bookmarks/)
* [Securing a Web Application](https://spring.io/guides/gs/securing-web/)
* [Spring Boot and OAuth2](https://spring.io/guides/tutorials/spring-boot-oauth2/)
* [Authenticating a User with LDAP](https://spring.io/guides/gs/authenticating-ldap/)

### Additional Links
These additional references should also help you:

* [Gradle Build Scans – insights for your project's build](https://scans.gradle.com#gradle)

## License

This project is licensed under the MIT License - see the [LICENSE.md](LICENSE.md) file for details