package worker;

import model.Task;

public class TaskExecutor extends Thread {
    private Task task;

    public TaskExecutor(Task task) {

        this.task = task;
    }

    @Override
    public void run() {

        task.runTask();
    }
}
