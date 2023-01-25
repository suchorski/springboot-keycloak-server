# Keycloak Server Embedded in a Spring Boot Application

This project provies an embedded [Keycloak](https://www.keycloak.org) server running on a [Spring Boot](https://spring.io/projects/spring-boot) application.

_Based on this post from [Baeldung](https://www.baeldung.com/keycloak-embedded-in-spring-boot-app)._

## Features

- Fully standalone Keycloak server running on embedded Tomcat;
- Added a custom theme with providers only login screen.

## Compatibility

| Version | Java | Keycloak | Spring Boot | RESTEasy | Infinispan |
| - | - | - | - | - | - |
| 1.0.0 | 17 | 18.0.2 | 2.6.5 | 3.15.1.Final | 13.0.8.Final |
| 2.0.0 | 17 | 20.0.1 | 2.7.5 | 4.7.4.Final | 13.0.10.Final |
| 2.2.1 | 17 | 20.0.2 | 2.7.5 | 4.7.7.Final | 14.0.2.Final |
| 2.2.2 | 17 | 20.0.3 | 2.7.7 | 4.7.7.Final | 14.0.4.Final |

## Configurations

You can customize the server by changing the `application.yml` file inside `resources` folder.

## Building

You can clone this repo and build it using the [Maven](https://maven.apache.org/).

```bash
$ git clone https://github.com/suchorski/springboot-keycloak-server
$ cd springboot-keycloak-server
$ mvn package
$ java -jar target/server-2.2.1.jar
```

# Contribution

Feel free to contribute with us.