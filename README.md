# LAB-BOOKING-ATTENDANCE
**How to Setup local MYSQL for the web application for Local Testing** 
MYSQL configurations : follow the table name, user name and password is all on *application.properties* file. Run the application using *springbootLrun* option. (Maven clean install is recommended). Then access the website through [here] (http://localhost:8080)

Example setup in application.properties 

```java
spring.jpa.hibernate.ddl-auto=update
spring.datasource.url=jdbc:mysql://localhost:3306/db_amigos
spring.datasource.username=spring
spring.datasource.password=ThePassword
```
