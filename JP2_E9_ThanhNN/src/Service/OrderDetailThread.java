package Service;

import Entity.Order;
import Entity.OrderDetail;
import Entity.Product;
import Entity.Status;

import java.util.List;
import java.util.stream.Collectors;

public class OrderDetailThread extends OrderDetailService implements Runnable{

    public OrderDetailThread(Order order, Product product, OrderDetail orderDetail) {
        super(order, product, orderDetail);
    }

    @Override
    public OrderDetail addOrderDetail() {
        super.getOrderDetail().setId(orderDetails.size() + 1);
        super.getOrderDetail().setOrder_id(super.getOrder().getId());
        super.getOrderDetail().setProduct_id(super.getProduct().getId());
        super.getOrderDetail().setQuantity(super.getOrderDetail().getQuantity());
        super.getOrderDetail().setStatus(super.getOrderDetail().getStatus());
        orderDetails.add(super.getOrderDetail());
        return super.getOrderDetail();
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
        addOrderDetail();
        updateStatus();
    }
}