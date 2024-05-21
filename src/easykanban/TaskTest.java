
package easykanban;
// Unit Test
public class TaskTest {
    public static void main(String[] args) {
        // Test case for task description length check
        Task task1 = new Task("Login Feature", "Create Login to authenicate users", "Robyn Harrison", 8, "To Do", 0);
        assert task1.checkTaskDescription() : "Task Description is valid";

        Task task2 = new Task("Add Task Feature", "This description is way too long and should trigger a failure", "Mike Smith", 10, "Doing", 1);
        assert !task2.checkTaskDescription() : "Task Description is invalid";

        // Test case for task ID generation
        Task task3 = new Task("Login Feature", "Create Login to authenicate users", "Robyn Harrison", 8, "To Do", 1);
        assert task3.createTaskID().equals("LO:1:SON") : "Task ID generated correctly";

        // Test case for total hours calculation
        Task task4 = new Task("Some Task", "Valid description", "Developer One", 5, "Done", 2);
        Task task5 = new Task("Another Task", "Valid description", "Developer Two", 10, "To Do", 3);
        int totalHours = task4.getTaskDuration() + task5.getTaskDuration();
        assert totalHours == 15 : "Total hours calculation is correct";

        System.out.println("All tests passed.");
    }
}

