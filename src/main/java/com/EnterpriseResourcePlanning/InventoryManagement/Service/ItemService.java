package com.EnterpriseResourcePlanning.InventoryManagement.Service;

import com.EnterpriseResourcePlanning.InventoryManagement.Entity.Item;
import org.springframework.stereotype.Service;
import java.util.List;

public interface ItemService {
    Item addItem(Item item);
    List<Item> listItems();
    Item updateItem(Long id, Item item);
    void deleteItem(Long id);
    Item getItemById(Long id);
}

