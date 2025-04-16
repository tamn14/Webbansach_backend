package com.example.Webbansach_backend.DAO;

import com.example.Webbansach_backend.Entity.NguoiDung;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NguoiDungRepository extends JpaRepository<NguoiDung , Integer> {
}
