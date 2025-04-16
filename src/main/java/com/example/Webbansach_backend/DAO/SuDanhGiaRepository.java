package com.example.Webbansach_backend.DAO;

import com.example.Webbansach_backend.Entity.Sach;
import com.example.Webbansach_backend.Entity.SuDanhGia;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

@RepositoryRestResource(path = "danhgia")
public interface SuDanhGiaRepository extends JpaRepository<SuDanhGia, Integer> {
}
