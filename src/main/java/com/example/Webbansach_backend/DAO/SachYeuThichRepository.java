package com.example.Webbansach_backend.DAO;

import com.example.Webbansach_backend.Entity.Sach;
import com.example.Webbansach_backend.Entity.SachYeuThich;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

@RepositoryRestResource(path = "sachyeuthich")
public interface SachYeuThichRepository extends JpaRepository<SachYeuThich, Integer> {
}
