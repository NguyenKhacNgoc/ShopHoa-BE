package com.example.demo.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.demo.Entity.Hoa;

public interface HoaReponsitory extends JpaRepository<Hoa, Long> {
    List<Hoa> findTop6ByOrderByGiabanDesc();

    List<Hoa> findAllByOrderByGiabanDesc();

    List<Hoa> findAllByOrderByGiabanAsc();

    List<Hoa> findByCategory(String category);

    List<Hoa> findByCategoryOrderByGiabanDesc(String category);

    List<Hoa> findByCategoryOrderByGiabanAsc(String category);

    @Query("SELECT DISTINCT hoa.category from Hoa hoa")
    List<String> findDistinctCategoryBy();
}
