package org.example.service.whiteboard;

import org.example.service.database.api.ItemRepository;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class ItemServlet extends HttpServlet {

    private ItemRepository repository;

    @Override
    protected void doGet(HttpServletRequest request,
                         HttpServletResponse response) throws ServletException, IOException {
        long id = Long.parseLong(request.getParameter("id"));
        var item = repository.getItem(id);
        var writer = response.getWriter();
        writer.append(item.toString());
    }

    public void setRepository(ItemRepository repository) {
        this.repository = repository;
        this.repository.getItems();
    }
}
