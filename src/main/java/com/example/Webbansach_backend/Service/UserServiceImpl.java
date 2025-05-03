package com.example.Webbansach_backend.Service;

import com.example.Webbansach_backend.DAO.NguoiDungRepository;
import com.example.Webbansach_backend.DAO.QuyenRepository;
import com.example.Webbansach_backend.Entity.NguoiDung;
import com.example.Webbansach_backend.Entity.Quyen;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {

    private NguoiDungRepository nguoiDungRepository;
    private QuyenRepository quyenRepository ;
    @Autowired
    public UserServiceImpl(NguoiDungRepository nguoiDungRepository, QuyenRepository quyenRepository) {
        this.nguoiDungRepository = nguoiDungRepository;
        this.quyenRepository = quyenRepository;
    }


    @Override
    public NguoiDung findByTenDangNhap(String tenDangNhap) {
        return nguoiDungRepository.findByTenDangNhap(tenDangNhap) ;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        NguoiDung nguoiDung = nguoiDungRepository.findByTenDangNhap(username);
        if(nguoiDung == null) {
            throw new UsernameNotFoundException("Tai khoan khong ton tai");

        }
        User user = new User(nguoiDung.getTenDangNhap(), nguoiDung.getMatKhau() ,rolesToAuthorities(nguoiDung.getQuyens()) ) ;
        return user ;
    }
    private Collection<? extends GrantedAuthority> rolesToAuthorities(Collection<Quyen> quyens) {
        return quyens.stream().map(role-> new SimpleGrantedAuthority(role.getTenQuyen())).collect(Collectors.toList());
    }
}
