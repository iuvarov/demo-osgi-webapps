package org.example.service.whiteboard;

import org.example.service.database.api.ItemRepository;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class Servlet extends HttpServlet {

    private ItemRepository repository;

    @Override
    protected void doGet(HttpServletRequest request,
                         HttpServletResponse response) throws ServletException, IOException {
        var items = repository.getItems();
        var writer = response.getWriter();
        writer.append(items.toString());
    }

    public void setRepository(ItemRepository repository) {
        this.repository = repository;
        this.repository.getItems();
    }
}
