import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class TODO_LIST {
    public static void main(String[] args) {
        Node head = new Node();
        head = addTask(head);
        System.out.println(head.getPriority());
    }

    public static Node addTask(Node head){


        int taskId = 0;
        String taskName = null;
        String description = null;
        DateTimeFormatter format = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        LocalDate dueDate = null;
        String dateString = null;
        String priority = null;
        String status = null;

        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the new task detail:");

        System.out.println("TaskName Must:");
        taskName = scanner.nextLine();

        System.out.println("Description");
        description = scanner.nextLine();

        System.out.println("dueDate:");
        dateString = scanner.nextLine();
        dueDate =  LocalDate.parse(dateString, format);

        System.out.println("Type priority LOW|MEDIUM|HIGH :");
        priority = scanner.nextLine();

        System.out.println("Type Status PENDING|COMPLETED|PROCESSING :");
        status = scanner.nextLine();

        Node newTask = new Node(taskId, taskName, description, dueDate, priority, status);

        Node current = head;
        if (isEmpty(head)) {

            return newTask;
        }
        while (current.getNext() != null) {

            current = current.getNext();
        }

        current.setNext(newTask);
        newTask.setPrev(current);

        return head;
    }

    public static boolean isEmpty(Node head){

        if (head == null) {
            
            return true;
        }
        return false;
    }
}