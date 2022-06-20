# AS Take Home Assessment

This project consists of two parts: a backend Rest API, and a frontend application. Each one is going to be detailed below.

## Backend

The backend is a simple REST API that is going to be used by the frontend to communicate with the backend. It's where the main logic of the application is implemented.

This project was generated following the [Spring Boot](https://spring.io/projects/spring-boot) instructions, by using the [Spring Boot Start](https://start.spring.io/).

Installed prerequisites to run the backend:

- [Java 1.8](https://www.java.com/en/download/)
- [Maven](https://maven.apache.org/)


> Further information about the setting up the local environment can be found [here](https://docs.spring.io/spring-boot/docs/current/reference/html/getting-started.html).


### Development server

On the root folder, run `mvn spring-boot:run` for a dev server. Navigate to `http://localhost:8080/`. 

To see the API documentation, built by using [Swagger](https://swagger.io/), navigate to `http://localhost:8080/swagger-ui/#/`.

### Build

On the root folder, run `mvn clean package` to build the project. The build artifacts will be stored in the `target/` directory.

### Running unit tests

Run `mvn clean test` to execute the unit tests

### Further help

To get more help on the Spring Boot check out the [Spring Boot Page](https://spring.io/projects/spring-boot).


## Frontend

This project was generated following the [Angular Get Started Instructions](https://angular.io/start#create-the-sample-project), being a [StackBlitz sample](https://angular.io/generated/live-examples/getting-started-v0/stackblitz.html)

Installed prerequisites to run the backend:
- [Node.js](https://nodejs.org/)
- [Npm](https://www.npmjs.com/)

> Further information about the setting up the local environment can be found [here](angular.io/guide/setup-local)

## Development server

Run `npm run start:local` for a dev server. Navigate to `http://localhost:4200/`. The app will automatically reload if you change any of the source files.

## Build

Run `npm run build` to build the project. The build artifacts will be stored in the `dist/` directory.

## Running unit tests

Run `npm run test` to execute the unit tests via [Karma](https://karma-runner.github.io).

## Further help

To get more help on the Angular CLI use `npm help` or check out the [Angular Page](https://angular.io/).
