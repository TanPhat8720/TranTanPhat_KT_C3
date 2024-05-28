package com.example.TranTanPhat_KT_C3.Controllers.User;

import com.example.TranTanPhat_KT_C3.Entities.Role;
import com.example.TranTanPhat_KT_C3.Entities.User;
import com.example.TranTanPhat_KT_C3.RequestEntities.RequestCreateUser;
import com.example.TranTanPhat_KT_C3.RequestEntities.RequestUpdateUser;
import com.example.TranTanPhat_KT_C3.Services.RoleServices;
import com.example.TranTanPhat_KT_C3.Services.UserServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/users")
public class UserController {
    @Autowired
    public UserServices userServices;
    @Autowired
    public RoleServices roleServices;
    @GetMapping("")
    public String ShowAllUser(Model model){
        List<User> users = userServices.GetAllUsers();
        model.addAttribute("users", users);
        return "User/index";
    }


    @GetMapping("/edit/{id}")
    public String ShowUserForm(@PathVariable String id, Model model){
        User user = userServices.GetUserById(id);
        List<Role> roles = roleServices.getAllRoles();
        model.addAttribute("user", user);
        model.addAttribute("role", roles);
        return "User/edit";
    }
    @PostMapping("/saveedit")
    public String SaveEditStudent(RequestUpdateUser requestUpdateUser){
        userServices.updateUser(requestUpdateUser.getId(),requestUpdateUser);
        return "redirect:/users";
    }
    @GetMapping("/new")
    public String createForm(Model model){
        User user = new User();
        List<Role> roles = roleServices.getAllRoles();
        model.addAttribute("user",user);
        model.addAttribute("role", roles);
        return "User/create";
    }
    @PostMapping("/create")
    public String SaveCreateUser(RequestCreateUser requestCreateUser){
        userServices.CreateUser(requestCreateUser);
        return "redirect:/users";
    }
    @GetMapping("/view/{id}")
    public String showDetail(@PathVariable String id, Model model) {
        User user = userServices.GetUserById(id);
        model.addAttribute("user", user);
        return "User/view";
    }
    @GetMapping("/delete/{id}")
    public String deleteUser(@PathVariable String id) {
        userServices.deleteUserById(id);
        return "redirect:/users";
    }

    @GetMapping("/activate/{id}")
    public String activateUser(@PathVariable String id) {
        userServices.activateUserById(id);
        return "redirect:/users";
    }

}
