package org.example.service.database.impl;

import org.apache.ibatis.mapping.Environment;
import org.apache.ibatis.session.Configuration;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.ibatis.transaction.jdbc.JdbcTransactionFactory;
import org.example.service.database.api.ItemRepository;
import org.example.service.database.dto.Item;
import org.example.service.database.impl.mapper.ItemMapper;

import javax.sql.DataSource;
import java.util.List;

public class ItemRepositoryImpl implements ItemRepository {
    private final SqlSessionFactory sqlSessionFactory;

    public ItemRepositoryImpl(DataSource dataSource){
        var environment = new Environment("id", new JdbcTransactionFactory(), dataSource);
        var configuration = new Configuration(environment);
        configuration.addMapper(ItemMapper.class);
        sqlSessionFactory = new SqlSessionFactoryBuilder().build(configuration);
    }

    @Override
    public void addItem(Item item) {
        try(var session = sqlSessionFactory.openSession()){
            session.getMapper(ItemMapper.class).addItem(item);
            session.commit();
        }
    }

    @Override
    public Item getItem(long id) {
        Item item;
        try(var session = sqlSessionFactory.openSession()){
            var mapper = session.getMapper(ItemMapper.class);
            item = mapper.getItem(id);
        }
        return item;
    }

    @Override
    public List<Item> getItems() {
        List<Item> items;
        try(var session = sqlSessionFactory.openSession()){
            items = session.getMapper(ItemMapper.class).getItems();
        }
        return items;
    }

    @Override
    public void updateItem(Item item) {
        try(var session = sqlSessionFactory.openSession()){
            session.getMapper(ItemMapper.class).updateItem(item);
            session.commit();
        }
    }

    @Override
    public void deleteItem(long id) {
        try(var session = sqlSessionFactory.openSession()){
            session.getMapper(ItemMapper.class).deleteItem(id);
            session.commit();
        }
    }
}
