
package easykanban;
// Main Program
import javax.swing.*;
import java.util.ArrayList;

public class EasyKanban {
    private static boolean loggedIn = false;
    private static ArrayList<Task> tasks = new ArrayList<>();

    public static void main(String[] args) {
        // Simulate login
        loggedIn = login();

        if (!loggedIn) {
            JOptionPane.showMessageDialog(null, "Login failed. Exiting...");
            System.exit(0);
        }

        // Welcome message
        JOptionPane.showMessageDialog(null, "Welcome to EasyKanban");

        while (true) {
            String input = JOptionPane.showInputDialog("Choose an option:\n1) Add tasks\n2) Show report\n3) Quit");
            int choice = Integer.parseInt(input);

            switch (choice) {
                case 1:
                    addTasks();
                    break;
                case 2:
                    JOptionPane.showMessageDialog(null, "Coming Soon!");
                    break;
                case 3:
                    JOptionPane.showMessageDialog(null, "Session Ended!");
                    System.exit(0);
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Invalid option, please choose again.");
            }
        }
    }

    private static boolean login() {
        // Simulated login logic
        String username = JOptionPane.showInputDialog("Enter username: (Username: Khaya)");
        String password = JOptionPane.showInputDialog("Enter password: (Password: 1265813115)");
        // In a real application, you'd check the username and password against a database or other data source.
        return username.equals("Khaya") && password.equals("1265813115");
    }

    private static void addTasks() {
        String numTasksInput = JOptionPane.showInputDialog("How many tasks would you like to enter?");
        int numTasks = Integer.parseInt(numTasksInput);

        for (int i = 0; i < numTasks; i++) {
            String taskName = JOptionPane.showInputDialog("Enter Task Name:");
            String taskDescription = JOptionPane.showInputDialog("Enter Task Description:");
            if (taskDescription.length() > 50) {
                JOptionPane.showMessageDialog(null, "Please enter a task description of less than 50 characters");
                i--; // Prompt user to re-type this task
                continue;
            }

            String developerDetails = JOptionPane.showInputDialog("Enter Developer Details (First & Last Name):");
            int taskDuration = Integer.parseInt(JOptionPane.showInputDialog("Enter Task Duration (in hours):"));
            String[] statusOptions = {"To Do", "Done", "Doing"};
            String taskStatus = (String) JOptionPane.showInputDialog(null, "Select Task Status:", "Task Status", JOptionPane.QUESTION_MESSAGE, null, statusOptions, statusOptions[0]);

            Task task = new Task(taskName, taskDescription, developerDetails, taskDuration, taskStatus, tasks.size());
            tasks.add(task);

            JOptionPane.showMessageDialog(null, task.printTaskDetails());
        }

        int totalHours = tasks.stream().mapToInt(Task::getTaskDuration).sum();
        JOptionPane.showMessageDialog(null, "Total Task Duration: " + totalHours + " hours");
    }
}

