# 📋 TODO List Manager - Java

A simple console-based TODO List application built with **Java** using a **Doubly Linked List** data structure.

## 📌 Features

- ➕ **Add Task** - Create new tasks with details
- ❌ **Delete Task** - Remove tasks by ID
- 📝 **Update Task** - Modify task information
- 🔍 **Search Task** - Find tasks by name
- 📋 **Display Tasks** - View all tasks

## 🛠️ Tech Stack

- **Language:** Java
- **Data Structure:** Doubly Linked List
- **Type:** Console Application

## 📂 Project Structure
```
TODO-List-Java/
├── TODO_LIST.java    # Main program with operations
└── Node.java         # Node class for linked list
```

## 🚀 How to Run

### Prerequisites
- Java JDK 8 or higher

### Steps

1. **Clone or download the project**
```bash
git clone https://github.com/Gurmeet788/TODO-List-Java.git
cd TODO-List-Java
```

2. **Compile the files**
```bash
javac TODO_LIST.java Node.java
```

3. **Run the program**
```bash
java TODO_LIST
```

## 💻 Usage

When you run the program, you'll see this menu:
```
Enter what you want to do from below:
AddTask:
DeleteTask:
DisplayTask:
Update:
Search:
Exit:
```

### Available Operations

| Command | Description |
|---------|-------------|
| `AddTask` | Add a new task |
| `DeleteTask` | Delete task by ID |
| `DisplayTask` | Show all tasks |
| `Update` | Modify existing task |
| `Search` | Find task by name |
| `Exit` | Close the program |

## 📝 Task Information

Each task contains:
- **Task ID** - Unique identifier
- **Task Name** - Task title
- **Description** - Task details
- **Due Date** - Deadline (dd-MM-yyyy)
- **Priority** - LOW | MEDIUM | HIGH
- **Status** - PENDING | COMPLETED | PROCESSING

## 🎯 Example Usage

### Add a Task
```
Enter what you want to do: AddTask
Enter taskId: 1
Enter Task Name: Complete Assignment
Enter Description: Finish Java project
Enter Due Date (dd-MM-yyyy): 31-12-2024
Enter Priority (LOW | MEDIUM | HIGH): HIGH
Enter Status (PENDING | COMPLETED | PROCESSING): PENDING
```

### Display Tasks
```
Enter what you want to do: DisplayTask

Task ID: 1
Task Name: Complete Assignment
Description: Finish Java project
Due Date: 31-12-2024
Priority: HIGH
Status: PENDING
-----------------------
```

### Update a Task
```
Enter what you want to do: Update
Enter taskId: 1

Enter your choice what you want to update:
Full:
taskId:
taskName:
description:
dueDate:
priority:
status:
Exit:

Choice: status
Enter new status: COMPLETED
```

### Search for a Task
```
Enter what you want to do: Search
Enter taskName: Complete Assignment

Task ID: 1
Task Name: Complete Assignment
Description: Finish Java project
Due Date: 31-12-2024
Priority: HIGH
Status: COMPLETED
-----------------------
```

### Delete a Task
```
Enter what you want to do: DeleteTask
Enter taskId: 1
Task deleted successfully!
```

## 🔧 Code Features

- **Doubly Linked List** implementation
- **Mid-pointer search** technique for finding tasks
- Simple menu-driven interface
- Full CRUD operations

## 📖 Learning Topics

This project demonstrates:
- Doubly Linked List operations
- Node insertion and deletion
- List traversal
- Search algorithms
- Console I/O in Java

## 🐛 Known Issues

- Search works best when tasks are sorted by name
- No data persistence (tasks lost after exit)

## 🚀 Future Improvements

- [ ] Save tasks to file
- [ ] Auto-sort tasks by priority
- [ ] Input validation
- [ ] Better error handling
- [ ] GUI version

## 👨‍💻 Author

**Your Name**
- GitHub: [@Gurmeet788](https://github.com/Gurmeet788)


## ⭐ Support

If you found this helpful, please give it a ⭐!

---

Made with ☕ and Java
