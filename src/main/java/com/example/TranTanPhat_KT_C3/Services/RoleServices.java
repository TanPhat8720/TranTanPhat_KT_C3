package com.example.TranTanPhat_KT_C3.Services;

import com.example.TranTanPhat_KT_C3.Entities.Role;
import com.example.TranTanPhat_KT_C3.Repositories.RoleRepository;
import com.example.TranTanPhat_KT_C3.RequestEntities.Role.RequestCreateRole;
import com.example.TranTanPhat_KT_C3.RequestEntities.Role.RequestUpdateRole;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleServices {
    @Autowired
    private RoleRepository roleRepository;
    public List<Role> getAllRoles() {
        return roleRepository.findAll();
    }
    public Role getRoleById(String id) {
        return roleRepository.findById(id).orElseThrow(
                () -> new RuntimeException("Role with id " + id + " not found")
        );
    }
    public Role CreateRole(RequestCreateRole requestCreateRole) {
        try{
            Role role = new Role();
            role.setRole_name(requestCreateRole.getRole_name());
            return roleRepository.save(role);
        }catch (Exception e){
            throw new RuntimeException(e.getMessage());
        }
    }
    public Role UpdateRole(RequestUpdateRole requestUpdateRole) {
        try {
            Role role = roleRepository.findById(requestUpdateRole.getRole_id()).orElseThrow();
            role.setRole_name(requestUpdateRole.getRole_name());
            return roleRepository.save(role);
        }catch (Exception e){
            throw new RuntimeException(e.getMessage());
        }
    }

}
