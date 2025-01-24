import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class TODO_LIST {

    Node head;
    Node current;
    public static void main(String[] args) {
        TODO_LIST todo_LIST = new TODO_LIST();

        while (true) {
            
        
        System.out.println("Enter what you want to do from blow\nAddTask:\nDeleteTask:");
        Scanner scanner = new Scanner(System.in);
        String choise = scanner.nextLine();

        switch (choise) {
            case "AddTask":
                todo_LIST.addTask(todo_LIST.head);
                break;
            case "DeleteTask":
                 System.out.println("Enter taskId:");
                 int taskId = scanner.nextInt();
                 todo_LIST.DeleteTask(null,taskId);
            default:
                System.out.println("Invalid");
                break;
        }

    }
    }

    public void addTask(Node head) {
        // Declare variables for task details
        int taskId;
        String taskName;
        String description;
        DateTimeFormatter format = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        LocalDate dueDate;
        String dateString;
        String priority;
        String status;
    
        // Create a Scanner to read input
        Scanner scanner = new Scanner(System.in);
    
        System.out.println("Enter the new task details:");
    
        System.out.print("Enter taskId: ");
        taskId = scanner.nextInt();
        scanner.nextLine(); // Consume newline character
    
        System.out.print("Enter Task Name: ");
        taskName = scanner.nextLine();
    
        System.out.print("Enter Description: ");
        description = scanner.nextLine();
    
        System.out.print("Enter Due Date (dd-MM-yyyy): ");
        dateString = scanner.nextLine();
        dueDate = LocalDate.parse(dateString, format);
    
        System.out.print("Enter Priority (LOW | MEDIUM | HIGH): ");
        priority = scanner.nextLine();
    
        System.out.print("Enter Status (PENDING | COMPLETED | PROCESSING): ");
        status = scanner.nextLine();
    
        // Create a new Node with the entered details
        Node newTask = new Node(taskId, taskName, description, dueDate, priority, status);
    
        // Check if the list is empty
        if (head == null) {
            head = newTask; // If empty, newTask becomes the head
        } else {
            // Traverse to the end of the list
            Node tail = head;
            while (tail.getNext() != null) {
                tail = tail.getNext();
            }
            // Link the newTask to the list
            tail.setNext(newTask);
            newTask.setPrev(tail);
        }
        this.current = newTask;
        this.head = head;
    }
    

    public  void DeleteTask(Node head, int taskId){

        Node temp = head;

        if (taskId == 1) {

            temp.getNext().setPrev(temp.getPrev());
            temp.setNext(null);

            this.head = temp;

        }
        while (temp.getTaskId() != taskId) {

            temp = temp.getNext();
        }
        if (temp.getNext() == null) {
            
            current = temp.getPrev();
            temp.getPrev().setNext(temp.getNext());
            temp.setPrev(null);

            this.head = head;
        }

        temp.getNext().setPrev(temp.getPrev());
        temp.getPrev().setNext(temp.getNext());
        temp.setNext(null);
        temp.setPrev(null);

        this.head = head;
    }


    public static void displayTasks(Node head) {
        if (head == null) {
            System.out.println("No tasks to display. The list is empty.");
            return;
        }
    
        Node current = head;
        while (current != null) {
            System.out.println("Task ID: " + current.getTaskId());
            System.out.println("Task Name: " + current.getTaskName());
            System.out.println("Description: " + current.getDescription());
            System.out.println("Due Date: " + current.getDueDate());
            System.out.println("Priority: " + current.getPriority());
            System.out.println("Status: " + current.getStatus());
            System.out.println("-----------------------");
            current = current.getNext();
        }
    }
    

    public static boolean isEmpty(Node head){

        if (head == null) {
            
            return true;
        }
        return false;
    }
}