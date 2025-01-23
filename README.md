# To-Do List Application

This project is a simple web application called "To-Do List" built using **Spring Boot** and **Thymeleaf** for rendering the client-side views. The web app allows users to add, search, delete, and view tasks.

## Technologies

- **Java** 23
- **Spring Boot** 3.3.7
- **Spring Data JPA** for database interaction
- **Thymeleaf** for HTML templating
- **Bootstrap** for frontend styling

## Features

The application provides the following functionality:

- **Add Tasks**: Users can add new tasks by entering a title and clicking "Add task".
- **Delete Tasks**: Tasks can be deleted individually or all tasks can be removed at once.
- **Search Tasks**: Users can search for tasks by their title.
- **Validation**: If a task title is empty, an error message will be shown.

## Project Structure

1. **`ToDoItem` (Model)**: The task entity, which holds an ID and a title for each task.
2. **`ToDoItemRepository` (Repository)**: Interface for interacting with the database using JPA.
3. **`ToDoController` (Controller)**: Handles user requests (adding, deleting tasks, searching).
4. **`TodoApplication` (Main application class)**: Boots up the Spring Boot application.

## Running the Project

### 1. Clone the Repository

```
git clone https://github.com/your-username/todoapp.git
cd todoapp
```
### 2. Build and Run the Application
This project uses Maven for dependency management. To build and run the project, execute the following command:
```
mvn spring-boot:run
The application will be available at:
http://localhost:8080
```
### 3. Database Structure
The application uses HSQLDB as an embedded in-memory database. All tasks are stored in memory and will be lost upon restarting the application.

## File Descriptions
### 1. ToDoController.java
The controller handles the following routes:

GET /: Displays the list of all tasks.
POST /add: Adds a new task.
POST /delete/{id}: Deletes a task by ID.
POST /deleteAll: Deletes all tasks.
POST /search: Searches tasks by the provided search term.
### 2. ToDoItem.java
A model for a task with two fields:
id: The unique identifier for the task (auto-generated).
title: The title of the task.
```
@Entity
public class ToDoItem {
    @Id
    @GeneratedValue
    private Long id;
    private String title;
}
```
### 3. application.properties
Configuration file for setting application properties.
```
spring.application.name=todoapp
```
### 4. pom.xml
Main configuration file for Maven, which includes all dependencies for Spring Boot, Thymeleaf, JPA, and other libraries.

### 5. HTML Template
The application uses Thymeleaf to render HTML pages. The template displays a form for adding tasks, a list of tasks, and forms for deleting tasks.

## Possible Improvements
User Authentication: Add user registration and login functionality.
Task Due Dates: Add support for setting due dates for tasks.
External Database Support: Use an external database like MySQL or PostgreSQL for persistent storage.

Contact
If you have any questions or suggestions, feel free to contact me:

Email: rustiksagad@gmail.com
GitHub: https://github.com/RustamLee
