# interview-001 project

## Scenario

The given (and broken) application was provided by a client of us. 

The client told us that one of his subcontractors created this application and messed it up and we should repair and finish the application.

-	Upload the given CSV-File `data\report_1.csv` and write the data to a Database (one line  = one row). Info: The current upload form fits the clients need
-	Provide a REST-Endpoint to find CSV-Entries by its ids
-	Provide a simple REST-Endpoint to fetch all CSV-Entries
-	Do refactoring’s if necessary 

Furthermore, the client told us that the application is not starting at all. Maybe you need to do some fixes before you can start with your work.

---
This project uses Quarkus, the Supersonic Subatomic Java Framework.

If you want to learn more about Quarkus, please visit its website: https://quarkus.io/ .

## Running the application in dev mode

You can run your application in dev mode that enables live coding using:
```
./mvnw compile quarkus:dev
```

After the application has started you can open: http://localhost:8080/

To open the swagger-ui you can open http://localhost:8080/swagger-ui.
