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
public class RequestCreateUser {

    private String username;
    private String firstname;
    private String lastname;
    private String email;
    private String password;
    private Role role;
}
