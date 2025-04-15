package com.example.Webbansach_backend.Entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;
@Data
@Table(name = "quyen")
@Entity
public class Quyen {
    @Id
    @Column(name = "maquyen")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int maQuyen ;
    @Column(name = "tenquyen")
    private String tenQuyen ;
    @ManyToMany(mappedBy = "quyens",
            fetch = FetchType.LAZY ,
            cascade = {
                    CascadeType.DETACH ,
                    CascadeType.MERGE ,
                    CascadeType.MERGE ,
                    CascadeType.REFRESH
            }
    )
    private List<NguoiDung> nguoiDungs ;
}
