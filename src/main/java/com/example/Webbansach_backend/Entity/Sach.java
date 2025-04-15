package com.example.Webbansach_backend.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor @AllArgsConstructor
@Entity
@Table(name = "sach")
public class Sach {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "masach")
    private int maSach ;
    @Column(name = "tensach" , length = 256)
    private String tenSach  ;
    @Column(name = "tentacgia", length = 512)
    private String tenTacGia ;
    @Column(name = "isbn" , length = 256)
    private String ISBN  ;
    @Column(name = "mota", columnDefinition = "text")
    private String moTa ;
    @Column(name = "gianiemyet")
    private double giaNiemYet ;
    @Column(name = "giaban")
    private double giaBan ;
    @Column(name = "soluong")
    private int soLuong;
    @Column(name = "trungbinhxephang")
    private double trungBinhXepHang ;
    @ManyToMany(
            fetch = FetchType.LAZY ,
            cascade = {
                    CascadeType.DETACH ,
                    CascadeType.MERGE ,
                    CascadeType.PERSIST ,
                    CascadeType.REFRESH
            }
    )
    @JoinTable(
            name = "sach_theloai" ,
            joinColumns = @JoinColumn(name = "masach") ,
            inverseJoinColumns = @JoinColumn(name = "matheloai")
    )
    private List<TheLoai> theLoais = new ArrayList<>() ;
    @OneToMany(
            fetch = FetchType.LAZY ,
            cascade = CascadeType.ALL ,
            mappedBy = "sach"
    )
    private List<HinhAnh> hinhAnhs = new ArrayList<>() ;
    @OneToMany(
            fetch = FetchType.LAZY ,
            cascade = CascadeType.ALL ,
            mappedBy = "sach"
    )
    private List<SuDanhGia> suDanhGias = new ArrayList<>() ;
    @OneToMany(
            fetch = FetchType.LAZY ,
            cascade = {
                    CascadeType.DETACH ,
                    CascadeType.MERGE ,
                    CascadeType.PERSIST ,
                    CascadeType.REFRESH
            },
            mappedBy = "sach"
    )
    private List<ChiTietDonHang> chiTietDonHangs = new ArrayList<>();
    @OneToMany(
            fetch = FetchType.LAZY ,
            cascade = CascadeType.ALL ,
            mappedBy = "sach"
    )
    private List<SachYeuThich> sachYeuThiches = new ArrayList<>() ;






}
