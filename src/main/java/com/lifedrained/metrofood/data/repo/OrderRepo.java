package com.lifedrained.metrofood.data.repo;

import com.lifedrained.metrofood.data.repo.entity.Order;
import jakarta.persistence.Table;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
@Table(name = "orders", schema = "app")
public interface OrderRepo extends JpaRepository<Order, Long> {

}
