package DAO;

import Connection.MySQLConnection;
import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Entity.OrderDetail;
import Entity.Product;
import Entity.Status;
import Generic.IShopManagement;

public class OrderDetailDAO implements IShopManagement {
    private Connection conn = MySQLConnection.getConnection();

    @Override
    public List<OrderDetail> getAll() {
        PreparedStatement pstmt = null;
        List<OrderDetail> ods = new ArrayList<>();
        String sql = "SELECT * FROM orderdetail";
        try{
            pstmt = conn.prepareStatement(sql);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()){
               OrderDetail od = new OrderDetail();
               od.setId(rs.getInt("id"));
               od.setOrder_id(rs.getString("order_id"));
               od.setProduct_id(rs.getString("product_id"));
               od.setQuantity(rs.getInt("quantity"));
               od.setStatus(Status.valueOf(rs.getString("status")));
               ods.add(od);
            }
        }catch (SQLException e){
            System.out.println(e.getMessage());
        }
        return ods;
    }
}
