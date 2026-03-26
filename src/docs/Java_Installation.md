# Java Installation Guide

This document explains how to install and configure Java (JDK) on a system.

---

## Step 1: Download JDK

You can download JDK from:

- Oracle Official Website: https://www.oracle.com/java/technologies/downloads/
- OpenJDK: https://jdk.java.net/

Download the latest stable version (JDK 21).

---

## Step 2: Install JDK

1. Run the downloaded installer.
2. Follow the installation steps.
3. Note the installation path (e.g., C:\Program Files\Java\jdk-21).

---

## Step 3: Set Environment Variables (Windows)

### 1. Set JAVA_HOME

1. Open **System Properties**
2. Click on **Environment Variables**
3. Under System Variables → Click **New**
    - Variable Name: JAVA_HOME
    - Variable Value: Path of JDK installation  
      Example: C:\Program Files\Java\jdk-21

---

### 2. Update PATH Variable

1. Find the `Path` variable under System Variables
2. Click **Edit**
3. Add new entry:


---

## Step 4: Verify Installation

Open Command Prompt or Git Bash and run:

```bash id="w0sk4l"
java -version