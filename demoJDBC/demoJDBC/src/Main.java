import repository.ConnectionConfig;
import repository.User;
import repository.UserRepository;

import java.util.List;

public class Main {
    static UserRepository userRepository = new UserRepository();

    public static void main(String[] args) {
//        List <User> users = userRepository.getAllUsers();
//        for (User user : users){
//            System.out.println(user.toString());
//        }
//
//        System.out.println(userRepository.updateUsername(1,"hoanghong092"));
//        System.out.println(userRepository.updatePassword(2,"ngocngoc321"));
//        System.out.println(userRepository.updatePhoneNumber(2,"0987654321"));
//
//        System.out.println("List user last Update:");
//        List <User> userUpdate = userRepository.getAllUsers();
//        for (User user : userUpdate){
//            System.out.println(user.toString());
//        }

//        System.out.println(userRepository.addUser(6,"user6","pass12345","0123456789"));
//        List <User> users = userRepository.getAllUsers();
//        for (User user : users){
//            System.out.println(user.toString());
//        }

        System.out.println(userRepository.deleteUser(6));
        List <User> users = userRepository.getAllUsers();
        for (User user : users){
            System.out.println(user.toString());
        }
    }
}