package org.example.cxf.rest.impl;

import org.example.cxf.rest.api.ItemService;
import org.example.service.database.api.ItemRepository;
import org.example.service.database.dto.Item;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("items")
public class ItemServiceImpl implements ItemService {
    private ItemRepository repository;

    @Produces(MediaType.APPLICATION_JSON)
    @GET
    @Path("/all")
    @Override
    public List<Item> getAllItems() {
        return repository.getItems();
    }

    @Produces(MediaType.APPLICATION_JSON)
    @GET
    @Path("/{id}")
    @Override
    public Item getItem(@PathParam("id") long id) {
        return repository.getItem(id);
    }

    @Consumes(MediaType.APPLICATION_JSON)
    @PUT
    @Path("/")
    @Override
    public void updateItem(Item item) {
        repository.updateItem(item);
    }

    @Consumes(MediaType.APPLICATION_JSON)
    @POST
    @Path("/")
    @Override
    public void addItem(Item item) {
        repository.addItem(item);
    }

    @DELETE
    @Path("/{id}")
    @Override
    public void removeItem(@PathParam("id") long id) {
        repository.deleteItem(id);
    }

    public void setRepository(ItemRepository repository) {
        this.repository = repository;
    }
}
