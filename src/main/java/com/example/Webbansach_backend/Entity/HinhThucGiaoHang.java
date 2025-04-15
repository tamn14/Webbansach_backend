package com.example.Webbansach_backend.Entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;
@Data
@Entity
@Table(name = "hinhthucgiaohang")
public class HinhThucGiaoHang {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "magiaohang")
    private int maGiaoHang ;
    @Column(name = "tenhinhthucgiaohang")
    private String tenHinhThucGiaoHang ;
    @Column(name = "mota" , columnDefinition = "text")
    private String moTa ;
    @Column(name = "chiphigiaohang")
    private double chiPhiGiaoHang ;
    @OneToMany(
            fetch = FetchType.LAZY ,
            cascade = CascadeType.ALL ,
            mappedBy = "hinhThucGiaoHang"
    )
    private List<DonHang> donHangs = new ArrayList<>() ;
}
