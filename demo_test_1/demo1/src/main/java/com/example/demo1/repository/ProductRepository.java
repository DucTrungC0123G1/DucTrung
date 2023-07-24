package com.example.demo1.repository;

import com.example.demo1.model.Product;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProductRepository implements IProductRepository{
    public static final String SELECT_ALL_PRODUCT = " select * from product; ";
    @Override
    public List<Product> getAll() {
        Connection connection = BaseRepository.getConnection();
        List<Product> productList = new ArrayList<>();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_PRODUCT);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
            int id = resultSet.getInt("id");
            String name = resultSet.getString("name");
            Date nsx = resultSet.getDate("nsx");
            boolean typeProduct = resultSet.getBoolean("type_product");
            String description = resultSet.getString("description");
            productList.add(new Product(id,name,nsx,typeProduct,description));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return productList;
    }
}
