
# JVM Basics

## What is JDK, JRE, JVM?

### JDK (Java Development Kit)
JDK is a complete package used for Java development. It includes tools like compiler (javac), debugger, and JRE. Developers use JDK to write and run Java programs.

### JRE (Java Runtime Environment)
JRE provides the environment to run Java programs. It includes JVM and standard libraries required to execute Java code.

### JVM (Java Virtual Machine)
JVM is a virtual machine that runs Java bytecode. It converts bytecode into machine-specific instructions so that the program can run on any system.

---

## What is Bytecode?

When a Java program is compiled using `javac`, it is converted into bytecode (.class file).  
Bytecode is platform-independent and can run on any system that has a JVM.

---

## What is "Write Once, Run Anywhere"?

Java follows the principle "Write Once, Run Anywhere".

It means:
- You write Java code once.
- Compile it into bytecode.
- The same bytecode can run on any operating system (Windows, Linux, Mac) using JVM.

This is possible because JVM acts as a bridge between Java code and the operating system.