package com.example.Webbansach_backend.Sercurity;

import org.springframework.scheduling.support.SimpleTriggerContext;

public class Endpoint {
    public static final String front_end_host = "http://localhost:5173" ;
    public static final String[] PUBLIC_GET_ENPOINT = {
            "/sach" ,
            "sach/**" ,
            "/hinhanh" ,
            "/hinhanh/**",
            "/nguoidung/search/existsByTenDangNhap",
            "/nguoidung/search/existsByEmail",
            "/taikhoan/kichhoat"
    } ;
    public static final String[] PUBLIC_POST_ENDPOINS = {
            "/taikhoan/dangky" ,
            "/taikhoan/login"
    };

    public static final String[] ADMIN_GET_ENDPOINS = {
            "/nguoidung",
            "/nguoidung/**",
    };
    public static final String[] ADMIN_POST_ENDPOINS = {
           "/sach" ,
    };

}
