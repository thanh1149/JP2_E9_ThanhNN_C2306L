package DAO;

import Connection.MySQLConnection;
import Entity.Customer;
import Entity.Date;
import Entity.Order;
import Generic.IShopManagement;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CustomerDAO implements IShopManagement<Customer> {
    private Connection conn = MySQLConnection.getConnection();

    public Customer getById(int id) {
        PreparedStatement pstmt = null;
        Customer customer = new Customer();
        String sql = "SELECT * FROM customer WHERE id = ?";
        try{
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1,id);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                customer.setId(rs.getInt("id"));
                customer.setName(rs.getString("name"));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return customer;
    }


    @Override
    public List<Customer> getAll() {
        PreparedStatement pstmt = null;
        List<Customer> customers = new ArrayList<>();
        String sql = "SELECT * FROM customer";
        try{
            pstmt = conn.prepareStatement(sql);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                Customer customer = new Customer();
                customer.setId(rs.getInt("id"));
                customer.setName(rs.getString("name"));
                customers.add(customer);
            }
        }catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return customers;
    }
}
