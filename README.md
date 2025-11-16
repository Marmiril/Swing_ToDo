Gestor de Tareas (Java)

Aplicación sencilla de gestión de tareas desarrollada en Java.
Incluye organización básica del proyecto, clases separadas y uso de JOptionPane para interactuar con el usuario.

Funcionalidades:
* Añadir tareas (título, descripción, fecha)
* Listar tareas (pendientes y completadas)
* Marcar tareas como completadas
* Editar tareas existentes
* Eliminar tareas
* Validación de entrada mediante MsgHelper

Estructura del Proyecto
/src
   /Taskapp.java      → Lógica principal y menú
   /TaskItem.java     → Entidad Tarea (propiedades y estado)
   /MsgHelper.java    → Utilidades de entrada y salida

Requisitos:
- Java 17 o superior
- Cualquier IDE (NetBeans, IntelliJ, VS Code) o ejecución por consola

Ejecutar
Compilar:
- javac Taskapp.java
Ejecutar:
- java Taskapp

Notas
Este proyecto forma parte del proceso de aprendizaje de Java desde C#, manteniendo una estructura clara y progresiva.

====================================================================================================================

Task Manager (Java)

A simple task manager built in Java using basic OOP, lists, and console interaction.
The project focuses on clean structure, modular helpers, and step-by-step workflow.

Features:
* Add tasks (title, description, due date)
* List tasks (pending / completed)
* Mark tasks as completed
* Edit existing tasks
* Delete tasks
* Input validation and helper utilities (via MsgHelper)
* Persistent storage through CSV (if implemented)

Project Structure
/src
   /Taskapp.java      → Main application and menu logic
   /TaskItem.java     → Task entity (fields, getters/setters, status)
   /MsgHelper.java    → Input/output helpers (JOptionPane)

Requirements:
- Java 17+ (recommended)
- Any IDE (NetBeans, IntelliJ, VS Code) or command-line compilation

How to Run
Compile:
- javac Taskapp.java
Run:
- java Taskapp

Notes
This project is part of a learning path transitioning from C# to Java, focusing on clean code and progressive improvement.
