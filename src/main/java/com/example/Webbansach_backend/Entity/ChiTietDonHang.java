package com.example.Webbansach_backend.Entity;

import jakarta.persistence.*;
import lombok.Data;
import org.springframework.context.annotation.DependsOn;
import org.springframework.context.annotation.Primary;

@Data
@Entity
@Table(name = "chitietdonhang")
public class ChiTietDonHang {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "chitietdonhang")
    private long chiTietDonHang ;
    @Column(name = "soluong")
    private int soLuong ;
    @Column(name = "giaban")
    private double giaBan ;
    @ManyToOne(
            cascade = {
                    CascadeType.DETACH ,
                    CascadeType.MERGE ,
                    CascadeType.PERSIST ,
                    CascadeType.REFRESH
            }
    )
    @JoinColumn(name = "masach" ,nullable = false)
    private Sach sach ;
    @ManyToOne(
            cascade = {
                    CascadeType.DETACH ,
                    CascadeType.MERGE ,
                    CascadeType.PERSIST ,
                    CascadeType.REFRESH
            }
    )
    @JoinColumn(name = "madonhang" ,nullable = false)
    private DonHang donhang ;

}
