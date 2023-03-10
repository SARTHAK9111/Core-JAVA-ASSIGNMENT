package Service;
import Database.taskDatabase;
import Database.userDatabase;
import Model.Task;
import Model.User;

import java.util.ArrayList;
import java.util.List;

public class taskService {
    private taskDatabase Tdatabase;
    private userDatabase Udatabase;


    public taskService(){
        this.Tdatabase=Tdatabase;
        this.Udatabase=Udatabase;

    }
    // Task part

    public void addTask(Task task)throws Exception{
        Tdatabase.insertTask(task);


    }

    public void updatetask(Task task){
        Tdatabase.updatetask(task.getTaskId(),task.getTaskTitle(),task.getTaskText(),task.getAssignedTo(),task.isTaskCompleted());
    }

    public boolean deletetask(String  tasktitle) throws Exception{
        if(Tdatabase.deleteTask(tasktitle)) {
            return true;
        }
        throw  new Exception(" not able to delete");
    }

    public  Task  search(String taskID){
        Task task= Tdatabase.getTaskbyID(taskID);
        return task;
    }

    public ArrayList<Task> getalltask(){

        ArrayList<Task> task = new ArrayList<>();
        task= (ArrayList<Task>) Tdatabase.getAlltask();
        return task;
    }

    public ArrayList<Task> getALlCompeletedTask (){

       ArrayList<Task > taskcompeleted= (ArrayList<Task>)Tdatabase.getcompeletedlist();
       return taskcompeleted;
    }
    public ArrayList<Task> getallPending (){

        ArrayList<Task > taskpending= (ArrayList<Task>)Tdatabase.getPendingtask();
        return taskpending;
    }
    // User part
    public boolean registerCustomer(User user) throws  Exception{
        if(user.getEmail() == null || user.getEmail().isBlank()){
            throw  new Exception(" email can not be empty");

        }
        try {
            Udatabase.insertUser(user);

        }
        catch (Exception e){
            e.printStackTrace();
            return  false;
        }
        return true ;
    }
    public List<Task> getAllTask() throws Exception{
        if(Tdatabase.getAlltask().size()== 0){
            throw new Exception("No customer register yet");
        }
        return  this.Tdatabase.getAlltask();
    }

    public boolean validateCerdential(String email , String Password) throws Exception{

        if(email == null || email.isEmpty())
        {
            throw  new Exception("email cannot be empty() ");
        }
        return this.Udatabase.login(email, Password );
    }



}
