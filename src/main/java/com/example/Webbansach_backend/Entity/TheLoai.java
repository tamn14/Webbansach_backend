package com.example.Webbansach_backend.Entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;
@Data
@Entity
@Table(name = "theloai")
public class TheLoai {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "matheloai")
    private int maTheLoai ;
    @Column(name = "tentheloai" , length = 256)
    private String tenTheLoai;
    @ManyToMany(mappedBy = "theLoais",
                fetch = FetchType.LAZY ,
                cascade = {
                        CascadeType.DETACH ,
                        CascadeType.MERGE ,
                        CascadeType.MERGE ,
                        CascadeType.REFRESH
                }
    )
    private List<Sach> sachs = new ArrayList<>() ;

}
