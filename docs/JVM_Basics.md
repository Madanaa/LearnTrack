# JVM Basics

## JDK, JRE, and JVM

JDK stands for Java Development Kit. It is the full toolkit used by developers to write, compile, and run Java programs. It includes tools like `javac` and also contains the JRE.

JRE stands for Java Runtime Environment. It provides the libraries and runtime support needed to execute Java applications, but it does not include development tools like the compiler.

JVM stands for Java Virtual Machine. It is the engine that reads Java bytecode and runs it on a specific operating system.

## What Is Bytecode?

When a Java source file is compiled, the compiler converts it into bytecode stored in `.class` files. Bytecode is not tied to a single operating system, which is why the same compiled program can run on different platforms that have a compatible JVM.

## Write Once, Run Anywhere

The phrase "write once, run anywhere" means a developer writes Java code one time and compiles it into bytecode. That bytecode can then be executed on Windows, Linux, or macOS without rewriting the program.

This works because each platform provides its own JVM implementation. The JVM handles the platform-specific work, so the Java program can stay the same.
