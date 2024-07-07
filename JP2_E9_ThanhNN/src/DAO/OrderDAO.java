package DAO;

import Connection.MySQLConnection;
import java.sql.Connection;

import Entity.Date;
import Entity.Order;
import Entity.Product;
import Generic.IShopManagement;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class OrderDAO implements IShopManagement {
    private Connection conn = MySQLConnection.getConnection();

    @Override
    public List<Order> getAll() {
        PreparedStatement pstmt = null;
        List<Order> orders = new ArrayList<>();
        String sql = "SELECT * FROM `order`";
        try{
            pstmt = conn.prepareStatement(sql);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()){
                Order order = new Order();
                order.setId(rs.getString("id"));
                order.setCus_id(rs.getInt("cus_id"));
                order.setDateTime(Date.formatDateTime(rs.getString("datetime")));
                orders.add(order);
            }
        }catch (SQLException e){
            System.out.println(e.getMessage());
        }
        return orders;
    }
}
