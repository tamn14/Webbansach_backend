package com.example.Webbansach_backend.DAO;

import com.example.Webbansach_backend.Entity.Quyen;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

@RepositoryRestResource(path = "quyen")
public interface QuyenRepository extends JpaRepository<Quyen , Integer> {
    public Quyen findByTenQuyen(String tenQuyen);
}
