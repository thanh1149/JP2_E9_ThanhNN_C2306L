package DAO;

import Connection.MySQLConnection;
import java.sql.Connection;

import Entity.Product;
import Generic.IShopManagement;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProductDAO implements IShopManagement {
    private Connection conn = MySQLConnection.getConnection();

    public Product getById(String id) {
       PreparedStatement pstmt = null;
        Product product = new Product();
        String sql = "SELECT * FROM product WHERE id = ?";
        try {
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, id);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()){
                product.setId(rs.getString("id"));
                product.setName(rs.getString("name"));
                product.setQuantity(rs.getInt("quantity"));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return product;
    }

    @Override
    public List<Product> getAll() {
        PreparedStatement pstmt = null;
        List<Product> products = new ArrayList<>();
        String sql = "SELECT * FROM product";
        try{
            pstmt = conn.prepareStatement(sql);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()){
                Product product = new Product();
                product.setId(rs.getString("id"));
                product.setName(rs.getString("name"));
                product.setQuantity(rs.getInt("quantity"));
                products.add(product);
            }
        }catch (SQLException e){
            System.out.println(e.getMessage());
        }
        return products;
    }
}
