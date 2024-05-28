package com.example.TranTanPhat_KT_C3.Controllers.Role;

import com.example.TranTanPhat_KT_C3.Entities.Role;
import com.example.TranTanPhat_KT_C3.RequestEntities.Role.RequestCreateRole;
import com.example.TranTanPhat_KT_C3.RequestEntities.Role.RequestUpdateRole;
import com.example.TranTanPhat_KT_C3.Services.RoleServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/roles")
public class RoleController {
    @Autowired
    private RoleServices roleServices;


    @GetMapping("")
    public String ShowAllRole(Model model){
        List<Role> roles = roleServices.getAllRoles();
        model.addAttribute("roles", roles);
        return "Role/index";
    }
    @GetMapping("/edit/{id}")
    public String ShowRoleForm(@PathVariable String id, Model model){
        Role role = roleServices.getRoleById(id);
        model.addAttribute("role", role);
        return "Role/edit";
    }
    @PostMapping("/saveedit")
    public String SaveEditRole(RequestUpdateRole requestUpdateRole){
        roleServices.UpdateRole(requestUpdateRole);
        return "redirect:/roles";
    }
    @GetMapping("/new")
    public String createForm(Model model){
        Role role = new Role();

        model.addAttribute("role", role);

        return "Role/create";
    }
    @PostMapping("/create")
    public String SaveCreateRole(RequestCreateRole requestCreateRole){
        roleServices.CreateRole(requestCreateRole);
        return "redirect:/roles";
    }
    @GetMapping("/view/{id}")
    public String showDetail(@PathVariable String id, Model model) {
        Role role = roleServices.getRoleById(id);
        model.addAttribute("role", role);
        return "Role/view";
    }

}
