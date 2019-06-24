## Pawpals  
**Version**: 1.0.0  

## Authors 
- Chai.Narukulla
- Timothy J Busch
- Kent Ketter
- Peter Tynan

## Overview and User Stories

- As a user i should be able to create/update my profile 
- As a user, I want to be able to create a pet profile and add automatically have it associated my profile.
- As a user, I want to be able to give reviews of other pets and users that I’ve had contact with.
- As a user, I want to look at the profiles of other users and their dogs.
- As a user, I want a way to show my time availability on my profile.
- As a user, I want the app to signal at the end of a playdate to add a review to the:
  - Petowner
  - Person having the playdate
- As a user, not logged in, I want to see images of the 


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