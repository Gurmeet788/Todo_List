import java.util.Scanner;
public class TODO_LIST {

    Node head;
    Node current;
    public static void main(String[] args) {
        TODO_LIST todo_LIST = new TODO_LIST();

        boolean flage = true;
        while (flage) {
        
        System.out.println("Enter what you want to do from blow\nAddTask:\nDeleteTask:\nDispalyTask:\nUpadate:\nSearch:\nExit:");
        Scanner scanner = new Scanner(System.in);
        String choise = scanner.nextLine();

        switch (choise) {
            case "AddTask":
                todo_LIST.addTask(todo_LIST.head);
                break;
            case "DeleteTask":
                System.out.println("Enter taskId:");
                int taskId = scanner.nextInt();
                todo_LIST.DeleteTask(todo_LIST.head,taskId);
                break;

            case "DispalyTask":
                todo_LIST.displayTasks(todo_LIST.head);
                break;
            case "Upadate":
                System.out.println("Enter taskId:");
                int taskIdU = scanner.nextInt();
                todo_LIST.update(todo_LIST.head, taskIdU);
                break;
            case "Search":
                System.out.println("Enter taskName");
                String taskName =scanner.nextLine();
                todo_LIST.search(todo_LIST.head, taskName);  
                break;
            case "Exit":
                flage = false;
                break;
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
        String dueDate;
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
        dueDate = scanner.nextLine();
    
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


        if (head.getNext() == null) {
            
            this.head = null;

            return;
        }

        if (taskId == 1) {

            temp.getNext().setPrev(temp.getPrev());
            temp.setNext(null);

            this.head = temp;

            return;

        }
        while (temp.getTaskId() != taskId) {

            temp = temp.getNext();
        }
        if (temp.getNext() == null) {
            
            current = temp.getPrev();
            temp.getPrev().setNext(temp.getNext());
            temp.setPrev(null);

            this.head = head;
            return;
        }

        temp.getNext().setPrev(temp.getPrev());
        temp.getPrev().setNext(temp.getNext());
        temp.setNext(null);
        temp.setPrev(null);

        this.head = head;

        return;
    }


    public void update(Node head, int taskId){

        if (isEmpty(head)) {
            System.out.println("List is empty");
            return;
        }

        Node temp = head;
        while (temp.getTaskId() != taskId) {

            temp = temp.getNext();
        }

        Scanner scanner = new Scanner(System.in);

        boolean flage = true;

        while (flage) {
        System.out.println("Enter your choise what you want to update\nFull:\ntaskId:\ntaskName:\ndescription:\ndueDate:\npriority:\nstatus\nExit:");

        String choise = scanner.nextLine();

        if (choise.equals("Full")){

            System.out.println("Enter new taskId:");
            temp.setTaskId(scanner.nextInt());

            System.out.println("Enter new taskName:");
            temp.setTaskName(scanner.nextLine());

            System.out.println("Enter new taskDescription:");
            temp.setDescription(scanner.nextLine());

            System.out.println("Enter new dueDate:");
            temp.setDueDate(scanner.nextLine());

            System.out.println("Enter new priority:");
            temp.setPriority(scanner.nextLine());

            System.out.println("Enter new status:");
            temp.setStatus(scanner.nextLine());

        }else if (choise.equals("Exit")) {
            return;

        }else{
       
        switch (choise) {
            case "taskId":
                System.out.println("Enter new taskId:");
                temp.setTaskId(scanner.nextInt());
                break;
            case "taskName":
                System.out.println("Enter new taskName:");
                temp.setTaskName(scanner.nextLine());
                break;
            case "description":
                System.out.println("Enter new taskDescription:");
                temp.setDescription(scanner.nextLine());
                break;
            case "dueDate":
                System.out.println("Enter new dueDate:");
                temp.setDueDate(scanner.nextLine());
                break; 
            case "priority":
                System.out.println("Enter new priority:");
                temp.setPriority(scanner.nextLine());
                break;
            case "status": 
                System.out.println("Enter new status:");
                temp.setStatus(scanner.nextLine());
                break; 
            default:
                System.out.println("Invalid");
                break;
        }
    }
    }
    }

    public Node findMid(Node start, Node end){
        Node slow = start;
        Node fast = start;

        while (fast != end && fast.getNext() != end) {
            slow = slow.getNext();
            fast = fast.getNext().getNext();
        }

        return slow;
    }
    public void search(Node head, String taskName){

        if (isEmpty(head)) {

            System.out.println("List is empty");
            return;
        }

        Node start = head;
        Node end = null;
        while (start != end) {

            Node mid = findMid(start, end);

            if (mid.getTaskName().equals(taskName)) {
                System.out.println("Task ID: " + mid.getTaskId());
                System.out.println("Task Name: " + mid.getTaskName());
                System.out.println("Description: " + mid.getDescription());
                System.out.println("Due Date: " + mid.getDueDate());
                System.out.println("Priority: " + mid.getPriority());
                System.out.println("Status: " + mid.getStatus());
                System.out.println("-----------------------");

                return;
            }else if (mid.getTaskName().compareTo(taskName) > 0) {

                end = mid;

            }else if (mid.getTaskName().compareTo(taskName) < 0) {

                start = mid.getNext();
            }
        }
        System.out.println("Task not found");
        return;
    }
    public void displayTasks(Node head) {
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