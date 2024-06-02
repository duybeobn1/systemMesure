package org.sample.park.repository;

import org.sample.park.model.CommandResult;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CommandResultRepository extends JpaRepository<CommandResult, Long> {
}
