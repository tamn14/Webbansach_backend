package com.example.Webbansach_backend.DAO;

import com.example.Webbansach_backend.Entity.HinhThucGiaoHang;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HinhThucGiaoHangRepository extends JpaRepository<HinhThucGiaoHang , Integer> {
}
