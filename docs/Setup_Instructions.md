# Setup Instructions

## JDK Version Used

This project uses JDK 21. A typical verification command is:

```powershell
java -version
javac -version
```

## Hello World Check

To confirm Java is installed correctly, create a small file such as `HelloWorld.java` with a `main` method that prints `Hello, World!`, then run:

```powershell
javac HelloWorld.java
java HelloWorld
```

If the terminal prints `Hello, World!`, the JDK, compiler, and runtime are working correctly.

## Compile and Run LearnTrack

From the project root:

```powershell
New-Item -ItemType Directory -Force out
javac -d out src\com\airtribe\learntrack\entity\*.java src\com\airtribe\learntrack\exception\*.java src\com\airtribe\learntrack\util\*.java src\com\airtribe\learntrack\service\*.java src\com\airtribe\learntrack\ui\*.java
java -cp out com.airtribe.learntrack.ui.Main
```
