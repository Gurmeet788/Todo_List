import java.time.LocalDate;
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

    public Node(int taskId, String taskName, String description, LocalDate dueDate, String priority, String status,
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

    public Node(int taskId, String taskName, String description, LocalDate dueDate, String priority,
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

        try {

            if (taskId <= 0) {
                throw new IllegalAccessError("The taskId is neg it is invalid");
            }

            this.taskId = taskId;

        } catch (IllegalAccessError e) {
            System.out.println("Error:" + e.getMessage());
        }
    }

    public String getTaskName() {
        return taskName;
    }

    public void setTaskName(String taskName) {
        try {
            
            if (taskName == null || taskName.trim().isEmpty()) { // if name is null or just space than throw error message
                 
                throw new IllegalArgumentException("You donot enter any name, please enter a name");

            }else if (taskName.length() < 3 || taskName.length() >= 50) { // if name length is less than 3 and greater than 50 than throw error message
                
                throw new IllegalArgumentException("You enter the taskname out of range");

            }else if (!taskName.matches("[A-Za-z0-9 ]+")){ // If you enter the special char in name than it will throw the message 

                throw new IllegalArgumentException(" Type a Name without special char");
            }

            this.taskName = taskName;

        } catch (IllegalAccessError e) {

            System.out.println("Error:" + e.getMessage());
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

    public void setDueDate(LocalDate dueDate) {
        this.dueDate = dueDate;
    }

    public String getPriority() {
        return priority;
    }

    public void setPriority(String priority) {
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
    
        } catch (IllegalArgumentException e) {
            // Catch the exception and print the error message
            System.out.println("Error: " + e.getMessage());
        }
    }
    

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        status = status.toUpperCase();

        try {
            status = status.toUpperCase();

            if (!status.matches("PENDING|COMPLETED|PROCESSING")){

                throw new IllegalArgumentException("Please enter valid Satus");
            }

            this.status = status;

        } catch (IllegalArgumentException e) {

            System.out.println("Error:" + e.getMessage());
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