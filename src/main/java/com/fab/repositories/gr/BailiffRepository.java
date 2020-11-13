package com.fab.repositories.gr;

import java.util.List;


import com.fab.entities.gr.BailiffGREntity;
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
public interface BailiffRepository extends JpaRepository<BailiffGREntity, Long> {

     List<BailiffGREntity> findByPostalCode(String postalCode);


}