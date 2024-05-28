package com.example.TranTanPhat_KT_C3.Controllers.Role;

import com.example.TranTanPhat_KT_C3.Entities.Role;
import com.example.TranTanPhat_KT_C3.RequestEntities.Role.RequestCreateRole;
import com.example.TranTanPhat_KT_C3.RequestEntities.Role.RequestUpdateRole;
import com.example.TranTanPhat_KT_C3.Services.RoleServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/api/roles")
public class RoleRestController {
    @Autowired
    private RoleServices roleServices;

    @GetMapping("")
    public List<Role> getAllRoles(){
        return roleServices.getAllRoles();
    }

    @PostMapping
    public Role CreateRole(@RequestBody RequestCreateRole role){
        return roleServices.CreateRole(role);
    }
    @GetMapping("/{id}")
    public Role getRoleById(@PathVariable String id) {
        return roleServices.getRoleById(id);
    }
    @PutMapping("/{id}")
    public Role updateRole(@PathVariable String id, @RequestBody RequestUpdateRole role) {
        return roleServices.UpdateRole( role);
    }
}
