package com.example.Webbansach_backend.DAO;

import com.example.Webbansach_backend.Entity.HinhAnh;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HinhAnhRepository extends JpaRepository<HinhAnh , Integer> {
}
