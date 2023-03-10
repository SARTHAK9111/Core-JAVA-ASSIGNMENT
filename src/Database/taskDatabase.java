package Database;

import Model.Task;
import Model.User;

import java.util.ArrayList;
import java.util.List;

public class taskDatabase {

    public ArrayList<Task> tasklist= new ArrayList<>();

    public taskDatabase() {
        tasklist.add( new Task("TSK01" ,"Email client " ," Email client to  about tender","riya@gmail.com",false));
        tasklist.add( new Task("TSK02" ,"Meet with client","meet with the client for brocher ","sayana@gmail.com",true));

    }

    public List<Task> getAlltask(){
        return this.tasklist;
    }

    public  boolean insertTask( Task task) throws  Exception
    {
        for(Task task_toinsert : tasklist){
            if(task_toinsert.getTaskTitle().equals(task.getTaskTitle())){
                throw  new Exception("Task  is already present ");
            }
        }
        tasklist.add(task);
        return true;
    }

    public  Task getTaskbyID(String TaskId ){
        Task task_to_find= null;
        for(Task task : tasklist){
            if(task.getTaskId().equals(TaskId)){
                task_to_find= task;
                break;
            }
        }
        return task_to_find;
    }

        public  boolean deleteTask(String tasktitle) throws  Exception
    {
        for(Task task_to_delete : tasklist){
            if(task_to_delete.getTaskTitle().equals(tasktitle)){
                tasklist.remove(task_to_delete);
            }
        }
        throw  new Exception(" NO TASK FOUND");
    }

    public  Task updatetask(String taskId, String taskTitle, String taskText, String assignedTo, boolean taskCompleted){
        Task task_to_update =getTaskbyID(taskId);
        task_to_update.setTaskTitle(taskTitle);
        task_to_update.setTaskText(taskText);
        task_to_update.setAssignedTo(assignedTo);
        task_to_update.setTaskCompleted(taskCompleted);
        return task_to_update;
    }
    public  ArrayList<Task> getcompeletedlist(){
        ArrayList<Task> compeletedList = new ArrayList<>();
        for(Task  taskdone: tasklist){
            if(taskdone.isTaskCompleted()== true)
            {
                compeletedList.add(taskdone);
            }
        }
        return compeletedList;
    }
    public  ArrayList<Task> getPendingtask(){
        ArrayList<Task> pendingList = new ArrayList<>();
        for(Task  taskdone: tasklist){
            if(taskdone.isTaskCompleted()== false)
            {
                pendingList.add(taskdone);
            }
        }
        return pendingList;
    }
}
