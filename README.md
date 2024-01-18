# Keycloak Server Embedded in a Spring Boot Application

This project provies an embedded [Keycloak](https://www.keycloak.org) server running on a [Spring Boot](https://spring.io/projects/spring-boot) application.

_Based on this post from [Baeldung](https://www.baeldung.com/keycloak-embedded-in-spring-boot-app)._

## Features

- Fully standalone Keycloak server running on embedded Tomcat;
- Added a custom theme with providers only login screen.

## Compatibility

| Version | Java | Keycloak | Spring Boot | RESTEasy | Infinispan | Liquibase |
| - | - | - | - | - | - | - |
| 4.0.0 | 17 | 22.0.5 | 3.1.5 | 6.2.4.Final | 14.0.19.Final | 4.23.2 |
| 5.0.0 | 17 | 23.0.3 | 3.2.0 | 6.2.4.Final | 14.0.21.Final | 4.23.2 |
| 5.0.1 | 17 | 23.0.4 | 3.2.1 | 6.2.4.Final | 14.0.21.Final | 4.23.2 |

* Removed older versions from compatibility table keeping last 2 major version. For olders, check the [tags](https://github.com/suchorski/springboot-keycloak-server/tags) section.

## Configurations

You can customize the server by changing the `application.yml` file inside `resources` folder.

## Building

You can clone this repo and build it using the [Maven](https://maven.apache.org/).

```bash
$ git clone https://github.com/suchorski/springboot-keycloak-server
$ cd springboot-keycloak-server
$ mvn package
$ java -jar target/server-5.0.1.jar
```

# Contribution

Feel free to contribute with us.
