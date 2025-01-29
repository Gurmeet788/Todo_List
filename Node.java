import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;
public class Node {

    private int taskId;
    private String taskName;
    private String description;
    private LocalDate dueDate;
    private String priority;
    private String status;
    private Node next;
    private Node prev;

    

    public Node() {
    }

    public Node(int taskId, String taskName, String description, String dueDate, String priority, String status,
            Node next, Node prev) {

                setTaskId(taskId);
                setTaskName(taskName);
                setDescription(description);
                setDueDate(dueDate);
                setPriority(priority);
                setStatus(status);
        this.next = next;
        this.prev = prev;
    }

    public Node(int taskId, String taskName, String description, String dueDate, String priority,
            String status) {
                setTaskId(taskId);
                setTaskName(taskName);
                setDescription(description);
                setDueDate(dueDate);
                setPriority(priority);
                setStatus(status);
    }

    public int getTaskId() {
        return taskId;
    }

    public void setTaskId(int taskId) {

        while (true) {

        try {

            if (taskId <= 0) {
                throw new IllegalAccessError("The taskId is neg it is invalid Type again:");
            }

            this.taskId = taskId;

            break;

        } catch (IllegalAccessError e) {

            System.out.println("---------------------------------");
            System.out.print("Error:" + e.getMessage());
            Scanner sc = new Scanner(System.in);
            taskId = sc.nextInt();
            System.out.println("---------------------------------");
        }
    }
    }

    public String getTaskName() {
        return taskName;
    }

    public void setTaskName(String taskName) {

        while (true) {
        try {
            
            if (taskName == null || taskName.trim().isEmpty()) { // if name is null or just space than throw error message
                 
                throw new IllegalArgumentException("You donot enter any name, please enter a name");

            }else if (taskName.length() < 3 || taskName.length() >= 50) { // if name length is less than 3 and greater than 50 than throw error message
                
                throw new IllegalArgumentException("You enter the taskname out of range");

            }else if (!taskName.matches("[A-Za-z0-9 ]+")){ // If you enter the special char in name than it will throw the message 

                throw new IllegalArgumentException(" Type a Name without special char");
            }

            this.taskName = taskName;

            break;

        } catch (IllegalArgumentException e) {

            System.out.println("---------------------------------");
            System.out.print("Error:" + e.getMessage());
            Scanner sc = new Scanner(System.in);
            taskName = sc.nextLine();
            System.out.println("---------------------------------");
        }
    }
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDate getDueDate() {
        return dueDate;
    }

    public void setDueDate(String duedate) {
        while (true) {
            try {
                DateTimeFormatter format = DateTimeFormatter.ofPattern("dd-MM-yyyy");
                this.dueDate = LocalDate.parse(duedate, format);
                break;  // Exit loop if input is valid
            } catch (Exception e) {
                System.out.println("Error: Invalid date format. Please use dd-MM-yyyy.");
                System.out.print("Enter Due Date again (dd-MM-yyyy): ");
                Scanner sc = new Scanner(System.in);
                duedate = sc.nextLine();
            }
        }
    }

    public String getPriority() {
        return priority;
    }

    public void setPriority(String priority) {

        while (true) {
            
        try {
            // Convert input to uppercase
            priority = priority.toUpperCase();
    
            // Validate input
            if (!priority.matches("LOW|MEDIUM|HIGH")) {
                // Throwing IllegalArgumentException instead of IllegalAccessError
                throw new IllegalArgumentException("Please enter a valid priority: LOW, MEDIUM, or HIGH.");
            }
    
            // If valid, assign the value to the instance variable
            this.priority = priority;

            break;
    
        } catch (IllegalArgumentException e) {
            // Catch the exception and print the error message
            System.out.println("---------------------------------");
            System.out.print("Error: " + e.getMessage());
            Scanner sc = new Scanner(System.in);
            priority = sc.nextLine();
            System.out.println("---------------------------------");
        }
    }
    }
    

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        status = status.toUpperCase();

        while (true) {
            
        try {
            status = status.toUpperCase();

            if (!status.matches("PENDING|COMPLETED|PROCESSING")){

                throw new IllegalArgumentException("Please enter valid Satus");
            }

            this.status = status;

            break;

        } catch (IllegalArgumentException e) {

            System.out.println("---------------------------------");
            System.out.print("Error:" + e.getMessage());
            Scanner sc = new Scanner(System.in);
            status = sc.nextLine();
            System.out.println("---------------------------------");
        }
    }
    }

    public Node getPrev() {
        return prev;
    }

    public void setPrev(Node prev) {
        this.prev = prev;
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }
}