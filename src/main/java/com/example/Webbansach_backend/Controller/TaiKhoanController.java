package com.example.Webbansach_backend.Controller;

import com.example.Webbansach_backend.Entity.NguoiDung;
import com.example.Webbansach_backend.Sercurity.JwtResponse;
import com.example.Webbansach_backend.Sercurity.LoginRequest;
import com.example.Webbansach_backend.Service.JwtService;
import com.example.Webbansach_backend.Service.TaiKhoanService;
import com.example.Webbansach_backend.Service.UserService;
import io.jsonwebtoken.Jwt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import javax.security.sasl.AuthenticationException;

@RestController
@RequestMapping("/taikhoan")
    @CrossOrigin(origins = "http://localhost:5173")
public class TaiKhoanController {
    private TaiKhoanService taiKhoanService ;
    private AuthenticationManager authenticationManager ;
    private UserService userService ;
    private JwtService jwtService ;
    @Autowired
    public TaiKhoanController(TaiKhoanService taiKhoanService, AuthenticationManager authenticationManager, UserService userService, JwtService jwtService) {
        this.taiKhoanService = taiKhoanService;
        this.authenticationManager = authenticationManager;
        this.userService = userService;
        this.jwtService = jwtService;
    }


    @PostMapping("/dangky")
    public ResponseEntity<?> CreateAccount(@RequestBody NguoiDung nguoiDung) {
        ResponseEntity<?> responseEntity = taiKhoanService.dangLyNguoiDung(nguoiDung) ;
        return responseEntity ;
    }
    @GetMapping("/kichhoat")
    public ResponseEntity<?> Active(@RequestParam String email , @RequestParam String maKichHoat) {
        ResponseEntity<?> responseEntity = taiKhoanService.KichHoatTaiKhoan(email , maKichHoat) ;
        return responseEntity ;
    }
    @PostMapping("/login")
    public ResponseEntity<?> dangNhap(@RequestBody LoginRequest loginRequest) {
        try {
            System.out.println("== Thử đăng nhập ==");
            System.out.println("Username: " + loginRequest.getUsername());
            System.out.println("Password: " + loginRequest.getPassword());
            Authentication authentication = authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(loginRequest.getUsername() , loginRequest.getPassword())
            ) ;
            if(authentication.isAuthenticated()) {
                final String jwt = jwtService.generateToken(loginRequest.getUsername()) ;
                return ResponseEntity.ok( new JwtResponse(jwt)) ;
            }
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.badRequest().body("Ten dang nhap hoac mat khau khong chinh xac") ;
        }
        return ResponseEntity.badRequest().body("Xac thuc khong thanh cong ") ;

    }






}
