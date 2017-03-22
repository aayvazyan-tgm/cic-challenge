CIC-Challenge
=============
To run this project execute the following at the project root:
```gradlew bootRun```
To run the tests execute:
```gradlew test```

Available Services:
-------------------
- /getAll
Return returns all saved movies with their filming locations

- /addMovie&title={}&locations={}
Adds a movie to the database

- /getFiltered/{locations}
Displays all movies with the given location

Functionality:
-------------------------
- The file "movieLocationData.json" is added to the database on startup
- A h2 database is used to store and query for movie data
- Spring is used for java EE implementations
- JSONPath is used to query JSON data
