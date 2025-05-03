package com.example.Webbansach_backend.Entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "hinhanh")
public class HinhAnh {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "mahinhanh")
    private int maHinhAnh ;
    @Column(name = "tenhinhanh", length = 255)
    private String tenHinhAnh ;
    @Column(name = "laicon")
    private boolean laIcon ;
    @Column(name = "duongdan")
    private String duongDan  ;
    @Column(name = "dulieuanh" , columnDefinition = "LONGTEXT")
    @Lob
    private String duLieuAnh;
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

}
