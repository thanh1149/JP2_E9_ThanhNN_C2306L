package Service;

import Entity.OrderDetail;
import Entity.Product;

import java.util.List;

public class ProductThread extends ProductService implements Runnable {
    private List<Product> products;

    public ProductThread(Product product, OrderDetail orderDetail) {
        super(product,orderDetail);
    }

    @Override
    public Product updateQuantity() {
        super.getProduct().setQuantity(super.getProduct().getQuantity()-super.getOrderDetail().getQuantity());
        return super.getProduct();
    }

    @Override
    public void run() {
        updateQuantity();
    }
}
