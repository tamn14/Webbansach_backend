package com.example.Webbansach_backend.Entity;

import jakarta.persistence.*;
import lombok.Data;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
@Data
@Entity
@Table(name = "donhang")
public class DonHang {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "madonhang" )
    private int maDonHang ;
    @Column(name = "ngaytao")
    private Date ngayTao ;
    @Column(name = "diachimuahang")
    private String diaChiMuaHang ;
    @Column(name = "diachinhanhang")
    private String diaChiNhanHang ;
    @Column(name = "tongtiensanpham")
    private double tongTienSanPham;
    @Column(name = "chiphigiaohang")
    private double chiPhiGiaoHang;
    @Column(name = "chiphithanhtoan")
    private double chiPhiThanhToan;

    @OneToMany(
            fetch = FetchType.LAZY ,
            cascade = CascadeType.ALL ,
            mappedBy = "donhang"
    )
    private List<ChiTietDonHang> chiTietDonHangs = new ArrayList<>() ;

    @ManyToOne(
            cascade = {
                    CascadeType.DETACH ,
                    CascadeType.MERGE ,
                    CascadeType.PERSIST ,
                    CascadeType.REFRESH
            }
    )
    @JoinColumn(name = "manguoidung" , nullable = false)
    private NguoiDung nguoiDung ;

    @ManyToOne(
            cascade = {
                    CascadeType.DETACH ,
                    CascadeType.MERGE ,
                    CascadeType.PERSIST ,
                    CascadeType.REFRESH
            }
    )
    @JoinColumn(name = "mathanhtoan" , nullable = true)
    private HinhThucThanhToan hinhThucThanhToan ;
    @ManyToOne(
            cascade = {
                    CascadeType.DETACH ,
                    CascadeType.MERGE ,
                    CascadeType.PERSIST ,
                    CascadeType.REFRESH
            }
    )
    @JoinColumn(name = "magiaohang" , nullable = true)
    private HinhThucGiaoHang hinhThucGiaoHang ;
}
