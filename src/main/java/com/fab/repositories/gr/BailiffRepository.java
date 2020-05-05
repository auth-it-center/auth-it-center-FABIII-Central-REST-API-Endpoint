package com.fab.repositories.gr;

import java.util.List;

import com.fab.models.gr.BailiffEntity;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository("bailiffRepository")
public interface BailiffRepository extends JpaRepository<BailiffEntity, Long> {
     List<BailiffEntity> findByPostalCode(String postalCode);
}