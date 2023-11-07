# API made with Spring and Hibernate

## IMPORTANT NOTES
- This is a backend project for learning purposes, made with the help of a Udemy course, it does not have o frontend yet.
- It uses the "Repository Pattern" rather than the "DAO pattern".
- There are multiple profiles, `test` uses h2 as the database, using any other profile you will have to set the PostgreSQL database and it's credentials under `env.properties` in the resources folder. For instance:
```
POSTGRESQL_USER=my_user
POSTGRESQL_PASSWORD=my_password
```
- To run the project, simply run `./mvnw spring-boot:run`.