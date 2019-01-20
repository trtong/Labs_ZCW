package com.example.demo.repository;

import com.example.demo.Steak;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SteakRepository extends JpaRepository<Steak, Long> {
    // Type steak, ID is Long type

    List<Steak> findAllById(Long id);
}
