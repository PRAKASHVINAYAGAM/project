package com.EnterpriseResourcePlanning.InventoryManagement.Service;

import com.EnterpriseResourcePlanning.InventoryManagement.Entity.Item;
import com.EnterpriseResourcePlanning.InventoryManagement.Exception.ItemNotFoundException;
import com.EnterpriseResourcePlanning.InventoryManagement.Repository.ItemRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class ItemServiceImpl implements ItemService {

    private final ItemRepository itemRepository;

    public ItemServiceImpl(ItemRepository itemRepository) {
        this.itemRepository = itemRepository;
    }

    @Override
    public Item addItem(Item item) {
        // Set the createdDate when a new item is added
        item.setCreatedDate(LocalDateTime.now());
        item.setUpdatedDate(LocalDateTime.now()); // Initially set to the same value

        return itemRepository.save(item);
    }

    @Override
    public List<Item> listItems() {
        return itemRepository.findAll();
    }

    @Override
    public Item updateItem(Long id, Item updatedItem) {
        // Find the item by ID, throw exception if not found
        Item existingItem = itemRepository.findById(id)
                .orElseThrow(() -> new ItemNotFoundException("Item with ID " + id + " not found"));

        // Update the item's fields (except ID and createdDate)
        existingItem.setName(updatedItem.getName());
        existingItem.setQuantity(updatedItem.getQuantity());
        existingItem.setPrice(updatedItem.getPrice());
        existingItem.setSku(updatedItem.getSku());
        existingItem.setUpdatedDate(LocalDateTime.now()); // Automatically update updatedDate

        return itemRepository.save(existingItem);
    }

    @Override
    public void deleteItem(Long id) {
        if (!itemRepository.existsById(id)) {
            throw new ItemNotFoundException("Item with ID " + id + " not found");
        }
        itemRepository.deleteById(id);
    }

    @Override
    public Item getItemById(Long id) {
        return itemRepository.findById(id)
                .orElseThrow(() -> new ItemNotFoundException("Item with ID " + id + " not found"));
    }
}
