# AICalculatorApp

AICalculatorApp is a small Java and Maven application used for practical deployment activities in the ICTPRG534 learner guide.

The project supports Chapters 1 to 8 of the manual. It gives learners a completed application that can be opened, checked, built, packaged, versioned, configured, tested, removed and rebuilt without spending the unit writing a large application from scratch.

## Practical scope

The project supports hands-on activities including:

- Opening the source project in Visual Studio Code or IntelliJ IDEA
- Checking Java, Maven and Git from the terminal
- Building the application with Maven
- Running the packaged JAR file
- Creating release folders and ZIP artefacts
- Using Git tags such as v0.1, v0.2 and v0.3
- Checking database scripts and seed data
- Running with Development, Test, Train and Production-style configuration files
- Testing uninstall scripts and retained release artefacts
- Supporting rollback and rebuild practice

## Project structure

```text
AICalculatorApp/
├── pom.xml
├── src/main/java/au/training/calculator/App.java
├── src/main/java/au/training/calculator/AppV02Example.java
├── config/
│   ├── application-dev.properties
│   ├── application-test.properties
│   ├── application-train.properties
│   └── application-prod.properties
└── database/
    ├── schema-v0.1.sql
    └── seed-v0.1.sql
```

## Build the package

Run this command from the project root folder:

```bash
mvn clean package
```

Expected package file:

```text
target/ai-calculator-1.0.jar
```

## Run the packaged application

```bash
java -jar target/ai-calculator-1.0.jar
```

Expected base output:

```text
AI Calculator v0.1
2 + 3 = 5
10 - 4 = 6
5 x 6 = 30
20 / 4 = 5
```

## Run with a configuration file

```bash
java -jar target/ai-calculator-1.0.jar --config=config/application-test.properties
```

Expected configuration output includes:

```text
Environment: Test
Database: database/test-db/aicalculator-test.db
Security mode: test
Debug enabled: false
```

## Database scripts

Apply the schema script first, then the seed script:

```bash
sqlite3 database/test-db/aicalculator-test.db < database/schema-v0.1.sql
sqlite3 database/test-db/aicalculator-test.db < database/seed-v0.1.sql
sqlite3 database/test-db/aicalculator-test.db "SELECT app_name, version, release_status FROM release_info;"
```

Expected result:

```text
AICalculatorApp|v0.1|Ready for test
```

## Security note

The production-style configuration uses placeholder values only. Do not commit live credential values to this repository.
