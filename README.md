# Contact Manager Application
---

Contact Manager is a ready application for maintaining contact information.
## Software Requirements
Following is the software requirements to run the application on local
**Java**        : Java 8
**Maven**       : maven-3.0+
**Database**    : Oracle (default), HSQL, MYSQL, DB2 (additional changes required to run with these db)
**Server**      : Jetty (inbuilt)

## Installation
Following Steps mention the process to install and run code on local machine:
  - In git bash, clone the contactApplication code from GitHub
  ```sh
$ git clone https://github.com/dharmjeetk/ContactApplication.git
```
  - If using oracle db modify the following db.properties located in location **_/ContactApplication/src/main/resources/db.properties_**
```sh
connection.url=?
connection.username=?
connection.password=?
```
- If using some other db apart from oracle, following activities must be done
1. Modify the pom.xml file to include the appropriate JDBCDriver jar (**_ContactApplication/pom.xml_**). Any of the supported db which is being used needs to be uncommented in pom.xml file
```
<dependency>
<groupId>com.oracle.ojdbc</groupId>
<artifactId>ojdbc8</artifactId>
<version>${oracle-version}</version>
</dependency>

<dependency>
<groupId>com.ibm.db2</groupId>
<artifactId>db2jcc4</artifactId>
<version>${db2-version}</version>
</dependency>

<dependency>
<groupId>org.hsqldb</groupId>
<artifactId>hsqldb</artifactId>
<version>${hsql-version}</version>
</dependency>

<dependency>
<groupId>mysql</groupId>
<artifactId>mysql-connector-java</artifactId>
<version>6.0.6</version>
</dependency>
```
2. Modify the following db.properties located in location **_/ContactApplication/src/main/resources/db.properties_**
```sh
connection.driver_class=?
connection.url=?
connection.username=?
connection.password=?
hibernate.dialect=?
```
- Execute the ddl script contact.sql located at `ContactApplication\src\test\resources\test-data\sql\ddl\contact.sql` on the db being used.
- Go to project download location where pom.xml is located and open cmd prompt. In cmd prompt type the following command
```sh
$ mvn jetty:run
```
- Go to Chrome or any other browser and type in Address link - http://localhost:8080/contactApp
- To directly access the REST, in Chrome or any other browser or REST api tests (SOAPUI/Postman) type in Address link - http://localhost:8080/contact

# Project Structure
This is maven based project.
1. All required dependencies for project is added in the `pom.xml` file.
2. For domain layer I have used hibernate which allows up to basically use any underlying db with minimal changes for configuration in properties file.
3. Its a spring based application
* Backend code can be found in packages `com.evolent.backend`
* Frontend code can be found in packages `com.evolent.frontend`
* As project is annotation based, all config classes can be found in packages `com.evolent.config`
4. Front end technology is Spring MVC with jsp pages.

__Author__: Dharmjeet Kumar - [Email Id](mailto:kum.dharm9579@gmail.com)
