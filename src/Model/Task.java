package Model;

public class Task {
     private  String TaskId;
    private String TaskTitle;
    private String TaskText;
    private String assignedTo;
    private  boolean taskCompleted ;

    public Task(String taskId, String taskTitle, String taskText, String assignedTo, boolean taskCompleted) {
        this.TaskId = taskId;
        this.TaskTitle = taskTitle;
        this.TaskText = taskText;
        this.assignedTo = assignedTo;
        this.taskCompleted = taskCompleted;
    }

    public Task() {
    }

    public String getTaskId() {
        return TaskId;
    }

    public void setTaskId(String taskId) {
        TaskId = taskId;
    }

    public String getTaskTitle() {
        return TaskTitle;
    }

    public void setTaskTitle(String taskTitle) {
        TaskTitle = taskTitle;
    }

    public String getTaskText() {
        return TaskText;
    }

    public void setTaskText(String taskText) {
        TaskText = taskText;
    }

    public String getAssignedTo() {
        return assignedTo;
    }

    public void setAssignedTo(String assignedTo) {
        this.assignedTo = assignedTo;
    }

    public boolean isTaskCompleted() {
        return taskCompleted;
    }

    public void setTaskCompleted(boolean taskCompleted) {
        this.taskCompleted = taskCompleted;
    }
}
