package com.example.Webbansach_backend.DAO;

import com.example.Webbansach_backend.Entity.Quyen;
import com.example.Webbansach_backend.Entity.Sach;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SachRepository extends JpaRepository<Sach, Integer> {
}
