package com.fab.repositories.gr;

import java.util.List;

import com.fab.models.gr.BailiffEntity;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Bailiff repository interface,
 * with methods supporting reading,
 * updating, deleting, and
 * creating records against a back end data store.
 *
 * TODO: support paging, and sorting
 *
 */
@Repository("bailiffRepository")
public interface BailiffRepository extends JpaRepository<BailiffEntity, Long> {

     List<BailiffEntity> findByPostalCode(String postalCode);


}