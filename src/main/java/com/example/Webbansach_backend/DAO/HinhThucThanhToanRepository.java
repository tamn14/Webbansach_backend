package com.example.Webbansach_backend.DAO;

import com.example.Webbansach_backend.Entity.HinhThucThanhToan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HinhThucThanhToanRepository extends JpaRepository<HinhThucThanhToan , Integer> {
}
