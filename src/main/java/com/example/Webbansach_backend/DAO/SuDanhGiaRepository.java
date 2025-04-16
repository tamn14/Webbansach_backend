package com.example.Webbansach_backend.DAO;

import com.example.Webbansach_backend.Entity.Sach;
import com.example.Webbansach_backend.Entity.SuDanhGia;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SuDanhGiaRepository extends JpaRepository<SuDanhGia, Integer> {
}
