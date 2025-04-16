package com.example.Webbansach_backend.DAO;

import com.example.Webbansach_backend.Entity.Quyen;
import com.example.Webbansach_backend.Entity.Sach;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

@RepositoryRestResource(path = "sach")
public interface SachRepository extends JpaRepository<Sach, Integer> {
}
