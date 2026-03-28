# Design Notes

## Why `ArrayList` Instead of Array

`ArrayList` was used because the number of students, courses, and enrollments changes while the program runs. Arrays have a fixed size, so adding or removing records becomes harder and requires manual resizing logic. `ArrayList` keeps the code simpler and is a better fit for a menu-driven CRUD application.

## Where Static Members Were Used

Static members were used in `IdGenerator`. The counters for student IDs, course IDs, and enrollment IDs are shared across the application, so static fields and static methods are appropriate. This also avoids duplicating ID logic in each service class.

## Where Inheritance Was Used

Inheritance was used by making `Student` extend `Person`. An optional `Trainer` class also extends `Person` to demonstrate reuse further. This avoids repeating common fields like `id`, `firstName`, `lastName`, and `email`.

## What Was Gained From Inheritance

The shared behavior in `Person`, especially `getDisplayName()`, can be reused and then specialized in child classes through method overriding. This gives a simple example of polymorphism while keeping the code easy to read for beginners.
