package main;

import model.Task;
import worker.TaskExecutor;
import java.util.ArrayList;
import java.util.Scanner;

public class TaskManagerApp {
    static ArrayList<Task> taskList = new ArrayList<>();
    static int nextId = 1;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\n=== Task Manager Menu ===");
            System.out.println("1. Add Task");
            System.out.println("2. View Tasks");
            System.out.println("3. Delete Task");
            System.out.println("4. Run Task");
            System.out.println("5. Exit");
            System.out.print("Enter choice: ");
            choice = sc.nextInt();
            sc.nextLine(); // Consume newline

            switch (choice) {
                case 1 -> addTask(sc);
                case 2 -> viewTasks();
                case 3 -> deleteTask(sc);
                case 4 -> runTask(sc);
                case 5 -> System.out.println("Exiting...");
                default -> System.out.println("Invalid choice. Try again.");
            }
        } while (choice != 5);

        sc.close();
    }

    static void addTask(Scanner sc) {
        System.out.print("Enter task name: ");
        String name = sc.nextLine();
        System.out.print("Enter duration (seconds): ");
        int duration = sc.nextInt();
        Task task = new Task(nextId++, name, duration);
        taskList.add(task);
        System.out.println("Task added successfully!");
    }

    static void viewTasks() {
        if (taskList.isEmpty()) {
            System.out.println("No tasks found.");
        } else {
            for (Task t : taskList) {
                t.displayInfo();
            }
        }
    }

    static void deleteTask(Scanner sc) {
        System.out.print("Enter task ID to delete: ");
        int id = sc.nextInt();
        boolean removed = taskList.removeIf(t -> t.getTaskId() == id);
        if (removed) {
            System.out.println("Task deleted.");
        } else {
            System.out.println("Task ID not found.");
        }
    }

    static void runTask(Scanner sc) {
        System.out.print("Enter task ID to run: ");
        int id = sc.nextInt();
        for (Task t : taskList) {
            if (t.getTaskId() == id) {
                TaskExecutor executor = new TaskExecutor(t);
                executor.start();
                return;
            }
        }
        System.out.println("Task ID not found.");
    }
}
