package com.example.Webbansach_backend.Entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;
@Data
@Table(name = "hinhthucthanhtoan")
@Entity
public class HinhThucThanhToan {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "mathanhtoan")
    private int maThanhToan ;
    @Column(name = "tenhinhthucthanhtoan")
    private String tenHinhThucThanhToan ;
    @Column(name = "mota" , columnDefinition = "text")
    private String moTa ;
    @Column(name = "chiphithanhtoan")
    private double chiPhiThanhToan ;
    @OneToMany(
            fetch = FetchType.LAZY ,
            cascade = CascadeType.ALL ,
            mappedBy = "hinhThucThanhToan"
    )
    private List<DonHang> donHangs = new ArrayList<>() ;

}
