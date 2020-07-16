package org.example.service.database.api;

import org.example.service.database.dto.Item;

import java.util.List;

public interface ItemRepository {
    void addItem(Item item);

    Item getItem(long id);

    List<Item> getItems();

    void updateItem(Item item);

    void deleteItem(long id);
}
