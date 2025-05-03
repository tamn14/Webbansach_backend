package com.example.Webbansach_backend.DAO;

import com.example.Webbansach_backend.Entity.Sach;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.RequestParam;

@RepositoryRestResource(path = "sach")
public interface SachRepository extends JpaRepository<Sach, Integer> {
    Page<Sach> findByTenSachContaining(@RequestParam("tensach") String tensach, Pageable pageable);
    Page<Sach> findByTheLoais_MaTheLoai(@RequestParam("maTheLoai") int maTheLoai, Pageable pageable);

    Page<Sach> findByTenSachContainingAndTheLoais_MaTheLoai( @RequestParam("tensach") String tensach ,@RequestParam("maTheLoai") int maTheLoai, Pageable pageable);
}
