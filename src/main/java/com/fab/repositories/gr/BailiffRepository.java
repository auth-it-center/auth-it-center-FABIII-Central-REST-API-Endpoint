package com.fab.repositories.gr;

import com.fab.models.gr.BailiffEntity;
// import com.fab.models.gr.BailiffResponse;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository("bailiffRepository")
public interface BailiffRepository extends JpaRepository<BailiffEntity, Long> {
    //  BailiffEntity findByPostalCode(String postalCode);
}