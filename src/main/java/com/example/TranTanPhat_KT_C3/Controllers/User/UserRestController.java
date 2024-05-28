package com.example.TranTanPhat_KT_C3.Controllers.User;

import com.example.TranTanPhat_KT_C3.Entities.User;
import com.example.TranTanPhat_KT_C3.RequestEntities.RequestCreateUser;
import com.example.TranTanPhat_KT_C3.RequestEntities.RequestUpdateUser;
import com.example.TranTanPhat_KT_C3.Services.UserServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserRestController {

    @Autowired
    private UserServices userServices;

    @PostMapping("")
    public User createUser(@RequestBody RequestCreateUser requestCreateUser) {
        return userServices.CreateUser(requestCreateUser);
    }
    @GetMapping("")
    public List<User> getAllUser() {
        return userServices.GetAllUsers();
    }
    @GetMapping("/{id}")
    public User getUserById(@PathVariable String id) {
        return userServices.GetUserById(id);
    }
    @PutMapping("/{id}")
    public User updateUser(@PathVariable String id, @RequestBody RequestUpdateUser requestUpdateUser) {
        return userServices.updateUser(id, requestUpdateUser);
    }
    @DeleteMapping("/{id}")
    public User deleteUser(@PathVariable String id) {
        return userServices.deleteUserById(id);
    }

    @PutMapping("/activate/{id}")
    public User activeUser(@PathVariable String id) {
        return userServices.activateUserById(id);
    }
}
