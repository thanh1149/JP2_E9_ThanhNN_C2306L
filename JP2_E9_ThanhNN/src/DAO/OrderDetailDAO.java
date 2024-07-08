package DAO;

import Connection.MySQLConnection;

import java.sql.*;

import java.util.ArrayList;
import java.util.List;

import Entity.OrderDetail;
import Entity.Product;
import Entity.Status;
import Generic.IShopManagement;

public class OrderDetailDAO implements IShopManagement<OrderDetail> {
    private Connection conn = MySQLConnection.getConnection();

    public OrderDetail add(OrderDetail orderDetail) {
        PreparedStatement pstmt = null;
        String sql = "INSERT INTO orderdetail (id,order_id,product_id,quantity,status) VALUES (?, ?, ?, ?, ?)";
        try {
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, orderDetail.getId());
            pstmt.setString(2, orderDetail.getOrder_id());
            pstmt.setString(3, orderDetail.getProduct_id());
            pstmt.setInt(4, orderDetail.getQuantity());
            pstmt.setString(5, orderDetail.getStatus().name());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return orderDetail;
    }



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
