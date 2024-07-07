import DAO.CustomerDAO;
import DAO.OrderDAO;
import DAO.OrderDetailDAO;
import DAO.ProductDAO;
import Entity.*;
import Service.*;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        CustomerDAO customerDAO = new CustomerDAO();
        ProductDAO productDAO = new ProductDAO();
        OrderDAO orderDAO = new OrderDAO();
        OrderDetailDAO odsDAO = new OrderDetailDAO();

        List<Product> productList = productDAO.getAll();
        List<Customer> customerList = customerDAO.getAll();
        List<Order> orderList = orderDAO.getAll();
        List<OrderDetail> orderDetailList = odsDAO.getAll();

        ShopService shopService = new ShopService();

        Thread t1,t2,t3;
        String productID,orderID;
        int quantity;

        try {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
            System.out.print("Enter order id: ");
            orderID = bufferedReader.readLine();
            if(!Validation.validateOrderID(orderID)){
                System.out.println("Wrong orderID");
                return;
            }
            Order order = shopService.checkOrderExist(orderID);
            if (order == null) {
                System.out.println("Order does not exist.");
                return;
            }

            System.out.print("Enter Product ID: ");
            productID = bufferedReader.readLine();
            if(!Validation.validateProductID(productID)){
                System.out.println("Wrong productID (ex:(MS|NE|SE)xxxx)");
                return;
            }

            System.out.print("Enter Quantity: ");
            try {
                quantity = Integer.parseInt(bufferedReader.readLine());
                if(!Validation.validateOrderDetailQuantity(quantity)){
                    System.out.println("Product quantity must > 0");
                    return;
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid quantity entered.");
                return;
            }
            OrderDetail newOrderDetail = shopService.createOrderDetail(orderID,productID,quantity);

            t1 = new Thread(new OrderThread(order, productDAO.getById(productID), newOrderDetail));
            t2 = new Thread(new ProductThread(productDAO.getById(productID), newOrderDetail));
            t3 = new Thread(new OrderDetailThread(order, productDAO.getById(productID), newOrderDetail));


            t1.start();
            t1.join();
            t2.start();
            t2.join();
            t3.start();
            t3.join();
            System.out.println("New OrderDetail created: " + newOrderDetail);
        }catch (Exception e){
            System.out.println(e.getMessage());
        }

    }
}