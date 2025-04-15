package com.example.Webbansach_backend.Entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "sudanhgia")
public class SuDanhGia {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "madanhgia")
    private long maDanhGia ;
    @Column(name = "diemxephang")
    private float diemXepHang ;
    @Column(name = "nhanxet")
    private String nhanXet ;
    @ManyToOne(
            cascade = {
                    CascadeType.DETACH ,
                    CascadeType.MERGE ,
                    CascadeType.PERSIST ,
                    CascadeType.REFRESH
            }
    )
    @JoinColumn(name = "masach" , nullable = false)
    private Sach sach ;
    @ManyToOne(
            cascade = {
                    CascadeType.DETACH ,
                    CascadeType.MERGE ,
                    CascadeType.PERSIST ,
                    CascadeType.REFRESH
            }
    )
    @JoinColumn(name = "manguoidung")
    private NguoiDung nguoiDung ;
}
