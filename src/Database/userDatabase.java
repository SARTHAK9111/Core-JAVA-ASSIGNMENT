package Database;

import Model.User;

import java.util.ArrayList;
import java.util.List;

public class userDatabase {

    private ArrayList<User> Ulist = new ArrayList<>();

    public userDatabase() {
        Ulist.add( new User("riya" ,"riya@gmail.com","123456"));
        Ulist.add( new User("sayana" ,"sayana@gmail.com","1234"));
        Ulist.add( new User("ruhi" ,"ruhi@gmail.com","1234"));
    }

    public List<User> getAlluser(){
         return this.Ulist;
    }
    public boolean  insertUser(User user )throws Exception{
        for(User user_to_insert : Ulist){
            if(user_to_insert.getEmail().equals(user.getEmail())){
                throw  new Exception("customer  is already present ");
            }
        }
        Ulist.add(user);
        return true ;
    }

    public  User getCustomerByEmail(String email){
        User user_to_pass= null;
        for(User user_to_find : Ulist){
            if(user_to_find.getEmail().equals(email)){
                user_to_pass= user_to_find;
                break;
            }
        }
        return user_to_pass;
    }

    public boolean login(String email, String password){
        for(User c: Ulist){
            if(c.getEmail().equals(email)){
                if(c.getPassword().equals(password)){
                    return  true;
                }
            }
        }
        return  false;
    }
}
