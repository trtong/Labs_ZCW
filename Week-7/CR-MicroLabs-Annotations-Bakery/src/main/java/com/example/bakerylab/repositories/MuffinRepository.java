package com.example.bakerylab.repositories;

import com.example.bakerylab.models.Muffin;
import org.springframework.data.repository.CrudRepository;

public interface MuffinRepository extends CrudRepository<Muffin, Long> {
}
