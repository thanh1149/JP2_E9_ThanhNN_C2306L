package Service;

import DAO.OrderDetailDAO;
import Entity.Order;
import Entity.OrderDetail;
import Entity.Product;
import Entity.Status;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class UpdataStatusThread extends OrderDetailService implements Runnable {
    private List<OrderDetail> orderDetails;
    private OrderDetailDAO orderDetailDAO;

    public UpdataStatusThread(Order order, Product product, OrderDetail orderDetail, OrderDetailDAO orderDetailDAO) {
        super(order, product, orderDetail);
        this.orderDetails = new ArrayList<>();
        this.orderDetailDAO = orderDetailDAO;
    }
    @Override
    public OrderDetail addOrderDetail() {
        return null;
    }

    @Override
    public List<OrderDetail> updateStatus() {
        List<OrderDetail> updateOrderDetail = orderDetails.stream()
                .filter(orderDetail -> "PENDING".equals(orderDetail.getStatus()))
                .collect(Collectors.toList());

        updateOrderDetail.forEach(orderDetail -> orderDetail.setStatus(Status.COMPLETE));

        return updateOrderDetail;
    }

    @Override
    public void run() {
        updateStatus();
    }
}
