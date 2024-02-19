package com.payproject.domain.order.repositories;

import com.payproject.domain.order.entities.ItemEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemRepository extends JpaRepository<ItemEntity, Long>
{
}
