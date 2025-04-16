package com.example.Webbansach_backend.DAO;

import com.example.Webbansach_backend.Entity.DonHang;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DonHangRepository extends JpaRepository<DonHang, Integer> {
}
