package com.lifedrained.metrofood.data.repo;

import com.lifedrained.metrofood.data.repo.entity.Position;
import jakarta.persistence.Table;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
@Table(name = "positions")
public interface PositionRepo extends JpaRepository<Position,Long> {

}
