package com.example.Webbansach_backend.DAO;

import com.example.Webbansach_backend.Entity.HinhThucThanhToan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

@RepositoryRestResource(path = "thanhtoan")
public interface HinhThucThanhToanRepository extends JpaRepository<HinhThucThanhToan , Integer> {
}
