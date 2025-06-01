package model;

public class Task extends TaskBase implements RunnableTask {
    private int taskId;

    public Task(int taskId, String taskName, int durationInSeconds) {
        super(taskName, durationInSeconds);
        this.taskId = taskId;
    }

    public int getTaskId() {
        return taskId;
    }

    public String getTaskName() {
        return taskName;
    }

    @Override
    public void runTask() {
        System.out.println("Running Task: " + taskName + " [Duration: " + durationInSeconds + "s]");
        try {
            Thread.sleep(durationInSeconds * 1000L);
        } catch (InterruptedException e) {
            System.out.println("Task interrupted.");
        }
        System.out.println("Task " + taskName + " completed!");
    }

    public void displayInfo() {
        System.out.println("ID: " + taskId + ", Name: " + taskName + ", Duration: " + durationInSeconds + "s");
    }
}
