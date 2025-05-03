package com.example.Webbansach_backend.Service;

import com.example.Webbansach_backend.DAO.NguoiDungRepository;
import com.example.Webbansach_backend.Entity.NguoiDung;
import com.example.Webbansach_backend.Entity.ThongBao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class TaiKhoanService {

    private NguoiDungRepository nguoiDungRepository ;
    private PasswordEncoder passwordEncoder ;
    private EmailService emailService ;
    @Autowired
    public TaiKhoanService(NguoiDungRepository nguoiDungRepository, PasswordEncoder passwordEncoder, EmailService emailService) {
        this.nguoiDungRepository = nguoiDungRepository;
        this.passwordEncoder = passwordEncoder;
        this.emailService = emailService;
    }



    public ResponseEntity<?> dangLyNguoiDung(NguoiDung nguoiDung) {
        // kiem tra ten dang nhap da ton tai chua
        if(nguoiDungRepository.existsByTenDangNhap(nguoiDung.getTenDangNhap())) {
            return ResponseEntity.badRequest().body(new ThongBao("Ten dang nhap da tong tai.")) ;
        }
        // kiem tra email da ton tai chua
        if(nguoiDungRepository.existsByEmail(nguoiDung.getEmail())) {
            return ResponseEntity.badRequest().body(new ThongBao("Email da tong tai.")) ;
        }

        // ma hoa mat khau
        String enCriptPassword = passwordEncoder.encode(nguoiDung.getMatKhau()) ;
        nguoiDung.setMatKhau(enCriptPassword);

        // gan va goi thong tin kich hoat
        nguoiDung.setMaKhichHoat(taoMaKichHoat());
        nguoiDung.setDaKichHoat(false);

        // luu nguoi dung vao db
        NguoiDung nguoiDungCreation = nguoiDungRepository.save(nguoiDung) ;

        // goi email kich hoat
        goiEmailKichHoat(nguoiDung.getEmail() , nguoiDung.getMaKhichHoat());


        return ResponseEntity.ok("Dang ky thanh cong") ;
    }

    private String taoMaKichHoat() {
        return UUID.randomUUID().toString() ;
    }

    private void goiEmailKichHoat(String email , String maKichHoat) {
        String Subject = "Kich hoat tai khoan tai web ban sach " ;
        String text = "Vui long su dung ma sau de kich hoat tai khoan < " + email + "> : <br/> <h1>" +maKichHoat+ "<h1/> " ;
        text += "<br/> Click vao duong link de kich hoat : " ;
        String url = "http://localhost:5173/kichhoat/" + email+ "/" +maKichHoat ;
        text += ("<br/> <a href = " + url + ">" + url + "<a/>" ) ;
        emailService.SendMessage("Tamn0443@gmail.com" , email , Subject , text);
    }

    public ResponseEntity<?> KichHoatTaiKhoan(String Email ,  String maKhichHoat) {
        NguoiDung nguoiDung = nguoiDungRepository.findByEmail(Email) ;
        if(nguoiDung == null) {
            return ResponseEntity.badRequest().body("Nguoi dung khong ton tai") ;
        }
        if(nguoiDung.isDaKichHoat()) {
            return ResponseEntity.badRequest().body("Tai Khoan da kich hoat ") ;
        }
        if(maKhichHoat.equals(nguoiDung.getMaKhichHoat())) {
            nguoiDung.setDaKichHoat(true);
            nguoiDungRepository.save(nguoiDung) ;
            return ResponseEntity.ok("Kich hoat tai khoan khong thanh cong") ;
        }
        else {
            return ResponseEntity.badRequest().body("Ma kich hoat khong dung ") ;
        }
    }


}
