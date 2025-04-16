package com.example.Webbansach_backend.DAO;

import com.example.Webbansach_backend.Entity.NguoiDung;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

@RepositoryRestResource(path = "nguoidung")
public interface NguoiDungRepository extends JpaRepository<NguoiDung , Integer> {
}
