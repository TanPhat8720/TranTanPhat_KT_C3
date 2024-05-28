package com.example.TranTanPhat_KT_C3.RequestEntities;

import com.example.TranTanPhat_KT_C3.Entities.Role;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class RequestUpdateUser {
    private String id;
    private String firstname;
    private String lastname;
    private String username;
    private String password;
    private String email;
    private Role role;
    private boolean isdeleted;
}
