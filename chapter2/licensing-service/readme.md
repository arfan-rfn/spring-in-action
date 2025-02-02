# Project Name

Brief description of your project and its main purpose.

## Table of Contents

- [Project Name](#project-name)
	- [Table of Contents](#table-of-contents)
	- [Prerequisites](#prerequisites)
	- [Installation](#installation)

## Prerequisites

- Java 17
  ```bash
  java --version
  ```
- Maven 3.6+ (for building and testing)
  ```bash
  mvn --version
  ```

## Installation

1. Clone the repository

   ```bash
   git clone {repository-url}
   cd {project-name}
   ```

2. Build the project

   ```bash
   mvn clean install
   ```

   Dependency tree

   ```bash
   mvn dependency:tree
   ```

3. Run the application

   ```bash
   mvn spring-boot:run
   ```

4. Run the tests

   ```bash
   mvn test
   ```

   Running JUnit tests for AllPersonInfoTest

   ```bash
   mvn test -Dtest=AllPersonInfoTest
   ```

   Running JUnit tests for OrganizationReportTest

   ```bash
   mvn test -Dtest=OrganizationReportTest
   ```
