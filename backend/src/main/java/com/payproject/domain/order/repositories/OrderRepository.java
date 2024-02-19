package com.payproject.domain.order.repositories;

import com.payproject.domain.order.entities.OrderEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<OrderEntity, Long>
{
}
