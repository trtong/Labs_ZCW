package io.zipcoder.tc_spring_poll_application.repositories;

import io.zipcoder.tc_spring_poll_application.domain.Option;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface OptionRepository extends CrudRepository<Option, Long> {
    @Query(value =
            "SELECT * " +
            "FROM Option", nativeQuery = true)
    public Iterable<Option> getAllOptions();
}
