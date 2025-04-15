package com.example.Webbansach_backend.Entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Table(name = "sachyeuthich")
@Entity
public class SachYeuThich {
    @Id
    @Column(name = "masachyeuthich")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int maSachYeuThich ;
    @ManyToOne(
            cascade = {
                    CascadeType.DETACH ,
                    CascadeType.MERGE ,
                    CascadeType.PERSIST ,
                    CascadeType.REFRESH
            }
    )
    @JoinColumn(name = "manguoidung", nullable = false)
    private NguoiDung nguoiDung ;
    @ManyToOne(
            cascade = {
                    CascadeType.DETACH ,
                    CascadeType.MERGE ,
                    CascadeType.PERSIST ,
                    CascadeType.REFRESH
            }
    )
    @JoinColumn(name = "masach", nullable = false)
    private Sach sach ;

}
