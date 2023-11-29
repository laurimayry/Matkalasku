package com.example.matkalasku.domain;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;



public interface LaskuRepository extends CrudRepository<Lasku, Long> {

    Optional<Lasku> findById(Long id);

	void deleteById(Long id);
    
}