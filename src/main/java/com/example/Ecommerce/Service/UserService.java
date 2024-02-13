package com.example.Ecommerce.Service;

import com.example.Ecommerce.Model.User;
import com.example.Ecommerce.Model.UserForms;
import com.example.Ecommerce.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private TokenService tokenService;

    // Method to save a new user
    public User save(UserForms userForms){
        User user = new User();
        user.setEmail(userForms.getEmail());
        user.setPassword(userForms.getPassword1());
        user.setUsername(userForms.getUsername());
        return userRepository.save(user);
    }

    // Method to check if a user with the given email exists
    public Boolean existByEmail(String email){
        Optional<User> userObj = Optional.ofNullable(userRepository.getUserByEmail(email));
        if(!userObj.isEmpty())
                return true;
        return false;
    }
    // Method for user login
    public String userLogin(User usr){
        boolean isUser = existByEmail(usr.getEmail());
        // is user exists
        if (isUser){
            // get the user attributes belong to a particular email
            User user = userRepository.getUserByEmail(usr.getEmail());
            // check whether the password sent is the login is equal to password in database
            if(user.getPassword().equals(usr.getPassword())){
                return "{" +
                        "\"message\":"+"\"Successfully logged in\""+",\n"+
                        "\"data\":"+user+",\n"+
                        "\"email\":"+user.getEmail()+",\n"+
                        "\"token\":"+tokenService.createTokenFunction(user.getId())+
                        "}";
            }
        }
        else{
            return "{"+"\"Authentication\":"+"failed" + "}";
        }
        return "";
    }

}
