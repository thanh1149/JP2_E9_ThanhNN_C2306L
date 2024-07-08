package Service;

import DAO.ProductDAO;
import Entity.OrderDetail;
import Entity.Product;

import java.util.List;

public class ProductThread extends ProductService implements Runnable {
    private List<Product> products;
    private ProductDAO productDAO;

    public ProductThread(Product product, OrderDetail orderDetail,ProductDAO productDAO) {
        super(product,orderDetail);
        this.productDAO = productDAO;
    }

    @Override
    public Product updateQuantity() {
        super.getProduct().setQuantity(super.getProduct().getQuantity()-super.getOrderDetail().getQuantity());
        productDAO.add(super.getProduct());
        return super.getProduct();

    }

    @Override
    public void run() {
        updateQuantity();
    }
}
