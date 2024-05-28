package com.example.TranTanPhat_KT_C3.Services;

import com.example.TranTanPhat_KT_C3.Entities.User;
import com.example.TranTanPhat_KT_C3.Repositories.UserRepository;
import com.example.TranTanPhat_KT_C3.RequestEntities.RequestCreateUser;
import com.example.TranTanPhat_KT_C3.RequestEntities.RequestUpdateUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServices {
    @Autowired
    UserRepository userRepository;
    public User CreateUser(RequestCreateUser requestCreateUser ) {
        try{
            User user = new User();
            user.setUsername(requestCreateUser.getUsername());
            user.setFirstname(requestCreateUser.getFirstname());
            user.setLastname(requestCreateUser.getLastname());
            user.setPassword(requestCreateUser.getPassword());
            user.setEmail(requestCreateUser.getEmail());
            user.setRole(requestCreateUser.getRole());
            userRepository.save(user);
            return user;
        }catch (Exception e){
            throw new RuntimeException(e.getMessage());
        }
    }
    public List<User> GetAllUsers(){
        return userRepository.findAll();
    }
    public User GetUserById(String id){
        return userRepository.findById(id).orElseThrow(
                () -> new RuntimeException("Student with id " + id + " not found")
        );
    }
    public User deleteUserById(String id) {
        try{
            User user = GetUserById(id);
            user.setIsdeleted(true);
            userRepository.save(user);
            return user;
        }catch (Exception e){
            throw new RuntimeException(e.getMessage());
        }
    }

    public User activateUserById(String id) {
        try{
            User user = GetUserById(id);
            user.setIsdeleted(false);
            userRepository.save(user);
            return user;
        }catch (Exception e){
            throw new RuntimeException(e.getMessage());
        }
    }
    public User updateUser(String id,RequestUpdateUser requestUpdateUser){
        try{
            User user = GetUserById(id);
            user.setUsername(requestUpdateUser.getUsername());
            user.setPassword(requestUpdateUser.getPassword());
            user.setEmail(requestUpdateUser.getEmail());
            user.setLastname(requestUpdateUser.getLastname());
            user.setFirstname(requestUpdateUser.getFirstname());
            user.setRole(requestUpdateUser.getRole());
            user.setIsdeleted(requestUpdateUser.isIsdeleted());
            userRepository.save(user);
            return user;
        }catch (Exception e){
            throw new RuntimeException(e.getMessage());
        }
    }
}

