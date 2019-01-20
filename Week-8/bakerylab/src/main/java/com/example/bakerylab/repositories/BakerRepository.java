package com.example.bakerylab.repositories;

import com.example.bakerylab.models.Baker;
import org.springframework.data.repository.CrudRepository;

public interface BakerRepository extends CrudRepository<Baker, Long> {
}
