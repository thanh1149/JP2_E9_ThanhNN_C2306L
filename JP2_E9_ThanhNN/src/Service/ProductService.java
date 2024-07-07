package Service;

import Entity.OrderDetail;
import Entity.Product;

import java.util.List;

public abstract class ProductService {
    private Product product;
    private OrderDetail orderDetail;
    private List<Product> productList;

    public ProductService(Product product, OrderDetail orderDetail) {
        this.product = product;
        this.orderDetail = orderDetail;
    }

    public abstract Product updateQuantity();

    public Product getProduct() {
        return product;
    }

    public Product findById(String id){
        return productList.stream()
                .filter(p->p.getId().equals(id))
                .findFirst().orElse(null);
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public OrderDetail getOrderDetail() {
        return orderDetail;
    }

    public void setOrderDetail(OrderDetail orderDetail) {
        this.orderDetail = orderDetail;
    }
}
