package com.example.TranTanPhat_KT_C3.Repositories;

import com.example.TranTanPhat_KT_C3.Entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository  extends JpaRepository<User,String> {
}
