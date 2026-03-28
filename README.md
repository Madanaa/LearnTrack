# LearnTrack

LearnTrack is a console-based Student and Course Management System built with Core Java. It is designed to practice Java fundamentals such as packages, classes, constructors, encapsulation, inheritance, polymorphism, collections, static members, and basic exception handling.

## Features

- Manage students, including add, update, search, list, and deactivate actions.
- Manage courses, including add, update, search, list, activate, and deactivate actions.
- Manage enrollments, including create, list, student-wise view, and status updates.
- Store all data in memory using `ArrayList`.
- Handle invalid input and missing entities with user-friendly messages.

## Project Structure

- `src/com/airtribe/learntrack/entity` for entity classes and enum types.
- `src/com/airtribe/learntrack/service` for business logic and in-memory storage.
- `src/com/airtribe/learntrack/ui` for the menu-driven console application.
- `src/com/airtribe/learntrack/exception` for custom exceptions.
- `src/com/airtribe/learntrack/util` for static utility helpers.
- `docs` for setup notes, JVM basics, and design notes.

## How to Compile

From the project root:

```powershell
New-Item -ItemType Directory -Force out
javac -d out src\com\airtribe\learntrack\entity\*.java src\com\airtribe\learntrack\exception\*.java src\com\airtribe\learntrack\util\*.java src\com\airtribe\learntrack\service\*.java src\com\airtribe\learntrack\ui\*.java
```

## How to Run

```powershell
java -cp out com.airtribe.learntrack.ui.Main
```

## Documentation

- [Setup Instructions](docs/Setup_Instructions.md)
- [JVM Basics](docs/JVM_Basics.md)
- [Design Notes](docs/Design_Notes.md)
