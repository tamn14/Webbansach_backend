package com.example.Webbansach_backend.Entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;
@Data
@Entity
@Table(name = "nguoidung")
public class NguoiDung {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "manguoidung")
    private int maNguoiDung ;
    @Column(name = "hodem", length = 256)
    private String hoDem ;
    @Column(name = "ten" , length = 256)
    private String ten ;
    @Column(name = "tendangnhap", length = 25)
    private String tenDangNhap ;
    @Column(name = "matkhau" , length = 512)
    private String matKhau;
    @Column(name = "gioitinh")
    private char gioiTinh ;
    @Column(name = "email" , length = 256)
    private String email;
    @Column(name = "sdt" , length = 10)
    private String sdt ;
    @Column(name = "diachimuahang" , columnDefinition = "text")
    private String diaChiMuaHang ;
    @Column(name = "diachigiaohang" , columnDefinition = "text")
    private String diaChiGiaoHang ;
    @Column(name = "daKichHoat")
    private boolean daKichHoat ;
    @Column(name = "maKichHoat")
    private String maKhichHoat ;
    @OneToMany(
            fetch = FetchType.LAZY ,
            cascade = {
                    CascadeType.DETACH ,
                    CascadeType.MERGE ,
                    CascadeType.PERSIST ,
                    CascadeType.REFRESH
            } ,
            mappedBy = "nguoiDung"
    )
    private List<SuDanhGia> suDanhGias = new ArrayList<>() ;
    @OneToMany(
            fetch = FetchType.LAZY ,
            cascade = {
                    CascadeType.DETACH ,
                    CascadeType.MERGE ,
                    CascadeType.PERSIST ,
                    CascadeType.REFRESH
            } ,
            mappedBy = "nguoiDung"
    )
    private List<SachYeuThich> sachYeuThichs = new ArrayList<>() ;
    @ManyToMany(
            fetch = FetchType.EAGER ,
            cascade = {
                    CascadeType.DETACH ,
                    CascadeType.MERGE ,
                    CascadeType.PERSIST ,
                    CascadeType.REFRESH
            }
    )
    @JoinTable(
            name = "nguoidung_quyen" ,
            joinColumns = @JoinColumn(name = "manguoidung") ,
            inverseJoinColumns = @JoinColumn(name = "maquyen")
    )
    private List<Quyen> quyens = new ArrayList<>() ;
    @OneToMany(
            fetch = FetchType.LAZY ,
            cascade = {
                    CascadeType.DETACH ,
                    CascadeType.MERGE ,
                    CascadeType.PERSIST ,
                    CascadeType.REFRESH
            } ,
            mappedBy = "nguoiDung"
    )
    private List<DonHang> donHangs = new ArrayList<>() ;
}
