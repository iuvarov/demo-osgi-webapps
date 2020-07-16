package org.example.cxf.rest.api;

import org.example.service.database.dto.Item;

import java.util.List;


public interface ItemService {

    public List<Item> getAllItems();

    public Item getItem(long id);

    public void updateItem(Item item);

    public void addItem(Item item);

    public void removeItem(long id);
}
