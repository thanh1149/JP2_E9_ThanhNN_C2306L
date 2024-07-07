package DAO;

import Connection.MySQLConnection;
import Entity.Customer;
import Generic.IShopManagement;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CustomerDAO implements IShopManagement {
    private Connection conn = MySQLConnection.getConnection();

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
