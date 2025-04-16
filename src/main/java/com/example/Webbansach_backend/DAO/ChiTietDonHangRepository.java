package com.example.Webbansach_backend.DAO;

import com.example.Webbansach_backend.Entity.ChiTietDonHang;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ChiTietDonHangRepository extends JpaRepository<ChiTietDonHang ,Long > {
}
