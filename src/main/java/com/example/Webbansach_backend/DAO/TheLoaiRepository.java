package com.example.Webbansach_backend.DAO;

import com.example.Webbansach_backend.Entity.SuDanhGia;
import com.example.Webbansach_backend.Entity.TheLoai;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

@RepositoryRestResource(path = "theloai")
public interface TheLoaiRepository extends JpaRepository<TheLoai, Integer> {
}
