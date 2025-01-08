import java.time.LocalDateTime;
public class Node {

    private int taskId;
    private String taskName;
    private String description;
    private LocalDateTime dueDate;
    private String Priority;
    private String status;

    public Node(int taskId, String taskName, String description, LocalDateTime dueDate, String priority,
            String status) {
        this.taskId = taskId;
        this.taskName = taskName;
        this.description = description;
        this.dueDate = dueDate;
        Priority = priority;
        this.status = status;
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
                 
                throw new IllegalAccessError("You donot enter any name, please enter a name");

            }else if (taskName.length() > 3 && taskName.length() <= 50) { // if name length is less than 3 and greater than 50 than throw error message
                
                throw new IllegalAccessError("You enter the taskname out of range");

            }else if (taskName.matches("[A-Za-z0-9 ]+")){ // If you enter the special char in name than it will throw the message 

                throw new IllegalAccessError(" Type a Name without special char");
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

    public LocalDateTime getDueDate() {
        return dueDate;
    }

    public void setDueDate(LocalDateTime dueDate) {
        this.dueDate = dueDate;
    }

    public String getPriority() {
        return Priority;
    }

    public void setPriority(String priority) {

        try {

            priority = priority.toUpperCase();

            if (!Priority.matches("LOW|MEDIUM|HIGH")) {  // YOU HAVE TO GIVE Proity in low medium and high otherwise it will give you an error

                throw new IllegalAccessError("Please enter valid prioority");
            }

            this.Priority = priority;

        } catch (IllegalAccessError e) {

            System.out.println("Error:" + e.getMessage());
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
}