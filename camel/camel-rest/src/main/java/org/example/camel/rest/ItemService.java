package org.example.camel.rest;

import org.example.service.database.api.ItemRepository;
import org.example.service.database.dto.Item;

import java.util.List;

public class ItemService {
    private ItemRepository repository;

    public List<Item> getAllItems() {
        return repository.getItems();
    }

    public Item getItem(long id) {
        return repository.getItem(id);
    }

    public void updateItem(Item item) {
        repository.updateItem(item);
    }

    public void addItem(Item item) {
        repository.addItem(item);
    }

    public void removeItem(long id) {
        repository.deleteItem(id);
    }

    public void setRepository(ItemRepository repository) {
        this.repository = repository;
    }
}
