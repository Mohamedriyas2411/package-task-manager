package model;

public class TaskBase {
    protected String taskName;
    protected int durationInSeconds;

    public TaskBase(String taskName, int durationInSeconds) {
        this.taskName = taskName;
        this.durationInSeconds = durationInSeconds;
    }
}
