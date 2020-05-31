# interview-001 project

## Szenario

The given (and broken) application was provided by a client of us. 

The client told us that one of his subcontractors create this application and messed it up and we should repair and finish the application.

-	Upload the given CSV-File `data\report_1.csv` and write the data to a Database (one line  = one row). Info: The current upload form fits the client needs
-	Provide a REST-Endpoint to find CSV-Entries by its ids
-	Provide a simple REST-Endpoint to fetch all CSV-Entries
-	Do refactoring’s if necessary 


This project uses Quarkus, the Supersonic Subatomic Java Framework.

If you want to learn more about Quarkus, please visit its website: https://quarkus.io/ .

## Running the application in dev mode

You can run your application in dev mode that enables live coding using:
```
./mvnw compile quarkus:dev
```

After the application has started you should visit: http://localhost:8080/
