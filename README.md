# AICalculatorApp

AICalculatorApp is a small Java and Maven application used for deployment practice activities in a learner guide.

The project is intentionally simple so learners can focus on practical deployment work, including building, packaging, testing, versioning and publishing release artefacts.

## Project purpose

This project supports practical activities such as:

- Opening a completed Java project in an editor or IDE
- Checking the Maven project structure
- Building the application with Maven
- Creating a packaged JAR file
- Running the packaged application from the terminal
- Preparing release folders such as v0.1
- Pushing source code to GitHub
- Creating release artefacts for deployment practice

## Project structure

AICalculatorApp/
- pom.xml
- src/main/java/au/training/calculator/App.java

## Build the package

Run this command from the project root folder:

mvn clean package

The package output will be created in the target folder.

Expected package file:

target/ai-calculator-1.0.jar

## Run the packaged application

Run this command from the project root folder after building:

java -jar target/ai-calculator-1.0.jar

Expected output:

AI Calculator v0.1
2 + 3 = 5
10 - 4 = 6
5 x 6 = 30
20 / 4 = 5

## Release version

The first learner-guide release version is v0.1.

Generated folders such as target/ should not be committed as source code. They can be recreated by running the Maven build command.
