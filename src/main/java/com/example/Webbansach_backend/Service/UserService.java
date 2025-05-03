package com.example.Webbansach_backend.Service;

import com.example.Webbansach_backend.Entity.NguoiDung;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserService extends UserDetailsService {
    public NguoiDung findByTenDangNhap(String tenDangNhap) ;
}
