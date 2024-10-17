package com.EnterpriseResourcePlanning.InventoryManagement.Repository;

import com.EnterpriseResourcePlanning.InventoryManagement.Entity.Item;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ItemRepository extends JpaRepository<Item, Long> {
}
