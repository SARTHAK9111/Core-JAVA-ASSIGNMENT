package Ui;

import Database.taskDatabase;
import Database.userDatabase;
import Model.Task;
import Model.User;
import Service.taskService;


import java.util.Scanner;

public class taskUI {

    public static void taskMangerdasboard(Scanner sc, taskService ts) {
        boolean flag = true;
        do {
            System.out.println("************** Task Manger***************");

            int ch = sc.nextInt();
            System.out.println("Select Operation\n"
                    + "1. See all task\n"
                    + " 2. add a task\n "
                    + "3. delete a task\n"
                    + " 4. update a task\n"
                    + " 5. search  a task\n"
                    + " press 0 to to exit");


            switch (ch) {
                case 1:
                    try {

                        for (Task task : ts.getAllTask()) {
                            System.out.println(task);
                        }


                    } catch (Exception e) {
                        throw new RuntimeException(e);
                    }
                    break;
                case 2:
                    System.out.println("please enter the task id");
                    String taskid = sc.nextLine();
                    System.out.println("Enter the task title");
                    String tasktitle = sc.nextLine();
                    System.out.println("Please enter the discription");
                    String taskDiscription = sc.nextLine();
                    System.out.println("enter the Assignment name");
                    String assignto = sc.nextLine();
                    System.out.println("is it completed or not");
                    boolean completedOrNot = sc.nextBoolean();

                    Task ne = new Task(taskid, tasktitle, taskDiscription, assignto, completedOrNot);
                    try {
                        ts.addTask(ne);
                    } catch (Exception e) {
                        throw new RuntimeException(e);
                    }
                    break;

                case 3:
                    System.out.println("Please enterthe task title which you want to delete");

                    String taskitle = sc.nextLine();
                    try {
                        ts.deletetask(taskitle);
                    } catch (Exception e) {
                        throw new RuntimeException(e);
                    }
                    break;

                case 4:
                    System.out.println("please enter the task id you want to update");
                    String taskId = sc.nextLine();
                    System.out.println("Enter the task title");
                    String taskTitle = sc.nextLine();
                    System.out.println("Please enter the discription");
                    String TaskDiscription = sc.nextLine();
                    System.out.println("enter the Assignment name");
                    String assignTo = sc.nextLine();
                    System.out.println("is it completed or not");
                    boolean CompletedOrNot = sc.nextBoolean();

                    Task ne1 = new Task(taskId, taskTitle, TaskDiscription, assignTo, CompletedOrNot);
                    ts.updatetask(ne1);
                    break;
                case 5:
                    System.out.print("Please the the task id you want to searchj");

                    String id = sc.nextLine();
                    ts.search(id);
                    break;
                case 0:
                    flag = false;
                    break;


                default:
                    System.out.println("Please enter the right choice ");
                    break;
            }


        } while (flag);


    }

    public static void userMangement(Scanner sc, taskService ts) {

        boolean flag= true;
        do{
            System.out.println(" ********** USER MANAGE************");
            System.out.println(" please select \n+ " +
                    "1. to add user \n" +
                    "0. exit ");
            int choice= sc.nextInt();

            switch(choice){
                case 1:
                    System.out.println("please enter the user name");
                    String name=sc.nextLine();
                    System.out.println("please enter the email");
                    String email= sc.nextLine();
                    System.out.println("please enterthe password ");
                    String password=sc.nextLine();

                    User user =new User(name,email,password);

                    try {
                        ts.registerCustomer(user);
                    } catch (Exception e) {
                        throw new RuntimeException(e);
                    }
                    break;
                case 0:
                    flag= false;
                    break;
                default:
                    System.out.println("please enter the right choice");
            }

        }while(flag);


    }


    public static void main(String[] args) {
        taskDatabase taskdata = new taskDatabase();
        taskService taskservice =new taskService();

        userDatabase userdata = new userDatabase();
        boolean flag = true;

        do {
            Scanner sc = new Scanner(System.in);

            System.out.println("Select Operation\n"
                    + "1.login for taskmanagement\n"
                    + "2.login  for user setting");



            int uInput = sc.nextInt();
            sc.nextLine();

            switch (uInput) {
                case 1:
                    System.out.println("Please enter email");
                    String email = sc.nextLine();
                    System.out.println("please enter the password");
                    String password = sc.nextLine();
                    try {
                        if (taskservice.validateCerdential(email, password)) {
                            taskMangerdasboard(sc, taskservice);
                        }


                    } catch (Exception e) {
                        throw new RuntimeException(e);
                    }
                    break;

                case 2:

                    System.out.println("Please enter email");
                    String emailforuser = sc.nextLine();
                    System.out.println("please enter the password");
                    String passwordforusername = sc.nextLine();

                    try {
                        if (taskservice.validateCerdential(emailforuser, passwordforusername)) {
                            userMangement(sc, taskservice);
                        }
                    } catch (Exception e) {
                        throw new RuntimeException(e);
                    }


            }



        }while (flag);
    }

}