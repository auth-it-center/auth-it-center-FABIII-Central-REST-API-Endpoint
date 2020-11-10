package com.fab.repositories;

import com.fab.models.BailiffEntity2;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;



/**
 * Bailiff repository interface,
 * with methods supporting reading,
 * updating, deleting, and
 * creating records against a back end data store.
 *
 * TODO: support paging, and sorting
 *
 */
@Repository("bailiffRepository2")
public interface BailiffRepository2 extends JpaRepository<BailiffEntity2, Long> {

    List<BailiffEntity2> findByPostalCode(String postalCode);


}